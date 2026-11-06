package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public class FileLoader implements DataLoader, DataRemover{
    @Override
    public void load() {
        System.out.println("Carregando dados de um arquivo...");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados do arquivo...");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões dos arquivos...");
    }
}
