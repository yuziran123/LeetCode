package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class ID433MinimumGeneticMutation {
    public static void main(String[] args) {
        Solution solution = new ID433MinimumGeneticMutation().new Solution();
        // 执行测试
        System.out.println("");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String startGene, String endGene, String[] bank) {
            int changeCounts = 0;
            Deque<String> deque = new ArrayDeque<>();
            HashSet<String> visited = new HashSet<>(); // 记录被访问的字符
            deque.offer(startGene);
            visited.add(startGene);
            while (!deque.isEmpty()) {
                // 遍历当前层的队列元素
                int n = deque.size();
                // for循环中使用deque.size() 控制迭代次数，可能导致当队列中的元素在处理时被修改，从而出现不准确的结果。
                for (int i = 0; i < n; i++) {
                    String curGen = deque.poll();
                    if (curGen.equals(endGene))
                        return changeCounts;
                    for (String gen : bank) {
                        if (isOneCharDifferent(curGen, gen) && visited.add(gen))
                            deque.offer(gen);
                    }
                }
                changeCounts++; // 记录层数，就是记录变化次数，即BFS的路径长度
            }
            return -1;
        }

        /*比较两字符串的不同字符是否超过了一个*/
        private static boolean isOneCharDifferent(String a, String b) {
            int differenceCount = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    differenceCount++;
                    if (differenceCount > 1) {
                        return false; // 超过一个不同字符
                    }
                }
            }
            return differenceCount == 1; // 只有一个不同字符
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}
