package academy.devdojo.maratonajava.projetos.duvidas.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Pagamento implements Runnable {
    private String nomeCliente;
    private int valor;

    public Pagamento(String nomeCliente, int valor) {
        if (valor > 0) {
            this.valor = valor;
        } else {
            throw new IllegalArgumentException(nomeCliente + " Adicionou valor negativo");
        }
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getValor() {
        return valor;
    }

    private void exibirPagamento() {
        // Usa System.out como bloqueio compartilhado para impedir que threads misturem as mensagens no console.
        synchronized(System.out) {
            System.out.println("==================");
            System.out.println("Nome do cliente: " + nomeCliente);
            System.out.println("Valor do pagamento: " + valor);
            System.out.println("Nome da thread que esta processando: " + Thread.currentThread().getName());

        }
    }

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        exibirPagamento();
    }
}

public class RunnableTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new Pagamento("Goku", 75));
        executorService.execute(new Pagamento("ChatGpt", 1700));
        executorService.execute(new Pagamento("Kakashi", 20));
        executorService.execute(new Pagamento("Obito", -150));
        executorService.execute(new Pagamento("Yuji", 250));
        executorService.execute(new Pagamento("Levi", 5000));
        executorService.execute(new Pagamento("Mark", 15));
        executorService.execute(new Pagamento("Kuririn", 6900));
        executorService.shutdown();
    }
}
