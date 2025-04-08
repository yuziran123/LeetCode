package leetcode.editor.cn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ID139WordBreak {
    public static void main(String[] args) {
        Solution solution = new ID139WordBreak().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            int n = s.length();
            // 初始化动态规划数组，dp[i]表示字符串s前i个字符组成的字符串是否能被字典中的单词拆分
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;   // 空字符串可以被拆分

            for (int i = 1; i <= n; i++) {
                // 在当前长度之前的所有子串中寻找可以拆分的点
                for (int j = 0; j < i; j++) {
                    // 如果前 j 个字符可以拆分，并且 [j, i) 子串在字典中
                    if (dp[j] && wordSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
