package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        solution.connect(root);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 利用队列层序遍历——每层的最后一个节点next指向null
        Deque<Node> deque = new ArrayDeque<>();

        public Node connect(Node root) {
            if (root == null)
                return root;
            deque.add(root);
            while (!deque.isEmpty()) {
                int n = deque.size();
                for (int i = 0; i < n; i++) {
                    Node node = deque.poll();
                    if (node.left != null)
                        deque.add(node.left);
                    if (node.right != null)
                        deque.add(node.right);
                    if (i == n - 1)
                        node.next = null;
                    else
                        node.next = deque.getFirst();
                }
            }
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
