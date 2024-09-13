package leetcode.editor.cn;

public class ID9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new ID9PalindromeNumber().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            char[] arr = String.valueOf(x).toCharArray();
            int n = arr.length;
            for (int i = 0; i < n / 2; i++) {
                if (arr[i] != arr[n - 1 - i])
                    return false;
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
