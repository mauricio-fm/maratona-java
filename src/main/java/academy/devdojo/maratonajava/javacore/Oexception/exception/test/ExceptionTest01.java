package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest01 {
    public static void main(String[] args) {
        criarNovoArquivo();
    }

    public static void criarNovoArquivo() {
        File file = new File("arquivo\\teste.txt");
        try { //tenta fazer alguma coisa
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado " + isCriado);
        } catch (IOException e) { //se der um problema pega o IOException
            e.printStackTrace();
        }

        /*
        tenta execultar a linha 14,se der certo vai imprimir Arquivo criado,
        se der erro pule parar a linha 16.
         */

        /*
        O Stack Trace é o histórico de onde o erro aconteceu e por quais métodos o programa passou até chegar nele.
        Se der erro vai aparecer algo como:
        java.io.IOException: Acesso negado
        at ExceptionTest01.criarNovoArquivo(ExceptionTest01.java:15)
        at ExceptionTest01.main(ExceptionTest01.java:8)

        Isso mostra:

        Tipo do erro: IOException
        Mensagem: Acesso negado
        Onde aconteceu: ExceptionTest01.java:15
        Caminho que o programa percorreu: criarNovoArquivo() → main()
        Dica: Copia o erro e joga no StackOverFlow, certeza que alguem ja solucionou o erro
         */

    }
}
