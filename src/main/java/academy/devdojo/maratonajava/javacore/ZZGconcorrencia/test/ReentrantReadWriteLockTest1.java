package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite {
    private final Map<String, String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock rwl;

    MapReadWrite(ReentrantReadWriteLock rwl) {
        this.rwl = rwl;
    }

    public void put(String key, String value) {
        rwl.writeLock().lock(); // obtem o lock de escrita
        try {
            if (rwl.isWriteLocked()) {
                System.out.printf("%s Obteve o WRITE lock %n", Thread.currentThread().getName());
            }
            map.put(key, value);
            Thread.sleep(500); // pausa o thread por um tempo determinado mas NAO libera a thread
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rwl.writeLock().unlock(); // voce sempre tem que liberar o lock, de leitura,escrita etc
        }

    }

    public Set<String> allKeys() {
        rwl.readLock().lock(); // voce pode ter mais de de uma thread obtendo o lock de leitura
        // mas para o lock de escrita e so uma thread
        try {
            return map.keySet();
        } finally {
            rwl.readLock().unlock();
        }

    }

}

public class ReentrantReadWriteLockTest1 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        MapReadWrite mapReadWrite = new MapReadWrite(rwl);

        Runnable writer = () -> {
            for (int i = 0; i < 20; i++) {
                mapReadWrite.put(String.valueOf(i), String.valueOf(i)); // adiciona o valor "i" convertendo para String
            }
        };

        Runnable reader = () -> {
            if (rwl.isWriteLocked()) {
                System.out.println("WRITE LOCKED!");
            }
            rwl.readLock().lock();
            System.out.println("FINNALY I GOT  THE DAMN LOCK");
            try {
                System.out.println(Thread.currentThread().getName() + " " + mapReadWrite.allKeys());
            } finally {
//                rwl.readLock().unlock();
            }
        };

        Thread threadWriter = new Thread(writer);
        Thread threadReader1 = new Thread(reader);
        Thread threadReader2 = new Thread(reader);
        threadWriter.start();
        threadReader1.start();
        threadReader2.start();
    }
}
