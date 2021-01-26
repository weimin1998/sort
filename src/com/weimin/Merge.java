package com.weimin;

import java.util.Arrays;

/**
 * 归并
 */
public class Merge {
    public static void main(String[] args) {
        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};

        mergeSort(array);

        System.out.println(Arrays.toString(array));


        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random()*80000);
        }

        long start = System.currentTimeMillis();

        mergeSort(arr);
        long end = System.currentTimeMillis();

        System.out.println(end-start); // 30 ms 左右
    }


    private static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1, new int[array.length]);
    }

    private static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 左  分
            mergeSort(array, left, mid, temp);
            // 右 分
            mergeSort(array, mid + 1, right, temp);

            // 合
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 合并
     *
     * @param array
     * @param left  左边有序序列的初始索引
     * @param mid
     * @param right 右边边有序序列的初始索引
     * @param temp  中间数组
     */
    private static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;

        int t = 0; //中间数组的当前索引


        //
        while (l <= mid && r <= right) {
            if (array[l] <= array[r]) {
                temp[t] = array[l];
                t += 1;
                l += 1;
            } else {
                temp[t] = array[r];
                t += 1;
                r += 1;
            }
        }


        // 左边有剩余
        while (l <= mid) {
            temp[t] = array[l];
            t += 1;
            l += 1;
        }

        // 右边有剩余
        while (r <= right) {
            temp[t] = array[r];
            t += 1;
            r += 1;
        }


        // temp 拷贝回去
        t = 0;
        int tempLeft = left;

        //System.out.println("tempLeft="+tempLeft+",right="+right);
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            tempLeft += 1;
            t += 1;
        }
    }
}
