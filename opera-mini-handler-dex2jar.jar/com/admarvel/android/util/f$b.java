// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.util;

class f$b extends f$a
{
    static final /* synthetic */ boolean g;
    private static final byte[] h;
    private static final byte[] i;
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte[] j;
    private int k;
    private final byte[] l;
    
    static {
        g = !f.class.desiredAssertionStatus();
        h = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        i = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
    }
    
    public f$b(int k, byte[] array) {
        final boolean b = true;
        this.a = array;
        this.d = ((k & 0x1) == 0x0);
        this.e = ((k & 0x2) == 0x0);
        this.f = ((k & 0x4) != 0x0 && b);
        if ((k & 0x8) == 0x0) {
            array = f$b.h;
        }
        else {
            array = f$b.i;
        }
        this.l = array;
        this.j = new byte[2];
        this.c = 0;
        if (this.e) {
            k = 19;
        }
        else {
            k = -1;
        }
        this.k = k;
    }
    
    public boolean a(byte[] j, int n, int n2, final boolean b) {
        final byte[] l = this.l;
        final byte[] a = this.a;
        final int n3 = 0;
        int k = this.k;
        final int n4 = n2 + n;
        Label_0064: {
            switch (this.c) {
                case 0: {
                    final int n5 = -1;
                    n2 = n;
                    n = n5;
                    break Label_0064;
                }
                case 1: {
                    if (n + 2 <= n4) {
                        final byte b2 = this.j[0];
                        n2 = n + 1;
                        n = j[n];
                        final byte b3 = j[n2];
                        this.c = 0;
                        n = ((b2 & 0xFF) << 16 | (n & 0xFF) << 8 | (b3 & 0xFF));
                        ++n2;
                        break Label_0064;
                    }
                    break;
                }
                case 2: {
                    if (n + 1 <= n4) {
                        final byte b4 = this.j[0];
                        final byte b5 = this.j[1];
                        n2 = n + 1;
                        n = j[n];
                        this.c = 0;
                        n = ((b4 & 0xFF) << 16 | (b5 & 0xFF) << 8 | (n & 0xFF));
                        break Label_0064;
                    }
                    break;
                }
            }
            final int n6 = -1;
            n2 = n;
            n = n6;
        }
        if (n != -1) {
            a[0] = l[n >> 18 & 0x3F];
            a[1] = l[n >> 12 & 0x3F];
            a[2] = l[n >> 6 & 0x3F];
            final int n7 = 4;
            a[3] = l[n & 0x3F];
            --k;
            if (k == 0) {
                n = n7;
                if (this.f) {
                    n = 5;
                    a[4] = 13;
                }
                final int n8 = n + 1;
                a[n] = 10;
                k = 19;
                n = n8;
            }
            else {
                n = 4;
            }
        }
        else {
            n = n3;
        }
        while (n2 + 3 <= n4) {
            final int n9 = (j[n2] & 0xFF) << 16 | (j[n2 + 1] & 0xFF) << 8 | (j[n2 + 2] & 0xFF);
            a[n] = l[n9 >> 18 & 0x3F];
            a[n + 1] = l[n9 >> 12 & 0x3F];
            a[n + 2] = l[n9 >> 6 & 0x3F];
            a[n + 3] = l[n9 & 0x3F];
            n2 += 3;
            n += 4;
            --k;
            if (k == 0) {
                if (this.f) {
                    final int n10 = n + 1;
                    a[n] = 13;
                    n = n10;
                }
                final int n11 = n + 1;
                a[n] = 10;
                final int n12 = 19;
                n = n11;
                k = n12;
            }
        }
        int b9;
        if (b) {
            int n18;
            int n20;
            if (n2 - this.c == n4 - 1) {
                int n13;
                byte b6;
                if (this.c > 0) {
                    j = this.j;
                    n13 = 1;
                    b6 = j[0];
                }
                else {
                    b6 = j[n2];
                    ++n2;
                    n13 = 0;
                }
                final int n14 = (b6 & 0xFF) << 4;
                this.c -= n13;
                final int n15 = n + 1;
                a[n] = l[n14 >> 6 & 0x3F];
                final int n16 = n15 + 1;
                a[n15] = l[n14 & 0x3F];
                n = n16;
                if (this.d) {
                    final int n17 = n16 + 1;
                    a[n16] = 61;
                    n = n17 + 1;
                    a[n17] = 61;
                }
                n18 = n;
                if (this.e) {
                    int n19 = n;
                    if (this.f) {
                        a[n] = 13;
                        n19 = n + 1;
                    }
                    a[n19] = 10;
                    n18 = n19 + 1;
                }
                n20 = n2;
            }
            else if (n2 - this.c == n4 - 2) {
                int n21;
                byte b7;
                if (this.c > 1) {
                    final byte[] i = this.j;
                    n21 = 1;
                    b7 = i[0];
                }
                else {
                    b7 = j[n2];
                    ++n2;
                    n21 = 0;
                }
                byte b8;
                if (this.c > 0) {
                    b8 = this.j[n21];
                    ++n21;
                }
                else {
                    b8 = j[n2];
                    ++n2;
                }
                final int n22 = (b8 & 0xFF) << 2 | (b7 & 0xFF) << 10;
                this.c -= n21;
                final int n23 = n + 1;
                a[n] = l[n22 >> 12 & 0x3F];
                final int n24 = n23 + 1;
                a[n23] = l[n22 >> 6 & 0x3F];
                n = n24 + 1;
                a[n24] = l[n22 & 0x3F];
                if (this.d) {
                    final int n25 = n + 1;
                    a[n] = 61;
                    n = n25;
                }
                n18 = n;
                if (this.e) {
                    int n26 = n;
                    if (this.f) {
                        a[n] = 13;
                        n26 = n + 1;
                    }
                    a[n26] = 10;
                    n18 = n26 + 1;
                }
                n20 = n2;
            }
            else {
                n20 = n2;
                n18 = n;
                if (this.e) {
                    n20 = n2;
                    if ((n18 = n) > 0) {
                        n20 = n2;
                        n18 = n;
                        if (k != 19) {
                            if (this.f) {
                                final int n27 = n + 1;
                                a[n] = 13;
                                n = n27;
                            }
                            n18 = n + 1;
                            a[n] = 10;
                            n20 = n2;
                        }
                    }
                }
            }
            if (!f$b.g && this.c != 0) {
                throw new AssertionError();
            }
            b9 = n18;
            if (!f$b.g) {
                b9 = n18;
                if (n20 != n4) {
                    throw new AssertionError();
                }
            }
        }
        else if (n2 == n4 - 1) {
            this.j[this.c++] = j[n2];
            b9 = n;
        }
        else {
            b9 = n;
            if (n2 == n4 - 2) {
                this.j[this.c++] = j[n2];
                this.j[this.c++] = j[n2 + 1];
                b9 = n;
            }
        }
        this.b = b9;
        this.k = k;
        return true;
    }
}
