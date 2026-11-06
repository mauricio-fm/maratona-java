package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        String nome = "Mauricio Ferreira ";
        nome = nome.concat("DevDojo"); //concat() → cria outra String
        System.out.println(nome);
        StringBuilder sb = new StringBuilder("Mauricio "); //StringBuilder nao sao imultaveis, elas ja vem com o toString
        sb.append("DevDojo").append("Academy"); //append() → adiciona no StringBuilder existente.
        System.out.println(sb);
    }
}
