package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ID71SimplifyPath {
    public static void main(String[] args) {
        Solution solution = new ID71SimplifyPath().new Solution();

        // 执行测试
        // solution.simplifyPath("/h/");
        solution.simplifyPath("/../");
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> stack = new LinkedList<>();
            // 将 path 字符串切割成多个子字符串——会有空串注意判断
            for (String str : path.split("/")) {
                if (str.equals("") || str.equals("."))
                    continue;
                if (str.equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else
                    stack.push(str);
            }

            StringBuilder ans = new StringBuilder();
            // 此时stack和路径的顺序是反着的
            while (!stack.isEmpty()) {
                ans.insert(0, stack.pop());
                ans.insert(0, "/");
            }
            // 不可以用ans.equals("")
            return ans.isEmpty() ? "/" : ans.toString();
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
