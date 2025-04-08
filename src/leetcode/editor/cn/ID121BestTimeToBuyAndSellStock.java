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
            int ans = 0;
            int min_prices = Integer.MAX_VALUE;
            for (int price : prices) {
                if (price < min_prices) {
                    min_prices = price;  // 更新最低买入价
                } else {
                    ans = Math.max(ans, price - min_prices); // 比较利润
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
