package leetcode.editor.cn;

public class ID115DistinctSubsequences {
    public static void main(String[] args) {
        Solution solution = new ID115DistinctSubsequences().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int m = s.length();
            int n = t.length();
            // 边界条件：如果 t 的长度大于 s，直接返回 0
            if (n > m) {
                return 0;
            }
            // dp[i][j] 表示 s 的前 i 个字符中包含 t 的前 j 个字符的不同子序列数量
            int[][] dp = new int[m + 1][n + 1];
            // 初始化：空字符串 t 是任何字符串 s 的子序列，且只有一种匹配方式
            for (int i = 0; i <= m; i++) {
                dp[i][0] = 1;
            }
            // 填充 dp 表
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 如果当前字符匹配，则有两种选择：
                    // 1. 使用 s[i-1] 匹配 t[j-1]
                    // 2. 不使用 s[i-1] 匹配 t[j-1]
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                    } else {
                        // 如果不匹配，则只能继承 dp[i-1][j]
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[m][n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
