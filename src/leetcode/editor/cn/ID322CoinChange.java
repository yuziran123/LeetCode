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
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int n = coins.length;
            int MAX = amount + 1;
            // dp数组用于动态规划，dp[j]表示金额j所需的最少硬币数量
            int[] dp = new int[amount + 1];
            // 初始化很关键
            Arrays.fill(dp, MAX);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= amount; j++) {
                    // 如果当前硬币面额大于当前找零金额，则不考虑使用这枚硬币
                    if (coins[i] > j) {
                        dp[j] = dp[j];
                    } else {
                        // 否则，考虑使用当前硬币，更新dp[j]为使用或不使用当前硬币的最小值
                        dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                    }
                }
            }
            // 如果dp[amount]不等于MAX，说明可以找零，返回最少硬币数量
            return dp[amount] != MAX ? dp[amount] : -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
