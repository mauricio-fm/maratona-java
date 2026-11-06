package academy.devdojo.maratonajava.projetos.duvidas.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/// CompletableFuture é uma classe do Java usada para executar tarefas assíncronas, permitindo processar resultados,
/// encadear operações e tratar erros sem bloquear a thread principal desnecessariamente.
public class CompletableFutureTest {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
//        searchPricesSync(storeService);
//        searchPricesAsyncFuture(storeService);
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesSync(StoreService storeService) {
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
    }

    private static void searchPricesAsyncFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 4");
        try {
            System.out.println(pricesAsyncFuture1.get());
            System.out.println(pricesAsyncFuture2.get());
            System.out.println(pricesAsyncFuture3.get());
            System.out.println(pricesAsyncFuture4.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
        StoreService.shutDown();
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        CompletableFuture<Double> pricesAsyncFuture1 = storeService.getPricesAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pricesAsyncFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pricesAsyncFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pricesAsyncFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");

        System.out.println(pricesAsyncFuture1.join()); // o join nao lança exececao como o get lança
        System.out.println(pricesAsyncFuture2.join());
        System.out.println(pricesAsyncFuture3.join());
        System.out.println(pricesAsyncFuture4.join());
        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
        // o completableFuture nao precisa de um shutDown, ele desliga sozinho

        /**
         * Assincrona e Sincrona:
         *      Assíncrono: uma tarefa começa a ser executada e o programa pode continuar fazendo
         *      outras coisas enquanto ela acontece.
         *
         *      Ex:
         *          Sincrona:
         *              int resultado = calcular();
         *              System.out.println("Continuando...");
         *              // o programa espera "calcular()" termina antes de imprimir a mensagem
         *
         *           Assincrona:
         *               CompletableFuture<Integer> futuro =
         *                       CompletableFuture.supplyAsync(() -> calcular());
         *
         *               System.out.println("Continuando...");
         *               // A tarefa é iniciada de forma assíncrona, permitindo que o programa continue sem
         *               // esperar o cálculo terminar, voce pega o resultado de um completableFuture com
         *               // .join() ou .get()
         *
         *                  Ex:
         *                      System.out.println(futuro.join()); // com join, nao lança execao
         *                      System.out.println(futuro.get()); // com get, lança execao
         *                      // tanto get quanto join espera o resultado
         *                      // get e usado com Future<V>
         *                      // join e get e usado no ComparableFuture
         *
         */
        System.out.println("=====ExemploThenApply=====");
        CompletableFuture<Integer> sum = CompletableFuture
                .supplyAsync(() -> 5 + 5)
                .thenApply(resultado -> resultado * 3); // O thenApply() recebe o resultado de uma tarefa
                // anterior, transforma esse valor e retorna um novo CompletableFuture
        System.out.println(sum.join());

        System.out.println("=====ExemploThenAccept=====");
        CompletableFuture<Void> futuro = CompletableFuture
                .supplyAsync(() -> 10 + 20)
                .thenAccept(System.out::println);

        System.out.println("==============");
        CompletableFuture<Void> sum2 = CompletableFuture // voce tem que colocar o tipo de retorno do Completable como Void
                .supplyAsync(() -> 8 + 2)
                .thenApply(resultado -> resultado * 4)
                .thenAccept(System.out::println);
    }
}
