package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/// Range
public class PatternMatcherTest03 {
    public static void main(String[] args) {
        // [] = conjunto (range/faixa) de caracteres permitidos [abc] aceita ou a ou b ou c
        String regex = "[a-zA-C]"; //usando - voce define um raio, por exemplo, a-z aceita de a ate z minusculo
        String texto = "cafeBABE";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) { 
            System.out.print(matcher.start() + " " + matcher.group() + " \n");
        }
        int numeroHexadecimal = 0x61AC6; //pra escrever numeros hexa no codigo, voce coloca "0x" no inicio e depois o numero sem ter espaço
        System.out.println(numeroHexadecimal);
    }
}