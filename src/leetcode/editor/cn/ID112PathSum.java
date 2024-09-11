package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID112PathSum {
    public static void main(String[] args) {
        Solution solution = new ID112PathSum().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int sum = 0;
        boolean ans = false;

        public boolean hasPathSum(TreeNode root, int targetSum) {
            pathSum(root, targetSum);
            return ans;
        }

        public void pathSum(TreeNode root, int target) {
            if (root == null)
                return;
            sum += root.val;
            if (root.left == null && root.right == null) {
                if (sum == target)
                    ans = true;
            }
            pathSum(root.left, target);
            pathSum(root.right, target);
            sum -= root.val; // 每次退出递归，要将当前节点值再减去
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
