package leetcode.editor.cn;

import java.util.*;

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

        /*优化写法*/
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            List<List<String>> ans = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                char[] c = strs[i].toCharArray();
                Arrays.sort(c); // 排序完异构词都一样
                map.computeIfAbsent(new String(c), k -> new ArrayList<>()).add(strs[i]);
            }
            // for (Map.Entry<String, List<String>> entry : map.entrySet())
            //     ans.add(entry.getValue());
            // return ans;
            return new ArrayList<>(map.values());
        }

        /*暴力解法——多层嵌套map*/
        public List<List<String>> groupAnagrams1(String[] strs) {
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
                // 将string拆分成字符存储，并统计相同字符的个数——字母异位词有一样的map
                for (int j = 0; j < strs[i].length(); j++) {
                    char key = strs[i].charAt(j);
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                // Map 的相等性不依赖于键值对的顺序
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
