package leetcode.editor.cn;

public class ID189RotateArray {
    public static void main(String[] args) {
        Solution solution = new ID189RotateArray().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:189. 轮转数组
         * Date 2024/8/28
         * 1.注意点：考虑数组元素长度小于k，做模运算
         * 2.做是做出来了，但不是最优，用了一点辅助空间
         *
         * @param nums
         * @param k
         */

        public void rotate(int[] nums, int k) {
            int len = nums.length;
            int[] temp = new int[k];
            // 考虑数组元素长度小于k，做模运算
            k = k % len;

            // 将k个轮转元素存储
            for (int j = 0; j < k; j++) {
                temp[j] = nums[len - k + j];
            }
            // 将其余元素后移
            for (int i = len - 1 - k; i >= 0; i--) {
                nums[i + k] = nums[i];
            }
            // 依次存储轮转元素
            for (int i = 0; i < k; i++) {
                nums[i] = temp[i];
            }
            return;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

            /*// 思路可以，但是超时
            int len = nums.length;
            int temp = 0;
            for (int c = 1; c <= k; c++) {
                temp = nums[len - 1];
                for (int i = len - 1; i > 0; i--) {
                    nums[i] = nums[i - 1];
                }
                nums[0] = temp;
            }*/
}
