package leetcode.editor.cn;

public class ID4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new ID4MedianOfTwoSortedArrays().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:双指针的思想
         * 计算中位数的步骤：
         * 排序：首先将数组中的元素进行排序。确定中位数：
         * 如果数组长度为奇数，中位数为 array[len / 2]
         * 如果数组长度为偶数，中位数为 (array[len/ 2 - 1] + array[len / 2]) / 2.0
         * Date 2024/9/19
         *
         * @param nums1
         * @param nums2
         * @return double
         */
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length, n2 = nums2.length;
            int mid = (n1 + n2) / 2;
            int idx1 = 0, idx2 = 0; // 两个数组的索引指针
            int pre = 0, cur = 0;   // 记录mid和mid-1的数值
            while (mid >= 0 && idx1 < n1 && idx2 < n2) {
                pre = cur;
                if (nums1[idx1] > nums2[idx2])
                    cur = nums2[idx2++];
                else
                    cur = nums1[idx1++];
                mid--;
            }
            // 考虑nums1或nums2走完了，也还没到中位数；处理剩余数组的数
            if (idx1 == n1) {
                while (mid >= 0) {
                    pre = cur;
                    cur = nums2[idx2];
                    idx2++;
                    mid--;
                }
            }
            if (idx2 == n2) {
                while (mid >= 0) {
                    pre = cur;
                    cur = nums1[idx1];
                    idx1++;
                    mid--;
                }
            }
            // 奇：mid就是中位数  偶：[mid+mid-1]/2.0
            if ((n1 + n2) % 2 == 0)
                return (pre + cur) / 2.0;
            else
                return cur;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
