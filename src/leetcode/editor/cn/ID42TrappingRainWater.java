package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ID42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new ID42TrappingRainWater().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*单调栈*/
        public int trap(int[] height) {
            int ans = 0, n = height.length;
            Deque<Integer> stack = new ArrayDeque<>(); // 维持一个单调递减栈
            stack.push(0);
            for (int k = 1; k < n; k++) {
                while (!stack.isEmpty() && height[k] > height[stack.peek()]) {
                    int j = stack.poll();
                    if (stack.isEmpty())
                        break;
                    int i = stack.peek();
                    int width = k - i - 1;
                    ans += (Math.min(height[k], height[i]) - height[j]) * width;
                }
                stack.push(k);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /*雨水 = sum(leftMax) + sum(rightMax) - sum(height[i]) - 整个长方形*/
    public int trap(int[] height) {
        int maxLeft = 0, maxRight = 0, ans = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            maxRight = Math.max(maxRight, height[(n - 1) - i]);
            ans += maxLeft + maxRight - height[i];
        }
        return ans - maxLeft * n; // return ans - maxRight * n;
    }
}
