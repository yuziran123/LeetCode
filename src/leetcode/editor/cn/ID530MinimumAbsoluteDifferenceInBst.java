package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID530MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        Solution solution = new ID530MinimumAbsoluteDifferenceInBst().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.getMinimumDifference(new TreeNode().stringToTree("1,0,48,null,null,12,49"));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 中序遍历，检查是否递增
        int pre = -100000;
        int min = 100001;

        public int getMinimumDifference(TreeNode root) {
            if (root == null)
                return 100002;
            int left = getMinimumDifference(root.left);
            min = Math.min(root.val - pre, min);
            pre = root.val;
            int right = getMinimumDifference(root.right);

            return Math.min(Math.min(min, left), right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
