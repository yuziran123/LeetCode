package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ID224BasicCalculator {
    public static void main(String[] args) {
        Solution solution = new ID224BasicCalculator().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int calculate(String s) {
            int ans = 0, n = s.length();
            Deque<Integer> stack = new ArrayDeque<>();
            int sign = 1, i = 0;
            stack.push(sign);
            char ch;
            while (i < n) {
                if (Character.isDigit(ch = s.charAt(i))) {
                    int number = 0;
                    //将连续的数字转换为整数。例如，如果字符串是 "123"，则 number 将最终变为 123。
                    while (i < n && Character.isDigit(ch = s.charAt(i))) {
                        number = number * 10 + ch - '0';
                        i++;
                    }
                    ans += sign * number;
                } else {
                    if (ch == '+')
                        sign = stack.peek();
                    else if (ch == '-')
                        sign = -stack.peek();
                    else if (ch == '(')
                        stack.push(sign);
                    else if (ch == ')')
                        stack.pop();
                    i++;
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
