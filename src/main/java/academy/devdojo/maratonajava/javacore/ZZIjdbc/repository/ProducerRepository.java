package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
// e usado para monitorar comportamento, log.info para exibir info, log.error para exibir erro log.warn para aviso de perigo
public class ProducerRepository {
    public static void save(Producer producer) { // coloca elementos no database
        //            inserir no anime_store na tabela producer na coluna name o valor {}
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        // Cria o SQL; use o Workbench para gerar comandos de exemplo, fazendo alguma alteracao, clicando em apply
        // e vendo o comando.
        try (Connection conn = ConnectionFactory.getConnection(); // tenta obter uma conexão com o MySQL obtido no ConnectionFactory
             Statement statement = conn.createStatement()) { // cria um objeto Statement para executar SQL
            int rowsAffected = statement.executeUpdate(sql);// execulta um comando e retorna a quantidade de linha afetadas
            log.info("Inserted producer '{}' in the database, rows affected '{}'", producer.getName(), rowsAffected);
        } catch (SQLException e) { // se nao consegue obeter a conexao lança uma mensagem de erro
            log.error("Error while trying to insert producer '{}'", producer.getName(), e);
        }
    }

    public static void saveTransaction(List<Producer> producers) { // Transação -> ou voce faz tudo ou nao faz nada
        // TODO adicionando varios elementos no banco de de dados, se um der problema na hora de adicionar, para de adicionar
        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false); // altera o commit automatico do banco para falso, assim, caso uma operacao nao seje
            // realizada, nenhuma sera feita
            preparedStatementSaveTransaction(conn, producers);
            conn.commit(); // agora sim sera feito o commit manual, o commit deve ser feito quando voce termina todas operacoes
            conn.setAutoCommit(true); // apos desativar o auto commit voce deve voltalo por conta propria
        } catch (SQLException e) {
            log.error("Error while trying to save producers '{}'", producers, e);
        }
    }

    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ( ? );";
        boolean shouldRollBack = false;
        for (Producer p: producers) {
            try( PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                log.info("Saving producer '{}'", p.getName());
                preparedStatement.setString(1, p.getName());
//                if (p.getName().equals("White fox")) throw new SQLException("Can't save white fox");
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                shouldRollBack = true;
            }
        }
        if (shouldRollBack) {
            log.warn("Transaction is going be rollback");
            conn.rollback(); // se caso der problema e ficar ao menos um elemento sem entrar no banco volta para como estava
        }

    }

    public static void delete(int id) { // retira elementos do database por id
        //            excluir do banco anime_store na tabela producer na coluna id
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement statement = conn.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Deleted producer '{}' from the database, rows affected '{}'", id, rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'", id, e);
        }
    }

    public static void update(Producer producer) { // atualiza elementos do database
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%d');".formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement statement = conn.createStatement()) {
            int rowsAffected = statement.executeUpdate(sql);
            log.info("Update producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = preparedStatementUpdate(conn, producer)) {
            int rowsAffected = preparedStatement.executeUpdate();
            log.info("Update producer '{}', rows affected '{}'", producer.getId(), rowsAffected);
        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId(), e);
        }
    }

    private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, producer.getName());
        preparedStatement.setInt(2, producer.getId());
        return preparedStatement;
    }

    public static List<Producer> findAll() { // busca todos os elementos do database
        log.info("Finding all Producers");
        return findByName("");
//        String sql = "SELECT id, name FROM anime_store.producer;";
//        List<Producer> producers = new ArrayList<>();
//        try(Connection conn = ConnectionFactory.getConnection();
//            Statement statement = conn.createStatement();
//            ResultSet rs = statement.executeQuery(sql)) { // exetureQuery executa consultas que retornam resultados, como SELECT
//            while (rs.next()) {
//                Producer producer1 = Producer
//                        .builder()
//                        .id(rs.getInt("id")) // pega os dados da coluna id
//                        .name(rs.getString("name")) // pega os dados da coluna name
//                        .build();
//                producers.add(producer1);
//            }
//
//        } catch (SQLException e) {
//            log.error("Error while trying to find all producers", e);
//        }
//        return producers;
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding Producers");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%%%s%%';"
                .formatted(name); // SELECT * seleciona todas as colunas
        // FROM indica a tabela
        // LIKE procura um padrão no texto
        // % permite encontrar partes do nome
        // formatted substitui %s pelo valor de name
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) { // TODO recebe e permite ler os dados que o banco retorna em uma
            // consulta SELECT, aqui ele basicamente traz os dados que foram buscados no anime_store.producer, o sql como parametro
            // e o caminho para o banco de dados que mando a informacao
            while (resultSet.next()) {
                Producer producer1 = Producer
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                producers.add(producer1);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find producers by name", e);
        }
        return producers;
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        log.info("Finding Producers with prepared statement");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = preparedStatementFindByName(conn, name);
             ResultSet resultSet = preparedStatement.executeQuery()) { // e uma forma de
            // execultar comandos SQL passando parametros, um valor que sera preenchido, evitando SQL Injection
            while (resultSet.next()) {
                Producer producer1 = Producer
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                producers.add(producer1);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find producers by name prepared statement", e);
        }
        return producers;
    }

    public static List<Producer> findByNameCallableStatement(String name) {
        log.info("Finding Producers with callable statement");
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement = callableStatementFindByName(conn, name);
             ResultSet resultSet = preparedStatement.executeQuery()) { // e uma forma de
            // execultar comandos SQL passando parametros, um valor que sera preenchido, evitando SQL Injection
            while (resultSet.next()) {
                Producer producer1 = Producer
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                producers.add(producer1);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find producers by name callable statement", e);
        }
        return producers;
    }

    private static CallableStatement callableStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
        CallableStatement callableStatement = conn.prepareCall(sql);
        callableStatement.setString(1, String.format("%%%s%%", name));
        return callableStatement;
    }

    private static PreparedStatement preparedStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE ?;";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, String.format("%%%s%%", name));
        return preparedStatement;
    }

    public static void showProducerMetaData() {
        log.info("Showing Producer Metadata");
        String sql = "SELECT * FROM anime_store.producer";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            resultSet.next(); // o rs comeca fazendo referencia para ninguem, agora ele faz para o primeiro item MADHOUSE
            int columnCount = resultSetMetaData.getColumnCount(); // quantidade de colunas na tabela
            log.info("Column count '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name '{}'", resultSetMetaData.getTableName(i));
                log.info("Column name '{}'", resultSetMetaData.getColumnName(i));
                log.info("Column size '{}'", resultSetMetaData.getColumnDisplaySize(i));
                log.info("Column type '{}'", resultSetMetaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            log.error("Error while trying to find producers by name", e);
        }
    }

    public static void showDriverMetaData() {
        log.info("Showing Driver MetaData");
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) { // só pode percorrer os resultados para frente
                log.info("Supports TYPE_FORWARD_ONLY");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) { // navega de cima para baixo e de baixo para cima
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
            if (databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                if (databaseMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And Supports CONCUR_UPDATABLE");
                }
            }
        } catch (SQLException e) {
            log.error("Error while trying to find producers by name", e);
        }
    }

    public static void showTypeScrollWorking() {
        String sql = "SELECT * FROM anime_store.producer;";
        try (Connection conn = ConnectionFactory.getConnection()) {
            Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(sql);
            // TODO move o cursor para a ultima linha
            log.info("Last row? '{}'", resultSet.last()); // vai para a ultima linha
            log.info("Last row number '{}'", resultSet.getRow()); // pega o numero da ultima linha
            log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());

            // TODO move o cursor para a primeira linha
            System.out.println();
            log.info("First row? '{}'", resultSet.first()); // vai para a primeira linha
            log.info("First row number '{}'", resultSet.getRow()); // pega o numero da primeira linha
            log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());

            // TODO move o cursor para uma linha especifica
            System.out.println();
            log.info("Row absolute? '{}'", resultSet.absolute(2)); // vai para a segunda linha
            log.info("Row number '{}'", resultSet.getRow()); // pega o numero da linha
            log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());

            // TODO volta ou avanca uma quantidade de linhas especificas
            System.out.println();
            log.info("Row relative? '{}'", resultSet.relative(-1)); // volta uma linha, se for negativo volta, se positivo avança
            log.info("Row number '{}'", resultSet.getRow()); // pega o numero da linha
            log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build());

            // TODO mostra em que linha esta sem mexer o cursor
            System.out.println();
            log.info("Is last? '{}'", resultSet.isLast()); // verifica se e a ultima linha sem mexer o curso
            log.info("Row number '{}'", resultSet.getRow());

            System.out.println();
            log.info("Is first? '{}'", resultSet.isFirst()); // verifica se a primeira
            log.info("Row number '{}'", resultSet.getRow());

            log.info("Last row? '{}'", resultSet.last());
            log.info("---------------------");
            resultSet.next();
            log.info("After last row? '{}'", resultSet.isAfterLast()); // vai para depois do fim da tabela
            while (resultSet.previous()) { // volta uma linha, enquanto houver linha ele vai voltar uma por vez
                log.info(Producer.builder().id(resultSet.getInt("id")).name(resultSet.getString("name")).build()); // imprime o nome e id da linha atual
                // ele nao imprime a linha atual, se voce ta na primeira, entra no loop, avança um(vai para 3 linha)
                // nao imprime, avanca para a segunda, imprime e avanca pra primeira, imprime e termina, se voce quer
                // incluir a atual, use o AfterLast para ir alem da tabela
            }
        } catch (SQLException e) {
            log.error("Error while attempting to retrieve the last element", e);
        }

    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        log.info("Finding Producers");
        String sql = "SELECT * FROM anime_store.producer WHERE name LIKE '%%%s%%';"
                .formatted(name); // SELECT * seleciona todas as colunas
        // FROM indica a tabela
        // LIKE procura um padrão no texto
        // % permite encontrar partes do nome
        // formatted substitui %s pelo valor de name
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery(sql)) { // TODO recebe e permite ler os dados que o banco retorna em uma
            // consulta SELECT, aqui ele basicamente traz os dados que foram buscados no anime_store.producer, o sql como parametro
            // e o caminho para o banco de dados que mando a informacao
            while (resultSet.next()) {
                // TODO atualizando dados com resultSet
                resultSet.updateString("name", resultSet.getString("name").toUpperCase()); // atualiza a coluna name colocando ela para upperCase, maiuscula
//                resultSet.cancelRowUpdates(); // cancela as atualizacoes feita nas colunas, esse comando deve ser antes do updateRow se nao nao volta mais
                resultSet.updateRow(); // so com esse comando e atualizado a linha, se voce esquecer dele nao vai mudar nada
                Producer producer = Producer
                        .builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .build();
                producers.add(producer);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find producers by name", e);
        }
        return producers;
    }

}

