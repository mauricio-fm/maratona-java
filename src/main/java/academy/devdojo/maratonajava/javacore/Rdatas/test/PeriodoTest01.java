package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalDate;
import java.time.Period;

//período de tempo entre datas, diferente de Duration que usa segundos/nanosegundos Period usa datas, dias,meses e anos
public class PeriodoTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(8);
        Period p1 = Period.between(now, nowAfterTwoYears); //between significa "entre", periodo de "agora" entre agora depois de dois anos".]
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofWeeks(58);
        Period p4 = Period.ofMonths(3);
        Period p5 = Period.ofYears(5);
        System.out.println(p1);
        //o outuput deve ser algo como "P2Y8D", que significa, P2 = periodo 2 anos, "Y" = e, "8D" = 8 dias
        System.out.println(p2);
        //o outuput aqui deve ser "P10D", P10D = periodo de 10 dias
        System.out.println(p3);
        //retorna o numero de semanas em dias
        System.out.println(p4);
        //periodo em meses, vai retorna "P3M", P3M = periodo de 3 meses
        System.out.println(p5);
        //periodo em ano
    }
}
