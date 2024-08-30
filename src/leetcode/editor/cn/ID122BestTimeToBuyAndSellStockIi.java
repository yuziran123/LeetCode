package leetcode.editor.cn;

public class ID122BestTimeToBuyAndSellStockIi {
    public static void main(String[] args) {
        Solution solution = new ID122BestTimeToBuyAndSellStockIi().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] peices = {7, 1, 5, 3, 6, 4};
        solution.maxProfit(peices);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:122. 买卖股票的最佳时机 II
         * 找递增子序列
         * Date 2024/8/29
         *
         * @param prices
         * @return int
         */

        public int maxProfit(int[] prices) {
            int profit = 0;
            int temp = 0;
            int len = prices.length;
            for (int i = 1; i < len; ) {
                // 序列不递增
                if (prices[i] <= prices[i - 1]) {
                    i++;
                    continue;
                } else {
                    // 记录递增子序列的首位
                    temp = prices[i - 1];
                    // 找到递增子序列的最后一位
                    while (i < len && prices[i] > prices[i - 1]) {
                        i++;
                    }
                    // 记录当前递增子序列的差值
                    //!跳出循环的i指向递增子序列末尾的下一位，故作i-1的处理
                    profit = profit + prices[i - 1] - temp;
                }
            }
            return profit;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
