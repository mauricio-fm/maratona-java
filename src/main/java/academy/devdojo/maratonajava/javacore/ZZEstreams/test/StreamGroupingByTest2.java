package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion.NORMAL_PRICE;
import static academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion.UNDER_PROMOTION;
import static java.util.stream.Collectors.*;

public class StreamGroupingByTest2 { // o groupingBy agrupa elementos de uma Stream de acordo com uma caracteristica, criando um Map
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overload", 10.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game no Life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemis", 5.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari ", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        Map<Promotion, List<LightNovel>> collect = lightNovels
                .stream()
                .collect(groupingBy(ln -> ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE
                ));
        /**
         * ln -> ln.getPrice() < 6 -> Verifica se o preço é menor que 6.
         * ? Promotion.UNDER_PROMOTION -> Se o preço for menor que 6, classifica como promoção.
         * : Promotion.NORMAL_PRICE -> Caso contrário, classifica como preço normal.
         * groupingBy() -> Agrupa os livros pela classificação retornada pela lambda.
         *
         * O resultado é um Map:
         *
         * Chave (Promotion) -> UNDER_PROMOTION ou NORMAL_PRICE
         * Valor (List<LightNovel>) -> Lista de livros daquela categoria.
         */
        System.out.println(collect);
        System.out.println();
        // Map<Category, Map<Promotion, List<LightNovel>>>

        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels
                .stream()
                .collect(groupingBy(LightNovel::getCategory, groupingBy(ln -> getPromotion(ln))));
        // Esse código agrupa os livros por categoria e, dentro de cada categoria, por promoção ou preço normal.
        System.out.println(collect1);
    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
    }
}
