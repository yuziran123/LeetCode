package leetcode.editor.cn;

import java.util.Arrays;

public class ID628MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new ID628MaximumProductOfThreeNumbers().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumProduct(int[] nums) {
            // 初始化最大三个数和最小两个数
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

            // 遍历数组，更新最大三个数和最小两个数
            for (int num : nums) {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                } else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                } else if (num > max3) {
                    max3 = num;
                }

                // 更新最小两个数
                if (num < min1) {
                    min2 = min1;
                    min1 = num;
                } else if (num < min2) {
                    min2 = num;
                }
            }

            // 计算可能的最大乘积
            int product1 = max1 * max2 * max3; // 最大三个数的乘积
            int product2 = max1 * min1 * min2; // 最大数与最小两个数的乘积

            return Math.max(product1, product2);
        }

    }

    // leetcode submit region end(Prohibit modification and deletion)
    public int maximumProduct(int[] nums) {
        // 排序完找到最大三个数和最小两个数，乘积就是
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        Arrays.sort(nums);
        ans = Math.max(ans, nums[n - 1] * nums[n - 2] * nums[n - 3]);
        ans = Math.max(ans, nums[n - 1] * nums[0] * nums[1]);
        return ans;
    }
}
