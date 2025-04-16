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
        public int lengthOfLongestSubstring(String s) {
            // 存储字符最后出现的位置后一位
            int[] arr = new int[128]; // ASCII 字符共 128 个（0-127）
            int i = 0;
            int ans = 0;
            // i表示无重复字符子串的起始 j表示当前字符位置
            for (int j = 0; j < s.length(); j++) {
                // 当遇到重复字符时，直接将左边界跳到该字符上次出现位置的下一位
                i = Math.max(i, arr[s.charAt(j)]);
                arr[s.charAt(j)] = j + 1;   // 更新当前字符的最新位置（下标+1）
                ans = Math.max(ans, j - i + 1);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
