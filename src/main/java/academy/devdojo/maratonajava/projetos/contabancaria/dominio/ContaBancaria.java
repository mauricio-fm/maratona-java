package academy.devdojo.maratonajava.projetos.contabancaria.dominio;

public class ContaBancaria {
    private int saldo = 50;
    private String nome;

    public synchronized void saque(int quantia) {
        if (quantia <= saldo) {
            this.saldo = this.saldo - quantia;
        }
    }

    public synchronized void deposito(int depositoQuantia) {
        if (depositoQuantia > 0 ) {
            this.saldo = this.saldo + depositoQuantia;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }
}
