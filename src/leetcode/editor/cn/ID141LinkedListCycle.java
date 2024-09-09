package leetcode.editor.cn;

import leetcode.editor.util.ListNode;

import java.util.HashSet;

public class ID141LinkedListCycle {
    public static void main(String[] args) {
        Solution solution = new ID141LinkedListCycle().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        ListNode node = ListNode.of("-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5");
        solution.hasCycle(node);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        /*快慢指针：相遇的位置不确定*/
        public boolean hasCycle(ListNode head) {
            if (head == null)
                return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                    return true;
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    // 哈希表法
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visitedNodes = new HashSet<>();
        // 修改 head 可能会导致链表丢失。
        // 使用额外的 current 指针，可以在不改变原链表结构的情况下遍历链表。
        ListNode current = head;
        while (current != null) {
            if (visitedNodes.contains(current))
                return true;

            visitedNodes.add(current);
            current = current.next;
        }
        // 遍历完链表后没有发现环
        return false;
    }
}
