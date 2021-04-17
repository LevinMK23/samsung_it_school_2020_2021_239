package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

    static int getRnd() {
        return (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a[i] = getRnd();
        }
        System.out.println(Arrays.toString(a));
        Arrays.sort(a, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(a));

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("IPhone12 PRO", 100500, 1));
        products.add(new Product("IPhone12 PRO", 5000, 1000));
        products.add(new Product("IPhone12 PRO", 5000, 500));
        products.add(new Product("IPhone12 PRO", 15000, 7));

        System.out.println(products);

        products.sort((o1, o2) -> {
            int title = o1.getTitle().compareTo(o2.getTitle());
            if (title == 0) {
                int price = o2.getPrice() - o1.getPrice();
                if (price == 0) {
                    return o2.getCount() - o1.getCount();
                }
                return price;
            }
            return title;
        });

        System.out.println(products);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(getRnd());
        }

        list = MergeSort.sort(list);
        // System.out.println(list);
        System.out.println(MergeSort.cnt);
    }
}
