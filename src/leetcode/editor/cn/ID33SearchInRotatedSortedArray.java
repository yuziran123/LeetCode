package leetcode.editor.cn;

public class ID33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID33SearchInRotatedSortedArray().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] > target) {
                    if (nums[left] <= target)
                        right = mid - 1;
                    else
                        left = mid + 1;
                } else {
                    if (nums[right] >= target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
            return -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
