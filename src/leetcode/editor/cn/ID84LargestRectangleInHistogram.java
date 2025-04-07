package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ID84LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new ID84LargestRectangleInHistogram().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 核心思想：
         * 通过维护一个单调递增栈，可以快速找到每个柱子左右两侧第一个比它矮的柱子的位置，从而计算以该柱子为高的矩形面积。
         * 宽度由当前柱子的索引 i 和栈中剩余元素决定：
         * 如果栈为空，则说明当前柱子左侧没有比它矮的柱子，宽度为 i。
         * 如果栈不为空，则栈顶元素是当前柱子左侧第一个比它矮的柱子的索引，宽度为 i - stack.peek() - 1。
         * 当遇到一个比栈顶柱子矮的柱子时，说明栈顶柱子的右侧第一个比它矮的柱子已经找到（即当前遍历到的柱子），此时可以计算以栈顶柱子为高的矩形面积
         * <p>
         * 对于每个柱子包括哨兵节点
         * 当前柱子高度小于栈顶 则栈顶弹出 并计算以该柱子为高的矩形面积
         * 矩形的宽度由当前索引与栈中剩余元素决定
         * <p>
         * 哨兵作用：
         * 在遍历数组的过程中，单调栈会将柱子索引压入栈中。
         * 如果数组中的柱子高度是递增的（例如 [1, 2, 3, 4]），那么遍历结束后栈中仍然会保留这些柱子的索引。
         * 这些柱子对应的矩形面积还没有被计算
         * 哨兵节点的高度为 0，比任何柱子的高度都小。
         * 当遍历到哨兵节点时，它会触发栈中所有柱子的弹出操作，从而确保每个柱子的矩形面积都被计算
         * <p>
         * Date 2025/4/7
         */
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int ans = 0;
            // 单调递增栈
            Deque<Integer> stack = new ArrayDeque<>();
            // 计算以每个柱子为高度的矩形面积
            for (int i = 0; i <= n; i++) {
                // 设置哨兵节点 确保所有的柱子都可以计算
                int curHeight = (i == n) ? 0 : heights[i];
                while (!stack.isEmpty() && curHeight < heights[stack.peek()]) { // 栈顶元素右侧第一个比他矮的柱子出现了
                    int height = heights[stack.pop()];
                    // 栈空：左侧没有比当前柱子更矮的
                    int width = (stack.isEmpty()) ? i : i - stack.peek() - 1; // 减去左侧就是当前柱子的最大矩形面积
                    ans = Math.max(ans, height * width);
                }
                stack.push(i);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
