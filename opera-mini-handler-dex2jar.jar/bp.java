import java.io.DataInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class bp extends bk
{
    private static Object B;
    private static int J;
    private boolean C;
    
    static {
        bp.J = Integer.MIN_VALUE;
        bp.B = new Object();
    }
    
    bp(final String s, final int n, final int n2) {
        super(s, n, n2, null, true, 0, 0);
    }
    
    static void Z(final int j) {
        if (j <= bp.J) {
            return;
        }
        bp.J = j;
        synchronized (bp.B) {
            bp.B.notifyAll();
        }
    }
    
    @Override
    public final void Code() {
        super.Code();
        synchronized (bp.B) {
            bp.B.notifyAll();
        }
    }
    
    @Override
    protected final void Code(final DataInputStream dataInputStream) {
        Object b = new byte[2048];
        Block_6: {
            while (true) {
            Label_0080_Outer:
                while (true) {
                    while (true) {
                        Label_0152: {
                            Label_0178: {
                                Label_0100: {
                                    if (!this.I) {
                                        final int read = dataInputStream.read((byte[])b);
                                        u.I.h();
                                        if (this.I) {
                                            u.I.i();
                                            break;
                                        }
                                        if (read >= 0) {
                                            break Label_0100;
                                        }
                                        u.I.i();
                                    }
                                    if (this.I) {
                                        break;
                                    }
                                    if (this.Z.r()) {
                                        break Label_0152;
                                    }
                                    try {
                                        b = bp.B;
                                        synchronized (b) {
                                            bp.B.wait();
                                            monitorexit(b);
                                            u.I.h();
                                            if (this.I) {
                                                u.I.i();
                                                return;
                                            }
                                            break Label_0178;
                                            continue Label_0080_Outer;
                                            final int read;
                                            u.Z.b(u.Z.I((byte[])b, 0, read));
                                            u.Z.c(0);
                                            u.Z.c(read);
                                            this.Code(12);
                                            iftrue(Label_0006:)(!this.C);
                                        }
                                    }
                                    catch (InterruptedException ex) {
                                        return;
                                    }
                                }
                                break Label_0152;
                            }
                            this.Code(16);
                            continue Label_0080_Outer;
                        }
                        final int read2 = dataInputStream.read();
                        if (read2 < 0) {
                            break Block_6;
                        }
                        if (read2 == 0) {
                            continue;
                        }
                        break;
                    }
                    continue Label_0080_Outer;
                }
            }
            return;
        }
        this.Code(504, "Server closed connection");
    }
    
    public final void Z() {
        this.C = true;
    }
}
