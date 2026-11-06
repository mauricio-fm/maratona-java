package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/// Serve para verificar se um caminho de um arquivo ou diretorio corresponde a um padrao que voce definiu
public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/file.bkp"); //fornece os paths dos arquivos a ser verificado
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");
        matches(path1, "glob:*.bkp"); // como um * nao atravessa diretorios, so naquele nivel, por isso retorna false
        matches(path1, "glob:**.bkp"); // com ** ele atravessa diretorios , por isso retorna true, porque o .bkp ta dentro de subpasta, mas começa a caçar em pasta
        matches(path1, "glob:**.{bkp,txt,java}"); // verifica mais de um, nao pode haver espaços entre as virgulas
        matches(path2, "glob:**.{bkp,txt,java}");
        matches(path3, "glob:**.{bkp,txt,java}");

        //tambem voce pode fazer com oque o pathMatcher seje uma variavel

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.java");
        System.out.println("isJava - " + matcher.matches(path3)); //o metodo matches() verifica se corresponde ao padrao

    }

    private static void matches(Path path, String glob) { // caminho que sera testado, glob e o padrao que sera usado para testar
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob); // cria um pathMatcher usando o padrao recebido
        System.out.println(glob + ": " + matcher.matches(path)); // imprime true se o o texto corresponde ao padrao fornecido
    }
}
