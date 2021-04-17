import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TaskStack1 {

    static boolean needProcess(ArrayList<Integer> list) {
        int cnt = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                cnt++;
                if (i == list.size() - 2) {
                    if (cnt >= 3) {
                        return true;
                    }
                }
            } else {
                if (cnt >= 3) {
                    return true;
                }
                cnt = 1;
            }
        }
        return false;
    }


    private static void process(ArrayList<Integer> list) {
        int cnt = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(list.get(i + 1))) {
                cnt++;
                if (i == list.size() - 2) {
                    if (cnt >= 3) {
                        int pos = i - cnt + 2;
                        for (int j = 0; j < cnt; j++) {
                            list.remove(pos);
                        }
                        return;
                    }
                }
            } else {
                if (cnt >= 3) {
                    int pos = i - cnt + 1;
                    for (int j = 0; j < cnt; j++) {
                        list.remove(pos);
                    }
                    return;
                }
                cnt = 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            int value = it.next();
            it.remove();
        }

        while (needProcess(list)) {
            process(list);
        }
        System.out.println(n - list.size());

    }
}
