package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ID105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ID105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        solution.buildTree(pre, in);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int[] preorder;
        int[] inorder;

        // 优化：递归参数改成子数组下标区间（左闭右开区间）的左右端点，从而避免复制数组
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            int n = preorder.length;
            for (int i = 0; i < n; i++)
                map.put(inorder[i], i);
            return build(0, n, 0, n);
        }

        public TreeNode build(int pre_left, int pre_right, int in_left, int in_right) {
            if (pre_left == pre_right)
                return null;
            TreeNode node = new TreeNode(preorder[pre_left]);
            int i = map.get(preorder[pre_left]) - in_left; // 左子树的大小
            node.left = build(pre_left + 1, pre_left + i + 1, in_left, in_left + i);
            node.right = build(pre_left + i + 1, pre_right, in_left + i + 1, in_right);
            return node;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    // 思路简单——时间&空间复杂度高
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int index = indexOf(inorder, preorder[0]); // 找根节点位置
        int[] pre_left = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] pre_right = Arrays.copyOfRange(preorder, index + 1, n);
        int[] in_left = Arrays.copyOfRange(inorder, 0, index);
        int[] in_right = Arrays.copyOfRange(inorder, index + 1, n);
        TreeNode left = buildTree1(pre_left, in_left);
        TreeNode right = buildTree1(pre_right, in_right);
        TreeNode root = new TreeNode(preorder[0], left, right);
        return root;
    }

    // 寻找数组下标
    private int indexOf(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return 0;
    }

    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    // 降低了时间复杂度——分析复杂
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        int n = preorder.length;
        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);
        return build(0, 0, n - 1);
    }

    /**
     * Date 2024/9/11
     *
     * @param root  根节点在前序遍历的索引
     * @param left  子树在中序遍历的左边界
     * @param right 子树在中序遍历的右边界
     * @return TreeNode
     * 当 left > right ，代表已经越过叶节点，此时返回 null
     */
    public TreeNode build(int root, int left, int right) {
        if (left > right)
            return null;
        int pos = map.get(preorder[root]); // 当前根的左子树节点数
        TreeNode left_node = build(root + 1, left, pos - 1);
        // pos - left + root + 1含义为 根节点索引 + 左子树长度 + 1
        TreeNode right_node = build(root + pos - left + 1, pos + 1, right);
        return new TreeNode(preorder[root], left_node, right_node);
    }
}

