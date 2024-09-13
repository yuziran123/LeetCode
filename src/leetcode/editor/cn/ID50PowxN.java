package leetcode.editor.cn;

public class ID50PowxN {
    public static void main(String[] args) {
        Solution solution = new ID50PowxN().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0)
                return 1;
            else if (n == 1) {
                return x;// n == -2147483648此时-n超出了int表示范围，这里要特殊处理
            } else if (n == -2147483648) {
                n = (int) (((long) n) / 2);
                double res = myPow(x, n / 2);
                return res * res;
            } else {
                x = n > 0 ? x : (1 / x);
                n = n > 0 ? n : -n;
                double res = myPow(x, n / 2);
                if (n % 2 == 1)
                    return res * res * x;
                else
                    return res * res;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
