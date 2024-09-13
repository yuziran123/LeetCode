package leetcode.editor.cn;

public class ID201BitwiseAndOfNumbersRange {
    public static void main(String[] args) {
        Solution solution = new ID201BitwiseAndOfNumbersRange().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            while (left < right)
                right = right & (right - 1);
            return right;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
