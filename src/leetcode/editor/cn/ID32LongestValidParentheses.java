package leetcode.editor.cn;

public class ID32LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ID32LongestValidParentheses().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidParentheses1(String s) {
            if (s == null) {
                return 0;
            }

            // 初始化最大长度为0
            int maxLength = 0;
            // dp数组用于动态规划，存储到当前位置为止的最长有效括号子串长度
            int[] dp = new int[s.length()];

            // 使用动态规划求解
            for (int i = 1; i < s.length(); i++) {
                // 当前字符为右括号时，尝试更新dp数组
                if (s.charAt(i) == ')') {
                    // 前一个字符为左括号，形成一对有效括号
                    if (s.charAt(i - 1) == '(') {
                        // 当前位置的有效括号长度为前两个位置的长度加2
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                        //  dp[i - 1]的含义：表示以i-1位置结尾的最长有效括号子串的长度
                        //  i - dp[i - 1] - 1：从当前位置i向前跳过dp[i - 1]个已经匹配的有效括号，再向前一个位置，判断该位置是否为左括号(。
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        // 当前位置的前一个位置的有效括号长度为dp[i - 1]，再前面有一个左括号与当前位置的右括号匹配
                        dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    // 更新最大长度
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
            return maxLength;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
