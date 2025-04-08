package leetcode.editor.cn;

public class ID287FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new ID287FindTheDuplicateNumber().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            // 初始化快慢指针
            int slow = nums[0];
            int fast = nums[0];

            // 第一步：快慢指针寻找相遇点（使用 while 循环）
            while (true) {
                slow = nums[slow]; // 慢指针每次移动一步
                fast = nums[nums[fast]]; // 快指针每次移动两步
                if (slow == fast) {
                    break; // 找到相遇点后退出循环
                }
            }

            // 第二步：从起点和相遇点同时移动，找到入口点即为重复数字
            slow = nums[0]; // 将慢指针重置到起点
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow; // 返回重复数字
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
