package leetcode.editor.cn;

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
        public Node copyRandomList(Node head) {
            Node node = head;
            int index = 0;
            while (node != null) {
                node.random.val = index;
                node = node.next;
                index++;
            }
            node = head;
            while (node != null) {
                if (node.random.next != null)
                    node.random.val = node.random.next.val;
                node = node.next;
            }
            return head;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
