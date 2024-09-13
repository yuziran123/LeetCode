package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID98ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ID98ValidateBinarySearchTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 中序遍历
        Long INF = Long.MAX_VALUE;// 无穷大
        long pre = -INF;

        public boolean isValidBST(TreeNode root) {
            if (root == null)
                return true;
            if (!isValidBST(root.left))
                return false;
            if (root.val <= pre)
                return false;
            else
                pre = root.val;
            return isValidBST(root.right);
        }


    }

    // leetcode submit region end(Prohibit modification and deletion)
    class Solution1 {
        // 先序遍历
        // int INF = Integer.MAX_VALUE; //会有边界问题
        Long INF = Long.MAX_VALUE;// 无穷大

        public boolean isValidBST(TreeNode root) {
            return isValid(root, -INF, INF);
        }

        public boolean isValid(TreeNode root, long left, long right) {
            if (root == null)
                return true;
            int x = root.val;
            return (left < x && x < right) && isValid(root.left, left, x) && isValid(root.right, x, right);
        }
    }
}
