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
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    // 只要今天比昨天高就累加利润
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
