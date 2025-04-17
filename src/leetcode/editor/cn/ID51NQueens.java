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
        // 存储所有可能的解决方案
        List<List<String>> ans = new ArrayList<>();

        boolean[] onPath;
        boolean[] diag1;
        boolean[] diag2;
        int[] col;  // 皇后放在[r,col[r]] 记录每行皇后放在了哪一列
        int n;

        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            this.col = new int[n];  // 标记当前列
            this.onPath = new boolean[n];
            this.diag1 = new boolean[2 * n - 1]; // 主对角线
            this.diag2 = new boolean[2 * n - 1]; // 副对角线

            dfs(0);
            return ans;
        }

        /**
         * 深度优先搜索放置皇后的所有可能性
         *
         * @param row 当前正在处理的行
         */
        public void dfs(int row) {
            // 如果已经处理完所有行，记录当前的解决方案
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
                // 检查当前位置是否可以放置皇后
                if (!onPath[c] && !diag1[row + c] && !diag2[row - c + n - 1]) {
                    // 记录当前行皇后放置的列号
                    col[row] = c;
                    // 标记当前列、主对角线、副对角线已被占用
                    onPath[c] = diag1[row + c] = diag2[row - c + n - 1] = true;
                    // 继续处理下一行
                    dfs(row + 1);
                    // 回溯，撤销当前行的皇后放置
                    onPath[c] = diag1[row + c] = diag2[row - c + n - 1] = false;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
