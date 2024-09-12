package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.*;

public class ID103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new ID103BinaryTreeZigzagLevelOrderTraversal().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        solution.zigzagLevelOrder(new TreeNode().stringToTree("1,2,3,4,null,null,5"));
        // solution.zigzagLevelOrder(new TreeNode().stringToTree("3,9,20,null,null,15,7"));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)
                return ans;
            List<Integer> vals = new ArrayList<>();
            Deque<TreeNode> cur = new ArrayDeque<>();
            cur.add(root);
            boolean flag = true;
            while (!cur.isEmpty()) {
                int n = cur.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = cur.poll();
                    if (node.left != null)
                        cur.add(node.left);
                    if (node.right != null)
                        cur.add(node.right);
                    vals.add(node.val);
                }
                if (!flag)
                    Collections.reverse(vals);// 单数层将当前数组倒序
                ans.add(vals);
                vals = new ArrayList<>();
                flag = !flag;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
