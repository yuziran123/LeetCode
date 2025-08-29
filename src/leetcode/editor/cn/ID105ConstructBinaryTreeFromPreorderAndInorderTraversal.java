package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.HashMap;

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

        /**
         * 思路:
         * 1. 用前序遍历找根节点：前序的第一个元素一定是当前子树的根。
         * 2. 用中序遍历分左右子树：在中序中找到根的位置，其左侧是左子树的中序遍历，右侧是右子树的中序遍历。
         * 3. 递归构建：根据左右子树的长度，在前序中划分出左右子树的前序遍历，再递归构建左右子树。
         */
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // 快速通过根节点的值，找到它在中序遍历中的位置
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i); // 存储「元素值 → 中序索引」
            }
            // 调用递归构建函数
            return build(preorder, inorder, 0, preorder.length, 0, inorder.length);
        }

        // 前序 中序 子数组的范围都是左闭右开
        private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart >= preEnd || inStart >= inEnd)
                return null;
            int rootValue = preorder[preStart];    // 前序的第一个元素是根
            TreeNode root = new TreeNode(rootValue);
            int rootIndex = map.get(rootValue); // 根在中序中的索引
            int leftSize = rootIndex - inStart; // 左子树的节点数量（中序中根左侧的元素个数）
            // 递归构建左子树和右子树
            root.left = build(preorder, inorder, preStart + 1, preStart + 1 + leftSize, inStart, rootIndex);
            root.right = build(preorder, inorder, preStart + 1 + leftSize, preEnd, rootIndex + 1, inEnd);
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}

