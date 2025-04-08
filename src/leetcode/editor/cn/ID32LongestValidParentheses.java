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
        public int longestValidParentheses(String s) {
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
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        // 当前位置的前一个位置的有效括号长度为dp[i - 1]，再前面有一个左括号与当前位置的右括号匹配
                        // 更新当前位置的有效括号长度
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
