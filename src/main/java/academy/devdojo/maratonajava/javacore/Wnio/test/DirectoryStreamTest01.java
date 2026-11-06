package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/// DirectoryStream → percorre os itens diretos do diretório indicado
public class DirectoryStreamTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("."); // o ponto pega o caminho do diretorio atual
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){ // // Cria um fluxo para listar os itens do diretório
            for (Path path : stream) { // path representa cada item encontrado
                System.out.println(path.getFileName()); // imprime o nome dos itens no terminal
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
