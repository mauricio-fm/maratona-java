package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;

public class ScheduledThreadPoolTest1 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final void beeper() {
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(timeFormatter) + " beeper"); // imprime beep quando r e chamado
            try {
                TimeUnit.SECONDS.sleep(5); // bota para dormir por 3s, quando ele acorda, ve que embaixo deve
                // imprimir um beeper a cada 5s, soma mais 2s e imprime beeper, e nao, dorme 3s, espera mais 5 e printa
                // se for sleep de 5s e imprimir beeper a cada 5s, ele vai acorda e imprimir imediatamente, isso no
                // scheduleAtFixedRate, ja no scheduleWithFixedDelay e o contrario, quando acorda ele ja começa a contar,
                // initialDelay(1s) -> execulta o primeiro -> Dorme(5s) -> acorda e conta mais 5s, a execucao e de 10s em 10s
                // 09:05:29            09:05:30               (09:05:35)   09:05:40 -> o 35 nao e impresso, so o de 40
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // execulta o Runnable a uma vez em 5 segundos
//        executor.schedule(r, 5, TimeUnit.SECONDS);

        // o primeiro beeper vem em 1s, depois a cada 5s para sempre
        ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);
//        ScheduledFuture<?> scheduleWithFixedDelay = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS);
        executor.schedule(() -> {
            System.out.println("Cancelando o scheduleWithFixedDelay");
            scheduleWithFixedDelay.cancel(false); // cancela o schedule
            executor.shutdown(); // desliga o executor
        }, 20, TimeUnit.SECONDS); // depois de 10s de delay
    }

    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(timeFormatter));
        beeper();
    }
}
