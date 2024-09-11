# LeetCode刷题记录

## 数组
1. [删除有序数组中的重复项Ⅱ ](src/leetcode/editor/cn/ID80RemoveDuplicatesFromSortedArrayIi.java)
2. [轮转数组](src/leetcode/editor/cn/ID189RotateArray.java)
3. [买卖股票的最佳时机Ⅱ](src/leetcode/editor/cn/ID122BestTimeToBuyAndSellStockIi.java)
4. [跳跃游戏](src/leetcode/editor/cn/ID55JumpGame.java)
5. [跳跃游戏Ⅱ](src/leetcode/editor/cn/ID45JumpGameIi.java)
6. [H指数](src/leetcode/editor/cn/ID274HIndex.java)[除自身以外数组的乘积](src/leetcode/editor/cn/ID238ProductOfArrayExceptSelf.java)
7. [加油站](src/leetcode/editor/cn/ID134GasStation.java)

- [ ] [O(1) 时间插入、删除和获取随机元素](src/leetcode/editor/cn/ID380InsertDeleteGetrandomO1.java)



### 字符串

1. [整数转罗马数字](src/leetcode/editor/cn/ID12IntegerToRoman.java)
2. [Z字形变换](src/leetcode/editor/cn/ID6ZigzagConversion.java)

- [ ] [文本左右对齐](src/leetcode/editor/cn/ID68TextJustification.java)


### 双指针
1. [验证回文串](src/leetcode/editor/cn/ID125ValidPalindrome.java)
2. [判断子序列](src/leetcode/editor/cn/ID392IsSubsequence.java)
3. [两数之和Ⅱ-输入有序数组](src/leetcode/editor/cn/ID167TwoSumIiInputArrayIsSorted.java)
4. [盛最多水的容器](src/leetcode/editor/cn/ID11ContainerWithMostWater.java)
5. [三数之和](src/leetcode/editor/cn/ID15ThreeSum.java)

### 滑动窗口
1. [长度最小的子数组](src/leetcode/editor/cn/ID209MinimumSizeSubarraySum.java)
2. [无重复字符的最长子串](src/leetcode/editor/cn/ID3LongestSubstringWithoutRepeatingCharacters.java)

- [ ] [串联所有单词的子串](src/leetcode/editor/cn/ID30SubstringWithConcatenationOfAllWords.java)
- [ ] [最小覆盖子串](src/leetcode/editor/cn/ID76MinimumWindowSubstring.java)

### 哈希表
1. [赎金信](src/leetcode/editor/cn/ID383RansomNote.java)
2. [有效的字母异位词](src/leetcode/editor/cn/ID242ValidAnagram.java)
3. [字母异位词分组](src/leetcode/editor/cn/ID49GroupAnagrams.java)
4. [快乐数](src/leetcode/editor/cn/ID202HappyNumber.java)
5. [存在重复元素Ⅱ](src/leetcode/editor/cn/ID219ContainsDuplicateIi.java)
6. [最长连续序列](src/leetcode/editor/cn/ID128LongestConsecutiveSequence.java)
7. [三数之和](src/leetcode/editor/cn/ID15ThreeSum.java)		[参考题解](https://leetcode.cn/problems/3sum/solutions/12307/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/)


### 区间
1. [汇总区间](src/leetcode/editor/cn/ID228SummaryRanges.java)
2. [合并区间](src/leetcode/editor/cn/ID56MergeIntervals.java)			[参考题解](https://leetcode.cn/problems/merge-intervals/solutions/2798138/jian-dan-zuo-fa-yi-ji-wei-shi-yao-yao-zh-f2b3/?envType=study-plan-v2&envId=top-interview-150)
3. [插入区间](src/leetcode/editor/cn/ID57InsertInterval.java)
4. [用最少数量的箭引爆气球](src/leetcode/editor/cn/ID452MinimumNumberOfArrowsToBurstBalloons.java)	[参考题解](https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/solutions/858320/dai-ma-sui-xiang-lu-dai-ni-xue-tou-tan-x-5wfl/?envType=study-plan-v2&envId=top-interview-150)

#### 笔记

1. `ans.toArray(new int[0][])` 会创建一个新的 `int[][]` 数组，并将 `ans` 中的元素复制到这个数组中。`new int[0][]` 是一个空的二维数组，用于告诉 `toArray` 方法返回的数组类型，并根据 `ans` 的大小来创建实际的数组。

   ```java
   List<int[]> ans = new ArrayList<>();
   return ans.toArray(new int[0][]);
   ```

2. 按 `intervals[][]` 的每一行的首元素排序

   ```java
   Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
   ```

3. **区间问题的关键在于左右端点的判断和更新时机**

### Kadane算法

1. 最大子数组和
2. 环形子数组的最大和

## 数据结构

### 栈

1. [有效的括号](src/leetcode/editor/cn/ID20ValidParentheses.java)
2. [简化路径](src/leetcode/editor/cn/ID71SimplifyPath.java)
3. [最小栈](src/leetcode/editor/cn/ID155MinStack.java) ——用栈+辅助栈实现
4. [逆波兰表达式求值](src/leetcode/editor/cn/ID150EvaluateReversePolishNotation.java)

- [ ] [基本计算器](src/leetcode/editor/cn/ID224BasicCalculator.java) 				

#### 笔记

1. `path.split("/")`：将 `path` 字符串按 `/` 拆分成一个字符串数组。	

`"/home//user/"`的切割结果是：	`[]		home	[]	user	[]`

2. Deque<>` 和 `Stack<>` 都可以用于实现栈。

- **`Deque<>`**:`LinkedList` 实现的 `Deque` 不是线程安全的。如果需要线程安全，可以使用 `ConcurrentLinkedDeque`。

- **`Stack<>`**:是线程安全的，因为它的方法是同步的，但这种线程安全特性可能会引入额外的开销。

-  **总结**
  
  如果应用场景需要线程安全的栈，`Stack<>` 可能会更合适。
  
  在大多数情况下，特别是当不需要线程安全性时，使用 `Deque<>`（尤其是 `ArrayDeque` 实现）会更高效，并且是推荐的做法

3. `StringBuilder` 的 `equals` 方法

- `StringBuilder` 类的 `equals` 方法并没有被重写，因此它继承了 `Object` 类的默认 `equals` 实现。这个默认实现比较的是对象的引用，而不是对象的内容。

- 因此，`ans.equals("")` 会检查 `ans` 对象是否与 `""`（一个空字符串对象）相同，而这永远是 `false`，因为 `StringBuilder` 和 `String` 是不同的类，即使 `StringBuilder` 为空，它也不等于一个空字符串。

- 要检查一个 `StringBuilder` 对象是否为空（即其内容是否为空），应该使用 `StringBuilder` 提供的方法，比如 `length()` 或 `toString()`

### 链表
1. [环形链表](src/leetcode/editor/cn/ID141LinkedListCycle.java) 
2.  [环形链表Ⅱ](src/leetcode/editor/cn/ID142LinkedListCycleIi.java)  [快慢指针参考题解](https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/)
3. [两数相加](src/leetcode/editor/cn/ID2AddTwoNumbers.java)
4. [合并两个有序链表](src/leetcode/editor/cn/ID21MergeTwoSortedLists.java)
5. [随机链表的复制](src/leetcode/editor/cn/IDLCR138BiaoShiShuZhiDeZiFuChuanLcof.java)    [参考题解](https://leetcode.cn/problems/copy-list-with-random-pointer/solutions/295083/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/?envType=study-plan-v2&envId=top-interview-150)
6. [反转链表Ⅱ](src/leetcode/editor/cn/ID92ReverseLinkedListIi.java)  
7.  [反转链表](src/leetcode/editor/cn/ID206ReverseLinkedList.java)   [参考题解](https://leetcode.cn/problems/reverse-linked-list/solutions/1992225/you-xie-cuo-liao-yi-ge-shi-pin-jiang-tou-o5zy/)
8. [K个一组翻转链表](src/leetcode/editor/cn/ID25ReverseNodesInKGroup.java)
9. [删除排序链表中的重复元素Ⅱ](src/leetcode/editor/cn/ID82RemoveDuplicatesFromSortedListIi.java)
10. [旋转链表](src/leetcode/editor/cn/ID61RotateList.java)
11. [分隔链表](src/leetcode/editor/cn/ID86PartitionList.java)     [参考题解](https://leetcode.cn/problems/partition-list/solutions/2362068/86-fen-ge-lian-biao-shuang-zhi-zhen-qing-hha7/?envType=study-plan-v2&envId=top-interview-150)
12. [LRU缓存](src/leetcode/editor/cn/ID146LruCache.java)     [参考题解](https://leetcode.cn/problems/lru-cache/solutions/2456294/tu-jie-yi-zhang-tu-miao-dong-lrupythonja-czgt/)

#### 笔记

1. 链表遍历注意

   ```Java
   //修改 head 可能会导致链表丢失；使用额外的 current 指针，可以在不改变原链表结构的情况下遍历链表。
   ```

## 二叉树

1. [二叉树的最大深度](src/leetcode/editor/cn/ID104MaximumDepthOfBinaryTree.java)
2. [相同的树](src/leetcode/editor/cn/ID100SameTree.java)  
3. [翻转二叉树](src/leetcode/editor/cn/ID226InvertBinaryTree.java)
4. [对称二叉树](src/leetcode/editor/cn/ID101SymmetricTree.java)        [参考题解](https://leetcode.cn/problems/symmetric-tree/solutions/2361627/101-dui-cheng-er-cha-shu-fen-zhi-qing-xi-8oba/)
5. [从前序与中序遍历序列构造二叉树](src/leetcode/editor/cn/ID105ConstructBinaryTreeFromPreorderAndInorderTraversal.java)        [参考题解](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/2646359/tu-jie-cong-on2-dao-onpythonjavacgojsrus-aob8/)        [参考题解2](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solutions/2361558/105-cong-qian-xu-yu-zhong-xu-bian-li-xu-4lvkz/)
6. [从中序与后序遍历序列构造二叉树](src/leetcode/editor/cn/ID106ConstructBinaryTreeFromInorderAndPostorderTraversal.java)
7. [填充每个节点的下一个右侧节点指针Ⅱ](src/leetcode/editor/cn/ID117PopulatingNextRightPointersInEachNodeIi.java)
8. [二叉树展开为链表](src/leetcode/editor/cn/ID114FlattenBinaryTreeToLinkedList.java)
9. [路径总和](src/leetcode/editor/cn/ID112PathSum.java)
10. [求根节点到叶节点数字之和](src/leetcode/editor/cn/ID129SumRootToLeafNumbers.java)
11. [二叉树中的最大路径和](src/leetcode/editor/cn/ID124BinaryTreeMaximumPathSum.java)
12. [二叉搜索树迭代器](src/leetcode/editor/cn/ID173BinarySearchTreeIterator.java)
13. [完全二叉树的节点个数](src/leetcode/editor/cn/ID222CountCompleteTreeNodes.java)
14. [二叉树的最近公共祖先](src/leetcode/editor/cn/ID236LowestCommonAncestorOfABinaryTree.java)

#### 笔记

1. [写树算法的套路框架](https://leetcode.cn/problems/same-tree/solutions/6558/xie-shu-suan-fa-de-tao-lu-kuang-jia-by-wei-lai-bu-/)

2. 对称二叉树定义

   ```Java
   1.L.val = R.val ：即此两对称节点值相等。
   2.L.left.val = R.right.val ：即 L 的 左子节点 和 R 的 右子节点 对称。
   3.L.right.val = R.left.val ：即 L 的 右子节点 和 R 的 左子节点 对称。
   ```
   
3. 

### 二叉树层次遍历
1. [二叉树的右视图](src/leetcode/editor/cn/ID199BinaryTreeRightSideView.java)
2. [二叉树的层平均值](src/leetcode/editor/cn/ID637AverageOfLevelsInBinaryTree.java)
3. [二叉树的层序遍历](src/leetcode/editor/cn/ID102BinaryTreeLevelOrderTraversal.java)
4. [二叉树的锯齿形层序遍历](src/leetcode/editor/cn/ID103BinaryTreeZigzagLevelOrderTraversal.java)

### 二叉搜索树
1. [二叉搜索树的最小绝对差](src/leetcode/editor/cn/ID530MinimumAbsoluteDifferenceInBst.java)
2. [二叉搜索树中第K小的元素](src/leetcode/editor/cn/ID230KthSmallestElementInABst.java)
3. [验证二叉搜索树](src/leetcode/editor/cn/ID98ValidateBinarySearchTree.java)

## 图
1. [岛屿数量](src/leetcode/editor/cn/ID200NumberOfIslands.java)
2. [被围绕的区域](src/leetcode/editor/cn/ID130SurroundedRegions.java)
3. [克隆图](src/leetcode/editor/cn/ID133CloneGraph.java)
4. [除法求值](src/leetcode/editor/cn/ID399EvaluateDivision.java)
5. [课程表](src/leetcode/editor/cn/ID207CourseSchedule.java)
6. [课程表Ⅱ](src/leetcode/editor/cn/ID210CourseScheduleIi.java)

### 图的广度优先搜索
1. [蛇梯棋](src/leetcode/editor/cn/ID909SnakesAndLadders.java)
2. [最小基因变化](src/leetcode/editor/cn/ID433MinimumGeneticMutation.java)
3. [单词接龙](src/leetcode/editor/cn/ID127WordLadder.java)

## 回溯
1. [电话号码的字母组合](src/leetcode/editor/cn/ID17LetterCombinationsOfAPhoneNumber.java)
2. [组合](src/leetcode/editor/cn/ID77Combinations.java)
3. [全排列](src/leetcode/editor/cn/ID46Permutations.java)
4. [组合总和](src/leetcode/editor/cn/ID39CombinationSum.java)
5. [N皇后Ⅱ](src/leetcode/editor/cn/ID52NQueensIi.java)
6. [括号生成](src/leetcode/editor/cn/ID22GenerateParentheses.java)
7. [单词搜索](src/leetcode/editor/cn/ID79WordSearch.java)

## 分治
1. [将有序数组转换为二叉搜索树](src/leetcode/editor/cn/ID108ConvertSortedArrayToBinarySearchTree.java)
2. [排序链表](src/leetcode/editor/cn/ID148SortList.java)
3. [建立四叉树](src/leetcode/editor/cn/ID427ConstructQuadTree.java)
4. [合并K个升序链表](src/leetcode/editor/cn/ID23MergeKSortedLists.java)

## 查找

### 字典树

1. [实现Trie(前缀树)](src/leetcode/editor/cn/ID208ImplementTriePrefixTree.java)
2. [添加与搜索单词-数据结构设计](src/leetcode/editor/cn/ID211DesignAddAndSearchWordsDataStructure.java)
3. [单词搜索Ⅱ](src/leetcode/editor/cn/ID212WordSearchIi.java)

### 二分查找

1. [搜索插入位置](src/leetcode/editor/cn/ID35SearchInsertPosition.java)
2. [搜索二维矩阵](src/leetcode/editor/cn/ID74SearchA2dMatrix.java)
3. [寻找峰值](src/leetcode/editor/cn/ID162FindPeakElement.java)
4. [搜索旋转排序数组](src/leetcode/editor/cn/ID33SearchInRotatedSortedArray.java)
5. [在排序数组中查找元素的第一个和最后一个位置](src/leetcode/editor/cn/ID34FindFirstAndLastPositionOfElementInSortedArray.java)
6. [寻找旋转排序数组中的最小值](src/leetcode/editor/cn/ID153FindMinimumInRotatedSortedArray.java)
7. [寻找两个正序数组的中位数](src/leetcode/editor/cn/ID4MedianOfTwoSortedArrays.java)

### 堆

1. [数组中的第K个最大元素](src/leetcode/editor/cn/ID215KthLargestElementInAnArray.java)
2. [IPO](src/leetcode/editor/cn/ID502Ipo.java)
3. [查找和最小的K对数字](src/leetcode/editor/cn/ID373FindKPairsWithSmallestSums.java)
4. [数据流的中位数](src/leetcode/editor/cn/ID295FindMedianFromDataStream.java)

## 数学
1. [回文数](src/leetcode/editor/cn/ID9PalindromeNumber.java)
2. [加一](src/leetcode/editor/cn/ID66PlusOne.java)
3. [阶乘后的零](src/leetcode/editor/cn/ID172FactorialTrailingZeroes.java)
4. [x的平方根](src/leetcode/editor/cn/ID69Sqrtx.java)
5. [Pow(x, n)](src/leetcode/editor/cn/ID50PowxN.java)
6. [直线上最多的点数](src/leetcode/editor/cn/ID149MaxPointsOnALine.java)

### 矩阵

1. [有效的数独](src/leetcode/editor/cn/ID36ValidSudoku.java)
2. [旋转图像](src/leetcode/editor/cn/ID36ValidSudoku.java)
3. [矩阵置零](src/leetcode/editor/cn/ID73SetMatrixZeroes.java)
4. [生命游戏](src/leetcode/editor/cn/ID289GameOfLife.java)

### 位运算

1. [二进制求和](src/leetcode/editor/cn/ID67AddBinary.java)
2. [颠倒二进制位](src/leetcode/editor/cn/ID190ReverseBits.java)
3. [位1的个数](src/leetcode/editor/cn/ID191NumberOf1Bits.java)
4. [只出现一次的数字](src/leetcode/editor/cn/ID136SingleNumber.java)
5. [只出现一次的数字Ⅱ](src/leetcode/editor/cn/ID137SingleNumberIi.java)
6. [数字范围按位OR](src/leetcode/editor/cn/ID201BitwiseAndOfNumbersRange.java)

## 动态规划

### 一维动态规划

1. [爬楼梯](src/leetcode/editor/cn/ID70ClimbingStairs.java)
2. [打家劫舍](src/leetcode/editor/cn/ID198HouseRobber.java)
3. [单词拆分](src/leetcode/editor/cn/ID139WordBreak.java)
4. [零钱兑换](src/leetcode/editor/cn/ID322CoinChange.java)
5. [最长递增子序列](src/leetcode/editor/cn/ID300LongestIncreasingSubsequence.java)

### 多维动态规划
1. [三角形最小路径和](src/leetcode/editor/cn/ID120Triangle.java)
2. [最小路径和](src/leetcode/editor/cn/ID64MinimumPathSum.java)
3. [不同路径Ⅱ](src/leetcode/editor/cn/ID63UniquePathsIi.java)
4. [最长回文子串](src/leetcode/editor/cn/ID5LongestPalindromicSubstring.java)
5. [交错字符串](src/leetcode/editor/cn/ID97InterleavingString.java)
6. [编辑距离](src/leetcode/editor/cn/ID72EditDistance.java)
7. [买卖股票的最佳时机Ⅱ](src/leetcode/editor/cn/ID123BestTimeToBuyAndSellStockIii.java)
8. [买卖股票的最佳时机Ⅳ](src/leetcode/editor/cn/ID188BestTimeToBuyAndSellStockIv.java)
9. [最大正方形](src/leetcode/editor/cn/ID221MaximalSquare.java)
