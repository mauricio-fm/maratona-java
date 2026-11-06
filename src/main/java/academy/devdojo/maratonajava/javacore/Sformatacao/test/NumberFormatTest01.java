package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

// Internacionalização Números com Locale
public class NumberFormatTest01 {
    public static void main(String[] args) {
        Locale localeBR = new Locale("pt", "BR");
        Locale localeJP = Locale.JAPAN; //e a mesma coisa daqui de cima, mas desse jeito nao tem para o Brasil
        Locale localeEN = Locale.US;
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getInstance();
        nfa[1] = NumberFormat.getInstance(localeBR);
        nfa[2] = NumberFormat.getInstance(localeJP);
        nfa[3] = NumberFormat.getInstance(localeEN);
        double valor = 1_000.2130;

        for (NumberFormat numberFormat : nfa) {
            System.out.println(numberFormat.format(valor));
            System.out.println("Numero de digitos fracionado: " + numberFormat.getMaximumFractionDigits());
            System.out.println();
        }
        String valorString = "1000.2130"; //usar "_" pra separar casas decimais, so e permitido direto como numero, se voce mudar de String pra number com ele, o java interpreta como caractere de String
        try {
            System.out.println(nfa[0].parse(valorString));
        } catch (ParseException e) {
            throw new RuntimeException("Invalid Format" + e);
        }
    }
}
