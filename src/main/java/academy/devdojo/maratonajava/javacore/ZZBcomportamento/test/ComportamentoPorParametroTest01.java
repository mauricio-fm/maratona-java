package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Car> cars = List.of(new Car("red", 2001), new Car("gray", 2007), new Car("black", 2019));

    public static void main(String[] args) {
        System.out.println(filterRedCar(cars)); // carros vermelhos
        System.out.println(filterBlackColor(cars)); // carros pretos
        System.out.println(filterCarByColor(cars, "gray")); // todos os carros cinzas
        System.out.println("----");
        System.out.println(filterByYearBefore(cars, 2015)); // filtra todos os carros antes de 2015
    }

    private static List<Car> filterRedCar(List<Car> cars) { // esse metodo filtra carros vermelhos da lista cars
        List<Car> filterCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("red")) {
                filterCars.add(car);
            }
        }
        return filterCars;

    }

    private static List<Car> filterBlackColor(List<Car> cars) {
        List<Car> filterCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("black")) {
                filterCars.add(car);
            }
        }
        return filterCars;

    }

    private static List<Car> filterCarByColor(List<Car> cars, String color) {
        List<Car> filterCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(color)) {
                filterCars.add(car);
            }
        }
        return filterCars;

    }

    private static List<Car> filterByYearBefore(List<Car> cars, int year) {
        List<Car> filterCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < year) { // a unica coisa que muda desses 4 metodos e so a condição do if
                filterCars.add(car);
            }
        }
        return filterCars;

    }
}
