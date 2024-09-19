package leetcode.editor.cn;

public class ID162FindPeakElement {
    public static void main(String[] args) {
        Solution solution = new ID162FindPeakElement().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:在题目描述中出现了 nums[-1] = nums[n] = -∞，
         * 这就代表着 只要数组中存在一个元素比相邻元素大，那么沿着它一定可以找到一个峰值
         * Date 2024/9/20
         */
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;
            // 保证区间至少可以取到两个值：mid，mid+1；所以不可以取left=right的情况
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] > nums[mid + 1])
                    right = mid;
                else
                    left = mid + 1;
            }
            return left; //二者是一样的退出while时left==right
            // return right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
