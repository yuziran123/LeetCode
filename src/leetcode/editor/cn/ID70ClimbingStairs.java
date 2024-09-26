package leetcode.editor.cn;

public class ID70ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ID70ClimbingStairs().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if (n == 1 || n == 2)
                return n;
            int[] dp = new int[n];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n - 1];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
