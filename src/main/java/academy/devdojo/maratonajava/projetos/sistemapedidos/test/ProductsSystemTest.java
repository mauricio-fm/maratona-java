package academy.devdojo.maratonajava.projetos.sistemapedidos.test;

import academy.devdojo.maratonajava.projetos.duvidas.dominio.PaymentMethod;
import academy.devdojo.maratonajava.projetos.sistemapedidos.dominio.Products;
import academy.devdojo.maratonajava.projetos.sistemapedidos.dominio.Status;
import academy.devdojo.maratonajava.projetos.sistemapedidos.service.RequestService;

import java.util.ArrayList;
import java.util.List;

public class ProductsSystemTest {
    public static void main(String[] args) {
        List<RequestService> requests = new ArrayList<>();
        requests.add(new RequestService(Products.COMPUTER, 15000, Status.PENDING, "Mauricio", PaymentMethod.PIX));
        requests.add(new RequestService(Products.PHONE, 7000, Status.FINISHED, "Carlos", PaymentMethod.CREDIT_CARD));
        requests.add(new RequestService(Products.TABLE, 600, Status.FINISHED, "ChatGpt", PaymentMethod.TICKET));
        requests.add(new RequestService(Products.TELEVISION, 3500, Status.PENDING, "Goku", PaymentMethod.PIX));
        requests.add(new RequestService(Products.PS5, 4500, Status.PENDING, "Kuririn", PaymentMethod.CREDIT_CARD));

        System.out.println("Novo pedido: " + requests.get(0));

        System.out.println("============");
        double sum = requests.stream()
                .mapToDouble(RequestService::getPrice)
                .sum();
        System.out.println("Total sum of products: " + sum);

        System.out.println("==========");
        System.out.println("All pending products");
        requests.stream()
                .filter(r -> r.getStatus() == Status.PENDING)
                .forEach(System.out::println);

        System.out.println("================");
        findRequestsByClient(requests, "ChatGpt");
    }

    private static void findRequestsByClient(List<RequestService> requests, String clientName) {
        requests.stream()
                .filter(r -> r.getClientName().equalsIgnoreCase(clientName))
                .forEach(System.out::println);
    }
}
