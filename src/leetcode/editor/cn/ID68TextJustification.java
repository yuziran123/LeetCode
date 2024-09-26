package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID68TextJustification {
    public static void main(String[] args) {
        Solution solution = new ID68TextJustification().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        solution.fullJustify(words, 16);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] words;
        int maxWidth;

        public List<String> fullJustify(String[] words, int maxWidth) {
            this.words = words;
            this.maxWidth = maxWidth;
            int curWidth = 0, n = words.length, begin = 0;
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                curWidth += words[i].length();
                if (curWidth > maxWidth) {
                    String cur = control(begin, i - 1);
                    ans.add(cur);
                    begin = i;
                    curWidth = words[i].length();
                }
                curWidth++;
            }
            // 处理最后一截——最后一部分可能 width <= maxWidth ；需要单独处理
            ans.add(control(begin, n - 1));
            return ans;
        }


        /**
         * 描述:分情况填充当前行
         */
        private String control(int begin, int end) {
            StringBuilder res = new StringBuilder();
            if (begin == end)
                res = oneWord(begin, res);
            else if (end == words.length - 1)
                res = lastRow(begin, end, res);
            else
                res = normal(begin, end, res);
            return res.toString();
        }

        /**
         * 一行一个单词，剩余填充空格
         */
        private StringBuilder oneWord(int index, StringBuilder builder) {
            int reaminWidth = maxWidth - words[index].length();
            builder.append(words[index]).append(" ".repeat(reaminWidth));
            return builder;
        }

        /**
         * 最后一行，剩余空格全部放在右边
         */
        private StringBuilder lastRow(int begin, int end, StringBuilder builder) {
            int reaminWidth = maxWidth;
            for (int i = begin; i < end; i++) {
                builder.append(words[i]).append(" ");
                reaminWidth = reaminWidth - words[i].length() - 1;
            }
            // 最后一个单词要单独处理
            builder.append(words[end]).append(" ".repeat(reaminWidth - words[end].length()));
            return builder;
        }

        /**
         * 描述:多余位置均匀填放空格，剩余空格位置从左往右放
         * 多余出来的空格，即不能平均的部分，这部分要按照从左到右依次分配
         * 比如，有4个单词，即3个间隔，一共有5个空格的话
         * 平均的话是每个间隔一个空格，还多了2个空格，从左到右分配
         * 最后的间隔就是前两个各占2个空格，最后一个占1个空格
         */
        private StringBuilder normal(int begin, int end, StringBuilder builder) {
            int curWidth = 0;
            for (int i = begin; i <= end; i++) {
                curWidth += words[i].length();
            }
            int num = end - begin; // 两个单词之间填空格
            int spaceCount = (maxWidth - curWidth) / num;
            int reaminWidth = (maxWidth - curWidth) % num;
            for (int i = begin; i < end; i++) {
                builder.append(words[i]).append(" ".repeat(spaceCount));
                if (reaminWidth-- > 0)
                    builder.append(" ");
            }
            builder.append(words[end]);
            return builder;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
