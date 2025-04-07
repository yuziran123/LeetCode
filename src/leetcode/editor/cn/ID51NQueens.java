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

    /**
     * N皇后问题解决方案类
     * 该问题的目标是在n*n的棋盘上放置n个皇后，使得它们互不攻击
     * 互不攻击的定义是：任意两个皇后都不能处于同一行、同一列或同一斜线上
     */
    class Solution {
        // 存储所有可能的解决方案
        List<List<String>> ans = new ArrayList<>();

        // onPath[c] 表示第c列是否有皇后
        boolean[] onPath;
        // diag1[r+c] 表示r+c相同的主对角线是否有皇后
        boolean[] diag1;
        // diag2[r-c+n-1] 表示r-c相同的副对角线是否有皇后
        boolean[] diag2;
        // col[r] 表示第r行皇后放置的列号
        int[] col;
        // 棋盘的大小
        int n;

        /**
         * 解决N皇后问题的入口方法
         *
         * @param n 棋盘的大小
         * @return 所有可能的解决方案
         */
        public List<List<String>> solveNQueens(int n) {
            this.n = n;
            this.col = new int[n];
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
