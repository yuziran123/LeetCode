package leetcode.editor.cn;

public class ID169MajorityElement {
    public static void main(String[] args) {
        Solution solution = new ID169MajorityElement().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            int major = 0, vote = 0;
            for (int num : nums) {
                if (vote == 0) {  // 当投票数为0时，选择当前元素作为候选的多数元素
                    major = num;
                }
                // 如果当前元素等于候选的多数元素，投票数加1；否则减1
                vote = vote + (num == major ? 1 : -1);
            }
            return major;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
