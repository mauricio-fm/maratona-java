package academy.devdojo.maratonajava.projetos.duvidas.dominio;

public interface Payment {
    String pagar();
}

class CreditCard implements Payment {

    @Override
    public String pagar() {
        return "Paying with credit card...";
    }
}

class Pix implements Payment {

    @Override
    public String pagar() {
        return "Paying with pix...";
    }
}

class Ticket implements Payment {

    @Override
    public String pagar() {
        return "Paying with ticket...";
    }
}
