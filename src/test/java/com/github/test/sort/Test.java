/**
 * Test.java
 */
package com.github.test.sort;

import com.github.algorithm.sort.Sortable;

import java.util.Arrays;

/**
 * @author jieshao
 * @date May 22, 2015
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[] { 7, 2, 0, 8, 12, 9, 3, 2, 17, 22, 15, 18, 26, 1, 32 };
        Sortable sort = new com.github.algorithm.sort.HeapSort();
        sort.sort(array);
        System.out.println(Arrays.toString(array));
    }

}
