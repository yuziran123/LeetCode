package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID21MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new ID21MergeTwoSortedLists().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        ListNode p = new ListNode();
        solution.mergeTwoLists(ListNode.of("1,2,4"), ListNode.of("1,3,4"));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode l1 = list1;
            ListNode l2 = list2;
            ListNode head = new ListNode();
            ListNode p = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    p.next = l1;
                    l1 = l1.next;
                } else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            // 合并剩余链表部分
            p.next = (l1 == null ? p.next : l1);
            p.next = (l2 == null ? p.next : l2);
            return head.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
