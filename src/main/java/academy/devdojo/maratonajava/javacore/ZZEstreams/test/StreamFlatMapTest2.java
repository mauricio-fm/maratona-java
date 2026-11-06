package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/// flatMap() serve para transformar cada elemento em uma sequência de elementos e depois juntar tudo em uma única Stream.
public class StreamFlatMapTest2 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");
        String[] letters = words.get(0).split("");
        System.out.println(Arrays.toString(letters));

        List<String[]> collect = words.stream() // cria uma lista a partir da lista "words"
                .map(w -> w.split("")) // w e a palavra atual, w.split() separa cada palavra em streams individual
                .collect(Collectors.toList()); // reune os resultados em uma lista

        Stream<String> stream = Arrays.stream(letters); // transforma um array em stream
        List<String> letters2 = words.stream()
                .map(w -> w.split("")) // Stream<String[]>
                .flatMap(Arrays::stream) // Stream<String>
                .collect(Collectors.toList());
        System.out.println(letters2);
    }
}
