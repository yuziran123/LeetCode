package leetcode.editor.cn;

import java.util.Stack;

public class ID150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution solution = new ID150EvaluateReversePolishNotation().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();

            for (String s : tokens) {
                // leetcode 内置jdk的问题，不能使用==判断字符串是否相等
                if ("+".equals(s)) {
                    stack.push(stack.pop() + stack.pop());
                } else if ("*".equals(s)) {
                    stack.push(stack.pop() * stack.pop());
                } else if ("-".equals(s)) {
                    stack.push(-stack.pop() + stack.pop());
                } else if ("/".equals(s)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                } else {
                    stack.push(Integer.valueOf(s));
                }
            }
            return stack.peek();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
