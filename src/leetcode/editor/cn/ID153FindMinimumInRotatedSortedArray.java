package leetcode.editor.cn;

public class ID153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID153FindMinimumInRotatedSortedArray().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                // if ()

            }
            return 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
