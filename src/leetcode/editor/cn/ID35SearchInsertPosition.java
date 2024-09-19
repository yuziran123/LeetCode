package leetcode.editor.cn;

public class ID35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new ID35SearchInsertPosition().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            int left = 0, right = n - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (target == nums[mid])
                    return mid;
                else if (target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // target不在数组中
            if (target < nums[mid])
                return mid;
            return mid + 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
