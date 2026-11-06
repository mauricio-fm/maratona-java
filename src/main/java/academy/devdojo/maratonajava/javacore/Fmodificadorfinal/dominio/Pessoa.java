package academy.devdojo.maratonajava.javacore.Fmodificadorfinal.dominio;

public class Pessoa {
    public String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public final void apresentar() {
        System.out.println("Meu nome é " + this.nome);
    }

    /*tambem temos classes final, mas nao usei aqui, classes final basicamente nao podem ser herdadas por
    outras classes, um exemplo de classe final no java e a String.
     */
}
