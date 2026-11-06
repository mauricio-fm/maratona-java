package academy.devdojo.maratonajava.projetos.bancodedados.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFac {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3307/java_treino";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password); // obtém uma conexão com o banco de dados e a
        // devolve para quem chamou o método


    }
}

/**
 * Oque é um Connection:
 *      É o objeto que representa a conexão entre uma aplicação Java e o banco de dados MySQL.
 *
 *      Ex:
 *          Connection connection = DriverManager.getConnection(
 *                  "jdbc:mysql://localhost:3307/loja",
 *                  "root",
 *                  "senha"
 *          );
 *
 *          para obter uma conexao voce precisa, da url (caminho para o banco), o username e a senha
 *
 *
 *          - DriverManager: obtém a conexão.
 *          - URL: informa onde está o banco e qual banco será acessado.
 *          - root: usuário do MySQL.
 *          - senha: senha desse usuário.
 *          - Connection: representa a conexão estabelecida.
 *
 * Oque é um Statement:
 *      É um objeto usado para enviar comandos SQL ao banco por meio da conexão
 *
 *      Ex:
 *          Statement statement = connection.createStatement();
 *
 *          statement.execute("SELECT * FROM produtos");
 *
 *
 *          - connection.createStatement() cria um Statement.
 *          - execute() envia o comando SQL para execução.
 *          - SELECT * FROM produtos solicita os registros da tabela produtos.
 */
