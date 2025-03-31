package leetcode.editor.cn;

public class ID54SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new ID54SpiralMatrix().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Object[] spiralOrder(int[][] matrix) {
            // 输入校验
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new Object[0];
            }

            // 初始化变量
            int m = matrix.length;       // 行数
            int n = matrix[0].length;   // 列数
            int total = m * n;          // 总元素个数
            Object[] result = new Object[total]; // 结果数组
            int index = 0;              // 当前填充位置

            // 定义边界
            int top = 0, bottom = m - 1;
            int left = 0, right = n - 1;

            // 螺旋遍历
            while (top <= bottom && left <= right) {
                // 从左到右遍历上边界
                for (int j = left; j <= right; j++) {
                    result[index++] = matrix[top][j];
                }
                top++;

                // 从上到下遍历右边界
                for (int i = top; i <= bottom; i++) {
                    result[index++] = matrix[i][right];
                }
                right--;

                // 从右到左遍历下边界
                if (top <= bottom) {
                    for (int j = right; j >= left; j--) {
                        result[index++] = matrix[bottom][j];
                    }
                    bottom--;
                }

                // 从下到上遍历左边界
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result[index++] = matrix[i][left];
                    }
                    left++;
                }
            }

            return result;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}
