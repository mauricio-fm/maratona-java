package academy.devdojo.maratonajava.javacore.Xserializacao.test;

import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Aluno;
import academy.devdojo.maratonajava.javacore.Xserializacao.dominio.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/// Serialização e converter um objeto em formato linear (como um fluxo de bytes ou texto, um JSON ou TXT)
public class SerializationTest01 {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(4512L, "Mauricio", "115120165156");
        Turma turma = new Turma("Maratona Java");
        aluno.setTurma(turma);
        serializar(aluno);
        desserializar();
    }

    // --- SERIALIZAÇÃO (Salvar no arquivo TXT) ---
    private static void serializar(Aluno aluno) {
        Path path = Paths.get("pasta/aluno.ser"); //cria uma referencia para o arquivo aonde os dados vao ser salvo
        //o  new ObjectOutputStream envolve esse OutputStream e adiciona a capacidade de de escrever objetos java
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) { // cria um OutputStream  para escrever bytes no arquivo
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Serialização concluida");
    }

    // --- DESSERIALIZAÇÃO (Ler do arquivo TXT e recriar o objeto) --
    private static void desserializar() {
        Path path = Paths.get("pasta/aluno.ser");
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            Aluno aluno = (Aluno) ois.readObject();
            System.out.println(aluno);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Desserialização concluida");
    }
}
