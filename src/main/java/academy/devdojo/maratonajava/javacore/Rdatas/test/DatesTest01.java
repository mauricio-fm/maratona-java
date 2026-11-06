package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.util.Date;

public class DatesTest01 {
    public static void main(String[] args) {
        Date date = new Date(1000000000L);
        System.out.println(date.getTime());
    }
}
