package leetcode.editor.cn;

public class ID153FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID153FindMinimumInRotatedSortedArray().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 分析：
         * 1.nums[mid] > nums[right]：本来应该是升序，此时却有降序，说明最小的值一定在[mid+1,right]
         * 2.nums[mid] < nums[right]：此时右侧是升序，说明最小的值一定在[left,mid]
         * Date 2024/9/20
         */
        public int findMin(int[] nums) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[right]) // 数组元素互不相同——不会有相等的情况
                    left = mid + 1;
                else
                    right = mid;
            }
            return nums[left];  // return nums[right];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
