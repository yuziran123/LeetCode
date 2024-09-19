package leetcode.editor.cn;

public class ID52NQueensIi {
    public static void main(String[] args) {
        Solution solution = new ID52NQueensIi().new Solution();
        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int ans = 0;
        private boolean[] onCol;
        private boolean[] diag1;
        private boolean[] diag2;
        private int n;

        public int totalNQueens(int n) {
            this.n = n;
            onCol = new boolean[n];
            diag1 = new boolean[2 * n - 1];
            diag2 = new boolean[2 * n - 1];

            dfs(0);
            return ans;
        }

        private void dfs(int row) {
            if (row == n) {
                ans++;
                return;
            }
            for (int c = 0; c < n; c++) {
                if (!onCol[c] && !diag1[row - c + n - 1] && !diag2[row + c]) {
                    onCol[c] = diag1[row - c + n - 1] = diag2[row + c] = true;
                    dfs(row + 1);
                    onCol[c] = diag1[row - c + n - 1] = diag2[row + c] = false;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
