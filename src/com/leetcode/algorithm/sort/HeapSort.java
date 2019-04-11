package com.leetcode.algorithm.sort;

/**
 *
 * @author shaojie
 * @since 2018/1/19
 */
public class HeapSort implements Sortable {

    @Override
    public void sort(int[] array) {
        buildMaxHeap(array, array.length);
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            maxHeapify(array, 0, i);
        }
    }

    /**
     * 建堆
     *
     * @param array
     * @param end
     */
    private void buildMaxHeap(int[] array, int end) {
        for (int i = end; i >= 0; i--) {
            maxHeapify(array, i, end);
        }
    }

    /**
     * 维护最大堆的性质
     *
     * @param array
     * @param idx
     * @param end
     */
    private void maxHeapify(int[] array, int idx, int end) {
        int left = left(idx);
        int right = right(idx);
        int largest = idx;
        if (left < end && array[left] > array[largest]) {
            largest = left;
        }
        if (right < end && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != idx) {
            int exchange = array[largest];
            array[largest] = array[idx];
            array[idx] = exchange;
            maxHeapify(array, largest, end);
        }
    }

    private int parent(int i) {
        return i >>> 1;
    }

    private int left(int i) {
        return right(i) - 1;
    }

    private int right(int i) {
        return (i + 1) << 1;
    }

}
