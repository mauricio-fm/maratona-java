package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable {
    private final int num;

    public Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s execultou: %d%n", Thread.currentThread().getName(), num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finalizou%n", Thread.currentThread().getName());

    }
}

public class ExecutorsTest1 {
    public static void main(String[] args) { // e uma maneira melhor e organizada de gerenciar thread
//        ExecutorService totalThreadAvailable = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        ExecutorService singleThread = Executors.newSingleThreadExecutor();
//        ExecutorService asNeededThread = Executors.newCachedThreadPool();
        // criando threads com executors, voce passa o valor e executa em uma unica linha, execute e como um start,
        // new Printer cria uma nova thread e dentro o valor

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4));
        executorService.execute(new Printer(5)); 
        executorService.execute(new Printer(6));
        // shutdown() inicia um encerramento ordenado, ele nao interrompe as tarefas atualmente em
        // execuçao; em vez disso, ele impede a aceitacao de novas tarefas e permite que as tarefas pendentes sejao finalizada
        executorService.shutdown();

        // quando voce tem duas ou mais thread do que o numero que voce crio de threads, o Java faz uma thread pegar mais
        // de um valor, por exemplo thread-2 pega o valor 2, ela inicia, finaliza volta e ve se tem mais valores se tem,
        // pega mais uma (por exemplo 6) inicia e finaliza, e vai alternando entre todas as 4 threads ate tudo esta pronto
        /**
         * Exemplo nesse caso:
         *
         *      thread-1 execultou: 1
         *      thread-2 execultou: 2
         *      thread-3 execultou: 3
         *      thread-4 execultou: 4
         *      thread-1 finalizou
         *      thread-4 finalizou
         *      thread-4 execultou: 6
         *      thread-2 finalizou
         *      thread-3 finalizou
         *      thread-1 execultou: 5
         *      thread-4 finalizou
         *      thread-1 finalizou
         */
    }
}
