package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class BarcoNameComparator implements Comparator<Barco> {

    @Override
    public int compare(Barco o1, Barco o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        List<Barco> barcoList = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
        barcoList.sort(new Comparator<Barco>() { // voce nao pode dar new em uma interface, mas pode quando ta trabalhando com classes anonimas
            @Override
            public int compare(Barco o1, Barco o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        // voce pode fazer esse mesmo codigo da seguinte forma
        //  barcoList.sort((o1, o2) -> o1.getNome().compareTo(o2.getNome())); “Pegue dois objetos da lista, o1 e o2. Pegue o nome de o1 e compare com o nome de o2.”
        System.out.println(barcoList);
    }
}
