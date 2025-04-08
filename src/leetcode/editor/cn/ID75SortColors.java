package leetcode.editor.cn;

public class ID75SortColors {
    public static void main(String[] args) {
        Solution solution = new ID75SortColors().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            // 定义三个指针
            int left = 0;       // 指向当前 0 应该存放的位置
            int right = nums.length - 1; // 指向当前 2 应该存放的位置
            int index = 0;      // 遍历指针

            while (index <= right) {
                if (nums[index] == 0) {
                    // 将当前值与 left 指针位置的值交换，并移动 left 和 index 指针
                    swap(nums, left, index);
                    left++;
                    index++; // 继续检查下一个元素
                } else if (nums[index] == 2) {
                    // 将当前值与 right 指针位置的值交换，并仅移动 right 指针
                    swap(nums, right, index);
                    right--; // 不移动 index，因为交换过来的值需要重新检查
                } else {
                    index++;// 当前值为 1，无需交换，直接移动 index 指针
                }
            }
        }

        // 辅助方法：交换数组中两个位置的值
        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
