package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/// Nessa classe vamos fazer os mesmos requisitos do StreamTest01 so que usando Streams
// compara pelo nome
// filtra
// para
public class StreamIntroductionTest2 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overload", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no Life", 2.99),
            new LightNovel("Fullmetal Alchemis", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari ", 4.00)
    ));
    public static void main(String[] args) {
        List<String> titles = lightNovels.stream() //cria um List para os titulos filtrados
                .sorted(Comparator.comparing(LightNovel::getTitle)) // compara os LightNovel pelo nome
                .filter(ln -> ln.getPrice() <= 4) //filtra os lightNovel pelo preco menor ou igual a 4
                .limit(3) //limita o tamanho em tres
                // mesma coisa que .map(ln -> ln.getTitle())
                .map(LightNovel::getTitle) // extrai aquilo que voce passa, nesse caso o titulo
                .collect(Collectors.toList()); // Captura o titulo e a adiciona dentro da nova lista titles
        /**
         * primeiro voce ordena pelo nome
         * depois voce filtra pelo preco
         * depois voce limita 3
         * depois voce pega o titulo
         * depois de tudo isso coloca os que passaram em uma lista filtrada
          */
        System.out.println(titles);
    }
}
