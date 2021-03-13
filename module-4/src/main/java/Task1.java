import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        int prev = in.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int cur = in.nextInt();
            if (cur > prev) {
                cnt++;
            }
            prev = cur;
        }
        System.out.println(cnt);
    }
}
