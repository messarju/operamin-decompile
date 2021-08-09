import java.io.IOException;
import java.util.Vector;
import java.util.Enumeration;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class aq
{
    private Enumeration B;
    private ar C;
    Vector Code;
    private ap I;
    private String J;
    private String Z;
    private int a;
    
    public aq(final ap i, String code, final String j) {
        this.a = 0;
        code = ap.Code(code);
        this.I = i;
        this.Z = code;
        this.J = j;
        this.Z();
    }
    
    private static void Code(final Vector vector, final Object o) {
        final String lowerCase = ((String)((Object[])o)[2]).toLowerCase();
        int n = vector.size() - 1;
        if (n < 0 || lowerCase.compareTo(((String)((Object[])vector.lastElement())[2]).toLowerCase()) >= 0) {
            vector.addElement(o);
            return;
        }
        while (n > 0 && lowerCase.compareTo(((String)((Object[])vector.elementAt(n - 1))[2]).toLowerCase()) < 0) {
            --n;
        }
        vector.insertElementAt(o, n);
    }
    
    private void Z() {
        final int n = 0;
        this.a = 0;
        this.Z = cg.Z(this.Z);
        if (this.Z.equals("file:///") || this.Z.equals("file://localhost/")) {
            this.Code = new Vector();
            final at[] b = this.I.B();
            for (int i = 0; i < b.length; ++i) {
                if (b[i] != null) {
                    Code(this.Code, new Object[] { b[i].I(), new Integer(7), b[i].Code(), null });
                }
            }
            return;
        }
        while (true) {
            try {
                this.C = u.c.Code(this.Z, false, 1);
                this.B = this.C.Code(this.J);
                cg.Code(this.C);
                if (this.B == null) {
                    return;
                }
            }
            catch (IOException ex) {
                cg.Code(this.C);
                continue;
            }
            finally {
                cg.Code(this.C);
            }
            break;
        }
        this.Code = new Vector();
        final Vector<Object> code = new Vector<Object>();
        int j;
        while (true) {
            j = n;
            if (!this.B.hasMoreElements()) {
                break;
            }
            final String s = this.B.nextElement();
            int n2;
            if (s.endsWith("/")) {
                n2 = 4;
            }
            else {
                n2 = 0;
            }
            final int n3 = n2 | 0x3;
            Vector<Object> code2;
            if ((n3 & 0x4) == 0x0) {
                code2 = this.Code;
            }
            else {
                code2 = code;
            }
            Code(code2, new Object[] { this.Z + s, new Integer(n3), s, null });
        }
        while (j < this.Code.size()) {
            code.addElement(this.Code.elementAt(j));
            ++j;
        }
        this.Code = code;
    }
    
    public final boolean Code() {
        return this.Code != null && this.a < this.Code.size();
    }
    
    public final Object[] I() {
        if (!this.Code()) {
            return null;
        }
        return this.Code.elementAt(this.a++);
    }
}
