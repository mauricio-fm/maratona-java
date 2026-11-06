package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

public class RuntimeExceptionTest03 {
    public static void main(String[] args) {
        abreConexao();
    }

    public static String abreConexao() {
        try {
            System.out.println("Abrindo arquivo...");
            System.out.println("Escrevendo dados no arquivo...");
            return "Conexao Aberta";
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally { //Voce pode usar so um try e finally
            System.out.println("Fechando recurso liberado pelo SO...");
        }
        return null;
    }
}

/*
TRATAMENTO DE EXCEPTIONS

try → tenta executar o código.
catch → captura e trata a exceção.
finally → executa sempre, com ou sem exceção.
 */

/*
Finally é um comando usado no tratamento de exceções para garantir que um trecho de código
seja executado, sempre, independente da condição que esteje acontecendo dentro do seu try catch.
 */
