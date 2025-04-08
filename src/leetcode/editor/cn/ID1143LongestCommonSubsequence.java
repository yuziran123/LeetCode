package leetcode.editor.cn;

public class ID1143LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution solution = new ID1143LongestCommonSubsequence().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();

            // 创建 DP 表，dp[i][j] 表示 text1 的前 i 个字符和 text2 的前 j 个字符的 LCS 长度
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1; // 如果当前字符相等，则 LCS 长度加 1
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);// 如果当前字符不相等，则取左上方的最大值
                    }
                }
            }

            // 返回最终结果
            return dp[m][n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
