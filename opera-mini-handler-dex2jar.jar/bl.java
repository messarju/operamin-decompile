import java.io.InputStream;
import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class bl
{
    int[] Code;
    int[] I;
    public boolean Z;
    
    public final void Code(final DataInputStream dataInputStream) {
        cg.Code((InputStream)dataInputStream, dataInputStream.readShort());
        final short short1 = dataInputStream.readShort();
        this.Code = new int[short1];
        this.I = new int[short1];
        int n = short1 * 6 - 6;
        for (int i = 0; i < short1; ++i) {
            dataInputStream.readShort();
            this.I[i] = dataInputStream.readInt();
            this.Code[i] = n;
            n += this.I[i] - 6;
        }
        this.Z = true;
    }
}
