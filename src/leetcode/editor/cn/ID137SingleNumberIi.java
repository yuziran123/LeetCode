package leetcode.editor.cn;

public class ID137SingleNumberIi {
    public static void main(String[] args) {
        Solution solution = new ID137SingleNumberIi().new Solution();
        // 执行测试
        int[] nums = {2, 2, 3, 2};
        solution.singleNumber(nums);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 统计各位的1的个数
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int cnt = 0;
                for (int num : nums)
                    cnt = cnt + ((num >> i) & 1);
                cnt = cnt % 3;
                ans = ans | (cnt << i);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    // 数字电路法
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = ones ^ nums[i] & ~twos;
            twos = twos ^ nums[i] & ~ones;
        }
        return ones;
    }
}
