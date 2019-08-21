/**
 * 
 */
package com.github.leetcode.array;

import java.util.Arrays;

/**
 * 189. Rotate Array
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * @author jieshao
 * @since Nov 25, 2015
 *
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2 };
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (k <= 0 || nums == null) {
            return;
        }
        int[] newOne = new int[nums.length];
        System.arraycopy(nums, 0, newOne, 0, nums.length);
        int j = 0;
        for (int i = 0; i < newOne.length; i++) {
            j = i + k;
            if (j >= newOne.length) {
                j = j % newOne.length;
            }
            nums[j] = newOne[i];
        }
    }

}
