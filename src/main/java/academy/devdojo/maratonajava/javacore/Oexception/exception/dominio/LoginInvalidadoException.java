package academy.devdojo.maratonajava.javacore.Oexception.exception.dominio;
//Exception custumizada, nesse exemplo login invalido

public class LoginInvalidadoException extends Exception{ //e esse extends que define que e uma exceção custumizada
    public LoginInvalidadoException() {
        super("Login invalido");
    }

    public LoginInvalidadoException(String message) {
        super(message);
    }
}
