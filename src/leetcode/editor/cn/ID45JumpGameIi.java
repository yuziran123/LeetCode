package leetcode.editor.cn;

public class ID45JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new ID45JumpGameIi().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路: 使用贪心算法，从左往右遍历数组，记录当前能够到达的最远位置。
         * <p>
         * 每次跳跃时更新目标位置，直到到达终点。
         * <p>
         * Date 2024/8/29
         */
        public int jump(int[] nums) {
            int resCount = 0;
            int curEnd = 0;
            int maxReach = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                // 更新下一次最远跳到哪
                maxReach = Math.max(maxReach, i + nums[i]);
                if (i == curEnd) { // 到达了跳跃边界，需要进行一次跳跃
                    curEnd = maxReach;
                    resCount++;
                    if (curEnd >= nums.length - 1) { // 提前终止
                        break;
                    }
                }
            }
            return resCount;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
