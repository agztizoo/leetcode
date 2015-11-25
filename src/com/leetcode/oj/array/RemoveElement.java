/**
 * 
 */
package com.leetcode.oj.array;

/**
 * @author jieshao
 * @since  Nov 25, 2015
 *
 */
public class RemoveElement {

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     * Given an array and a value, remove all instances of that value in place
     * and return the new length.
     * 
     * The order of elements can be changed. It doesn't matter what you leave
     * beyond the new length.
     * 
     * @param A
     * @param elem
     * @return
     */
    public static int removeElement(int[] A, int elem) {
        int index = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == elem) {
                if (index == -1) {
                    index = i;
                }
                continue;
            }
            if (index >= 0) {
                A[index] = A[i];
                index++;
            }
        }
        return index == -1 ? A.length : index;
    }

}
