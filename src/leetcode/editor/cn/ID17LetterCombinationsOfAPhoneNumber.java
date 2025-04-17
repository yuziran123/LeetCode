package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new ID17LetterCombinationsOfAPhoneNumber().new Solution();
        // 执行测试
        solution.letterCombinations("23");
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final String[] alphabet = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        char[] path;
        String digits;

        public List<String> letterCombinations(String digits) {
            int n = digits.length();
            if (n == 0) {
                return ans;
            }
            this.digits = digits;
            path = new char[n];
            DFS(0);
            return ans;
        }

        public void DFS(int i) {
            if (i == digits.length()) {
                ans.add(new String(path));
                return;
            }
            for (char c : alphabet[digits.charAt(i) - '0'].toCharArray()) {
                path[i] = c;
                DFS(i + 1);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
