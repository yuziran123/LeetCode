package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ID114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new ID114FlattenBinaryTreeToLinkedList().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 按照先序遍历——展开成链表
        List<TreeNode> list = new ArrayList<>();

        public void flatten(TreeNode root) {
            if (root == null)
                return;

            preorder(root);
            TreeNode p = new TreeNode();
            TreeNode dummy = p;
            for (TreeNode node : list) {
                p.left = null;
                p.right = node;
                p = node;
            }
            root = dummy;
        }

        public void preorder(TreeNode root) {
            if (root == null)
                return;
            list.add(root);
            preorder(root.left);
            preorder(root.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
