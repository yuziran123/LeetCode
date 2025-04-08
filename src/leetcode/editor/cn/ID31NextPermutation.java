package leetcode.editor.cn;

public class ID31NextPermutation {
    public static void main(String[] args) {
        Solution solution = new ID31NextPermutation().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;

            // 从右向左找到第一个递减的元素
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            if (i >= 0) {
                // 从右向左找到第一个比 nums[i] 大的元素
                int j = n - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                // 交换 nums[i] 和 nums[j]
                swap(nums, i, j);
            }

            // 反转 i 后的部分
            reverse(nums, i + 1, n - 1);
        }

        // 辅助方法：交换数组中的两个元素
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 辅助方法：反转数组中指定范围的元素
        private void reverse(int[] nums, int start, int end) {
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
