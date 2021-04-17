package codeforsec;

import java.util.HashSet;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            HashSet<String> set = new HashSet<>();
            String a = in.next(), b = in.next();
            int min = a.length() + b.length();
            for (int j = 0; j < a.length(); j++) {
                for (int k = j; k < a.length(); k++) {
                    set.add(a.substring(j, k + 1));
                }
            }
            for (int j = 0; j < b.length(); j++) {
                for (int k = j; k < b.length(); k++) {
                    String s = b.substring(j, k + 1);
                    if (set.contains(s)) {
                        min = Math.min(min, b.length() - s.length() +
                                a.length() - s.length());
                    }
                }
            }
            System.out.println(min);
        }
    }
}
