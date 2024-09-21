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
        int ans = 0;
        char[][] grid;
        int m, n;
        int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {1, 0}};

        public int numIslands(char[][] grid) {

            this.m = grid.length;
            this.n = grid[0].length;
            boolean[][] visited = new boolean[m + 1][n + 1];
            this.grid = grid;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dfs(0, 0, visited);
                }
            }
            return ans;
        }

        private void dfs(int x, int y, boolean[][] visited) {
            if (!inArea(x, y, visited))
                return;
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[0];
            }
        }

        public boolean inArea(int x, int y, boolean[][] visited) {
            return x >= 0 && y >= 0 && x < m && y < n && !visited[x][y];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
