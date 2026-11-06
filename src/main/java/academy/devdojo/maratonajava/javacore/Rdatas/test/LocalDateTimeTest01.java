package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// LocalDateTime
// aqui voce tem a junção dos metodos da LocalDate e LocalTime
public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate date = LocalDate.parse("2026-08-25"); //voce pode usar o parse, mas a data deve ser (ano-mês-dia)
        System.out.println(date);

        LocalTime time = LocalTime.parse("16:34:00"); //tambem pra hora, (hora-min-seg)
        System.out.println(time);

        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now().withSecond(0).withNano(0); //tira o nanosegundo e segundo
        System.out.println(timeNow);

        LocalDateTime ldt1 = date.atTime(time);
        LocalDateTime ldt2 = dateNow.atTime(timeNow);
        System.out.println(ldt1); //mostra a data configurada acima
        System.out.println(ldt2); //mostra a data e hora atual sem nanosegundos e segundos
    }
}
