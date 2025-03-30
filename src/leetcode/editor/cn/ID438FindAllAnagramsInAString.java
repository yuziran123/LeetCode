package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ID438FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new ID438FindAllAnagramsInAString().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 连续 可重复 任意组合
        public List<Integer> findAnagrams(String s, String p) {
            ArrayList<Integer> ans = new ArrayList<>();
            if (s == null || p == null || s.length() < p.length()) {
                return ans;
            }
            int[] pCount = new int[26];
            int[] window = new int[26];
            for (int i = 0; i < p.length(); i++) {
                pCount[p.charAt(i) - 'a']++;
            }
            int left = 0, right = 0;
            while (right < s.length()) {
                char currentChar = s.charAt(right);
                // 扩大窗口 右侧字符加入
                if (right - left + 1 <= p.length()) {
                    window[currentChar - 'a']++;
                }
                // 达到窗口大小
                if (right - left + 1 == p.length()) {
                    if (matches(pCount, window)) {
                        ans.add(left);
                    }
                    // 缩小窗口 左侧字符移除
                    char leftChar = s.charAt(left);
                    window[leftChar - 'a']--;
                    left++;
                }
                right++;
            }
            return ans;
        }

        // 判断是否为异位词
        private boolean matches(int[] a, int[] b) {
            for (int i = 0; i < 26; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    // 超时
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Character, Integer> subMap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char key = p.charAt(i);
            subMap.put(key, subMap.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (!subMap.containsKey(s.charAt(i))) {
                continue;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < i + p.length(); j++) {
                if (!subMap.containsKey(s.charAt(j))) {
                    break;
                }
                char key = s.charAt(j);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            if (map.equals(subMap)) {
                ans.add(i);
            }
        }
        return ans;
    }

}
