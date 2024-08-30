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

            int index = len - 1;    // index表示下标而不是长度
            int distance = 0;
            int i = index - 1;
            while (i >= 0) {
                distance = index - i;   // 末尾元素与当前元素的距离
                if (distance > nums[i]) // 距离过大，当前元素无法到达
                {
                    i--;
                    continue;
                } else {
                    // 当i=0时，就是判断是否能完成跳跃的条件
                    if (i == 0 && distance <= nums[i])
                        return true;
                    // 当前元素足够跳到末尾，将当前元素置为末尾元素
                    index = i;
                    i--;
                }
            }
            return false;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
