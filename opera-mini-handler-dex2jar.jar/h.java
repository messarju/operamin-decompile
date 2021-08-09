import java.io.DataInput;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class h
{
    public abstract byte Code();
    
    public abstract int Code(final DataInput p0, final int p1);
    
    public final int Code(final Object o) {
        int n;
        if ((n = this.I() - ((h)o).I()) == 0) {
            n = this.Code() - ((h)o).Code();
        }
        return n;
    }
    
    protected abstract int I();
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof h && this.I() == ((h)o).I() && this.Code() == ((h)o).Code();
    }
    
    @Override
    public final int hashCode() {
        return this.I();
    }
}
