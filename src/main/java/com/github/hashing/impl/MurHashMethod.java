package com.github.hashing.impl;

import com.github.hashing.HashMethod;
import com.google.common.base.Charsets;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

/**
 *
 * @author shaojie
 * @since 2018/6/23
 */
public class MurHashMethod implements HashMethod {

    @Override
    public Long hash(String input) {
        HashFunction hashFunction = Hashing.murmur3_32();

        return (long) hashFunction.newHasher().putString(input, Charsets.UTF_8).hash().asInt();
    }

}
