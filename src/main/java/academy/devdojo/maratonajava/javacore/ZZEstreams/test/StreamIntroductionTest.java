package academy.devdojo.maratonajava.javacore.ZZEstreams.test;


import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//1. Order LightNovel by title
//2. Retrive the first 3 titles light novels with price less than 4
public class StreamIntroductionTest {
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
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle)); // compara os LightNovel pelo nome
        List<String> titles = new ArrayList<>(); // cria uma lista para os titulos
        for (LightNovel lightNovel : lightNovels) {
            if (lightNovel.getPrice() <= 4) { // se o preço do lightNovel for menor ou igual a 4
                titles.add(lightNovel.getTitle()); // pegue o titulo e adicione no ArrayList titles
            }
            if (titles.size() >= 3) { // se a quantidade de titulos filtrados for maior ou igual a 3
                break; // pare
            }
        }

        System.out.println(lightNovels);
        System.out.println(titles);

        /**
         * Operacoes:
         *
         *      Você pode identificar se uma operação de Stream é intermediária ou terminal observando seu retorno
         *
         *          Ex:
         *              Operação intermediária → retorna uma Stream
         *              Operação terminal      → retorna um resultado que não é Stream
         *
         *      • resultado final: Pode ser um valor único (como count()), uma coleção
         *      (como collect()), ou um efeito colateral (como forEach()).
         *
         *      • Execução tardia (Lazy Evaluation): As operações intermediárias anteriores (como
         *      filter ou map) só são executadas de verdade quando a operação terminal é chamada.
         *
         *      • Consumo único: Se você tentar usar o mesmo stream novamente após uma operação
         *      terminal, o Java lançará uma exceção IllegalStateException.
         */
    }
}
