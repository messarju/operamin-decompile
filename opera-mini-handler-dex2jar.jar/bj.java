import java.io.EOFException;
import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

abstract class bj extends Thread
{
    protected String Code;
    protected boolean I;
    private int Z;
    
    bj(final String code, final int n) {
        this.Code = code;
        this.Z = u.J(n);
        u.Code(this);
    }
    
    protected static String I(int i) {
        if (i == 0) {
            return null;
        }
        final StringBuffer sb = new StringBuffer();
        final int n = u.Z.n(i);
        u.Z.Code(i, n);
        p z;
        int[] j;
        p z2;
        p z3;
        int[] k;
        p z4;
        for (i = 0; i < n / 2; ++i) {
            if (sb.length() != 0) {
                sb.append('\n');
            }
            z = u.Z;
            j = u.Z.I;
            z2 = u.Z;
            sb.append(z.f(j[i * 2 + 0]));
            sb.append(':');
            z3 = u.Z;
            k = u.Z.I;
            z4 = u.Z;
            sb.append(z3.f(k[i * 2 + 0 + 1]));
        }
        return sb.toString();
    }
    
    protected int Code(final Exception ex) {
        return 0;
    }
    
    public void Code() {
        this.I = true;
    }
    
    protected final void Code(final int n) {
        if (this.Z != 0) {
            u.I.I(u.B(this.Z), n);
        }
    }
    
    protected void Code(final int n, String s) {
        if (u.Code.p()) {
            return;
        }
        u.I.h();
        if (this.I) {
            u.I.i();
            return;
        }
        final p z = u.Z;
        final p z2 = u.Z;
        if (s == null) {
            s = "Unspecified error";
        }
        z.b(z2.Code(s));
        u.Z.c(n);
        this.Code(14);
    }
    
    protected void Code(final DataInputStream dataInputStream) {
        final byte[] array = new byte[2048];
        while (true) {
            if (this.I) {
                return;
            }
            int read;
            while (true) {
                try {
                    read = dataInputStream.read(array);
                    u.I.h();
                    if (this.I) {
                        u.I.i();
                        return;
                    }
                }
                catch (EOFException ex) {
                    read = -1;
                    continue;
                }
                break;
            }
            if (read <= 0) {
                break;
            }
            u.Z.b(u.Z.I(array, 0, read));
            u.Z.c(0);
            u.Z.c(read);
            this.Code(12);
        }
        this.Code(13);
    }
    
    protected String I(final Exception ex) {
        final String message = ex.getMessage();
        if (message != null) {
            return message;
        }
        return ex.toString();
    }
    
    protected abstract void I();
    
    @Override
    public void run() {
        while (true) {
            try {
                this.I();
                u.C(this.Z);
                u.I(this);
            }
            catch (Exception ex) {
                if (!this.I) {
                    this.Code(this.Code(ex), this.I(ex));
                }
                continue;
            }
            break;
        }
    }
}
