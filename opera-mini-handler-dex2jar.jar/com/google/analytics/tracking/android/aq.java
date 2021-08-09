// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.analytics.tracking.android;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import android.text.TextUtils;
import java.util.Locale;

final class aq
{
    static byte[] B(final String s) {
        final byte[] array = new byte[s.length() / 2];
        for (int i = 0; i < array.length; ++i) {
            array[i] = (byte)(Code(s.charAt(i * 2)) << 4 | Code(s.charAt(i * 2 + 1)));
        }
        return array;
    }
    
    private static int Code(final char c) {
        int n2;
        final int n = n2 = c - 48;
        if (n > 9) {
            n2 = n - 7;
        }
        return n2;
    }
    
    static String Code(final String s, final int n) {
        return s + "*" + n;
    }
    
    static String Code(final Locale locale) {
        if (locale != null && !TextUtils.isEmpty((CharSequence)locale.getLanguage())) {
            final StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (!TextUtils.isEmpty((CharSequence)locale.getCountry())) {
                sb.append("-").append(locale.getCountry().toLowerCase());
            }
            return sb.toString();
        }
        return null;
    }
    
    public static Map Code(final String s) {
        final HashMap hashMap = new HashMap();
        final String[] split = s.split("&");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String[] split2 = split[i].split("=");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            }
            else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], null);
            }
        }
        return hashMap;
    }
    
    public static double I(final String s) {
        if (s == null) {
            return 0.0;
        }
        try {
            return Double.parseDouble(s);
        }
        catch (NumberFormatException ex) {
            return 0.0;
        }
    }
    
    public static String J(String decode) {
        if (TextUtils.isEmpty((CharSequence)decode)) {
            return null;
        }
        String s = decode;
        if (decode.contains("?")) {
            s = decode.split("[\\?]")[1];
        }
        while (true) {
            Label_0190: {
                if (!s.contains("%3D")) {
                    break Label_0190;
                }
                try {
                    decode = URLDecoder.decode(s, "UTF-8");
                    final Map code = Code(decode);
                    final String[] array = { "dclid", "utm_source", "gclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "gmob_t" };
                    final StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < array.length; ++i) {
                        if (!TextUtils.isEmpty((CharSequence)code.get(array[i]))) {
                            if (sb.length() > 0) {
                                sb.append("&");
                            }
                            sb.append(array[i]).append("=").append((String)code.get(array[i]));
                        }
                    }
                    return sb.toString();
                }
                catch (UnsupportedEncodingException ex) {
                    return null;
                }
            }
            decode = s;
            if (!s.contains("=")) {
                return null;
            }
            continue;
        }
    }
    
    public static boolean Z(final String s) {
        return Boolean.parseBoolean(s);
    }
}
