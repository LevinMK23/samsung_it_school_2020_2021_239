import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class TaskStack1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<Integer> stack = new LinkedList<>();
        Stack<Integer> counters = new Stack<>();
        int ans = 0, cnt = 0;
        while (in.hasNext()) {
            int cur = in.nextInt();
            if (!stack.isEmpty()) {
                if (stack.getLast() == cur) {
                    cnt++;
                } else {
                    if (cnt >= 3) {
                        int last = stack.getLast();
                        while (stack.getLast() == last) {
                            stack.pollLast();
                            ans++;
                        }
                        cnt = counters.pop();
                    } else {
                        counters.push(cnt);
                    }
                }
            } else {
                cnt = 1;
            }
            stack.addLast(cur);
        }
        if (cnt > 1) {
            ans += cnt + 1;
        }
        System.out.println(ans);
    }
}
