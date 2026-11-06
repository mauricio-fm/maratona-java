package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Locale.filter;

public class ComportamentoPorParametroTest03 {
    private static List<Car> cars = List.of(new Car("red", 2001), new Car("gray", 2007), new Car("red", 2019), new Car("black", 2026), new Car("black", 2019));

    public static void main(String[] args) {

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

        List<Integer> nums = List.of(1,2,3,4,5,6,7,8,9,10);
        //                        pega a list,  variavel -> pega a variavel e ve se o resto da divisao por 2 e igual a 0
        System.out.println(filter(nums, num -> num % 2 == 0)); // filtra os numeros pares


    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) { // metodo estatico do tipo (que sera passado) com um retorno em lista com um tipo que vai ser passado
        List<T> filteredList = new ArrayList<>(); // cria uma lista de itens filtrados com o tipo que sera passado
        for (T e : list) { // esse for está percorrendo uma lista e colocando em outra lista apenas os elementos que passam por uma condição.
            if (predicate.test(e)) {
                filteredList.add(e);
            }
        }
        return filteredList;
    }

}
