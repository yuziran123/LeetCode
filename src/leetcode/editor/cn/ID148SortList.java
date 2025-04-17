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
         * 描述: 使用归并排序对链表进行排序
         *
         * @param head 链表头节点
         * @return 排序后的链表头节点
         */
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head; // 如果链表为空或只有一个节点，直接返回
            }

            // 1. 分割链表：使用快慢指针找到链表中点
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode mid = slow.next; // 中点的下一个节点
            slow.next = null; // 将链表断开

            // 递归排序左右两部分
            ListNode left = sortList(head);
            ListNode right = sortList(mid);

            // 2. 合并两个有序链表
            return merge(left, right);
        }

        // 合并两个有序链表
        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0); // 创建虚拟头节点
            ListNode cur = dummy;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            // 拼接剩余部分
            cur.next = (l1 != null ? l1 : l2);
            return dummy.next; // 返回合并后的链表头节点
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}
