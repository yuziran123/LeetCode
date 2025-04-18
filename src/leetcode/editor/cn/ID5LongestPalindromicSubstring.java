package leetcode.editor.cn;

public class ID5LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new ID5LongestPalindromicSubstring().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandParliament(s, i, i); // 以i为中心寻找
                int len2 = expandParliament(s, i, i + 1); // 以(i i+1)为中心寻找
                int maxLen = Math.max(len1, len2);
                if (maxLen > end - start) { // 更新最大回文串的起始索引
                    start = i - (maxLen - 1) / 2;
                    end = i + maxLen / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        // 从中间向两边扩散 寻找最大回文串长度
        private int expandParliament(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // 不满足回文条件退出循环 所以左右都多移动一次
            return right - left - 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
