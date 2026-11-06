package academy.devdojo.maratonajava.projetos.sistemapedidos.dominio;

public enum Status  {
    PENDING("PENDING"),
    FINISHED("FINISHED");

    private final String label;

    Status(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
