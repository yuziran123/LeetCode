package leetcode.editor.cn;

public class ID208ImplementTriePrefixTree {
    public static void main(String[] args) {
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (node.childrens[index] == null)
                    node.childrens[index] = new Node();
                node = node.childrens[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Node node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        /**
         * 查找字典树是否包含word前缀
         */
        public Node searchPrefix(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                node = node.childrens[index];
                if (node == null)
                    return null;
            }
            return node;
        }

        /**
         * 描述: 每一层的节点并不是直接存储了某个字符，而是记录这一层节点对应字符串的位置是否出现了某个字符
         */
        private class Node {
            Node[] childrens;  // 子节点列表
            boolean isEnd;     // 是否是尾节点

            Node() {
                childrens = new Node[26];
                isEnd = false;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
