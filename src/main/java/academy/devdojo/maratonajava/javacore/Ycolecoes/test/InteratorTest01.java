package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/// e uma classe que checa antes de fazer uma ação
public class InteratorTest01 {
    public static void main(String[] args) {
        // um LinkedList e um array aonde cada posiçao conhece a posição anterior e a proxima, exemplo, a posição 1 sabe
        // da 2 e a posicao 2 sabe da 1 e 3, sendo na Big-o, mais rapido para remover do que o ArrayList
        List<Manga> mangasLinkedList = new LinkedList<>();

        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(2L, "Pokemon", 19.9, 0));
        mangas.add(new Manga(5L, "Berserk", 25.52, 5));
        mangas.add(new Manga(3L, "Attack on Titan", 15.56, 0));
        mangas.add(new Manga(4L, "Dragon Ball Z", 45.54, 4));

//        Iterator<Manga> mangaIterator = mangas.iterator(); // interator e uma classe que checa antes de fazer uma ação
//        while (mangaIterator.hasNext()) { // enquanto existir um proximo manga
//            Manga manga = mangaIterator.next();
//            if (manga.getQuantidade() == 0) {
//                mangaIterator.remove();
//            }
//        }

        // navega por todos os mangas e remove se a quantidade de manga for 0
        mangas.removeIf(manga -> manga.getQuantidade() == 0);

        System.out.println(mangas);
    }
}
