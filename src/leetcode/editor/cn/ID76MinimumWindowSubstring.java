package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ID76MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new ID76MinimumWindowSubstring().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (s == null || t == null || s.length() == 0 || t.length() == 0) {
                return "";
            }
            Map<Character, Integer> hash = new HashMap<>();
            Map<Character, Integer> window = new HashMap<>();
            StringBuilder sb = new StringBuilder();
            for (char c : t.toCharArray()) {
                hash.put(c, hash.getOrDefault(c, 0) + 1); // 当前子串出现频率
            }
            int left = 0, right = 0; // 左闭右开
            int valid = 0;  // 匹配上的字符数
            int start = 0, len = Integer.MAX_VALUE; // 记录最小窗口的 起始和长度
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;    // 扩展窗口

                if (hash.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(hash.get(c))) {
                        valid++;
                    }
                    // 所有字符都匹配上了 尝试缩小窗口——左侧可能有冗余的字符
                    while (valid == hash.size()) {
                        if (right - left < len) { // 当前窗口更小则更新记录
                            start = left;
                            len = right - left;
                        }
                        char cc = s.charAt(left);
                        left++;

                        if (hash.containsKey(cc)) {
                            // 如果是子串的字符——更新窗口数据
                            if (window.get(cc).equals(hash.get(cc))) {
                                valid--;
                            }
                            window.put(cc, window.get(cc) - 1);
                        }
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
