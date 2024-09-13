package leetcode.editor.cn;

public class ID191NumberOf1Bits {
    public static void main(String[] args) {
        Solution solution = new ID191NumberOf1Bits().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingWeight(int n) {
            // StringBuilder res = new StringBuilder();
            int mod = 0; // 余数
            int count = 0;
            while (n != 0) {
                mod = n % 2;
                if (mod == 1)
                    count++;
                n = n / 2;
                // res.append(mod);
            }
            // System.out.println(n + "====" + res.reverse().toString());
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
