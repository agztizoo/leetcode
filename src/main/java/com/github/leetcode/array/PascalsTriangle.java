package com.github.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5, Return
 * 
 * [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 * 
 * 
 * @author jieshao
 * @since Feb 2, 2016
 *
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(generate(6));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(numRows);
        if (numRows <= 0) {
            return result;
        }
        List<Integer> interal = null;
        for (int i = 0; i < numRows; i++) {
            interal = new ArrayList<>(i + 1);
            if (i == 0) {
                interal.add(1);
            } else {
                List<Integer> list2 = result.get(i - 1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0) {
                        interal.add(list2.get(j));
                        continue;
                    }
                    if (j == i) {
                        interal.add(list2.get(j - 1));
                        continue;
                    }
                    interal.add(list2.get(j) + list2.get(j - 1));
                }
            }
            result.add(interal);
        }
        return result;
    }
}
