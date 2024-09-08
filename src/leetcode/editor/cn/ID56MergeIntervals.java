package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new ID56MergeIntervals().new Solution();

        // 执行测试
        int[][] intervals = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] data = {
                {1, 10}, {4, 5}, {8, 9}, {6, 7}};
        solution.merge(data);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            // 对intervals按每一行的首元素排序
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            List<int[]> ans = new ArrayList<>();
            for (int[] arr : intervals) {
                int size = ans.size();
                if (size > 0 && ans.get(size - 1)[1] >= arr[0]) // 区间合并
                    // 由于左端按序排列，只需选择较大的作为右端
                    ans.get(size - 1)[1] = Math.max(ans.get(size - 1)[1], arr[1]);
                else
                    ans.add(arr); // 新的独立区间
            }
            return ans.toArray(new int[0][]);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
