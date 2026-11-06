package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) {
        Path path = Paths.get("pasta2/new.txt");
        try {
            BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class); // BasicFileAttributes guarda informações do arquivo
            FileTime creationTime = basicFileAttributes.creationTime(); // quando foi criado
            FileTime lastAccessTime = basicFileAttributes.lastAccessTime(); //quando foi acessado pela ultima vez
            FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime(); //quando foi modificado pela ultima vez

            System.out.println("creationTime " + creationTime);
            System.out.println("lastAccessTime " + lastAccessTime);
            System.out.println("lastModifiedTime " + lastModifiedTime);
            System.out.println("--------------------");

            BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class); //obetem a visao basica dos atributos do arquivo
            FileTime nowCreationTime = FileTime.fromMillis(System.currentTimeMillis()); // pega a tempo atual
            fileAttributeView.setTimes(lastModifiedTime, nowCreationTime, creationTime); //muda a data

            creationTime = fileAttributeView.readAttributes().creationTime();
            lastAccessTime = basicFileAttributes.lastAccessTime();
            lastModifiedTime = basicFileAttributes.lastModifiedTime();

            System.out.println("creationTime " + creationTime);
            System.out.println("lastAccessTime " + lastAccessTime);
            System.out.println("lastModifiedTime " + lastModifiedTime);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Tudo oque tem view (BasicFileAttributeView, FileAttributeView) permite, acessar e am alguns casos alterar atributos
    }
}
