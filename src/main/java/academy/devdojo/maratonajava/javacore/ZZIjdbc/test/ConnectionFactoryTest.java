package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest {
    public static void main(String[] args) {
        Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producerToUpdate = Producer.builder().id(1).name("MadHouse").build();
//        ProducerService.save(producer); // adiciona o elemento Studio Deen
//        ProducerService.delete(9); // delelta toda uma linha por id
//        ProducerService.update(producerToUpdate); // atualiza um valor na tabela deixando o MadHouse upperCase
//        List<Producer> producers = ProducerService.findByName("A-1"); // pesquisa por nome
//        List<Producer> producers = ProducerService.findAll(); // pesquisa tudo
//        ProducerService.showProducerMetaData();
//        ProducerService.showDriverMetaData(); // as informacoes da tabela, quantidade de colunas, nome de cada entre outros
//        ProducerService.showTypeScrollWorking();
//        List<Producer> producers = ProducerService.findByNamePreparedStatement("Wit Studio");
//        List<Producer> producers = ProducerService.findByNamePreparedStatement("bones");
//        log.info("Producers found '{}'", producers);
//        ProducerService.updatePreparedStatement(producerToUpdate);
        List<Producer> producers = ProducerService.findByNameCallableStatement("bones");
        log.info("Producers found '{}'", producers);
    }
}

/**
 * Tipos de Log
 *
 *  log.info("info"); // Eventos normais e importantes, como uma operação concluída
 *  log.debug("debug"); // Informações para depuração, como valores de variáveis e etapas da execução
 *  log.warn("warn"); // Situações inesperadas que merecem atenção, mas não impedem necessariamente a execução
 *  log.error("error"); // Erros que impedem uma operação ou indicam uma falha
 *  log.trace("trace"); // Detalhes extremamente específicos
 *
 *      os mais importantes e usado e
 *
 *          log.info()
 *          log.warn()
 *          log.error()
 */
