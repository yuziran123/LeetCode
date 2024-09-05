package leetcode.editor.cn;

public class ID48RotateImage {
    public static void main(String[] args) {
        Solution solution = new ID48RotateImage().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*将旋转90°的操作变为转置+对称*/
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            if (n == 1) {
                return;
            }

            int temp = 0;
            // 1.将矩阵转置
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) { // 处理对角线的上半三角即可
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
            // 2.将矩阵元素左右对换
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) { // 处理中轴左边
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }
            return;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
