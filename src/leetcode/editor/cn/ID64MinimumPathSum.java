package leetcode.editor.cn;

public class ID64MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new ID64MinimumPathSum().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid.length; // 行数
            int n = grid[0].length; // 列数
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    } else if (i == 0) { // 第一行只能从左边来
                        grid[i][j] = grid[i][j - 1] + grid[i][j];
                    } else if (j == 0) { // 第一列只能从上边来
                        grid[i][j] = grid[i - 1][j] + grid[i][j];
                    } else { // 其他位置取上方和左方的最小值
                        grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                    }
                }
            }
            return grid[m - 1][n - 1];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
