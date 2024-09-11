package leetcode.editor.util;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName:TreeNode
 * Description:二叉树节点定义
 * Author:yu
 * Date:2024/9/8 15:50
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 描述:数组转二叉树
     *
     * @return TreeNode
     */
    public TreeNode arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        return buildTree(arr, 0);
    }

    private TreeNode buildTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null)
            return null;
        TreeNode node = new TreeNode(arr[index]);
        node.left = buildTree(arr, 2 * index + 1);
        node.right = buildTree(arr, 2 * index + 2);
        return node;
    }


    /**
     * 描述:字符串转二叉树（按层序遍历）
     *
     * @param data 字符串表示的二叉树，节点用逗号分隔，"null" 表示空节点
     * @return TreeNode 根节点
     */
    public TreeNode stringToTree(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(",");
        if (nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }
        // 使用队列实现层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.length) {
            TreeNode current = queue.poll();
            // 创建左子节点
            if (!nodes[index].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(current.left);
            }
            index++;

            // 创建右子节点
            if (index < nodes.length && !nodes[index].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[index]));
                queue.add(current.right);
            }
            index++;
        }
        return root;
    }

}
