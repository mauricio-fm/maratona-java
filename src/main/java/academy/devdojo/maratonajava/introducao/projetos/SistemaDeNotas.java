package academy.devdojo.maratonajava.introducao.projetos;

public class SistemaDeNotas {
    public static void main(String[] args) {

        int[] notas = {8, 5, 10, 7, 3, 9};

        for (int nota : notas) {
            System.out.println("Nota: " + nota);
        }

        int soma = 0;

        for (int i = 0; i < notas.length; i++) {
            soma += notas[i];

        }
        System.out.println("Soma: " + soma);

        int quantidadeNotas = 6;
        int media = soma / quantidadeNotas;

        System.out.println("Media da nota: " + media);

        int maior = notas[0];
        int indiceMaior = 0;

        for (int i = 0; i < notas.length; i++) {

            if (notas[i] > maior) {
                maior = notas[i];
                indiceMaior = i;
            }

        }
        System.out.println("Maior nota: " + maior);
        System.out.println("Indice maior nota: " + indiceMaior);

        int menor = notas[0];

        for (int i = 0; i <notas.length ; i++) {
            if (notas[i] < menor) {
                menor = notas[i];
            }
        }
        System.out.println("Menor nota: " + menor);

        int aprovados = 0;

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 6) {
                aprovados++;
            }
        }
        System.out.println("Aprovados: " + aprovados);
    }
}
