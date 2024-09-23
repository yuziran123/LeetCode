package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID212WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new ID212WordSearchIi().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> ans = new ArrayList<>();
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    // 在单词搜索的基础上改造——对每一个单词一一做判断，但是会判定超时
    class Solution1 {
        // 偏移量数组在二维平面内是经常使用的：表示上下左右四个方向的移动
        int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited; // 标记当前单元格是否被访问过
        char[][] board;
        int rows; // 行数
        int cols;// 列数

        public List<String> findWords(char[][] board, String[] words) {
            this.rows = board.length;
            this.cols = board[0].length;
            List<String> ans = new ArrayList<>();
            for (String word : words) {
                if (exist(board, word))
                    ans.add(word);
            }
            return ans;
        }

        public boolean exist(char[][] board, String word) {
            char[] wordArr = word.toCharArray();
            this.board = board;
            this.visited = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++)
                    // 当前单元格作为起始匹配失败——利用这个二维循环回溯
                    if (dfs(i, j, 0, wordArr)) return true;
            }
            return false;
        }

        public boolean dfs(int x, int y, int start, char[] wordArr) {
            if (start == wordArr.length - 1)   // 递归结束的出口
                return board[x][y] == wordArr[start];

            if (board[x][y] == wordArr[start]) {
                visited[x][y] = true;// 设置访问标记
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (isValid(newX, newY) && !visited[newX][newY])
                        // 继续访问下一个可探索单元格
                        if (dfs(newX, newY, start + 1, wordArr)) return true;
                }
                visited[x][y] = false; // 非常重要：回溯前要恢复现场，将访问标记抹去
            }
            return false;
        }

        // 判断当前方向单元格是否越界
        public boolean isValid(int x, int y) {
            return x < rows && y < cols && x >= 0 && y >= 0;
        }
    }
}
