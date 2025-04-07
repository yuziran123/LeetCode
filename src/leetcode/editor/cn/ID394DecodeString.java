package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ID394DecodeString {
    public static void main(String[] args) {
        Solution solution = new ID394DecodeString().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String decodeString(String s) {
            StringBuilder str = new StringBuilder();
            Deque<Integer> numStack = new ArrayDeque<>();
            Deque<String> strStack = new ArrayDeque<>();
            int count = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    // 数字
                    count = count * 10 + (c - '0');
                } else if (c == '[') {
                    // 左括号-数字和字符入栈
                    numStack.push(count);
                    strStack.push(str.toString());
                    str = new StringBuilder();
                    count = 0;
                } else if (c == ']') {
                    int repeats = numStack.pop();
                    StringBuilder temp = new StringBuilder(strStack.pop());
                    for (int i = 0; i < repeats; i++) {
                        temp.append(str);
                    }
                    str = temp;
                } else {
                    str.append(c);
                }
            }
            return str.toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
