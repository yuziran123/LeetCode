package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

public class ID56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new ID56MergeIntervals().new Solution();

        // 执行测试
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] data = {{1, 10}, {4, 5}, {8, 9}, {6, 7}};
        solution.merge(data);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            ArrayList<int[]> ans = new ArrayList<>();
            // 排序 按区间左侧排序
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            for (int[] nums : intervals) {
                int n = ans.size();
                // 上一区间右侧和当前区间左侧相交-合并
                if (!ans.isEmpty() && ans.get(n - 1)[1] >= nums[0]) {
                    ans.get(n - 1)[1] = Math.max(ans.get(n - 1)[1], nums[1]);
                } else {
                    ans.add(nums);
                }
            }
            return ans.toArray(new int[0][]);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
