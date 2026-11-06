package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        // Type erasure, definir o tipo da lista na sua criacao
//        List<String> lista = new ArrayList<>();
        List lista = new ArrayList<>();
        lista.add("Midoriya");
        lista.add(123L);
        lista.add(new Consumidor("Goku"));

        for (Object o : lista) {
            if (o instanceof String) { // instaceof verifica se um objeto e uma instancia de algo, String int, para usar voce utiliza wrapper, Integer, Long etc
                System.out.println(o);
            }
            if (o instanceof Long) {
                System.out.println(o);
            }
        }

    }
}
