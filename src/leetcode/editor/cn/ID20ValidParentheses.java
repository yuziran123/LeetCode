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
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                // 如果是左括号，则将对应的右括号入栈
                if (c == '(') stack.push(')');
                else if (c == '{') stack.push('}');
                else if (c == '[') stack.push(']');
                    // 如果是右括号，且栈为空（没有左括号可以匹配）或栈顶元素不匹配，则字符串无效
                else if (stack.isEmpty() || stack.pop() != c) return false;
            }
            return stack.isEmpty();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
