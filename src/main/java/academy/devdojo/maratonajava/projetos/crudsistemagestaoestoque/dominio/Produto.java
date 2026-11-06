package academy.devdojo.maratonajava.projetos.crudsistemagestaoestoque.dominio;

public class Produto {
    String nome;
    String descricao;
    Integer preco;
    Integer quantidadeEstoque;
    String categoria;
    String codigo;

    public Produto(String nome, String descricao, Integer preco, Integer quantidadeEstoque, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        if (preco > 0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("Preco invalido");
        }
        if (quantidadeEstoque > 0) {
            this.quantidadeEstoque = quantidadeEstoque;
        } else {
            throw new IllegalArgumentException("Quantidade de estoque invalido");
        }
        this.categoria = categoria;
    }
}
