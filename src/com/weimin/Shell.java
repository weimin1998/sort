package com.weimin;

import java.util.Arrays;

/**
 * 希尔
 */
public class Shell {
    public static void main(String[] args) {
        //int[] array = {9, 3, -1, 10, -2, 7, -6, 5};
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort2(array);
        System.out.println(Arrays.toString(array));

        /*int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        long start = System.currentTimeMillis();

        sort(arr);
        long end = System.currentTimeMillis();

        System.out.println(end - start); // 10515 ms*/


        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }

        long start = System.currentTimeMillis();

        sort2(arr);
        long end = System.currentTimeMillis();

        System.out.println(end - start); // 20-30 ms
    }

    private static void sortTest(int[] array) {
        // 第一轮
        // 将上面的8个数据分成4组
        for (int i = 4; i < array.length; i++) {
            // 比较每组的值
            for (int j = i - 4; j >= 0; j -= 4) {
                if (array[j] > array[j + 4]) {
                    int temp = array[j];
                    array[j] = array[j + 4];
                    array[j + 4] = temp;
                }
            }
        }

        // 第2轮
        // 将上面的8个数据分成2组
        for (int i = 2; i < array.length; i++) {
            // 比较每组的值
            for (int j = i - 2; j >= 0; j -= 2) {
                if (array[j] > array[j + 2]) {
                    int temp = array[j];
                    array[j] = array[j + 2];
                    array[j + 2] = temp;
                }
            }
        }


        // 第3轮
        // 将上面的8个数据分成1组
        for (int i = 1; i < array.length; i++) {
            // 比较每组的值
            for (int j = i - 1; j >= 0; j -= 1) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }


    }

    // 交换法  网上有网友说是分组+插入？
    private static void sort(int[] array) {
        int temp = 0;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                // 比较每组的值
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
    }


    // 位移法  分组+插入
    // niu pi  !!!
    private static void sort2(int[] array) {

        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];

                while (j - gap >= 0 && temp < array[j - gap]) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;

            }
        }
    }
}
