// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class az
{
    int Code;
    
    public abstract aw B();
    
    public az Code(int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11, final boolean b) {
        if (n3 != n5 || n4 != n6) {
            n = ba.Code(new int[n3 * n4], n3, n4, n5, n6, n7, n8, n9, n10, n11, b).length / n6;
            throw new NullPointerException();
        }
        if (n3 == this.I() && n4 == this.Z()) {
            return this;
        }
        return this.Code(n, n2, n3, n4, n3, n4, 0, 0, 0, 0, 0, true);
    }
    
    public final void Code() {
        this.Code = 0;
    }
    
    public abstract int I();
    
    public abstract int J();
    
    public abstract int Z();
}
