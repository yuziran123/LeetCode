package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID46Permutations {
    public static void main(String[] args) {
        Solution solution = new ID46Permutations().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> path = new ArrayList<Integer>();
            backtrack(path, new boolean[nums.length], nums);
            return ans;
        }

        private void backtrack(List<Integer> path, boolean[] selected, int[] nums) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!selected[i]) {
                    selected[i] = true;
                    path.add(nums[i]);
                    backtrack(path, selected, nums);
                    path.remove(path.size() - 1);
                    selected[i] = false;
                }
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
