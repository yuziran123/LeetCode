package leetcode.editor.util;

/**
 * ClassName:Print
 * Description:
 * Author:yu
 * Date:2024/9/8 10:00
 */
public class Print {
    /**
     * 描述:打印2维数组
     */
    public void print2DArrays(int[][] nums) {
        for (int[] row : nums) {
            System.out.print("[");
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("], ");
        }
        System.out.println();
    }
}
