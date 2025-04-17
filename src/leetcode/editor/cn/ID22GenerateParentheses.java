package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID22GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new ID22GenerateParentheses().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> ans = new ArrayList<>();
        char[] path;
        private int n;

        // 1.选左括号的前提是：其数量小于n
        // 2.选右括号的前提是：右括号数量小于左括号数量
        public List<String> generateParenthesis(int n) {
            this.n = n;
            path = new char[2 * n];
            dfs(0, 0);
            return ans;
        }

        public void dfs(int i, int left) { // left表示当前左括号的数量
            if (i == 2 * n) {
                ans.add(new String(path));
                return;
            }
            if (left < n) {
                path[i] = '(';
                dfs(i + 1, left + 1);
            }
            if (i - left < left) { // i-left（右括号数量:确保其小于左括号数量）
                path[i] = ')';
                dfs(i + 1, left);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
