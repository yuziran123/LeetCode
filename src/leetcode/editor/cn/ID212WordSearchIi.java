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
         * 字典树节点结构
         */
        public class TrieNode {
            Map<Character, TrieNode> children;
            String str; // 如果是尾节点，存储对应的单词

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
                if (word.length() > rows * cols) continue;  // 字符串长度超过二维矩阵尺寸，肯定无法构成
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
                node.children.putIfAbsent(ch, new TrieNode());// 字符ch对应的节点不存在，新建一个
                node = node.children.get(ch);// 更新node
            }
            node.str = word;   // 尾节点记录单词，用于后序查找的时候快速得到
        }

        public void dfs(int x, int y, int len, TrieNode node) {
            if (len > 10) return; // 题目：单词长度不超过10
            char ch = board[x][y];
            if (!node.children.containsKey(ch)) return;
            TrieNode cur = node;
            node = node.children.get(ch);  // 更新当前node为当前字符对应得到的节点
            if (node.str.length() > 0) {
                ans.add(node.str);    // 当前节点记录了一个单词，则得到了一个words中的单词
                node.str = "";     // 匹配了单词，不重复匹配
            }
            if (node.children.size() == 0) {
                cur.children.remove(ch);// 当前节点没有后序字符了，那么这个节点一定是某个单词最后一个字符对应的节点。
                return; // 并且不是其他任何单词的前缀，因此匹配完了之后，可以将这个字符从其父节点的childran列表中删除。
            }
            board[x][y] = '*';  // 遍历过的用特殊字符表示，取代visited
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (isValid(newX, newY) && board[newX][newY] != '*')
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
