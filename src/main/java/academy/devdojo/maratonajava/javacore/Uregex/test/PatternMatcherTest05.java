package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/// Quantificadores
public class PatternMatcherTest05 {
    public static void main(String[] args) {
        // ? Zero ou uma
        // * Zero ou mais
        // + uma ou mais
        // {n,m} de n ate m
        // () agrupamento
        // | ou, e usado junto com o de agrupamento
        // $ fim da linha
        // . tudo entre um numero e outro, digitos ou nao digitos 
        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String texto = "luffy@hotmail.com, 123goku@gmail.com, principedossayjin@gmail.com.br, #@!zoroperdido@mail.br, teste@gmail.com";
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