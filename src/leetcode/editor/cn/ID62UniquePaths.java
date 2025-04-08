package leetcode.editor.cn;

public class ID62UniquePaths {
    public static void main(String[] args) {
        Solution solution = new ID62UniquePaths().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /* 如果不写 dp[0][1]=1，那么需要在代码中特判 i=j=0 的情况，因为 dp[1][1] 属于初始值，不能用状态转移方程计算。
         * 但是，如果把初始值改成 dp[0][1]=1（或者 dp[1][0]=1），就无需特判 i=j=0 的情况了，dp[1][1] 也可以用状态转移方程计算
         */
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            dp[0][1] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
            return dp[m][n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
