package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamReduceTest2 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overload", 10.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no Life", 2.99),
            new LightNovel("Fullmetal Alchemis", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari ", 4.00)
    ));

    public static void main(String[] args) {
        // pega os precos do light novels maior do que 3 e soma eles
        lightNovels.stream()
                // pega os precos do light novel e coloca em sequencia
                .map(LightNovel::getPrice)
                .filter(price -> price > 3)
                // soma os precos que passaram na condicao
                .reduce(Double::sum)
                .ifPresent(System.out::println);

        // faz a mesma coisa como o de cima, mas esse mantem o tipo em primitivo, nao wrapper
        double doubleStream = lightNovels.stream() // Stream<Double>
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price > 3)
                .sum();
        System.out.println(doubleStream);

    }
}
