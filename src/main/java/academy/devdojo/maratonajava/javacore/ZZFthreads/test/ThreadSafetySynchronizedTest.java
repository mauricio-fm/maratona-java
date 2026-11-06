package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import java.util.ArrayList;
import java.util.List;

class ThreadSafeNames {
    private final List<String> names = new ArrayList<>();

    public synchronized void add(String name) { // ThreadSafe, os metodos desses tipos de classes sao todos sincronizados.
        // se nao houver sincronização, pode acontecer uma condição de corrida (race condition): as duas threads
        // verificam o saldo ao mesmo tempo e tentam sacar, causando um saldo incorreto (saldo negativo)
        names.add(name);
    }

    public synchronized void removeFirst() {
        if (names.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}

// o lock e um mecanismo de controle que garante que apenas uma thread acesse por vez um recurso
// compartilhado entre mais de uma thread, por exemplo, duas threads acessam o atributo de saldo
// um dos tipos mais comum de lock e o synchronized

/**
 * Exemplo:
 *      Imagine um banheiro publico com uma chave na porta
 *      * o Objeto é o banheiro
 *      * a Thread é a pessoa
 *      * Se alguém entra e tranca a porta, qualquer outra
 *      pessoa que chegar terá que esperar na fila até que a primeira saia e devolva a chave.
 *      * essa "Chave" e o synchronized (lock)
 */
public class ThreadSafetySynchronizedTest {
    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Junkrat");
        Runnable r = threadSafeNames::removeFirst;
        new Thread(r).start();
        new Thread(r).start();
    }
}
