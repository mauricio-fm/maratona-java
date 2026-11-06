package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion;

import java.util.*;

import static academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion.NORMAL_PRICE;
import static academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promotion.UNDER_PROMOTION;
import static java.util.stream.Collectors.*;

public class StreamGroupingByTest4 { // o groupingBy agrupa elementos de uma Stream de acordo com uma caracteristica, criando um Map
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

        // agrupa os LightNovels pela categoria, e faz um resumo de preço, quantidade, soma total, valor minimo etc
        Map<Category, DoubleSummaryStatistics> estatisticasPorCategoria = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, summarizingDouble(LightNovel::getPrice)));
        System.out.println(estatisticasPorCategoria);
        // Map<Category, List<Promotion>>

        // usando Set ao inves de List faz com que nao tenha valores duplicados
        Map<Category, Set<Promotion>> promocoesPorCategoria = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, mapping(StreamGroupingByTest4::getPromotion, toSet())));
        System.out.println(promocoesPorCategoria);

        Map<Category, LinkedHashSet<Promotion>> promocoesPorCategoriaComHash = lightNovels.stream()
                .collect(groupingBy(LightNovel::getCategory, mapping(StreamGroupingByTest4::getPromotion,
                        toCollection(LinkedHashSet::new))));
        System.out.println(promocoesPorCategoriaComHash);
    }

    private static Promotion getPromotion(LightNovel ln) {
        return ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
    }
}
