package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        now = now.with(ChronoField.DAY_OF_MONTH, 20); // O ChronoField serve para alterar uma parte especifica da data
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));  // Data da próxima quinta-feira ou hoje
        System.out.println("\n" + now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY));  // Data da próxima quinta-feira
        System.out.println("\n" + now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)); // Data da quinta-feira anterior
        System.out.println("\n" + now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()); //mostra o primeiro dia do mes atual
        System.out.println("\n" + now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()); //mostra o ultimo dia do mes atual
        System.out.println("\n" + now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear()); //mostra o primeiro dia do proximo ano
        System.out.println("\n" + now);
        System.out.println(now.getDayOfWeek());
    }
}
