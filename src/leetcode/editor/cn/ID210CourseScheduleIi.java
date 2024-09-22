package leetcode.editor.cn;

import java.util.*;

public class ID210CourseScheduleIi {
    public static void main(String[] args) {
        Solution solution = new ID210CourseScheduleIi().new Solution();
        StringBuilder builder = new StringBuilder();

        // 执行测试

        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer> ans = new ArrayList<>();
            int index = 0;

            // 构建入度表  邻接表
            int[] inDgrees = new int[numCourses];
            Map<Integer, List<Integer>> adjacency = new HashMap<>();
            for (int i = 0; i < prerequisites.length; i++) {
                int course = prerequisites[i][0];
                int pre = prerequisites[i][1];
                inDgrees[course]++;
                adjacency.putIfAbsent(pre, new ArrayList<>());
                adjacency.get(pre).add(course);
            }

            // 构建0入度队列
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDgrees[i] == 0)
                    deque.offer(i);
            }
            // 拓扑排序——记录选课顺序
            while (!deque.isEmpty()) {
                numCourses--;
                int pre = deque.poll();
                ans.add(pre);
                // 获取当前课程的后置课程——入度-1，出现入度0，就入堆
                List<Integer> courses = adjacency.get(pre);
                if (courses != null) {
                    for (int course : courses) {
                        inDgrees[course]--;
                        if (inDgrees[course] == 0)
                            deque.offer(course);
                    }
                }
            }
            ans = numCourses == 0 ? ans : new ArrayList<>(); //判断是否可以完成所有课程
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
