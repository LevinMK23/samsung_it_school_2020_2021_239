package codeforsec;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt(), k = in.nextInt();
            char[] c = in.next().toCharArray();
            int cnt = 1, l = 0, r = n - 1;
            for (int j = 0; j < n; j++) {
                if (c[j] == '*') {
                    l = j;
                    break;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (c[j] == '*') {
                    r = j;
                    break;
                }
            }

            for (int j = l; j < r; j += k) {
                if (c[j] == '.') {
                    j--;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
