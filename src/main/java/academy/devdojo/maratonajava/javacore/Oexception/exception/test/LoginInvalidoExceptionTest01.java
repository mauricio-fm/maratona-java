package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.dominio.LoginInvalidadoException;

import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidadoException e) {
            e.printStackTrace();
        }
    }

    private static void logar() throws LoginInvalidadoException {
        Scanner teclado = new Scanner(System.in);
        String usernameDB = "Goku";
        String passwordDB = "ssj";
        System.out.println("Usuario");
        String usernameDigitado = teclado.nextLine();
        System.out.println("Senha");
        String senhaDigitada = teclado.nextLine();
        if (!usernameDB.equals(usernameDigitado) || !passwordDB.equals(senhaDigitada)) {
            throw new LoginInvalidadoException("Usuario ou senha invalido tente novamente");
        }else {
            System.out.println("Usuario logado com sucesso");
        }

    }
}
