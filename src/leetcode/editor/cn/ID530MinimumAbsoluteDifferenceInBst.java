package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID530MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new ID530MinimumAbsoluteDifferenceInBst().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int getMinimumDifference(TreeNode root) {


            int minL = getMinimumDifference(root.left);
            int minR = getMinimumDifference(root.right);
            return Math.min(minL, minR);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
