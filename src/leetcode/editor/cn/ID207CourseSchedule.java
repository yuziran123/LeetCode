package leetcode.editor.cn;

import java.util.*;

public class ID207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new ID207CourseSchedule().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 方法一：深度优先遍历
         */

        /**
         * 方法二：拓扑排序——BFS实现
         */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int n = prerequisites.length;
            int[] inDgrees = new int[numCourses];
            Map<Integer, List<Integer>> adjacency = new HashMap<>(); // 记录当前课程的后置课程
            for (int i = 0; i < n; i++) {
                inDgrees[prerequisites[i][0]]++;
                adjacency.putIfAbsent(prerequisites[i][1], new ArrayList<>());
                adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            Deque<Integer> deque = new ArrayDeque<>(); // 记录入度=0的课程
            for (int i = 0; i < numCourses; i++) {
                if (inDgrees[i] == 0)
                    deque.offer(i);
            }

            while (!deque.isEmpty()) {
                int course = deque.poll();
                numCourses--;
                List<Integer> list = adjacency.get(course);
                System.out.println(list);
                if (list != null) {
                    for (int nextCorse : list) {
                        inDgrees[nextCorse]--;
                        if (inDgrees[nextCorse] == 0)
                            deque.offer(nextCorse); // 入的是序号
                    }
                }
            }
            return numCourses == 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}