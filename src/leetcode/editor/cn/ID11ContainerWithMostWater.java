package leetcode.editor.cn;

import java.util.*;

public class ID11ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ID11ContainerWithMostWater().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        // int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        // int[] nums = new int[]{1, 3, 2, 5, 25, 24, 5};
        int[] nums = new int[]{1, 5, 6, 7, 5, 8};
        solution.maxArea(nums);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea1(int[] height) {
            int result = 0, volume = 0, h = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    h = Math.min(height[i], height[j]);
                    volume = (j - i) * h;
                    result = Math.max(result, volume);
                }
            }
            return result;
        }

        public int maxArea(int[] height) {
            int i = 0, j = 1;
            int result = 0;
            int len = height.length;
            int oldResult = 0;
            while (i < len && j < len) {
                oldResult = result;
                result = Math.min(height[i], height[j]) * (j - i);
                if (result < oldResult) {
                    if (height[i] < height[j])
                        j++;
                    else
                        i++;
                } else {
                    j = i;
                    i++;
                }

            }
            return result;
        }
    }

// leetcode submit region end(Prohibit modification and deletion)

}
