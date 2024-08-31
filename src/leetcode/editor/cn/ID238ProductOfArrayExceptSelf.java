package leetcode.editor.cn;

public class ID238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution solution = new ID238ProductOfArrayExceptSelf().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] arr = {1, 2, 3, 4, 5};
        int[] ints = solution.productExceptSelf(arr);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:
         * 1.不使用除法
         * 2.O(n)时间复杂度
         * Date 2024/8/29
         *
         * @param nums
         * @return int[]
         */
        public int[] productExceptSelf1(int[] nums) {
            int len = nums.length;
            int[] answer = new int[len];
            // i=（i-1）*（i+1）
            // 左边
            int[] left = new int[len];
            left[0] = 1;
            for (int i = 1; i < len; i++) {
                left[i] = left[i - 1] * nums[i - 1];
                if (left[i] == 0) break;
            }
            // 右边
            int[] right = new int[len];
            right[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                right[i] = right[i + 1] * nums[i + 1];
                if (right[i] == 0) break;
            }
            // ans=left*right
            for (int i = 0; i < len; i++) {
                answer[i] = left[i] * right[i];
            }
            return answer;
        }

        /**
         * 描述:空间优化版本
         */
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            // i=（i-1）*（i+1）
            // 左边
            int[] left = new int[len];
            left[0] = 1;
            for (int i = 1; i < len; i++) {
                left[i] = left[i - 1] * nums[i - 1];
                if (left[i] == 0) break;
            }
            // 右边
            int[] right = new int[len];
            right[len - 1] = 1;
            for (int i = len - 2; i >= 0; i--) {
                right[i] = right[i + 1] * nums[i + 1];
                if (right[i] == 0) break;
            }
            // ans=left*right
            for (int i = 0; i < len; i++) {
                left[i] = left[i] * right[i];
            }
            return left;
        }

    }

    // leetcode submit region end(Prohibit modification and deletion)
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] answer = new int[len];
        // O(N²)的时间复杂度——超时了
        for (int i = 0; i < len; i++) {
            answer[i] = 1;
            // 模运算
            int j = (i + 1) % len;
            while (j != i) {
                answer[i] = answer[i] * nums[j];
                j = (j + 1) % len; // 下标所以不可以是len
            }
        }
        return answer;
    }

}
