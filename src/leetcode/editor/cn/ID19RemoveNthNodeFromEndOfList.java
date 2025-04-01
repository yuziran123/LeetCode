package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID19RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new ID19RemoveNthNodeFromEndOfList().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int len = getLength(head);
            // 虚拟头节点 方便删除head节点
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode p = dummy;
            for (int i = 0; i < len - n; i++) {
                p = p.next;
            }
            p.next = p.next.next;
            return dummy.next;
        }

        private int getLength(ListNode head) {
            ListNode p = head;
            int len = 0;
            while (p != null) {
                len++;
                p = p.next;
            }
            return len;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
