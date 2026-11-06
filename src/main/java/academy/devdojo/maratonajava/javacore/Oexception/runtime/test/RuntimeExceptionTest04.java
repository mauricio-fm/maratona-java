package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RuntimeExceptionTest04 {
    public static void main(String[] args) {
        //para tratar multiplas exception, basta colocar multiplos catch.
        //nao pode fazer isso com classes na mesma linha de herança
        try {
            throw new RuntimeException();
            //fazendo desse jeito quando voce execultar o try, ele vai procurar nos catch oque melhor se adequa.
            //se nao tiver, vai dar erro.

        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e) {
            System.out.println("Dentro do ArrayIndexOutOfBoundsException | IllegalArgumentExceptione | ArithmeticException");
        } catch (RuntimeException e) {
            System.out.println("Dentro do RuntimeException");
            //AVISO: exception mais generica sempre deve vir no final, se for a primeira, o codigo da erro
        }

        try {
            talvezLanceException();
        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void talvezLanceException() throws SQLException, FileNotFoundException {
        //throw  → LANÇA a exceção
        //throws → DECLARA que o método pode lançar uma exceção
        System.out.println("Dentro do talvezLanceException");
    }
}