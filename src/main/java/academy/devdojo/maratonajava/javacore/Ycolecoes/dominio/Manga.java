package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

import java.util.Objects;

public class Manga implements Comparable<Manga> { // comparable e a forma padrao de comparar seus objetos
    private Long id; // quando estamos trabalhando com classes que representam o mundo real, voce precisa de um identificador unico, normalmente id
    private String nome;
    private double preco;
    private int quantidade;

    public Manga(Long id, String nome, double preco) {
        Objects.requireNonNull(id, "Id nao pode ser null");
        Objects.requireNonNull(nome, "Nome nao pode ser null");
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Manga(Long id, String nome, double preco, int quantidade) {
        this(id, nome, preco);
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(id, manga.id) && Objects.equals(nome, manga.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Manga outroManga) { // define a logica de como comparar, pelo oque comparar dois objetos
        // negativo se o this < outroManga
        // se this == outroManga, return 0
        // positivo se o this > outroManga

//        if (this.id < outroManga.getId()) { // se o this.id for menor do que o id passado return -1
//            return -1;
//        } else if (this.id.equals(outroManga.getId())) { // se o this.id for igual ao id passado return 0
//            return 0;
//        } else { // caso contrario return 1
//            return 1;
//        }

        return this.nome.compareTo(outroManga.getNome()); // organiza pelo nome
//        return this.id.compareTo(outroManga.getId()); // organiza pelo id, como aqui encima mas com a classe compareTo do java
//        return Double.compare(preco, outroManga.getPreco()); // organiza pelo preco
//        return Double.valueOf(preco).compareTo(outroManga.getPreco()); // tambem pelo preco
    }


}
