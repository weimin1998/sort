package com.weimin;

import java.util.Arrays;

/**
 * 冒泡排序
 * O(n^2)
 *
 */
public class MaoPao {
    public static void main(String[] args) {
        int[] array = {3, 9, -1, 10, -2};
        sort(array);
        System.out.println(Arrays.toString(array));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*80000);
        }

        long start = System.currentTimeMillis();

        sort(arr);
        long end = System.currentTimeMillis();

        System.out.println(end-start); // 14531 ms
    }

    public static void sort(int[] array) {
        // 这个change是优化
        boolean change = false;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    change = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

            if(change){
                // 重置
                change = false;
            }else {
                break;
            }
        }
    }

    public static void sortTest(int[] array) {
        int temp = 0;
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }

        for (int j = 0; j < array.length - 1 - 1; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }

        for (int j = 0; j < array.length - 1 - 2; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }

        for (int j = 0; j < array.length - 1 - 3; j++) {
            if (array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
