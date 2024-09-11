package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID226InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ID226InvertBinaryTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        TreeNode root = new TreeNode().stringToTree("2,null,3,1");
        solution.invertTree(root);
        System.out.println(builder);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null)
                return root;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
