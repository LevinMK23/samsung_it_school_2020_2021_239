package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Shop {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            String surname = in.next();
            String number = in.next();

            String key = name + " " + surname;

            if (!map.containsKey(key)) {
                map.put(key, new HashSet<>());
            }
            map.get(key).add(number);
        }

        map.forEach((key, val) -> {
            System.out.print(key + ": ");
            String numbers = "[" +
                    String.join(", ", val) + "]";
            System.out.println(numbers);
        });
    }
}
