package com.github.algorithm.sort;

/**
 * 
 * @author JayShao
 * @since 2015年5月30日
 * 
 */
public class BubbleSort implements Sortable {

    @Override
    public void sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

}
