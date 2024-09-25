package leetcode.editor.cn;

public class ID135Candy {
    public static void main(String[] args) {
        Solution solution = new ID135Candy().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int ans = n;
            int[] left = new int[n];
            int[] right = new int[n];
            // 从左往右
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1])
                    left[i] = left[i - 1] + 1;
            }
            ans += left[n - 1];
            // 从右往左——从n-2开始，故ans需要先加上n-1处孩子的糖果数
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1])
                    right[i] = right[i + 1] + 1;
                ans += Math.max(left[i], right[i]);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
