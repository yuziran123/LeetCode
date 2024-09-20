package leetcode.editor.cn;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class ID295FindMedianFromDataStream {
    public static void main(String[] args) {
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 思路分析：
     * 使用大根堆（maxHeap）存储较小的一半元素，
     * 使用小根堆（minHeap）存储较大的一半元素。
     * 这样可以确保中位数总是在这两个堆的堆顶之一
     */
    class MedianFinder {
        Queue<Integer> minHeap;
        Queue<Integer> maxHeap;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 这样才是大根堆的初始化
        }

        /**
         * 如果新元素小于或等于大根堆的堆顶，则加入大根堆；否则加入小根堆。
         * 调整两个堆的大小，使它们的大小差不超过 1。
         */
        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek())
                maxHeap.offer(num);
            else
                minHeap.offer(num);
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.offer(maxHeap.poll());
            else if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            else
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
