package leetcode.editor.cn;

import java.util.HashSet;

public class ID202HappyNumber {
    public static void main(String[] args) {
        Solution solution = new ID202HappyNumber().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        solution.isHappy(2);
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*取各位数字的优化方案*/
        public boolean isHappy(int n) {
            HashSet<Integer> hash = new HashSet<>();
            while (!hash.contains(n)) {
                if (n == 1)
                    return true;
                hash.add(n);
                n = getNextNumber(n);
            }
            return false;
        }

        /*计算数字各位平方和*/
        public int getNextNumber(int n) {
            int res = 0, temp = 0;
            while (n != 0) {
                temp = n % 10;
                res += temp * temp;
                n = n / 10;
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)


    /*数字转字符串——再逐个处理——hash记录已经尝试过的数字，避免死循环*/
    public boolean isHappy1(int n) {
        HashSet<Integer> hash = new HashSet<>();
        String s = String.valueOf(n);
        int sum = 0;
        hash.add(n);
        while (!hash.contains(sum)) {
            hash.add(sum);
            sum = 0;
            for (int i = 0; i < s.length(); i++)
                sum += (s.charAt(i) - '0') * (s.charAt(i) - '0');
            if (sum == 1)
                return true;
            s = String.valueOf(sum);
        }
        return false;
    }

}
