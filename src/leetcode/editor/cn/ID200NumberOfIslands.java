package leetcode.editor.cn;

public class ID200NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new ID200NumberOfIslands().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        char[][] grid;

        public int numIslands(char[][] grid) {
            int ans = 0;
            this.grid = grid;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1')
                        ans += area(i, j);
                }
            }
            return ans;
        }

        public int area(int x, int y) {
            if (!inArea(x, y) || grid[x][y] != '1')
                return 0;
            // 说明此时有岛屿，利用DFS探寻该岛屿的最大范围 ，并设置探寻过的标记
            grid[x][y] = '2';
            for (int[] direction : DIRECTIONS) { // 从四个方向分别探寻岛屿
                area(x + direction[0], y + direction[1]);
            }
            return 1;
        }

        // 判断岛屿坐标是否越界
        public boolean inArea(int x, int y) {
            return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
