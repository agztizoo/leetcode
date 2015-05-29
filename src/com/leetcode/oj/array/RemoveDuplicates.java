package com.leetcode.oj.array;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] a = new int[] { 1, 1, 2, 3, 4, 4, 5, 6, 6, 7 };
        System.out.println(removeDuplicates(a));
        System.out.println(Arrays.toString(a));
    }

    public static int removeDuplicates(int[] A) {
        int cur = -1;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == A[i + 1]) {
                if (cur == -1) {
                    cur = i + 1;
                }
                continue;
            }
            if (cur != -1) {
                A[cur] = A[i + 1];
                cur++;
            }
        }
        if (cur != -1) {
            int[] B = new int[cur];
            for (int i = 0; i < B.length; i++) {
                B[i] = A[i];
            }
            A = B;
        }
        return A.length;
    }

}
