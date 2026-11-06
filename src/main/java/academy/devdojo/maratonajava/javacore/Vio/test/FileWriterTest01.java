package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/// Para escrever em arquivos
public class FileWriterTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try( FileWriter fw = new FileWriter(file)) {
            fw.write("O palmeiras nao tem mundial!!");
            fw.flush(); //força os dados que estão no buffer (uma área temporária de memória) a serem enviados para o arquivo
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
