package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new ID82RemoveDuplicatesFromSortedListIi().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        // solution.deleteDuplicates(ListNode.of("1,2,3,3,4,4,5"));
        solution.deleteDuplicates(ListNode.of("1,1"));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*指针法*/
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode cur = dummy;
            // 要比较的是下一个节点和下下一个节点的值
            while (cur.next != null && cur.next.next != null) {
                int val = cur.next.val;
                if (val == cur.next.next.val) {
                    while (cur.next != null && cur.next.val == val)
                        cur.next = cur.next.next; //更新下一个节点，直到不再重复当前val
                } else
                    cur = cur.next;
            }
            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /*哈希表法优化版——不新建链表*/
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        int[] hash = new int[201];
        while (cur != null) {
            hash[cur.val + 100]++; // 让所有的节点值右偏移100，防止出现负的索引值
            cur = cur.next;
        }
        ListNode pre = dummy;
        cur = head;
        while (cur != null) {
            if (hash[cur.val + 100] != 1) {
                while (cur != null && hash[cur.val + 100] != 1)
                    cur = cur.next;
                pre.next = cur;
            }
            pre = cur;
            if (cur != null)
                cur = cur.next;
        }
        return dummy.next;
    }

    /*哈希表法*/
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode cur = head;
        int[] hash = new int[201];
        while (cur != null) {
            hash[cur.val + 100]++; // 让所有的节点值右偏移100，防止出现负的索引值
            cur = cur.next;
        }
        // p在迭代中不断更新——使用虚拟头节点dummy，可以正确返回链表的起始节点
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (int i = 0; i < 201; i++) {
            if (hash[i] == 1) {
                ListNode node = new ListNode(i - 100);
                p.next = node;
                p = node;
            }
        }
        return dummy.next;
    }
}
