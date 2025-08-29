package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new ID54SpiralMatrix().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            // 初始化变量
            int m = matrix.length;       // 行数
            int n = matrix[0].length;   // 列数
            List<Integer> result = new ArrayList<>();

            // 定义边界
            int top = 0, bottom = m - 1;
            int left = 0, right = n - 1;

            // 螺旋遍历
            while (top <= bottom && left <= right) {
                // 从左到右遍历上边界
                for (int j = left; j <= right; j++) {
                    result.add(matrix[top][j]);
                }
                top++;

                // 从上到下遍历右边界
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;

                // 从右到左遍历下边界
                if (top <= bottom) {
                    for (int j = right; j >= left; j--) {
                        result.add(matrix[bottom][j]);
                    }
                    bottom--;
                }

                // 从下到上遍历左边界
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
