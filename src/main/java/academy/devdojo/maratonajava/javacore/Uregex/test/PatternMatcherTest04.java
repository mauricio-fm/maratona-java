package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/// Quantificadores
public class PatternMatcherTest04 {
    public static void main(String[] args) {
        // ? Zero ou uma
        // * Zero ou mais
        // + uma ou mais
        // {n,m} de n ate m
        // () agrupamento
        // | ou, e usado junto com o de agrupamento
        // $ fim da linha
        // . tudo entre um numero e outro, digitos ou nao digitos
        String regex = "0[xX]([0-9a-fA-F])+\\s|$";
        String texto = "12 0x 0X 0xFFABC 0x10G 0x1";
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  " + texto);
        System.out.println("indice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posições encontradas");
        while (matcher.find()) { 
            System.out.print(matcher.start() + " " + matcher.group() + " \n");
        }
        System.out.println(0.1  + 0.2);
    }
}