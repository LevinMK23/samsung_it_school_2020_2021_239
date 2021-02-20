public class Recursion {

    static void foo(int n) {
        if (n > 0) {
            foo(n-1);
        }
    }

    static void printFirst(int n) {
        System.out.println(n);
        if (n > 0) { // base
            printFirst(n - 1);
        }
    }

    static void printLast(int n) {
        if (n > 0) {
            printLast(n - 1);
        }
        System.out.println(n);
    }

    // 1 * 2 * 3 * ..... * n
    static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static long fib(int n) {
        System.out.print(n + " ");
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fib(5));
        fib(5);
        System.out.println();
    }
}
