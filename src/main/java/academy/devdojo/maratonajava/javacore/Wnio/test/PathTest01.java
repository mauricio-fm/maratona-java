package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

/// Paths é uma classe usada para criar objetos Path, o path diz aonde e o paths diz como criar o caminho e o File diz oque fazer (pasta,arquivo)
/// ao inves de usar o file pra fazer tudo usa os tres
public class PathTest01 {
    public static void main(String[] args) {
        Path p1 = Paths.get("C:\\Programação\\Java\\file.txt");
        Path p2 = Paths.get("C:\\Programação\\Java", "file.txt");
        Path p3 = Paths.get("C:", "\\Programação\\Java", "file.txt");
        Path p4 = Paths.get("C:", "Programação", "Java", "file.txt"); //ambos pegam o mesmo path, so sao maneiras diferente
        System.out.println(p1.getFileName());
        System.out.println(p2.getFileName());
        System.out.println(p3.getFileName());
        System.out.println(p4.getFileName());

    }
}
