package cn.zhangbin.selfstudy.test;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;

public class Demo3 {
    /**
     * 不相邻的最大子序列和
     * @param args
     */
    public static void main(String[] args) {
        int[] arrs = new int[] {3,2,3,4,5};
        System.out.println(subsequence(arrs,arrs.length));
        int[][] a = new int[][] {{1,2,3},{3,2,1},{1,2,4}};
        int[][] b = new int[][] {{3,4,2},{2,1,3},{3,2,2}};
        int[][] result = matrixMultiplication(a,b,3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static long subsequence(int[] array,int n){
        //如果数组长度为0,则直接返回0
        if (n == 0){
            return 0;
        }
        //如果数组长度为1,则判断,若数组中第一个元素不大于0则返回0,否则返回第一个元素
        if (n == 1){
            return Math.max(array[0],0);
        }
        int temp = 0; // 步长为0
        if (n == 2){
            temp = Math.max(array[0],array[1]); // 返回两数中的最大值
            temp = Math.max(0,temp); // 返回最大值和0的比对结果
            return temp; // 返回最大值
        }
        // 当长度大于2时 则代表有子序列, result[i] 代表到第i个数时,不相邻的数据之和
        long[] result = new long[n];
        result[0] = Math.max(0,array[0]); // 到第一个数时
        result[1] = Math.max(result[0],array[1]); // 到第二个数时
        for (int i = 2; i < n; i++) {
            // 到第i个数 下标不相邻 i-1 或者 i-2+i
            result[i] = Math.max(result[i-1], result[i-2] + array[i]);
        }
        return result[n-1];
    }

    /**
     * 矩阵乘法
     * @param a 矩阵1
     * @param b 矩阵2
     * @param n 阶数
     * @return 结果矩阵
     */
    private static int[][] matrixMultiplication(int[][] a,int[][] b,int n){
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += a[i][k] * b[k][j]; //行列元素相乘后相加
                }
            }
        }
        return result;
    }
}
