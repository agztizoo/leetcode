/**
 * ContainsDuplicate.java
 */
package com.leetcode.oj.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 217. Contains Duplicate
 * 
 * Given an array of integers, find if the array contains any duplicates. Your
 * function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * 
 * @author jieshao
 * @date Nov 25, 2015
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        //        int[] a = new int[] {1, 1, 2, 3, 4, 4, 5, 6, 6, 7};
        int[] a = new int[] {1, 2, 3, 4, 5, 6, 7};
        System.out.println(containsDuplicate(a));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer number : nums) {
            //如果PUT返回不为空，说明存在重复元素
            if (map.put(number, number) != null) {
                return true;
            }
        }
        return false;
    }

}
