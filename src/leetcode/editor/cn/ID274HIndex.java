package leetcode.editor.cn;


import java.util.Arrays;

public class ID274HIndex {
    public static void main(String[] args) {
        Solution solution = new ID274HIndex().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            // 排序
            Arrays.sort(citations);
            // 数组元素全0，则h指数=0
            if (citations[len - 1] == 0)
                return 0;
            int i = 0;
            for (; i < len; i++) {
                // len - 1 - i ：≥当前文献引用数的文献个数
                if (len - 1 - i < citations[i])
                    break;
            }
            // len-i：≥当前引用数的文献个数
            return Math.min(len - i, citations[i]);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
