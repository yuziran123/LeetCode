package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ID138CopyListWithRandomPointer {
    public static void main(String[] args) {
        Solution solution = new ID138CopyListWithRandomPointer().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // Definition for a Node.
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*哈希表法——Map<源节点，新节点>*/
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            // 1.第一次遍历——复制源节点的值
            while (cur != null) {
                Node node = new Node(cur.val);
                map.put(cur, node);
                cur = cur.next;
            }
            // 2.第二次遍历——复制源节点的next和random
            cur = head;
            while (cur != null) {
                //map.get(cur)——cur对应的新节点
                Node node = map.get(cur);
                if (cur.next != null)
                    node.next = map.get(cur.next);
                if (cur.random != null)
                    node.random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)
    public Node copyRandomList(Node head) {
        // 1.复制当前节点
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        // 2.修改新链表的random——复制节点的random指向原节点random的next
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3.拆分链表
        Node dummy = new Node(0);
        cur = dummy;
        Node original = head;
        while (original != null) {
            cur.next = original.next;
            original.next = cur.next.next;
            original = original.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
