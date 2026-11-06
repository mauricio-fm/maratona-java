package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// E uma lista de elementos aonde o primeiro elemento a entrar, e o primeiro a sair
public class ArrayBlockingQueueTest1 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        bq.put("Mauricio");
        // o metodo peek() retorna um valor sem remover daquela lista
        System.out.printf("%s added the value %s %n ", Thread.currentThread().getName(), bq.peek());
        System.out.println("    Trying to add another value");
        new Thread(new RemoveFromQueue(bq)).start();
        bq.put("Ferreira");
        System.out.printf("%s added the value %s %n ", Thread.currentThread().getName(), bq.peek());
    }

    static class RemoveFromQueue implements Runnable {
        private final BlockingQueue<String> bq;

        public RemoveFromQueue(BlockingQueue<String> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            System.out.printf("%s going to sleep for 5 seconds %n ", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s removing value from queue %s%n ", Thread.currentThread().getName(), bq.take());
                // o metodo take() pega e remove o primerio elemento da lista
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
