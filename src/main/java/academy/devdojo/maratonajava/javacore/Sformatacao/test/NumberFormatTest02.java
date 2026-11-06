package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

//  Internacionalização de moeda com Locale
public class NumberFormatTest02 {
    public static void main(String[] args) {
        Locale localeBR = new Locale("pt", "BR");
        Locale localeJP = Locale.JAPAN; //e a mesma coisa daqui de cima, mas desse jeito nao tem para o Brasil
        Locale localeIT = localeBR.ITALY;
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getCurrencyInstance();
        nfa[1] = NumberFormat.getCurrencyInstance(localeBR);
        nfa[2] = NumberFormat.getCurrencyInstance(localeJP);
        nfa[3] = NumberFormat.getCurrencyInstance(localeIT);
        double valor = 1000.2130;

        for (NumberFormat numberFormat : nfa) {
            System.out.println(numberFormat.format(valor));
            System.out.println("Numero de digitos fracionado: " +numberFormat.getMaximumFractionDigits());
            System.out.println();
        }
        String valorString = "￥1,000"; //para rodar voce precisa colocar tambem o simbolo da moeda, se nao tiver da a exceção  Unparseable number
        try {
            System.out.println(nfa[2].parse(valorString));
        } catch (ParseException e) {
            throw new RuntimeException("Invalid Format " + e);
        }


    }
}
