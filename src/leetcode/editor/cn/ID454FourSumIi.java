package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ID454FourSumIi {
    public static void main(String[] args) {
        Solution solution = new ID454FourSumIi().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            int count = 0;
            // HashSet<Integer> set = new HashSet<>();
            Map<Integer, Integer> record = new HashMap<>();

            int key = 0;
            // 记录nums1于nums2的和sum及其数量
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    key = nums1[i] + nums2[j];
                    record.put(key, record.getOrDefault(key, 0) + 1);
                }
            }

            for (int k = 0; k < nums3.length; k++) {
                for (int l = 0; l < nums4.length; l++) {
                    key = nums3[k] + nums4[l];
                    if (record.getOrDefault(-key, -1) != -1)
                        count += record.get(-key);
                }
            }
            return count;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
