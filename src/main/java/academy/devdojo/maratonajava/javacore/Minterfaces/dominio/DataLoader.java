package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public interface DataLoader {
    //Voce pode declarar atributos em interfaces mas por padrao sao public static final, coloque so o tipo nome e valor.
    int MAX_DATA_SIZE = 10;

    void load();

    default void checkPermission() {
        System.out.println("Fazendo checagem de permissões...");
    }
    /*
     um metodo concreto que nao precisa ser obrigatoriamete implementado, se ele nao for implementado
     mas for chamado ele execulta essa mensagem acima.
     */
}
