package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

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
        /**
         * 描述:核心逻辑：使用一个单调递减栈（栈中存储的是温度数组的索引）。
         * <p>
         * 从右往左遍历数组：
         * <p>
         * 1.如果当前温度大于栈顶对应的温度，则弹出栈顶元素
         * （因为这些温度已经不可能成为后续天数的答案）。
         * <p>
         * 2.当栈为空时，说明右侧没有更高温度，answer[i] = 0。
         * <p>
         * 3.否则，answer[i] 等于栈顶索引与当前索引的差值。
         * <p>
         * 4.当前索引入栈
         * <p>
         * Date 2025/4/7
         */
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> stack = new ArrayDeque<>(); // 使用双端队列实现单调栈
            int n = temperatures.length;
            int[] answer = new int[n];
            int curT = 0;
            // 遍历温度数组，从右往左构建单调递减栈
            for (int i = n - 1; i >= 0; i--) {
                curT = temperatures[i];
                while (!stack.isEmpty() && curT >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                // 如果栈为空，表示右侧没有更高的温度；否则计算距离
                answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
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
