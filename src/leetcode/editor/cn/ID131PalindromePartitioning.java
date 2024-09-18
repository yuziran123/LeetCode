package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new ID131PalindromePartitioning().new Solution();
        // 执行测试
        solution.partition("aab");
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans = new ArrayList<>();
        List<String> record = new ArrayList<>();
        String s;

        public List<List<String>> partition(String s) {
            this.s = s;
            dfs(0);
            System.out.println(ans);
            return ans;
        }

        public void dfs(int start) {
            if (start == s.length()) {
                ans.add(new ArrayList<>(record));
                return;
            }
            StringBuilder path = new StringBuilder();
            for (int i = start; i < s.length(); i++) {
                path.append(s.charAt(i));
                if (!path.equals(path.reverse().toString()))
                    return;

                record.add(path.toString());
                dfs(i + 1);
                record.remove(record.size() - 1);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
