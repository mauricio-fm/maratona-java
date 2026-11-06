package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

/// Relativize serve para saber como chegar a classe dado o diretorio, aonde o OlaMundo.java se encontra
public class RelativizeTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/mauricio");
        Path classe = Paths.get("/home/mauricio/java/OlaMundo.java");
        Path pathToClasse = dir.relativize(classe); //se eu tiver no /home/mauricio como chego no OlaMundo.java
        System.out.println(pathToClasse);

        Path absoluto1 = Paths.get("/home/mauricio");
        Path absoluto2 = Paths.get("/user/local");
        Path absoluto3 = Paths.get("/home/mauricio/java/OlaMundo.java");
        Path relativo2 = Paths.get("temp");
        Path relativo1 = Paths.get("temp/temp.20269");

        System.out.println("1 " + absoluto1.relativize(absoluto3));
        System.out.println("2 " + absoluto3.relativize(absoluto1));
        System.out.println("3 " + absoluto1.relativize(absoluto2));
        System.out.println("4 " + relativo1.relativize(relativo2));
        System.out.println("5 " + relativo2.relativize(relativo1));
    }
}
