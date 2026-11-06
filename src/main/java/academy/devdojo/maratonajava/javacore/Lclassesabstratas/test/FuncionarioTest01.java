package academy.devdojo.maratonajava.javacore.Lclassesabstratas.test;

import academy.devdojo.maratonajava.javacore.Lclassesabstratas.dominio.Desenvolvedor;
import academy.devdojo.maratonajava.javacore.Lclassesabstratas.dominio.Gerente;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Goku", 5000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Akira", 10000);
        System.out.println(gerente);
        System.out.println(desenvolvedor);

        //confira o .txt MetodosAbstratosRegras pra entender oque aconteceu aqui embaixo.
        gerente.imprime();
        desenvolvedor.imprime();
    }
}
