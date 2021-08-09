// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class bv
{
    private static final int[] Code;
    private int B;
    private int C;
    private int I;
    private int J;
    private int Z;
    private int a;
    private int b;
    private int c;
    private byte[] d;
    private int e;
    private int[] f;
    private int g;
    private int h;
    
    static {
        Code = cg.Code(cg.J("428a2f9871374491b5c0fbcfe9b5dba53956c25b59f111f1923f82a4ab1c5ed5d807aa9812835b01243185be550c7dc372be5d7480deb1fe9bdc06a7c19bf174e49b69c1efbe47860fc19dc6240ca1cc2de92c6f4a7484aa5cb0a9dc76f988da983e5152a831c66db00327c8bf597fc7c6e00bf3d5a7914706ca63511429296727b70a852e1b21384d2c6dfc53380d13650a7354766a0abb81c2c92e92722c85a2bfe8a1a81a664bc24b8b70c76c51a3d192e819d6990624f40e3585106aa07019a4c1161e376c082748774c34b0bcb5391c0cb34ed8aa4a5b9cca4f682e6ff3748f82ee78a5636f84c878148cc7020890befffaa4506cebbef9a3f7c67178f2"), 0, 256);
    }
    
    public bv() {
        this.d = new byte[4];
        this.f = new int[64];
        this.Code();
    }
    
    private static int Code(final int n, final int n2, final int n3) {
        return ((n >>> 6 | n << 26) ^ (n >>> 11 | n << 21) ^ (n >>> 25 | n << 7)) + ((n & n2) ^ (~n & n3));
    }
    
    private void Code(final byte b) {
        this.d[this.e++] = b;
        if (this.e == this.d.length) {
            this.Code(this.d, 0);
            this.e = 0;
        }
        ++this.h;
    }
    
    private static void Code(final int n, final byte[] array, final int n2) {
        array[n2] = (byte)(n >>> 24);
        array[n2 + 1] = (byte)(n >>> 16);
        array[n2 + 2] = (byte)(n >>> 8);
        array[n2 + 3] = (byte)n;
    }
    
    private void Code(final byte[] array, final int n) {
        this.f[this.g++] = ((array[n] & 0xFF) << 24 | (array[n + 1] & 0xFF) << 16 | (array[n + 2] & 0xFF) << 8 | (array[n + 3] & 0xFF));
        if (this.g == 16) {
            this.I();
        }
    }
    
    private static int I(final int n, final int n2, final int n3) {
        return ((n >>> 2 | n << 30) ^ (n >>> 13 | n << 19) ^ (n >>> 22 | n << 10)) + ((n & n2) ^ (n & n3) ^ (n2 & n3));
    }
    
    private void I() {
        for (int i = 16; i <= 63; ++i) {
            final int[] f = this.f;
            final int n = this.f[i - 2];
            final int n2 = this.f[i - 7];
            final int n3 = this.f[i - 15];
            f[i] = (n >>> 10 ^ ((n >>> 17 | n << 15) ^ (n >>> 19 | n << 13))) + n2 + (n3 >>> 3 ^ ((n3 >>> 7 | n3 << 25) ^ (n3 >>> 18 | n3 << 14))) + this.f[i - 16];
        }
        int j = this.I;
        int z = this.Z;
        int k = this.J;
        int b = this.B;
        int c = this.C;
        int a = this.a;
        int b2 = this.b;
        int c2 = this.c;
        int l = 0;
        int n4 = 0;
        while (l < 8) {
            final int code = Code(c, a, b2);
            final int n5 = bv.Code[n4];
            final int[] f2 = this.f;
            final int n6 = n4 + 1;
            final int n7 = f2[n4] + (code + n5) + c2;
            final int n8 = b + n7;
            final int n9 = n7 + I(j, z, k);
            final int code2 = Code(n8, c, a);
            final int n10 = bv.Code[n6];
            final int[] f3 = this.f;
            final int n11 = n6 + 1;
            final int n12 = b2 + (code2 + n10 + f3[n6]);
            final int n13 = k + n12;
            final int n14 = n12 + I(n9, j, z);
            final int code3 = Code(n13, n8, c);
            final int n15 = bv.Code[n11];
            final int[] f4 = this.f;
            final int n16 = n11 + 1;
            final int n17 = a + (code3 + n15 + f4[n11]);
            final int n18 = z + n17;
            final int n19 = n17 + I(n14, n9, j);
            final int code4 = Code(n18, n13, n8);
            final int n20 = bv.Code[n16];
            final int[] f5 = this.f;
            final int n21 = n16 + 1;
            final int n22 = c + (code4 + n20 + f5[n16]);
            final int n23 = j + n22;
            final int n24 = n22 + I(n19, n14, n9);
            final int code5 = Code(n23, n18, n13);
            final int n25 = bv.Code[n21];
            final int[] f6 = this.f;
            final int n26 = n21 + 1;
            final int n27 = code5 + n25 + f6[n21] + n8;
            c2 = n9 + n27;
            b = n27 + I(n24, n19, n14);
            final int code6 = Code(c2, n23, n18);
            final int n28 = bv.Code[n26];
            final int[] f7 = this.f;
            final int n29 = n26 + 1;
            final int n30 = code6 + n28 + f7[n26] + n13;
            b2 = n14 + n30;
            k = I(b, n24, n19) + n30;
            final int code7 = Code(b2, c2, n23);
            final int n31 = bv.Code[n29];
            final int[] f8 = this.f;
            final int n32 = n29 + 1;
            final int n33 = code7 + n31 + f8[n29] + n18;
            a = n19 + n33;
            z = I(k, b, n24) + n33;
            final int code8 = Code(a, b2, c2);
            final int n34 = bv.Code[n32];
            final int[] f9 = this.f;
            n4 = n32 + 1;
            final int n35 = n23 + (n34 + code8 + f9[n32]);
            c = n24 + n35;
            j = n35 + I(z, k, b);
            ++l;
        }
        this.I += j;
        this.Z += z;
        this.J += k;
        this.B += b;
        this.C += c;
        this.a += a;
        this.b += b2;
        this.c += c2;
        this.g = 0;
        for (int n36 = 0; n36 < 16; ++n36) {
            this.f[n36] = 0;
        }
    }
    
    public final void Code() {
        this.h = 0;
        this.e = 0;
        for (int i = 0; i < this.d.length; ++i) {
            this.d[i] = 0;
        }
        this.g = 0;
        for (int j = 0; j < this.f.length; ++j) {
            this.f[j] = 0;
        }
        this.I = 1779033703;
        this.Z = -1150833019;
        this.J = 1013904242;
        this.B = -1521486534;
        this.C = 1359893119;
        this.a = -1694144372;
        this.b = 528734635;
        this.c = 1541459225;
    }
    
    public final void Code(final int n) {
        this.Code((byte)(n >>> 24));
        this.Code((byte)(n >>> 16));
        this.Code((byte)(n >>> 8));
        this.Code((byte)n);
    }
    
    public final void Code(final byte[] array) {
        final int h = this.h;
        this.Code((byte)(-128));
        while (this.e != 0) {
            this.Code((byte)0);
        }
        if (this.g > 14) {
            this.I();
        }
        this.f[15] = h * 8;
        this.I();
        Code(this.I, array, 0);
        Code(this.Z, array, 4);
        Code(this.J, array, 8);
        Code(this.B, array, 12);
        Code(this.C, array, 16);
        Code(this.a, array, 20);
        Code(this.b, array, 24);
        Code(this.c, array, 28);
        this.Code();
    }
    
    public final void Code(final byte[] array, int n, int n2) {
        int n3 = n2;
        int n4 = n;
        while (true) {
            n = n4;
            n2 = n3;
            if (this.e == 0) {
                break;
            }
            n = n4;
            if ((n2 = n3) <= 0) {
                break;
            }
            this.Code(array[n4]);
            ++n4;
            --n3;
        }
        int n5;
        int i;
        while (true) {
            n5 = n;
            if ((i = n2) <= this.d.length) {
                break;
            }
            this.Code(array, n);
            n += this.d.length;
            n2 -= this.d.length;
            this.h += this.d.length;
        }
        while (i > 0) {
            this.Code(array[n5]);
            ++n5;
            --i;
        }
    }
}
