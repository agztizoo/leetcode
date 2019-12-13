package com.github.leetcode.array;

/**
 * 33. Search in Rotated Sorted Array
 */
public class SearchInRotateArray {

    public static void main(String[] args) {
        int[] array = new int[] {1,3};
        System.out.println(search(array, 0));
    }

    private static int search(int[] array, int k) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = array.length - 1;
        while (end >= begin) {
            int mid = (end + begin) / 2;
            if (array[mid] == k) {
                return mid;
            }
            if (sorted(array, begin, mid)) {//左有序
                if (array[begin] <= k && array[mid] >= k) {//在左边
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (array[mid] <= k && array[end] >= k) {//在右边
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        //if (end == begin && array[begin] == k) {
        //    return begin;
        //}
        return -1;
    }

    private static boolean sorted(int[] array, int begin, int end) {
        return array[begin] <= array[end];
    }
}
