// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.facebook.ads.internal;

import java.security.MessageDigest;

public class StringUtils
{
    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.length() <= 0;
    }
    
    public static String md5(String string) {
        try {
            final byte[] digest = MessageDigest.getInstance("MD5").digest(string.getBytes("utf-8"));
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digest.length; ++i) {
                sb.append(Integer.toString((digest[i] & 0xFF) + 256, 16).substring(1));
            }
            string = sb.toString();
            return string;
        }
        catch (Exception ex) {
            return null;
        }
    }
}
