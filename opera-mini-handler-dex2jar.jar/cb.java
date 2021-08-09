// 
// Decompiled by Procyon v0.6-prerelease
// 

final class cb
{
    private String B;
    private char[] C;
    private final al Code;
    private final int I;
    private final int J;
    private final int Z;
    private boolean a;
    
    cb(final al code, final int i, final int z, final int j) {
        this.B = null;
        this.C = null;
        this.a = false;
        this.Code = code;
        this.I = i;
        this.Z = z;
        this.J = j;
    }
    
    private boolean B(final cb cb) {
        return this.Z < cb.Z;
    }
    
    private boolean C(final cb cb) {
        return this.J > cb.J;
    }
    
    static boolean Code(final int n, final int n2, final int n3, final int n4) {
        return n < n3 + n4 && n + n2 > n3;
    }
    
    static boolean Code(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        if (Code(n2, n4, n6, n8)) {
            if (n < n5) {
                if (n + n3 == n5) {
                    return false;
                }
            }
            else if (n == n5 + n7) {
                return false;
            }
        }
        return true;
    }
    
    private boolean a(final cb cb) {
        return this.J < cb.J;
    }
    
    private boolean b(final cb cb) {
        return this.Z > cb.Z;
    }
    
    private cb m() {
        return this.Code.B(this.I);
    }
    
    final int B() {
        return this.Code.Code(this.I + 8);
    }
    
    final int C() {
        return this.Code.I(this.I + 15);
    }
    
    final int Code() {
        return this.I;
    }
    
    final int Code(final cb cb) {
        return this.I - cb.I;
    }
    
    final int Code(final boolean b) {
        return this.a().length() - this.I(b);
    }
    
    final boolean Code(final int n, final int n2) {
        return cg.Code(n, n2, 1, 1, this.Z, this.J, this.J(), this.B());
    }
    
    final int I() {
        return this.Z;
    }
    
    final int I(final boolean b) {
        if (this.c()) {
            if (b) {
                return 1;
            }
            return 0;
        }
        else {
            if (b) {
                return this.a().length() - 1;
            }
            return this.a().length();
        }
    }
    
    final boolean I(final cb cb) {
        return Code(this.J, this.B(), cb.J, cb.B());
    }
    
    final int J() {
        return this.Code.I(this.I + 6);
    }
    
    final boolean J(final cb cb) {
        return cg.Code(this.Z, this.J, this.J(), this.B(), cb.Z, cb.J, cb.J(), cb.B());
    }
    
    final int Z() {
        return this.J;
    }
    
    final boolean Z(final cb cb) {
        return Code(this.Z, this.J, this.J(), this.B(), cb.Z, cb.J, cb.J(), cb.B());
    }
    
    final String a() {
        if (this.B == null) {
            final int n = this.I + 17;
            int i = this.Code.Z(n);
            int n2 = n + 1;
            while (i > 0) {
                final al code = this.Code;
                final int n3 = n2 + 1;
                switch (code.Z(n2)) {
                    default: {
                        n2 = this.Code.I(n3) + 2 + n3;
                        break;
                    }
                    case 114: {
                        this.a = true;
                        n2 = n3 + 2;
                        break;
                    }
                }
                --i;
            }
            this.B = this.Code.J(n2);
            if (cg.Code(this.B.charAt(0)) && !cg.J(this.B.charAt(0))) {
                this.B = new StringBuffer(this.B).reverse().toString();
            }
        }
        return this.B;
    }
    
    final char[] b() {
        if (this.C == null) {
            this.C = this.a().toCharArray();
        }
        return this.C;
    }
    
    final boolean c() {
        boolean b = false;
        if (!cg.Code(this.a().charAt(0))) {
            b = true;
        }
        return b;
    }
    
    final boolean d() {
        if (this.B == null) {
            this.a();
        }
        return !this.a;
    }
    
    final cb e() {
        return this.Code.Code(this.I, this.Z, this.J);
    }
    
    final cb f() {
        final int j = this.J;
        final int b = this.B();
        for (cb cb = this.e(); cb != null; cb = cb.e()) {
            if (cb.J >= b + j) {
                return cb;
            }
        }
        return null;
    }
    
    final cb g() {
        final int j = this.J;
        for (cb cb = this.m(); cb != null; cb = cb.m()) {
            if (cb.J + cb.B() - 1 < j) {
                return cb;
            }
        }
        return null;
    }
    
    final cb h() {
        cb m;
        final cb cb = m = this.m();
        if (cb != null) {
            m = cb;
            if (!this.I(cb)) {
                m = null;
            }
        }
        return m;
    }
    
    final cb i() {
        final cb e = this.e();
        Label_0039: {
            if (e == null) {
                break Label_0039;
            }
            if (e.I(this)) {
                final cb cb = e;
                if (e.b(this)) {
                    return cb;
                }
            }
            if (!e.C(this)) {
                break Label_0039;
            }
            return e;
        }
        final cb m = this.m();
        if (m != null) {
            if (m.I(this)) {
                final cb cb = m;
                if (m.b(this)) {
                    return cb;
                }
            }
            final cb cb = m;
            if (m.C(this)) {
                return cb;
            }
        }
        return null;
    }
    
    final cb j() {
        final cb e = this.e();
        Label_0039: {
            if (e == null) {
                break Label_0039;
            }
            if (e.I(this)) {
                final cb cb = e;
                if (e.B(this)) {
                    return cb;
                }
            }
            if (!e.C(this)) {
                break Label_0039;
            }
            return e;
        }
        final cb m = this.m();
        if (m != null) {
            if (m.I(this)) {
                final cb cb = m;
                if (m.B(this)) {
                    return cb;
                }
            }
            final cb cb = m;
            if (m.C(this)) {
                return cb;
            }
        }
        return null;
    }
    
    final cb k() {
        final cb e = this.e();
        Label_0039: {
            if (e == null) {
                break Label_0039;
            }
            if (e.I(this)) {
                final cb cb = e;
                if (e.B(this)) {
                    return cb;
                }
            }
            if (!e.a(this)) {
                break Label_0039;
            }
            return e;
        }
        final cb m = this.m();
        if (m != null) {
            if (m.I(this)) {
                final cb cb = m;
                if (m.B(this)) {
                    return cb;
                }
            }
            final cb cb = m;
            if (m.a(this)) {
                return cb;
            }
        }
        return null;
    }
    
    final cb l() {
        final cb e = this.e();
        Label_0039: {
            if (e == null) {
                break Label_0039;
            }
            if (e.I(this)) {
                final cb cb = e;
                if (e.b(this)) {
                    return cb;
                }
            }
            if (!e.a(this)) {
                break Label_0039;
            }
            return e;
        }
        final cb m = this.m();
        if (m != null) {
            if (m.I(this)) {
                final cb cb = m;
                if (m.b(this)) {
                    return cb;
                }
            }
            final cb cb = m;
            if (m.a(this)) {
                return cb;
            }
        }
        return null;
    }
    
    @Override
    public final String toString() {
        final StringBuilder append = new StringBuilder("offset=").append(this.I).append(" (\"");
        String s;
        if (this.a().length() < 7) {
            s = this.a();
        }
        else {
            s = this.a().substring(0, 5) + "\u2026";
        }
        return append.append(s).append("\")").toString();
    }
}
