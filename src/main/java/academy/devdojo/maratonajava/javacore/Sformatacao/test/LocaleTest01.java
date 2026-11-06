package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

// Internacionalização Datas com Locale
public class LocaleTest01 {
    public static void main(String[] args) {
        Locale localeItaly = new Locale("it", "IT");
        Locale localeBrazil = new Locale("pt-br", "BR");
        Locale localeJapan = new Locale("ja", "JP");
        Calendar calendar = Calendar.getInstance();
        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL, localeBrazil);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL, localeJapan);

        System.out.println("Italy " + df1.format((calendar.getTime())));
        System.out.println("Brazil " + df2.format((calendar.getTime())));
        System.out.println("Japan " + df3.format((calendar.getTime())));
    }
}
