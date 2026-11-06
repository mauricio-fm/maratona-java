package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/// epressoes regulares e uma linguagem que usa simbolos que encontra padroes em um texto
/// pattern e o padrao e matcher que encontra esse padrao
public class PatternMatcherTest01 {
    public static void main(String[] args) {
        String regex = "ab";
//        String texto = "abaaba";
        String texto2 = "abababa";
        Pattern pattern = Pattern.compile(regex); // expressoes regulares precisam ser compiladas, padrao
        Matcher matcher = pattern.matcher(texto2);//procura o padrao
        System.out.println("Texto:  " + texto2);
        System.out.println("indice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) { //enquanto matcher encontrar
            System.out.print(matcher.start() + " ");
        }
    }
}
