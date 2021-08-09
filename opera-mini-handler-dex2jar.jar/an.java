// 
// Decompiled by Procyon v0.6-prerelease
// 

public class an
{
    private bh[] Code;
    
    public an() {
        this.Code = new bh[1];
    }
    
    int Code() {
        return this.Code.length;
    }
    
    bh Code(final int n) {
        return this.Code[n];
    }
    
    final void Code(final int n, final bh bh) {
        if (n >= this.Code.length) {
            final bh[] code = new bh[n + 1];
            System.arraycopy(this.Code, 0, code, 0, this.Code.length);
            this.Code = code;
        }
        if (this.Code[n] != bh) {
            final bh bh2 = this.Code[n];
            this.Code[n] = bh;
            if (bh2 != null) {
                bh2.I(null, 0);
            }
            bh.I(this, n);
        }
    }
    
    final void I(final int n) {
        if (this.Code[n] != null) {
            final bh bh = this.Code[n];
            this.Code[n] = null;
            bh.I(null, 0);
        }
    }
}
