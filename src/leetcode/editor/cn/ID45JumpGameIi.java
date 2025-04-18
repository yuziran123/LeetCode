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
        public int jump(int[] nums) {
            int jumps = 0; // 记录跳跃次数
            int end = 0; // 当前能到达的最远边界
            int maxReach = 0; // 当前能跳到的最远位置
            for (int i = 0; i < nums.length - 1; i++) { // 注意：不需要遍历到最后一个元素
                maxReach = Math.max(maxReach, i + nums[i]);
                if (i == end) { // 到达当前步数的边界，必须跳一步
                    jumps++;
                    end = maxReach;
                }
            }
            return jumps;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
