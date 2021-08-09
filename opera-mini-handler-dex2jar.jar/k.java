import java.io.DataInput;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class k extends h
{
    public int Code;
    public int I;
    private int J;
    public byte[] Z;
    
    public k() {
        this.J = -1;
        this.Code = -1;
        this.I = -1;
    }
    
    @Override
    public final byte Code() {
        return 1;
    }
    
    @Override
    public final int Code(final DataInput dataInput, int n) {
        this.J = dataInput.readInt() + n;
        this.Code = dataInput.readUnsignedShort();
        this.I = dataInput.readUnsignedShort();
        if (this.Code > this.I) {
            n = this.Code;
        }
        else {
            n = this.I;
        }
        dataInput.readFully(this.Z = new byte[n]);
        return this.J;
    }
    
    public final int I() {
        return this.J;
    }
}
