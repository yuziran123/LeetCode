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
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null) {
                return root;
            }
            return left != null ? left : right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
