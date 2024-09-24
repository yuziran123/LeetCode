package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ID149MaxPointsOnALine {
    public static void main(String[] args) {
        Solution solution = new ID149MaxPointsOnALine().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 2层遍历，统计所有的点对斜率
         */
        public int maxPoints(int[][] points) {
            int n = points.length, ans = 1;
            for (int i = 0; i < n; i++) {
                int[] x = points[i];  // 取第1个点
                int max = 0;
                Map<String, Integer> map = new HashMap<>();
                for (int j = i + 1; j < n; j++) {
                    int[] y = points[j]; // 取第2个点
                    int a = y[1] - x[1];
                    int b = y[0] - x[0];
                    int k = greatCommonDivisons(a, b);
                    String key = a / k + "-" + b / k;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                }
                ans = Math.max(max + 1, ans);
            }
            return ans;
        }

        /**
         * 描述:求最大公约
         */
        public int greatCommonDivisons(int x, int y) {
            return y == 0 ? x : greatCommonDivisons(y, x % y);
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

    /**
     * 3层遍历枚举所有的可能
     * 将除法改成了乘法，避免了除法精度问题
     */
    public int maxPoints1(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = points[i];  // 取第1个点
            for (int j = i + 1; j < n; j++) {
                int[] y = points[j]; // 取第2个点
                int count = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] z = points[k];  // 取第3个点
                    // 斜率除法，改成了交叉乘法
                    if (((y[1] - x[1]) * (z[0] - y[0])) == ((y[0] - x[0]) * (z[1] - y[1]))) count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
