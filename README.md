# LeetCode刷题记录

## 数组
1. [删除有序数组中的重复项Ⅱ ](src/leetcode/editor/cn/ID80RemoveDuplicatesFromSortedArrayIi.java)
2. [轮转数组](src/leetcode/editor/cn/ID189RotateArray.java)
3. [买卖股票的最佳时机Ⅱ](src/leetcode/editor/cn/ID122BestTimeToBuyAndSellStockIi.java)
4. [跳跃游戏](src/leetcode/editor/cn/ID55JumpGame.java)
5. [跳跃游戏Ⅱ](src/leetcode/editor/cn/ID45JumpGameIi.java)
6. [H指数](src/leetcode/editor/cn/ID274HIndex.java)[除自身以外数组的乘积](src/leetcode/editor/cn/ID238ProductOfArrayExceptSelf.java)
7. [加油站](src/leetcode/editor/cn/ID134GasStation.java)

- [ ] O(1) 时间插入、删除和获取随机元素



### 字符串

1. [整数转罗马数字](src/leetcode/editor/cn/ID12IntegerToRoman.java)
2. [Z字形变换](src/leetcode/editor/cn/ID6ZigzagConversion.java)

- [ ] 文本左右对齐


### 双指针
1. [验证回文串](src/leetcode/editor/cn/ID125ValidPalindrome.java)
2. [判断子序列](src/leetcode/editor/cn/ID392IsSubsequence.java)
3. [两数之和Ⅱ-输入有序数组](src/leetcode/editor/cn/ID167TwoSumIiInputArrayIsSorted.java)
4. [盛最多水的容器](src/leetcode/editor/cn/ID11ContainerWithMostWater.java)
5. [三数之和](src/leetcode/editor/cn/ID15ThreeSum.java)

### 滑动窗口
1. [长度最小的子数组](src/leetcode/editor/cn/ID209MinimumSizeSubarraySum.java)
2. [无重复字符的最长子串](src/leetcode/editor/cn/ID3LongestSubstringWithoutRepeatingCharacters.java)

- [ ] 串联所有单词的子串
- [ ] 最小覆盖子串

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

`"/home//user/"`的切割结果是	

```Java
[]	home	[]	user	[]
```

2. Deque<>` 和 `Stack<>` 都可以用于实现栈。

   - **`Deque<>`**:`LinkedList` 实现的 `Deque` 不是线程安全的。如果需要线程安全，可以使用 `ConcurrentLinkedDeque`。

   - **`Stack<>`**:是线程安全的，因为它的方法是同步的，但这种线程安全特性可能会引入额外的开销。
     
   -  **总结**
     
     如果应用场景需要线程安全的栈，`Stack<>` 可能会更合适。
     
     在大多数情况下，特别是当不需要线程安全性时，使用 `Deque<>`（尤其是 `ArrayDeque` 实现）会更高效，并且是推荐的做法


3.  `StringBuilder` 的 `equals` 方法

   - `StringBuilder` 类的 `equals` 方法并没有被重写，因此它继承了 `Object` 类的默认 `equals` 实现。这个默认实现比较的是对象的引用，而不是对象的内容。

   - 因此，`ans.equals("")` 会检查 `ans` 对象是否与 `""`（一个空字符串对象）相同，而这永远是 `false`，因为 `StringBuilder` 和 `String` 是不同的类，即使 `StringBuilder` 为空，它也不等于一个空字符串。

   - 要检查一个 `StringBuilder` 对象是否为空（即其内容是否为空），应该使用 `StringBuilder` 提供的方法，比如 `length()` 或 `toString()`

4. 

### 链表
1. [环形链表](src/leetcode/editor/cn/ID141LinkedListCycle.java)
2. [两数相加](src/leetcode/editor/cn/ID2AddTwoNumbers.java)
3. [合并两个有序链表](src/leetcode/editor/cn/ID21MergeTwoSortedLists.java)
4. [随机链表的复制](src/leetcode/editor/cn/IDLCR138BiaoShiShuZhiDeZiFuChuanLcof.java)
5. [反转链表](src/leetcode/editor/cn/ID92ReverseLinkedListIi.java)Ⅱ
6. [K个一组翻转链表](src/leetcode/editor/cn/ID25ReverseNodesInKGroup.java)
7. [删除排序链表中的重复元素](src/leetcode/editor/cn/ID82RemoveDuplicatesFromSortedListIi.java)Ⅱ
8. [旋转链表](src/leetcode/editor/cn/ID61RotateList.java)
9. [分隔链表](src/leetcode/editor/cn/ID86PartitionList.java)
10. LRU[缓存](src/leetcode/editor/cn/ID146LruCache.java)

## 二叉树

二叉树的最大深度
相同的树
翻转二叉树
对称二叉树
从前序与中序遍历序列构造二叉树
从中序与后序遍历序列构造二叉树
填充每个节点的下一个右侧节点指针Ⅱ
二叉树展开为链表
路径总和
求根节点到叶节点数字之和
二叉树中的最大路径和
二叉搜索树迭代器
完全二叉树的节点个数
二叉树的最近公共祖先

### 二叉树层次遍历
二叉树的右视图
二叉树的层平均值
二叉树的层序遍历
二叉树的锯齿形层序遍历

### 二叉搜索树
二叉搜索树的最小绝对差
二叉搜索树中第K小的元素
验证二叉搜索树

## 图
岛屿数量
被围绕的区域
克隆图
除法求值
课程表
课程表Ⅱ

### 图的广度优先搜索
蛇梯棋
最小基因变化
单词接龙

## 回溯
电话号码的字母组合
组合
全排列
组合总和
N皇后Ⅱ
括号生成
单词搜索

## 分治
将有序数组转换为二叉搜索树
排序链表
建立四叉树
合并K个升序链表

## 查找

### 字典树

实现Trie(前缀树)
添加与搜索单词-数据结构设计
单词搜索Ⅱ

### 二分查找

搜索插入位置
搜索二维矩阵
寻找峰值
搜索旋转排序数组
在排序数组中查找元素的第一个和最后一个位置
寻找旋转排序数组中的最小值
寻找两个正序数组的中位数

### 堆

数组中的第K个最大元素
IPO
查找和最小的K对数字
数据流的中位数

## 数学
回文数
加一
阶乘后的零
x的平方根
Pow(x, n)
直线上最多的点数

### 矩阵

有效的数独
螺旋矩阵
旋转图像
矩阵置零
生命游戏

### 位运算

二进制求和
颠倒二进制位
位1的个数
只出现一次的数字
只出现一次的数字Ⅱ
数字范围按位OR

## 动态规划

### 一维动态规划

爬楼梯
打家劫舍
单词拆分
零钱兑换
最长递增子序列

### 多维动态规划
三角形最小路径和
最小路径和
不同路径Ⅱ
最长回文子串
交错字符串
编辑距离
买卖股票的最佳时机Ⅱ
买卖股票的最佳时机Ⅳ
最大正方形
设置学习计划
