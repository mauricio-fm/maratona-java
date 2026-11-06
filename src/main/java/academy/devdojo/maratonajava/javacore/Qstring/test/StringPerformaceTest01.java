package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringPerformaceTest01 {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatString(100_000); //voce pode usar _  para separar
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para a String " + (fim - inicio) + "ms");

        inicio = System.currentTimeMillis();
        concatStringBuilder(10_000_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para a StringBuilder " + (fim - inicio) + "ms");
    }

    private static void concatString(int tamanho) {
        String texto = "";
        for (int i = 0; i < tamanho; i++) {
            texto += i;
        }
    }

    private static void concatStringBuilder(int tamanho) {
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }
}
