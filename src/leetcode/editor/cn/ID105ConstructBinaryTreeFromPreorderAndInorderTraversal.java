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
    public class Solution {
        private HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 构建中序遍历的索引映射
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            // 调用递归构建函数
            return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
        }

        private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            // 基础情况：如果子数组为空，返回 null
            if (preStart >= preEnd || inStart >= inEnd) {
                return null;
            }
            // 获取当前子树的根节点
            int rootValue = preorder[preStart];
            TreeNode root = new TreeNode(rootValue);
            // 找到根节点在中序遍历中的索引
            int rootIndex = map.get(rootValue);
            // 计算左子树的长度
            int leftSize = rootIndex - inStart;
            // 递归构建左子树和右子树
            root.left = build(preorder, inorder, preStart + 1, preStart + 1 + leftSize, inStart, rootIndex);
            root.right = build(preorder, inorder, preStart + 1 + leftSize, preEnd, rootIndex + 1, inEnd);
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}

