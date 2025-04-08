package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new ID300LongestIncreasingSubsequence().new Solution();
        // 执行测试
        solution.lengthOfLIS(new int[]{0, 3, 1, 6, 2, 2, 7});
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 计算最长递增子序列的长度
         * 通过动态规划的方法，考虑每个元素作为最长递增子序列的最后一个元素的可能性
         *
         * @param nums 输入的整数数组
         * @return 返回最长递增子序列的长度
         */
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            // dp数组，dp[i]表示以nums[i]结尾的最长递增子序列的长度
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                // 遍历当前元素之前的所有元素，寻找可以构成更长递增子序列的前一个元素
                for (int j = 0; j < i; j++) {
                    // 如果当前元素大于前一个元素，说明可以将当前元素接在前面的元素之后形成更长的递增子序列
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
            return ans;
        }

        /**
         * 计算最长递增子序列的长度
         * 该方法使用耐心排序算法，通过维护一个数组 dp 来找到最长递增子序列
         * dp[i] 表示长度为 i+1 的递增子序列的最小末尾值
         * 通过二分查找更新 dp 数组，从而保证时间复杂度为 O(n log n)
         *
         * @param nums 输入的整数数组，代表待分析的序列
         * @return 返回最长递增子序列的长度
         */
        public int lengthOfLIS1(int[] nums) {
            // 初始化 dp 数组，用于存储递增子序列的最小末尾值
            List<Integer> dp = new ArrayList<>();

            for (int num : nums) {
                // 使用二分查找找到 num 应该插入的位置
                int left = 0, right = dp.size();
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (dp.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 如果 num 比 dp 中所有元素都大，则追加到 dp 末尾
                if (left == dp.size()) {
                    dp.add(num);
                } else {
                    // 否则替换 dp 中第一个不小于 num 的元素
                    dp.set(left, num);
                }
            }
            // dp 的长度即为最长递增子序列的长度
            return dp.size();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
