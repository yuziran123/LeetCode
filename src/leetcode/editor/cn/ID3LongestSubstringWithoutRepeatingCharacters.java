package leetcode.editor.cn;

public class ID3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new ID3LongestSubstringWithoutRepeatingCharacters().new Solution();

        // 执行测试
        // String s = "pwwkew";
        // String s = "abcabcbb";
        String s = "bbtablud";
        // String s = "dvdf";
        StringBuilder str = new StringBuilder();
        str.append("0");
        str.append("1");
        str.append("2");
        str.delete(0, 3);


        solution.lengthOfLongestSubstring(s);
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /*利用了很多Java的字符串接口*/
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            if (n == 0)
                return 0;

            int pre = 0, suf = 1;
            int ans = 1;
            int index = 0;
            StringBuilder str = new StringBuilder(n);
            str.append(s.charAt(0));
            while (pre < n && suf < n) {
                // 当前字符是否与子串某个字符重复
                index = str.indexOf(String.valueOf(s.charAt(suf)));
                if (index == -1) {
                    ans = Math.max(ans, suf - pre + 1);
                } else {
                    str = str.delete(0, index + 1); // 删除子串的0-index区间字符
                    pre = pre + index + 1;      // 新的子串起始为index的下一个
                }
                str.append(s.charAt(suf));
                suf++;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
