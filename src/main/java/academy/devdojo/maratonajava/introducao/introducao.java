package academy.devdojo.maratonajava.introducao;

public class introducao {
    public static void main(String[] args) {

        byte cargaHoraria = 9;
        char validacaoDoCliente = 'B';

        double salarioFixo = 1800;
        double salarioDescontado = 1000;

        if (cargaHoraria >= 20 || validacaoDoCliente == 'B') {
            System.out.println(salarioFixo);
        } else {
            System.out.println(salarioDescontado);
        }

        //Array

        //Declaração com alocação de tamanho
        int[] idades = new int[2];

        idades[0] = 15;
        idades[1] = 20;

        System.out.println(idades[0]);

        // Declaração com inicialização direta

      //tipo  nome     valores
        int[] idade = {1, 2, 3, 4};

        String[] nomesFamilia = {"mauricio", "allana", "allesandro", "maisa"};

        System.out.print("nomes da familia ");
        for (String nome : nomesFamilia) {
            System.out.print(nome + ", ");
        }

        //Imprimindo array com for

        String[] nomes = new String[3];

        nomes[0] = "\nGoku";
        nomes[1] = "Vegeta";
        nomes[2] = "Luffy";

        for (int i = 0; i < nomes.length; i++) {
            System.out.println(nomes[i]);
        }
        //Isso tambem funciona para o Array, Declaração com inicialização direta

        for (int i = 0; i < idade.length; i++) {
            System.out.println(idade[i]);
        }

        //Alem disso tambem podemos imprimir um Array com foreach

        for (int num : idade) {
            System.out.println(num);
        }
    }
}



