package leetcode.editor.cn;

import java.util.*;

public class ID49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new ID49GroupAnagrams().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        solution.groupAnagrams(strs);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars); // 排序后作为键
                String key = new String(chars);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
