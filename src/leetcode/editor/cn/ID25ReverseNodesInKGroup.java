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
                // 测试当前链表剩余节点数是够k个
                ListNode test = cur;
                for (int i = 1; i <= k; i++) {
                    if (test == null) {
                        return dummy.next;
                    }
                    test = test.next;
                }

                // 每次反转前pre指空
                ListNode pre = null;
                ListNode curEnd = cur; // 当前组反转后的尾节点
                for (int i = 1; i <= k; i++) {
                    ListNode nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                preGroupEnd.next = pre;
                curEnd.next = cur; // 此时cur为下一组的首节点
                preGroupEnd = curEnd;
            }
            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
