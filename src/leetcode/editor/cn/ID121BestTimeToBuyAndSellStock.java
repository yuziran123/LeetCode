package leetcode.editor.cn;

public class ID121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution solution = new ID121BestTimeToBuyAndSellStock().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] prices) {
            int maxProfit = 0;
            int minPrice = Integer.MAX_VALUE;
            for (int price : prices) {
                minPrice = Math.min(minPrice, price); // 记录历史最低价
                maxProfit = Math.max(maxProfit, price - minPrice); // 计算最大利润
            }
            return maxProfit;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
