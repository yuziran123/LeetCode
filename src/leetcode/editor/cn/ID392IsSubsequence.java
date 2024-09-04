package leetcode.editor.cn;

import java.util.*;

public class ID392IsSubsequence {
    public static void main(String[] args) {
        Solution solution = new ID392IsSubsequence().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int si = 0;
            int ti = 0;
            while (si < s.length() && ti < t.length()) {
                if (s.charAt(si) == t.charAt(ti)) {
                    si++;
                    ti++;
                } else {
                    ti++;
                }
            }
            if (si == s.length())
                return true;
            else
                return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
