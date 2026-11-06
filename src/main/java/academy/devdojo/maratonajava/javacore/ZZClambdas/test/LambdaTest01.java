package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.List;
import java.util.function.Consumer;

/// Consumer basicamente e Pegue cada elemento e faça alguma coisa com ele
public class LambdaTest01 {
    public static void main(String[] args) {
        List<String> strings = List.of("Mauricio", "Ferreira", "Goku", "Eren");
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        forEach(strings, (String s) -> System.out.println(s)); // execulta o forEach passando a lista strings e uma acao que recebe uma String e imprime essa String
        forEach(integers,  i -> System.out.println(i)); // voce pode tirar os parenteses e o tipo
    }

    // T significa que o metodo e generico, List<T> list, e a lista que o metodo vai percorrer, Consumer representa uma ação que recebe um objeto e não retorna nada
    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T e : list) { // pega cada elemento da lista e entrega para o Consumer
            consumer.accept(e);
        }

    }

}
