package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ID131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new ID131PalindromePartitioning().new Solution();
        // 执行测试
        solution.partition("aab");
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        char[] arr;

        public List<List<String>> partition(String s) {
            this.arr = s.toCharArray(); // 方便遍历
            dfs(0);
            return ans;
        }

        public void dfs(int start) {
            if (start == arr.length) {
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = start; i < arr.length; i++) {
                if (isPalindromic(start, i)) { // 剪枝--确保截取的是回文串
                    path.addLast(new String(arr, start, i + 1 - start)); // 获取子集的方式
                    dfs(i + 1);
                    path.removeLast();
                }
            }
        }

        // 判断当前子串是否是回文串
        public boolean isPalindromic(int left, int right) {
            while (left < right) {
                if (arr[left] != arr[right])
                    return false;
                left++;
                right--;
            }
            return true;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
