import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.print(a[a.length-1] + " ");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
