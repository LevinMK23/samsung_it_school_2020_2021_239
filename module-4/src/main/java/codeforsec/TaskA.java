package codeforsec;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong(), m = in.nextLong(),
                    x = in.nextLong();
            long row = x % n == 0 ? n : x % n;
            row--;
            long col = (x + n - 1) / n;
            System.out.println(row * m + col);
        }
    }
}
