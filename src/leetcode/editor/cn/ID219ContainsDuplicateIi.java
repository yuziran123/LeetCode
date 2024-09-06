package leetcode.editor.cn;

import java.util.HashSet;

public class ID219ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ID219ContainsDuplicateIi().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] nums = {1, 2, 3, 1, 2, 3};
        // int[] nums = {1, 2, 3, 1};
        solution.containsNearbyDuplicate(nums, 3);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int n = nums.length;
            if (k == 0 || n == 1)
                return false;

            HashSet<Integer> hash = new HashSet<>();
            // 创建一个最大长度为k的哈希表
            for (int i = 0; i < n; i++) {
                if (hash.contains(nums[i]))
                    return true;
                hash.add(nums[i]);
                if (hash.size() > k)
                    hash.remove(nums[i-k]);
            }
            return false;


            // O(n*k)时间复杂度
            /*for (int i = 1; i <= k; i++) {
                for (int j = 0; j < n - i;j++ ) {
                    if (nums[j] == nums[j + i])
                        return true;
                }
            }
            return false;*/


            // 双指针
            /*int left = 0, right = 1;
            while (left < n - 1) {
                while (right < n && right <= left + k && nums[left] != nums[right]) {
                    right++;
                }
                if (right < n && nums[left] == nums[right])
                    if (right - left <= k && right < n)
                        return true;
                left++;
                right = left + 1;
            }
            return false;*/


            // 哈希表
            /*Map<Integer, List<Integer>> hash = new HashMap<>();
            AtomicBoolean flag = new AtomicBoolean(false);
            for (int i = 0; i < n; i++) {
                hash.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
            }
            hash.forEach((index, list) -> {
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i + 1) - list.get(i) <= k) {
                        flag.set(true);
                        break;
                    }
                }
            });*/

            /*Map<Integer, List<Integer>> hash = new HashMap<>();
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                hash.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
            }
            for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
                List<Integer> list = entry.getValue();
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i + 1) - list.get(i) <= k) {
                        return true;
                    }
                }
            }
            return flag;*/
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
