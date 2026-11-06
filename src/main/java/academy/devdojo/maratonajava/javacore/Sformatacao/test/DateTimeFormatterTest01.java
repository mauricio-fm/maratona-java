package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

///nova classe responsavel por formatação
public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        //toda vez que tem format, ta transformando seu objeto para uma String
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); //formata tudo junto sem espaço '20111203'
        String s2 = date.format(DateTimeFormatter.ISO_DATE); //formata  '2011-12-03' ou '2011-12-03+01:00'
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); //formata a data assim '2011-12-03'
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        //quando tem parse, passando de uma String para seu objeto
        LocalDate parse1 = LocalDate.parse("20260829", DateTimeFormatter.BASIC_ISO_DATE); //precisa colocar a String que quero passar pra objeto e o DateTimeFormatter que passa ela
        LocalDate parse2 = LocalDate.parse("2026-08-29", DateTimeFormatter.ISO_DATE); //precisa colocar a String que quero colocar e o DateTimeFormatter que passa ela
        LocalDate parse3 = LocalDate.parse("2026-08-29", DateTimeFormatter.ISO_LOCAL_DATE); //precisa colocar a String que quero colocar e o DateTimeFormatter que passa ela
        System.out.println("\n" + parse1);
        System.out.println(parse2);
        System.out.println(parse3);
    }
}
