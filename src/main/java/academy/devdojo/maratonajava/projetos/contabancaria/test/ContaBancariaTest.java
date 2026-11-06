package academy.devdojo.maratonajava.projetos.contabancaria.test;

import academy.devdojo.maratonajava.projetos.contabancaria.dominio.ContaBancaria;

public class ContaBancariaTest implements Runnable {
    private static final ContaBancaria conta = new ContaBancaria();

    public static void main(String[] args) {
        ContaBancariaTest contaBancariaTest = new ContaBancariaTest();
        Thread thread1 = new Thread(() -> contaBancariaTest.saque(10), "Goku"); // sacando direto, para usar
        // comente o saque e deposito do metodo run do Runnable
//        Thread thread1 = new Thread(contaBancariaTest, "Goku");
        Thread thread2 = new Thread(contaBancariaTest, "Vegeta"); // aqui ta sendo usado contaBancariaTest porque
        // conta pertence a instancia ContaBancariaTest e nao uma variavel main
        Thread thread3 = new Thread(contaBancariaTest, "Mestre Kami");
        Thread thread4 = new Thread(contaBancariaTest, "Beerus");
        Thread thread5 = new Thread(contaBancariaTest, "Whis");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    @Override
    public void run() { // O runnable e quem executa a Thread, mas voce consegue usar uma thread sem ele de forma direta
        // como fiz aqui, ai sim voce pode tirar o metodo run, mas as outras threads que nao declaram direto nao vai executar
        // Thread thread1 = new Thread(() -> contaBancariaTest.saque(10), "Goku");
        // thread1.start();
        saque(10);
        deposito(5);
        if (conta.getSaldo() < 0) {
            System.out.println("FODEO");

        }
    }

    public void saque(int quantia) {
        synchronized (conta) {
            if (conta.getSaldo() >= quantia) {
                System.out.println(Thread.currentThread().getName() + " esta indo sacar dinheiro " + quantia);
                if (quantia > 0) {
                    conta.saque(quantia);
                }
                System.out.println(Thread.currentThread().getName() + " realizou o saque com sucesso, saldo atual " +
                        conta.getSaldo());
                System.out.println("=========ProximaThread=========");
            }
        }
    }

    public void deposito(int depositoQuantia) {
        if (depositoQuantia > 0) {
            synchronized (conta) {
                System.out.println(Thread.currentThread().getName() + " esta indo depositar " + depositoQuantia);
                conta.deposito(depositoQuantia);
                System.out.println(Thread.currentThread().getName() + " realizou o deposito com sucesso, saldo atual " +
                        conta.getSaldo());

            }
        }
    }
}
