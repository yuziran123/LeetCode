package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ID347TopKFrequentElements {
    public static void main(String[] args) {
        Solution solution = new ID347TopKFrequentElements().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> frequency = new HashMap<>(); // 统计数字频率
            for (int num : nums) {
                frequency.put(num, frequency.getOrDefault(num, 0) + 1);
            }
            // 如果 k 大于不同的数字数量，直接返回所有数字
            if (k >= frequency.size()) {
                return frequency.keySet().stream().mapToInt(i -> i).toArray();
            }
            // 小根堆 按照map的值排序
            Queue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
                heap.offer(entry);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            // heap中的k个元素就是频率最高的k个
            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = heap.poll().getKey();
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
