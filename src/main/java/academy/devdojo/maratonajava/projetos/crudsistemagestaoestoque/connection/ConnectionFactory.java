package academy.devdojo.maratonajava.projetos.crudsistemagestaoestoque.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements AutoCloseable {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql//localhost:3307/produtos";
        String userName = "root";
        String password = "root";
        return DriverManager.getConnection(url, userName, password);
    }

    @Override
    public void close() throws Exception {

    }
}
