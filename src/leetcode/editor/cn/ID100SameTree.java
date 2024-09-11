package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID100SameTree {
    public static void main(String[] args) {
        Solution solution = new ID100SameTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        // 创建 TreeNode 实例
        TreeNode root = new TreeNode();
        root = root.stringToTree("1,2,3");
        solution.isSameTree(root, root);
        System.out.println(builder);
    }
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null)
                return p == q;
            if (p.val != q.val)
                return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) // 递归结束
            return p == q;
        else // p == q 只能判断两个节点是否引用相同对象，但不能检查两个不同对象的值和结构是否相同
            return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
