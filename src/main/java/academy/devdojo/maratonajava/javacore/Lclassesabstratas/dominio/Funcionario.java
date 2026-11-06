package academy.devdojo.maratonajava.javacore.Lclassesabstratas.dominio;

public abstract class Funcionario extends Pessoa{
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        calculaBonus();
    }

    public abstract void calculaBonus();

    /*
    Metodos abstratos so podem estar dentro de classes abstratas, mas classes abstratas podem ter metodos abstratos
    ou nao abstratos, agora esse metodo abstrato aqui encima obriga todos que herdam de Funcionario a ter um bonus,
    mas o valor e decidido na sub-classe.
     */

    @Override
    public void imprime() {
        System.out.println("Imprimindo...");
    }
}
