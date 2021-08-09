import java.io.ByteArrayOutputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class Z extends ByteArrayOutputStream
{
    public Z() {
    }
    
    public Z(final int n) {
        super(n);
    }
    
    public final byte[] Code() {
        return super.buf;
    }
    
    public final void Code(final int count) {
        super.count = count;
    }
}
