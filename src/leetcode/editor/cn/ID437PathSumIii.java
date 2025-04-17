package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new ID437PathSumIii().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return 0;
            }
            // 计算根 左 右为起点的路径数
            int count = dfs(root, targetSum, 0L);
            count += pathSum(root.left, targetSum);
            count += pathSum(root.right, targetSum);
            return count;
        }

        //
        private int dfs(TreeNode root, int target, long curSum) {
            if (root == null) {
                return 0;
            }
            curSum += root.val;
            int count = (curSum == target ? 1 : 0);
            count += dfs(root.left, target, curSum);
            count += dfs(root.right, target, curSum);
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
