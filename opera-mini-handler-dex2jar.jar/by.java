import java.io.IOException;
import java.util.Hashtable;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class by extends InputStream
{
    private Hashtable B;
    private int C;
    private bx Code;
    private by I;
    private int[] J;
    private Object[] Z;
    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private byte[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private final boolean j;
    private int k;
    private byte[] l;
    private long m;
    
    by(final Object[] z, final int[] j, final int i, final boolean k) {
        this.k = 0;
        this.l = new byte[1];
        this.Z = z;
        this.J = j;
        this.i = i;
        this.j = k;
        j[46] = 0;
        this.B = (Hashtable)z[9];
        z[9] = null;
    }
    
    final by B() {
        return this.I;
    }
    
    final int C() {
        return this.C;
    }
    
    final int Code() {
        return this.i;
    }
    
    final Hashtable Code(final boolean b) {
        final Hashtable b2 = this.B;
        if (b) {
            this.B = null;
        }
        return b2;
    }
    
    final void Code(final int g) {
        synchronized (this) {
            this.g = g;
            this.e = null;
            this.notifyAll();
        }
    }
    
    final void Code(final bx code, final int c) {
        this.Code = code;
        this.C = c;
    }
    
    final void Code(final by i) {
        this.I = i;
    }
    
    final boolean Code(final String s) {
        if (this.k >= 3) {
            return false;
        }
        ++this.k;
        this.i = ce.Code(s, null);
        this.Code = null;
        if (this.k == 1) {
            this.Z[90] = this.Z[53];
        }
        this.Z[53] = s;
        this.J[46] = 0;
        return true;
    }
    
    final by I(final by by) {
        if (by != this) {
            by i = this;
            while (true) {
                final by j = this;
                if (i.I == null) {
                    return j;
                }
                if (i.I == by) {
                    break;
                }
                i = i.I;
            }
            i.I = by.I;
            by.I = null;
            return this;
        }
        final by j = this.I;
        this.I = null;
        return j;
    }
    
    final void I(final int d) {
        this.a = true;
        this.d = d;
        cg.Code((Object)this);
    }
    
    final boolean I() {
        return this.j;
    }
    
    final void J() {
        this.Code = null;
    }
    
    final void J(final int n) {
        this.h += n;
    }
    
    final bx Z() {
        return this.Code;
    }
    
    final void Z(final int b) {
        this.b = b;
    }
    
    final Object[] a() {
        return this.Z;
    }
    
    final int[] b() {
        return this.J;
    }
    
    final byte[] c() {
        return this.e;
    }
    
    @Override
    public final void close() {
        bx.Code(this, false);
    }
    
    final int d() {
        return this.f;
    }
    
    final int e() {
        return this.g;
    }
    
    final void f() {
        this.Z = null;
        this.J = null;
    }
    
    final boolean g() {
        return this.Z == null;
    }
    
    final boolean h() {
        return this.J[46] != 0;
    }
    
    final void i() {
        this.J[46] = 1;
    }
    
    final void j() {
        this.c = true;
        cg.Code((Object)this);
    }
    
    public final boolean k() {
        return this.a;
    }
    
    final int l() {
        return this.b;
    }
    
    public final int m() {
        return this.d;
    }
    
    public final int n() {
        return this.h;
    }
    
    public final boolean o() {
        return this.Code != null && this.Code.c();
    }
    
    final void p() {
        this.m = System.currentTimeMillis();
    }
    
    public final int q() {
        return (int)(System.currentTimeMillis() - this.m);
    }
    
    public final boolean r() {
        return this.Code.B();
    }
    
    @Override
    public final int read() {
        if (this.read(this.l, 0, 1) < 0) {
            return -1;
        }
        return this.l[0] & 0xFF;
    }
    
    @Override
    public final int read(final byte[] e, final int f, final int g) {
    Label_0000:
        while (true) {
            this.f = f;
            this.g = g;
            this.e = e;
            cg.Code((Object)this);
            while (!this.a) {
                final bx code = this.Code;
                if (code != null) {
                    code.Code(this);
                }
                if (this.e == null) {
                    if (this.g != 0) {
                        return this.g;
                    }
                    continue Label_0000;
                }
                else {
                    cg.Code((Object)this, 1000);
                }
            }
            if (this.c) {
                return -1;
            }
            throw new IOException();
        }
    }
    
    final bu s() {
        return this.Code.Code();
    }
}
