package leetcode.editor.cn;

import java.util.*;

public class ID373FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        Solution solution = new ID373FindKPairsWithSmallestSums().new Solution();
        // 执行测试
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        solution.kSmallestPairs(nums1, nums2, 3);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            // 创建优先队列，按照pair[0] + pair[1]的和进行排序——小根堆；队列中存储的是索引[index1,index2]
            // 注意这里的写法；0来自nums1，1来自nums2，容易出错
            Queue<int[]> heap = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));

            for (int i = 0; i < Math.min(k, nums1.length); i++)
                heap.offer(new int[]{i, 0}); // 将所有的索引对入堆，index2初始全部设为0

            // 小根堆——依次弹出的k个堆顶，就是k个最小数对
            while (k > 0 && !heap.isEmpty()) {
                int[] poll = heap.poll();
                ans.add(Arrays.asList(nums1[poll[0]], nums2[poll[1]]));
                if (poll[1] < nums2.length - 1) {
                    poll[1]++;
                    heap.offer(poll); // index2指向下一个，入堆
                }
                k--;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
