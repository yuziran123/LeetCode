package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ID502Ipo {
    public static void main(String[] args) {
        Solution solution = new ID502Ipo().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 2};
        solution.findMaximizedCapital(3, 0, profits, capital);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = capital.length;
            Integer[] indexs = new Integer[n];
            for (int i = 0; i < n; i++)
                indexs[i] = i;

            // 按capital值升序排列对应的索引
            Arrays.sort(indexs, (i, j) -> (capital[i] - capital[j])); // 排序要用封装类型？
            Queue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);  // 维护利润的大根堆

            int i = 0;
            while (k-- > 0) {
                //将启动资本小于等于当前资本的项目的利润都加入大顶堆
                while (i < n && w >= capital[indexs[i]])
                    maxheap.offer(profits[indexs[i++]]);

                if (maxheap.isEmpty())
                    break;
                w += maxheap.poll();
            }
            return w;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    /*超时*/
    class Solution1 {
        int[] profit;
        int[] capital;

        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            this.profit = profits;
            this.capital = capital;
            while (k > 0) {
                int i = findMax(w);
                if (i == -1)
                    break;
                w = w + profit[i];
                k--;
                capital[i] = -1;
            }
            return w;
        }

        public int findMax(int w) {
            int id = -1, max = 0;
            for (int i = 0; i < capital.length; i++) {
                if (capital[i] != -1 && w >= capital[i]) {
                    if (max < profit[i]) {
                        max = profit[i];
                        id = i;
                    }
                }
            }
            return id;
        }
    }
}
