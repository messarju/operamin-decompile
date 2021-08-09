// 
// Decompiled by Procyon v0.6-prerelease
// 

final class cf
{
    final int B;
    final String Code;
    final String I;
    final String J;
    final int Z;
    
    cf(final String code, final String i, final int z, final String j, final int b) {
        this.Code = code;
        this.I = i;
        this.Z = z;
        this.J = j;
        this.B = b;
    }
    
    @Override
    public final String toString() {
        return "{" + this.Code + ", " + this.I + ", " + this.Z + ", " + this.J + "} -> slot " + this.B;
    }
}
