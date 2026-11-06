package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
//        Map<Integer, String> map = new HashMap<>(); // voce usa wrapper em maps
        Map<String, String> map = new HashMap<>();
//        Map<String, String> map = new LinkedHashMap<>(); // mantem a ordem de inserção
        map.put("teklado", "teclado"); // no map usa o metodo put para adicionar, e nao add
        map.put("mouze", "mouse");
        map.put("vc", "você"); // se voce tem dois chaves e valores extamente igual, o put nao vai deixar adicionar, se o valor e diferente ele sobrescreve oque ja atem
        map.put("vc", "você"); // se voce usa putItAbsent, ele adiona se nao existir
        System.out.println(map);

        for (String key : map.keySet()) { // o metodo KeySet imprime as chaves de um map
            System.out.println(key + " : " + map.get(key)); // map.get(key) imprime os valores
        }
        System.out.println("---------------");

        for (String value : map.values()) { // o metodo values imprime os valores de um map separadamente
            System.out.println(value);
        }
    }
}
