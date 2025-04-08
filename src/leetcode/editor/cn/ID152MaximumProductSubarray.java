package leetcode.editor.cn;

public class ID152MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new ID152MaximumProductSubarray().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int n = nums.length;
            int max = nums[0], min = nums[0];
            int ans = nums[0];
            for (int i = 1; i < n; i++) {
                // 如果当前数字是负数，交换max和min，因为负数会反转最大值和最小值的关系
                if (nums[i] < 0) {
                    int temp = max;
                    max = min;
                    min = temp;
                }
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
                ans = Math.max(max, ans);
            }
            return ans;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
