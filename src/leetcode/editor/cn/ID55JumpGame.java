package leetcode.editor.cn;

public class ID55JumpGame {
    public static void main(String[] args) {
        Solution solution = new ID55JumpGame().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        // int[] nums = new int[]{2, 3, 1, 1, 4};
        // int[] nums = new int[]{3, 2, 1, 0, 4};
        // int[] nums = new int[]{2, 0, 0, 0, 4};
        int[] nums = new int[]{1, 2};
        System.out.println(solution.canJump(nums));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int maxReach = 0; // 当前能跳到的最远位置
            for (int i = 0; i < nums.length; i++) {
                if (i > maxReach) {  // 如果当前i已经超过了能跳的最远距离，说明无法到达
                    return false;
                }
                maxReach = Math.max(maxReach, i + nums[i]);
                if (maxReach >= nums.length - 1) {  // 可以跳到终点
                    return true;
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
