package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID57InsertInterval {
    public static void main(String[] args) {
        Solution solution = new ID57InsertInterval().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[][] intervals = {{0, 4}, {7, 12}};
        int[] newInterval = {0, 5};
        // int[][] intervals = {{1, 5}};
        // int[] newInterval = {2, 3};
        solution.insert(intervals, newInterval);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:参考56合并区间的做法——找到区间左端应该存在的位置，直接进行区间插入——再合并区间
         */
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> ans = new ArrayList<>();
            int len = intervals.length;
            if (len == 0) {
                ans.add(newInterval);
                return ans.toArray(new int[0][]);
            }
            // newInterval的位置——起始之前 末尾之后 其实末尾之间
            int flag = 0;
            if (intervals[0][0] > newInterval[0]) { // 所有区间之前
                ans.add(newInterval);
            } else if (intervals[len - 1][0] <= newInterval[0])  // 所有区间之后
                flag = 2;
            else
                flag = 1; // 就在区间中间

            for (int[] arr : intervals) {
                int n = ans.size();
                if (flag == 1 && arr[0] >= newInterval[0]) {
                    if (n > 0 && ans.get(n - 1)[1] >= newInterval[0])
                        ans.get(n - 1)[1] = Math.max(ans.get(n - 1)[1], newInterval[1]);
                    else
                        ans.add(newInterval);
                    n = ans.size(); /*更新n——有可能newInterval作为新的独立区间这样n=n+1*/
                }
                if (n > 0 && ans.get(n - 1)[1] >= arr[0])
                    ans.get(n - 1)[1] = Math.max(ans.get(n - 1)[1], arr[1]);
                else
                    ans.add(arr);
            }
            if (flag == 2) {
                int n = ans.size();
                if (ans.get(n - 1)[1] >= newInterval[0])
                    ans.get(n - 1)[1] = Math.max(ans.get(n - 1)[1], newInterval[1]);
                else
                    ans.add(newInterval);
            }
            return ans.toArray(new int[0][]);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


}
