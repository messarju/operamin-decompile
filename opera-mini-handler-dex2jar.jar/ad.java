import java.io.IOException;
import java.io.DataOutputStream;
import java.io.OutputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class ad extends OutputStream
{
    private ak Code;
    private DataOutputStream I;
    private int J;
    private String Z;
    
    private ad() {
    }
    
    public static ad Code(final int j, final String z) {
        final ad ad = new ad();
        ad.Code = new ak();
        ad.I = new DataOutputStream(ad.Code);
        ad.Z = z;
        ad.J = j;
        return ad;
    }
    
    public static ad Code(final OutputStream outputStream) {
        final ad ad = new ad();
        ad.Code = new ak();
        ad.I = new DataOutputStream(outputStream);
        return ad;
    }
    
    final void Code(final int n) {
        this.I.writeByte(n);
    }
    
    final void Code(final long n) {
        this.I.writeLong(n);
    }
    
    final void I(final int n) {
        this.I.writeShort(n);
    }
    
    final void Z(final int n) {
        this.I.writeInt(n);
    }
    
    @Override
    public final void close() {
        try {
            final String a = u.a(this.J);
            this.Z = u.Code(this.J, this.Z);
            bs.Code.Code(a, this.Z, this.Code.Code(), this.Code.size());
        }
        catch (IOException ex) {}
        finally {
            cg.Code(this.I);
            this.I = null;
            this.Code = null;
            this.Z = null;
            this.J = 0;
        }
    }
    
    @Override
    public final void flush() {
        this.I.flush();
    }
    
    @Override
    public final void write(final int n) {
        this.I.write(n);
    }
    
    @Override
    public final void write(final byte[] array) {
        this.I.write(array);
    }
    
    @Override
    public final void write(final byte[] array, final int n, final int n2) {
        this.I.write(array, n, n2);
    }
}
