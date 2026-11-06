package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.List;

/*
 * Comparator:
 *
 *     Usado quando queremos definir uma regra
 *     de comparação fora da classe.
 *
 *     Diferente do Comparable, podemos criar
 *     várias formas de ordenação.
 *
 *     Exemplos:
 *
 *         ordenar por nome
 *         ordenar por capítulos
 *         ordenar por id
 */

public class ComparatorTest01 {

    public static void main(String[] args) {

        List<Manga> mangas = new ArrayList<>();

        mangas.add(new Manga(5L, "Berserk", 40));
        mangas.add(new Manga(1L, "Naruto", 700));
        mangas.add(new Manga(3L, "One Piece", 1100));
        mangas.add(new Manga(2L, "Bleach", 686));

        /*
         * Comparator:
         *
         *     (m1, m2) -> ...
         *
         *     m1 e m2 são os dois objetos
         *     que serão comparados.
         */

        mangas.sort((m1, m2) ->
                m1.getNome().compareTo(m2.getNome())  // recebe m1 e m2 como parametros, pega o nome do manga1, e compara com
                // o do manga2
        );

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
