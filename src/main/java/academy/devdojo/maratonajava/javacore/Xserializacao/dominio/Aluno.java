package academy.devdojo.maratonajava.javacore.Xserializacao.dominio;

import java.io.*;

public class Aluno implements Serializable {
    @Serial
    private static final long serialVersionUID = -7122195954934564752L; //diz que que esse objeto e serializavel
    private long id;
    private String nome;
    private transient String password; //transient diz que esse atributo nao deve ser serializado
    private static final String NOME_ESCOLA = "DevDojo"; // atributos estaticos nao sao serializados, porque static pertence a classe
    private transient Turma turma;

    public Aluno(long id, String nome, String password) {
        System.out.println("Dentro do Construtor");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    // para voce serializar um objeto que nao pode ser serializavel, voce tem que escrever praticamente todos os atributos
    // daquele objeto, nos metodos writeObject e readObject
    @Serial
    private void writeObject(ObjectOutputStream oos) {
        try {
            oos.defaultWriteObject();
            oos.writeUTF(turma.getNome());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    //aqui serializamos a String turma
    private void readObject(ObjectInputStream ois) {
        try {
            ois.defaultReadObject();
            String nomeTurma = ois.readUTF();
            turma = new Turma(nomeTurma);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
