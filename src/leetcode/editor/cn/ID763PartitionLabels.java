package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID763PartitionLabels {
    public static void main(String[] args) {
        Solution solution = new ID763PartitionLabels().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> partitionLabels(String s) {
            List<Integer> ans = new ArrayList<>();
            int[] last = new int[26];
            // 记录每个字母最后一次出现的索引
            for (int i = 0; i < s.length(); i++) {
                last[s.charAt(i) - 'a'] = i;
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);
                if (i == end) {
                    ans.add(end - start + 1);
                    start = end + 1; // 更新下一个区间起始位置
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
