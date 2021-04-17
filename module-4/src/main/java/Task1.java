import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

class User {
    String name;
    int age;

    User(String n, int a) {
        name = n;
        age = a;
    }
}

class Main {
    public static void main(String[] args) {
        TreeSet<User> tree = new TreeSet<>(
                Comparator.comparing(o -> o.name));

        Integer [] a = {16, 28, 60, 22, 67, 54, 11};
        Arrays.sort(a, a.length/2, a.length);
        System.out.println(Arrays.toString(a));

        HashSet collection = new HashSet();
        collection.add("3");
        collection.add("21");
        collection.add("1");
        collection.add("25");

        System.out.println(collection);

    }
}
