package academy.devdojo.maratonajava.javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

/// e usado para internacionalização, permite mudar textos conforme indioma ou regiao
public class ResourceBundleTest01 {
    public static void main(String[] args) {
        //baseName = nome base do arquivo, nesse caso messages, linguagem do SO e país
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        System.out.println(Locale.getDefault());
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("good.night"));

        bundle = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));
        System.out.println(bundle.getString("hello"));
        System.out.println(bundle.getString("good.morning"));
        System.out.println(bundle.getString("good.night"));
        System.out.println(bundle.getString("hi"));
    }
}
