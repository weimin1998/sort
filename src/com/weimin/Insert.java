package com.weimin;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Insert {
    public static void main(String[] args) {
        int[] array = {9, 3, -1, 10, -2,7,-6};
        sort(array);
        System.out.println(Arrays.toString(array));

        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*80000);
        }

        long start = System.currentTimeMillis();

        sort(arr);
        long end = System.currentTimeMillis();

        System.out.println(end-start); // 955 ms
    }

    private static void sortTest(int[] array){
        // 第一轮
        // 待插入的数
        int insertVal = array[1];
        int insertIndex = 0;

        while (insertIndex>=0 && insertVal<array[insertIndex]){
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;
        }
        // 要插入值的位置 insertIndex+1
        array[insertIndex+1] = insertVal;


        // 第2轮
        // 待插入的数
        insertVal = array[2];
        insertIndex = 1;

        while (insertIndex>=0 && insertVal<array[insertIndex]){
            array[insertIndex+1] = array[insertIndex];
            insertIndex--;
        }
        // 要插入值的位置 insertIndex+1
        array[insertIndex+1] = insertVal;

        // 。。。。。。。
    }

    private static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            // 待插入的数
            int insertVal = array[i];
            int insertIndex = i-1;

            while (insertIndex>=0 && insertVal<array[insertIndex]){
                array[insertIndex+1] = array[insertIndex];
                insertIndex--;
            }
            // 要插入值的位置 insertIndex+1
            array[insertIndex+1] = insertVal;
        }
    }
}
