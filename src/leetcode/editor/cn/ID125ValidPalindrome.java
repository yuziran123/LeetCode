package leetcode.editor.cn;

import java.util.*;

public class ID125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ID125ValidPalindrome().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试
        // solution.isPalindrome("A man, a plan, a canal: Panama");
        solution.isPalindrome(".,");
        solution.isPalindrome("0P");
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*简单，就是字符的处理注意*/
        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                // 不考虑字母或数字以外的符号
                while (!Character.isLetterOrDigit(s.charAt(left)) && left < right)
                    left++;
                while (!Character.isLetterOrDigit(s.charAt(right)) && left < right)
                    right--;
                // 忽略大小写
                if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}
