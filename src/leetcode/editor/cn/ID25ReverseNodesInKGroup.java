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
            ListNode sentry = new ListNode(0, head);
            ListNode p0 = sentry;
            ListNode cur = head;
            while (cur != null) {
                // 测试当前链表剩余节点数是够k个
                ListNode test = cur;
                for (int i = 1; i <= k; i++) {
                    if (test == null)
                        return sentry.next;
                    test = test.next;
                }

                // 每次反转前pre指空
                ListNode pre = null;
                for (int i = 1; i <= k; i++) {
                    ListNode nxt = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nxt;
                }
                ListNode temp = p0.next;
                p0.next.next = cur;
                p0.next = pre;
                // 反转链表部分的前一个节点需要更新记录
                p0 = temp;
            }
            return sentry.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
