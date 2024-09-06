package leetcode.editor.cn;

import java.util.*;

public class ID15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ID15ThreeSum().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int n = nums.length;
            List<List<Integer>> ans = new ArrayList<>();

            HashSet<Integer> hash = new HashSet<>();
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> record = new ArrayList<>();
                            record.add(nums[i]);
                            record.add(nums[j]);
                            record.add(nums[k]);
                            ans.add(record);
                        }
                    }
                }
            }

            // 排序
           /* Arrays.sort(nums);

            if (nums[0]==0 && nums[n-1]==0){
                List<Integer> record = new ArrayList<>();
                record.add(0);
                record.add(0);
                record.add(0);
                ans.add(record);
                return ans;
            }
            int mid = 0;
            for (int i = 0; i < n - 1; i++) {
                // 负数和非负数的分界线
                if (nums[i] < 0 && nums[i + 1] >= 0)
                    mid = i + 1;
            }


            for (int i = 0; i < mid; i++) {
                hash.add(nums[i]);
            }
            int sum = 0;
            for (int i = mid; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum = nums[i] + nums[j];
                    if (hash.contains(-sum) && !hash.contains(sum)) {
                        List<Integer> record = new ArrayList<>();
                        record.add(-sum);
                        record.add(nums[i]);
                        record.add(nums[j]);
                        ans.add(record);
                    }
                    hash.add(sum);
                }
            }
            hash.clear();
            for (int i = mid; i < n; i++) {
                hash.add(nums[i]);
            }
            sum = 0;
            for (int i = 0; i < mid - 1; i++) {
                for (int j = i + 1; j < mid; j++) {
                    sum = nums[i] + nums[j];
                    if (hash.contains(-sum) && !hash.contains(sum)) {
                        List<Integer> record = new ArrayList<>();
                        record.add(-sum);
                        record.add(nums[i]);
                        record.add(nums[j]);
                        ans.add(record);
                    }
                    hash.add(sum);
                }
            }
*/

            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
