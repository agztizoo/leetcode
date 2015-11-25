/**
 * ContainsDuplicate2.java
 */
package com.leetcode.oj.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jieshao
 * @date Nov 25, 2015
 */
public class ContainsDuplicate2 {

    public static void main(String[] args) {
        int[] a = new int[] {1, 1};
        System.out.println(containsNearbyDuplicate(a, 1));
    }

    /**
     * Given an array of integers and an integer k, find out whether there are
     * two distinct indices i and j in the array such that nums[i] = nums[j] and
     * the difference between i and j is at most k.
     * 
     * nums[i]和nums[j]之间是否存在相同元素，其中0<j-i<=k
     * 
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                //如果i大于k,那么必须踢掉一个元素，这个元素的位置是i-k，由于i是从0开始，所以是i-k-1
                map.remove(nums[i - k - 1]);
            }
            if (map.put(nums[i], nums[i]) != null) {
                return true;
            }
        }
        return false;
    }

}
