import java.io.EOFException;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class g
{
    private Vector Code;
    
    public g() {
        this.Code = new Vector();
    }
    
    private void Code(final h h) {
        for (int i = this.Code.size(); i > 0; --i) {
            final int code = h.Code(this.Code.elementAt(i - 1));
            if (code == 0) {
                this.Code.insertElementAt(h, i);
                return;
            }
            if (code > 0) {
                this.Code.insertElementAt(h, i);
                return;
            }
        }
        this.Code.insertElementAt(h, 0);
    }
    
    public final Vector Code() {
        return this.Code;
    }
    
    public final void Code(final InputStream inputStream) {
        this.Code.removeAllElements();
        final f f = new f(inputStream);
        if (f.readByte() != 69 || f.readByte() != 80) {
            throw new IOException();
        }
        int code = 0;
        int n = 0;
        while (true) {
            while (true) {
                Label_0290: {
                    try {
                        while (true) {
                            h h = null;
                            switch (f.readByte()) {
                                default: {
                                    throw new IOException();
                                }
                                case 0: {
                                    if (n != 0) {
                                        throw new IOException();
                                    }
                                    h = new n();
                                    break;
                                }
                                case 1: {
                                    h = new k();
                                    break;
                                }
                                case 2: {
                                    h = new l();
                                    break;
                                }
                                case 4: {
                                    h = new m();
                                    break;
                                }
                            }
                            code = h.Code(f, code);
                            if (h instanceof m) {
                                final m m = (m)h;
                                for (int i = 0; i < m.Code.length; ++i) {
                                    final int n2 = m.Code[i];
                                    final byte j = m.I;
                                    final boolean k = m.J;
                                    final byte z = m.Z;
                                    final boolean b = m.B;
                                    this.Code(new l(n2, j, k, z, m.C));
                                }
                            }
                            else {
                                if (!(h instanceof n)) {
                                    break Label_0290;
                                }
                                n = 1;
                                this.Code(h);
                            }
                        }
                    }
                    catch (EOFException ex) {
                        if (n == 0) {
                            throw new IOException();
                        }
                        return;
                    }
                }
                continue;
            }
        }
    }
}
