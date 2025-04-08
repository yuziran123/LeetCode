package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new ID118PascalsTriangle().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) { // 两端元素始终为1
                        row.add(1);
                    } else {
                        // 中间元素通过上一行的两个相邻元素相加得到
                        int num = ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j);
                        row.add(num);
                    }
                }
                ans.add(row);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
