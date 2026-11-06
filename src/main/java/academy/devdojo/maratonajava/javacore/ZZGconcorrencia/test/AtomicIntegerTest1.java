package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private Lock lock = new ReentrantLock(true);

    void increment() {
        lock.lock(); // garante que apenas uma thread por vez acesse um recurso compartilhado com outras threads
        try {
            count++;
            atomicInteger.incrementAndGet();
        } finally {
            // independente se der excecao ou nao o unlock e execultado
            lock.unlock(); // libera o lock
        }
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}

// e uma classe que permite manipular um numero inteiro com operacoes atomicas
// operacoes que sao execultadas de forma indivisivel em relacao as outras operacoes
// concorrentes do mesmo objeto
public class AtomicIntegerTest1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < 10_000; i++) {
                counter.increment();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
        System.out.println(counter.getAtomicInteger());
    }
}
