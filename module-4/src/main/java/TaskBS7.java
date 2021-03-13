import java.util.Scanner;

public class TaskBS7 {

    static boolean canCut(int[] a, int k, int len) {
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            cnt += a[i] / len;
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int l = 0, r = 1000000000;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (canCut(a, k, m)) {
                l = m;
            } else {
                r = m;
            }
        }
        System.out.println(l);
    }
}
