package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>(); // o Queue e como uma fila em java
        fila.add("C");
        fila.add("B");
        fila.add("A");

        while(!fila.isEmpty()) {
            System.out.println(fila.poll());
        }

    }
}
