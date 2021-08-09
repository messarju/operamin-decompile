import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class bt extends br
{
    int B;
    String C;
    int J;
    byte[] a;
    private String b;
    
    bt(final String s, final String s2) {
        super(s + "/res/7.6.40234/" + s2, null, null, 1);
    }
    
    @Override
    protected final void Code(final int n, final String b) {
        this.b = b;
        this.J = -1;
    }
    
    @Override
    protected final void Code(final DataInputStream dataInputStream) {
        if (this.J > 0) {
            final byte[] array = new byte[1024];
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this.J);
            while (this.B < this.J) {
                final int read = dataInputStream.read(array);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(array, 0, read);
                this.B += read;
            }
            this.a = byteArrayOutputStream.toByteArray();
        }
        else if (this.b == null) {
            this.Code(0, "Invalid content length");
        }
    }
    
    @Override
    protected final boolean Code(final String s, final String c) {
        if (s.equals("content-length")) {
            this.J = Integer.parseInt(c);
        }
        else if (s.equals("update-digest")) {
            this.C = c;
        }
        return true;
    }
}
