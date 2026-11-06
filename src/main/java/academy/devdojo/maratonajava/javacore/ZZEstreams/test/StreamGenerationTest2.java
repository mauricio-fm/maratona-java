package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamGenerationTest2 {
    public static void main(String[] args) {
        // iterate e um metodo que serve para criar streams infinitos, precisando de um valor inicial (seed) sendo necessario limitar com o uso do .limit(tamanho de rep em int)
        Stream.iterate(0, n -> n + 2) // imprime todos os numeros pares e forma infinita
                .limit(10)
                .forEach(System.out::println);
        System.out.println();

        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144...
        // 0 1
        // (0,1) (1,1) (1,2) (2,3) (3,5) (5,8)

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]}) // imprime a sequencia de fibonacci
                .limit(10)
                .forEach(a -> System.out.println(Arrays.toString(a)));

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a[0])
                .forEach(System.out::println);

        ThreadLocalRandom random = ThreadLocalRandom.current();
        // generate tambem serve para criar um stream infinito, mas nao precisa de seed, recebe apenas uma funcao, o uso mais comum e para criar valores que mudam a cada chamada
        Stream.generate(() -> random.nextInt(1, 50_000)) // cria 90 numeros aleatorios de 1 a 500
                .limit(90)
                .forEach(System.out::println);
    }
}
