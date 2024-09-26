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
            int[][] dp = new int[n][2];
            dp[0][0] = 0;
            dp[0][1] = nums[0];
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = dp[i - 1][0] + nums[i];
            }
            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
