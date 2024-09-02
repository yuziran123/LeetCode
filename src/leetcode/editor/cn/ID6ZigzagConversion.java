package leetcode.editor.cn;

import java.util.*;

public class ID6ZigzagConversion {
    public static void main(String[] args) {
        Solution solution = new ID6ZigzagConversion().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        String s = "PAYPALISHIRING";
        int numsRow = 3;
        // String s = "ABC";
        // int numsRow = 2;
        solution.convert(s, numsRow);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*用一个二维数组将N字形存储下来 在对这个而二维数组遍历——纯暴力解法*/
        public String convert1(String s, int numRows) {
            String res = "";
            int len = s.length();
            if (numRows == 1)
                return s;

            String[][] str = new String[numRows][len];
            int i = 0, row = 0, col = 0;
            while (i < len) {
                while (row < numRows && i < len) {
                    str[row++][col] = String.valueOf(s.charAt(i++));
                }
                row--;
                while (row > 1 && i < len) {
                    row--;
                    col++;
                    str[row][col] = String.valueOf(s.charAt(i));
                    i++;
                }
                col++;
                row--;
            }
            for (i = 0; i < numRows; i++) {
                for (int j = 0; j < len; j++) {
                    if (str[i][j] != null)
                        res += str[i][j];
                }
            }
            return res;
        }

        /*暴力解法的优化-2维存储转为1维，将同行的各列拼接——效率依旧不高*/
        /* List<StringBuilder> 代替 String[] 可以提高整体效率*/
        public String convert(String s, int numRows) {
            int len = s.length();
            if (numRows == 1)
                return s;

            List<StringBuilder> str = new ArrayList<StringBuilder>();
            for (int i = 0; i < numRows; i++)
                str.add(new StringBuilder());
            int i = 0, row = 0;
            while (i < len) {
                while (row < numRows && i < len) {
                    str.get(row++).append(s.charAt(i++));
                }
                row--;
                while (row > 1 && i < len) {
                    str.get(--row).append(s.charAt(i++));
                }
                row--;
            }

            /*使用 StringBuilder 来构建最终的结果字符串，这样可以提高性能，
                因为 StringBuilder 是可变的，
                而字符串拼接在循环中使用 String 会创建很多临时对象。*/
            StringBuilder res = new StringBuilder();
            for (StringBuilder string : str) {
                res.append(string);
            }
            return res.toString();
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
