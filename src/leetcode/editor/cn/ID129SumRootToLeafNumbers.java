package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ID129SumRootToLeafNumbers {
    public static void main(String[] args) {
        Solution solution = new ID129SumRootToLeafNumbers().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        solution.sumNumbers(new TreeNode().stringToTree("1,2,3"));
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumNumbers(TreeNode root) {
            return sum(root, 0);
        }

        public int sum(TreeNode root, int sum) {
            if (root == null)
                return 0;
            int curSum = sum * 10 + root.val;
            if (root.left == null && root.right == null)
                return curSum;

            return sum(root.left, curSum) + sum(root.right, curSum);
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)

    int sum = 0;
    int pathSum = 0;

    /**
     * 描述:pathSum记录当前路径和，每下一层*10，返回上一层/10；遇到到叶子节点加入总和
     * Date 2024/9/11
     */
    public void sum1(TreeNode root) {
        if (root == null)
            return;
        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null)
            sum += pathSum;

        sum1(root.left);
        sum1(root.right);
        pathSum = pathSum - root.val;
        pathSum = pathSum / 10;
    }

    /**
     * 描述:用list将每条路径以字符存储——再遍历循环转数字求和即可
     * Date 2024/9/11
     */
    List<String> list = new ArrayList<>();
    StringBuilder str = new StringBuilder();

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        sum(root);
        for (int i = 0; i < list.toArray().length; i++) {
            sum += Integer.valueOf(list.get(i));
        }
        return sum;
    }

    public void sum(TreeNode root) {
        if (root == null)
            return;
        str.append(root.val);
        if (root.left == null && root.right == null)
            list.add(str.toString());

        sum(root.left);
        sum(root.right);
        str.deleteCharAt(str.length() - 1);
    }
}
