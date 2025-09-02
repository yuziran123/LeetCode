package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ID207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new ID207CourseSchedule().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 拓扑排序——BFS实现
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 初始化入度数组和邻接表
            int[] inDegrees = new int[numCourses];
            List<List<Integer>> adjacency = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<Integer>());
            }
            // 构建图并计算入度
            for (int[] pre : prerequisites) {
                inDegrees[pre[0]]++; // 入度 = 某门课程需要先完成的先修课程数量
                adjacency.get(pre[1]).add(pre[0]);  // 存储先修课程i修完后可以学习的课程列表
            }

            // 将所有入度为 0 的课程加入队列，表示没有先修课程，可以直接学习
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegrees[i] == 0) {
                    deque.add(i);
                }
            }

            while (!deque.isEmpty()) {
                int course = deque.poll();
                numCourses--; // 每完成一门课程，课程总数减1
                List<Integer> nextCourses = adjacency.get(course);
                if (nextCourses != null) {
                    for (int nextCourse : nextCourses) {
                        inDegrees[nextCourse]--;
                        if (inDegrees[nextCourse] == 0) {
                            deque.add(nextCourse);
                        }
                    }
                }
            }
            // 如果所有课程都被完成，则返回true，否则返回false
            return numCourses == 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}