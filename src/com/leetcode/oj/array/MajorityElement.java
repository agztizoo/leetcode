/*
 * MajorityElement.java
 */
package com.leetcode.oj.array;

/**
 * 
 * @author JayShao
 * @since 2015年2月2日
 * 
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] array = new int[] { 2, 4, 2, 3, 2, 5, 6, 2, 2 };
        System.out.println(majorityElement(array));
    }

    /**
     * Given an array of size n, find the majority element. The majority element
     * is the element that appears more than ⌊ n/2 ⌋ times.
     * 
     * You may assume that the array is non-empty and the majority element
     * always exist in the array.
     * 
     * @param num
     * @return
     */
    public static int majorityElement(int[] num) {
        int major = -1;
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            if (num[i] == major) {
                count++;
            } else if (count > 0) {
                count--;
            } else {
                major = num[i];
                count = 1;
            }
        }
        return major;
    }
}
