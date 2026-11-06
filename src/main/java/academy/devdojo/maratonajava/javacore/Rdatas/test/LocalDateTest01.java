package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Month;

// LocalDate
// Sempre use LocalDate para datas, nao use Date ou Calendar
public class LocalDateTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2026, Month.OCTOBER, 6); //LocalDate e so data, sem hora
        System.out.println(date);

        LocalDate agora = LocalDate.now(); //data de agora
        System.out.println(agora); //ao imprimir dessa maneira, o output ja vem do formato que e usado para guardas no banco de dados

        System.out.println(date.getYear()); //mostra ano
        System.out.println(date.getMonth()); //mostra mes
        System.out.println(date.getMonthValue()); //numero do mes
        System.out.println(date.getDayOfWeek()); //dia da semana
        System.out.println(date.getDayOfMonth()); //dia do mes
        System.out.println(date.getDayOfYear()); //dia do ano que estamos
        System.out.println(date.lengthOfMonth()); //quantos dias tem o mes
        System.out.println(date.isLeapYear()); //mostra se o ano e ou nao bissexto
    }
}
