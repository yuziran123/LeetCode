package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID78Subsets {
    public static void main(String[] args) {
        Solution solution = new ID78Subsets().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> record = new ArrayList<>();
        int[] nums;

        public List<List<Integer>> subsets(int[] nums) {
            this.nums = nums;
            dfs(0);
            return ans;
        }

        public void dfs(int start) {
            if (record.size() > nums.length)
                return;
            // 与组合问题的不同之处在于——记录递归中的所有可能
            ans.add(new ArrayList<>(record));
            for (int i = start; i < nums.length; i++) {
                record.add(nums[i]);
                dfs(i + 1);
                record.remove(record.size() - 1);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
