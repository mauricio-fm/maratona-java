package academy.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Fisica"),
    PESSOA_JURIDICA(2, "Pessoa Juridica");

    private int valor;
    private String nomeRelatorio;
    TipoCliente(int valor, String nomeRelatorio) {
        this.valor = valor;
        this.nomeRelatorio = nomeRelatorio;
    }

    //Como retorna uma enum baseado nos atributos
    public static TipoCliente tipoClientePorNomeRelatorio(String nomeRelatorio) {
        for (TipoCliente tipoCliente : values()) {
            if (tipoCliente.getNomeRelatorio().equals(nomeRelatorio)) {
                return tipoCliente;
            }
        }
        return null;
    }

    /*
      Oque aconteceu aqui foi:

      1 - O método deu um values() (pegou a lista de todo mundo: PESSOA_FISICA e PESSOA_JURIDICA).

      2 - entrou no for e pegou o primeiro cara: PESSOA_FISICA.

      3 - Aí fez: tipoCliente.getNomeRelatorio(). O que tem guardado nesse atributo dentro da PESSOA_FISICA?
      A String "Pessoa Fisica".

      4 - Aí foi comparado: "Pessoa Fisica".equals("Pessoa Fisica").

      5 - Como e igual! Deu true. O método então deu um return tipoCliente;.
      Dessa forma voce cria um metodo que vai retorna com base no atributo que voce deseja.
     */

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }

    public int getValor() {
        return valor;
    }
}
