package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ID230KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new ID230KthSmallestElementInABst().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 中序遍历——设置计数器
        int count;
        int ans;

        public int kthSmallest(TreeNode root, int k) {
            this.count = k;
            inorder(root);
            return this.ans;
        }

        public void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);
            count--;
            if (count == 0)
                this.ans = root.val;
            inorder(root.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        // 中序遍历存入数组
        List<Integer> list = new ArrayList<>();

        public int kthSmallest(TreeNode root, int k) {
            inorder(root);
            return list.get(k - 1);
        }

        public void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }
    }
}
