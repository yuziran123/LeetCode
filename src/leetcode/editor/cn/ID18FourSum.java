package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID18FourSum {
    public static void main(String[] args) {
        Solution solution = new ID18FourSum().new Solution();

        // 执行测试
        // int[] nums = {1000000000, 1000000000, 1000000000, 1000000000};
        int[] nums = {0, 0, 0, -1000000000, -1000000000, -1000000000, -1000000000};
        // solution.fourSum(nums, -294967296);
        solution.fourSum(nums, -1000000000);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // int[] nums = {1000000000, 1000000000, 1000000000, 1000000000}; 求和超出了int范围 结果 = -294967296

        /**
         * 描述:三数之和双指针法的扩展
         * Date 2024/9/7
         */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < n; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int sum1 = nums[i] + nums[j];

                    int L = j + 1, R = n - 1;
                    while (L < R) {
                        int sum2 = nums[L] + nums[R];
                        if ((long) sum1 + sum2 == (long) target) {
                            ans.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
                            while (L < R && nums[L] == nums[L + 1]) L++;
                            while (L < R && nums[R] == nums[R - 1]) R--;
                            L++;
                            R--;
                        } else if (sum1 + sum2 < target) {
                            L++;
                        } else {
                            R--;
                        }
                    }
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
