package leetcode.editor.util;

/**
 * ClassName:TreeNode
 * Description:二叉树节点定义
 * Author:yu
 * Date:2024/9/8 15:50
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
