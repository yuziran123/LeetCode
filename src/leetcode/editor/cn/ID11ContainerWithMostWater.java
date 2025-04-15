package leetcode.editor.cn;

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
        // left~right围成的面积，受矮侧的影响最大 / 如果想要寻求更大的area，只有移动矮侧
        public int maxArea(int[] height) {
            int result = 0, area = 0;
            int left = 0, right = height.length - 1;
            while (left < right) {
                area = (right - left) * Math.min(height[left], height[right]);
                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
                result = Math.max(result, area);
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
