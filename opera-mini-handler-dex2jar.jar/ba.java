// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class ba
{
    private az Code(final byte[] array, int i, int j, int n, int n2, int n3, final az[] array2, final boolean b) {
        az az;
        if (n == 0 || n2 == 0 || n3 == 0) {
            az = null;
        }
        else {
            final az az2 = null;
            az az3 = null;
            Label_0185: {
                if (cg.v && I(array, i, j)) {
                    final ch code = this.Code();
                    if (!code.Code(array, i, j)) {
                        return null;
                    }
                    final int code2 = code.Code();
                    final int k = code.I();
                    if (n3 == 256) {
                        j = k;
                        i = code2;
                    }
                    else if (n3 >= 0) {
                        j = k * n3 * 256 + 65535 >> 16;
                        i = Math.max(1, code2 * j / k);
                    }
                    else {
                        j = n2;
                        i = n;
                    }
                    if (k != j || code2 != i) {
                        if (u.Code.t()) {
                            return null;
                        }
                        n = 0;
                        if (j > k || i > code2) {
                            n = 1;
                        }
                        az3 = this.Code(null, code2, k, i, j, n);
                    }
                    else {
                        az3 = this.Code(null, code2, k, false, b);
                    }
                }
                else if (array[i] == 82 || array[i] == 67 || array[i] == 88) {
                    if (array[i] == 88) {
                        n = (array[i + 1] << 3 | (array[i + 2] >>> 5 & 0x7));
                        n2 = ((array[i + 2] & 0x1F) << 6 | (array[i + 3] >>> 2 & 0x3F));
                    }
                    else {
                        n = array[i + 1];
                        n2 = array[i + 2];
                    }
                    final int[] array3 = new int[n * n2];
                    if (array[i] == 82) {
                        for (i += 3, j = 0; j < n * n2; ++j, i += 4) {
                            array3[j] = ((array[i] & 0xFF) << 24) + ((array[i + 1] & 0xFF) << 16) + ((array[i + 2] & 0xFF) << 8) + (array[i + 3] & 0xFF);
                        }
                    }
                    else if (array[i] == 67) {
                        final byte[] array4 = new byte[n * n2 * 2];
                        final bd x = u.Code.x();
                        x.Code(array4);
                        x.setInput(array, i + 3, j - 3);
                        x.read(null, 0, array4.length);
                        x.end();
                        byte b2;
                        byte b3;
                        for (i = 0; i < n * n2 * 2; ++i, array3[i >> 1] = (((j & 0xF0) >>> 4 | (n3 & 0xF0)) << 24) + (((b2 & 0xF) << 4 | (b3 & 0xF)) << 16) + (((array4[i] & 0xF0) >>> 4 | (array4[i] & 0xF0)) << 8) + ((array4[i] & 0xF) << 4 | (array4[i] & 0xF)), ++i) {
                            j = array4[i];
                            n3 = array4[i];
                            b2 = array4[i];
                            b3 = array4[i];
                        }
                    }
                    else {
                        final byte[] array5 = new byte[n * n2 * 3];
                        final bd x2 = u.Code.x();
                        x2.Code(array5);
                        x2.setInput(array, i + 4, j - 4);
                        x2.read(null, 0, array5.length);
                        x2.end();
                        byte b4;
                        byte b5;
                        int n4;
                        int n5;
                        for (i = 0; i < n * n2 * 3; i = ((b4 << 6 & 0xF0) | (array5[n3] >> 2 & 0x3C)), b5 = array5[n3], ++n3, n4 = ((b5 << 4 & 0xF0) | (array5[n3] >> 4 & 0xC)), n5 = (array5[n3] & 0x3F) << 2, array3[n3 / 3] = ((j | j >> 6) << 24) + ((i | i >> 6) << 16) + ((n4 | n4 >> 6) << 8) + (n5 | n5 >> 6), i = n3 + 1) {
                            j = (array5[i] & 0xFC);
                            b4 = array5[i];
                            n3 = i + 1;
                        }
                    }
                    az3 = this.Code(array3, n, n2, true, b);
                }
                else if (cg.s || array[i] == -119) {
                    final int n6 = 0;
                    final az code3 = this.Code(array, i, j, b);
                    if (n3 == 256) {
                        j = code3.Z();
                        i = code3.I();
                    }
                    else if (n3 >= 0) {
                        j = code3.Z() * n3 * 256 + 65535 >> 16;
                        i = Math.max(1, code3.I() * j / code3.Z());
                    }
                    else {
                        j = n2;
                        i = n;
                    }
                    if (code3.Z() == j) {
                        az3 = code3;
                        if (code3.I() == i) {
                            break Label_0185;
                        }
                    }
                    if (array2 != null) {
                        array2[0] = code3;
                    }
                    if (u.Code.t()) {
                        return null;
                    }
                    Label_1013: {
                        if (j <= code3.Z()) {
                            n = n6;
                            if (i <= code3.I()) {
                                break Label_1013;
                            }
                        }
                        n = 1;
                    }
                    az3 = code3.Code(0, 0, code3.I(), code3.Z(), i, j, 0, 0, 0, 0, n, false);
                }
                else {
                    int max;
                    if ((max = n3) == -1) {
                        cg.Code(array, i, j, new int[3]);
                        n3 = cg.f();
                        final int g = cg.g();
                        if (n3 <= 0) {
                            return null;
                        }
                        max = Math.max(Math.min(256, n * 256 / n3), Math.min(256, n2 * 256 / g));
                    }
                    final be be = new be();
                    if (max == 256) {
                        if (be.Code(array, i, j, 0, false) == 0 && be.Code != 0 && be.I != 0) {
                            if (be.Code < n || be.I < n2) {
                                az3 = this.Code(be.Z, be.Code, be.I, n, n2, 1);
                            }
                            else {
                                az3 = this.Code(be.Z, be.Code, be.I, false, b);
                            }
                        }
                        else {
                            az3 = null;
                        }
                    }
                    else {
                        if (u.Code.t()) {
                            return null;
                        }
                        n3 = be.Code(array, i, j, 0, true);
                        final int n7 = (0xFFFF0000 & n3) >> 16;
                        final int n8 = n3 & 0xFFFF;
                        for (n3 = 3; 256 >> n3 <= max; --n3) {}
                        if (n7 >> n3 == 0 || n8 >> n3 == 0) {
                            return null;
                        }
                        az code4 = az2;
                        if (be.Code(array, i, j, n3, false) == 0) {
                            if (n == -1 || n2 == -1) {
                                j = n8 * max * 256 + 65535 >> 16;
                                i = n7 * max * 256 + 65535 >> 16;
                            }
                            else {
                                j = n2;
                                i = n;
                            }
                            n = 0;
                            if (be.Code < i || be.I < j) {
                                n = 1;
                            }
                            code4 = this.Code(be.Z, be.Code, be.I, i, j, n);
                        }
                        az3 = code4;
                    }
                }
            }
            if ((az = az3) != null) {
                az = az3;
                if (az3.Z() == 0) {
                    throw new OutOfMemoryError("");
                }
            }
        }
        return az;
    }
    
    private static void Code(final int[] array, int i, int j, int n, int n2, final int n3, final int[] array2, int k, int n4, int n5, final int n6, final int n7, int min, final boolean b) {
        if (n != 0 && n2 != 0 && n5 != 0 && n6 != 0) {
            if (n == n5 && n2 == n6) {
                Code(array, i, j, n3, array2, k, n4, n7, n, n2);
                return;
            }
            final int n8 = i + j * n3;
            k += n4 * n7;
            if (n2 == 2 && n6 >= 2 && n == n5) {
                i = k;
                int n9;
                int n10;
                int n11;
                int n12;
                int n13;
                for (j = n8; j < n8 + n; ++j) {
                    k = array[j];
                    n2 = array[j + n3];
                    n9 = (k >> 8 & 0xFF0000);
                    min = (k & 0xFF0000);
                    n5 = (0xFF0000 & k << 8);
                    n4 = (0xFF0000 & k << 16);
                    n10 = ((n2 >> 8 & 0xFF0000) - n9) / (n6 - 1);
                    n11 = ((0xFF0000 & n2) - min) / (n6 - 1);
                    n12 = ((n2 << 8 & 0xFF0000) - n5) / (n6 - 1);
                    n13 = ((n2 << 16 & 0xFF0000) - n4) / (n6 - 1);
                    for (k = 0, n2 = i; k < n6; ++k, n2 += n7) {
                        array2[n2] = ((0xFF0000 & n9) << 8 | (0xFF0000 & min) | (0xFF0000 & n5) >> 8 | n4 >> 16);
                        n9 += n10;
                        min += n11;
                        n5 += n12;
                        n4 += n13;
                    }
                    ++i;
                }
            }
            else {
                final int n14 = n * 256 / n5;
                final int n15 = n2 * 256 / n6;
                if (n14 > 512 || n15 > 512) {
                    i = 0;
                }
                else {
                    i = min;
                }
                n4 = n - 1;
                --n2;
                if (n4 == 0 || n2 == 0 || n5 == 1 || n6 == 1) {
                    i = 0;
                }
                if (i == 1) {
                    int n16;
                    int n17;
                    int n18;
                    int n19;
                    int min2;
                    int n20;
                    int n21;
                    int n22;
                    int n23;
                    for (i = 0; i < n6; ++i) {
                        j = (i * n2 << 8) / (n6 - 1);
                        min = (j & 0xFF);
                        n16 = j >>> 8;
                        for (j = 0; j < n5; ++j) {
                            n = (j * n4 << 8) / (n5 - 1);
                            n17 = (n & 0xFF);
                            n18 = n >>> 8;
                            n19 = n7 * i + k + j;
                            n = Math.min(n18 + 1, n4);
                            min2 = Math.min(n16 + 1, n2);
                            n20 = array[n3 * n16 + n8 + n18];
                            n21 = array[n3 * n16 + n8 + n];
                            n22 = array[n18 + (n3 * min2 + n8)];
                            n23 = array[n3 * min2 + n8 + n];
                            if (b) {
                                n = (n20 >>> 24) * (256 - n17) * (256 - min) + (n21 >>> 24) * n17 * (256 - min) + (n22 >>> 24) * (256 - n17) * min + (n23 >>> 24) * n17 * min >>> 16 << 24;
                            }
                            else {
                                n = 0;
                            }
                            array2[n19] = n + ((n20 >> 16 & 0xFF) * (256 - n17) * (256 - min) + (n21 >> 16 & 0xFF) * n17 * (256 - min) + (n22 >> 16 & 0xFF) * (256 - n17) * min + (n23 >> 16 & 0xFF) * n17 * min >>> 16 << 16) + ((n20 >> 8 & 0xFF) * (256 - n17) * (256 - min) + (n21 >> 8 & 0xFF) * n17 * (256 - min) + (n22 >> 8 & 0xFF) * (256 - n17) * min + (n23 >> 8 & 0xFF) * n17 * min >>> 16 << 8) + (n17 * (n23 & 0xFF) * min + ((n20 & 0xFF) * (256 - n17) * (256 - min) + (n21 & 0xFF) * n17 * (256 - min) + (n22 & 0xFF) * (256 - n17) * min) >>> 16);
                            if (!b) {
                                array2[n19] |= 0xFF000000;
                            }
                        }
                    }
                }
                else {
                    int n24;
                    for (i = 0; i < n6; ++i) {
                        n = Math.min(i * n15 >>> 8, n2);
                        for (j = 0; j < n5; ++j) {
                            min = Math.min(j * n14 >>> 8, n4);
                            n24 = n7 * i + k + j;
                            array2[n24] = array[min + (n3 * n + n8)];
                            if (!b) {
                                array2[n24] |= 0xFF000000;
                            }
                        }
                    }
                }
            }
        }
    }
    
    private static void Code(final int[] array, final int n, final int n2, final int n3, final int[] array2, final int n4, final int n5, final int n6, final int n7, final int n8) {
        if (n7 != 0) {
            for (int i = 0; i < n8; ++i) {
                System.arraycopy(array, (n2 + i) * n3 + n, array2, (n5 + i) * n6 + n4, n7);
            }
        }
    }
    
    public static int[] Code(final int[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, int n9, final boolean b) {
        if (n9 == 2) {
            n9 = 1;
        }
        final int[] array2 = new int[n3 * n4];
        Code(array, n5, 0, n - n5 - n7, n6, n, array2, n5, 0, n3 - n5 - n7, n6, n3, n9, b);
        Code(array, n5, n6, n - n5 - n7, n2 - n6 - n8, n, array2, n5, n6, n3 - n5 - n7, n4 - n6 - n8, n3, n9, b);
        Code(array, n5, n2 - n8, n - n5 - n7, n8, n, array2, n5, n4 - n8, n3 - n5 - n7, n8, n3, n9, b);
        Code(array, 0, n6, n5, n2 - n6 - n8, n, array2, 0, n6, n5, n4 - n6 - n8, n3, n9, b);
        Code(array, n - n7, n6, n7, n2 - n6 - n8, n, array2, n3 - n7, n6, n7, n4 - n6 - n8, n3, n9, b);
        Code(array, 0, 0, n, array2, 0, 0, n3, n5, n6);
        Code(array, 0, n2 - n8, n, array2, 0, n4 - n8, n3, n5, n8);
        Code(array, n - n7, 0, n, array2, n3 - n7, 0, n3, n7, n6);
        Code(array, n - n7, n2 - n8, n, array2, n3 - n7, n4 - n8, n3, n7, n8);
        return array2;
    }
    
    protected static boolean I(final byte[] array, final int n, final int n2) {
        return n2 >= 20 && array[n] == 82 && array[n + 1] == 73 && array[n + 2] == 70 && array[n + 3] == 70 && array[n + 8] == 87 && array[n + 9] == 69 && array[n + 10] == 66 && array[n + 11] == 80;
    }
    
    public abstract az Code(final int p0, final int p1);
    
    public final az Code(final byte[] array, final int n, final int n2, final int n3, final int n4, final az[] array2) {
        return this.Code(array, n, n2, n3, n4, -1, array2, false);
    }
    
    public final az Code(final byte[] array, final int n, final int n2, final int n3, final az[] array2, final boolean b) {
        return this.Code(array, n, n2, -1, -1, n3, array2, b);
    }
    
    protected abstract az Code(final byte[] p0, final int p1, final int p2, final boolean p3);
    
    public final az Code(final byte[] array, final int n, final boolean b) {
        return this.Code(array, 0, n, 256, null, b);
    }
    
    public az Code(int[] code, final int n, final int n2, final int n3, final int n4, final int n5) {
        code = Code(code, n, n2, n3, n4, 0, 0, 0, 0, n5, false);
        return this.Code(code, code.length / n4, n4, true, true);
    }
    
    public abstract az Code(final int[] p0, final int p1, final int p2, final boolean p3, final boolean p4);
    
    protected ch Code() {
        return null;
    }
    
    public abstract Object Code(final byte[] p0, final int p1, final int p2);
}
