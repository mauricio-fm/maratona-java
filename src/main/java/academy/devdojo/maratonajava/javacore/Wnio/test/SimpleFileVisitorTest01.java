package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListJavaTimes extends SimpleFileVisitor<Path> { // cria um visitante que trabalha com path
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) { // visita o arquivo, file = caminho do arquivo atual, attrs = informações sobre esse arquivo
        if (file.getFileName().toString().endsWith(".java")) { //verifica se a terminação do arquivo e .java, se sim imprime o nome
            System.out.println(file.getFileName());
        }

        // voce pode fazer a verificação com o PathMatcher
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");
        if (matcher.matches(file.getFileName())) {
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE; // continua percorrendo quando o java encontra o arquivo
    }
}

/// percorre o diretório e entra nas subpastas, podendo chegar a todos os arquivos da árvore.
public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {
        Path root = Paths.get("."); // pasta atual
        ListJavaTimes visitante = new ListJavaTimes();
        Files.walkFileTree(root, visitante); // Comece em root e percorra toda a árvore de arquivos usando ListAllFiles como visitante.
    }
}
