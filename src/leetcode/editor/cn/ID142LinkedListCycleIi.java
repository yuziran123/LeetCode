package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

import java.util.HashSet;

public class ID142LinkedListCycleIi {
    public static void main(String[] args) {
        Solution solution = new ID142LinkedListCycleIi().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        /**
         * 快慢指针法——要一定的数学推导
         * 1.假设环形前有a个点 环形有b个点
         * 2.fast和slow相遇时，有f=2*s（fast走两步一次）；f=s+n*b（fast比slow夺走了n圈）
         * 3.推出，相遇时slow一共走了n*b
         * 4.走到环形入口一定需要需要走a+N*b
         * 5.故此时slow只需再走a步就可以到达入口，而head到入口正好是a步
         */
        public ListNode detectCycle(ListNode head) {
            if (head == null)
                return null;
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) { // 此时相遇 slow和head都走a步在入口相遇
                    // ListNode node = head;
                    fast = head; // 内存优化
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return fast;
                }
            }
            return null;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    // 标记法——给访问过的节点赋予一个不一样的值
    public ListNode detectCycle2(ListNode head) {
        if (head == null)
            return null;
        ListNode node = head;
        while (node != null) {
            if (node.val == 100002)
                return node;
            node.val = 100002;
            node = node.next;
        }
        return null;
    }

    // 哈希表法
    public ListNode detectCycle1(ListNode head) {
        if (head == null)
            return null;
        ListNode node = head;
        HashSet<ListNode> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node))
                return node;
            set.add(node);
            node = node.next;
        }
        return null;
    }
}
