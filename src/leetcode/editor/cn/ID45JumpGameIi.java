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
         * 思路:
         * 从左往右，找到最小的能跳到队尾的元素，并将其记为新的队尾，这样问题就变成了一个更小的子问题
         * Date 2024/8/29
         *
         * @param nums
         * @return int
         */
        public int jump(int[] nums) {
            int resCount = 0;
            int len = nums.length;
            if (len == 1) // 不用跳
                return resCount;

            int end = len - 1; // 记录当前队尾
            int distance = 0;

            for (int i = 0; i < end; ) {
                if (end == 0)
                    break;
                distance = end - i;
                if (distance <= nums[i]) {
                    resCount++;
                    end = i;
                    i = 0;
                    continue;
                }
                i++;
            }
            return resCount;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
