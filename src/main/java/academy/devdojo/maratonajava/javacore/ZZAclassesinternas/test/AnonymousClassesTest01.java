package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

/// Classes Anonimas sao classes que vao existir brevemente por um determinado periodo de tempo no codigo e que nao pode ser reutilizada em nenhum outro lugar
class Animal {
    public void walk() {
        System.out.println("Animal Walking");
    }
}

public class AnonymousClassesTest01 {
    public static void main(String[] args) {
        Animal animal = new Animal() { // criacao de uma classe anonima sem nome, aqui e criado uma subclasse de animal, usado para uma alteracao so naquele ponto especifico do codigo

            @Override
            public void walk() {
                System.out.println("Walking in the shadows");
                jump(); // voce so pode usar metodo anonimo dentro da propria classe, fora dela esse metodo nao e enxergado
            }
            public void jump() {

            }
        };
        animal.walk();
    }
}
