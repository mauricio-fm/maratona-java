package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

///permite trabalhar diretamente com arquivos
public class FileTest01 {
    public static void main(String[] args) {
        File file = new File("C:\\Programação\\Java\\arquivo\\file.txt"); //para salvar em um lugar especifico voce coloca o caminho absoluto
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created " + isCreated);
            System.out.println("path " + file.getPath()); //pega path
            System.out.println("absoulte path " + file.getAbsolutePath()); //pega path absoluto
            System.out.println("is directory " + file.isDirectory()); // e diretorio
            System.out.println("is file " + file.isFile()); //e uma arquivo
            System.out.println("is hiddens " + file.isHidden()); // e oculto
            System.out.println("last modified " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDate()); //quando foi a ultima modificação
            boolean exists = file.exists(); //verifica se um arquivo existe
            if (exists) {
                System.out.println("Deleted " + file.delete());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
