package academy.devdojo.maratonajava.projetos.bancodedados.test;

import academy.devdojo.maratonajava.projetos.bancodedados.dominio.Produto;
import academy.devdojo.maratonajava.projetos.bancodedados.service.ProdutoService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ProdutoTest {
    public static void main(String[] args) {
        Produto produto = Produto.builder().name("Teclado").price(250).build();
        Produto produto2 = Produto.builder().name("Mouse").price(50).build();
//        ProdutoService.save(produto);
//        ProdutoService.save(produto2);
//        List<Produto> products = ProdutoService.findByName("teclado");
//        log.info("Products found '{}' ", products);
        ProdutoService.deleteProduto(3);
    }
}
