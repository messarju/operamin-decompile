// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class e
{
    private int Code;
    private int I;
    private int J;
    private int Z;
    
    public final void Code() {
        this.Code = 1;
        this.I = 0;
        this.Z = 0;
        this.J = 0;
    }
    
    public final void Code(final byte[] array, int n, int i) {
        this.J += i;
        while (i > 0) {
            if (this.Z++ == 2775) {
                this.Code %= 65521;
                this.I %= 65521;
                this.Z = 0;
            }
            this.Code += (array[n] & 0xFF);
            this.I += this.Code;
            --i;
            ++n;
        }
    }
    
    public final byte[] I() {
        this.Code %= 65521;
        this.I %= 65521;
        final int n = this.I << 16 | this.Code;
        return new byte[] { (byte)(n >>> 24 & 0xFF), (byte)(n >>> 16 & 0xFF), (byte)(n >>> 8 & 0xFF), (byte)(n & 0xFF) };
    }
}
