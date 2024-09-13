package leetcode.editor.cn;

public class ID190ReverseBits {
    public static void main(String[] args) {
        Solution solution = new ID190ReverseBits().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                result <<= 1;               // 将结果左移一位
                result |= (n & 1);         // 将n的最低位加到结果中
                n >>= 1;                   // 将n右移一位，处理下一个位
            }
            return result;
            // return Integer.reverse(n);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
