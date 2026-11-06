package academy.devdojo.maratonajava.projetos.bancodedados.service;

import academy.devdojo.maratonajava.projetos.bancodedados.dominio.Produto;
import academy.devdojo.maratonajava.projetos.bancodedados.repository.ProdutoRepository;

import java.util.List;


public class ProdutoService {
    public static void save(Produto produto) {
        ProdutoRepository.save(produto);
    }

    public static List<Produto> findByName(String nome) {
        return ProdutoRepository.findByName(nome);
    }

    public static void deleteProduto(Integer id) {
        requereValidId(id);
        ProdutoRepository.delete(id);
    }

    public static void requereValidId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid value for id");
        }
    }
}
