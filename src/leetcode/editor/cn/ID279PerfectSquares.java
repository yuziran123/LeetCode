package leetcode.editor.cn;

import java.util.Arrays;

public class ID279PerfectSquares {
    public static void main(String[] args) {
        Solution solution = new ID279PerfectSquares().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            // 动态规划数组 dp[i] 表示数字 i 可以表示为最少的完全平方数之和的数量
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
            return dp[n];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
