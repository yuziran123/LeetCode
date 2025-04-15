package leetcode.editor.test;

import java.util.Arrays;
import java.util.Collections;

public class ArraysSort {
    public static void main(String[] args) {
        int[] nums = {5, 2, 9, 1, 5};
        // 实现数组的逆序排序
        nums = Arrays.stream(nums)           // 转为 IntStream
                .boxed()                 // 转为 Stream<Integer>
                .sorted(Collections.reverseOrder()) // 降序排序
                .mapToInt(Integer::intValue) // 转回 IntStream
                .toArray();              // 转为 int[]

        // 输出排序后的数组
        System.out.println(Arrays.toString(nums)); // [9, 5, 5, 2, 1]
    }
}