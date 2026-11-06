package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/// a function tambem e uma interface funcional, contendo T (oque voce vai receber) e R (oque voce vai voltar)
/// a definicao de function e pegue cada elemento, transforme-o em outra coisa e coloque o resultado em uma nova lista
public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> strings = List.of("Natsu", "Allucard");
        List<Integer> integers = map(strings, (String s) -> s.length()); // pega uma String e retorna o tamanho dela em int
        List<String> map = map(strings, String::toUpperCase); // aqui voi usado method reference, voce usa quando sua lambda chama apenas um metodo
        System.out.println(integers);
        System.out.println(map);
    }

    // T tipo que entra, R tipo que sai, List<T> e a lista que entra no metodo, Function<T, R> function e aonde voce
    // passa a transformação que voce quer fazer, recebe T -> transforma -> retorna R
    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>(); // e a lista que vai guardar os resultados da transformação
        for (T e : list) { // para cada elemento da lista original
            R r = function.apply(e); // pegue "e" e aplique a transformacao e retorne R
            result.add(r);
        }
        return result;
    }
}
