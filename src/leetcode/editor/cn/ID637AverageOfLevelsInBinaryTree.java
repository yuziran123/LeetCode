package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ID637AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new ID637AverageOfLevelsInBinaryTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.add(root);
            while (!deque.isEmpty()) {
                int n = deque.size();
                double sum = 0; // sum要用double，防止和溢出
                for (int i = 0; i < n; i++) {
                    TreeNode node = deque.poll();
                    sum += node.val;
                    if (node.left != null)
                        deque.add(node.left);
                    if (node.right != null)
                        deque.add(node.right);
                }
                ans.add((double) sum / n);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
