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
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len; // 处理 k > len 的情况

            // 使用反转法实现数组旋转
            reverse(nums, 0, len - 1); // 整体反转
            reverse(nums, 0, k - 1);   // 反转前 k 个元素
            reverse(nums, k, len - 1); // 反转剩余部分
        }

        // 辅助方法：反转数组的指定区间
        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
