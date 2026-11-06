package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamFindingMatchingTest { // Finding and Matching
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
        System.out.println(lightNovels.stream()
                .anyMatch(ln -> ln.getPrice() > 8));
        //  anyMatch retorna booleano de uma lista de acordo com uma condicao, nesse caso,
        //  existe algum light novel com o preco maior do que 8 ?

        System.out.println(lightNovels.stream()
                .allMatch(ln -> ln.getPrice() > 0));
        // todo mundo dentro dessa lista tem o preco maior do que 0
        // retorna false se ao menos um nao atender a condicao
        // allMatch retorna true para uma Stream vazia; isso pode ser útil saber futuramente.

        System.out.println(lightNovels.stream()
                .noneMatch(ln -> ln.getPrice() < 0));
        // retorna true se NENHUM elemento atender a condicao
        // retorna false se pelo menos um atender
        /// todos os tres sao uma operacao terminal de uma stream

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .findAny()
                .ifPresent(System.out::println);
        // Retorna um Optional com algum elemento encontrado.
        // Não garante qual elemento será escolhido.

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice))
                .findFirst()
                .ifPresent(System.out::println);
        // Retorna um Optional com o primeiro elemento encontrado.
        // Respeita a ordem da Stream.

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .min(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);
        // Retorna um Optional com o primeiro elemento encontrado.
        // Respeita a ordem da Stream.

    }
}
