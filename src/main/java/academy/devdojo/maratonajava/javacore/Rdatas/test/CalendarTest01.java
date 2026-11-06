package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();  //voce nao pode usar, new na classe Calendar, devido ela ser abstrata
        if (calendar.getFirstDayOfWeek() == Calendar.SUNDAY) {
            System.out.println("Domingo e o primeiro dia da semanda");
        }
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); //dia da semana
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); //dia do mes
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); //dia do ano
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH)); //dia da semanda no mes

        calendar.add(Calendar.DAY_OF_MONTH, 2); //adiciona 2 dias no mes
        calendar.add(Calendar.DAY_OF_WEEK, 3); //adiciona 3 dias na semana
        calendar.add(Calendar.HOUR, 3); //adiciono 3 horas
        Date date = calendar.getTime();
        System.out.println(date);
    }
}
