package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("home/mauricio");
        Path arquivo = Paths.get("dev/arquivo.txt");
        Path resolve = dir.resolve(arquivo); //junta dois path, mas nao pode ser de relativo pra absoluto, so absoluto pra relativo
        System.out.println(resolve);

        Path absoluto = Paths.get("home/mauricio");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        System.out.println("1 " + absoluto.resolve(relativo));
        System.out.println("2 " + absoluto.resolve(file));
        System.out.println("3 " + relativo.resolve(absoluto));
        System.out.println("4 " + relativo.resolve(file));
        System.out.println("5 " + file.resolve(absoluto)); //quando o caminho e absoluto, retorna o proprio caminho, poís nao tem oque resolver
        System.out.println("6 " + file.resolve(relativo));
    }
}
