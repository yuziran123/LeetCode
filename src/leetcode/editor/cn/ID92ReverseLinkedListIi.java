package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID92ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ID92ReverseLinkedListIi().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.reverseBetween(ListNode.of("1,2,3,4,5"), 2, 4);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            // 充当哨兵：会有从头节点开始反转的情况，哨兵指向头节点；这样p0就一定不为null
            ListNode sentry = new ListNode(0, head);
            ListNode p0 = sentry; // 反转位置的前一个
            int count = 1;
            while (count != left) {
                p0 = p0.next;
                count++;
            }
            ListNode pre = null;
            ListNode cur = p0.next;
            while (right >= left) { // 有right-left+1个节点要反转
                ListNode nxt = cur.next;
                cur.next = pre;
                pre = cur;
                cur = nxt;
                left++;
            }
            // 画个示意图就清晰了
            p0.next.next = cur;
            p0.next = pre;
            return sentry.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
