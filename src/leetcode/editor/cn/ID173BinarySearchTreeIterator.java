package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ID173BinarySearchTreeIterator {
    public static void main(String[] args) {
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class BSTIterator {
        Deque<TreeNode> deque = new ArrayDeque<>();

        public BSTIterator(TreeNode root) {
            leftDfs(root);
        }

        public int next() {
            TreeNode node = deque.pollLast();
            int ans = node.val;
            node = node.right;
            leftDfs(node);
            return ans;
        }

        public boolean hasNext() {
            return !deque.isEmpty();
        }

        public void leftDfs(TreeNode root) {
            while (root != null) {
                deque.add(root);
                root = root.left;
            }
        }
    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// leetcode submit region end(Prohibit modification and deletion)

}
