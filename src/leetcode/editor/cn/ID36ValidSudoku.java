package leetcode.editor.cn;

public class ID36ValidSudoku {
    public static void main(String[] args) {
        Solution solution = new ID36ValidSudoku().new Solution();

        // 执行测试
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.isValidSudoku(board);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*纯纯的举证遍历*/
        public boolean isValidSudoku(char[][] board) {
            int[] flag = new int[10];
            int number = 0;
            // 逐行
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        number = board[i][j] - '0';
                        flag[number]++;
                        if (flag[number] > 1)
                            return false;
                    }
                }
                flag = new int[10];
            }

            // 逐列
            flag = new int[10];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[j][i] != '.') {
                        number = board[j][i] - '0';
                        flag[number]++;
                        if (flag[number] > 1)
                            return false;
                    }
                }
                flag = new int[10];
            }

            // 3×3宫格
            flag = new int[10];
            for (int r = 0; r < 9; ) {
                for (int c = 0; c < 9; ) {
                    for (int i = r; i < r + 3; i++) {
                        for (int j = c; j < c + 3; j++) {
                            if (board[i][j] != '.') {
                                number = board[i][j] - '0';
                                flag[number]++;
                                if (flag[number] > 1)
                                    return false;
                            }
                        }
                    }
                    flag = new int[10];
                    c = c + 3;
                }
                r = r + 3;
            }

            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
