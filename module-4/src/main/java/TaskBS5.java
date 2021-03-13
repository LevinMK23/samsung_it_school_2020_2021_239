import java.util.Scanner;

public class TaskBS5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();
        double d = in.nextInt();
        double l = -1e12, r = 1e12;

        if (a > 0) {
            while (r - l > 1e-6) {
                double m = (l + r) / 2;
                if (a * m * m * m + b * m * m + c * m + d > 0) {
                    r = m;
                } else {
                    l = m;
                }
            }
        } else {
            while (r - l > 1e-6) {
                double m = (l + r) / 2;
                if (a * m * m * m + b * m * m + c * m + d > 0) {
                    l = m;
                } else {
                    r = m;
                }
            }
        }
        System.out.println(l);
    }
}
