import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

abstract class br extends bk
{
    br(final String s, final String s2, final String s3, final int n) {
        super(s, 0, s2, s3, true, 0, 0, n);
    }
    
    protected abstract boolean Code(final String p0, final String p1);
    
    @Override
    protected final void I(final DataInputStream dataInputStream) {
        boolean b = true;
        if (dataInputStream.readByte() != 1) {
            this.Code(0, "Unknown version");
        }
        else {
            final int unsignedShort = dataInputStream.readUnsignedShort();
            dataInputStream.readUTF();
            final String utf = dataInputStream.readUTF();
            if (unsignedShort != 200) {
                this.Code(unsignedShort, utf);
                b = false;
            }
            if (b) {
                for (int i = dataInputStream.readUnsignedShort(); i > 0; --i) {
                    this.Code(dataInputStream.readUTF(), dataInputStream.readUTF());
                }
                final byte byte1 = dataInputStream.readByte();
                if (byte1 == 0) {
                    this.Code(dataInputStream);
                    return;
                }
                if (byte1 == 6) {
                    this.Code(0, dataInputStream.readUTF());
                    return;
                }
                this.Code(0, "Bad data");
            }
        }
    }
}
