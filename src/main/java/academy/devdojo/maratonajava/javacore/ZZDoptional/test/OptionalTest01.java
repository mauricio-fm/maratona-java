package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/// È um contêiner que pode ou não conter um valor não nulo, criado para evitar erros de NullPointerException
public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> o1 = Optional.of("Aula 201");
        Optional<String> o2 = Optional.ofNullable(null); // ofNullable diz que nao sabe se o objeto sera null, portanto deixa colocar
        Optional<String> o3 = Optional.empty(); // cria um optional vazio
        System.out.println(o1);
        System.out.println(o2);
        System.out.println(o3);
        System.out.println("-------------------");

        Optional<String> nameOptional = findName("Mauricio");
        String empty = nameOptional.orElse("EMPTY");
        System.out.println(empty);
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));

    }

    private static Optional<String> findName(String name) {
        List<String> list = new ArrayList<>(List.of("Mauricio", "DevDojo"));
        int i = list.indexOf(name); // procura name dentro da lista e retorna o index de onde ele esta e guarda na variavel i
        if (i != 1) {
            return Optional.of(list.get(i));
        }
        return Optional.empty();
    }
}
