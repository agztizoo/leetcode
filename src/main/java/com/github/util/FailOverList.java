package com.github.util;

import java.util.LinkedList;

public class FailOverList<E> {

    private static final int INIT_SIZE = 16;

    private static final int DEFAULT_LENGTH = 256;

    private final int length;

    private int cursor = 1;

    private LinkedList<E> data;

    public FailOverList() {
        this(DEFAULT_LENGTH);
    }

    public FailOverList(int length) {
        if (length <= 0) {
            this.length = DEFAULT_LENGTH;
        } else if (isPowerOfTwo(length)) {
            this.length = length;
        } else {
            int i = INIT_SIZE;
            while (true) {
                if (i >= length) {
                    this.length = i;
                    break;
                }
                i *= 2;
            }
        }
        data = new LinkedList<>();
    }

    public boolean addLast(E object) {
        if (data.size() >= length) {
            compress();
        }
        data.addLast(object);
        return true;
    }

    private void compress() {
        if (cursor >= data.size()) {
            cursor = 1;
        }
        data.remove(cursor++);
    }

    public boolean contains(E object) {
        return data.contains(object);
    }

    public E getFirst() {
        return data.getFirst();
    }

    public void removeFirst() {
        data.removeFirst();
    }

    public int size() {
        return data.size();
    }

    private boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }

}
