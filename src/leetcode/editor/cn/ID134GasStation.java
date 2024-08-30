package leetcode.editor.cn;

public class ID134GasStation {
    public static void main(String[] args) {
        Solution solution = new ID134GasStation().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        // int[] gas = {1, 2, 3, 4, 5};
        // int[] cost = {3, 4, 5, 1, 2};

        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        // int[] gas = {5, 8, 2, 8};
        // int[] cost = {6, 5, 6, 6};
        // int[] gas = {67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66};
        // int[] cost = {27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
        int i = solution.canCompleteCircuit(gas, cost);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 描述:  动态规划求解
         * Date 2024/8/30
         *
         * @param gas
         * @param cost
         * @return int
         */
        public int canCompleteCircuit(int[] gas, int[] cost) {

            return 0;
        }

        public int canCompleteCircuit1(int[] gas, int[] cost) {
            int sum = 0;
            int len = gas.length;
            int start = 0;
            // i->i+1 可余油量
            for (int i = 0; i < len; i++) {
                gas[i] = gas[i] - cost[i];
                sum += gas[i];
            }
            if (sum < 0)
                return -1;
            // sum >= 0：一定可以完成环路
            sum = 0;
            /**对于问题的拆解分析——算是利用数组和问题的性质求解
             * start表示环路起始  即使start之前的和为负，可是sum >= 0 start之后一定满足要求
             */
            for (int i = 0; i < len; i++) {
                sum += gas[i];
                // 从左我往右寻找其后sum>=0的起始点
                if (sum < 0 && gas[i] < 0) {
                    sum = 0;
                    start = i + 1;
                }
            }
            return start;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

     /*// 时间复杂度O(N²)，超出时间限制
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int sum = 0;
            int len = gas.length;
            int tempSum = 0;
            // i->i+1 可余油量
            for (int i = 0; i < len; i++) {
                gas[i] = gas[i] - cost[i];
                sum += gas[i];
            }
            if (sum < 0)
                return -1;
            // sum >= 0：一定可以完成环路
            int start = 0;
            for (int i = 0; i < len; i++) {
                int j = i;
                sum = 0;
                for (; j != (i + len - 1) % len; ) {
                    sum += gas[j];
                    if (sum < 0)
                        break;
                    j = (j + 1) % len;
                }
                if (j == i - 1)
                    start = i;
            }
            return start;
        }*/
}
