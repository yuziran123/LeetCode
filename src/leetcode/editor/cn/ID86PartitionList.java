package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID86PartitionList {
    public static void main(String[] args) {
        Solution solution = new ID86PartitionList().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        // solution.partition(ListNode.of("1,4,3,2,5,2"), 3);
        solution.partition(ListNode.of("2,1"), 2);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 小的新建一个链表 大的新建一个 最后拼接起来
        public ListNode partition(ListNode head, int x) {
            // dummy    large_dummy分别保存新链表头的虚拟头节点
            ListNode dummy = new ListNode(-1);
            ListNode small = dummy;
            ListNode large_dummy = new ListNode(-1);
            ListNode large = large_dummy;
            ListNode cur = head;
            while (cur != null) {
                ListNode node = new ListNode(cur.val);
                if (cur.val < x) {
                    small.next = node;
                    small = node;
                } else {
                    large.next = node;
                    large = node;
                }
                cur = cur.next;
            }
            small.next = large_dummy.next;
            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
