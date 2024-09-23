package leetcode.editor.cn;

public class ID918MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new ID918MaximumSumCircularSubarray().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int len = nums.length;
            int max = nums[0];
            int sum = 0;
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i] = Math.max(dp[i - 1], 0) + nums[i];
                max = Math.max(max, dp[i]);
            }
            for (int i = 0; i < len; i++) {
            }
            return max;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
