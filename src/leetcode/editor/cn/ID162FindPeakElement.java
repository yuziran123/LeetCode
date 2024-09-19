package leetcode.editor.cn;

public class ID162FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new ID162FindPeakElement().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPeakElement(int[] nums) {
            if (nums.length == 1)
                return 0;
            if (nums.length == 2)
                return nums[0] > nums[1] ? 0 : 1;
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                    return i;
            }
            return nums.length - 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
