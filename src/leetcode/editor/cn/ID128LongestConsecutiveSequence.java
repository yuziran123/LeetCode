package leetcode.editor.cn;

import java.util.Arrays;

public class ID128LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new ID128LongestConsecutiveSequence().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        solution.longestConsecutive(nums);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //[1,1,2,2] = 2
        public int longestConsecutive(int[] nums) {
            int n = nums.length;
            if (n == 0)
                return 0;
            Arrays.sort(nums); // 排序
            int count = 0, ans = 0;
            for (int i = 0; i < n - 1; i++) {
                if (nums[i] == nums[i + 1]) continue;   // 相邻的数重复，跳过不做处理
                if (nums[i + 1] == nums[i] + 1) count++;    // 相邻的数连续
                else {
                    ans = Math.max(ans, count + 1); // 相邻的数不连续——重新开始计数——记录当前长度是否最大
                    count = 0;
                }
            }
            return Math.max(ans, count + 1);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
