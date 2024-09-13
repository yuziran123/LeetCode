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
            if (n > 0) {
                if (n == 1)
                    return x;
                else {
                    double res = myPow(x, n / 2);
                    if (n % 2 == 1)
                        return res * res * x;
                    else
                        return res * res;
                }
            } else {
                x = 1 / x;
                n = n == -2147483648 ? -n - 1 : -n;
                if (n == 1)
                    return x;
                else {
                    double res = myPow(x, n / 2);
                    if (n % 2 == 1)
                        return res * res * x;
                    else
                        return res * res;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
