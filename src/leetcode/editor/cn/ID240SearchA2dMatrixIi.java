package leetcode.editor.cn;

public class ID240SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new ID240SearchA2dMatrixIi().new Solution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        System.out.println(solution.searchMatrix(matrix, target)); // 输出: true

        target = 20;
        System.out.println(solution.searchMatrix(matrix, target)); // 输出: false
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length; // 行数
            int n = matrix[0].length; // 列数

            // 从右上角开始搜索
            int row = 0;
            int col = n - 1;

            while (row < m && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] < target) {
                    row++; // 向下移动
                } else {
                    col--; // 向左移动
                }
            }

            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
