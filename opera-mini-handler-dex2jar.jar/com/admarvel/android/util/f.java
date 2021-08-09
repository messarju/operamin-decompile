// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

import java.io.UnsupportedEncodingException;

public class f
{
    static final /* synthetic */ boolean a;
    
    static {
        a = !f.class.desiredAssertionStatus();
    }
    
    private f() {
    }
    
    public static String a(final byte[] array, final int n) {
        try {
            return new String(b(array, n), "US-ASCII");
        }
        catch (UnsupportedEncodingException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public static byte[] a(final byte[] array, final int n, final int n2, int n3) {
        final f$b f$b = new f$b(n3, null);
        final int n4 = n2 / 3 * 4;
        if (f$b.d) {
            n3 = n4;
            if (n2 % 3 > 0) {
                n3 = n4 + 4;
            }
        }
        else {
            n3 = n4;
            switch (n2 % 3) {
                case 2: {
                    n3 = n4 + 3;
                    break;
                }
                case 1: {
                    n3 = n4 + 2;
                }
                case 0: {
                    break;
                }
                default: {
                    n3 = n4;
                    break;
                }
            }
        }
        int n5 = n3;
        if (f$b.e) {
            n5 = n3;
            if (n2 > 0) {
                final int n6 = (n2 - 1) / 57;
                int n7;
                if (f$b.f) {
                    n7 = 2;
                }
                else {
                    n7 = 1;
                }
                n5 = n3 + n7 * (n6 + 1);
            }
        }
        f$b.a = new byte[n5];
        f$b.a(array, n, n2, true);
        if (!f.a && f$b.b != n5) {
            throw new AssertionError();
        }
        return f$b.a;
    }
    
    public static byte[] b(final byte[] array, final int n) {
        return a(array, 0, array.length, n);
    }
}
