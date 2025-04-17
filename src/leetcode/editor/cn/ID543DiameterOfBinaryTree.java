package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID543DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ID543DiameterOfBinaryTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int ans;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return -1;
            }
            int left = dfs(node.left) + 1;
            int right = dfs(node.right) + 1;
            // left + right 表示经过当前节点的最长路径（左子树高度 + 右子树高度）。
            ans = Math.max(ans, left + right);
            return Math.max(left, right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
