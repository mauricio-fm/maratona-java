package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.LocalTime;

//LocalTime
public class LocalTimeTest01 {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(3, 53, 32);//de uma hora especifica, so vai ate 23 horas
        System.out.println(time); //imprime a hora definida com .of()

        LocalTime timeNow = LocalTime.now().plusHours(2).withSecond(0).withNano(0); //plus adiciona uma quantidade certa de tempo no horario
        System.out.println(timeNow);  //e usado o formato 24 horas

        System.out.println(time.getHour()); // hora definido no LocalTime.of()
        System.out.println(time.getMinute()); // minuto definido no LocalTime.of()
        System.out.println(time.getSecond()); // segundo definido no LocalTime.of()
    }
}
