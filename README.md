# LeetCode刷题记录

## 一、数组
1. [删除有序数组中的重复项Ⅱ ](src/leetcode/editor/cn/ID80RemoveDuplicatesFromSortedArrayIi.java)
2. [轮转数组](src/leetcode/editor/cn/ID189RotateArray.java)
3. [买卖股票的最佳时机Ⅱ](src/leetcode/editor/cn/ID122BestTimeToBuyAndSellStockIi.java)
4. [跳跃游戏](src/leetcode/editor/cn/ID55JumpGame.java)
5. [跳跃游戏Ⅱ](src/leetcode/editor/cn/ID45JumpGameIi.java)
6. [H指数](src/leetcode/editor/cn/ID274HIndex.java)[除自身以外数组的乘积](src/leetcode/editor/cn/ID238ProductOfArrayExceptSelf.java)
7. [加油站](src/leetcode/editor/cn/ID134GasStation.java)
8. [O(1) 时间插入、删除和获取随机元素](src/leetcode/editor/cn/ID380InsertDeleteGetrandomO1.java)



### 字符串

1. [整数转罗马数字](src/leetcode/editor/cn/ID12IntegerToRoman.java)
2. [Z字形变换](src/leetcode/editor/cn/ID6ZigzagConversion.java)
3. [文本左右对齐](src/leetcode/editor/cn/ID68TextJustification.java)


### 双指针
1. [验证回文串](src/leetcode/editor/cn/ID125ValidPalindrome.java)
2. [判断子序列](src/leetcode/editor/cn/ID392IsSubsequence.java)
3. [两数之和Ⅱ-输入有序数组](src/leetcode/editor/cn/ID167TwoSumIiInputArrayIsSorted.java)
4. [盛最多水的容器](src/leetcode/editor/cn/ID11ContainerWithMostWater.java)
5. [三数之和](src/leetcode/editor/cn/ID15ThreeSum.java)

### 滑动窗口
1. [长度最小的子数组](src/leetcode/editor/cn/ID209MinimumSizeSubarraySum.java)
2. [无重复字符的最长子串](src/leetcode/editor/cn/ID3LongestSubstringWithoutRepeatingCharacters.java)
3. [串联所有单词的子串](src/leetcode/editor/cn/ID30SubstringWithConcatenationOfAllWords.java)
4. [最小覆盖子串](src/leetcode/editor/cn/ID76MinimumWindowSubstring.java)

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

**笔记**

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

### 回溯

子集型

1. [电话号码的字母组合](src/leetcode/editor/cn/ID17LetterCombinationsOfAPhoneNumber.java)        [参考题解](https://leetcode.cn/problems/letter-combinations-of-a-phone-number/solutions/2059416/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-3orv/)     
2. [分割回文串](src/leetcode/editor/cn/ID131PalindromePartitioning.java)        [参考题解](https://leetcode.cn/problems/palindrome-partitioning/solutions/54233/hui-su-you-hua-jia-liao-dong-tai-gui-hua-by-liweiw/)
3. [子集](src/leetcode/editor/cn/ID78Subsets.java)

组合型 剪枝

1. [组合](src/leetcode/editor/cn/ID77Combinations.java)        [参考题解](https://leetcode.cn/problems/combinations/solutions/2071017/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-65lh/)        [参考题解](https://leetcode.cn/problems/combinations/solutions/6701/hua-jie-suan-fa-77-zu-he-by-guanpengchn/)
2. [组合总和](src/leetcode/editor/cn/ID39CombinationSum.java)
3. [括号生成](src/leetcode/editor/cn/ID22GenerateParentheses.java)        [参考题解](https://leetcode.cn/problems/generate-parentheses/solutions/2071015/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-wcdw/)

排列型

1. [全排列](src/leetcode/editor/cn/ID46Permutations.java)
2. [N皇后](src/leetcode/editor/cn/ID51NQueens.java)        [参考题解](https://leetcode.cn/problems/n-queens/solutions/2079586/hui-su-tao-lu-miao-sha-nhuang-hou-shi-pi-mljv/)
3. [N皇后Ⅱ](src/leetcode/editor/cn/ID52NQueensIi.java)
4. [单词搜索](src/leetcode/editor/cn/ID79WordSearch.java)        [参考题解](https://leetcode.cn/problems/word-search/solutions/12096/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/)

## 二、栈&链表

### 栈

1. [有效的括号](src/leetcode/editor/cn/ID20ValidParentheses.java)
2. [简化路径](src/leetcode/editor/cn/ID71SimplifyPath.java)
3. [最小栈](src/leetcode/editor/cn/ID155MinStack.java) ——用栈+辅助栈实现
4. [逆波兰表达式求值](src/leetcode/editor/cn/ID150EvaluateReversePolishNotation.java)
5. [基本计算器](src/leetcode/editor/cn/ID224BasicCalculator.java) 				

**笔记**

1. `path.split("/")`：将 `path` 字符串按 `/` 拆分成一个字符串数组。	

- "/home//user/"的切割结果是：	[]		home	[]	user	[]

2. Deque<>` 和 `Stack<>` 都可以用于实现栈。

- **`Deque<>`**:`LinkedList` 实现的 `Deque` 不是线程安全的。如果需要线程安全，可以使用 `ConcurrentLinkedDeque`。

  **`Stack<>`**:是线程安全的，因为它的方法是同步的，但这种线程安全特性可能会引入额外的开销。

  **总结**

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

**笔记**

1. 链表遍历注意

   ```Java
   //修改 head 可能会导致链表丢失；使用额外的 current 指针，可以在不改变原链表结构的情况下遍历链表。
   ```

## 三、二叉树

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

12. [二叉搜索树迭代器](src/leetcode/editor/cn/ID173BinarySearchTreeIterator.java)        [参考题解](https://leetcode.cn/problems/binary-search-tree-iterator/solutions/684405/xiang-jie-ru-he-dui-die-dai-ban-de-zhong-4rxj/)
13. [完全二叉树的节点个数](src/leetcode/editor/cn/ID222CountCompleteTreeNodes.java)
14. [二叉树的最近公共祖先](src/leetcode/editor/cn/ID236LowestCommonAncestorOfABinaryTree.java)       [参考题解](https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/2023872/fen-lei-tao-lun-luan-ru-ma-yi-ge-shi-pin-2r95/?envType=study-plan-v2&envId=top-interview-150)

**笔记**

1. [写树算法的套路框架](https://leetcode.cn/problems/same-tree/solutions/6558/xie-shu-suan-fa-de-tao-lu-kuang-jia-by-wei-lai-bu-/)

2. 对称二叉树定义

   ```Java
   1.L.val = R.val ：即此两对称节点值相等。
   2.L.left.val = R.right.val ：即 L 的 左子节点 和 R 的 右子节点 对称。
   3.L.right.val = R.left.val ：即 L 的 右子节点 和 R 的 左子节点 对称。
   ```

3. 细节

   ```Java
   List<TreeNode> cur = new ArrayList<>();
   List<TreeNode> next = new ArrayList<>();
   cur = next;
   将 cur 引用设置为指向 next 对象。cur 和 next 将指向同一个 ArrayList 实例
   cur 和 next 共享相同的数据，并且对其中一个的修改需要反映到另一个上
   ```

4. `Deque<T> cur = new LinkedList<>();和Deque<T> cur = new ArrayDeque<>();`

   ```Java
   LinkedList 是基于链表的实现。每个元素都包含指向前一个和下一个元素的指针。
   ArrayDeque 是基于动态数组的实现，内部使用了数组来存储元素
   
   LinkedList: 更适合频繁的插入和删除操作，尤其是在列表的两端或中间；随机访问较慢，内存开销较大。
   ArrayDeque: 更适合频繁的两端插入和删除操作，以及需要较低的内存开销；随机访问性能较好，但在极端情况下可能需要扩展数组的容量
   ```

5. 二叉搜索树

   ```
   前序遍历：往左子树，更新当前值为右区间；往右子树，更新当前值为左区间
   中序遍历：是个递增数组
   ```


### 二叉树层次遍历
1. [二叉树的右视图](src/leetcode/editor/cn/ID199BinaryTreeRightSideView.java)
2. [二叉树的层平均值](src/leetcode/editor/cn/ID637AverageOfLevelsInBinaryTree.java)
3. [二叉树的层序遍历](src/leetcode/editor/cn/ID102BinaryTreeLevelOrderTraversal.java)        [参考题解](https://leetcode.cn/problems/binary-tree-level-order-traversal/solutions/2049807/bfs-wei-shi-yao-yao-yong-dui-lie-yi-ge-s-xlpz/?envType=study-plan-v2&envId=top-interview-150)
4. [二叉树的锯齿形层序遍历](src/leetcode/editor/cn/ID103BinaryTreeZigzagLevelOrderTraversal.java)

### 二叉搜索树
1. [二叉搜索树的最小绝对差](src/leetcode/editor/cn/ID530MinimumAbsoluteDifferenceInBst.java)
2. [二叉搜索树中第K小的元素](src/leetcode/editor/cn/ID230KthSmallestElementInABst.java)
3. [验证二叉搜索树](src/leetcode/editor/cn/ID98ValidateBinarySearchTree.java)        [参考题解](https://leetcode.cn/problems/validate-binary-search-tree/solutions/2020306/qian-xu-zhong-xu-hou-xu-san-chong-fang-f-yxvh/)

### 分治

1. [将有序数组转换为二叉搜索树](src/leetcode/editor/cn/ID108ConvertSortedArrayToBinarySearchTree.java)        [参考题解](https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/solutions/2592692/javapython3cfen-zhi-zhong-xu-bian-li-mei-qkzz/)
2. [排序链表](src/leetcode/editor/cn/ID148SortList.java)        [参考题解](https://leetcode.cn/problems/sort-list/solutions/13728/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/)
3. [建立四叉树](src/leetcode/editor/cn/ID427ConstructQuadTree.java)        
4. [合并K个升序链表](src/leetcode/editor/cn/ID23MergeKSortedLists.java)

## 四、图

### 深度优先搜索

1. [岛屿问题: 在网格中DFS](https://leetcode.cn/problems/number-of-islands/solutions/211211/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/)
   1. [岛屿数量](src/leetcode/editor/cn/ID200NumberOfIslands.java)        
   2. [岛屿的周长](src/leetcode/editor/cn/ID463IslandPerimeter.java) 
   3. [岛屿的最大面积](src/leetcode/editor/cn/ID695MaxAreaOfIsland.java) 
   4. [最大人工岛](src/leetcode/editor/cn/ID827MakingALargeIsland.java)         [参考题解](https://leetcode.cn/problems/making-a-large-island/solutions/2808887/jian-ji-gao-xiao-ji-suan-dao-yu-de-mian-ab4h7/)

      ```Java
      HashSet 的 add 方法用于向集合中添加元素：
          集合中不存在该元素，add 方法会将其添加，并返回 true。
          如果元素已存在，则不做任何操作，返回 false
      ```

   5. [被围绕的区域](src/leetcode/editor/cn/ID130SurroundedRegions.java)

2. [克隆图](src/leetcode/editor/cn/ID133CloneGraph.java)            [参考题解](https://leetcode.cn/problems/clone-graph/solutions/965264/ke-long-tu-ha-xi-dfs-zui-qing-xi-yi-dong-3v6l/)

**拓扑排序**

1. [课程表](src/leetcode/editor/cn/ID207CourseSchedule.java)        [参考题解](https://leetcode.cn/problems/course-schedule/solutions/250377/bao-mu-shi-ti-jie-shou-ba-shou-da-tong-tuo-bu-pai-/)

   ```Java
   map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
   putIfAbsent 是 Map 接口的方法，它的功能是：
   如果指定的键当前不在 map 中，则将该键和指定的值放入 map。
   如果键已经存在，putIfAbsent 不会做任何操作，不会替换原有的值。
   ```
2. [课程表Ⅱ](src/leetcode/editor/cn/ID210CourseScheduleIi.java)

   `list.isEmpty() 和 list == null`

   ```java
   List<String> list = new ArrayList<>();
   System.out.println(list.isEmpty()); // true
   System.out.println(list == null);    // false
   
   List<String> list = null;
   System.out.println(list.isEmpty()); // 会抛出 NullPointerException
   System.out.println(list == null);    // true
   ```

   

### 广度优先搜索
1. [除法求值](src/leetcode/editor/cn/ID399EvaluateDivision.java)        [参考题解](https://leetcode.cn/problems/evaluate-division/solutions/2539446/javapython3cyan-du-you-xian-sou-suo-jian-uwy3/)
2. [最小基因变化](src/leetcode/editor/cn/ID433MinimumGeneticMutation.java)
3. [单词接龙](src/leetcode/editor/cn/ID127WordLadder.java)

## 五、查找

### 字典树

1. [实现Trie(前缀树)](src/leetcode/editor/cn/ID208ImplementTriePrefixTree.java)       [参考题解](https://leetcode.cn/problems/implement-trie-prefix-tree/solutions/2614334/javapython3cdfsbiao-zhi-wei-gou-zao-zi-d-zxrc/)
2. [添加与搜索单词-数据结构设计](src/leetcode/editor/cn/ID211DesignAddAndSearchWordsDataStructure.java)        [参考题解](https://leetcode.cn/problems/design-add-and-search-words-data-structure/solutions/2618841/javapython3czi-dian-shu-hui-su-fa-pi-pei-1tr7/)
3. [单词搜索Ⅱ](src/leetcode/editor/cn/ID212WordSearchIi.java)        [参考题解](https://leetcode.cn/problems/word-search-ii/solutions/2663477/javapython3chui-su-fa-zi-dian-shu-jian-z-0o8a/)

### 二分查找

1. [搜索插入位置](src/leetcode/editor/cn/ID35SearchInsertPosition.java)
2. [搜索二维矩阵](src/leetcode/editor/cn/ID74SearchA2dMatrix.java)
3. [寻找峰值](src/leetcode/editor/cn/ID162FindPeakElement.java)        [参考题解](https://leetcode.cn/problems/find-peak-element/solutions/6695/hua-jie-suan-fa-162-xun-zhao-feng-zhi-by-guanpengc/)
4. [搜索旋转排序数组](src/leetcode/editor/cn/ID33SearchInRotatedSortedArray.java)       
5. [在排序数组中查找元素的第一个和最后一个位置](src/leetcode/editor/cn/ID34FindFirstAndLastPositionOfElementInSortedArray.java)
6. [寻找旋转排序数组中的最小值](src/leetcode/editor/cn/ID153FindMinimumInRotatedSortedArray.java)        [参考题解](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/126635/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/)
7. [寻找两个正序数组的中位数](src/leetcode/editor/cn/ID4MedianOfTwoSortedArrays.java)

### 堆

1. [数组中的第K个最大元素](src/leetcode/editor/cn/ID215KthLargestElementInAnArray.java)

   ```
   Queue<Integer> heap = new PriorityQueue<>();	// PriorityQueue 默认是小根堆
   PriorityQueue 是一个基于优先级的队列，默认情况下，它按照自然顺序排列元素，即小根堆，堆顶是最小元素。为了实现大根堆，我们可以使用 Collections.reverseOrder() 作为构造参数。
   Collections.reverseOrder() 返回一个比较器，这个比较器反转了元素的自然顺序
       
   maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 大根堆
   
   不提供比较器：使用默认自然顺序（小根堆）。
   提供比较器：按照指定的顺序排列元素（可以是大根堆或其他顺序）
   ```

2. [IPO](src/leetcode/editor/cn/ID502Ipo.java)

3. [查找和最小的K对数字](src/leetcode/editor/cn/ID373FindKPairsWithSmallestSums.java)        [参考题解](https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solutions/1210157/tong-ge-lai-shua-ti-la-you-xian-ji-dui-l-fw7y/)

   **数组转List**

   ```java
   int[] poll = heap.poll();
   List<Integer> list = Arrays.stream(poll).boxed().collect(Collectors.toList());
   Arrays.stream(poll):	这个方法将 int[] 转换为一个流（Stream）。流是一种可以处理数据序列的功能。
   .boxed():这个方法将 int 原始类型的流转换为 Integer 对象的流。因为 Java 的集合类（如 List）只能存储对象，而不能存储原始类型。
   .collect(Collectors.toList()):最后，使用 Collectors.toList() 将流收集到一个 List<Integer> 中。这样就完成了从 int[] 到 List<Integer> 的转换。
   ```
4. [数据流的中位数](src/leetcode/editor/cn/ID295FindMedianFromDataStream.java)

## 六、数学
1. [回文数](src/leetcode/editor/cn/ID9PalindromeNumber.java)
2. [加一](src/leetcode/editor/cn/ID66PlusOne.java)
3. [阶乘后的零](src/leetcode/editor/cn/ID172FactorialTrailingZeroes.java)        [参考题解](https://leetcode.cn/problems/factorial-trailing-zeroes/solutions/1366037/by-ac_oier-1y6w/)
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
4. [只出现一次的数字](src/leetcode/editor/cn/ID136SingleNumber.java)       [参考题解](https://leetcode.cn/problems/single-number/solutions/10261/hua-jie-suan-fa-136-zhi-chu-xian-yi-ci-de-shu-zi-b/)        [参考题解2](https://leetcode.cn/problems/single-number/solutions/2481594/li-yong-yi-huo-de-xing-zhi-fu-ti-dan-pyt-oizc/)
5. [只出现一次的数字Ⅱ](src/leetcode/editor/cn/ID137SingleNumberIi.java)        [参考题解](https://leetcode.cn/problems/single-number-ii/solutions/2482832/dai-ni-yi-bu-bu-tui-dao-chu-wei-yun-suan-wnwy/)
6. [数字范围按位OR](src/leetcode/editor/cn/ID201BitwiseAndOfNumbersRange.java)        [参考题解](https://leetcode.cn/problems/bitwise-and-of-numbers-range/solutions/624595/hua-tu-fen-xi-201-ti-shu-zi-fan-wei-an-w-vzfb/)

**笔记**

1. 在数学上，将一个整数转换为二进制的过程包括以下步骤：

   1. **除以 2**: 将整数除以 2，记录下余数（0 或 1）。
   2. **记录商**: 将除法得到的商作为新的数，重复步骤 1。
   3. **重复直到商为 0**: 继续除以 2，直到商为 0。
   4. **逆序余数**: 最终，二进制表示是余数从最后一次到第一次的逆序排列。

   ### 示例

   将 13 转换为二进制：

   13 ÷ 2 = 6，余数 1

   6 ÷ 2 = 3，余数 0

   3 ÷ 2 = 1，余数 1

   1 ÷ 2 = 0，余数 1

   余数从最后到最开始的逆序是 1101，因此 13 的二进制表示是 `1101`

## 七、动态规划

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

## 八、贪心算法
