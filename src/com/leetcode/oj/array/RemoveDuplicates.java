package com.leetcode.oj.array;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 * 
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with
 * constant memory.
 * 
 * For example, Given input array nums = [1,1,2],
 * 
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author jieshao
 * @since Feb 2, 2016
 *
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] a = new int[] { 1, 1, 2, 3, 4, 4, 5, 6, 6, 7 };
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }

    public static int removeDuplicates(int[] A) {
        int cur = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                if (cur == -1) {
                    cur = i + 1;
                }
                continue;
            }
            if (cur != -1) {
                A[cur] = A[i + 1];
                cur++;
            }
        }
        if (cur != -1) {
            int[] B = new int[cur];
            for (int i = 0; i < B.length; i++) {
                B[i] = A[i];
            }
            A = B;
        }
        return A.length;
    }

}
