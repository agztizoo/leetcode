package com.github.leetcode.tree;

/**
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 *
 * @author shaojie
 * @since 2019/11/21
 */
public class TheSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || (p.val != q.val)) {
            return false;
        }
        boolean sameLeft = isSameTree(p.left, q.left);
        boolean sameRight = isSameTree(p.right, q.right);

        return sameLeft && sameRight;
    }

}
