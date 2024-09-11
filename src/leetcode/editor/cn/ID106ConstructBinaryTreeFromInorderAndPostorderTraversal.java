package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.Arrays;

public class ID106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ID106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = postorder.length;
            if (n == 0)
                return null;
            int i = indexOf(inorder, postorder[n - 1]);
            int[] post_left = Arrays.copyOfRange(postorder, 0, i);
            int[] post_right = Arrays.copyOfRange(postorder, i, n - 1);
            int[] in_left = Arrays.copyOfRange(inorder, 0, i);
            int[] in_right = Arrays.copyOfRange(inorder, i + 1, n);
            TreeNode left = buildTree(in_left, post_left);
            TreeNode right = buildTree(in_right, post_right);
            return new TreeNode(postorder[n - 1], left, right);
        }

        // 寻找数组下标
        private int indexOf(int[] arr, int key) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == key)
                    return i;
            }
            return 0;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
