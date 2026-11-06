package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

/// Serve para consultar os atributos de um arquivo no sistema DOS/Windows.
public class DosFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta/teste.txt");
        if (Files.notExists(path)) Files.createFile(path);

        Files.setAttribute(path, "dos:hidden", true); // Defina o atributo hidden desse arquivo como true
        //o atributo deve ser passado em lowercase, minusculo, caso contrario da exceção, o "dos:" e obrigatorio
        Files.setAttribute(path, "dos:readonly", true);  // parametros, path = caminho, attribute, readonly nesse caso, value, true nesse caso

        Files.setAttribute(path, "dos:hidden", false);
        Files.setAttribute(path, "dos:readonly", false); //volta a como o arquivo era

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());
        System.out.println(dosFileAttributes.isArchive());
        System.out.println(dosFileAttributes.lastModifiedTime());

        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        fileAttributeView.setHidden(true);
        fileAttributeView.setReadOnly(true);
        System.out.println(fileAttributeView.readAttributes().isHidden());
        System.out.println(fileAttributeView.readAttributes().isReadOnly());
    }
}
