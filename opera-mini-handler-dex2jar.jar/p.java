import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.DataOutputStream;
import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class p
{
    private RuntimeException B;
    private int C;
    public byte[] Code;
    public int[] I;
    private boolean J;
    private long Z;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    
    public p(final s s) {
        this.J = false;
        this.B = new RuntimeException();
        Code(this, s);
    }
    
    private native void Code(final int p0, final int[] p1);
    
    private static native void Code(final p p0, final s p1);
    
    private native void Code(final byte[] p0, final int p1, final int p2, final int p3, final int p4);
    
    private native void Code(final byte[] p0, final int p1, final byte[] p2, final int p3, final boolean p4);
    
    private native void Code(final int[] p0, final int p1, final int p2, final int p3, final int p4);
    
    private native void F(final int p0);
    
    private native void I(final int[] p0, final int p1, final int p2, final int p3, final int p4);
    
    private native int Z(final byte[] p0, final int p1, final int p2);
    
    private native int Z(final int[] p0, final int p1, final int p2);
    
    private native int a(final int p0, final int p1);
    
    private native int[] a(final int p0, final int p1, final int p2);
    
    private native byte[] b(final int p0, final int p1, final int p2);
    
    public static void i() {
    }
    
    public static void k() {
    }
    
    public static int r() {
        throw new RuntimeException("TODO");
    }
    
    public static void w() {
    }
    
    private native void y();
    
    public native void A(final int p0);
    
    public final int B() {
        return this.f;
    }
    
    public native int B(final int p0, final int p1);
    
    public final void B(final int f) {
        this.f = f;
    }
    
    public native void B(final int p0, final int p1, final int p2);
    
    public native String C(final int p0, final int p1);
    
    public native void C();
    
    public native void C(final int p0);
    
    public native void C(final int p0, final int p1, final int p2);
    
    public final int Code() {
        return this.a;
    }
    
    public native int Code(final int p0, final int p1, final Object p2);
    
    public native int Code(final long p0);
    
    public final int Code(final String s) {
        final int code = q.Code(s);
        final byte[] array = new byte[code];
        int i = 0;
        int n = 0;
        while (i < s.length()) {
            int char1 = s.charAt(i);
            if (char1 >= 55296 && char1 <= 56319) {
                ++i;
                char1 = s.charAt(i) - '\udc00' + (65536 + (char1 - 55296 << 10));
            }
            n += q.Code(char1, array, n);
            ++i;
        }
        return this.Code(array, 0, code);
    }
    
    public final int Code(final byte[] array) {
        if (array == null) {
            return 0;
        }
        return this.Z(array, 0, array.length);
    }
    
    public native int Code(final byte[] p0, final int p1, final int p2);
    
    public native int Code(final byte[] p0, final int p1, final int p2, final byte[] p3, final int p4, final int p5);
    
    public final int Code(final char[] array, final int n, final int n2) {
        int i = 0;
        int n3 = 0;
        while (i < n2) {
            final char c = array[n + i];
            int n6;
            int n7;
            if (c >= '\ud800' && c <= '\udbff') {
                final int n4 = n3 + 4;
                final int n5 = i + 1;
                n6 = n4;
                n7 = n5;
            }
            else {
                final int n8 = q.Code(c) + n3;
                n7 = i;
                n6 = n8;
            }
            final int n9 = n7 + 1;
            n3 = n6;
            i = n9;
        }
        final byte[] array2 = new byte[n3];
        int n12;
        int code;
        for (int j = 0, n10 = 0; j < n2; j = n12 + 1, n10 += code) {
            int n11;
            final char c2 = (char)(n11 = array[n + j]);
            n12 = j;
            if (c2 >= '\ud800') {
                n11 = c2;
                n12 = j;
                if (c2 <= '\udbff') {
                    n12 = j + 1;
                    n11 = (c2 - '\ud800' << 10) + 65536 + (array[n + n12] - '\udc00');
                }
            }
            code = q.Code(n11, array2, n10);
        }
        return this.Code(array2, 0, n3);
    }
    
    public native String Code(final int p0, final int p1, final int p2);
    
    public final void Code(final int a) {
        this.a = a;
    }
    
    public final void Code(final int n, final int n2) {
        this.g = 0;
        this.h = 0;
        this.I = this.a(n, 0, n2);
    }
    
    public final void Code(final int g, final int h, final int n, final boolean b) {
        this.g = g;
        this.h = h;
        int[] i;
        if (b) {
            i = this.I(g, h, n);
        }
        else {
            i = new int[n];
        }
        this.I = i;
    }
    
    public native void Code(final DataInputStream p0, final DataOutputStream p1, final boolean p2);
    
    public final void Code(final InputStream inputStream) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final byte[] array = new byte[inputStream.available()];
        for (int i = inputStream.read(array); i != -1; i = inputStream.read(array)) {
            byteArrayOutputStream.write(array, 0, i);
        }
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        final byte[] array2 = new byte[0];
        this.Code(byteArray, byteArray.length, array2, array2.length, false);
    }
    
    public final void Code(final int[] array) {
        this.Code(0, array);
    }
    
    public native void Code(final int[] p0, final int p1, final int p2);
    
    public native boolean Code(final Object p0);
    
    public native int D(final int p0);
    
    public final void E(final int n) {
        this.Code(n, null);
    }
    
    public final int I() {
        return this.b;
    }
    
    public native int I(final int p0, final int p1);
    
    public final int I(final byte[] array, final int n, final int n2) {
        return this.Z(array, n, n2);
    }
    
    public final void I(final int b) {
        this.b = b;
    }
    
    public final void I(final int g, final int h, final int n, final boolean b) {
        this.g = g;
        this.h = h;
        byte[] b2;
        if (b) {
            b2 = this.b(g, h, n);
        }
        else {
            b2 = new byte[n];
        }
        this.Code = b2;
    }
    
    public final void I(final String s) {
        this.F(this.Code(s));
    }
    
    public native void I(final int[] p0, final int p1, final int p2);
    
    public native int[] I(final int p0, final int p1, final int p2);
    
    public final int J() {
        return this.e;
    }
    
    public final void J(final int e) {
        this.e = e;
    }
    
    public native void J(final int p0, final int p1);
    
    public native void J(final int p0, final int p1, final int p2);
    
    public final int Z() {
        return this.d;
    }
    
    public final void Z(final int d) {
        this.d = d;
    }
    
    public native void Z(final int p0, final int p1);
    
    public native void Z(final int p0, final int p1, final int p2);
    
    public native int a(final int p0);
    
    public native void a();
    
    public native void b();
    
    public native void b(final int p0);
    
    public native void c(final int p0);
    
    public native Object[] c();
    
    public native int d(final int p0);
    
    public native long d();
    
    public native int e();
    
    public final RuntimeException e(final int c) {
        this.C = c;
        return this.B;
    }
    
    public native int f();
    
    public native String f(final int p0);
    
    @Override
    protected void finalize() {
        try {
            this.y();
        }
        finally {
            super.finalize();
        }
    }
    
    public native int g();
    
    public final char[] g(final int n) {
        final String f = this.f(n);
        if (f != null) {
            return f.toCharArray();
        }
        return null;
    }
    
    public native int h();
    
    public native long h(final int p0);
    
    public final void i(final int n) {
        this.Code = new byte[n];
    }
    
    public final int j() {
        return this.Code("");
    }
    
    public native void j(final int p0);
    
    public native int k(final int p0);
    
    public final int l() {
        return this.Code(this.Code, 0, this.Code.length);
    }
    
    public native void l(final int p0);
    
    public final void m() {
        this.a = this.a(0, this.a);
    }
    
    public final void m(final int n) {
        this.F(n);
    }
    
    public native int n();
    
    public native int n(final int p0);
    
    public final int o() {
        return this.Z(this.I, 0, this.I.length);
    }
    
    public final void o(final int n) {
        this.I = new int[n];
    }
    
    public final void p() {
        this.I(this.I, 0, this.g, this.h, this.I.length);
    }
    
    public final void p(final int n) {
        this.I = new int[n];
    }
    
    public final int q() {
        return this.Code(this.Code);
    }
    
    public native int q(final int p0);
    
    public final void r(final int n) {
        this.Code = new byte[n];
    }
    
    public native int s();
    
    public final void s(final int n) {
        this.Code(this.Code, 0, this.g, this.h + 0, n);
    }
    
    public native int t();
    
    public final byte[] t(final int n) {
        return this.b(n, 0, this.u(n));
    }
    
    public native int u(final int p0);
    
    public native boolean u();
    
    public native int v(final int p0);
    
    public native void v();
    
    public native int w(final int p0);
    
    public native int x(final int p0);
    
    public final RuntimeException x() {
        return this.B;
    }
    
    public native Object y(final int p0);
    
    public native void z(final int p0);
}
