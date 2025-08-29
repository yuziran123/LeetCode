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
        // 利用有序数组的中间元素作为根节点，天然保证左右子树节点数量均衡，从而实现 “平衡”;
        // 递归划分左右区间，自然满足 BST 的 “左小右大” 特性。
        public TreeNode sortedArrayToBST(int[] nums) {
            return buildBST(nums, 0, nums.length - 1);// 左闭右开的区间
        }

        public TreeNode buildBST(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = buildBST(nums, left, mid - 1);
            node.right = buildBST(nums, mid + 1, right);
            return node;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
