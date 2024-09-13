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
            StringBuilder str = new StringBuilder(String.valueOf(n)).reverse();
            n = 0;
            n = Integer.parseInt(str.toString(), 2);
            return n;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
