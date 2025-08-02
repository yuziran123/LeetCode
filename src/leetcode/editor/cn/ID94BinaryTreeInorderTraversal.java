package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ID94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ID94BinaryTreeInorderTraversal().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        ArrayList<Integer> ans = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return ans;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            ans.add(root.val);
            dfs(root.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
