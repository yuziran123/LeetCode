package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID222CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new ID222CountCompleteTreeNodes().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null)
                return 0;
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
