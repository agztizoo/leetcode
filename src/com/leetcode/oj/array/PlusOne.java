package com.leetcode.oj.array;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] a = new int[] { 9, 9, 9, 9 };
        System.out.println(Arrays.toString(plusOne(a)));
    }

    /**
     * Given a non-negative number represented as an array of digits, plus one
     * to the number.
     * 
     * The digits are stored such that the most significant digit is at the head
     * of the list.
     * 
     * 
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int init = 1;
        int cur = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            cur = digits[i];
            digits[i] = (cur + init) % 10;
            init = (cur + init) / 10;
        }
        if (init > 0) {
            int[] digits2 = new int[digits.length + 1];
            digits2[0] = init;
            System.arraycopy(digits, 0, digits2, 1, digits.length);
            return digits2;
        }
        return digits;
    }

}
