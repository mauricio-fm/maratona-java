package academy.devdojo.maratonajava.projetos.bancodedados.dominio;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Produto {
    Integer id;
    String name;
    Integer price;
}
