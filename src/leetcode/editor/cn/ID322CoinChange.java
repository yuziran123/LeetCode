package leetcode.editor.cn;

import java.util.Arrays;

public class ID322CoinChange {
    public static void main(String[] args) {
        Solution solution = new ID322CoinChange().new Solution();
        // 执行测试
        int[] coins = {186, 419, 83, 408};
        System.out.println(solution.coinChange(coins, 6249));
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*空间优化*/
        public int coinChange(int[] coins, int amount) {
            if (amount == 0)
                return 0;
            int n = coins.length;
            int MAX = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, MAX);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (coins[i - 1] > j)
                        dp[j] = dp[j];
                    else
                        dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
                }
            }
            return dp[amount] != MAX ? dp[amount] : -1;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    public int coinChange0(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int n = coins.length;
        int MAX = amount + 1;
        int[][] dp = new int[n + 1][MAX];
        for (int i = 1; i < MAX; i++) {
            dp[0][i] = MAX;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
            }
        }
        System.out.println(dp);
        return dp[n][amount] != MAX ? dp[n][amount] : -1;
    }
}
