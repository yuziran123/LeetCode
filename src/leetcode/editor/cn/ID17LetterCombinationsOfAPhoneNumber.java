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
            if (n == 0)
                return ans;
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
    class Solution1 {
        private static final String[] alphabet =
                new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            StringBuilder str = new StringBuilder();
            if (digits.length() == 1) {
                for (char c : alphabet[digits.charAt(0) - '0'].toCharArray())
                    ans.add(String.valueOf(c));
                return ans;
            }
            backtrack(str, digits, new boolean[28], new boolean[digits.length()]);
            return new ArrayList<>(ans.subList(0, ans.size() / 2));
        }

        public void backtrack(StringBuilder record, String digits, boolean[] selected, boolean[] choiced) {
            if (record.length() == digits.length()) {
                ans.add(record.toString());
                return;
            }
            for (int i = 0; i < digits.length(); i++) {
                if (!choiced[i]) {
                    choiced[i] = true;
                    int index = digits.charAt(i) - '0';
                    char[] cur = alphabet[index].toCharArray();
                    for (int j = 0; j < cur.length; j++) {
                        selected[cur[j] - 'a'] = true;
                        record.append(cur[j]);
                        backtrack(record, digits, selected, choiced);
                        record.deleteCharAt(record.length() - 1);
                        selected[cur[j] - 'a'] = false;
                    }
                    choiced[i] = false;
                }
            }
        }
    }
}
