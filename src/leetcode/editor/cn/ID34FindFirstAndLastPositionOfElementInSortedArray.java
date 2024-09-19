package leetcode.editor.cn;

public class ID34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:二分查找-确定数组中目标位置，然后左右分别递归，直到不同的数出现
         * Date 2024/9/19
         */
        public int[] searchRange(int[] nums, int target) {
            int[] ans = {-1, -1};
            // 左<=target<=右
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    while (mid < n && nums[mid] == target)
                        mid++;
                    ans[1] = mid - 1;
                    mid = (left + right) / 2;
                    while (mid >= 0 && nums[mid] == target)
                        mid--;
                    ans[0] = mid + 1;
                    return ans;
                } else if (nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
