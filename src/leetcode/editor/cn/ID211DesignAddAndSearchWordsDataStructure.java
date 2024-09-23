package leetcode.editor.cn;

public class ID211DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args) {
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {
        private Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            int index;
            for (int i = 0; i < word.length(); i++) {
                index = word.charAt(i) - 'a';
                if (node.children[index] == null)
                    node.children[index] = new Node();
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        public boolean dfs(String word, int index, Node node) {
            if (index == word.length())
                return node.isEnd;
            if (word.charAt(index) == '.') {
                // 枚举当前所有非空的子节点，去匹配下一个字符
                for (Node child : node.children) {
                    if (child != null && dfs(word, index + 1, child))
                        return true;
                }
            } else {
                Node nxt = node.children[word.charAt(index) - 'a'];
                if (nxt != null && dfs(word, index + 1, nxt))
                    return true;
            }
            return false;
        }

        public class Node {
            Node[] children;
            boolean isEnd;

            public Node() {
                children = new Node[26];
                isEnd = false;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
