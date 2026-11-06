package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * È uma lista feita para ambientes com varias threads
 * permitindo que varias threads leiam a lista  enquanto outras a modificam de forma segura, quando uma
 * thread modifica algo da lista, o Java cria uma nova copia e aplica a alteracao nessa copia.
 * "TODO" as Threads que estao lendo a versao anterior nao sao interrompidas por essa modificacao
 * e usada quando a muita leitura
 *         // [1] -> array original
 *         // [1,2] -> adiciono o numero 2 e foi criado um novo array com ele
 *         // [1,2,3] -> coloco 3 e crio um novo array
 *         // [1,2] -> se voce remove um tambem cria uma nova lista
 **/
public class CopyOnWriteArrayListTest1 {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 2000; i++) {
            list.add(i);
        }
        Runnable runnableIterator = () -> {
            Iterator<Integer> iterator = list.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println); // imprime os valores (2000) dentro desse iterator
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable runnableRemover = () -> {
            for (int i = 0; i < 500; i++) {
                System.out.printf("%s removed %d %n", Thread.currentThread().getName(), i);
                list.remove(i);
            }
        };

        new Thread(runnableIterator).start();
        new Thread(runnableRemover).start();
    }
}
