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
        /**
         * 描述:队列实现层序遍历
         * Date 2024/9/12
         *
         * @param root
         * @return List<List < Integer>>
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null)
                return ans;
            List<Integer> vals = new ArrayList<>();
            Deque<TreeNode> cur = new ArrayDeque<>();
            cur.add(root);
            while (!cur.isEmpty()) {
                int n = cur.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = cur.poll();
                    vals.add(node.val);
                    if (node.left != null)
                        cur.add(node.left);
                    if (node.right != null)
                        cur.add(node.right);
                }
                ans.add(vals);
                vals = new ArrayList<>();
                // 这段代码清空了 vals 列表中的所有元素，但 vals 的引用并没有改变。
                // 如果在调用 vals.clear() 后再将 vals 添加到 ans，ans 中将只会包含一个空的 vals 列表。
                // vals.clear();
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
