package academy.devdojo.maratonajava.javacore.Uregex.test;

/// Tokens e Delimitadores
public class ScannerTest01 {
    public static void main(String[] args) {
        String texto = "Levi, Eren, Mikasa"; //Tokens e o resultado,Delimitadores nesse caso e a ","
        String[] nomes = texto.split(","); // serve para dividir uma String em partes usando regex
        for (String nome : nomes) { // escrevendo o nome do array, dando um alt+enter, selecionando iterate, voce cria um for
            System.out.println(nome.trim()); //trim remove os espaços
        }

    }
}
