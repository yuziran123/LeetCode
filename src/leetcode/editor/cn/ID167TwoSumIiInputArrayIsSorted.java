package leetcode.editor.cn;

import java.util.*;

public class ID167TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new ID167TwoSumIiInputArrayIsSorted().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] < target)
                    left++;
                else if (numbers[left] + numbers[right] > target)
                    right--;
                else {
                    //下标从1开始
                    result[0] = left + 1;
                    result[1] = right + 1;
                    break;
                }
            }
            return result;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
