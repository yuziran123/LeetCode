package leetcode.editor.cn;

public class ID72EditDistance {
    public static void main(String[] args) {
        Solution solution = new ID72EditDistance().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            // 如果其中一个字符串为空，则编辑距离为另一个字符串的长度
            if (m == 0) return n;
            if (n == 0) return m;

            // 创建动态规划表 dp，dp[i][j] 表示 word1 的前 i 个字符与 word2 的前 j 个字符的最小编辑距离
            int[][] dp = new int[m + 1][n + 1];

            // 初始化边界条件
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i; // 将 word1 的前 i 个字符变为空字符串，需要删除 i 次
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j; // 将空字符串变为 word2 的前 j 个字符，需要插入 j 次
            }

            // 填充动态规划表
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1]; // 字符相等，无需操作
                    } else {
                        // 取三种操作（删除、插入、替换）中的最小值，并加 1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
