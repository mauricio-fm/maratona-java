package academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.test;

import academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.dominio.Person;

/// Design Patternes ou padroes de projetos e uma forma de escrever codigo que vai resolver um problema comum
public class BuilderPatternTest {
    public static void main(String[] args) {
        Person person = Person.PersonBuilder // builder e uma forma mais legivel e profissional de
                // trabalhar com objetos, facilitando a leitura do codigo
                .builder()
                .fisrtName("Mauricio")
                .lastName("Duarte")
                .username("IS MAURICIO")
                .email("mauricio@devdojo.academy")
                .build();
        System.out.println(person);
    }
}
