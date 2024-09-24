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
            int m = s.length();
            int n = t.length();
            char ch;
            Map<Character, Integer> charCount = new HashMap<>();    // 字符数量差值哈希表
            for (int i = 0; i < n; i++) {   // 哈希表初始化
                ch = t.charAt(i);
                charCount.putIfAbsent(ch, 0);
                charCount.put(ch, charCount.get(ch) + 1);
            }
            int diff = charCount.size();   // 统计当前滑动窗口未被覆盖的字符数，重复字符算一个，所以不能是n
            int left = 0, right = 0;    // 左闭右开，滑动窗口左右指针，right指向下一个要加入滑动窗口的字符
            int subBegin = left, minLen = m + 1;   //  最小滑动窗口的起始位置和长度，用于求解子串
            while (right <= m) {  // 确保最后一个字符也在考虑范围内
                if (diff > 0) {
                    if (right == m)
                        break;
                    ch = s.charAt(right++);
                    charCount.put(ch, charCount.getOrDefault(ch, 0) - 1);
                    if (charCount.get(ch) == 0)
                        diff--;
                } else {
                    if (right - left < minLen) {
                        minLen = right - left;
                        subBegin = left;
                    }
                    ch = s.charAt(left++);
                    charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
                    if (charCount.get(ch) == 1)
                        diff++;
                }
            }
            return minLen == m + 1 ? "" : s.substring(subBegin, subBegin + minLen); // substring：左闭右开
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
