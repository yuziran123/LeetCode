package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ID300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new ID300LongestIncreasingSubsequence().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int ans = 1;
            // int[] dp = new int[n];
            // dp[0] = 1;
            // for (int i = 1; i < n; i++) {
            //     if (nums[i] > nums[i - 1]) {
            //         dp[i] = dp[i - 1] + 1;
            //         ans = Math.max(ans, dp[i]);
            //     } else
            //         dp[i] = dp[i-1];
            // }
            // return dp[n - 1];
            // // return ans;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(nums[0]);
            for (int i = 1; i < n; i++) {
                if (!stack.isEmpty() && stack.peek() >= nums[i])
                    stack.pop();
                // if (stack.)
                stack.push(nums[i]);
                ans = Math.max(stack.size(), ans);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
