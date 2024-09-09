package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new ID2AddTwoNumbers().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        // solution.addTwoNumbers(ListNode.of("0,8,6,5,6,8,3,5,7"),
        //         ListNode.of("6,7,8,0,8,5,8,9,7"));
        solution.addTwoNumbers(ListNode.of("2,4,9"), ListNode.of("5,6,4,9"));
        // solution.addTwoNumbers(ListNode.of("2,4,3"), ListNode.of("5,6,4"));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:新建链表，按值插入——要处理的细节很多
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode p1 = l1, p2 = l2;
            ListNode head = new ListNode();
            ListNode ansHead = head;
            int sum = p1.val + p2.val; // 表示和
            int carry = 0; // 表示进位
            head.val = sum % 10;
            carry = sum / 10;
            p1 = p1.next;
            p2 = p2.next;
            while (p1 != null && p2 != null) {
                ListNode node = new ListNode();
                sum = p1.val + p2.val + carry;
                node.val = sum % 10;
                carry = sum / 10;
                head.next = node;
                head = head.next;
                p1 = p1.next;
                p2 = p2.next;
            }
            while (p1 != null) {
                sum = p1.val + carry;
                p1.val = sum % 10;
                carry = sum / 10;
                head.next = p1;
                head = head.next;
                p1 = p1.next;
            }
            while (p2 != null) {
                sum = p2.val + carry;
                p2.val = sum % 10;
                carry = sum / 10;
                head.next = p2;
                head = head.next;
                p2 = p2.next;
            }
            if (carry == 1) {
                ListNode node = new ListNode();
                node.val = 1;
                head.next = node;
            }
            return ansHead;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
