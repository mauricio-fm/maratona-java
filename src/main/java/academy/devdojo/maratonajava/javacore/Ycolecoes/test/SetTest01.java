package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        // armazena uma colecao de elementos unicos, sem permitir valores duplicados
        // para funcionar corretamente, normalmente sobrescreve o metodo equals e hashCode
        // pense em um hashSet como um filtro de itens duplicados de listas

        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(5L, "Hellsing Hultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berserk", 25.52, 5));
        mangas.add(new Manga(4L, "Pokemon", 19.9, 0));
        mangas.add(new Manga(3L, "Attack on Titan", 15.56, 0));
        mangas.add(new Manga(2L, "Dragon Ball Z", 45.54, 4));
        mangas.add(new Manga(2L, "Dragon Ball Z", 45.54, 4));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        // Set<Manga> mangasLinkedHash = new LinkedHashSet<>(); // mantem a ordem de inserção

    }
}
