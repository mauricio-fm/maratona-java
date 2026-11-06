package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamFlatMapTest {
    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>(); // e como uma Matriz, uma lista dentro de outra lista
        List<String> graphicDesigners = List.of("Catarina Santos", "Sandy Carolina");
        List<String> developers = List.of("William Suane", "Mauricio", "David");
        List<String> students = List.of("Edipo", "Guilherme");
        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

        for (List<String> people : devdojo) {
            for (String person : people) {
                System.out.println(person);
            }

        }
        System.out.println("-----------");
        devdojo.stream().flatMap(Collection::stream).forEach(System.out::println);
        // flatMap serve para transformar cada elemento em vários elementos e depois juntar tudo em uma única Stream
    }
}
