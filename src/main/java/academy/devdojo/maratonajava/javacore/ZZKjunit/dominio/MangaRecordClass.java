package academy.devdojo.maratonajava.javacore.ZZKjunit.dominio;

// TODO record e usado para armazenar dados de maneira simples e imultavel
public record MangaRecordClass(String name, int episodes) { // os atributos sao passados como se fossem parametros
//    private String producer; // voce so pode criar atributos do jeito normal se forem estaticos
    // nao pode haver tambem blocos de inicializacao normais, so estatico
    // voce pode usar Generics no Recod Class
    // voce nao pode criar construtores, um record ja o possui um gerado automaticamente
    // nao use o tempo todo, ele e para coisas simples, use para
    /**
     * DTOs (Data Transfer Objects).
     * Representar respostas de APIs.
     * Transportar dados entre camadas.
     * Representar informações de consultas ao banco de dados.
     */
}

//class Person {
//    private final String name;
//    private final int age;
//
//    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//}

// TODO voce pode reduzir tudo isso a isso aqui

//public record Person(String name, int age) {
//}