package leetcode.editor.cn;

import java.util.HashSet;

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
            int ans = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            // nums转成set 去重
            for (int x : set) {
                if (set.contains(x - 1)) {
                    continue;
                }
                int y = x + 1;
                while (set.contains(y)) {
                    y++;
                }
                // x 到 y-1 都是连续的 有 y-x个数
                ans = Math.max(ans, y - x);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
