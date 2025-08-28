package leetcode.editor.cn;

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
            int point = 0; // 下一个需要填充非0元素的位置
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[point];
                    nums[point] = temp;
                    point++;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
