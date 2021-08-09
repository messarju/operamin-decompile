import java.io.DataInput;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class m extends h
{
    public boolean B;
    public int C;
    public int[] Code;
    public byte I;
    public boolean J;
    public byte Z;
    
    public m() {
        this.Code = null;
        this.Z = 0;
        this.I = 0;
        this.C = 0;
    }
    
    @Override
    public final byte Code() {
        return 4;
    }
    
    @Override
    public final int Code(final DataInput dataInput, int i) {
        final int n = 1;
        final int unsignedByte = dataInput.readUnsignedByte();
        this.I = (byte)(unsignedByte & 0x7);
        this.J = ((unsignedByte & 0x8) == 0x0);
        this.Z = (byte)((unsignedByte & 0x70) >> 4);
        this.B = ((unsignedByte & 0x80) == 0x0);
        this.C = dataInput.readInt();
        final short short1 = dataInput.readShort();
        (this.Code = new int[short1])[0] = dataInput.readInt() + i;
        for (i = n; i < short1; ++i) {
            this.Code[i] = dataInput.readInt() + this.Code[i - 1];
        }
        return this.Code[0];
    }
    
    @Override
    protected final int I() {
        return -1;
    }
}
