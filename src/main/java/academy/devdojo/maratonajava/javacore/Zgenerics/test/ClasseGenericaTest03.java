package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("Mustang"), new Carro("Porsche GT3")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));
        RentalService<Carro> rentalServiceCarro =  new RentalService<>(carrosDisponiveis); // esse T agora vira o tipo que sera trabalhado, nesse caso, Carro
        Carro carro = rentalServiceCarro.buscarObjetoDisponiveis();
        System.out.println("Usando carro por um mês...");
        rentalServiceCarro.retornaObjetoAlugado(carro);

        System.out.println("-----------------");

        RentalService<Barco> rentalServiceBarco =  new RentalService<>(barcosDisponiveis); // esse T agora vira o tipo que sera trabalhado, nesse caso, Carro
        Barco barco = rentalServiceBarco.buscarObjetoDisponiveis();
        System.out.println("Usando barco por um mês...");
        rentalServiceBarco.retornaObjetoAlugado(barco);


    }
}
