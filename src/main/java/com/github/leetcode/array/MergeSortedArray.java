/**
 * 
 */
package com.github.leetcode.array;

/**
 * 88. Merge Sorted Array
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * @author jieshao
 * @since Feb 2, 2016
 *
 */
public class MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
        for (int i = m - 1, j = n - 1, k = m + n - 1; k >= 0; k--) {
            if (i >= 0 && (j < 0 || A[i] > B[j])) {
                A[k] = A[i--];
            } else {
                A[k] = B[j--];
            }
        }
    }
}
