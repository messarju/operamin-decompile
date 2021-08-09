import java.io.EOFException;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ab extends InputStream
{
    public DataInputStream Code;
    public int I;
    private int Z;
    
    public static ab Code(int short1) {
        int i = -1;
        final ab ab = new ab();
        final int n = short1 & 0x7FFF;
        ab.Code = new DataInputStream(new ByteArrayInputStream(u.n()));
        final bl m = u.m();
        short1 = ab.Code.readShort();
        cg.Code((InputStream)ab.Code, short1);
        ab.Code.readShort();
        if (m.Z) {
            short1 = m.Code[n];
        }
        else {
            short1 = -1;
        }
        if (m.Z) {
            i = m.I[n];
        }
        ab.I = i;
        cg.Code((InputStream)ab.Code, short1 + (n * 6 + 6));
        return ab;
    }
    
    public static ab Code(final int n, String code) {
        final String a = u.a(n);
        code = u.Code(n, code);
        return bs.Code.J(a, code);
    }
    
    public static ab Code(final InputStream inputStream, final int i) {
        final ab ab = new ab();
        ab.Code = new DataInputStream(inputStream);
        ab.I = i;
        return ab;
    }
    
    public final long B() {
        if (this.Z + 8 > this.I) {
            throw new EOFException();
        }
        this.Z += 8;
        return this.Code.readLong();
    }
    
    public final int Code() {
        return this.I;
    }
    
    public final int I() {
        if (this.Z == this.I) {
            throw new EOFException();
        }
        ++this.Z;
        return this.Code.readByte();
    }
    
    public final int I(final int n) {
        final int min = Math.min(n, this.I - this.Z);
        cg.Code((InputStream)this.Code, min);
        this.Z += min;
        if (n != min) {
            throw new EOFException();
        }
        return n;
    }
    
    public final int J() {
        if (this.Z + 4 > this.I) {
            throw new EOFException();
        }
        this.Z += 4;
        return this.Code.readInt();
    }
    
    public final int Z() {
        if (this.Z + 2 > this.I) {
            throw new EOFException();
        }
        this.Z += 2;
        return this.Code.readShort();
    }
    
    @Override
    public final void close() {
        cg.Code((InputStream)this.Code);
        this.Code = null;
    }
    
    @Override
    public final int read() {
        final int read = this.Code.read();
        if (read < 0) {
            return -1;
        }
        ++this.Z;
        return read;
    }
    
    @Override
    public final int read(final byte[] array, int read, final int n) {
        if (this.Z == this.I && n > 0) {
            throw new EOFException();
        }
        read = this.Code.read(array, read, Math.min(n, this.I - this.Z));
        if (read < 0) {
            throw new EOFException();
        }
        this.Z += read;
        return read;
    }
}
