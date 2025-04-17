package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID230KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new ID230KthSmallestElementInABst().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 中序遍历——设置计数器
        int k;
        int ans;

        // 二叉搜索树（BST）的中序遍历结果是有序的
        public int kthSmallest(TreeNode root, int k) {
            this.k = k;
            inorder(root);
            return this.ans;
        }

        public void inorder(TreeNode root) {
            if (root == null || k == 0) {
                return;
            }
            inorder(root.left);
            k--;
            if (k == 0) {
                this.ans = root.val;
            }
            inorder(root.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
