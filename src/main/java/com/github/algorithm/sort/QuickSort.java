package com.github.algorithm.sort;

/**
 * 
 * @author JayShao
 * @since 2015年5月30日
 * 
 */
public class QuickSort implements Sortable {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int p, int q) {
        if (p < q) {
            int k = patition(array, p, q);
            quickSort(array, p, k - 1);
            quickSort(array, k + 1, q);
        }
    }

    private int patition(int[] array, int p, int q) {
        int k = array[q];
        int i = p - 1;
        for (int j = p; j <= q; j++) {
            if (array[j] < k) {
                int temp = array[j];
                array[j] = array[++i];
                array[i] = temp;
            }
        }
        array[q] = array[++i];
        array[i] = k;
        return i;
    }

}
