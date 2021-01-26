package com.weimin;

import java.util.Arrays;

/**
 * 基数排序
 * 空间换时间
 */
public class Base {
    public static void main(String[] args) {

        int[] array = {53, 3, 542, 748, 14, 214};
        sort(array);
        System.out.println(Arrays.toString(array));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        long start = System.currentTimeMillis();

        sort(arr);
        long end = System.currentTimeMillis();

        System.out.println(end - start); // 40 ms 左右
    }

    private static void sortTest(int[] array) {
        // 定义一个二维数组，表示十个桶
        int[][] bucket = new int[10][array.length];

        // 记录每个桶中数据的数量
        int[] nums = new int[10];


        // 第一轮
        for (int i = 0; i < array.length; i++) {
            // 个位的数字
            int digit = array[i] % 10;
            bucket[digit][nums[digit]] = array[i];
            nums[digit]++;
        }


        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = 0; j < nums[i]; j++) {
                    array[index++] = bucket[i][j];
                }
            }
            // 清零
            nums[i] = 0;
        }


        // 第2轮
        for (int i = 0; i < array.length; i++) {
            // 十位的数字
            int digit = array[i] / 10 % 10;
            bucket[digit][nums[digit]] = array[i];
            nums[digit]++;
        }


        index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = 0; j < nums[i]; j++) {
                    array[index++] = bucket[i][j];
                }
            }
            // 清零
            nums[i] = 0;
        }


        // 第3轮
        for (int i = 0; i < array.length; i++) {
            // 百位的数字
            int digit = array[i] / 100 % 10;
            bucket[digit][nums[digit]] = array[i];
            nums[digit]++;
        }


        index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = 0; j < nums[i]; j++) {
                    array[index++] = bucket[i][j];
                }
            }
            // 清零
            nums[i] = 0;
        }
    }

    private static void sort(int[] array) {
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 最大数的长度
        int maxLength = (max + "").length();

        // 定义一个二维数组，表示十个桶
        int[][] bucket = new int[10][array.length];

        // 记录每个桶中数据的数量
        int[] nums = new int[10];

        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {

            for (int i = 0; i < array.length; i++) {
                // 位的数字
                int digit = array[i] / n % 10;
                bucket[digit][nums[digit]] = array[i];
                nums[digit]++;
            }


            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    for (int j = 0; j < nums[i]; j++) {
                        array[index++] = bucket[i][j];
                    }
                }
                // 清零
                nums[i] = 0;
            }
        }


    }
}
