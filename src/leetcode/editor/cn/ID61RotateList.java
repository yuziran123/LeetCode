package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID61RotateList {
    public static void main(String[] args) {
        Solution solution = new ID61RotateList().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.rotateRight(ListNode.of("1,2,4"), 20000);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null)
                return head;
            ListNode dummy = new ListNode(-1, head);
            ListNode pre = head;    // 尾节点的前驱节点
            ListNode tail = head; // 尾节点
            int len = 1;
            // 找链表当前尾节点，并统计链表长度
            while (tail.next != null) {
                tail = tail.next;
                len++;
            }
            tail = head;
            for (int i = 0; i < k % len; i++) {
                while (tail.next != null) {
                    pre = tail;
                    tail = tail.next;
                }
                // 将尾节点插入虚拟节点后
                tail.next = dummy.next;
                dummy.next = tail;
                pre.next = null;
            }
            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
