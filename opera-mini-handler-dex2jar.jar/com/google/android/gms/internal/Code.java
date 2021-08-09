// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.google.android.gms.internal;

import java.security.NoSuchAlgorithmException;
import java.math.BigInteger;
import java.util.Locale;
import java.security.MessageDigest;
import android.os.Looper;
import android.os.Handler;

public final class Code
{
    static {
        new Handler(Looper.getMainLooper());
    }
    
    public static String Code(final String s) {
        int i = 0;
        while (i < 2) {
            try {
                final MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(s.getBytes());
                return String.format(Locale.US, "%032X", new BigInteger(1, instance.digest()));
            }
            catch (NoSuchAlgorithmException ex) {
                ++i;
                continue;
            }
            break;
        }
        return null;
    }
}
