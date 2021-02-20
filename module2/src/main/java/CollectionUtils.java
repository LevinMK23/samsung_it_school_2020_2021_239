import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

public class CollectionUtils {
    public static void main(String[] args) {

        Collection<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();

        ConcurrentLinkedDeque<Integer> cl = new ConcurrentLinkedDeque<>();


        // очередь и стек

//        new Thread(() -> {
//            while (true) {
//                try {
//
//                    Integer value = ll.pollLast();
//                    if (value != null) {
//                        processValue(value);
//                    } else {
//                        // System.out.println("Waiting values...");
//                    }
//
//                    TimeUnit.MILLISECONDS.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        Scanner in = new Scanner(System.in);
//        System.out.println("Add values for process.....");
//        while (in.hasNext()) {
//            int value = in.nextInt();
//
//            ll.add(value);
//
//            System.out.println("value " + value + " added to processor queue");
//        }

        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < 20; i++) {
            ts.add((int) (Math.random() * 100));
        }
        System.out.println(ts);
        System.out.println(ts.size());
        Iterator<Integer> iterator = ts.iterator();
        int cnt = 0;
        while (true) {
            int value = iterator.next();
            cnt++;
            if (cnt == 5) {
                System.out.println(value);
                break;
            }
        }
    }

    static void processValue(Integer value) {

        value++;
        System.out.println("processed value incremented: " + value);

    }
}
