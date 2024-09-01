package leetcode.editor.cn;

public class ID12IntegerToRoman {
    public static void main(String[] args) {
        Solution solution = new ID12IntegerToRoman().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*简单的暴力枚举*/
        public String intToRoman(int num) {
            String res = "";
            int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            int[] arr = new int[4];
            Solution.intToArray(num, arr);
            res += "M".repeat(arr[0]);

            if (arr[1] == 9)
                res += "CM";
            else if (arr[1] >= 5) {
                res += "D";
                res += "C".repeat(arr[1] - 5);
            } else if (arr[1] == 4) {
                res += "CD";
            } else {
                res += "C".repeat(arr[1]);
            }

            if (arr[2] == 9)
                res += "XC";
            else if (arr[2] >= 5) {
                res += "L";
                res += "X".repeat(arr[2] - 5);
            } else if (arr[2] == 4) {
                res += "XL";
            } else {
                res += "X".repeat(arr[2]);
            }

            if (arr[3] == 9)
                res += "IX";
            else if (arr[3] >= 5) {
                res += "V";
                res += "I".repeat(arr[3] - 5);
            } else if (arr[3] == 4) {
                res += "IV";
            } else {
                res += "I".repeat(arr[3]);
            }

            return res;
        }

        /*优化：val和str数组的索引对应关系可以利用*/

        /*num各位数转为数组存储*/
        public static void intToArray(int num, int[] arr) {
            arr[0] = num / 1000;
            // arr[0] = arr[0] * 1000;
            arr[1] = num % 1000 / 100;
            // arr[1] = arr[1] * 100;
            arr[2] = num % 100 / 10;
            // arr[2] = arr[2] * 10;
            arr[3] = num % 10;
        }
    }

    // leetcode submit region end(Prohibit modification and deletion)

}
