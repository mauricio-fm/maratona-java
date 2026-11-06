package academy.devdojo.maratonajava.javacore.Ycolecoes.dominio;

public class Smartphone {
    private String serialNumber;
    private String marca;

    public Smartphone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    // Regras de implementação equals
    // Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
    // Simetrico: para x e y diferentes de null, se x.equals(y)  == true logo, y.equals(x) == true
    // Transitividade: para x,y,z diferentes de null, se x.equals(y) == true, e x.equals(z) == true logo, y.equals(z) == true
    // Consistente: x.equals(x) sempre retorna true se x for diferente de null
    // para x diferente de null, x.equals(null) tem que retorna false
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false; // se o objeto recebido for null retorne falso
        // this representa o objeto atual, o objeto que chamou o método equals()
        if (this == obj) return true; // se this (o objeto atual) for igual ao objeto recebido retorne true
        if (this.getClass() != obj.getClass()) return false; // se os dois objetos não são exatamente da mesma classe retorne false
        Smartphone smartphone = (Smartphone) obj; // converte o objeto para um smartphone para conseguir acessar smartphone.serialNumber
        return serialNumber != null && serialNumber.equals(smartphone.serialNumber); // serialNumber nao pode ser null e serialNumber precisa ser igual ao serialNumber de outro smartphone
    }

    // Regras de implementação hashCode
    // o equals e hashCode devem estar em sintonia, por exemplo, se voce usa serialNumber como valor de equals, voce tambem precisa usar ele para gerar o hashCode, se nao voce gera hash diferente
    // se x.equals(y)  == true, y.hashCode() == x.hashCode()
    // se voce tem y.hashCode() == x.hashCode() não significa que o equals de y.equals(x) tem que ser true (retorna a mesma coisa)
    // x.equals(y) == false o hashCode tem que ser diferente
    // y.hashCode() != x.hashCode() x.equals(y) devera ser false
    @Override
    public int hashCode() {
        // operador ternario
        // resultado = (condicao) ? valorSeVerdadeiro : valorSeFalso;
        return serialNumber == null ? 0 : this.serialNumber.hashCode(); // se serialNumer for null, retorne false, caso contrario retorne o hashCode do serialNumber do objeto atual
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
