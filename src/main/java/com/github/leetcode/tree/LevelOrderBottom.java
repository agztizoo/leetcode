package com.github.leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author shaojie
 * @since 2019/11/21
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(root.val));
        List<TreeNode> childs = getChilds(root);
        while (childs.size() > 0) {
            List<Integer> subList = new ArrayList<>(childs.size());
            List<TreeNode> subChilds = new ArrayList<>(childs.size() * 2);
            for (TreeNode child : childs) {
                if (child != null) {
                    subList.add(child.val);
                    subChilds.addAll(getChilds(child));
                }
            }
            if  (subList.size() > 0) {
                array.add(subList);
            }
            childs = subChilds;
        }
        Collections.reverse(array);
        return array;
    }

    private List<TreeNode> getChilds(TreeNode node) {
        return Arrays.asList(node.left, node.right);
    }

}
