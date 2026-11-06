package academy.devdojo.maratonajava.projetos.duvidas.test;

import academy.devdojo.maratonajava.projetos.duvidas.dominio.Computer;

public class BuilderTest {
    public static void main(String[] args) {
        Computer computador = Computer.ComputadorBuilder
                .builder()
                .processador("AMD RYZEN 5600")
                .memoriaRam(32)
                .armazenamento(456)
                .placaDeVideo("RX6600")
                .build();
        System.out.println(computador);
    }
}
