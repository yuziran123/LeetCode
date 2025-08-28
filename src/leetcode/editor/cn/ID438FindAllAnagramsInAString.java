package leetcode.editor.cn;

import java.util.ArrayList;
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
        // 通过比较窗口内字符频率与目标串p的频率，判断是否为异位词
        public List<Integer> findAnagrams(String s, String p) {
            ArrayList<Integer> ans = new ArrayList<>();

            int[] pCount = new int[26];
            int[] window = new int[26];
            for (int i = 0; i < p.length(); i++) {
                pCount[p.charAt(i) - 'a']++;
            }

            int left = 0, right = 0;
            while (right < s.length()) {
                // 扩大窗口 右侧字符加入
                if (right - left + 1 <= p.length()) {
                    window[s.charAt(right) - 'a']++;
                }
                // 达到窗口大小
                if (right - left + 1 == p.length()) {
                    if (matches(pCount, window)) {
                        ans.add(left);
                    }
                    // 缩小窗口 左侧字符移除
                    window[s.charAt(left) - 'a']--;
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
}
