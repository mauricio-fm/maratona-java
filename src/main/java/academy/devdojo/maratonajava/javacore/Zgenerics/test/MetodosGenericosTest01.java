package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;

import java.util.List;

public class MetodosGenericosTest01 {
    public static void main(String[] args) {
        criarArratComUmObjeto(new Barco("Canoa"));
    }

    private static <T> void criarArratComUmObjeto(T t) { // o parametro (T) tipo, e passao depois dos modificadores de acesso, antes do tipo de retorno, e tambem deve ser passado no parametro do metodo
        List<T> list = List.of(t);
        System.out.println(list);
    }
}
