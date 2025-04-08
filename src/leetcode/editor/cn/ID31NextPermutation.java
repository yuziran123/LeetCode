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
        /*题目理解：
         *可以将该问题形式化地描述为：给定若干个数字，将其组合为一个整数。
         *如何将这些数字重新排列，以得到下一个更大的整数。如 123 下一个更大的数为 132。
         *如果没有更大的整数，则输出最小的整数。
         *
         * 算法思路：
         *  1.从后向前 查找第一个 相邻升序 的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
         *  2.在 [j,end) 从后向前 查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
         *  3.将 A[i] 与 A[k] 交换
         *  4.可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
         *  5.如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
         * */
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;

            // 从后向前 找到第一个递减的元素
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            if (i >= 0) {
                // 从后向前找到第一个比 nums[i] 大的元素
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
