package com.weimin;

import java.util.Arrays;

/**
 * 选择排序
 * O(n^2)
 */
public class Xuanze {
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

        System.out.println(end-start); // 3810 ms
    }

    private static void sortTest(int[] array) {
        // 假定第一个数就是最小的

        // 第一轮
        int minIndex = 0;
        int min = array[minIndex];

        for (int i = 1; i < array.length; i++) {
            // 如果最小的比别人大，重置
            if (min > array[i]) {
                min = array[i];
                minIndex = i;
            }
        }

        array[minIndex]= array[0];
        array[0] = min;



        // 第2轮
        minIndex = 1;
        min = array[minIndex];

        for (int i = 2; i < array.length; i++) {
            // 如果最小的比别人大，重置
            if (min > array[i]) {
                min = array[i];
                minIndex = i;
            }
        }

        array[minIndex]= array[1];
        array[1] = min;

        // 。。。。。。
    }

    private static void sort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            int min = array[i];

            for (int j = i+1; j < array.length; j++) {
                if(min>array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){// 这个if是优化 ，里面的语句必须
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }
}
