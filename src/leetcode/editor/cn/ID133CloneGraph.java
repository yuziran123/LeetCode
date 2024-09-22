package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Node, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null)
                return node;
            return dfs(node);
        }

        private Node dfs(Node node) {
            if (map.containsKey(node))
                return map.get(node);
            Node colne = new Node(node.val);
            map.put(node, colne);
            for (Node newNode : node.neighbors) {
                colne.neighbors.add(dfs(newNode));
            }
            return colne;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
