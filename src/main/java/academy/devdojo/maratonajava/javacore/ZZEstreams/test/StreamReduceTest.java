package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.List;

/// reduce È uma operação terminal da Stream usada para combinar todos os elementos de um fluxo em um único valor
public class StreamReduceTest {
    public static void main(String[] args) { // Reduce
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        integers.stream().reduce((x, y) -> x + y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0,(x,y) -> x + y));

        // usando lambda
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0, Integer::sum));

        System.out.println("--------------");

        integers.stream().reduce((x, y) -> x * y).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(1,(x,y) -> x * y));

        System.out.println("--------------");

        // ambos os codigos abaixo retorna o maior da lista
        integers.stream().reduce((x, y) -> x > y ? x : y).ifPresent(System.out::println); // Se x for maior que y, retorne x; caso contrário, retorne y.
        System.out.println(integers.stream().reduce(0, Integer::max)); // mesma coisa daqui de cima

    }
}
