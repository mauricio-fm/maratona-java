package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

///Normalização significa limpar um caminho, removendo partes desnecessárias
public class NormalizeTest01 {
    public static void main(String[] args) {
        String diretorioProjeto = "home/mauricio/dev";
        String arquivoTxt = "../../arquivo.Txt";
        Path path1 = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(path1);
        System.out.println(path1.normalize());
        Path path2 = Paths.get("/home/./mauricio/./dev/");
        System.out.println(path2);
        System.out.println(path2.normalize());
    }
}
