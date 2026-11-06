package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        int num = ThreadLocalRandom.current().nextInt(1, 11); // numero aleatorio de 1 a 11
        for (int i = 0; i < num; i++) {
            System.out.printf("%s executando uma tarefa callable...%n", Thread.currentThread().getName());
        }
        // String.format formata um return em String, permitindo usar metodos de String
        return String.format("%s finished and the random number is %d", Thread.currentThread().getName(), num);
    }
}

public class CallableTest1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(randomNumberCallable); // e excultado no futuro, primerio voce ve
        // o sout da lnha de baixo e depois essa linha
        String s = future.get();
        System.out.printf("Program finished %s", s);
        executorService.shutdown();
    }
}
