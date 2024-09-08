package leetcode.editor.cn;

import java.util.Stack;

public class ID20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ID20ValidParentheses().new Solution();

        // 执行测试

        solution.isValid("(])");
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            boolean ans = true;
            char[] chars = s.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                if (stack.isEmpty())
                    stack.push(c);
                else {
                    if (c == ')' && stack.peek() == '(')
                        stack.pop();
                    else if (c == '}' && stack.peek() == '{')
                        stack.pop();
                    else if ((c == ']' && stack.peek() == '['))
                        stack.pop();
                    else
                        stack.push(c);
                }
            }
            return stack.isEmpty();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
