package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Account;

public class ThreadAccountTest01 implements Runnable{
    private final Account account = new Account();

    public static void main(String[] args) {
        ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
        Thread t1 = new Thread(threadAccountTest01, "Hestia");
        Thread t2 = new Thread(threadAccountTest01, "Bell Cranel");
        t1.start();
        t2.start();
    }


    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            withdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("FODEO");
            }
        }
    }
    private static synchronized void print() {
        // voce pode criar synchronized em metodos estaticos, nesse caso com
        // metodo estatico voce ta basicamente sincronizando a classe inteira
        synchronized (ThreadAccountTest01.class) {
            // ou voce pode fazer em bloco e sincronizar trechos especificos
            // mas o mais comum e o bloco ou sincronizar o metodo normal, sem static
        }
    }

    private void withdrawal(int amount) {
        // synchronized serve para a thread que começa a execultar esse metodo, vai termina de execultar ele, vem logo apos
        // o tipo de acesso do metodo
        // voce pode criar tambem como um bloco de codigo, mas para isso a variavel usada (account) precisa ser final
        System.out.println(getThreadName().getName() + " ##### fora do synchronized");
        synchronized (account) {
            System.out.println(getThreadName().getName() + " ***** dentro do synchronized");
            if (account.getBalance() >= amount) {
                System.out.println(getThreadName().getName() + " está indo sacar " + amount);
                account.withdrawal(amount);
                System.out.println(getThreadName().getName() + " realizou o saque com sucesso, saldo atual " + account.getBalance());
            } else {
                System.out.println("Saldo insuficiente para " + getThreadName().getName() + " efetuar o saque " + account.getBalance());
            }
        }
    }

    private static Thread getThreadName() {
        return Thread.currentThread();
    }
}
