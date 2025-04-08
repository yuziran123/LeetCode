package leetcode.editor.cn;

public class ID198HouseRobber {
    public static void main(String[] args) {
        Solution solution = new ID198HouseRobber().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int n = nums.length;
            // dp[i][0]表示不偷第i间房屋时能得到的最大金额
            // dp[i][1]表示偷第i间房屋时能得到的最大金额
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = nums[0];
            for (int i = 1; i < n; i++) {
                // 不偷当前房屋，则取前一间房屋偷与不偷的最大值
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                // 偷当前房屋，则前一间房屋不能偷，当前房屋的金额加上前一间房屋不偷时的最大金额
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
