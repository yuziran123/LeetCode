package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ID560SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new ID560SubarraySumEqualsK().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.subarraySum(new int[]{1, 1, 1}, 2);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int ans = 0;
            int prefixSum = 0; // 前缀和
            Map<Integer, Integer> map = new HashMap<>(); // 记录前缀和出现次数
            map.put(0, 1);
            for (int num : nums) {
                prefixSum += num;
                if (map.containsKey(prefixSum - k)) {
                    ans += map.get(prefixSum - k);
                }
                // 更新当前前缀和出现系数
                map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
