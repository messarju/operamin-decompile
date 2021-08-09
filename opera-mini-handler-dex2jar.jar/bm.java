// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class bm
{
    private ax Code;
    private byte[] I;
    private byte[] Z;
    
    public bm() {
        this.I = new byte[64];
        this.Z = new byte[32];
    }
    
    public final void Code(final byte[] array, final int n) {
        this.Code = new ax(array, n, 32);
    }
    
    public final void I(final byte[] array, final int n) {
        for (int i = n; i < 64; ++i) {
            this.I[i] = 0;
        }
        System.arraycopy(array, 0, this.I, 0, Math.min(64, n));
        this.Code.Code(this.I, 0, 64);
        this.Code.I(this.Z, 0, 32);
    }
    
    public final void Z(final byte[] array, final int n) {
        this.Code.Code(this.Z, 0, 32);
        this.Code.Code(this.I, 0, 64);
        this.Code.I(array, n, 32);
        this.Code.Code(this.Z, 0, 32);
        this.Code.I(this.Z, 0, 32);
    }
}
