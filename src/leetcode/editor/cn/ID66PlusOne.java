package leetcode.editor.cn;

public class ID66PlusOne {
    public static void main(String[] args) {
        Solution solution = new ID66PlusOne().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            int carry = 0;
            int n = digits.length;
            digits[n - 1] += 1;
            for (int i = n - 1; i >= 0; i--) {
                int sum = digits[i] + carry;
                digits[i] = sum % 10;
                carry = sum / 10;
                if (carry == 0)
                    return digits;
            }
            int[] ans = new int[n + 1];
            ans[0] = 1;
            System.arraycopy(digits, 0, ans, 1, digits.length);
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
