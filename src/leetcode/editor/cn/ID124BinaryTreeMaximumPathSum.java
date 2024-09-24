package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new ID124BinaryTreeMaximumPathSum().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int ans = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            dfs(root);
            return ans;
        }

        public int dfs(TreeNode node) {
            if (node == null)
                return 0;
            int lVal = dfs(node.left);
            int rVal = dfs(node.right);
            ans = Math.max(ans, lVal + rVal + node.val);
            return Math.max(Math.max(lVal, rVal) + node.val, 0);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
