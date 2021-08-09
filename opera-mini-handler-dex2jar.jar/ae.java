// 
// Decompiled by Procyon v0.6-prerelease
// 

final class ae
{
    private final al Code;
    private final cc I;
    private boolean Z;
    
    ae(final al code) {
        this.Z = false;
        this.Code = code;
        this.I = new cc(code);
    }
    
    final int Code() {
        return this.I.B();
    }
    
    final void Code(final int n) {
        this.I.Code(n);
    }
    
    final void Code(final int n, final int n2, final int n3) {
        this.I.Code(n, n2, n3);
    }
    
    final void Code(final aw aw, int n, int n2, final int n3) {
        if (!this.Z) {
            return;
        }
        final int b = this.I.B();
        final int c = this.I.C();
        final int b2 = this.I.b();
        n += this.Code.a(b);
        n2 += this.Code.a(c);
        final int a = this.Code.a(b2);
        aw.Z(n - 1, n2, 3, 1, n3);
        aw.Z(n, n2, 1, a, n3);
        aw.Z(n - 1, n2 + a - 1, 3, 1, n3);
    }
    
    final void Code(final cc cc) {
        this.I.Code(cc);
    }
    
    final void Code(final boolean z) {
        this.Z = z;
    }
    
    final int I() {
        return this.I.C();
    }
    
    final boolean I(final int n) {
        return this.I.I(n);
    }
    
    final boolean J() {
        return this.Z;
    }
    
    final cc Z() {
        return this.I;
    }
}
