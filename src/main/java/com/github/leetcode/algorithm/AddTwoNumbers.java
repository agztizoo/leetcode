package com.github.leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2. Add Two Numbers
 *
 * @author shaojie
 * @since 2019/4/2
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node3 = null;
        int carry = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        while (node1 != null || node2 != null) {
            int v3 = (node1 == null ? node2.val : (node2 == null ? node1.val : node1.val + node2.val)) + carry;
            carry = v3 / 10;
            v3 = v3 % 10;
            if (node3 == null) {
                node3 = new ListNode(v3);
                head = node3;
            } else {
                node3.next = new ListNode(v3);
                node3 = node3.next;
            }
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }
        if (carry > 0) {
            node3.next = new ListNode(carry);
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode node1 = buildListNode(new int[]{2, 4, 3});
        ListNode node2 = buildListNode(new int[]{5, 6, 4});
        ListNode node3 = addTwoNumbers(node1, node2);
        System.out.println(list2String(node3));
    }

    public static ListNode buildListNode(int[] array){
        if (array == null || array.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(array[0]);
        ListNode node = head;
        for (int i = 1; i < array.length; i++) {
            node.next = new ListNode(array[i]);
            node = node.next;
        }
        return head;
    }

    public static String list2String(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return Arrays.toString(list.toArray());
    }

}
