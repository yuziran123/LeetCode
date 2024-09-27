package leetcode.editor.cn;

import java.util.Arrays;

public class ID322CoinChange {
    public static void main(String[] args) {
        Solution solution = new ID322CoinChange().new Solution();
        // 执行测试
        int[] coins = {186, 419, 83, 408};
        solution.coinChange(coins, 6249);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0)
                return 0;
            int n = coins.length, ans = 1;
            Arrays.sort(coins);
            int[][] dp = new int[n][amount + 1];
            dp[n - 1][0] = 0;
            dp[n - 1][amount - coins[n - 1]] = coins[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                for (int a = 0; a <= amount; a++) {
                    if (coins[i] > amount)
                        dp[i][a] = dp[i + 1][a];
                    else {
                        dp[i][a] = Math.max(dp[i + 1][a], dp[i][amount - coins[i]]) + coins[i];
                        ans++;
                    }
                }
            }
            return amount == 0 ? ans : -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
