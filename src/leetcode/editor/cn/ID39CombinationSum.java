package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new ID39CombinationSum().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();
        private int[] candidates;
        private int n;
        private int target;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            this.n = candidates.length;
            dfs(0, target);
            return ans;
        }

        public void dfs(int start, int target) {
            if (target < 0)
                return;
            else if (target == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            // 可以重复选取-i依旧从start开始选取
            for (int i = start; i < n; i++) {
                path.add(candidates[i]);
                dfs(i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
