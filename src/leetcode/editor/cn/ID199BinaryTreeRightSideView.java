package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ID199BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new ID199BinaryTreeRightSideView().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        List<Integer> list = solution.rightSideView(new TreeNode().stringToTree("1,2,3,null,5,null,4"));
        System.out.println(list);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:双数组——层序遍历，记录每一层的最后一个节点值
         */
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node.left != null)
                        deque.add(node.left);
                    if (node.right != null)
                        deque.add(node.right);
                    if (i == size - 1)
                        ans.add(node.val);
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
