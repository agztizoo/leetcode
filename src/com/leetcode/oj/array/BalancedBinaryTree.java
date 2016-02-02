/**
 * 
 */
package com.leetcode.oj.array;

/**
 * 110. Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author jieshao
 * @since Feb 2, 2016
 *
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int ldepth = getDepth(root.left, 1);
        int rdepth = getDepth(root.right, 1);
        if (Math.abs(ldepth - rdepth) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int getDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int ldepth = getDepth(root.left, depth + 1);
        int rdepth = getDepth(root.right, depth + 1);
        return ldepth > rdepth ? ldepth : rdepth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
