package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ID30SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new ID30SubstringWithConcatenationOfAllWords().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:滑动窗口 m*w
         * Date 2024/9/24
         *
         * @param s
         * @param words
         * @return List<Integer>
         */
        public List<Integer> findSubstring(String s, String[] words) {
            int n = s.length(), m = words.length, w = words[0].length();
            List<Integer> ans = new ArrayList<>();
            if (n < m * w)
                return ans;
            Map<String, Integer> map = new HashMap<>();  // 统计字符数组的单词-频率
            for (int i = 0; i < m; i++) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }

            for (int i = 0; i < w; i++) {
                Map<String, Integer> temp = new HashMap<>();
                for (int j = i; j + w <= n; j += w) {
                    String cur = s.substring(j, j + w); // 截取一个单词
                    temp.put(cur, temp.getOrDefault(cur, 0) + 1);
                    if (j >= i + m * w) { // 滑动窗口固定 m*w， 超出了范围要移除首单词
                        int preIndex = j - m * w;
                        String pre = s.substring(preIndex, preIndex + w); // 移除超出窗口长度的单词-首个单词
                        if (temp.get(pre) == 1)
                            temp.remove(pre);
                        else
                            temp.put(pre, temp.get(pre) - 1);
                        // 剪枝2
                        if (!map.getOrDefault(pre, 0).equals(temp.getOrDefault(pre, 0)))
                            continue;
                    }
                    // 剪枝1
                    if (!map.getOrDefault(cur, 0).equals(temp.getOrDefault(cur, 0)))
                        continue;
                    if (map.equals(temp))
                        ans.add(j + w - m * w); // 最后一个单词的结束位置是 j + w
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
