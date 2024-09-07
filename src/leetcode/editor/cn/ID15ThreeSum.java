package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ID15ThreeSum().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:双指针法
         * Date 2024/9/7
         */
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) break;
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                int L = i + 1, R = n - 1;
                while (L < R) {
                    sum = nums[i] + nums[L] + nums[R];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        while (L < R && nums[L] == nums[L + 1]) L++;
                        while (L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    } else if (sum < 0) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }

            return result;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * 描述:哈希表法
     * Date 2024/9/7
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        return ans;
    }

}
