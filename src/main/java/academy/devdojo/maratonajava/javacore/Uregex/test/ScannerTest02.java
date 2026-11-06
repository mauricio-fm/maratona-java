package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Scanner;

/// Tokens e Delimitadores
public class ScannerTest02 {
    public static void main(String[] args) {
        String texto = "Levi,Eren,Mikasa,true,200";
        Scanner scanner = new Scanner(texto); //o delimitador padrao de Scanner e um espaço em branco
        scanner.useDelimiter(","); //troca o delimitador
        while (scanner.hasNext()) { //enquanto existir um proximo scanner
            if (scanner.hasNextInt()) { //verifica se o proximo valor disponivel e int
                int i = scanner.nextInt();
                System.out.println("Int " + i);
            } else if (scanner.hasNextBoolean()) {
                boolean b = scanner.nextBoolean();
                System.out.println("Boolean " + b);
            } else {
                System.out.println(scanner.next());
            }
        }
    }
}
