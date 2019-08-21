/**
 * 
 */
package com.github.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * @author jieshao
 * @since Nov 25, 2015
 *
 */
public class PascalsTriangle2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(getRow(6));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> array = new ArrayList<Integer>(rowIndex < 1 ? 1 : rowIndex);
        if (rowIndex < 0) {
            return array;
        }
        for (int i = 0; i <= rowIndex; i++) {
            array.add(0);
            if (i == 0) {
                array.set(i, 1);
                continue;
            }
            for (int j = i; j > 0; j--) {
                if (j == i) {
                    array.set(j, array.get(j - 1));
                    continue;
                }
                array.set(j, (array.get(j - 1) + array.get(j)));
            }
        }
        return array;
    }

}
