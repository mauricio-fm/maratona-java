package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

// um ArrayList tem a capacidade inicial de 10, a cada modificação ele duplica, mas por boas praticas, define a capacidade aproximada
public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(10); // no tipo de dado de uma lista, voce e obrigado a usar objetos, se voce precisa de valor do estilo tipo primitivo, use wrapper
        List<String> nomes2 = new ArrayList<>();
        nomes.add("Mauricio");
        nomes.add("DevDojo ");
        nomes2.add("Ferreira");
        nomes2.add("Academy");
        // voce pode criar um ArrayList de objetos assim como voce tem Array de objetos, como mostrado abaixo
//        nomes.add(new Consumidor("Mauricio")); // voce passa new nomeObjeto(elementosConstrutor)
//        nomes.remove(1); // tem duas maneiras de remover, pelo index que nesse caso remove o DevDojo Academy ou removendo o objeto como e mostrado abaixo
//        nomes.remove("Mauricio");

        System.out.println(nomes); // voce pode usar sout para imprimir um ArrayList, o output dele vira em toString bem formatada

        nomes.addAll(nomes2); // adicione todos os elementos de nomes2 dentro de nomes

        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("-----------");

        int size = nomes.size();
        for (int i = 0; i < nomes.size(); i++) { // imprimindo lista com for indexado, nao usa lenght como no for mas sim size
            System.out.println(nomes.get(i));
        }

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1234);
        System.out.println(numeros);

        System.out.println("--------");
        // outra maneira melhor de imprimir List, e usar lambdas, nao foi usado aqui pois e mais avançado, veja

        nomes.forEach(System.out::println);
    }
}
