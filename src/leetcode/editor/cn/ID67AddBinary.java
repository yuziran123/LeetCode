package leetcode.editor.cn;

public class ID67AddBinary {
    public static void main(String[] args) {
        Solution solution = new ID67AddBinary().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            int la = a.length();
            int lb = b.length();
            int n = la - lb;
            // 短的字符前面全部拼上"0"
            if (la > lb)
                b = "0".repeat(n) + b;
            else
                a = "0".repeat(-n) + a;
            // 从后往前加-需要逆置字符串
            StringBuilder A = new StringBuilder(a).reverse();
            StringBuilder B = new StringBuilder(b).reverse();
            // StringBuilder res = new StringBuilder(); //用A替代
            int carry = 0;
            for (int i = 0; i < A.length(); i++) {
                int sum = A.charAt(i) - '0' + B.charAt(i) - '0' + carry;
                carry = sum / 2;
                A.setCharAt(i, (char) ('0' + (sum % 2)));
            }
            if (carry == 1) // 还多了一个进位
                A.append("1");
            A.reverse(); // 从后往前加的，输出时需要逆序
            return A.toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
