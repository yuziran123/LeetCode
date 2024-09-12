package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ID236LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new ID236LowestCommonAncestorOfABinaryTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left != null && right != null)
                return root;
            if (left != null)
                return left;
            else // right!=null 或者 left,right都为空
                return right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    List<TreeNode> list = new ArrayList<>();
    List<TreeNode> list1 = new ArrayList<>(); // 存p的祖先路径
    List<TreeNode> list2 = new ArrayList<>();// 存q的祖先路径

    /*记录两者公共祖先——再逐一比对*/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path(root, p, q);
        int len1 = list1.size();
        int len2 = list2.size();
        TreeNode ans = null;
        // 遍历list1 list2的最后一个相同节点——即为最近公共祖先
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (list1.get(i) == list2.get(i))
                ans = list1.get(i);
        }
        return ans;
    }

    public void path(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return;
        list.add(root);
        if (root == p)
            list1 = new ArrayList<>(list);
        if (root == q)
            list2 = new ArrayList<>(list);
        path(root.left, p, q);
        path(root.right, p, q);
        list.remove(root);
    }

   /* public void path1(TreeNode root, TreeNode node) {
        if (root == null)
            return;
        list.add(root);
        if (root == node)
            list1 = new ArrayList<>(list);
        path1(root.left, node);
        path1(root.right, node);
        list.remove(root);
    }

    public void path2(TreeNode root, TreeNode node) {
        if (root == null)
            return;
        list.add(root);
        if (root == node)
            list2 = new ArrayList<>(list);
        path2(root.left, node);
        path2(root.right, node);
        list.remove(root);
    }*/
}
