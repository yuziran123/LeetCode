package leetcode.editor.cn;

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class ID117PopulatingNextRightPointersInEachNodeIi {
    public static void main(String[] args) {
        Solution solution = new ID117PopulatingNextRightPointersInEachNodeIi().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node connect(Node root) {
            if (root == null)
                return root;

            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
