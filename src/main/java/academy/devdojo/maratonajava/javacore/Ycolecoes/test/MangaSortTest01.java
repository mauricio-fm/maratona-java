package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(1L, "Pokemon", 19.9));
        mangas.add(new Manga(4L, "Berserk", 25.52));
        mangas.add(new Manga(2L, "Attack on Titan", 15.56));
        mangas.add(new Manga(3L, "Dragon Ball Z", 45.54));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Collections.sort(mangas);
        System.out.println("---------");

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        mangas.sort(new MangaByIdComparator());
        System.out.println("---------");

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
