package academy.devdojo.maratonajava.projetos.duvidas.test;

import java.util.concurrent.*;

/// O submit() envia uma tarefa ao ExecutorService, assim como execute(), mas retorna um objeto Future, que permite
/// acompanhar a tarefa e obter seu resultado
public class SubmitTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> resultado = executor.submit(() -> {
            return 10 + 20;
        });
        try {
            System.out.println(resultado.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // voce tambem pode colocar o resultado do get e colocar dentro de uma variavel, ou usa-la direto como fiz aqui encima
        int result = resultado.get();
        System.out.println(result);


        executor.shutdown();
        // 1- o submit() envia a tarefa para execucao
        // 2- a tarefa calcula 10 + 20
        // 3- o resultado e armazanado no Future, que representa o resultado futuro daquela tarefa
        // 4- voce pode chamar resultado.get() para obter a resposta, se a tarefa nao terminou o get espera
        // o get lanca duas exececoes, a InterrupedException e a ExecutionException

        /// Exercicio

        System.out.println("=============");
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> submit = executorService.submit(() -> 15 + 25);
        // TODO importante, o submit() nao devolve diretamente o resultado, ele devolve um Future<V> que representa o
        //  resultado da tarefa o get e quem recupera a tarefa
        System.out.println(submit.get());
        executorService.shutdown();
    }
}
