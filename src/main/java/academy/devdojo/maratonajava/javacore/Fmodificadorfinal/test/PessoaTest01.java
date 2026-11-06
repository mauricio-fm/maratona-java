package academy.devdojo.maratonajava.javacore.Fmodificadorfinal.test;

import academy.devdojo.maratonajava.javacore.Fmodificadorfinal.dominio.Pessoa;

public class PessoaTest01 {
    public static void main(String[] args) {
        final Pessoa pessoa = new Pessoa("Elon musk");
        //Funcionario pessoa = new Funcionario("Elon");

        pessoa.apresentar();
    }
}
