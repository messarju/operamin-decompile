// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class bu
{
    public final int B;
    public final String C;
    public final int Code;
    public final int I;
    public final int J;
    public final String Z;
    public final String a;
    
    bu(final int code, final int i, final String z, final int j, final int b, final String c, final String a) {
        this.Code = code;
        this.I = i;
        this.Z = z;
        this.J = j;
        this.B = b;
        this.C = c;
        this.a = a;
    }
    
    final boolean Code() {
        return (this.I & 0x1) != 0x0;
    }
    
    final boolean I() {
        return this.B == 0;
    }
    
    public final String Z() {
        return this.a + this.C.substring(0, 8);
    }
    
    @Override
    public final String toString() {
        final StringBuilder append = new StringBuilder("{slot: ").append(this.Code).append(", flags: ").append(Integer.toBinaryString(this.I)).append(", domain: ").append(this.Z).append(":").append(this.J).append("/").append(this.B).append(", key: ");
        String substring;
        if (this.C == null || this.C.length() == 0) {
            substring = "<none>";
        }
        else {
            substring = this.C.substring(0, 8);
        }
        final StringBuilder append2 = append.append(substring).append("...");
        String string;
        if (this.a.equals(this.Z)) {
            string = "";
        }
        else {
            string = ", clusterDomain: " + this.a;
        }
        return append2.append(string).append("}").toString();
    }
}
