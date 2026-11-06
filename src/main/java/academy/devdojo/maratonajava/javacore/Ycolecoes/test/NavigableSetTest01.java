package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone> { //regra separada da classe, voce define e usar de fora

    @Override
    public int compare(Smartphone o1, Smartphone o2) { // compara smartphone 1 com o 2
        return o1.getMarca().compareTo(o2.getMarca()); //
    }
}

class MangaPrecoComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {
        // tudo que herda de Set, deve tomar cuidado para nao inserir elementos duplicados
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "nokia");
        set.add(smartphone);
        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator()); // tambem elimina duplicados mas coloca em ordem, baseado no seu compareTo
        mangas.add(new Manga(5L, "Hellsing Hultimate", 19.9, 0));
        mangas.add(new Manga(1L, "Berserk", 9.5, 5));
        mangas.add(new Manga(4L, "Pokemon", 3.2, 0));
        mangas.add(new Manga(3L, "Attack on Titan", 11.2, 0));
        mangas.add(new Manga(2L, "Dragon Ball Z", 2.99, 4));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga yuyu = new Manga(21L, "Yu yu Hakusho", 3.2, 5);

        // metodos de comparacao
        // lower - traz o primeiro menor <
        // floor - o mesmo elemento ou caso nao exista, o imediato logo abaixo dele <=
        // higher - o primeiro maior >
        // ceiling - >=
        System.out.println("--------------");
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        System.out.println("---------------");
        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst()); // retorna e remove o primeiro elemento, remove um por um
        System.out.println(mangas.pollLast()); // retorna e remove o ultimo elemento, tambem remove um por um
        System.out.println(mangas.size());
    }
}
