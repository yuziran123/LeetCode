package leetcode.editor.cn;

public class ID136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new ID136SingleNumber().new Solution();
        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++)
                ans = ans ^ nums[i];
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
