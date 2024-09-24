package leetcode.editor.cn;

public class ID918MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new ID918MaximumSumCircularSubarray().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int maxS = Integer.MIN_VALUE, minS = 0;
            int sum = 0, curMax = 0, tmpMin = 0;
            for (int num : nums) {
                curMax = Math.max(curMax, 0) + num;
                maxS = Math.max(curMax, maxS); //初始curMax=-1，maxS=0；此时maxS=0显然不对，故maxS初始化要足够小
                tmpMin = Math.min(tmpMin, 0) + num;
                minS = Math.min(minS, tmpMin);
                sum += num;
            }
            return minS == sum ? maxS : Math.max(maxS, sum - minS);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
