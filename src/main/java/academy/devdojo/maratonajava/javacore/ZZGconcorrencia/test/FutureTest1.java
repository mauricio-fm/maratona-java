package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

/// Future<V> representa o resultado futuro de uma tarefa executada de forma assíncrona.
public class FutureTest1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> { // retorna o valor do dolar que pode ser requisitado
            // com dollarRequest.get()
            TimeUnit.SECONDS.sleep(5);
            return 5.07D;
        });
        System.out.println(doSomething());

        Double dollarResponse = null;
        try {
            // tenta pegar o valor do dollar por 3s, se nao der lança a TimeoutException
            dollarResponse = dollarRequest.get(3, TimeUnit.SECONDS); // por conta do sleep, a thread so vai ser
            // desligada depois que o tempo acabar, dando o valor null para dolar
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        System.out.println("Us Dollar: " + dollarResponse + " Brazilian Real");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long doSomething() {
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        return sum;
    }
}
