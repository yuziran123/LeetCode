package leetcode.editor.cn;

public class ID80RemoveDuplicatesFromSortedArrayIi {
    public static void main(String[] args) {
        Solution solution = new ID80RemoveDuplicatesFromSortedArrayIi().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        // int[] nums = {1, 1, 1, 1};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:80. 删除有序数组中的重复项 II
         * 1.不要使用额外的数组空间
         * 2.nums 是以“引用”方式传递的，需要对原数组做修改
         * Date 2024/8/28
         *!虽然做出来了，但是反复调试，整体思路是有的，就是很多特殊情况需要考虑；
         *!尤其是数组末尾元素的考虑要周全；难度倒是还好
         * @param nums
         * @return int
         */
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            if (len <= 2)
                return len;
            int index = 0;

            int right = 0;
            int temp = 0;
            for (int i = 0; i < len - 1; ) {
                // 1.相邻元素不重复
                if (nums[i] != nums[i + 1]) {
                    nums[index++] = nums[i++];
                    continue;
                } else {    // 2.相邻元素重复   nums[i] == nums[i + 1]
                    temp = nums[i];
                    // 2.1只重复一次
                    nums[index++] = nums[i++];

                    // 2.2重复两次及以上
                    right = i + 1;
                    if (right <= len - 2 && temp == nums[right]) {
                        nums[index++] = nums[i + 1];
                        while (right <= len - 2 && temp == nums[right]) {
                            right++;
                            i = right;
                        }
                    }

                }
            }
            //for循环并未考虑末尾的元素，只要最后一位！=倒数第三位，就说明该元素最多之重复两次，所以一定可以加到数组中
            if (nums[len - 1] != nums[index - 2])
                nums[index++] = nums[len - 1];
            return index;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

    /* //不满足题目要求-辅助空间
        public int removeDuplicates(int[] nums) {
            int len = nums.length;
            int max = nums[len - 1];
            int res = 0;
            int[] temp = new int[max + 1];
            for (int i = 0; i < len; i++) {
                temp[nums[i]] += 1;
            }
            for (int i = 1; i <= max; i++) {
                if (temp[i] > 2)
                    temp[i] = 2;
                res += temp[i];
            }
            return res;
        }*/
}
