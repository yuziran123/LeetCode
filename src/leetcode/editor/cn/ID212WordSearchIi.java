package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ID212WordSearchIi {
    public static void main(String[] args) {
        Solution solution = new ID212WordSearchIi().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:字典树节点结构
         *
         * @param children 这个Map的每一个键值对都存储了当前节点的一个子节点
         * @param str      str是尾节点时，记录单词；其他为""
         */
        public class TrieNode {
            Map<Character, TrieNode> children;
            String str;     // 如果是尾节点，存储对应的单词

            TrieNode() {
                children = new HashMap<>();
                str = "";
            }
        }

        int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        char[][] board;
        int rows; // 行数
        int cols;// 列数
        TrieNode root;
        List<String> ans = new ArrayList<>();

        public List<String> findWords(char[][] board, String[] words) {
            this.rows = board.length;
            this.cols = board[0].length;
            this.board = board;

            // 构建words的字典树
            this.root = new TrieNode();
            for (String word : words) {
                if (word.length() <= rows * cols)
                    insert(word);
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++)
                    dfs(i, j, 0, root);
            }
            return ans;
        }

        /**
         * 将单词word插入字段数root
         */
        private void insert(String word) {
            TrieNode node = root;      // 从根节点开始构造这个word对应的路径节点
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                node.children.putIfAbsent(ch, new TrieNode());
                node = node.children.get(ch);
            }
            node.str = word;   // 尾节点记录单词，不是尾节点str=""
        }

        public void dfs(int x, int y, int len, TrieNode node) {
            char ch = board[x][y];
            if (!node.children.containsKey(ch))
                return;
            TrieNode cur = node;
            node = node.children.get(ch);
            if (node.str.length() > 0) {    // 当前节点时尾节点
                ans.add(node.str);
                node.str = "";          // 匹配过的单词，不重复匹配
            }
            /*当前节点没有后续字符了，那么这个节点一定是某个单词最后一个字符对应的节点。
            并且不是其他任何单词的前缀，因此匹配完了之后，可以将这个字符节点从其父节点的children列表中删除。
            不会影响搜索结果，但是这样剪枝，可以有效地提升搜索效率*/
            if (node.children.size() == 0) {
                cur.children.remove(ch);
                return;
            }
            board[x][y] = '*';  // 遍历过的用特殊字符表示，取代visited
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (isValid(newX, newY) && board[newX][newY] != '*' && len <= 10)
                    dfs(newX, newY, len++, node);// 继续访问下一个可探索单元格
            }
            board[x][y] = ch;// 非常重要：回溯前要恢复现场，将访问标记抹去
        }

        public boolean isValid(int x, int y) {
            return x < rows && y < cols && x >= 0 && y >= 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
