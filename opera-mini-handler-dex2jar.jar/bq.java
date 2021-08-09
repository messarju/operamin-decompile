// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class bq
{
    private byte[] Code;
    private int I;
    private int Z;
    
    public bq(final byte[] array) {
        int i = 0;
        this.Code = new byte[256];
        this.I = 0;
        this.Z = 0;
        this.I = 0;
        this.Z = 0;
        for (int j = 0; j < 256; ++j) {
            this.Code[j] = (byte)j;
        }
        int n = 0;
        int n2 = 0;
        while (i < 256) {
            n = (n + (array[n2] + this.Code[i]) & 0xFF);
            final byte b = this.Code[i];
            this.Code[i] = this.Code[n];
            this.Code[n] = b;
            n2 = (n2 + 1) % 32;
            ++i;
        }
    }
    
    public final void Code(final byte[] array, final int n, final int n2) {
        for (int i = 0; i < n2; ++i) {
            this.I = (this.I + 1 & 0xFF);
            this.Z = (this.Code[this.I] + this.Z & 0xFF);
            final byte b = this.Code[this.I];
            this.Code[this.I] = this.Code[this.Z];
            this.Code[this.Z] = b;
            array[n + i] ^= this.Code[this.Code[this.I] + this.Code[this.Z] & 0xFF];
        }
    }
}
