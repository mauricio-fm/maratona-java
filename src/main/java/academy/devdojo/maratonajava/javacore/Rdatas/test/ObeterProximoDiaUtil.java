package academy.devdojo.maratonajava.javacore.Rdatas.test;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

class ObeterProximoDiaUtil implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int adddays;
        switch (dayOfWeek) {
            case FRIDAY:
                adddays = 3;
                break;
            case SATURDAY:
                adddays = 2;
                break;
            default:
                adddays = 1;
        }

        return temporal.plus(adddays, ChronoUnit.DAYS);
    }
}
