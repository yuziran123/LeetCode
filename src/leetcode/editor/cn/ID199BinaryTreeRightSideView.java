package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
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
            if (root == null)
                return ans;
            List<TreeNode> cur = new ArrayList<>();
            List<TreeNode> next = new ArrayList<>();
            cur.add(root);
            while (!cur.isEmpty()) {
                // 记录当前层最后一个节点值，即每一层最右边的点
                ans.add(cur.get(cur.size() - 1).val);
                for (TreeNode node : cur) {
                    if (node.left != null)
                        next.add(node.left);
                    if (node.right != null)
                        next.add(node.right);
                }
                // cur = next; //二者共享一个实例
                cur = new ArrayList<>(next);
                next.clear(); // 每一层遍历完需要清楚当前的next
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
