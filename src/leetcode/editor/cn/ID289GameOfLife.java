package leetcode.editor.cn;

public class ID289GameOfLife {
    public static void main(String[] args) {
        Solution solution = new ID289GameOfLife().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        // int[][] matrix = {
        //         {0, 1, 0},
        //         {0, 0, 1},
        //         {1, 1, 1},
        //         {0, 0, 0}
        // };

        // int[][] matrix = {
        //         {0, 0, 0, 0},
        //         {0, 1, 1, 0},
        //         {0, 1, 1, 0},
        //         {0, 0, 0, 0}
        // };
        int[][] matrix = {
                {1},
                {0},
                {0},
                {1},
                {0},
                {0},
                {1},
                {0},
                {0},
                {1}
        };
        solution.gameOfLife(matrix);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*不讲理——纯纯的暴力遍历*/
        public void gameOfLife(int[][] board) {
            int m = board.length;// 行
            int n = board[0].length;// 列
            int[][] next = new int[m][n];
            int count = 0;

            // 1行
            if (m == 1) {
                board[0][0] = 0;
                board[0][n - 1] = 0;
                for (int col = 1; col < n - 1; col++) {
                    count += board[0][col - 1];
                    count += board[0][col + 1];
                    if (count == 2 && board[0][col] == 1)
                        next[0][col] = 1;
                    count = 0;
                }
                board[0] = next[0].clone();
                return;
            }

            // 1列
            if (n == 1) {
                board[0][0] = 0;
                board[m - 1][0] = 0;
                for (int row = 1; row < m - 1; row++) {
                    count += board[row - 1][0];
                    count += board[row + 1][0];
                    if (count == 2 && board[row][0] == 1)
                        next[row][0] = 1;
                    count = 0;
                }
                for (int i = 0; i < m; i++) {
                    board[i] = next[i].clone(); // 克隆每一行
                }
                return;
            }

            // 0，0
            count += board[0][1];
            count += board[1][1];
            count += board[1][0];
            if (count == 3 || (count == 2 && board[0][0] == 1))
                next[0][0] = 1;
            count = 0;
            // 0，n-1
            count += board[0][n - 2];
            count += board[1][n - 1];
            count += board[1][n - 2];
            if (count == 3 || (count == 2 && board[0][n - 1] == 1))
                next[0][n - 1] = 1;
            count = 0;
            // m-1，0
            count += board[m - 1][1];
            count += board[m - 2][0];
            count += board[m - 2][1];
            if (count == 3 || (count == 2 && board[m - 1][0] == 1))
                next[m - 1][0] = 1;
            count = 0;
            // m-1，n-1
            count += board[m - 1][n - 2];
            count += board[m - 2][n - 1];
            count += board[m - 2][n - 2];
            if (count == 3 || (count == 2 && board[m - 1][n - 1] == 1))
                next[m - 1][n - 1] = 1;
            count = 0;

            // 0行
            for (int col = 1; col < n - 1; col++) {
                count += board[0][col - 1];
                count += board[0][col + 1];
                count += board[1][col - 1];
                count += board[1][col];
                count += board[1][col + 1];
                if (count == 3 || (count == 2 && board[0][col] == 1))
                    next[0][col] = 1;
                count = 0;
            }
            // m-1行
            for (int col = 1; col < n - 1; col++) {
                count += board[m - 1][col - 1];
                count += board[m - 1][col + 1];
                count += board[m - 2][col - 1];
                count += board[m - 2][col];
                count += board[m - 2][col + 1];
                if (count == 3 || (count == 2 && board[m - 1][col] == 1))
                    next[m - 1][col] = 1;
                count = 0;
            }

            // 0列
            for (int row = 1; row < m - 1; row++) {
                count += board[row - 1][0];
                count += board[row + 1][0];
                count += board[row - 1][1];
                count += board[row][1];
                count += board[row + 1][1];
                if (count == 3 || (count == 2 && board[row][0] == 1))
                    next[row][0] = 1;
                count = 0;
            }

            // n-1列
            for (int row = 1; row < m - 1; row++) {
                count += board[row - 1][n - 1];
                count += board[row + 1][n - 1];
                count += board[row - 1][n - 2];
                count += board[row][n - 2];
                count += board[row + 1][n - 2];
                if (count == 3 || (count == 2 && board[row][n - 1] == 1))
                    next[row][n - 1] = 1;
                count = 0;
            }

            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    count += board[i - 1][j - 1];
                    count += board[i - 1][j];
                    count += board[i - 1][j + 1];
                    count += board[i][j - 1];
                    count += board[i][j + 1];
                    count += board[i + 1][j - 1];
                    count += board[i + 1][j];
                    count += board[i + 1][j + 1];
                    if (count == 3 || (count == 2 && board[i][j] == 1))
                        next[i][j] = 1;
                    count = 0;
                }
            }

            for (int i = 0; i < m; i++) {
                board[i] = next[i].clone(); // 克隆每一行
            }
            return;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
