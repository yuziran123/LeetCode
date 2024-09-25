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
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1])
                    ans++;
            }
            for (int i = n - 2; i > 0; i--) {
                if (ratings[i] > ratings[i + 1] && ratings[i] < ratings[i - 1])
                    ans++;
            }
            if (ratings[0] > ratings[1])
                ans++;
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
