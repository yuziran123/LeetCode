package leetcode.editor.cn;

import java.util.Arrays;

public class ID416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new ID416PartitionEqualSubsetSum().new Solution();
        // 执行测试
        // int[] nums = {1, 5, 11, 5, 9, 4, 5};
        int[] nums = {1, 2, 5};
        System.out.println(solution.canPartition(nums));
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 误区:排序然后左右分成和大小一致的子集，并不合理，想等元素组成的子集不一定是连续的
         */
        /*空间优化*/
        public boolean canPartition(int[] nums) {
            int n = nums.length, sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            if (sum % 2 != 0)
                return false;
            sum = sum / 2; // 这个就是背包容量
            int[] dp = new int[sum + 1];
            int MAX = sum + 1;
            Arrays.fill(dp, MAX);
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                for (int h = sum; h >= 0; h--) {
                    if (h < nums[i - 1])
                        dp[h] = dp[h];
                    else
                        dp[h] = Math.min(dp[h], dp[h - nums[i - 1]] + 1);
                }
                if (dp[sum] != MAX)
                    return true;
            }
            return false;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    public boolean canPartition0(int[] nums) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0)
            return false;
        int halfSum = sum / 2; // 这个就是背包容量
        int[][] dp = new int[n + 1][halfSum + 1];
        int MAX = halfSum + 1;
        for (int i = 1; i < MAX; i++) {
            dp[0][i] = MAX;
        }
        for (int i = 1; i < n; i++) {
            for (int h = 1; h <= halfSum; h++) {
                if (h < nums[i - 1])
                    dp[i][h] = dp[i - 1][h];
                else
                    dp[i][h] = Math.min(dp[i - 1][h], dp[i - 1][h - nums[i - 1]] + 1);
            }
            if (dp[i][halfSum] != MAX)
                return true;
        }
        return false;
    }
}
