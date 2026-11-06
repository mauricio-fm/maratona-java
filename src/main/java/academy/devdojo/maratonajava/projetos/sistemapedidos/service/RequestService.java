package academy.devdojo.maratonajava.projetos.sistemapedidos.service;

import academy.devdojo.maratonajava.projetos.duvidas.dominio.PaymentMethod;
import academy.devdojo.maratonajava.projetos.sistemapedidos.dominio.Products;
import academy.devdojo.maratonajava.projetos.sistemapedidos.dominio.Status;

public class RequestService {
    private Products product;
    private double price;
    private Status status;
    private PaymentMethod paymentMethod;
    private String clientName;

    public RequestService(Products product, double price, Status status, String clientName, PaymentMethod paymentMethod) {
        this.product = product;
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("The price cannot be negative");
        }
        this.status = status;
        this.clientName = clientName;
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "RequestService{" +
                "product=" + product +
                ", price=" + price +
                ", status=" + status +
                ", paymentMethod=" + paymentMethod +
                ", clientName='" + clientName + '\'' +
                '}';
    }

    public Products getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public String getClientName() {
        return clientName;
    }
}
