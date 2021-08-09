// 
// Decompiled by Procyon v0.6-prerelease
// 

class cc
{
    private al Code;
    private cb I;
    private int J;
    private int Z;
    
    cc(final al code) {
        this.I = null;
        this.Code = code;
        this.J = Integer.MIN_VALUE;
    }
    
    private cc(final al code, final cb i, final int z) {
        this.I = null;
        this.Code = code;
        this.I = i;
        this.Z = z;
    }
    
    cc(final cc cc) {
        this.I = null;
        this.Code(cc);
    }
    
    static int Code(cc code, final cc cc, final int n, final int n2) {
        code = Code(code, cc);
        if (code.I.Code() != n) {
            return 0;
        }
        return Math.max(0, code.Z - n2);
    }
    
    static cc Code(final cc cc, final cc cc2) {
        if (!cc.Code()) {
            if (cc2.Code()) {
                return cc2;
            }
            if (cc.I.Code() >= cc2.I.Code()) {
                if (cc.I.Code() > cc2.I.Code()) {
                    return cc2;
                }
                if (cc.Z > cc2.Z) {
                    return cc2;
                }
            }
        }
        return cc;
    }
    
    static boolean Code(cc cc, final cc cc2, final int n) {
        if (!cc.Code() && !cc2.Code()) {
            final cc code = Code(cc, cc2);
            if (code == cc) {
                cc = cc2;
            }
            if (code.I.Code() <= n && cc.I.Code() >= n) {
                return true;
            }
        }
        return false;
    }
    
    static boolean Code(cc cc, final cc cc2, int z, final int n, int z2) {
        final boolean b = false;
        final cc code = Code(cc, cc2);
        if (code == cc) {
            cc = cc2;
        }
        final int n2 = n + z2;
        if (code.I.Code() == z) {
            z2 = code.Z;
        }
        else {
            z2 = 0;
        }
        if (cc.I.Code() == z) {
            z = cc.Z;
        }
        else {
            z = n2;
        }
        boolean b2 = b;
        if (z2 <= n2) {
            b2 = b;
            if (z >= n) {
                b2 = true;
            }
        }
        return b2;
    }
    
    static int I(final cc cc, cc cc2, final int n, final int n2, final int n3) {
        if (Code(cc, cc2) != cc) {
            cc2 = cc;
        }
        if (cc2.I.Code() != n) {
            return n3;
        }
        return Math.min(cc2.Z - n2, n3);
    }
    
    static boolean I(cc cc, final cc cc2, final int n) {
        if (!cc.Code() && !cc2.Code()) {
            if (Code(cc, cc2) == cc) {
                cc = cc2;
            }
            if (n < cc.I.Code()) {
                return true;
            }
        }
        return false;
    }
    
    private void Z(final int n) {
        final int c = this.C();
        final int b = this.b();
        int n2 = Integer.MAX_VALUE;
        boolean j = false;
        int n3;
        for (cc cc = new cc(this); cb.Code(cc.C(), cc.b(), c, b) && !j; j = cc.J(), n2 = n3) {
            final int abs = Math.abs(cc.B() - n);
            if (abs < (n3 = n2)) {
                this.Code(cc);
                n3 = abs;
            }
        }
    }
    
    private int e() {
        if (this.J == Integer.MIN_VALUE) {
            this.J = this.B();
        }
        return this.J;
    }
    
    final int B() {
        if (this.Code()) {
            return 0;
        }
        final int c = this.I.C();
        final char[] b = this.I.b();
        if (this.I.c()) {
            int n;
            for (n = this.Z - 1; n >= 0 && b[n] != '\n'; --n) {}
            return cg.Code(c, b, n + 1, this.Z - 1 - n) + this.I.I();
        }
        int z;
        for (z = this.Z; z < b.length && b[z] != '\n'; ++z) {}
        return cg.Code(c, b, this.Z, z - this.Z) + this.I.I();
    }
    
    final int C() {
        int i = 0;
        if (this.Code()) {
            return 0;
        }
        int z = this.I.Z();
        final int c = this.I.C();
        final String a = this.I.a();
        final int a2 = cg.a(c);
        while (i < this.Z) {
            int n = z;
            if (a.charAt(i) == '\n') {
                n = z + a2;
            }
            ++i;
            z = n;
        }
        return z;
    }
    
    final void Code(int i) {
        final int n = 1;
        final int n2 = 1;
        final int n3 = 0;
        Label_0014: {
            if (!this.Code()) {
                switch (i) {
                    default: {
                        return;
                    }
                    case 1: {
                        this.J = Integer.MIN_VALUE;
                        final int b = this.B();
                        i = 1;
                        do {
                            if (this.I.c()) {
                                if (this.Z > 0) {
                                    --this.Z;
                                }
                                else {
                                    cb j;
                                    if (this.I.d()) {
                                        j = this.I.k();
                                    }
                                    else {
                                        j = this.I.j();
                                    }
                                    if (j != null) {
                                        this.Z = j.Code(!j.Z(this.I));
                                        this.I = j;
                                    }
                                    else {
                                        i = 0;
                                    }
                                }
                            }
                            else {
                                final int length = this.I.a().length();
                                if (this.Z < length - 1) {
                                    ++this.Z;
                                }
                                else {
                                    cb k;
                                    if (this.I.d()) {
                                        k = this.I.k();
                                    }
                                    else {
                                        k = this.I.j();
                                    }
                                    if (this.Z == length - 1 && (k == null || this.I.Z(k))) {
                                        this.Z = length;
                                    }
                                    else if (k != null) {
                                        this.Z = k.Code(this.Z == length && !this.I.Z(k));
                                        this.I = k;
                                    }
                                    else {
                                        i = 0;
                                    }
                                }
                            }
                            if (i == 0) {
                                break Label_0014;
                            }
                        } while (this.B() == b);
                        return;
                    }
                    case 2: {
                        this.J = Integer.MIN_VALUE;
                        final int b2 = this.B();
                        i = 1;
                        do {
                            if (this.I.c()) {
                                final int length2 = this.I.a().length();
                                if (this.Z < length2 - 1) {
                                    ++this.Z;
                                }
                                else {
                                    cb l;
                                    if (this.I.d()) {
                                        l = this.I.i();
                                    }
                                    else {
                                        l = this.I.l();
                                    }
                                    if (this.Z == length2 - 1 && (l == null || this.I.Z(l))) {
                                        this.Z = length2;
                                    }
                                    else if (l != null) {
                                        this.Z = l.I(this.Z == length2 && !l.Z(this.I));
                                        this.I = l;
                                    }
                                    else {
                                        i = 0;
                                    }
                                }
                            }
                            else if (this.Z > 0) {
                                --this.Z;
                            }
                            else {
                                cb m;
                                if (this.I.d()) {
                                    m = this.I.i();
                                }
                                else {
                                    m = this.I.l();
                                }
                                if (m != null) {
                                    this.Z = m.I(!this.I.Z(this.I));
                                    this.I = m;
                                }
                                else {
                                    i = 0;
                                }
                            }
                            if (i == 0) {
                                break Label_0014;
                            }
                        } while (this.B() == b2);
                        return;
                    }
                    case 3: {
                        final int e = this.e();
                        final String a = this.I.a();
                        while (true) {
                            cb i2;
                            cb g;
                            cb h;
                            String a2;
                            for (i = this.Z - 1; i >= 0; --i) {
                                if (a.charAt(i) == '\n') {
                                    if (i == -1) {
                                        i = 0;
                                    }
                                    else {
                                        this.Z = i;
                                        while (true) {
                                            i = n2;
                                            if (this.Z <= 0) {
                                                break;
                                            }
                                            i = n2;
                                            if (a.charAt(this.Z - 1) == '\n') {
                                                break;
                                            }
                                            --this.Z;
                                        }
                                    }
                                    if (i == 0) {
                                        i2 = null;
                                        for (g = this.I.g(); g != null; g = h) {
                                            h = g.h();
                                            i2 = g;
                                        }
                                        if (i2 == null) {
                                            break Label_0014;
                                        }
                                        this.I = i2;
                                        this.Z = 0;
                                        for (a2 = this.I.a(), i = n3; i < a2.length(); ++i) {
                                            if (a2.charAt(i) == '\n') {
                                                this.Z = i + 1;
                                            }
                                        }
                                    }
                                    this.Z(e);
                                    return;
                                }
                            }
                            i = -1;
                            continue;
                        }
                    }
                    case 4: {
                        final int e2 = this.e();
                        while (true) {
                            String a3;
                            cb f;
                            for (a3 = this.I.a(), i = this.Z; i < a3.length(); ++i) {
                                if (a3.charAt(i) == '\n') {
                                    this.Z = i + 1;
                                    i = n;
                                    if (i == 0) {
                                        f = this.I.f();
                                        if (f == null) {
                                            break Label_0014;
                                        }
                                        this.I = f;
                                        this.Z = 0;
                                    }
                                    this.Z(e2);
                                    return;
                                }
                            }
                            i = 0;
                            continue;
                        }
                    }
                }
            }
        }
    }
    
    final void Code(final int n, final int n2, final int n3) {
        if (this.I != null && this.I.Code(n2, n3)) {
            this.Code(this.I, n2, n3);
            return;
        }
        this.Code(this.Code.I(n, n2, n3), n2, n3);
    }
    
    final void Code(final cb i, final int n, final int n2) {
        if (i != null) {
            this.J = Integer.MIN_VALUE;
            this.I = i;
            this.Z = 0;
            int n3 = Integer.MAX_VALUE;
            final cc cc = new cc(this);
            do {
                final int a = cg.a(cc.I.C());
                final cb e = cc.I.e();
                cc cc2;
                if (e != null) {
                    cc2 = new cc(this.Code, e, 0);
                }
                else {
                    cc2 = new cc(this.Code, cc.I, cc.I.a().length());
                }
                for (boolean j = false; cc.Z(cc2) <= 0 && !j; j = cc.J()) {
                    final int n4 = cc.B() - n;
                    final int n5 = cc.C() + a / 2 - n2;
                    final int n6 = n4 * n4 + n5 * n5;
                    if (n6 < n3) {
                        this.Code(cc);
                        n3 = n6;
                    }
                }
                cc.I = e;
                cc.Z = 0;
                if (cc.I == null) {
                    return;
                }
            } while (cc.I.J(this.I));
        }
    }
    
    final void Code(final cc cc) {
        this.Code = cc.Code;
        this.I = cc.I;
        this.Z = cc.Z;
        this.J = cc.J;
    }
    
    final boolean Code() {
        return this.I == null;
    }
    
    final void I() {
        this.I = null;
    }
    
    final void I(int char1, final int n, final int n2) {
        this.Code(char1, n, n2);
        final String a = this.I.a();
        if (this.Z > a.length()) {
            this.Z = a.length();
        }
        while (this.Z > 0) {
            char1 = a.charAt(this.Z - 1);
            if (char1 == 32 || char1 == 10) {
                break;
            }
            --this.Z;
        }
    }
    
    final boolean I(final int n) {
        return !this.Code() && this.I.Code() == n;
    }
    
    final boolean I(final cc cc) {
        if (this.Code() || cc.Code()) {
            if (this.Code() != cc.Code()) {
                return false;
            }
        }
        else if (this.Z(cc) != 0) {
            return false;
        }
        return true;
    }
    
    final boolean J() {
        final int length = this.I.a().length();
        if (this.Z < length - 1) {
            ++this.Z;
            return false;
        }
        final cb e = this.I.e();
        if (e != null) {
            if (this.Z == length - 1 && this.I.Z(e)) {
                ++this.Z;
                return false;
            }
            this.I = e;
            this.Z = 0;
            return false;
        }
        else {
            if (this.Z < length) {
                ++this.Z;
                return false;
            }
            return true;
        }
    }
    
    final char Z() {
        final String a = this.I.a();
        if (this.Z < a.length()) {
            return a.charAt(this.Z);
        }
        final cb e = this.I.e();
        if (e == null) {
            return '\0';
        }
        if (this.I.I(e)) {
            return ' ';
        }
        return '\n';
    }
    
    final int Z(final cc cc) {
        if (this.I.Code(cc.I) == 0) {
            return this.Z - cc.Z;
        }
        return this.I.Code(cc.I);
    }
    
    final void Z(int char1, final int n, final int n2) {
        this.Code(char1, n, n2);
        final String a = this.I.a();
        while (this.Z < a.length()) {
            char1 = a.charAt(this.Z);
            if (char1 == 32 || char1 == 10) {
                break;
            }
            ++this.Z;
        }
    }
    
    final int a() {
        if (this.Code()) {
            return 0;
        }
        return 1;
    }
    
    final int b() {
        if (this.Code()) {
            return 0;
        }
        return cg.a(this.I.C());
    }
    
    int c() {
        return this.I.Code();
    }
    
    final int d() {
        return cg.Code(this.I.a(), this.Z);
    }
    
    @Override
    public final String toString() {
        return "node=" + this.I + " offset=" + this.Z + " (x: " + this.B() + ", y: " + this.C() + ")";
    }
}
