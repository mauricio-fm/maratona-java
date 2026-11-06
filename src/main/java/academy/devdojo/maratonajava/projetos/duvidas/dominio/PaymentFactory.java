package academy.devdojo.maratonajava.projetos.duvidas.dominio;

public class PaymentFactory {
    public static Payment newPayment(PaymentMethod payment) {
        switch (payment) {
            case PIX:
                return new Pix();
            case CREDIT_CARD:
                return new CreditCard();
            case TICKET:
                return new Ticket();
            default:throw new IllegalArgumentException("No payment found");
        }
    }
}
