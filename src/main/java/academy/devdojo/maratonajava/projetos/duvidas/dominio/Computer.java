package academy.devdojo.maratonajava.projetos.duvidas.dominio;

public class Computer {
    private final String processador;
    private final int memoriaRam;
    private final int armazenamento;
    private final String placaDeVideo;

    public Computer(String processador, int memoriaRam, int armazenamento, String placaDeVideo) {
        this.processador = processador;
        this.memoriaRam = memoriaRam;
        this.armazenamento = armazenamento;
        this.placaDeVideo = placaDeVideo;
    }

    @Override
    public String toString() {
        return "Computador{" +
                "processador='" + processador + '\'' +
                ", memoriaRam=" + memoriaRam +
                ", armazenamento=" + armazenamento +
                ", placaDeVideo='" + placaDeVideo + '\'' +
                '}';
    }

    public static final class ComputadorBuilder {
        private String processador;
        private int memoriaRam;
        private int armazenamento;
        private String placaDeVideo;

        private ComputadorBuilder() {
        }

        public static ComputadorBuilder builder() {
            return new ComputadorBuilder();
        }

        public ComputadorBuilder processador(String processador) {
            this.processador = processador;
            return this;
        }

        public ComputadorBuilder memoriaRam(int memoriaRam) {
            this.memoriaRam = memoriaRam;
            return this;
        }

        public ComputadorBuilder armazenamento(int armazenamento) {
            this.armazenamento = armazenamento;
            return this;
        }

        public ComputadorBuilder placaDeVideo(String placaDeVideo) {
            this.placaDeVideo = placaDeVideo;
            return this;
        }

        public Computer build() {
            return new Computer(processador, memoriaRam, armazenamento, placaDeVideo);
        }
    }
}
