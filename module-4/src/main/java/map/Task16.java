package map;

import java.util.Scanner;
import java.util.TreeMap;

public class Task16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();
        while (in.hasNextLine()) {
            String[] data = in.nextLine().split(" ");
            String name = data[0];
            String product = data[1];
            int price = Integer.parseInt(data[2]);
            if (!map.containsKey(name)) {
                map.put(name, new TreeMap<>());
            }
            int total = map.get(name).getOrDefault(product, 0);
            map.get(name).put(product, total + price);
        }
        map.forEach((name, productMap) -> {
            System.out.println(name + ":");
            productMap.forEach((product, price) -> {
                System.out.println(product + " " + price);
            });
        });
    }
}
