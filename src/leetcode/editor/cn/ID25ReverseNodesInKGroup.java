package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ID25ReverseNodesInKGroup().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.reverseKGroup(ListNode.of("1,2,3,4,5"), 3);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 本质还是反转链表的思路
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0, head);
            ListNode preGroupEnd = dummy, cur = head;
            while (cur != null) {
                // 1.测试当前链表剩余节点数是够k个
                ListNode test = cur;
                for (int i = 1; i <= k; i++) {
                    if (test == null) {
                        return dummy.next;
                    }
                    test = test.next;
                }

                // 2.反转当前子链表
                // 每次反转前pre指空
                ListNode pre = null;
                ListNode curEnd = cur; // 当前组反转后的尾节点
                for (int i = 1; i <= k; i++) {
                    ListNode nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                // 3.处理子链表反转后的前后节点
                // preGroupEnd.next = pre;：将前一组的尾节点指向当前组反转后的头节点。
                // curEnd.next = cur;：将当前组反转后的尾节点指向下一组的头节点（即未反转部分的起始节点）。
                // preGroupEnd = curEnd;：更新前一组的尾节点为当前组的尾节点，以便处理下一组。
                preGroupEnd.next = pre;
                curEnd.next = cur; // 此时cur为下一组的首节点
                preGroupEnd = curEnd;
            }
            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
