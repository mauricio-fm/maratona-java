package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. Uma classe → um assunto/exemplo principal
 * 2. Um método → uma tarefa
 * 3. Variáveis próximas do código que as utiliza
 * 4. Separe visualmente blocos de etapas diferentes
 */
public class ListSortTest01 {
    public static void main(String[] args) {
        ordenarMangas();
        ordenarDinheiro();
        new Manga(null, null, 0);

    }

    // lembrando, quando voce tem um metodo estatico dentro de uma classe estatica, voce pode chama-lo diretamente,
    // se nao for estatico, precisa criar objeto, ele pode ser private, nao precisa de get para chama-lo pois estao
    // dentro da mesma classe
    public static void ordenarDinheiro() {
        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(21.87);
        dinheiros.add(22.0);
        dinheiros.add(98.0);
        dinheiros.add(12.98);

        for (Double dinheiro : dinheiros) {
            System.out.println("Valor do manga " + dinheiro);
        }

        System.out.println("Valores antes de ser ordenados " + dinheiros); // antes de ser ordenado
        Collections.sort(dinheiros);
        System.out.println("Valores depois de ser ordenados " + dinheiros); // depois de ser ordenado
    }

    public static void ordenarMangas() {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Pokemon");
        mangas.add("Berserk");
        mangas.add("Attack on Titan");
        mangas.add("Dragon Ball Z");


        for (String manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("-------------");
    }
}
