import java.io.IOException;
import java.io.DataOutputStream;
import java.io.OutputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class I extends OutputStream
{
    private Z Code;
    private DataOutputStream Code;
    private String Code;
    private int Code;
    
    public static I Code(final OutputStream outputStream) {
        final I n;
        (n = new I()).Code = new Z();
        n.Code = new DataOutputStream(outputStream);
        return n;
    }
    
    public static I Code(final int code, final String code2) {
        final I n;
        (n = new I()).Code = new Z();
        n.Code = new DataOutputStream(n.Code);
        n.Code = code2;
        n.Code = code;
        return n;
    }
    
    private I() {
    }
    
    public final void write(final int n) {
        this.Code.write(n);
    }
    
    public final void write(final byte[] array, final int n, final int n2) {
        this.Code.write(array, n, n2);
    }
    
    public final void write(final byte[] array) {
        this.Code.write(array);
    }
    
    public final void Code(final int n) {
        this.Code.writeByte(n);
    }
    
    public final void I(final int n) {
        this.Code.writeShort(n);
    }
    
    public final void Z(final int n) {
        this.Code.writeInt(n);
    }
    
    public final void Code(final long n) {
        this.Code.writeLong(n);
    }
    
    public final void flush() {
        this.Code.flush();
    }
    
    public final void close() {
        final int code = this.Code;
        try {
            final String i = Code.I(code);
            this.Code = Code.Code(this.Code, this.Code);
            Code.J.Code(i, this.Code, this.Code.Code(), 0, this.Code.size());
        }
        catch (IOException ex) {}
        finally {
            Code.Code((OutputStream)this.Code);
            this.Code = null;
            this.Code = null;
            this.Code = null;
            this.Code = 0;
        }
    }
}
