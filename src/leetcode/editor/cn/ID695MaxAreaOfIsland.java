package leetcode.editor.cn;

public class ID695MaxAreaOfIsland {
    public static void main(String[] args) {
        Solution solution = new ID695MaxAreaOfIsland().new Solution();
        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1)
                        ans = Math.max(ans, area(i, j, grid));
                }
            }
            return ans;
        }

        public int area(int x, int y, int[][] grid) {
            // 越界判断一定要先判断 否则grid[x][y]会有非法索引
            if (!inArea(x, y, grid) || grid[x][y] != 1)
                return 0;
            grid[x][y] = 2; // 重要：设置访问过的标记
            int res = 1;
            for (int[] direction : DIRECTIONS)
                res += area(x + direction[0], y + direction[1], grid);
            return res;
        }

        public boolean inArea(int x, int y, int[][] grid) {
            return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
