package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new ID114FlattenBinaryTreeToLinkedList().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        TreeNode dummy;

        public void flatten(TreeNode root) {
            if (root == null)
                return;
            flatten(root.left);
            dummy.right = root.left;
            dummy.left = null;
            dummy = dummy.right;
            flatten(root.right);
            dummy.right = root.right;
            dummy.left = null;
            dummy = dummy.right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
