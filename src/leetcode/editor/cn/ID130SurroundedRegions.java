package leetcode.editor.cn;

public class ID130SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new ID130SurroundedRegions().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        char[][] board;
        int m, n;

        public void solve(char[][] board) {
            this.board = board;
            this.m = board.length;
            this.n = board[0].length;

            // 从边界 'O' 开始 DFS
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O' && inBundary(i, j))
                        dfs(i, j);
                }
            }
            // 此时图中有'O' 'X' '#'(这才是真正的O)
            // 修改 'O' 为 'X'，将标记的边界 'O' 重新改为 'O'
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O')
                        board[i][j] = 'X'; // 变成 'X'
                    else if (board[i][j] == '#')
                        board[i][j] = 'O'; // 变回 'O'
                }
            }
        }

        // DFS 方法：将所有与边界构成区域的格子，标记为#
        public void dfs(int xi, int yi) {
            board[xi][yi] = '#'; // 标记为已访问
            for (int[] dir : DIRECTIONS) {
                int x = xi + dir[0];
                int y = yi + dir[1];
                if (inArea(x, y) && board[x][y] == 'O') {
                    dfs(x, y);
                }
            }
        }

        // 当前格子是否越界
        public boolean inArea(int x, int y) {
            return x >= 0 && y >= 0 && x < m && y < n;
        }

        // 当前格子是否位于边界
        public boolean inBundary(int x, int y) {
            return x == 0 || y == 0 || x == m - 1 || y == n - 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
