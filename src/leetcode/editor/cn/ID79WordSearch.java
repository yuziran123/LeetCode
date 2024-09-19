package leetcode.editor.cn;

public class ID79WordSearch {
    public static void main(String[] args) {
        Solution solution = new ID79WordSearch().new Solution();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        // 执行测试
        solution.exist(board, "ABCCED");
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 偏移量数组在二维平面内是经常使用的：表示上下左右四个方向的移动
        int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited; // 标记当前单元格是否被访问过
        char[] wordArr;
        char[][] board;
        int rows; // 行数
        int cols;// 列数

        public boolean exist(char[][] board, String word) {
            this.wordArr = word.toCharArray();
            this.board = board;
            this.rows = board.length;
            this.cols = board[0].length;
            this.visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++)
                    // 当前单元格作为起始匹配失败——利用这个二维循环回溯
                    if (dfs(i, j, 0)) return true;
            }
            return false;
        }

        public boolean dfs(int x, int y, int start) {
            if (start == wordArr.length - 1)   // 递归结束的出口
                return board[x][y] == wordArr[start];

            if (board[x][y] == wordArr[start]) {
                visited[x][y] = true;// 设置访问标记
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (isValid(newX, newY) && !visited[newX][newY])
                        // 继续访问下一个可探索单元格
                        if (dfs(newX, newY, start + 1)) return true;
                }
                visited[x][y] = false; //非常重要：回溯前要恢复现场，将访问标记抹去
            }
            return false;
        }

        // 判断当前方向单元格是否越界
        public boolean isValid(int x, int y) {
            return x < rows && y < cols && x >= 0 && y >= 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
