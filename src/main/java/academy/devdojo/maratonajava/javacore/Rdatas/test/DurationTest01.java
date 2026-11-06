package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;

///Duration serve para representar uma quantidade de tempo, ou seja, a duração entre dois momentos.
public class DurationTest01 {
    public static void main(String[] args) {
        // Pega a data e hora atuais.
        LocalDateTime now = LocalDateTime.now();

        // Pega a data e hora atuais e adiciona 2 anos e 8 minutos.
        LocalDateTime nowAfterTwoYears = LocalDateTime.now().plusYears(2).plusMinutes(8);

        // Pega o horário atual.
        LocalTime timeNow = LocalTime.now();

        // Pega o horário atual e remove 7 horas.
        LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);

        // Calcula a duração entre duas datas e horários.
        Duration duration1 = Duration.between(now, nowAfterTwoYears);

        // Calcula a duração entre dois horários.
        Duration duration2 = Duration.between(timeNow, timeMinus7Hours);

        // Calcula a duração entre dois instantes.
        // O segundo Instant ocorre 1000 segundos depois do primeiro.
        Duration duration3 = Duration.between(Instant.now(), Instant.now().plusSeconds(1_000));

        // Exibe as durações.
        System.out.println(duration1);
        System.out.println(duration2);
        System.out.println(duration3);
    }
}
