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
        public boolean isValidBST(TreeNode root) {
            if (root == null || (root.left == null && root.right == null))
                return true;
            if (root.left != null && root.right != null)
                return root.left.val < root.val && root.val < root.right.val;
            if (root.left != null)
                return root.left.val < root.val;
            if (root.right != null)
                return root.val < root.right.val;
            boolean left = isValidBST(root.left);
            boolean right = isValidBST(root.right);
            return left && right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
