package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID24SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new ID24SwapNodesInPairs().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy, cur = head;
            while (cur != null && cur.next != null) {
                ListNode nxt = cur.next;
                ListNode nxt2 = nxt.next;
                cur.next = nxt.next;
                nxt.next = cur;
                pre.next = nxt;
                pre = cur;
                cur = nxt2;
            }
            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
