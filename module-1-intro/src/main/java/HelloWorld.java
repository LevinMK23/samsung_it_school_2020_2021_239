public class HelloWorld {

    public int x = 7;
    public String s = "123";

    public int funcForTest(int param) {
        return param + 1;
    }

    static void calc(String s, String o) {
        int start = 0, ans = 0;
        while (start < s.length()) {
            start = s.indexOf(o, start);
            start++;
            if (start != 0) {
                ans++;
            } else {
                break;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        calc("1234567234", "234");
    }
}
