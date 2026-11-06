package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "     Luffy    ";
        System.out.println(nome.charAt(0)); //vai retorna a letra com base no indice
        System.out.println(nome.length()); //length de String e um metodo, ja o length de array e um atributo, mas ambos retornam o tamanho
        System.out.println(nome.replace("f", "l")); //percorre todoa String e troca aonde tem f por l
        System.out.println(nome.toLowerCase()); //transforma toda a String em minuscula
        System.out.println(nome.toUpperCase()); //transforma toda a String em maiuscula
        System.out.println(nome.trim()); //tira os espaços em branco do inicio e fim da String
    }
}
