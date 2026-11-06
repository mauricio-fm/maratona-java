package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

///Meta caracteres
public class PatternMatcherTest02 {
    public static void main(String[] args) {
        // \d = Todos os digitos
        // \D = Tudo oque nao for digito
        // \s = Todos os epaços em branco
        // \S = Todos os caracteres excluindo espaços brancos
        // \w = a-ZA-Z, digitos, _
        // \W = Tudo oque nao for incluso no \w
        String regex = "\\W";
        String texto = "@#hh_j2 12gvh21"; 
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) { 
            System.out.print(matcher.start() + " " + matcher.group() + " \n");
        }
    }
}