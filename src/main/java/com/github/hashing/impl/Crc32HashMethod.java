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
public class Crc32HashMethod implements HashMethod {

    @Override
    public Long hash(String input) {
        HashFunction hashFunction = Hashing.crc32();
        return (long) hashFunction.newHasher().putString(input, Charsets.UTF_8).hash().asInt();
    }

}
