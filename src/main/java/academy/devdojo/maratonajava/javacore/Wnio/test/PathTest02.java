package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) {
        Path pasta2Path = Paths.get("pasta2");
        try {
            //verifica se o caminho nao existe, se nao existir retorna true e cria a pasta, se existir nao entra, ja o exists faz o contrario
            if (Files.notExists(pasta2Path)) {
                // Files e como um File moderno, usado so junto com path
                Path pastaDirectory = Files.createDirectory(pasta2Path); //createDirectory cria uma pasta por vez, se força lança uma IOException
            }
            Path subPastaPath = Paths.get("pasta/subpasta/subsupasta"); //caso o diretorio ja exista e voce rode o codigo, nao lança exceção, e nao precisa de if como o createDirectoy
            Path subPastaDirectory = Files.createDirectories(subPastaPath); //createDirectories cria varias pastas , incluindo as necessarias
            //voce pode usar o createDirectories pra criar uma unica pasta, nao vai lançar exceção se rodar mais de uma vez

            Path filePath = Paths.get(subPastaPath.toString(), "file.txt");
            if (Files.notExists(filePath)) {
                //assim como o createDirectory, voce precisa de um if para o createFile
                Path filePathCreated = Files.createFile(filePath); // essas duas linhas de cima cria um arquivo dentro da subPastaPath de cima
            }

            Path origem = filePath;
            Path destino = Paths.get(filePath.getParent().toString(), "file_renamed.txt"); // filePath.getParent Pega a pasta pai do arquivo origem
            Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING); //tambem os valores de file.txt vem junto por ser uma copia

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
