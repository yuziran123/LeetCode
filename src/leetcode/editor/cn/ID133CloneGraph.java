package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID133CloneGraph {
    public static void main(String[] args) {
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public Node cloneGraph(Node node) {
            Node root = new Node();
            return root;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
