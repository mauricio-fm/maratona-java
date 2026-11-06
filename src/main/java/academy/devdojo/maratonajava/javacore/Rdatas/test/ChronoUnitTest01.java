package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

///ChronoUnit é usado para medir ou calcular diferenças entre datas/horários usando uma unidade específica.
public class ChronoUnitTest01 {
    public static void main(String[] args) {
        LocalDateTime aniversario = LocalDateTime.of(2011, Month.OCTOBER, 6, 9, 45, 0);
        LocalDateTime now = LocalDateTime.now(); //voce precisa ter um LocalDateTime para poder usar o ChronoUnit, uma data de inicio e fim
        System.out.println(ChronoUnit.DAYS.between(aniversario, now)); //pega quantos dias tem do valor aniversario ate agora
        System.out.println(ChronoUnit.WEEKS.between(aniversario, now)); //pega quantas semanas tem do valor aniversario ate agora
        System.out.println(ChronoUnit.MONTHS.between(aniversario, now)); //pega quantos meses tem do valor aniversario ate agora
        System.out.println(ChronoUnit.YEARS.between(aniversario, now)); //para saber qual o tipo e o metodo, coloque o mouse sobre ele e veja a assinatura
        System.out.println(ChronoUnit.YEARS.between(aniversario, now)); //faz a mesma coisa daqui de cima mas de forma mais precisa
    }
}
