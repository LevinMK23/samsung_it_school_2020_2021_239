import java.util.LinkedList;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Test {

    public static int[] generate(int limit, int bound) {
        int[] a = new int[limit];
        for (int i = 0; i < limit; i++) {
            a[i] = (int) (Math.random() * bound);
        }
        return a;
    }

    public static void searchWithList() {
        long start = System.currentTimeMillis();
        int[] data = generate(1000000, 1000);
        int[] find = generate(1000000, 1000);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : data) {
            list.add(i);
        }
        for (int i : find) {
            list.contains(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    public static void searchWithTree() {
        long start = System.currentTimeMillis();
        int[] data = generate(1000000, 1000);
        int[] find = generate(1000000, 1000);
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i : data) {
            tree.add(i);
        }
        for (int i : find) {
            tree.contains(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("time: " + (end - start));
    }

    public static void main(String[] args) {
        BST<Integer> tr = new BST<>();
        for (int i = 0; i < 15; i++) {
            tr.add((int) (Math.random() * 1000));
        }
        tr.forEach(v -> System.out.print(v + " "));
        System.out.println();
        for (int i = 0; i < 15; i++) {
            System.out.println(tr.getKOrder(i + 1));
        }
    }
}
