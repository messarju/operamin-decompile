// 
// Decompiled by Procyon v0.6-prerelease
// 

final class bb implements Runnable
{
    private boolean B;
    private al C;
    private int Code;
    private boolean I;
    private int J;
    private al[] Z;
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    
    bb() {
        this.Z = new al[10];
        cg.Code(this);
    }
    
    private void Z() {
        synchronized (this) {
            while (this.Code > 0 || (this.J == 0 && this.C == null)) {
                this.wait();
            }
        }
        this.I = false;
        if (this.J > 0 && (this.B || this.C == null)) {
            this.C = this.Z[0];
            final al[] z = this.Z;
            final al[] z2 = this.Z;
            final int j = this.J - 1;
            this.J = j;
            z[0] = z2[j];
            this.Z[this.J] = null;
            this.B = false;
        }
        monitorexit(this);
    }
    
    final void Code() {
        synchronized (this) {
            ++this.Code;
        }
    }
    
    final void Code(final int b, final int c, final int d, final int g, final int h, final int f, final int e, final boolean i) {
        this.a = true;
        this.b = b;
        this.c = c;
        this.d = d;
        this.g = g;
        this.h = h;
        this.e = e;
        this.f = f;
        this.i = i;
    }
    
    final void Code(final al al) {
        int i = 0;
        synchronized (this) {
            while (i < this.J) {
                if (this.Z[i] == al) {
                    final al[] z = this.Z;
                    final al[] z2 = this.Z;
                    final int j = this.J - 1;
                    this.J = j;
                    z[i] = z2[j];
                    this.Z[this.J] = null;
                    if (i == 0) {
                        this.B = false;
                        break;
                    }
                    break;
                }
                else {
                    ++i;
                }
            }
        }
    }
    
    final void I() {
        synchronized (this) {
            --this.Code;
            if (this.Code == 0 && this.I) {
                this.notify();
            }
        }
    }
    
    final void I(final al al) {
        synchronized (this) {
            if (!this.B) {
                int n;
                for (n = 0; n < this.J && this.Z[n] != al; ++n) {}
                if (n == this.J) {
                    if (this.J == this.Z.length) {
                        this.Z[this.J - 1] = al;
                    }
                    else {
                        this.Z[this.J++] = al;
                    }
                }
            }
            this.I = true;
            if (this.Code == 0) {
                this.notify();
            }
        }
    }
    
    final void Z(final al al) {
        int i = 1;
        synchronized (this) {
            this.Z[0] = al;
            while (i < this.J) {
                this.Z[i] = null;
                ++i;
            }
            this.J = 1;
            this.B = true;
            this.I = true;
            if (this.Code == 0) {
                this.notify();
            }
        }
    }
    
    @Override
    public final void run() {
        Thread.currentThread().setPriority(1);
    Label_0007_Outer:
        while (true) {
            while (true) {
                Label_0081: {
                    try {
                        while (true) {
                            this.Z();
                            this.a = false;
                            this.C.J();
                            if (!this.a) {
                                break Label_0081;
                            }
                            this.C.Code(this.b, this.c, this.d, this.f, this.e, this.g, this.h, this.i);
                        }
                    }
                    catch (Throwable t) {
                        this.C = null;
                        continue Label_0007_Outer;
                    }
                    continue;
                }
                this.C = null;
                continue;
            }
        }
    }
}
