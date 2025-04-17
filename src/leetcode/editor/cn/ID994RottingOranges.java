package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class ID994RottingOranges {
    public static void main(String[] args) {
        Solution solution = new ID994RottingOranges().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        public int orangesRotting(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int freshOranges = 0;
            int minutes = 0;
            Queue<int[]> queue = new LinkedList<>();
            // 遍历网格，统计新鲜橘子，并将腐烂橘子加入队列
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        freshOranges++;
                    } else if (grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                    }
                }
            }
            if (freshOranges == 0) {
                return 0;
            }

            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean isRotten = false;
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    // 检查四个方向的新鲜橘子
                    for (int[] direction : DIRECTIONS) {
                        int row = cur[0] + direction[0];
                        int col = cur[1] + direction[1];
                        if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                            isRotten = true;
                            queue.add(new int[]{row, col});
                            grid[row][col] = 2;
                            freshOranges--;
                        }
                    }
                }
                // 本轮有橘子腐烂 时间+1
                if (isRotten) {
                    minutes++;
                }
            }
            return freshOranges == 0 ? minutes : -1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
