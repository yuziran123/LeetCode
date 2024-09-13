package leetcode.editor.cn;

public class ID172FactorialTrailingZeroes {
    public static void main(String[] args) {
        Solution solution = new ID172FactorialTrailingZeroes().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            if (n == 0)
                return 0;
            int count = 0;
            int f = 1;
            for (int i = 1; i <= n; i++) {
                f = f * i;
                while (f % 10 == 0) {
                    f = f / 10;
                    count++;
                }
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
