package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;
import academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(new Car("red", 2001), new Car("gray", 2007), new Car("red", 2019), new Car("black", 2026), new Car("black", 2019));

    public static void main(String[] args) {
//        List<Car> redCars = filter(cars, new CarPredicate() {
//            @Override
//            public boolean test(Car car) {
//                return car.getColor().equals("red");
//            }
//        });

        List<Car> redCars = filter(cars, car -> car.getColor().equals("red")); // todo o codigo da classe anonima acima, e substituido por uma unica linha, graças as lambdas
        List<Car> blackCars = filter(cars, car -> car.getColor().equals("black"));
        List<Car> yearBeforeCars = filter(cars, car -> car.getYear() < 2015);

        for (Car redCar : redCars) {
            System.out.println(redCar);
        }

        for (Car blackCar : blackCars) {
            System.out.println(blackCar);
        }

        System.out.println(yearBeforeCars);


    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filterCar.add(car);
            }
        }
        return filterCar;

    }
}
