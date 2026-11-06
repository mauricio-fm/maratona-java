package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        // converte uma lista para array, voce pode usar numeros.size no lugar do 0, com zero o java descobre o tamanho
        // do array que ele tem que criar, alem do que a performace com o 0 e melhor
        Integer[] listToArray = numeros.toArray(new Integer[0]);
        System.out.println(Arrays.toString(listToArray));
        System.out.println("------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0, 12);
        System.out.println(Arrays.toString(numerosArray));
        System.out.println(arrayToList);

        System.out.println("---------------");
        List<Integer> numerosList = new ArrayList<>( Arrays.asList(numerosArray)); // tome cuidado quando usar asList pois ele e imutavel, mantendo uma ligação com o array original
        numerosList.add(15);
        System.out.println(numerosList);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4)); // uma maneira de criar um arrayList em uma unica linha
        System.out.println(numbers);
    }
}
