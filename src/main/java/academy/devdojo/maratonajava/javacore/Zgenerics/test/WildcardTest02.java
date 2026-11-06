package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());
        printAllConsulta(cachorros);
        printAllConsulta(gatos);
        List<Animal> animals = new ArrayList<>();
        printConsultaAnimal(animals);
        printConsultaAnimal(cachorros);
    }
    // o ? extends nao aceita criar um Animal especifico, por exemplo, animais.add(new Cachorro()); vai dar erro, voce so pode ler elementos
    private static void printAllConsulta(List<? extends Animal> animals) { // o (? extends) è usado para dizer aceito qualquer tipo que seja dessa classe ou de uma classe filha
        for (Animal animal : animals) {
            animal.consulta();
        }
    }
    private static void printConsultaAnimal(List<? super Cachorro> animals) { // o (? super) è usado para dizer que aceita qualquer tipo que seja pai
        for (Object o : animals) { // por ser qualquer tipo superior a animal, voce nao pode usar nada no tipo a nao ser objeto
            if (o instanceof Cachorro) { // por isso voce tem de usar um if para fazer alguma ação especifica
                System.out.println(o);
            }
        }
    }
}
