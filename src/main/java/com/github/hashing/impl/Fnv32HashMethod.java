package com.github.hashing.impl;

import com.github.hashing.HashMethod;

/**
 *
 * @author shaojie
 * @since 2018/6/21
 */
public class Fnv32HashMethod implements HashMethod {

    @Override
    public Long hash(String input) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < input.length(); i++) { hash = (hash ^ input.charAt(i)) * p; }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return (long)Math.abs(hash);
    }

}
