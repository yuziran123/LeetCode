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
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            // 双端队列 —— 明确在使用双端队列功能，推荐使用 peekFirst()/peekLast()
            Deque<Integer> deque = new LinkedList<>(); // 维护当前窗口索引
            for (int i = 0; i < n; i++) {
                // 移除超出窗口范围索引
                while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                // 移除小于当前元素索引
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                deque.offerLast(i); // 添加当前元素索引

                // 窗口大小=k 记录最大值
                if (i >= k - 1) {
                    if (!deque.isEmpty()){
                        ans[i - k + 1] = nums[deque.peekFirst()];
                    }
                }
            }

            return ans;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
