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
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] answer = new int[len];
            // O(N²)的时间复杂度——超时了
            for (int i = 0; i < len; i++) {
                nums[i] = nums[(i + len - 1) % len] * nums[(i + 1) % len];

            }
            return answer;
        }

    }

    // leetcode submit region end(Prohibit modification and deletion)
   /* public int[] productExceptSelf(int[] nums) {
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
    }*/
}
