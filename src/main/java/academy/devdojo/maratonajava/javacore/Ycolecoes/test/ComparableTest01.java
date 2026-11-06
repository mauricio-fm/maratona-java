package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Comparable:
 *
 *     Usado quando a própria classe define
 *     sua ordem natural.
 *
 *     A classe "Manga" precisa implementar:
 *
 *         Comparable<Manga>
 *
 *     E sobrescrever:
 *
 *         compareTo()
 *
 *     O compareTo() define como dois objetos
 *     daquele tipo serão comparados.
 */

public class ComparableTest01 {

    public static void main(String[] args) {

        List<Manga> mangas = new ArrayList<>();

        mangas.add(new Manga(5L, "Berserk", 40));
        mangas.add(new Manga(1L, "Naruto", 700));
        mangas.add(new Manga(3L, "One Piece", 1100));
        mangas.add(new Manga(2L, "Bleach", 686));

        /*
         * Collections.sort() utiliza o
         * compareTo() da classe Manga.
         */

        Collections.sort(mangas); // se voce for ate a classe Manga, vera que o compareTo de la ta comparando pelo nome

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}