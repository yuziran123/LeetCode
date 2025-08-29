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
         * 描述:分治合并只有logk层，而顺序合并有k层：这是分治合并的根本优化
         */
        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            if (len == 0) return null;
            return merge(lists, 0, len - 1);
        }

        public ListNode merge(ListNode[] lists, int L, int R) {
            if (L == R) { // 此时只有一个链表，直接返回头节点
                return lists[L];
            }
            int mid = (L + R) / 2;
            ListNode left = merge(lists, L, mid);
            ListNode right = merge(lists, mid + 1, R);
            return mergeTwoLists(left, right);
        }

        public ListNode mergeTwoLists(ListNode left, ListNode right) {
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    p.next = left;
                    left = left.next;
                } else {
                    p.next = right;
                    right = right.next;
                }
                p = p.next;
            }
            p.next = (left != null ? left : right);
            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
