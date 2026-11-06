package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

// Reference to an instance method for a particular object
public class MethodReferenceTest02 {
    public static void main(String[] args) {

        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animes = new ArrayList<>(List.of(new Anime("Attack on Titan", 89), new Anime("Berserk", 43), new Anime("Dragon Ball Z", 349)));
        animes.sort(animeComparators::compareByEpisodesNonStatic); // aqui chamamos pelo objeto e nao pelo nome da classe
        animes.sort((a1, a2) -> animeComparators.compareByEpisodesNonStatic(a1, a2)); // a mesma coisa daqui de cima
        System.out.println(animes);
    }
}
