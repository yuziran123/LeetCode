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
        System.out.println(s);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        // 滑动窗口
        public int lengthOfLongestSubstring(String s) {
            // 存储字符最后出现的位置后一位
            int[] arr = new int[128]; // ASCII 字符共 128 个（0-127）
            int i = 0;
            int ans = 0;
            for (int j = 0; j < s.length(); j++) {
                // 出现重复字符，窗口左侧跳到新位置
                // 此时 arr[s.charAt(j)] 的值一定 大于当前 i（因为字符上次出现在窗口内）
                i = Math.max(i, arr[s.charAt(j)]);
                // 更新当前字符的最新位置（下标+1）
                arr[s.charAt(j)] = j + 1;
                ans = Math.max(ans, j - i + 1);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;

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
