package academy.devdojo.maratonajava.javacore.ZZJcrud.dominio;

import lombok.Builder;
import lombok.Value;

@Value // deixa a classe imutavel
@Builder // cria um Builder para criacao de objetos
public  class Producer {
    Integer id;
    String name;
}
