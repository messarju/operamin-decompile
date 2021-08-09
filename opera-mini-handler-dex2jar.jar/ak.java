import java.io.ByteArrayOutputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ak extends ByteArrayOutputStream
{
    ak() {
    }
    
    ak(final int n) {
        super(n);
    }
    
    final void Code(final int count) {
        this.count = count;
    }
    
    public final byte[] Code() {
        return this.buf;
    }
}
