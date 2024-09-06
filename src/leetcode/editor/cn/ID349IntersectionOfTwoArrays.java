package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ID349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new ID349IntersectionOfTwoArrays().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        int[] n1 = {1, 1, 2, 2};
        int[] n2 = {2, 2};
        solution.intersection(n1, n2);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            List<Integer> record = new ArrayList<>();
            int[] hash1 = new int[1001];
            int[] hash2 = new int[1001];
            for (int i = 0; i < n1; i++) {
                hash1[nums1[i]] = 1;
            }
            for (int i = 0; i < n2; i++) {
                hash2[nums2[i]] = 1;
            }
            for (int i = 0; i < 1001; i++) {
                if (hash1[i] == 1 && hash2[i] == 1)
                    record.add(i);
            }
            int[] ans = new int[record.size()];
            for (int i = 0; i < record.size(); i++) {
                ans[i] = record.get(i);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
