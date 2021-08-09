import java.io.DataInput;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class n extends h
{
    public int Code;
    public byte[] I;
    
    public n() {
        this.Code = -1;
    }
    
    @Override
    public final byte Code() {
        return 0;
    }
    
    @Override
    public final int Code(final DataInput dataInput, final int n) {
        this.Code = dataInput.readInt();
        dataInput.readFully(this.I = new byte[4]);
        return 0;
    }
    
    public final int I() {
        return -1;
    }
}
