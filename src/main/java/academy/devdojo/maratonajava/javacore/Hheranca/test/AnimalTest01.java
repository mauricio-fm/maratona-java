package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Cachorro;
import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Gato;

public class AnimalTest01 {
    public static void main(String[] args) {
        Cachorro dog = new Cachorro("Caramelo", 7, "Caramelo");
        Gato cat = new Gato("Faisca", 4, "brown");

        dog.print();
        dog.bark();

        cat.print();
        cat.meow();
    }
}
