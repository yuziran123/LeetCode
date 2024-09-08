# LeetCode刷题记录

## 数组/字符串
合并两个有序数组
移除元素
删除有序数组中的重复项
删除有序数组中的重复项Ⅱ
多数元素
轮转数组
买卖股票的最佳时机
买卖股票的最佳时机Ⅱ
跳跃游戏
跳跃游戏Ⅱ
H指数
O(1) 时间插入、删除和获取随机元素
除自身以外数组的乘积
加油站
分发糖果
接雨水
罗马数字转整数
整数转罗马数字
最后一个单词的长度
最长公共前缀
反转字符串中的单词
Z字形变换
找出字符串中第一个匹配项的下标
文本左右对齐




## 双指针
验证回文串
判断子序列
两数之和Ⅱ-输入有序数组
盛最多水的容器
三数之和
## 滑动窗口
长度最小的子数组
无重复字符的最长子串
串联所有单词的子串
最小覆盖子串
## 矩阵
有效的数独
螺旋矩阵
旋转图像
矩阵置零
生命游戏
## 哈希表
赎金信
同构字符串
单词规律

[有效的字母异位词](src/leetcode/editor/cn/ID242ValidAnagram.java)

字母异位词分组
两数之和
快乐数
存在重复元素Ⅱ
最长连续序列

[三数之和](src/leetcode/editor/cn/ID15ThreeSum.java)		[参考题解](https://leetcode.cn/problems/3sum/solutions/12307/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/)




## 区间
[汇总区间](src/leetcode/editor/cn/ID228SummaryRanges.java)

[合并区间](src/leetcode/editor/cn/ID56MergeIntervals.java)			[参考题解](https://leetcode.cn/problems/merge-intervals/solutions/2798138/jian-dan-zuo-fa-yi-ji-wei-shi-yao-yao-zh-f2b3/?envType=study-plan-v2&envId=top-interview-150)

[插入区间](src/leetcode/editor/cn/ID57InsertInterval.java)

[用最少数量的箭引爆气球](src/leetcode/editor/cn/ID452MinimumNumberOfArrowsToBurstBalloons.java)	[参考题解](https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/solutions/858320/dai-ma-sui-xiang-lu-dai-ni-xue-tou-tan-x-5wfl/?envType=study-plan-v2&envId=top-interview-150)

### 笔记

1. `ans.toArray(new int[0][])` 会创建一个新的 `int[][]` 数组，并将 `ans` 中的元素复制到这个数组中。`new int[0][]` 是一个空的二维数组，用于告诉 `toArray` 方法返回的数组类型，并根据 `ans` 的大小来创建实际的数组。

   ```java
   List<int[]> ans = new ArrayList<>();
   return ans.toArray(new int[0][]);
   ```

2. 按 `intervals[][]` 的每一行的首元素排序

   ```java
   Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
   ```

3. 区间问题的关键在于左右端点的判断和更新时机

## 栈

有效的括号
[简化路径](src/leetcode/editor/cn/ID71SimplifyPath.java)
[最小栈](src/leetcode/editor/cn/ID155MinStack.java)
逆波兰表达式求值
[基本计算器](src/leetcode/editor/cn/ID224BasicCalculator.java)

## 链表
环形链表
两数相加
合并两个有序链表
随机链表的复制
反转链表Ⅱ
K个一组翻转链表
删除链表的倒数第N个结点
删除排序链表中的重复元素Ⅱ
旋转链表
分隔链表
LRU缓存

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

## 二叉树层次遍历
二叉树的右视图
二叉树的层平均值
二叉树的层序遍历
二叉树的锯齿形层序遍历

## 二叉搜索树
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

## 图的广度优先搜索
蛇梯棋
最小基因变化
单词接龙

## 字典树
实现Trie(前缀树)
添加与搜索单词-数据结构设计
单词搜索Ⅱ

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

## Kadane算法
最大子数组和
环形子数组的最大和

## 二分查找
搜索插入位置
搜索二维矩阵
寻找峰值
搜索旋转排序数组
在排序数组中查找元素的第一个和最后一个位置
寻找旋转排序数组中的最小值
寻找两个正序数组的中位数

## 堆
数组中的第K个最大元素
IPO
查找和最小的K对数字
数据流的中位数

## 位运算
二进制求和
颠倒二进制位
位1的个数
只出现一次的数字
只出现一次的数字Ⅱ
数字范围按位OR

## 数学
回文数
加一
阶乘后的零
x的平方根
Pow(x, n)
直线上最多的点数

## 一维动态规划
爬楼梯
打家劫舍
单词拆分
零钱兑换
最长递增子序列

## 多维动态规划
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
