package com.github.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * @author shaojie
 * @since 2019/4/2
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            Integer index = map.get(x);
            if (index != null && index != i) {
                return new int[] {i, index};
            }
        }
        throw new IllegalArgumentException();
    }
}
