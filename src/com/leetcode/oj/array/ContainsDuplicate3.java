/**
 * ContainsDuplicate3.java
 */
package com.leetcode.oj.array;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 * 
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * nums[i]到nums[j]中是否存在这样的元素:nums[j]-nums[i]<t,0<j-i<k
 * 
 * @author jieshao
 * @date Nov 25, 2015
 */
public class ContainsDuplicate3 {

    public static void main(String[] args) {
        int[] a = new int[] {-1,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(a, 1, 2147483647));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            int number = nums[i];
            Integer bigger = set.ceiling(number);
            Integer less = set.floor(number);
            if ((bigger != null && bigger.longValue() - number <= t) || (less != null && number - less.longValue() <= t)){
                return true;
            }
            set.add(number);
        }
        return false;
    }

}
