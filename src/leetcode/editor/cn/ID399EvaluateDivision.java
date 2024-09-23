package leetcode.editor.cn;

import java.util.*;

public class ID399EvaluateDivision {
    public static void main(String[] args) {
        Solution solution = new ID399EvaluateDivision().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            Map<String, Map<String, Double>> graph = new HashMap<>();
            int n = equations.size();
            for (int i = 0; i < n; i++) {
                String s = equations.get(i).get(0), e = equations.get(i).get(1);
                graph.putIfAbsent(s, new HashMap<>());
                graph.putIfAbsent(e, new HashMap<>());
                double v = values[i];
                graph.get(s).put(e, v);
                graph.get(e).put(s, 1 / v);
                // graph.get(s).put(s, 1.0);
                // graph.get(e).put(e, 1.0);
            }

            Deque<NodeData> deque = new ArrayDeque<>();
            HashSet<String> visited;
            int m = queries.size();
            double[] ans = new double[m];
            Arrays.fill(ans, -1.0);

            for (int i = 0; i < m; i++) {
                String qx = queries.get(i).get(0), qy = queries.get(i).get(1);
                if (!graph.containsKey(qx) || !graph.containsKey(qy))
                    continue;
                deque.offer(new NodeData(qx, 1.0));
                visited = new HashSet<>();
                visited.add(qx);
                while (!deque.isEmpty()) {
                    NodeData cur = deque.poll();
                    for (Map.Entry<String, Double> entry : graph.get(cur.var).entrySet()) {
                        String neighbor = entry.getKey();
                        Double weight = entry.getValue();
                        if (qy.equals(neighbor)) {
                            ans[i] = cur.mulWeight * weight;
                            break;
                        }
                        if (visited.add(neighbor))
                            deque.offer(new NodeData(neighbor, cur.mulWeight * weight));
                    }
                }
            }
            return ans;
        }

        /*用于广度优先搜索存储数据的节点数据结构*/
        class NodeData {
            String var;         // 当前变量名
            double mulWeight;   // 到达该节点时的累乘权重积

            NodeData(String var, double weight) {
                this.var = var;
                this.mulWeight = weight;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
