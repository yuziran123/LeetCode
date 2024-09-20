package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ID215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new ID215KthLargestElementInAnArray().new Solution();
        // 执行测试
        System.out.println();
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:利用小根堆实现
         * size() = k的小根堆，堆顶元素最小，就是第k个最大元素
         */
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> heap = new PriorityQueue<>();
            for (int num : nums) {
                heap.offer(num);
                if (heap.size() > k) // 让堆的大小维持在k
                    heap.poll(); // 弹出最小的那个
            }
            return heap.poll();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public int findKthLargest(int[] nums, int k) {
        // 有内置方法不用？没道理的
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
