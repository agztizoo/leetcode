package com.github.leetcode.tree;

import java.util.Arrays;

/**
 *
 * @author shaojie
 * @since 2019/11/22
 */
public class ArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null  || nums.length == 0) {
            return  null;
        }
        int mid = nums.length/2;
        TreeNode root =  new TreeNode(nums[mid]);
        buildChild(root, Arrays.copyOfRange(nums, 0, mid), Arrays.copyOfRange(nums, mid + 1, nums.length));
        return root;
    }

    public void buildChild(TreeNode parent, int[] left, int[] right) {
        if (left.length > 0) {
            int mid = left.length/2;
            TreeNode node =  new TreeNode(left[mid]);
            parent.left = node;
            buildChild(node, Arrays.copyOfRange(left, 0, mid), Arrays.copyOfRange(left, mid + 1, left.length));
        }
        if (right.length > 0) {
            int mid = right.length/2;
            TreeNode node =  new TreeNode(right[mid]);
            parent.right = node;
            buildChild(node, Arrays.copyOfRange(right, 0, mid), Arrays.copyOfRange(right, mid + 1, right.length));
        }
    }

}
