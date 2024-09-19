package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ID51NQueens {
    public static void main(String[] args) {
        Solution solution = new ID51NQueens().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans = new ArrayList<>();

        boolean[] onPath;
        boolean[] diag1;
        boolean[] diag2;
        int[] col;
        int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            this.col = new int[n];
            this.onPath = new boolean[n];
            this.diag1 = new boolean[2 * n - 1]; // 主对角线
            this.diag2 = new boolean[2 * n - 1]; // 副对角线

            dfs(0);
            return ans;
        }

        public void dfs(int row) {
            if (row == n) {
                List<String> record = new ArrayList<>();
                for (int c : col) {
                    char[] arr = new char[n];
                    Arrays.fill(arr, '.');
                    arr[c] = 'Q';
                    record.add(new String(arr));
                }
                ans.add(record);
                return;
            }
            // 主对角线上行+列为固定值；副对角线上行-列为固定值，为了避免负索引+n-1
            for (int c = 0; c < n; c++) {
                if (!onPath[c] && !diag1[row + c] && !diag2[row - c + n - 1]) {
                    col[row] = c;
                    onPath[c] = diag1[row + c] = diag2[row - c + n - 1] = true;
                    dfs(row + 1);
                    onPath[c] = diag1[row + c] = diag2[row - c + n - 1] = false;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
