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
        // 能否从 nums 中选出一个子序列，其元素和恰好等于元素和一半
        // 于是就等价于0-1背包问题
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % 2 == 1) {
                return false;
            }
            int target = sum / 2;
            int[] dp = new int[target + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = target; j >= nums[i]; j--) {
                    if (dp[j - nums[i]] != Integer.MAX_VALUE) { // 确保可以选到j-num[i]
                        dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                    }
                }
            }
            return dp[target] != Integer.MAX_VALUE;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
