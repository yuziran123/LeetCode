package leetcode.editor.cn;

public class ID53MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new ID53MaximumSubarray().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        // int[] nums = {8, -19, 5, -4, 20};
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {5, 4, -1, 7, 8};
        System.out.println(solution.maxSubArray(nums));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int max = nums[0];
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                dp[i] = Math.max(dp[i - 1], 0) + nums[i];
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
