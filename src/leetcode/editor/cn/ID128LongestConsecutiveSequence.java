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
        public int longestConsecutive(int[] nums) {
            int ans = 0;
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            for (int x : set) {
                // 如果当前元素 x 的前一个数 x-1 存在于集合中，则说明 x 不是一个连续序列的起点
                // 跳出此次循环，避免重复计算
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
