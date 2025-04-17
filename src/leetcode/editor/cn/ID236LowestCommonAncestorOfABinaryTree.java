package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new ID236LowestCommonAncestorOfABinaryTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:后序遍历+自底向上[先递归到最底层（叶子节点），再回溯]
         * <p>
         * Date 2025/4/6
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 终止条件：空节点或找到 p/q
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 如果左右均不为空，说明 p 和 q 分布在两侧，当前 root 是 LCA
            if (left != null && right != null) {
                return root;
            }
            // 否则返回非空的一侧（即 p 和 q 在同一子树中）
            return left != null ? left : right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
