import java.io.DataInput;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class l extends h
{
    private int B;
    public byte Code;
    public byte I;
    public int J;
    public boolean Z;
    
    public l() {
        this.B = -1;
        this.I = 0;
        this.Code = 0;
        this.J = 0;
    }
    
    public l(final int b, final byte code, final boolean z, final byte i, final int j) {
        this.B = b;
        this.Code = code;
        this.Z = z;
        this.I = i;
        this.J = j;
    }
    
    @Override
    public final byte Code() {
        return 2;
    }
    
    @Override
    public final int Code(final DataInput dataInput, int unsignedByte) {
        this.B = dataInput.readInt() + unsignedByte;
        unsignedByte = dataInput.readUnsignedByte();
        this.Code = (byte)(unsignedByte & 0x7);
        this.Z = ((unsignedByte & 0x8) == 0x0);
        this.I = (byte)((unsignedByte & 0x70) >> 4);
        this.J = dataInput.readInt();
        return this.B;
    }
    
    public final int I() {
        return this.B;
    }
}
