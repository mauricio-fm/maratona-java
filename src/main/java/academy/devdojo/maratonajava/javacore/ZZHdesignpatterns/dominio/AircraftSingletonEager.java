package academy.devdojo.maratonajava.javacore.ZZHdesignpatterns.dominio;

import java.util.HashSet;
import java.util.Set;

public final class AircraftSingletonEager {
    // Eager initalization
    private static final AircraftSingletonEager INSTACE = new AircraftSingletonEager("787-900");
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonEager(String name) { // e obrigatorio o construtor ser privado quando usar singleton
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    @Override
    public String toString() {
        return "AircraftSingletonEager{" +
                "availableSeats=" + availableSeats +
                ", name='" + name + '\'' +
                '}';
    }

    public static AircraftSingletonEager getInstance() {
        return INSTACE;
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
