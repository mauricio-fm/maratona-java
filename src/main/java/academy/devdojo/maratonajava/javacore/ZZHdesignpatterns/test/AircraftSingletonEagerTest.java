package academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.test;

import academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.dominio.AircraftSingletonEager;

public class AircraftSingletonEagerTest {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1A");
    }
    private static void bookSeat(String seat) {
        System.out.println(AircraftSingletonEager.getInstance());
        AircraftSingletonEager aircraft = AircraftSingletonEager.getInstance(); // voce nao pode dar new,
        // para usar o objeto do tipo AircraftSingletonEager usa um get, voce cria um atributo do mesmo tipo da classe
        // mas tem que ser private static final, passa o nome, e cria um get para ele, isso na classe AircraftSingletonEager
        // voce tira a possibilidade sem ser ela mesma de criar um objeto, so usar

        System.out.println(aircraft.bookSeat(seat));
    }
}
