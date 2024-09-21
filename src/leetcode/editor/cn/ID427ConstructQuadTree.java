package leetcode.editor.cn;

public class ID427ConstructQuadTree {
    public static void main(String[] args) {
        Solution solution = new ID427ConstructQuadTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] presum;

        public Node construct(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            presum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    presum[i + 1][j + 1] = presum[i + 1][j] + presum[i][j + 1] - presum[i][j] + grid[i][j];
            return dfs(0, 0, m, n);
        }

        private Node dfs(int x0, int y0, int x1, int y1) {
            int diff = presum[x1][y1] - presum[x1][y0] - presum[x0][y1] + presum[x0][y0];
            if (diff == 0)
                return new Node(false, true, null, null, null, null);
            if (diff == (x1 - x0) * (y1 - y0))
                return new Node(true, true, null, null, null, null);
            int hx = (x0 + x1) / 2, hy = (y0 + y1) / 2;
            return new Node(true, false,
                    dfs(x0, y0, hx, hy),
                    dfs(x0, hy, hx, y1),
                    dfs(hx, y0, x1, hy),
                    dfs(hx, hy, x1, y1));
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
