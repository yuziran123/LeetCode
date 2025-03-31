package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new ID234PalindromeLinkedList().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 1.快慢指针找中间节点
     * 2.反转半截链表进行比较
     */
    class Solution {
        // 一个走一步一个走两步 二者相交 走一步的在中点
        public boolean isPalindrome(ListNode head) {
            ListNode mid = findMid(head);
            ListNode q = reverseList(mid);
            ListNode p = head;
            while (q != null) {
                if (p.val != q.val) {
                    return false;
                }
                q = q.next;
                p = p.next;
            }
            return true;
        }

        // 快慢指针找链表中间点
        private ListNode findMid(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

        // 翻转链表
        private ListNode reverseList(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
            }
            return pre;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
