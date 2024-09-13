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
            StringBuilder res = new StringBuilder();
            char[] A = a.toCharArray();
            char[] B = b.toCharArray();
            int lenA = A.length;
            int lenB = B.length;
            int cur = 0;
            int carry = 0;
            for (int i = 0; i < Math.min(lenA, lenB); i++) {
                int add = (A[i] - '0') + (B[i] - '0') + carry;
                cur = add % 2;
                carry = add / 2;
                res.append(cur);
            }
            if (lenA == lenB) {
                if (carry == 1)
                    res.append(carry);
            } else if (lenA > lenB) {
                for (int i = lenB; i < lenA; i++) {
                    int add = (A[i] - '0') + carry;
                    cur = add % 2;
                    carry = add / 2;
                    res.append(cur);
                }
                if (carry == 1)
                    res.append(carry);
            } else {
                for (int i = lenA; i < lenB; i++) {
                    int add = (B[i] - '0') + carry;
                    cur = add % 2;
                    carry = add / 2;
                    res.append(cur);
                }
                if (carry == 1)
                    res.append(carry);
            }
            res.reverse();
            return res.toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
