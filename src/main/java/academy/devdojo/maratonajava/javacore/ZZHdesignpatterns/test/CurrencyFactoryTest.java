package academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.test;

import academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.dominio.Country;
import academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.dominio.Currency;
import academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.dominio.CurrencyFactory;

public class CurrencyFactoryTest {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        System.out.println(currency.getSymbol());
    }
}
