// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.graphics.Paint;

final class ap
{
    private static int[] B;
    private static int[] C;
    private static char[] Code;
    private static float[] I;
    private static g J;
    private static int Z;
    
    static {
        ap.Z = -64;
        ap.B = new int[32];
        ap.C = new int[32];
    }
    
    public static int Code(final g g, char c) {
    Label_0174_Outer:
        while (true) {
            final char c2 = '\0';
            final char c3 = '\u0001';
            int i = 0;
            int n;
            int n2;
            float n3;
            final Paint paint;
            byte directionality;
            Label_0347_Outer:Label_0385_Outer:
            while (true) {
            Label_0385:
                while (true) {
                Label_0347:
                    while (true) {
                    Label_0127_Outer:
                        while (true) {
                        Label_0127:
                            while (true) {
                                while (true) {
                                    while (true) {
                                        synchronized (ap.class) {
                                            while (true) {
                                                if (ap.J != g) {
                                                    c = (char)(-1);
                                                }
                                                else {
                                                    i = ap.Z;
                                                    if (c < ap.Z || c >= i + 64) {
                                                        ap.J.g();
                                                        ap.Z = c / '@' * 64;
                                                        for (i = 0; i < 64; ++i) {
                                                            ap.Code[i] = (char)(ap.Z + i);
                                                        }
                                                        n = c / '@' / 32;
                                                        n2 = c / '@' % 32;
                                                        if ((ap.B[n] >> n2 & 0x1) == 0x1) {
                                                            i = 1;
                                                            break Label_0341;
                                                        }
                                                        break Label_0127;
                                                    }
                                                    n3 = ap.I[c % '@'];
                                                    c = c2;
                                                    if (n3 >= 0.0f) {
                                                        if (n3 > 1024.0f) {
                                                            c = '\u0400';
                                                        }
                                                        else if (n3 - (int)n3 > 0.0f) {
                                                            c = (char)((int)n3 + 1);
                                                        }
                                                        else {
                                                            c = (char)n3;
                                                        }
                                                    }
                                                }
                                                return c;
                                                iftrue(Label_0243:)(i >= 64);
                                                while (true) {
                                                    Block_14: {
                                                        break Block_14;
                                                        Label_0243: {
                                                            ap.B[n] |= 1 << n2;
                                                        }
                                                        i = 0;
                                                        break Label_0347;
                                                        ap.C[n] |= 1 << n2;
                                                        i = 1;
                                                        break Label_0347;
                                                        while (true) {
                                                            ap.I[i] = paint.measureText(ap.Code, i, 1);
                                                            ++i;
                                                            break Label_0127;
                                                            iftrue(Label_0394:)((ap.C[n] >> n2 & 0x1) != 0x1);
                                                            i = 1;
                                                            break Label_0385;
                                                            iftrue(Label_0279:)(i >= 64);
                                                            continue Label_0127_Outer;
                                                        }
                                                    }
                                                    directionality = Character.getDirectionality(c + i);
                                                    iftrue(Label_0404:)(directionality != 1 && directionality != 2 && directionality != 6 && directionality != 16 && directionality != 17);
                                                    continue Label_0127_Outer;
                                                }
                                                paint.getTextWidths(ap.Code, 0, 64, ap.I);
                                                continue Label_0174_Outer;
                                            }
                                        }
                                        if (i == '\0') {
                                            continue Label_0385_Outer;
                                        }
                                        break;
                                    }
                                    i = '\0';
                                    if (i == '\0') {
                                        if ('\u0d7f' > c && 2304 < c + '@') {
                                            i = c3;
                                        }
                                        else {
                                            i = '\0';
                                        }
                                        if (i == '\0') {
                                            continue;
                                        }
                                    }
                                    break;
                                }
                                i = '\0';
                                continue Label_0127;
                            }
                            i = '\0';
                            continue Label_0174_Outer;
                        }
                        if (i != '\0') {
                            i = '\u0001';
                            continue Label_0347;
                        }
                        break;
                    }
                    i = '\0';
                    continue Label_0347_Outer;
                    Label_0394: {
                        i = '\0';
                    }
                    continue Label_0385;
                }
                Label_0404: {
                    ++i;
                }
                continue Label_0347_Outer;
            }
        }
    }
    
    public static void Code() {
        synchronized (ap.class) {
            ap.J = null;
            ap.Z = -64;
            ap.Code = null;
            ap.I = null;
        }
    }
    
    public static void Code(final g j) {
        synchronized (ap.class) {
            if (ap.J != j) {
                ap.J = j;
                ap.Z = -64;
                if (ap.Code == null) {
                    ap.Code = new char[64];
                }
                if (ap.I == null) {
                    ap.I = new float[64];
                }
            }
        }
    }
}
