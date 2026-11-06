package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 { // classe top level
    private  String name = "Mauricio";
    static class Nested { // voce so pode acessar atributos estaticos da classe top level, ao usar static class, ela tambem se torna aqui, uma classe top level
        private String lastName = "Ferreira"; // estando dentro da classe, voce pode acessar diretamente
        void print() {
//            System.out.println(name); // colocando o atributo name como estatico
            System.out.println(new OuterClassesTest03().name + " "  + lastName); // sem colocar o atributo como estatico
        }
    }
    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
