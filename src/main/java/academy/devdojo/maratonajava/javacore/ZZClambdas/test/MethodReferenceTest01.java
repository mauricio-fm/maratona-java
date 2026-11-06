package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

// Reference to a static method
public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animes = new ArrayList<>(List.of(new Anime("Attack on Titan", 89), new Anime("Berserk", 43), new Anime("Dragon Ball Z", 349)));
        animes.sort((a1, a2) -> a1.getTitle().compareTo(a2.getTitle())); // ordena os animes por titulo
        // aqui voce pode usar method reference porque a uma chamada, aqui encima tem duas
        animes.sort(AnimeComparators::compareByTitle);
        animes.sort(AnimeComparators::compareByEpisodes); // do menor ao maior
        System.out.println(animes);
    }
}
