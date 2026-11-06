package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/// Condition serve gerenciar a sincronização de threads em ambientes concorrentes
public class Members {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10); //  é uma lista de elementos aonde o
    // primeiro a entrar e o primeiro a sair, esse blockingQueue e uma  fila que armazena os e-mails pendentes ate 10
    private final ReentrantLock lock = new ReentrantLock(); // controla o acesso concorrente à fila
    private final Condition condition = lock.newCondition(); // permite que threads esperem por uma condição e sejam
    // notificadas quando algo mudar
    private boolean open = true; //indica se o sistema continua aceitando e-mails

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        lock.lock(); // Adquire o bloqueio; outras threads precisam esperar para adiquirir o mesmo lock,
        // e usado para as outras threads nao atravessarem a thread atual, como no synchronized
        // isso so impede a entrada simultanea de de outras threads em trechos protegidos como esse

        try {
            return emails.size(); // consulta e retorna quantos emails pendentes estao na lista
        } finally {
            lock.unlock(); // garante que o bloqueio seja liberado, mesmo dando exceçao
        }
    }

    public void addMemberEmail(String email) {
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");
            this.emails.add(email);
            condition.signalAll(); // notifica todas as threads que aguardam aquela condicao
        } finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException { // esse metodo tenta retirar o email da fila, a fila ta vazia ?
        // (Sim -> O sistema esta fechado ? se sim retorna null. Se nao execulta o await())
        // (Se a fila nao ta vazia retira o email com poll())

        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        lock.lock();
        try {
            while (this.emails.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponivel na lista, entrando em modo de espera");
                condition.await(); // faz a thread atual parar de rodar imediatamente e entrar em estado de espera
                // ele libera o thread por meio de  uma notificação ou condição (nesse caso e uma condicao que libera)
                // para usalo voce precisa da interface Condition
            }
            return this.emails.poll();
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Notificando to mundo que não estamos mais pegando emails");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
