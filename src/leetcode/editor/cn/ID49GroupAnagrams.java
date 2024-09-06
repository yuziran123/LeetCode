package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ID49GroupAnagrams {
    public static void main(String[] args) {
        Solution solution = new ID49GroupAnagrams().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        String[] strs = new String[1];
        solution.groupAnagrams(strs);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*暴力解法——多层嵌套map*/
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> ans = new ArrayList<>();
            List<String> list = new ArrayList<>();
            int n = strs.length;

            if (n == 0) {
                list.add("");
                ans.add(list);
                return ans;
            }

            Map<Map<Character, Integer>, List<String>> record = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                Map<Character, Integer> map = new HashMap<>();
                for (int j = 0; j < strs[i].length(); j++) {
                    char key = strs[i].charAt(j);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                if (record.containsKey(map)) {
                    List<String> list1 = record.get(map);
                    list1.add(strs[i]);
                    record.put(map, list1);
                } else {
                    List<String> list2 = new ArrayList<>();
                    list2.add(strs[i]);
                    record.put(map, list2);
                }
            }

            for (Map.Entry<Map<Character, Integer>, List<String>> entry : record.entrySet()) {
                ans.add(entry.getValue());
            }

            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
