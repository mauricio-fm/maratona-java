package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.dominio.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("1ABC1", "iPhone");
        System.out.println(s1.equals(s2));
        System.out.println("equals funcionamento");
        equals();
    }
    public static void equals() {
        String nome = "Mauricio Ferreira";
        String nome2 = new String("Mauricio Ferreira"); //se fizer new String retorna false pois esta no heap
        System.out.println(nome == nome2); //verifica referencia
        System.out.println(nome.equals(nome2)); // verifca o conteudo
    }
}
