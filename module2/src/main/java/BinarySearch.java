public class BinarySearch {

    public static void main(String[] args) {
        double x = 2;
        double left = 0, right = 2;
        while (right - left > 0.00000000000001) {
            double mid = (left + right) / 2;
            if (mid * mid > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        System.out.println(left);
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(bs(a, 3));
        System.out.println(bs(a, 8));
        System.out.println(bs(a, 1));
        System.out.println(bs(a, 10));
        System.out.println(bs(a, -3));
        System.out.println(bs(a, 30));
    }

    static int bs(int[] a, int key) {
        int l = -1, r = a.length;
        while (r - l > 1) {
            int m = (l + r) / 2;
            if (a[m] == key) {
                return m;
            } else if (a[m] > key) {
                r = m;
            } else {
                l = m;
            }
        }
        return -1;
    }
}
