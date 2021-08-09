// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ax
{
    private bv Code;
    private byte[] I;
    private byte[] J;
    private byte[] Z;
    
    public ax(byte[] array, int i, final int n) {
        this.Code = new bv();
        this.I = new byte[64];
        this.Z = new byte[64];
        this.J = new byte[32];
        byte[] array2 = array;
        int n2 = i;
        int n3 = n;
        if (n > 64) {
            this.Code.Code(array, i, n);
            array2 = new byte[64];
            this.Code.Code(array2);
            this.Code.Code();
            n3 = 64;
            n2 = 0;
        }
        System.arraycopy(array2, n2, this.I, 0, n3);
        System.arraycopy(array2, n2, this.Z, 0, n3);
        for (i = 0; i < 64; ++i) {
            array = this.Z;
            array[i] ^= 0x36;
            array = this.I;
            array[i] ^= 0x5C;
        }
        this.Code.Code(this.Z, 0, 64);
    }
    
    public final void Code(final int n) {
        this.Code.Code(n);
    }
    
    public final void Code(final byte[] array, final int n, final int n2) {
        this.Code.Code(array, n, n2);
    }
    
    public final void I(final byte[] array, final int n, final int n2) {
        this.Code.Code(this.J);
        this.Code.Code(this.I, 0, 64);
        this.Code.Code(this.J, 0, 32);
        this.Code.Code(this.J);
        System.arraycopy(this.J, 0, array, n, n2);
        this.Code.Code(this.Z, 0, 64);
    }
}
