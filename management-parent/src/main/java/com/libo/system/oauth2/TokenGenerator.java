package com.libo.system.oauth2;

import com.libo.common.exception.ResponseException;

import java.security.MessageDigest;
import java.util.UUID;

public class TokenGenerator {
    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    /**
     *  通过md5算法生成token
     */
    private static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance( "MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] digest = algorithm.digest();
            return toHexString(digest);
        } catch (Exception e) {
            throw new ResponseException("生成Token失败,原因为:{}" + e.getMessage());
        }
    }

    private static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }

//    public static void main(String[] args) {
//        String s = TokenGenerator.generateValue();
//        System.out.println("token="+s);
//    }


}

