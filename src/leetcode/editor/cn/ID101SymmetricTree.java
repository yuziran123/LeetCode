package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new ID101SymmetricTree().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:对称二叉树定义： 对于树中 任意两个对称节点 L 和 R ，一定有：
         * 1.L.val = R.val ：即此两对称节点值相等。
         * 2.L.left.val = R.right.val ：即 L 的 左子节点 和 R 的 右子节点 对称。
         * 3.L.right.val = R.left.val ：即 L 的 右子节点 和 R 的 左子节点 对称。
         * Date 2024/9/11
         *
         * @param root
         * @return boolean
         */
        public boolean isSymmetric(TreeNode root) {
            return root == null || judge(root.left, root.right);
        }

        public boolean judge(TreeNode L, TreeNode R) {
            if (L == null && R == null) {
                return true;
            }
            if (L == null || R == null || L.val != R.val) {
                return false;
            }
            return judge(L.left, R.right) && judge(L.right, R.left);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
