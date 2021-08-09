// 
// Decompiled by Procyon v0.6-prerelease
// 

final class bw
{
    private final al Code;
    private final cc I;
    private boolean J;
    private final cc Z;
    
    bw(final al code) {
        this.Code = code;
        this.I = new cc(code);
        this.Z = new cc(code);
        this.J = false;
    }
    
    final void B() {
        if (!this.J) {
            return;
        }
        u.Code.w().Code(this.C());
    }
    
    final String C() {
        if (!this.J || this.I.Code() || this.Z.Code()) {
            return "";
        }
        final cc code = cc.Code(this.I, this.Z);
        cc cc;
        if (code != this.I) {
            cc = this.I;
        }
        else {
            cc = this.Z;
        }
        final StringBuffer sb = new StringBuffer();
        final cc cc2 = new cc(code);
        while (cc2.Z(cc) < 0) {
            sb.append(cc2.Z());
            if (cc2.J()) {
                break;
            }
        }
        return sb.toString();
    }
    
    final cc Code() {
        return this.I;
    }
    
    final void Code(final int n, final int n2, final int n3) {
        this.I.Code(n, n2, n3);
    }
    
    final void Code(final aw aw, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final char[] array, final int n9, final int n10, final int n11, final boolean b) {
        if (this.J && !this.I.Code() && !this.Z.Code()) {
            final int a = cg.a(n10);
            final int n12 = n11 / a;
            int n13 = 1;
            for (int n14 = 0; n14 < n9 && n13 <= n12; ++n14) {
                if (array[n14] == '\n') {
                    ++n13;
                }
            }
            final int a2 = this.Code.a(a);
            int n16;
            for (int i = 0, n15 = 0; i < n13; ++i, n15 += n16 + 1) {
                n16 = 0;
                for (int n17 = n15; n17 < n9 && array[n17] != '\n'; ++n17, ++n16) {}
                if (cc.Code(this.I, this.Z, n8, n15, n16)) {
                    int n18 = n4 + this.Code.a(n11 * i / n13);
                    final int code = cc.Code(this.I, this.Z, n8, n15);
                    final int code2 = cg.Code(n10, array, n15, code);
                    final int code3 = cg.Code(n10, array, n15 + code, cc.I(this.I, this.Z, n8, n15, n16) - code);
                    final int a3 = this.Code.a(code2);
                    final int a4 = this.Code.a(code3);
                    int n19;
                    if (b) {
                        n19 = a3 + n3;
                    }
                    else {
                        n19 = n3 + n5 - a3 - a4;
                    }
                    aw.Z(n19, n18, a4, a2, -5189377);
                    if (i + 1 == n13 && cc.I(this.I, this.Z, n8)) {
                        final cb code4 = this.Code.Code(n8, n6, n7);
                        if (cb.Code(n11 * i / n13 + n7, cg.a(n10), code4.Z(), code4.B())) {
                            if (b) {
                                n19 += a4;
                            }
                            final int z = code4.Z();
                            final int b2 = code4.B();
                            int n20;
                            if (n11 < b2) {
                                final int a5 = this.Code.a(b2 + z);
                                final int a6 = this.Code.a(z);
                                n20 = a5 - a6;
                                n18 = a6 + n2;
                            }
                            else {
                                n20 = a2;
                            }
                            final int n21 = this.Code.a(code4.I()) + n;
                            if (n19 < n21) {
                                aw.Z(n19, n18, n21 - n19 + 1, n20, -5189377);
                            }
                            else {
                                final int j = code4.J();
                                aw.Z(n21 + j, n18, n19 - (j + n21) + 1, n20, -5189377);
                            }
                        }
                    }
                }
            }
        }
    }
    
    final void Code(final cc cc) {
        this.I.Code(cc);
    }
    
    final void Code(final boolean j) {
        this.J = j;
    }
    
    final boolean Code(final int n) {
        return cc.Code(this.I, this.Z, n);
    }
    
    final cc I() {
        return this.Z;
    }
    
    final void I(final int n, final int n2, final int n3) {
        this.I.I(n, n2, n3);
    }
    
    final void I(final cc cc) {
        this.Z.Code(cc);
    }
    
    final void J() {
        this.I.I();
        this.Z.I();
    }
    
    final void J(final int n, final int n2, final int n3) {
        this.Z.Z(n, n2, n3);
    }
    
    final void Z(final int n, final int n2, final int n3) {
        this.Z.Code(n, n2, n3);
    }
    
    final boolean Z() {
        return this.J;
    }
    
    final boolean a() {
        return this.J && !this.I.Code() && !this.Z.Code() && !this.I.I(this.Z);
    }
}
