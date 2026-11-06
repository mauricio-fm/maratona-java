package academy.devdojo.maratonajava.javacore.ZZJcrud.test;

import academy.devdojo.maratonajava.javacore.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true) {
            producerMenu();
            System.out.print("Type here your -> ");
            op = Integer.parseInt(SCANNER.nextLine());
            if (op == 0) break;
            ProducerService.menu(op);
        }
    }

    private static void producerMenu() {
        System.out.println("\nType the number of your operation");
        System.out.println("  0 - Exit");
        System.out.println("  1 - Search for producer");
        System.out.println("  2 - Delete producer");
        System.out.println("  3 - Save producer");
        System.out.println("  4 - Update producer");
    }
}
