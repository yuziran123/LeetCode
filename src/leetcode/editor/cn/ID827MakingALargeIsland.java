package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ID827MakingALargeIsland {
    public static void main(String[] args) {
        Solution solution = new ID827MakingALargeIsland().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int largestIsland(int[][] grid) {
            int n = grid.length;
            List<Integer> record = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1)
                        record.add(area(i, j, grid, record.size() + 2)); // +2是为了和原有的0 1 区分开
                }
            }

            if (record.isEmpty())
                return 1;

            int ans = 0;
            Set<Integer> s = new HashSet<>();
            // 找到所有的海洋格子，累加其相邻的岛屿面积
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0)
                        continue;

                    s.clear();
                    int newArea = 1;
                    for (int[] dir : DIRECTIONS) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (inArea(x, y, grid) && grid[x][y] != 0 && s.add(grid[x][y]))
                            newArea += record.get(grid[x][y] - 2); // 累加面积
                    }
                    ans = Math.max(ans, newArea);
                }
            }
            return ans == 0 ? n * n : ans; // 如果最后 ans 仍然为 0，说明所有格子都是 1，返回 n^2
        }

        // DFS获取每个岛屿面积
        public int area(int x, int y, int[][] grid, int id) {
            grid[x][y] = id; // 标记当前网格属于哪个岛屿
            int res = 1;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY, grid) && grid[newX][newY] == 1)
                    res += area(newX, newY, grid, id);
            }
            return res;
        }

        public boolean inArea(int x, int y, int[][] grid) {
            return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
