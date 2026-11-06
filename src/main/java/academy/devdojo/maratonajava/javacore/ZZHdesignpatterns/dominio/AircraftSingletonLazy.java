package academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonLazy {
    private static AircraftSingletonLazy INSTACE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonLazy(String name) { // e obrigatorio o construtor ser privado quando usar singleton
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

//    @Override
//    public String toString() {
//        return "AircraftSingletonEager{" +
//                "availableSeats=" + availableSeats +
//                ", name='" + name + '\'' +
//                '}';
//    }

    public static AircraftSingletonLazy getInstance() {
        if (INSTACE == null) {
            synchronized (AircraftSingletonLazy.class) { // sincroniza para que duas threads nao peguem o mesmo assento
                if (INSTACE == null) {
                    INSTACE = new AircraftSingletonLazy("787-900"); // cria de forma lazy
                }
            }
        }
        return INSTACE;
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
