package leetcode.editor.cn;

import java.util.*;

public class ID739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new ID739DailyTemperatures().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] nusm = {73, 74, 75, 71, 69, 72, 76, 73};
        // int[] nusm = {73, 74, 75, 73};
        solution.dailyTemperatures(nusm);
        System.out.println(builder);
    }

    /**
     * 笔记:
     * 1.Stack类是早期Java集合框架的一部分，它直接继承自Vector类。
     * Vector是一个线程安全的动态数组，这意味着Stack的所有方法都是同步的，
     * 这在单线程环境下可能会导致不必要的性能开销。
     * <p>
     * 2.ArrayDeque（Array Double Ended Queue）
     * 是Java集合框架中的一个更现代的实现，它是一个基于动态数组的双端队列。
     * 虽然它不是专门设计为栈的，但通过只使用一端（比如只进行addFirst()和removeFirst()操作），
     * 它可以非常高效地作为栈来使用。ArrayDeque没有继承自任何线程安全的类，
     * 其方法也不是默认同步的，因此在非线程安全的场景下性能更好。
     */

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*单调栈：从右往左——单调增栈;代码优化版*/
        public int[] dailyTemperatures(int[] temperatures) {
            // Stack<Integer> stack = new Stack<>();
            Deque<Integer> stack = new ArrayDeque<>(); // 双端队列，开销更小，也可以实现先进后出
            int n = temperatures.length;
            int[] answer = new int[n];
            int t = 0;
            for (int i = n - 1; i >= 0; i--) {
                t = temperatures[i];
                while (!stack.isEmpty() && t >= temperatures[stack.peek()])
                    stack.pop();
                if (stack.isEmpty())
                    answer[i] = 0;
                else
                    answer[i] = stack.peek() - i;
                stack.push(i);
            }
            return answer;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

    /*单调栈：从右往左——思路清晰*/
    public int[] dailyTemperatures2(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] answer = new int[n];
        answer[n - 1] = 0;
        stack.push(n - 1);
        int t = 0;
        for (int i = n - 2; i >= 0; i--) {
            t = temperatures[i];
            // 当前温度小于栈顶，直接入栈，栈顶指针就是下一次高温
            if (t < temperatures[stack.peek()]) {
                answer[i] = stack.peek() - i;
                stack.push(i);  // 无论那种情况最后都是要将当前元素入栈的
            } else {
                // 找下一次高温
                while (!stack.empty() && t >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if (stack.empty()) // 要么栈空
                    answer[i] = 0;
                else // 要么找到了新的高温栈顶
                    answer[i] = stack.peek() - i;
                stack.push(i);
            }
        }
        return answer;
    }

    /*暴力法：时间复杂度O(n²)*/
    public int[] dailyTemperatures1(int[] temperatures) {
        int len = temperatures.length;
        int[] answer = new int[len];
        answer[len - 1] = 0;
        int index = 0;
        for (int i = 0; i < len - 1; i++) {
            index = 1;
            while (i + index < len && temperatures[i + index] <= temperatures[i])
                index++;
            if (i + index == len)
                index = 0;
            answer[i] = index;
        }
        answer[len - 1] = 0;
        return answer;
    }

}
