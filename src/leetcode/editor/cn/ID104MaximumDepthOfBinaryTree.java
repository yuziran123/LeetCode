package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ID104MaximumDepthOfBinaryTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null)
                return 0;
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left + 1, right + 1);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
