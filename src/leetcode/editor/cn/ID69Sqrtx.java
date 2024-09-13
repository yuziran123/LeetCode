package leetcode.editor.cn;

public class ID69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new ID69Sqrtx().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.mySqrt(2147395600);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x == 0 || x == 1)
                return x;
            if (x == 2 || x == 3)
                return 1;
            int ans = 1;
            for (int i = x / 2; i >= 1; ) {
                if ((double) i * i <= x) {
                    while ((double) i * i <= x)
                        i++;
                    ans = i - 1;
                    break;
                } else
                    i = i / 2;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
