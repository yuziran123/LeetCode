package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID206ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ID206ReverseLinkedList().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
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
