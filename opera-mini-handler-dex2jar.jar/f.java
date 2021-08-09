import java.io.EOFException;
import java.io.DataInput;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class f extends InputStream implements DataInput
{
    private final InputStream Code;
    
    f(final InputStream code) {
        this.Code = code;
    }
    
    private int Code() {
        final int read = this.Code.read();
        if (read == -1) {
            throw new EOFException();
        }
        return read;
    }
    
    private int I() {
        int n;
        int n2;
        for (n = this.Code(), n2 = (n & 0x7F); (n & 0x80) != 0x0; n = this.Code(), n2 = (n2 << 7 | (n & 0x7F))) {}
        return n2;
    }
    
    @Override
    public final int read() {
        return this.Code.read();
    }
    
    @Override
    public final boolean readBoolean() {
        return this.Code() != 0;
    }
    
    @Override
    public final byte readByte() {
        return (byte)this.Code();
    }
    
    @Override
    public final char readChar() {
        return (char)this.I();
    }
    
    @Override
    public final double readDouble() {
        return 0.0;
    }
    
    @Override
    public final float readFloat() {
        return 0.0f;
    }
    
    @Override
    public final void readFully(final byte[] array) {
        if (this.Code.read(array) < array.length) {
            throw new EOFException();
        }
    }
    
    @Override
    public final void readFully(final byte[] array, final int n, final int n2) {
        if (this.Code.read(array, n, n2) < n2) {
            throw new EOFException();
        }
    }
    
    @Override
    public final int readInt() {
        return this.I();
    }
    
    @Override
    public final String readLine() {
        return null;
    }
    
    @Override
    public final long readLong() {
        return -1L;
    }
    
    @Override
    public final short readShort() {
        return (short)this.I();
    }
    
    @Override
    public final String readUTF() {
        return null;
    }
    
    @Override
    public final int readUnsignedByte() {
        return this.Code();
    }
    
    @Override
    public final int readUnsignedShort() {
        return this.I();
    }
    
    @Override
    public final int skipBytes(final int n) {
        return (int)this.skip(n);
    }
}
