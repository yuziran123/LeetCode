package leetcode.editor.cn;

import java.util.Arrays;

public class ID73SetMatrixZeroes {
    public static void main(String[] args) {
        Solution solution = new ID73SetMatrixZeroes().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        solution.setZeroes(matrix);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*O(m + n)的空间复杂度*/
        public void setZeroes(int[][] matrix) {
            int m = matrix.length; // 行
            int n = matrix[0].length; // 列

            // 分别用两个数组记录有0元素的行和列
            int[] recordRow = new int[m];
            Arrays.fill(recordRow, -1);// 初始化所有元素填充-1;避免记录时和0行/列冲突
            int[] recordCol = new int[n];
            Arrays.fill(recordCol, -1);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        recordRow[i] = j; // i行j列处元素=0
                        recordCol[j] = i;
                    }
                }
            }
            // 根据recordRow数组将对应i行置为全0
            for (int i = 0; i < m; i++) {
                if (recordRow[i] != -1) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }
            // 根据recordCol数组将对应i列置为全0
            for (int i = 0; i < n; i++) {
                if (recordCol[i] != -1) {
                    for (int j = 0; j < m; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }
            return;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
