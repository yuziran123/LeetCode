package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class ID239SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new ID239SlidingWindowMaximum().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 使用双端队列动态维护当前窗口内的递减元素索引，确保队首始终是窗口最大值。
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            // 双端队列 —— 明确在使用双端队列功能，推荐使用 peekFirst()/peekLast()
            Deque<Integer> deque = new LinkedList<>(); // 存储索引，维护递减性
            for (int i = 0; i < n; i++) {
                // 移除窗口外的过期索引（左边界为i-k+1）
                while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }
                // 移除队列中比当前元素小的索引（它们不可能是最大值）
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }
                deque.offerLast(i); // 添加当前元素索引

                // 窗口大小=k 记录最大值
                if (i >= k - 1) {
                    ans[i - k + 1] = nums[deque.peekFirst()];
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
