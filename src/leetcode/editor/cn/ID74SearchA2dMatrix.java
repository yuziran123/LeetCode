package leetcode.editor.cn;

public class ID74SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new ID74SearchA2dMatrix().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            int mid = 0;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][cols - 1] < target)
                    continue;

                int left = 0, right = cols - 1;
                while (left <= right) {
                    mid = (left + right) / 2;
                    if (target == matrix[i][mid])
                        return true;
                    else if (target < matrix[i][mid])
                        right = mid - 1;
                    else
                        left = mid + 1;
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
