package leetcode.editor.cn;

public class ID209MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution solution = new ID209MinimumSizeSubarraySum().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] nums = {1, 4, 4};
        solution.minSubArrayLen(4, nums);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int ans = 100001;
            int pre = 0, suf = 0;
            int sum = 0;
            while (pre < nums.length && suf < nums.length) {
                while (sum < target && suf < nums.length) {
                    sum += nums[suf];
                    suf++;
                }
                while (sum >= target && pre <= suf) {
                    // 本来长度应该=suf - pre + 1；但是当sum>= target时，suf实际多+1了
                    ans = Math.min(ans, suf - pre);
                    sum -= nums[pre];
                    pre++;
                }
            }
            ans = ans < 100001 ? ans : 0;
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
