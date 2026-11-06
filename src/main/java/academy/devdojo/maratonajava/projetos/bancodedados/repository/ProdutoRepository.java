package academy.devdojo.maratonajava.projetos.bancodedados.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.projetos.bancodedados.connection.ConnectionFac;
import academy.devdojo.maratonajava.projetos.bancodedados.dominio.Produto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProdutoRepository {
    public static void save(Produto producer) {
        String sql = "INSERT INTO java_treino.produto (nome, preco) VALUES ('%s', %s)"
                .formatted(producer.getName(), producer.getPrice());
        try (Connection conn = ConnectionFac.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted produto '{}' in the database, rows affected '{}'", producer.getName(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to insert produto '{}'", producer.getName(), e);
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM `java_treino`.`produto` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement statement = conn.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Deleted product '{}' from the database, rows affected '{}'", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete produto '{}'", id, e);
        }
    }

    public static List<Produto> findByName(String nome) {
        log.info("Finding products");
        String sql = "SELECT * FROM java_treino.produto WHERE nome LIKE '%%%s%%';"
                .formatted(nome);
        List<Produto> products = new ArrayList<>();
        try (Connection conn = ConnectionFac.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Produto product = Produto
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("nome"))
                        .price(resultSet.getInt("preco"))
                        .build();
                products.add(product);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find products by name", e);
        }
        return products;
    }
}
