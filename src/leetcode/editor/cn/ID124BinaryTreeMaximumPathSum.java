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
            if (node == null) {
                return 0;
            }
            int leftVal = dfs(node.left);
            int rightVal = dfs(node.right);
            ans = Math.max(ans, leftVal + rightVal + node.val);
            // 从当前节点出发只能走左/右其中一条
            return Math.max(Math.max(leftVal, rightVal) + node.val, 0);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
