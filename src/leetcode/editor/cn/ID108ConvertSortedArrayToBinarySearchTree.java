package leetcode.editor.cn;

import leetcode.editor.util.TreeNode;

public class ID108ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ID108ConvertSortedArrayToBinarySearchTree().new Solution();
        StringBuilder builder = new StringBuilder();
        // 执行测试
        System.out.println(builder);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            // 左闭右开的区间
            return buildBST(nums, 0, nums.length - 1);
        }

        public TreeNode buildBST(int[] nums, int left, int right) {
            if (left > right)
                return null;
            // 选择右中间元素，构建的更平衡
            int mid = (left + right + 1) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildBST(nums, left, mid - 1);
            node.right = buildBST(nums, mid + 1, right);
            return node;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
