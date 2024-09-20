package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID23MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new ID23MergeKSortedLists().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode().of("1,4,5");
        lists[1] = new ListNode().of("1,3,4");
        lists[2] = new ListNode().of("2,6");
        solution.mergeKLists(lists);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:分治合并只有logk层，而顺序合并有k层：这是分支合并的根本优化
         */
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0)
                return null;
            return merge(lists, 0, len - 1);
        }

        public ListNode merge(ListNode[] lists, int L, int R) {
            if (L == R) // 此时只有一个链表，直接返回头节点
                return lists[L];
            int mid = (L + R) / 2;  // 选左中点：注意和构建二叉搜索树中点的区别
            ListNode left = merge(lists, L, mid);
            ListNode right = merge(lists, mid + 1, R);
            return mergeTwoLists(left, right);
        }

        public ListNode mergeTwoLists(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    dummy.next = left;
                    left = left.next;
                } else {
                    dummy.next = right;
                    right = right.next;
                }
                dummy = dummy.next;
            }
            dummy.next = left != null ? left : right;
            return head.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        // 每次合并两个链表
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0 || len == 1)
                return len == 0 ? null : lists[0];
            ListNode head = new ListNode(-1);
            ListNode ans = head;
            head.next = lists[0];
            for (int i = 1; i < len; i++) {
                ListNode H = mergeTwoLists(head.next, lists[i]);
                head.next = H;
            }
            return ans.next;
        }

        public ListNode mergeTwoLists(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    dummy.next = left;
                    left = left.next;
                } else {
                    dummy.next = right;
                    right = right.next;
                }
                dummy = dummy.next;
            }
            dummy.next = left != null ? left : right;
            return head.next;
        }

    }

}
