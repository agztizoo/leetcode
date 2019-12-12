package com.github.leetcode.tree;

/**
 *
 * @author shaojie
 * @since 2019/11/21
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return (root == null) || isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        boolean sameLeft = isSymmetric(p.left, q.right);
        boolean sameRight = isSymmetric(p.right, q.left);
        return (p.val == q.val) && sameLeft && sameRight;
    }

}
