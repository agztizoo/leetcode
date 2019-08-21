package com.github.hashing.impl;

import com.github.hashing.HashMethod;

/**
 *
 * @author shaojie
 * @since 2018/6/23
 */
public class NativeHashMethod implements HashMethod {

    @Override
    public Long hash(String input) {
        return (long)Math.abs(input.hashCode());
    }

}
