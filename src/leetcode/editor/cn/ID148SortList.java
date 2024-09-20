package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID148SortList {
    public static void main(String[] args) {
        Solution solution = new ID148SortList().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:先分割再合并
         * Date 2024/9/21
         *
         * @param head
         * @return ListNode
         */
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) // 此时只有此次节点了，不用分割直接返回
                return head;
            //* 1.分割利用快慢指针找到链表中点：fast走的路程是slow两倍
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            // 此时slow指向链表中点
            ListNode nxt = slow.next;
            slow.next = null; // 将链表断开
            ListNode left = sortList(head);
            ListNode right = sortList(nxt);

            //* 2.分别将left，right指向的两个链表合并成一个有序链表
            ListNode dummy = new ListNode(0);
            ListNode ans = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    dummy.next = left;
                    left = left.next;
                } else {
                    dummy.next = right;
                    right = right.next;
                }
                dummy = dummy.next;
            }
            dummy.next = left != null ? left : right; // 指向剩余链表的其余节点

            return ans.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
