package map;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        String s = "a b c d a a a b b c";
        String[] strings = s.split(" +");
        for (String string : strings) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        System.out.println(map);

        HashMap<String, Set<String>> nums = new HashMap<>();
        nums.put("Ivan", new HashSet<>());
        nums.get("Ivan").add("88888888");
        nums.get("Ivan").add("123124124");
        nums.put("Oleg", new HashSet<>());
        nums.get("Oleg").add("1243124");
        nums.get("Oleg").add("1213312");

        for (Map.Entry<String, Set<String>> entry : nums.entrySet()) {
            System.out.print(entry.getKey() + ": [");
            for (String num : entry.getValue()) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }

        nums.forEach((name, numbers) -> {
            System.out.print(name + ": ");
            numbers.forEach(num -> System.out.print(num + " "));
            System.out.println();
        });

    }
}
