package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(4);
        numeros.add(3);
        numeros.add(1);
        numeros.add(5);
        // -(ponto de inserção) -1
        // A lista que vai ser procurada deve estar ordenada
        // Caso voce tenha definido um comparator, voce precisa passar ele tambem no binarySearch
        Collections.sort(numeros);
        // index 0,1,3,4,5,6
        // value 0,2,3,4,1,5
        int binarySearch = Collections.binarySearch(numeros, 2);
        System.out.println("Valores ordenados " + numeros);
        System.out.println("Valor encontrado no index " + binarySearch);

    }
}
