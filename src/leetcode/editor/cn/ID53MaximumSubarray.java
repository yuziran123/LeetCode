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
        /**
         * 描述:动态规划解决
         * Date 2024/8/31
         *
         * @param nums
         * @return int
         */
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int max = nums[0];
            int sum = 0;
            int[] dp = new int[len];
            dp[0] = nums[0];
            for (int i = 1; i < len; i++) {
                // dp[i] 取决于 dp[i-1]
                // 1.dp[i-1]<=0 ;nums[i]作为新序列的起始
                // 2.dp[i-1]>0 ;nums[i]作为新序列的末尾
                dp[i] = Math.max(dp[i - 1], 0) + nums[i];
                // 取所有递增自序列和最大的情况
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

    // 纯数组特性分析方法
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            // 当nums[i]<0时并且sum<0时，说明之前的自学列对面后面的自学列不会起到增加的效果，故应当重新开始子序列
            if (nums[i] < 0 && sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }
}
