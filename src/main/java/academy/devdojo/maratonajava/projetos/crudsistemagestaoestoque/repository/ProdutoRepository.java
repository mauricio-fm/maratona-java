package academy.devdojo.maratonajava.projetos.crudsistemagestaoestoque.repository;

import academy.devdojo.maratonajava.projetos.crudsistemagestaoestoque.connection.ConnectionFactory;
import academy.devdojo.maratonajava.projetos.crudsistemagestaoestoque.dominio.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProdutoRepository {

    public static List<Produto> findByName(String name) {
        try(Connection conn = ConnectionFactory.getConnection()) {
            String sql = "SELECT * FROM loja.produtos WHERE nome like ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
