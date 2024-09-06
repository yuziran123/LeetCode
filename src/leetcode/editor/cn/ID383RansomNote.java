package leetcode.editor.cn;

public class ID383RansomNote {
    public static void main(String[] args) {
        Solution solution = new ID383RansomNote().new Solution();

        // 执行测试

        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //参考    242.有效的字母异位词 一样的思想
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] hash = new int[26];
            int index = 0;
            for (int i = 0; i < ransomNote.length(); i++) {
                index = ransomNote.charAt(i) - 'a';
                hash[index]++;
            }
            for (int i = 0; i < magazine.length(); i++) {
                index = magazine.charAt(i) - 'a';
                hash[index]--;
            }
            for (int i = 0; i < 26; i++) {
                if (hash[i] > 0)
                    return false;
            }
            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
