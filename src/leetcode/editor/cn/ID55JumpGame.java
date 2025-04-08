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
        /**
         * 描述:
         * 1.元素表示最大跳跃长度-不是只能跳这么多
         * 2.能到到达最后一个元素即可-和末尾元素值无关
         * Date 2024/8/29
         *
         * @param nums
         * @return boolean
         */
        public boolean canJump(int[] nums) {
            int len = nums.length;
            // 后面的算法考虑的都是其他元素和末尾元素的距离，所以len为1的情况要先过滤
            if (len == 1) {
                return true;
            }
            int target = len - 1;
            for (int i = len - 2; i >= 0; i--) {
                if (i + nums[i] >= target) { // 如果当前位置可以到达目标位置
                    target = i; // 更新目标位置为当前位置
                }
            }
            return target == 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
