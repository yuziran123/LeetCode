package leetcode.editor.cn;

import java.util.Arrays;

public class ID283MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new ID283MoveZeroes().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 双指针
        public void moveZeroes(int[] nums) {
            int p0 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    p0++;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    // 把nums当栈
    public void moveZeroes2(int[] nums) {
        int stackSize = 0;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            nums[stackSize++] = num;
        }
        // 从数组 nums 的索引 stackSize 开始，到数组末尾填充 0
        Arrays.fill(nums, stackSize, nums.length, 0);
    }
}
