// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

public final class bq
{
    private static long Code;
    private static long I;
    private static boolean J;
    private static boolean Z;
    
    public static long Code() {
        if (!u.I.I()) {
            u.I.h();
            u.I.Z(76);
        }
        return bq.I;
    }
    
    public static void Code(final long code) {
        bq.Code = code;
    }
    
    public static void Code(final boolean z) {
        bq.Z = z;
    }
    
    public static void I(final long i) {
        bq.I = i;
    }
    
    public static void I(final boolean j) {
        bq.J = j;
    }
    
    public static boolean I() {
        u.I.h();
        u.I.Z(74);
        return bq.Z;
    }
    
    public static int J() {
        if (!u.I.I()) {
            u.I.h();
            u.I.Z(75);
        }
        final long code = bq.Code;
        final long code2 = Code();
        if (code <= 0L || code2 <= 0L || code2 >= code) {
            return 0;
        }
        return Math.min(99, 100 - (int)(code2 * 100L / code));
    }
    
    public static boolean Z() {
        u.I.h();
        u.I.Z(73);
        return bq.J;
    }
}
