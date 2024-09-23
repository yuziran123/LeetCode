package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ID205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new ID205IsomorphicStrings().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            Map<Character, Character> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);
                if (map.containsKey(charS) && map.get(charS) != charT)
                    return false;
                map.put(charS, charT);
            }
            map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                char charS = s.charAt(i);
                char charT = t.charAt(i);
                if (map.containsKey(charT) && map.get(charT) != charS)
                    return false;
                map.put(charT, charS);
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
