package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ID98ValidateBinarySearchTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 判断一个二叉树是否为有效的二叉搜索树
         * 通过中序遍历来检查树中的每个节点，确保它们的值严格递增
         *
         * @param root 二叉树的根节点
         * @return 如果树是有效的二叉搜索树，则返回true；否则返回false
         */
        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            // 如果节点为空，自然是有效的二叉搜索树
            if (root == null) {
                return true;
            }
            // 首先检查左子树是否为有效的二叉搜索树
            if (!isValidBST(root.left)) {
                return false;
            }
            // 二叉搜索树中序遍历值严格递增
            if (root.val <= pre) {
                return false;
            } else {
                pre = root.val;
            }
            // 最后检查右子树是否为有效的二叉搜索树
            return isValidBST(root.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
