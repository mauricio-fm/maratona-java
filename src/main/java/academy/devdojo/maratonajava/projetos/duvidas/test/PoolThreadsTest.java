package academy.devdojo.maratonajava.projetos.duvidas.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PoolDeThreads implements Runnable {

    @Override
    public void run() {
        System.out.printf("Thread %s execultando tarefa... %n", Thread.currentThread().getName());
    }
}

public class PoolThreadsTest {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2); // o Pool de threads e o conjunto de thread definido
        ex.execute(new PoolDeThreads());
        ex.execute(new PoolDeThreads());
        ex.execute(new PoolDeThreads());
        ex.execute(new PoolDeThreads());
        ex.execute(new PoolDeThreads());
        ex.execute(new PoolDeThreads());
        ex.shutdown(); // o shutDown nao cancela as tarefas, so impede de adicionar novas
    }
}
