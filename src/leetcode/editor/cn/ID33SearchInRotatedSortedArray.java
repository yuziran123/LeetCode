package leetcode.editor.cn;

public class ID33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new ID33SearchInRotatedSortedArray().new Solution();
        // 执行测试
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        solution.search(nums, 3);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.找到最小值对应的索引——数组起始位置
         * 2.以此分左右分别执行二分查找——两侧都是递增的数组
         * Date 2024/9/20
         */
        public int search(int[] nums, int target) {
            int n = nums.length;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] < nums[right])
                    right = mid;
                else
                    left = mid + 1;
            }
            // 此时left为最小索引处
            if (left == 0) // 数组保持不变
                return searchPos(nums, 0, n - 1, target);
            else {
                int x = searchPos(nums, left, n - 1, target);
                if (x != -1)
                    return x;
                int y = searchPos(nums, 0, left - 1, target);
                if (y != -1)
                    return y;
                return -1;
            }
        }

        /**
         * 描述:搜索target的位置
         */
        public int searchPos(int[] nums, int left, int right, int target) {
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (target == nums[mid])
                    return mid;
                else if (target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            if (target != nums[left])// target不在数组中
                return -1;
            return left;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
