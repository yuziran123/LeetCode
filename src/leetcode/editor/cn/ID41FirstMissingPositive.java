package leetcode.editor.cn;

public class ID41FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new ID41FirstMissingPositive().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            // 标记所有负数=n+1
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            // 对于遍历到的数x 如果再[1,n] ,就把对应的x-1出打上标记
            for (int i = 0; i < n; i++) {
                int num = Math.abs(nums[i]);
                if (num < n + 1) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }

            // 找到第一个未被标记的位置
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            // 如果数组中每一个元素都被打赏标记了 结果是n+1
            return n + 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
