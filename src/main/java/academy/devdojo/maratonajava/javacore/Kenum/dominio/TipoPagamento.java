package academy.devdojo.maratonajava.javacore.Kenum.dominio;

public enum TipoPagamento {
    DEBITO(1, "Debito") {
        @Override
        public double calcularDesconto(double valor) { //aqui estamos sobrescrevendo o metodo abstract calcularDesconto.
            return valor * 0.1; //aqui estamos dando um valor ao desconto de 10%
        }
    },
    CREDITO(2, "Credito") {
        @Override
        public double calcularDesconto(double valor) { //tambem sobrescrevendo o metodo calcularDesconto
            return valor * 0.05; //aqui estamos dando um valor ao desconto de 5%
        }
    };

    private final int valor;
    private final String nomeRelatorio;

    TipoPagamento(int valor, String nomeRelatorio) {
        this.valor = valor;
        this.nomeRelatorio = nomeRelatorio;
    }

    public abstract double calcularDesconto(double valor);
    /*Aqui oque voce ta dizendo nesse abstract é Todo TipoPagamento deve ter um método calcularDesconto, mas eu não
    vou implementar esse método aqui.*/

    //Ou seja, existe a obrigação de ter esse método, mas cada constante do enum decide como implementá-lo.

    /*O Java não teria como saber que todo tipo de pagamento precisa implementar esse método.
    O abstract obriga cada constante a criar sua própria versão.*/

    public int getValor() {
        return valor;
    }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }
}
