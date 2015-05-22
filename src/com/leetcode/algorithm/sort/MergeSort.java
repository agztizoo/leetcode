/**
 * MergeSort.java
 */
package com.leetcode.algorithm.sort;

/**
 * @author jieshao
 * @date May 22, 2015
 */
public class MergeSort implements Sortable {

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int begin, int end) {
        if (end > begin) {
            int m = (begin + end) / 2;
            mergeSort(array, begin, m);
            mergeSort(array, m + 1, end);
            merge(array, begin, m, end);
        }
    }

    private void merge(int[] array, int p, int q, int r) {
        int m = q - p + 1;
        int n = r - q;
        int[] L = new int[m];
        int[] R = new int[n];
        for (int i = 0; i < m; i++) {
            L[i] = array[p + i];
        }
        for (int i = 0; i < n; i++) {
            R[i] = array[q + i + 1];
        }
        int a = 0;
        int b = 0;
        for (int i = p; i <= r; i++) {
            if (a >= m) {
                array[i] = R[b++];
            } else if (b >= n) {
                array[i] = L[a++];
            } else if (L[a] > R[b]) {
                array[i] = R[b++];
            } else {
                array[i] = L[a++];
            }
        }
    }

}
