/**
 * InsertionSort.java
 */
package com.github.algorithm.sort;

/**
 * @author jieshao
 * @date May 22, 2015
 */
public class InsertionSort implements Sortable {

    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > k) {
                array[j + 1] = array[j--];
            }
            array[j + 1] = k;
        }
    }

}
