package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

public class ID160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        Solution solution = new ID160IntersectionOfTwoLinkedLists().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        /*相交时
        链表一样长，走的步数一样
        链表不一样长 a走完直接从b开始走 ; b走完直接从a开始走 一样的步数后依旧相交于非空节点
        不相交 一样的步长后相交于空节点*/
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;
            while (p != q) {
                p = (p != null ? p.next : headB);
                q = (q != null ? q.next : headA);
            }
            return p;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
