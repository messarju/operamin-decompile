// 
// Decompiled by Procyon v0.6-prerelease
// 

final class aj
{
    static byte[] c;
    static long d;
    static boolean e;
    byte[] B;
    byte[] C;
    final int[] Code;
    long I;
    int[] J;
    int[] Z;
    byte[] a;
    byte[] b;
    private bm f;
    private int g;
    
    static {
        aj.c = new byte[0];
    }
    
    public aj(final int[] code) {
        this.f = new bm();
        this.C = new byte[0];
        this.a = new byte[8];
        this.b = new byte[32];
        this.Code = code;
    }
    
    private boolean Code(final long n) {
        return this.I < n || this.I - 1814400000L > n;
    }
    
    final int Code(final bx bx) {
        synchronized (this) {
            int n;
            if (this.B == null) {
                n = -1;
            }
            else {
                final byte[] i = bx.I;
                i[0] = (byte)(this.g >> 16);
                i[1] = (byte)(this.g & 0xFF);
                this.f.I(i, 2);
                this.f.Z(i, 0);
                (bx.J = new ax(i, 0, 32)).Code(this.a, 0, 8);
                this.f.Z(i, 0);
                (bx.B = new ax(i, 0, 32)).Code(this.a, 0, 8);
                this.f.Z(i, 0);
                (bx.C = new bq(i)).Code(i, 0, 1024);
                this.f.Z(i, 0);
                (bx.a = new bq(i)).Code(i, 0, 1024);
                n = this.g++;
            }
            return n;
        }
    }
    
    final void Code() {
        synchronized (this) {
            this.J = null;
            this.Z = null;
            this.B = null;
            System.arraycopy(this.b, 0, this.a, 0, 8);
        }
    }
    
    final boolean I() {
        if (cg.D) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (this.Code(currentTimeMillis) && this.Code(currentTimeMillis - aj.d)) {
                return true;
            }
        }
        return false;
    }
    
    final void Z() {
        while (true) {
            final int n = 2;
            final int n2 = 0;
            Label_0232: {
                byte[] code = null;
                Label_0102: {
                    synchronized (this) {
                        if (this.I() || this.J == null) {
                            this.Code();
                        }
                        else {
                            if (this.Z == null) {
                                break Label_0232;
                            }
                            final bv bv = new bv();
                            code = cg.Code(w.Code(this.Z, this.Code));
                            if (code[0] == 0 && code[1] == 1 && code[code.length - 32 - 1] == 0) {
                                break Label_0102;
                            }
                            this.Code();
                        }
                        return;
                    }
                }
                for (int i = 2; i < code.length - 32 - 2; ++i) {
                    if (code[i] != -1) {
                        this.Code();
                        return;
                    }
                }
                final bv bv2;
                bv2.Code((int)(this.I >> 32));
                bv2.Code((int)this.I);
                bv2.Code(cg.Code(this.J), 0, this.J.length * 4);
                bv2.Code(code);
                for (int j = n2; j < 32; ++j) {
                    if (code[j] != code[code.length + j - 32]) {
                        this.Code();
                        return;
                    }
                }
                this.Z = null;
                if (cg.K[1] != null) {
                    cg.a("md");
                }
            }
            if (this.B == null) {
                final bm k = cg.I(this.b);
                final byte[] code = new byte[this.J.length * 4];
                for (int l = n; l < code.length - 32; ++l) {
                    while (code[l] == 0) {
                        k.Z(code, l);
                    }
                }
                code[0] = 0;
                code[1] = 2;
                code[code.length - 32 - 1] = 0;
                k.Z(code, code.length - 32);
                this.f.Code(code, code.length - 32);
                k.Code(code, code.length - 32);
                this.B = cg.Code(w.Code(cg.Code(code, 0, code.length), this.J));
                this.g = 0;
            }
        }
    }
}
