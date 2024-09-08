package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID228SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new ID228SummaryRanges().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        solution.summaryRanges(nums);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            int n = nums.length;
            if (n == 0) return ans;
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int start = i;
                s.append(nums[i]);
                // 从i开始找区间的尾端
                while (i < n - 1 && nums[i] + 1 == nums[i + 1]) {
                    i++;
                    continue;
                }
                // start != i表示区间长度大于1
                if (start != i) {
                    s.append("->");
                    s.append(nums[i]);
                }
                ans.add(s.toString());
                s.setLength(0); // s长度设置为0，这将清空其内容
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
