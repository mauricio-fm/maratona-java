package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Quote;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest5 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        var completableFutures = stores.stream() // o var passa diz para o compilador escolher o tipo
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %dms%n", store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutures); // anyOf e considerado
        // terminado quando pelo menos um dos CompletableFuture e finalizado, se retorna um terminado, o programa encerra

//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);// allOf e um metodo
        // usado para combinar multiplas tarefas assincronas, retornando um
        // novo CompletableFuture<Void> que só é concluído quando todas as CompletableFuture fornecidas tiverem
        // finalizado sua execução
        voidCompletableFuture.join();
        System.out.printf("Finished? -> %b%n", voidCompletableFuture.isDone());

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesSync %dms%n", (end - start));
    }
}
