package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public class ID127WordLadder {
    public static void main(String[] args) {
        Solution solution = new ID127WordLadder().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 和最小基因变化一样的处理思路
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            HashSet<String> set = new HashSet<>();
            Deque<String> deque = new ArrayDeque<>();
            set.add(beginWord);
            deque.offer(beginWord);
            int count = 0;
            while (!deque.isEmpty()) {
                int n = deque.size();
                count++;
                for (int i = 0; i < n; i++) {
                    String cur = deque.poll();
                    if (cur.equals(endWord))
                        return count;
                    for (String str : wordList) {
                        if (isOneCharDiff(cur, str) && set.add(str))
                            deque.offer(str);
                    }
                }
            }
            return 0;
        }

        private static boolean isOneCharDiff(String a, String b) {
            int diffNum = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    diffNum++;
                    if (diffNum > 1) {
                        return false; // 超过一个不同字符
                    }
                }
            }
            return diffNum == 1; // 只有一个不同字符
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
