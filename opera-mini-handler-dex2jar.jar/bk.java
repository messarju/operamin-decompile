import java.io.InputStream;
import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

class bk extends bj
{
    private String B;
    private boolean C;
    private String J;
    protected by Z;
    private int a;
    private int b;
    private int c;
    
    bk(final String s, final int n, final int n2, final String s2, final boolean b, final int n3, final int n4) {
        this(s, n, bj.I(n2), s2, b, n3, n4, 0);
    }
    
    bk(final String s, final int n, final String j, final String b, final boolean c, final int c2, final int a, final int b2) {
        super(s, n);
        this.J = j;
        this.B = b;
        this.C = c;
        this.a = a;
        this.c = c2;
        this.b = b2;
    }
    
    @Override
    protected final int Code(final Exception ex) {
        if (this.Z != null && this.Z.k()) {
            return this.Z.m();
        }
        return super.Code(ex);
    }
    
    protected void Code(final Object[] array, final int[] array2) {
        final int n = 1;
        if (this.J == null) {
            this.J = "";
        }
        array[64] = this.J.getBytes();
        int n2;
        if (this.C) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        array2[65] = n2;
        int n3 = n;
        if (this.B != null) {
            n3 = 3;
        }
        array2[29] = n3;
        array[42] = this.B;
        array2[37] = this.a;
        array[53] = this.Code;
        array2[93] = this.c;
        array[97] = u.Code.aq();
    }
    
    @Override
    protected final String I(final Exception ex) {
        if (this.Z != null && this.Z.k()) {
            switch (this.Z.m()) {
                case 0: {
                    return "Unknown error";
                }
                case 1: {
                    return "Key expired";
                }
                case 2: {
                    return "Timeout";
                }
            }
        }
        return super.I(ex);
    }
    
    @Override
    protected final void I() {
        final Object[] array = new Object[127];
        final int[] array2 = new int[127];
        this.Code(array, array2);
        Label_0070: {
            if (this.b == 0) {
                break Label_0070;
            }
            int n = this.b;
            while (true) {
                this.Z = bx.Code(array, array2, n, true);
                try {
                    if (!this.I) {
                        this.I(new DataInputStream(this.Z));
                    }
                    return;
                    n = ce.Code(this.Code, null);
                }
                finally {
                    cg.Code(this.Z);
                }
            }
        }
    }
    
    protected void I(final DataInputStream dataInputStream) {
        u.I.h();
        if (this.I) {
            u.I.i();
            return;
        }
        u.Z.c(-1);
        u.Z.b(0);
        u.Z.b(0);
        this.Code(11);
        this.Code(dataInputStream);
    }
    
    @Override
    public void run() {
        cg.J();
        super.run();
    }
}
