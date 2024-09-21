package leetcode.editor.cn;

public class ID463IslandPerimeter {
    public static void main(String[] args) {
        Solution solution = new ID463IslandPerimeter().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        /**
         * 描述:可以将岛屿的周长中的边分为两类：
         * 1.与网格边界相邻的周长
         * 2.与海洋格子相邻的周长
         * 已经遍历过的岛屿格子和周长没有关系
         */
        public int islandPerimeter(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1)
                        return area(i, j, grid);
                }
            }
            return 0;
        }

        public int area(int x, int y, int[][] grid) {
            if (!inArea(x, y, grid) || grid[x][y] == 0)
                return 1;
            if (grid[x][y] != 1)
                return 0;
            grid[x][y] = 2;
            int res = 0;
            // 统计当前格子在岛屿中的周长：每个格子的周长来自其四个方向的相邻，只要是边界或海洋就+1
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
