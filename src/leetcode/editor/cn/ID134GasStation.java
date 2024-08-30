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
         * 描述:  53. 最大子数组和的马甲题
         * Date 2024/8/30
         *
         * @param gas
         * @param cost
         * @return int
         */

        public int canCompleteCircuit(int[] gas, int[] cost) {
            int sum = 0;
            int len = gas.length;
            int max = 0;
            int start = 0;
            // i->i+1 可余油量
            for (int i = 0; i < len; i++) {
                gas[i] = gas[i] - cost[i];
                sum += gas[i];
            }
            if (sum < 0)
                return -1;
            // sum >= 0：一定可以完成环路
            gas[0] = gas[0] + gas[1];
            max = gas[0];
            for (int i = 1; i < len; i++) {
                gas[i] = gas[i] + gas[(i + 1) % len];
                if (gas[i] >= max) {
                    max = gas[i];
                    start = i;
                }
            }
            System.out.println(start);
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
