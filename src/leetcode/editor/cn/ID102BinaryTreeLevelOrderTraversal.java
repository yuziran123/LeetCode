package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ID102BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new ID102BinaryTreeLevelOrderTraversal().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.levelOrder(new TreeNode().stringToTree("1,2,3,null,5,null,4"));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 描述:队列实现层序遍历
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> level = new ArrayList<>(levelSize);
                for (int i = 0; i < levelSize; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                ans.add(level);
            }
            return ans;
        }
        // public List<List<Integer>> levelOrder(TreeNode root) {
        //     if (root == null) {
        //         return new ArrayList<>();
        //     }
        //     List<List<Integer>> ans = new ArrayList<>();
        //     List<Integer> levels = new ArrayList<>();
        //     Deque<TreeNode> cur = new ArrayDeque<>();
        //     cur.add(root);
        //     while (!cur.isEmpty()) {
        //         int n = cur.size();
        //         for (int i = 0; i < n; i++) {
        //             TreeNode node = cur.poll();
        //             levels.add(node.val);
        //             if (node.left != null) {
        //                 cur.add(node.left);
        //             }
        //             if (node.right != null) {
        //                 cur.add(node.right);
        //             }
        //         }
        //         ans.add(levels);
        //         levels = new ArrayList<>();
        //     }
        //     return ans;
        // }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
