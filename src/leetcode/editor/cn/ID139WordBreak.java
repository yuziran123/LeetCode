package leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ID139WordBreak {
    public static void main(String[] args) {
        Solution solution = new ID139WordBreak().new Solution();
        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public class TrieNode {
            Map<Character, TrieNode> children;
            String str;

            TrieNode() {
                children = new HashMap<>();
                str = "";
            }
        }

        TrieNode root;

        public boolean wordBreak(String s, List<String> wordDict) {
            this.root = new TrieNode();
            for (String word : wordDict) {
                insert(word);
            }
            while (s != null) {

            }
            return true;
        }

        private void insert(String word) {
            TrieNode node = root;      // 从根节点开始构造这个word对应的路径节点
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.str = word;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
