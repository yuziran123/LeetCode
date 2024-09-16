package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID77Combinations {
    public static void main(String[] args) {
        Solution solution = new ID77Combinations().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int n;
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            dfs(1, k);
            return ans;
        }

        private void dfs(int num, int k) {
            if (k == 0) { // 此时路径组合存储已经满k个
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = num; i <= n - k + 1; i++) {
                path.add(i);
                dfs(i + 1, k - 1); // 没往下一层，k就可以-1
                path.remove(path.size() - 1);
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        private int k;
        private List<List<Integer>> ans = new ArrayList<>();
        private List<Integer> path = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            dfs(n);
            return ans;
        }

        private void dfs(int n) {
            int d = k - path.size();
            if (d == 0) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = n; i >= d; i--) {
                path.add(i);
                dfs(i - 1);
                path.remove(path.size() - 1);
            }
        }
    }
}