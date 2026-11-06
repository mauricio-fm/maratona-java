package academy.devdojo.maratonajava.javacore.Pwrapper.test;

public class WrapperTest01 {
    public static void main(String[] args) {
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 10L;
        float floatP = 10F;
        double doubleP = 10D;
        boolean booleanP = true;
        char charP = 'M';

        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1;   //autoboxing quando voce tem tipo primitivo e o java converte automaticamente pra um wrapper
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 10D;
        Boolean booleanW = true;
        Character charW = 'M';

        int i = intW;  //unboxing quando voce vai de um wrapper para um tipo primitivo
        Integer intW2 = Integer.parseInt("1"); //pegar o texto "1" e transforma no número inteiro 1.
        //usados para valores do usuario, se ele digita 15 no Scanner, vem como texto, mas com isso voce transforma em numero

        int soma = intW2 + 5;
        System.out.println(soma);

        System.out.println(Character.isDigit('A'));          // Verifica se é número
        System.out.println(Character.isLetterOrDigit('9'));  // Verifica se é letra ou número
        System.out.println(Character.isUpperCase('A'));      // Verifica se é maiúscula
        System.out.println(Character.isLowerCase('a'));      // Verifica se é minúscula
        System.out.println(Character.toUpperCase('a'));      // Converte para maiúscula
        System.out.println(Character.toLowerCase('A'));      // Converte para minúscula
    }
}
