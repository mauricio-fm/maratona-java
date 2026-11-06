package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable { // Runnable Representa uma operação que não retorna um resultado
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            if (lock.isHeldByCurrentThread()) { // Verifica se este bloqueio está mantido pela thread atual
                System.out.printf("Thread %s entrou em uma sessão critica %n", name);
                // printf serve para imprimir textos formatados, permitindo inserir variáveis em posições
                // específicas e controlar como os valores aparecem
            }
            System.out.printf("%d Threads esperando na fila %n", lock.getQueueLength()); // mostra o numero de threads
            // que estao em espera
            System.out.printf("Thread %s vai esperar 2s %n", name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera %n", name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) { // Verifica se este bloqueio está mantido pela thread atual
            lock.unlock();
            }
        }
    }
}

public class ReentrantLockTest1 { // ReentrantLock é uma ferramenta do Java utilizada para controlar o acesso
    // de múltiplas threads a um recurso compartilhado
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();
    }
}

/**
 * Especificador	    Tipo
 * %s	                Texto (String)
 * %d	                Número inteiro (int, long)
 * %f	                Número decimal (float, double)
 * %n	                Quebra de linha
 * %.2f             	Decimal com 2 casas após a vírgula
 */
