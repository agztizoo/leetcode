package com.github.hashing.impl;

import com.github.hashing.HashMethod;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author shaojie
 * @since 2018/6/19
 */
public class KetamaHashMethod implements HashMethod {

    public static final String MD5 = "MD5";

    @Override
    public Long hash(String input) {
        MessageDigest digest = getDigest(MD5);
        digest.update(input.getBytes());
        byte[] bKey = digest.digest();
        long res = ((long) (bKey[3] & 0xFF) << 24)
                | ((long) (bKey[2] & 0xFF) << 16)
                | ((long) (bKey[1] & 0xFF) << 8)
                | (long) (bKey[0] & 0xFF);
        return res;
    }

    private MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (final NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) {
        HashMethod hashing = new KetamaHashMethod();
        System.out.println(hashing.hash("192.168.1.1:12810"));
    }

}
