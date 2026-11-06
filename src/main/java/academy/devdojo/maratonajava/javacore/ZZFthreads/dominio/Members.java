package academy.devdojo.maratonajava.javacore.ZZFthreads.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    // Queue é uma lista de elementos aonde o primeiro a entrar e o primeiro a sair
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        synchronized (emails) {
            return emails.size();
        }
    }

    public void addMemberEmail(String email) {
        synchronized (this.emails) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adicionou email na lista");
            this.emails.add(email);
            this.emails.notifyAll(); // notifica todas as threads que ha um email, voce tambem precisar esta
            // em um bloco sincronizado para usar o notifyAll
        }
    }

    // a thread que chamou vai verificar se tem, se a thread pegar o locky do objeto e nao tiver email
    // se tiver aberto (ele entra nos email), se nesse momento tiver mais de uma thread, elas vao ficar
    // esperando, ate ela liberar o locky
    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        synchronized (this.emails) {
            while (this.emails.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponivel na lista, entrando em modo de espera");
                this.emails.wait(); // diz para a thread que esta execultando o this.email esperar, voce so pode chamar
                // wait se tiver o lock do objeto, voce precisa ta obrigatoriamente quando usar wait, dentro de um bloco
                // sincronizado, ele e usado com um objeto
            }
            return this.emails.poll(); // retorna o primeiro email
        }
    }

    public void close() {
        open = false;
        synchronized (this.emails) {
            System.out.println(Thread.currentThread().getName() + " Notificando to mundo que não estamos mais pegando emails");
            this.emails.notifyAll();
        }
    }
}
