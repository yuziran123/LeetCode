package leetcode.editor.cn;

import java.util.Arrays;

public class ID452MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        Solution solution = new ID452MinimumNumberOfArrowsToBurstBalloons().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[][] intervals = {
                {3, 9},
                {7, 12},
                {3, 8},
                {6, 8},
                {9, 10},
                {2, 9},
                {0, 9},
                {3, 9},
                {0, 6},
                {2, 8}
        };
        solution.findMinArrowShots(intervals);
        System.out.println(builder);
        // [[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0])); // 排序
            int count = 1, n = points.length;
            for (int i = 1; i < n; i++) {
                if (points[i - 1][1] < points[i][0]) // 前后区间不交叉
                    count++;
                else // 前后区间交叉——新的右边界为小的那个
                    points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
