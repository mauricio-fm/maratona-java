package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        String nome = "Mauricio ";  //String constant pool
        String nome2 = "Mauricio ";
        nome = nome.concat("Ferreira");
        System.out.println(nome);
        System.out.println(nome == nome2); //compara a referencia e nao o valor.
        String nome3 = new String("Mauricio"); //1 variavel de referencia, 2 objeto do tipo string, 3 uma string no pool de string
        System.out.println(nome2 == nome3);
        System.out.println(nome2 == nome3.intern());
    }
}

/*
Strings são objetos imutáveis, enquanto tipos primitivos não são objetos e não possuem
o conceito de mutabilidade da mesma forma.
 */
