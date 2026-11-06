package academy.devdojo.maratonajava.projetos.duvidas.test;

import academy.devdojo.maratonajava.projetos.duvidas.dominio.Payment;
import academy.devdojo.maratonajava.projetos.duvidas.dominio.PaymentFactory;
import academy.devdojo.maratonajava.projetos.duvidas.dominio.PaymentMethod;

public class FactoryTest {
    public static void main(String[] args) {
        Payment payment = PaymentFactory.newPayment(PaymentMethod.PIX);
        System.out.println(payment.pagar());

    }
}
