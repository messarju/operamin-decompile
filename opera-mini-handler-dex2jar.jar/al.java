import java.util.Enumeration;
import java.io.EOFException;
import java.util.Map;
import java.util.HashMap;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.DataInput;
import java.util.Vector;
import java.util.Hashtable;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class al
{
    private static az[] aC;
    private static int[] aD;
    private static az[] aE;
    private static final char[] aw;
    private static final bb az;
    private boolean A;
    private boolean B;
    private boolean C;
    final bh Code;
    private boolean D;
    private int[] E;
    private boolean F;
    private boolean G;
    private int H;
    al I;
    int J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private boolean S;
    private int[] T;
    private int U;
    private boolean V;
    private boolean W;
    private int X;
    private int Y;
    am Z;
    private int a;
    private am aA;
    private boolean aB;
    private Hashtable aF;
    private int aG;
    private int aH;
    private int aI;
    private int aJ;
    private int aK;
    private ca aL;
    private int aa;
    private int ab;
    private int[] ac;
    private int[] ad;
    private Hashtable ae;
    private Hashtable af;
    private Hashtable ag;
    private int ah;
    private byte[] ai;
    private int aj;
    private int ak;
    private Hashtable al;
    private Vector am;
    private String an;
    private String ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private int at;
    private int au;
    private int av;
    private int ax;
    private boolean ay;
    private boolean b;
    private String c;
    private long d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;
    private String j;
    private String k;
    private int l;
    private int m;
    private byte[] n;
    private int o;
    private boolean p;
    private int q;
    private int r;
    private byte s;
    private int t;
    private int u;
    private int[] v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    
    static {
        aw = new char[512];
        az = new bb();
        al.aC = new az[1];
        al.aD = new int[3];
        al.aE = new az[1];
    }
    
    al(final bh code, final al i, final boolean b, final boolean c) {
        this.r = 0;
        this.u = 1;
        this.v = null;
        this.w = false;
        this.E = new int[5];
        this.al = new Hashtable();
        this.am = new Vector();
        this.aA = new am();
        this.aB = true;
        this.aF = null;
        if (i != null) {
            this.I = i;
            this.Z = i.aA;
        }
        this.Code = code;
        this.B = b;
        this.C = c;
        this.a = code.k();
        if (i != null && this.a != i.a) {
            i.I(true);
        }
    }
    
    private int A() {
        this.av += 2;
        return this.I(this.av - 2);
    }
    
    private static int A(final int n) {
        final int n2 = u.Z.q(n) - 2;
        u.Z.Code(n, 2, n2, true);
        return n2;
    }
    
    private int B(final int n, final int n2, final int n3) {
        this.T[n + 0] = n2;
        this.T[n + 1] = n3;
        this.T[n + 2] = this.at;
        this.T[n + 3] = this.au;
        return n;
    }
    
    private native void B(final int p0, final int p1, final int p2, final int p3);
    
    private void B(final boolean b) {
        if (b) {
            this.Code.a();
        }
        if (this.Code.C() == 0) {
            u.I.i();
            return;
        }
        this.V = false;
        u.Z.o(this.U + 2);
        final p z = u.Z;
        for (int n = 2, i = 0; i < this.U; ++i, ++n) {
            final int n2 = this.T[i * 5 + 4];
            final int[] j = u.Z.I;
            int n3;
            if ((n2 & 0x1) != 0x0) {
                n3 = Integer.MIN_VALUE;
            }
            else {
                n3 = 0;
            }
            int n4;
            if ((n2 & 0x2) != 0x0) {
                n4 = 1073741824;
            }
            else {
                n4 = 0;
            }
            j[n] = (n4 | n3);
        }
        u.Z.b(u.Z.o());
        u.I.I(this.Code.C(), 23);
    }
    
    private int C(final int n, final int n2, final int n3) {
        if (n <= n3) {
            return n;
        }
        return (n - n3) * this.x / n2 + n3;
    }
    
    private int Code(int i, final char c) {
        synchronized (this) {
            this.av = i + 1;
            this.av += this.D() * 10;
            this.av += this.A();
            for (i = this.D(); i > 0; --i) {
                if (this.D() == c) {
                    i = this.av;
                    return i;
                }
                this.av += this.A();
            }
            i = 0;
            return i;
        }
    }
    
    static int Code(final DataInput dataInput) {
        return dataInput.readUnsignedByte() << 16 | dataInput.readUnsignedShort();
    }
    
    private static int Code(final Hashtable hashtable, final String s) {
        int n = -1;
        int n2 = 0;
    Label_0076_Outer:
        while (true) {
            int n3;
            if ((n3 = s.indexOf(0, n2)) < 0) {
                n3 = s.length();
            }
            while (true) {
                try {
                    final int int1 = Integer.parseInt(s.substring(n2, n3));
                    final Integer n4 = new Integer(int1);
                    hashtable.put(n4, n4);
                    int n5;
                    if (int1 < n || (n5 = n) < 0) {
                        n5 = int1;
                    }
                    n2 = n3 + 1;
                    n = n5;
                    if (n3 >= s.length()) {
                        return n5;
                    }
                    continue Label_0076_Outer;
                }
                catch (Exception ex) {
                    final int n5 = n;
                    continue;
                }
                break;
            }
        }
    }
    
    private static int Code(final byte[] array, final int n) {
        return ((array[n] & 0xFF) << 16) + ((array[n + 1] & 0xFF) << 8) + (array[n + 2] & 0xFF);
    }
    
    private static int Code(final byte[] array, final int n, final int n2) {
        if (n2 >= 2) {
            final int z = q.Z(array, n);
            if (z + 2 <= n2 && cg.I(array, n + 2, z)) {
                return z + 2;
            }
        }
        return -1;
    }
    
    private static int Code(char[] array, int n, final int n2, final int n3) {
        int i = 0;
        int n4 = 0;
        while (i < n) {
            int n5 = 0;
            int n7 = 0;
            Label_0034: {
                if (array[i] == '\n') {
                    n5 = i;
                    final int n6 = 0;
                    n7 = n;
                    n = n6;
                }
                else if (n4 == 0 || array[i] == ' ') {
                    int n8;
                    for (n8 = 1; i + n8 < n && array[i + n8] != ' ' && array[i + n8] != '\n'; ++n8) {}
                    final int code = cg.Code(n2, array, i, n8);
                    int n9 = n4 + code;
                    if (n9 > n3) {
                        if (code <= n3) {
                            array[i] = '\n';
                            n9 = code;
                        }
                        else {
                            if (array[i] == ' ') {
                                array[i] = '\n';
                            }
                            final int code2 = cg.Code(n2, array, i, n8, n3);
                            if (code2 != 0) {
                                if (n == array.length) {
                                    final char[] array2 = new char[array.length + 10];
                                    System.arraycopy(array, 0, array2, 0, n);
                                    array = array2;
                                }
                                n5 = i + code2;
                                System.arraycopy(array, n5, array, n5 + 1, n - n5);
                                array[n5] = '\n';
                                n7 = n + 1;
                                n = 0;
                                break Label_0034;
                            }
                            n9 = 0;
                        }
                    }
                    final int n10 = n9;
                    n5 = n8 - 1 + i;
                    n7 = n;
                    n = n10;
                }
                else {
                    final int n11 = n4;
                    final int n12 = n;
                    n5 = i;
                    n = n11;
                    n7 = n12;
                }
            }
            final int n13 = n7;
            i = n5 + 1;
            n4 = n;
            n = n13;
        }
        return n;
    }
    
    private int Code(final int[] array, final int n, final int n2) {
        final int z = this.Z(array, 0, n, n2);
        if (z >= n) {
            return this.y;
        }
        return this.T[z * 5 + 0] + n2 - (array[z + 0] & 0xFFFFFF);
    }
    
    static al Code(final Object o) {
        return (al)((Object[])o)[0];
    }
    
    private az Code(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        az[] ac = al.aC;
        int n8;
        if (!this.aA.I(cg.b * 256)) {
            ac = null;
            n8 = 0;
        }
        else {
            n8 = 0;
        }
    Label_0028:
        while (true) {
            while (true) {
                Label_0208: {
                    if (n8 > 2) {
                        break Label_0208;
                    }
                    while (true) {
                        while (true) {
                            Label_0202: {
                                try {
                                    final az code = this.Code(n2, n3, n4, n5, n6, n7, ac);
                                    if (code != null && this.aA.I(1)) {
                                        final am aa = this.aA;
                                        if (n3 != 256) {
                                            break Label_0202;
                                        }
                                        final boolean b = true;
                                        if (!aa.Code(n, b, code, al.aC[0])) {
                                            this.J(false);
                                        }
                                    }
                                    al.aC[0] = null;
                                    return code;
                                }
                                catch (Throwable t) {
                                    al.aC[0] = null;
                                    ac = null;
                                    if (n8 <= 1) {
                                        if ((this.B || n8 > 0) && this.Z != null) {
                                            this.w();
                                        }
                                        if (n8 > 0) {
                                            this.aB = false;
                                        }
                                        if (n8 == 0) {
                                            this.J(false);
                                        }
                                        else {
                                            this.t();
                                            this.Code.Code.p();
                                        }
                                        ++n8;
                                        continue Label_0028;
                                    }
                                    break;
                                }
                            }
                            final boolean b = false;
                            continue;
                        }
                    }
                }
                final az code = null;
                continue;
            }
        }
    }
    
    private az Code(int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9) {
        while (true) {
            while (true) {
                Label_0689: {
                    while (true) {
                        az code;
                        synchronized (this) {
                            final int z = this.aA.Z(n);
                            az[] array;
                            if (n7 == 256) {
                                array = this.aA.I;
                            }
                            else {
                                array = this.aA.Z;
                            }
                            Label_0316: {
                                if (!this.aA.I(z, n)) {
                                    final am aa = this.aA;
                                    if (aa.J == aa.I.length) {
                                        aa.Code = cg.Code(aa.Code, aa.J * 2 * 6);
                                        aa.I = cg.Code(aa.I, aa.J * 2);
                                        aa.Z = cg.Code(aa.Z, aa.J * 2);
                                    }
                                    final int n10 = z * 6;
                                    System.arraycopy(aa.Code, n10, aa.Code, n10 + 6, aa.J * 6 - n10);
                                    System.arraycopy(aa.I, z, aa.I, z + 1, aa.J - z);
                                    System.arraycopy(aa.Z, z, aa.Z, z + 1, aa.J - z);
                                    ++aa.J;
                                    aa.Code[n10 + 0] = n;
                                    aa.Code[n10 + 1] = n2;
                                    aa.Code[n10 + 4] = 0;
                                    aa.I[z] = (aa.Z[z] = null);
                                    break Label_0316;
                                }
                                if (array[z] == null) {
                                    break Label_0316;
                                }
                                code = array[z];
                                return code;
                            }
                            if (this.Z != null && this.Z.Code(n, n7, this.aA, z) && array[z] != null) {
                                code = array[z];
                                return code;
                            }
                            final am aa2 = this.aA;
                            if (n8 < 0) {
                                n = 0;
                                break Label_0678;
                            }
                            break Label_0689;
                            code = this.Code(z, n2, n7, n8, n9, n3, n4);
                            return code;
                            final boolean a = this.A;
                            final int n11 = z * 6;
                            final am am;
                            iftrue(Label_0510:)(am.Code[n11 + 4] != 0);
                            Label_0443: {
                                Block_12: {
                                    break Block_12;
                                    final int n12;
                                    Label_0510: {
                                        n12 = (am.Code[n11 + 2] & 0x3FFFFFFF);
                                    }
                                    final int n13 = am.Code[n11 + 3];
                                    final int min = Math.min(n3, n12);
                                    final int min2 = Math.min(n4, n13);
                                    am.Code[n11 + 4] = (Math.max(n3 + n5, n12 + (am.Code[n11 + 4] >>> 16)) - min << 16 | Math.max(n4 + n6, n13 + (am.Code[n11 + 4] & 0xFFFF)) - min2);
                                    am.Code[n11 + 2] = (min | (am.Code[n11 + 2] & 0xC0000000));
                                    am.Code[n11 + 3] = min2;
                                    break Label_0443;
                                }
                                am.Code[n11 + 2] = n3;
                                am.Code[n11 + 3] = n4;
                                am.Code[n11 + 4] = (n5 << 16 | n6);
                            }
                            final int n14;
                            am.Code[n11 + 5] = (n14 | n << 16);
                            iftrue(Label_0672:)((this.aA.Code[z * 6 + 2] & Integer.MIN_VALUE) == 0x0 || !this.w(n2));
                            return this.Code(z, n2, n7, n8, n9, n3, n4);
                        }
                        Label_0672: {
                            code = null;
                        }
                        return code;
                        if (n9 < 0) {
                            final int n14 = 0;
                            continue;
                        }
                        final int n14 = n9;
                        continue;
                    }
                }
                n = n8;
                continue;
            }
        }
    }
    
    private az Code(final int n, final int n2, int max, int max2, int n3, final int n4, az[] array) {
        final int n5 = 0;
        if (!this.aB || max > 0 || max2 > 0) {
            array = null;
        }
        if (max <= 0 || max2 <= 0) {
            n3 = 1;
        }
        else if (n2 < 256 && n2 > 0) {
            max = Math.max(1, this.L(n3 + max) - this.L(n3));
            max2 = Math.max(1, this.L(n4 + max2) - this.L(n4));
            n3 = n5;
        }
        else {
            n3 = n5;
        }
        if (n3 != 0) {
            return u.Code.r().Code(this.ai, n + 2, q.Z(this.ai, n), n2, array, false);
        }
        return u.Code.r().Code(this.ai, n + 2, q.Z(this.ai, n), max, max2, array);
    }
    
    private cb Code(final int[] array, final int n, final int n2, final int n3) {
        final int av = this.av;
        final int ap = this.ap;
        final int aq = this.aq;
        int n4 = 0;
        Label_0028: {
            if (this.ac == null) {
                n4 = -1;
            }
            else {
                int i = 0;
                int n5 = -1;
                int n6 = Integer.MAX_VALUE;
                while (i < this.ac.length) {
                    final int n7 = this.ac[i + 0];
                    final int j = this.I(array, 2, n, this.ac[i + 1]);
                    final int n8 = this.ac[i + 2];
                    final int n9 = this.ac[i + 3];
                    n4 = i;
                    if (cg.Code(n2, n3, 1, 1, n7, j, n8, n9)) {
                        break Label_0028;
                    }
                    final int code = cg.Code(n2, n7, n7 + n8 - 1);
                    final int code2 = cg.Code(n3, j, j + n9 - 1);
                    final int n10 = n2 - code;
                    final int n11 = n3 - code2;
                    final int n12 = n10 * n10 + n11 * n11;
                    int n13;
                    int n14;
                    if (n12 < n6) {
                        n13 = i;
                        n14 = n12;
                    }
                    else {
                        n13 = n5;
                        n14 = n6;
                    }
                    i += 5;
                    n6 = n14;
                    n5 = n13;
                }
                n4 = n5;
            }
        }
        int n15 = 0;
        int k = 0;
        int x = this.x;
        int n16 = array[0];
        if (n4 >= 0) {
            n15 = this.ac[n4 + 0];
            k = this.I(array, 2, n, this.ac[n4 + 1]);
            x = this.ac[n4 + 2];
            n16 = this.ac[n4 + 3];
        }
        int n17 = 0;
        int n18 = 0;
        this.av = this.aj;
        boolean b = false;
        int n19 = Integer.MAX_VALUE;
        int n20 = Integer.MAX_VALUE;
        int n21 = 0;
        int n22 = 0;
        int n23 = -1;
        while (true) {
        Label_0696_Outer:
            while (this.av < this.ai.length) {
                final int av2 = this.av;
                final int d = this.D();
                switch (d) {
                    case 66:
                    case 70:
                    case 73:
                    case 84: {
                        this.F();
                        final int ap2 = this.ap;
                        n18 += this.aq;
                        n17 += ap2;
                        break;
                    }
                }
                while (true) {
                    Label_0737: {
                        if (d != 84 || this.z(av2)) {
                            break Label_0737;
                        }
                        final int l = this.I(array, 2, n, n18);
                        final int ar = this.ar;
                        final int as = this.as;
                        int n24;
                        if (n2 < n17) {
                            n24 = n17 - n2;
                        }
                        else if (n2 >= n17 + ar) {
                            n24 = n2 - n17 - ar + 1;
                        }
                        else {
                            n24 = 0;
                        }
                        int n25;
                        if (n3 < l) {
                            n25 = l - n3;
                        }
                        else if (n3 >= l + as) {
                            n25 = n3 - l - as + 1;
                        }
                        else {
                            n25 = 0;
                        }
                        int n26;
                        int n27;
                        int n28;
                        int n29;
                        int n30;
                        if (n24 == 0 && n25 == 0) {
                            this.ap = ap;
                            this.aq = aq;
                            this.av = av;
                            if (av2 > 0) {
                                return new cb(this, av2, n17, n18);
                            }
                            return null;
                        }
                        else {
                            final boolean code3 = cg.Code(n15, k, x, n16, n17, l, ar, as);
                            boolean b2;
                            if (n25 < n19 || (n25 == n19 && n24 < n20)) {
                                b2 = true;
                            }
                            else {
                                b2 = false;
                            }
                            if ((b || (!code3 && !b2)) && (!b || !code3 || !b2)) {
                                break Label_0737;
                            }
                            n26 = n25;
                            n27 = n24;
                            n28 = n18;
                            n29 = n17;
                            n30 = av2;
                            b = code3;
                        }
                        this.K(d);
                        final int n31 = n30;
                        n19 = n26;
                        n20 = n27;
                        n21 = n28;
                        n22 = n29;
                        n23 = n31;
                        continue Label_0696_Outer;
                    }
                    int n29 = n22;
                    final int n32 = n23;
                    int n26 = n19;
                    int n27 = n20;
                    int n28 = n21;
                    int n30 = n32;
                    continue;
                }
            }
            n17 = n22;
            n18 = n21;
            final int av2 = n23;
            continue;
        }
    }
    
    private void Code(final aw aw, final int n, final int n2) {
        final int d = this.D();
        final int d2 = this.D();
        final String h = this.H();
        final String h2 = this.H();
        final int y = this.y();
        this.A();
        if (!this.am.contains(h) && !this.Code.I.containsKey(h)) {
            String s;
            if (h.equals(this.an)) {
                s = Integer.toString(0);
            }
            else if (h.equals(this.ao)) {
                s = Integer.toString(1);
            }
            else if (this.al.containsKey(h)) {
                s = h;
            }
            else {
                s = null;
            }
            if (s != null) {
                final char c = (char)d;
                String s2;
                if (this.al.containsKey(s)) {
                    s2 = null;
                }
                else {
                    s2 = h2;
                }
                this.Code(s, h, c, s2);
            }
        }
        final String s3 = this.Code.I.get(h);
        String s4;
        if (s3 == null) {
            s4 = h2;
        }
        else {
            s4 = s3;
        }
        char[] array2 = null;
        int n4 = 0;
        Label_0234: {
            switch (d) {
                case 112: {
                    final int length = s4.length();
                    final char[] array = new char[length];
                    int n3 = 0;
                    while (true) {
                        array2 = array;
                        n4 = length;
                        if (n3 >= array.length) {
                            break Label_0234;
                        }
                        array[n3] = cg.w;
                        ++n3;
                    }
                    break;
                }
                case 97: {
                    final int d3 = this.Code.d();
                    final int length2 = s4.length();
                    if (length2 > al.aw.length) {
                        final Integer n5 = new Integer(s4.hashCode());
                        if (this.aF == null) {
                            this.aF = new Hashtable();
                        }
                        int n6;
                        if (this.aF.containsKey(n5)) {
                            array2 = (char[])this.aF.get(n5);
                            if (this.G && !this.F) {
                                n6 = 1;
                            }
                            else {
                                n6 = 0;
                            }
                        }
                        else {
                            array2 = new char[length2];
                            n6 = 1;
                        }
                        if (n6 != 0) {
                            s4.getChars(0, length2, array2, 0);
                            n4 = Code(array2, length2, d3, this.M(this.ar));
                            this.aF.put(n5, array2);
                        }
                        else {
                            n4 = length2;
                        }
                        break Label_0234;
                    }
                    array2 = al.aw;
                    s4.getChars(0, length2, array2, 0);
                    n4 = Code(array2, length2, d3, this.M(this.ar));
                    break Label_0234;
                }
                case 83:
                case 85:
                case 120: {
                    array2 = s4.toCharArray();
                    n4 = array2.length;
                    break Label_0234;
                }
                case 99: {
                    boolean b;
                    if (s3 != null) {
                        b = true;
                    }
                    else {
                        b = false;
                    }
                    boolean b2;
                    if ((d2 & 0x2) != 0x0) {
                        b2 = true;
                    }
                    else {
                        b2 = false;
                    }
                    if (b2 ^ b) {
                        aw.Code(this.ap + 1, this.aq + 1, this.ap + this.ar - 2, this.aq + this.as - 2, 0);
                        aw.Code(this.ap + 1, this.aq + this.as - 2, this.ap + this.ar - 2, this.aq + 1, 0);
                        n4 = 0;
                        array2 = null;
                        break Label_0234;
                    }
                    break;
                }
                case 114: {
                    if (s3 != null) {
                        if (!s3.equals(h2)) {
                            break;
                        }
                    }
                    else if ((d2 & 0x2) == 0x0) {
                        break;
                    }
                    aw.Code(this.ap + 1, this.aq + 1, this.ar - 3, this.as - 3, -90, 360, 4210752);
                    n4 = 0;
                    array2 = null;
                    break Label_0234;
                }
                case 115: {
                    final int av = this.av;
                    this.av = y;
                    int i = this.y();
                    final String string = "\u0000" + s4 + "\u0000";
                    final StringBuffer sb = new StringBuffer();
                    while (i > 0) {
                        final String h3 = this.H();
                        final String h4 = this.H();
                        boolean b3;
                        if (string.indexOf("\u0000" + h3 + "\u0000") >= 0) {
                            b3 = true;
                        }
                        else {
                            b3 = false;
                        }
                        if ((d2 & 0x4) == 0x0) {
                            if (b3) {
                                sb.append(h4).append("\n");
                                break;
                            }
                        }
                        else {
                            if (b3) {
                                sb.append("*");
                            }
                            sb.append(h4).append("\n");
                        }
                        --i;
                    }
                    this.av = av;
                    array2 = sb.toString().toCharArray();
                    n4 = array2.length;
                    break Label_0234;
                }
                case 102: {
                    if (this.Code.a != null && this.Code.a.containsKey(h)) {
                        final String s5 = (String)((Object[])this.Code.a.get(h))[0];
                        final int lastIndex = s5.lastIndexOf(47);
                        String substring = s5;
                        if (lastIndex >= 0) {
                            substring = s5;
                            if (lastIndex < s5.length()) {
                                substring = s5.substring(lastIndex + 1);
                            }
                        }
                        array2 = substring.toCharArray();
                        n4 = array2.length;
                        break Label_0234;
                    }
                    break;
                }
            }
            n4 = 0;
            array2 = null;
        }
        if (array2 != null) {
            final int code = aw.Code();
            final int j = aw.I();
            final int z = aw.Z();
            final int k = aw.J();
            aw.I(this.ap, this.aq, this.ar, this.as);
            this.Code(aw, array2, n4, n, this.Code.d(), n2);
            aw.Code(code, j, z, k);
        }
    }
    
    private void Code(final aw aw, final int n, int av, final int n2, final int n3, final int[] array) {
        if (n3 < 0) {
            return;
        }
        av += this.a(array[n2 + 2] & 0xFFFFFF);
        final int code = aw.Code();
        final int i = aw.I();
        final int z = aw.Z();
        final int j = aw.J();
        aw.I(n, av, this.z, this.a(this.T[n3 * 5 + 0] + this.T[n3 * 5 + 1]));
        final int n4 = av - this.a(this.T[n2 * 5 + 0]);
        av = 0;
        int n5 = 0;
        this.av = 0;
        while (!u.r()) {
            int n6 = n5;
            final int n7 = Integer.MAX_VALUE;
            int k = n2;
            int n8 = av;
            av = n7;
        Label_0149:
            while (k <= n3) {
                int n9 = this.T[k * 5 + 3];
                while (true) {
                    int n10;
                    while (true) {
                        n10 = av;
                        if (this.T[n9] == 0) {
                            break;
                        }
                        this.T[k * 5 + 3] = n9;
                        if (this.T[n9 + 1] > this.av) {
                            av = cg.Code(av, this.av, this.T[n9]);
                            if (this.T[n9] == (n10 = av)) {
                                n8 = this.T[n9 + 2];
                                n6 = this.T[n9 + 3];
                                ++k;
                                continue Label_0149;
                            }
                            break;
                        }
                        else {
                            n9 += 4;
                        }
                    }
                    av = n10;
                    continue;
                }
            }
            if (av == Integer.MAX_VALUE) {
                break;
            }
            int n11 = av;
            int max;
            while (true) {
                int l = n2;
                max = n11;
                while (l <= n3) {
                    for (int n12 = this.T[l * 5 + 3]; this.T[n12] != 0 && this.T[n12] <= this.X + max; max = Math.max(max, this.T[n12 + 1]), n12 += 4) {
                        this.T[l * 5 + 3] = n12;
                    }
                    ++l;
                }
                if (n11 == max) {
                    break;
                }
                n11 = max;
            }
            this.av = av;
            int n13 = n6;
            av = n8;
            while (this.av < max && !u.r()) {
                final int av2 = this.av;
                final int d = this.D();
                if (d == 83 || d == 76 || d == 77) {
                    this.K(d);
                }
                else {
                    this.F();
                    this.ap += av;
                    this.aq += n13;
                    av = this.ap;
                    final int aq = this.aq;
                    final int ar = this.ar;
                    final int as = this.as;
                    this.ar = this.a(this.ap + this.ar);
                    this.as = this.a(this.aq + this.as);
                    this.ap = this.a(this.ap);
                    this.aq = this.a(this.aq);
                    this.ar -= this.ap;
                    this.as -= this.aq;
                    this.ap += n;
                    this.aq += n4;
                    if (cg.Code(this.ap, this.aq, this.ar, this.as, aw.Code(), aw.I(), aw.Z(), aw.J())) {
                        final int x = this.x();
                        switch (d) {
                            case 84: {
                                final int a = this.A();
                                for (int d2 = this.D(); d2 > 0; --d2) {
                                    switch (this.D()) {
                                        default: {
                                            this.av += this.A();
                                            break;
                                        }
                                        case 114: {
                                            this.A();
                                            break;
                                        }
                                    }
                                }
                                final int a2 = this.A();
                                char[] aw2 = al.aw;
                                if (a2 > al.aw.length) {
                                    aw2 = new char[a2];
                                }
                                final int code2 = r.Code(this.ai, this.av, aw2, 0, a2);
                                this.av += a2;
                                if (this.Code.J.Z() && this.Code.J.Code(av2) && !this.z(av2)) {
                                    this.Code.J.Code(aw, n, n4, this.ap, this.aq, this.ar, av, aq, av2, aw2, code2, a, as, !cg.Code(aw2[0]));
                                }
                                if (this.Code.Z.I(av2) && !this.z(av2)) {
                                    this.Code.Z.Code(aw, n, n4, x);
                                }
                                this.Code(aw, aw2, code2, x, a, as);
                                if (this.aL != null) {
                                    final Vector m = this.aL.I(av2);
                                    if (m != null) {
                                        for (int n14 = 0; n14 < m.size(); ++n14) {
                                            final int[] array2 = m.elementAt(n14);
                                            boolean b;
                                            if (array2[9] == this.Code.C) {
                                                b = true;
                                            }
                                            else {
                                                b = false;
                                            }
                                            int n15;
                                            if (b) {
                                                n15 = 61030;
                                            }
                                            else {
                                                n15 = 16772710;
                                            }
                                            int n16;
                                            if (b) {
                                                n16 = 16777215;
                                            }
                                            else {
                                                n16 = 0;
                                            }
                                            final int n17 = this.a(array2[3]) + this.ap;
                                            final int n18 = this.a(array2[4]) + this.aq;
                                            aw.Z(n17, n18, this.a(array2[5]), this.a(array2[6]), n15);
                                            cg.Code(aw, a, aw2, array2[1], array2[2], n17, n18, n16, this.H, this.z, this.x);
                                        }
                                    }
                                }
                                n13 = aq;
                                continue;
                            }
                            case 73: {
                                final int z2 = this.z();
                                int a3 = -1;
                                int a4 = -1;
                                int d3 = this.D();
                                int x2 = 0;
                                int a5 = 0;
                                int a6 = 0;
                                while (d3 > 0) {
                                    switch (this.D()) {
                                        default: {
                                            this.av += this.A();
                                            break;
                                        }
                                        case 99: {
                                            final int a7 = this.A();
                                            x2 = this.x();
                                            this.av += a7 - 4;
                                            break;
                                        }
                                        case 111: {
                                            this.av += 2;
                                            a5 = this.A();
                                            a6 = this.A();
                                            break;
                                        }
                                        case 122: {
                                            this.A();
                                            a3 = this.A();
                                            a4 = this.A();
                                            break;
                                        }
                                    }
                                    --d3;
                                }
                                if (this.ar <= 0 || this.as <= 0) {
                                    break;
                                }
                                final int n19 = x2 + a4 * 1024 + a3;
                                az az;
                                if (a3 != -1 && a4 != -1) {
                                    if (this.D) {
                                        az = this.Code(n19, this.Y + z2, av, aq, ar, as, 256, a3, a4);
                                    }
                                    else {
                                        az = this.Code(n19, this.Y + z2, av, aq, ar, as, this.u(), a3, a4);
                                    }
                                }
                                else if (this.D) {
                                    az = this.Code(n19, this.Y + z2, av, aq, ar, as, 256, -1, -1);
                                }
                                else {
                                    az = this.Code(n19, this.Y + z2, av, aq, ar, as, this.u(), ar, as);
                                }
                                if (az != null) {
                                    int n20;
                                    if (this.F) {
                                        n20 = 0;
                                    }
                                    else {
                                        n20 = 1;
                                    }
                                    aw.Code(az, this.ap, this.aq, this.ar, this.as, a5, a6, this.ar, this.as, n20);
                                    n13 = aq;
                                    continue;
                                }
                                aw.Z(this.ap, this.aq, this.ar, this.as, x);
                                n13 = aq;
                                continue;
                            }
                            case 66: {
                                aw.J(this.ap, this.aq, this.ar, this.as, x);
                                n13 = aq;
                                continue;
                            }
                            case 70: {
                                this.Code(aw, x, as);
                                break;
                            }
                        }
                        n13 = aq;
                    }
                    else {
                        this.K(d);
                        n13 = aq;
                    }
                }
            }
            av = n8;
            n5 = n6;
        }
        aw.Code(code, i, z, j);
    }
    
    private void Code(final aw aw, final int n, final int n2, int n3, final int n4, final int[] array, final int n5) {
        Label_0009: {
            if (n3 < array[0]) {
                int z = this.Z(array, 2, n5, n3);
                if (z != n5) {
                    n3 = z;
                    while (!u.r()) {
                        if (z == n5) {
                            this.Code(aw, n, n2, n3, z - 1, array);
                            return;
                        }
                        this.T[z * 5 + 3] = this.T[z * 5 + 2];
                        int n6;
                        int n7;
                        if ((array[z + 2] & Integer.MIN_VALUE) == 0x0) {
                            this.Code(aw, n, n2, n3, z - 1, array);
                            do {
                                n6 = n3 + 1;
                                if (n6 == n5) {
                                    break Label_0009;
                                }
                                n3 = n6;
                            } while ((array[n6 + 2] & Integer.MIN_VALUE) == 0x0);
                            n7 = n6 - 1;
                        }
                        else {
                            n7 = z;
                            n6 = n3;
                            if ((array[z + 2] & 0xFFFFFF) > n4) {
                                this.Code(aw, n, n2, n3, z - 1, array);
                                return;
                            }
                        }
                        z = n7 + 1;
                        n3 = n6;
                    }
                }
            }
        }
    }
    
    private void Code(final aw aw, final char[] array, int i, final int n, final int n2, final int n3) {
        int n4;
        int max;
        int n5;
        int n6;
        for (n4 = 1, max = Math.max(n3 / cg.a(n2), 1), n5 = 0; n5 < i && n4 <= max; n4 += n6, ++n5) {
            if (array[n5] == '\n') {
                n6 = 1;
            }
            else {
                n6 = 0;
            }
        }
        final int n7 = n4;
        i = n5;
        int n8 = n7;
        while (i > 0) {
            final int aq = this.aq;
            final int n9 = n8 - 1;
            final int a = this.a(n3 * n9 / n4);
            int n10 = 0;
            int n11 = i;
            int n12;
            if (n9 == 0) {
                n12 = 0;
            }
            else {
                int n13;
                do {
                    n13 = n10;
                    i = n11;
                    if (array[n11 - 1] == '\n') {
                        break;
                    }
                    n13 = n10 + 1;
                    i = n11 - 1;
                    n10 = n13;
                } while ((n11 = i) != 0);
                n12 = i;
                i = n13;
            }
            int n14 = i;
            if (i > 0) {
                n14 = i;
                if (array[n12 + i - 1] == '\r') {
                    n14 = i - 1;
                }
            }
            aw.Code(n2, array, n12, n14, this.ap, aq + a, n, this.D, this.H, this.z, this.x);
            i = n12 - 1;
            n8 = n9;
        }
    }
    
    private static void Code(final DataInputStream dataInputStream) {
        final byte byte1 = dataInputStream.readByte();
        for (int i = 0; i < byte1; ++i) {
            u.Code.B(dataInputStream.readUTF(), dataInputStream.readUTF());
        }
    }
    
    private static void Code(final DataInputStream dataInputStream, int i, final bh bh) {
        final int read = dataInputStream.read();
        final int n = 1;
        int n2;
        if ((read & 0x1) != 0x0) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        int n3;
        if ((read & 0x2) != 0x0) {
            n3 = 1;
        }
        else {
            n3 = 0;
        }
        final boolean b = (read & 0x4) != 0x0;
        if (n3 != 0) {
            bh.a();
            u.I.Z(44);
            return;
        }
        final Vector<byte[]> vector = new Vector<byte[]>();
        int j = n;
        while (j < i) {
            final int read2 = dataInputStream.read();
            final int unsignedShort = dataInputStream.readUnsignedShort();
            final int read3 = dataInputStream.read();
            final int code = Code((DataInput)dataInputStream);
            j += code + 7;
            final byte[] array = new byte[code + 6];
            cg.Code(array, read2, unsignedShort, read3);
            dataInputStream.readFully(array, 6, code);
            vector.addElement(array);
        }
        int size = vector.size();
        final byte[] array2 = new byte[size];
        synchronized (cg.X) {
            if ((cg.Y == null || cg.Y.length == 0) && n2 == 0) {
                return;
            }
        }
        byte[] array4 = null;
        int n4 = 0;
        Label_0297: {
            if (n2 != 0 || cg.Y == null) {
                cg.b();
                cg.aa = new byte[size * 3];
                cg.ab = new byte[size];
                while (true) {
                    byte[] array3;
                    for (i = 0; i < size; ++i) {
                        array3 = vector.elementAt(i);
                        cg.aa[i * 3] = array3[2];
                        array4[i] = array3[2];
                        if (!cg.Code(i, array3)) {
                            i = 1;
                            array4 = new byte[0];
                            n4 = 1;
                            break Label_0297;
                        }
                    }
                    i = n2;
                    continue;
                }
            }
            cg.aa = new byte[cg.Y.length];
            System.arraycopy(cg.Y, 0, cg.aa, 0, cg.Y.length);
            final int n5 = 0;
            i = n2;
            final int n6 = 0;
            int k = n5;
            n4 = n6;
        Label_0423:
            while (k < size) {
                final byte[] array5 = vector.elementAt(k);
                array4[k] = array5[2];
                while (true) {
                    for (int l = 0; l < cg.aa.length / 3; ++l) {
                        if (array5[2] == cg.aa[l * 3]) {
                            cg.aa[l * 3 + 1] = array5[3];
                            cg.aa[l * 3 + 2] = array5[4];
                            cg.ab[l] = array5[5];
                            int n7;
                            if (!cg.Code(l, array5)) {
                                size = 0;
                                n7 = 1;
                                i = 1;
                                array4 = new byte[0];
                            }
                            else {
                                n7 = 1;
                            }
                            if (n7 == 0) {
                                final int n8 = cg.aa.length / 3;
                                int n9 = 1;
                                final byte[] array6 = new byte[size - k];
                                array6[0] = vector.elementAt(k)[2];
                                int n10 = k + 1;
                            Label_0580:
                                while (n10 < size) {
                                    final byte[] array7 = vector.elementAt(n10);
                                    while (true) {
                                        for (int n11 = 0; n11 < n8; ++n11) {
                                            if (array7[2] == cg.aa[n11 * 3]) {
                                                final int n12 = 1;
                                                if (n12 == 0) {
                                                    array6[n9] = vector.elementAt(n10)[2];
                                                    ++n9;
                                                }
                                                ++n10;
                                                continue Label_0580;
                                            }
                                        }
                                        final int n12 = 0;
                                        continue;
                                    }
                                }
                                final byte[] aa = new byte[(n8 + n9) * 3];
                                final byte[] ab = new byte[n8 + n9];
                                System.arraycopy(cg.aa, 0, aa, 0, n8 * 3);
                                System.arraycopy(cg.ab, 0, ab, 0, n8);
                                cg.aa = aa;
                                cg.ab = ab;
                                final int n13 = 1;
                                for (int n14 = 0; n14 < n9; ++n14) {
                                    cg.aa[(n8 + n14) * 3] = array6[n14];
                                }
                                --k;
                                n4 = n13;
                            }
                            ++k;
                            continue Label_0423;
                        }
                    }
                    int n7 = 0;
                    continue;
                }
            }
        }
        if (n4 != 0) {
            cg.a();
            if (cg.Y == null) {
                i = 1;
                array4 = new byte[0];
            }
        }
        else {
            cg.d();
        }
        final Object o;
        monitorexit(o);
        bh.a();
        u.Z.b(u.Z.Code(array4));
        final p z = u.Z;
        if (i != 0) {
            i = 1;
        }
        else {
            i = 0;
        }
        z.c(i);
        final p z2 = u.Z;
        if (b) {
            i = 1;
        }
        else {
            i = 0;
        }
        z2.c(i);
        u.I.Z(42);
    }
    
    private void Code(String s, final String s2, final char c, final String s3) {
        final String s4 = null;
        if (s2 != null && !this.am.contains(s2) && !this.Code.I.containsKey(s2) && (s3 == null || s3.length() == 0 || this.Code.i() == null || this.Code.i().indexOf(s2 + "=") == -1)) {
            s = this.al.remove(s);
        }
        else {
            s = s4;
            if (s3 != null) {
                s = s4;
                if (s3.length() > 0) {
                    s = s3;
                }
            }
        }
        if (s != null) {
            this.Code.Code(s, c, s2);
        }
    }
    
    private native void Code(final p p0, final int p1, final int p2, final int[] p3, final int p4, final int p5, final boolean p6, final boolean p7, final boolean p8, final int p9, final int p10, final int p11);
    
    private native void Code(final p p0, final int p1, final boolean p2);
    
    private void Code(final int[] array, final int n, final int[] array2) {
        final int[][] code = this.aL.Code(this.Code.C);
        for (int i = 0; i < code.length; ++i) {
            final int[] array3 = code[i];
            if (i == 0) {
                array2[0] = array3[3] + array3[7];
                array2[2] = array3[5];
            }
            else {
                array2[0] = Math.min(array2[0], array3[3] + array3[7]);
                array2[2] += array3[5];
            }
            array2[1] = this.I(array, 0, n, array3[4] + array3[8]);
            array2[3] = array3[6];
        }
    }
    
    private static boolean Code(int n, final byte[] array, final int n2) {
        boolean b = true;
        int n3 = 0;
    Label_0275:
        while (true) {
            byte b2 = 0;
            Label_0107: {
            Label_0227_Outer:
                while (true) {
                Label_0266_Outer:
                    while (true) {
                        while (true) {
                            switch (n) {
                                default: {
                                    b = false;
                                    break;
                                }
                                case 0: {
                                    if (n2 != 0) {
                                        b2 = array[0];
                                        n = 0;
                                        n3 = 1;
                                        break Label_0107;
                                    }
                                    return false;
                                }
                                case 2: {
                                    Label_0213: {
                                        break Label_0213;
                                        try {
                                            final int i = I(array, n3 + 0, n2 - n3);
                                            if (i < 0) {
                                                return false;
                                            }
                                            final int n4 = n3 + i;
                                            final int j = I(array, n4 + 0, n2 - n4);
                                            if (j <= 2) {
                                                return false;
                                            }
                                            final int n5 = n4 + j;
                                            final int code = Code(array, n5 + 0, n2 - n5);
                                            if (code < 0) {
                                                return false;
                                            }
                                            final int n6 = n5 + code;
                                            final int code2 = Code(array, n6 + 0, n2 - n6);
                                            if (code2 >= 0) {
                                                n3 = n6 + code2;
                                                ++n;
                                                break Label_0107;
                                            }
                                            return false;
                                            return Code(array, n2, true);
                                            return Code(array, n2, false);
                                            iftrue(Label_0259:)(n >= 5);
                                            while (true) {
                                                final int n7;
                                                Block_9: {
                                                    break Block_9;
                                                    Label_0259: {
                                                        iftrue(Label_0091:)(n7 == n2);
                                                    }
                                                    return false;
                                                    iftrue(Label_0091:)(n2 > 0);
                                                    return false;
                                                    Label_0264:
                                                    return false;
                                                    final int k;
                                                    n7 += k;
                                                    ++n;
                                                    continue Label_0266_Outer;
                                                }
                                                final int k = I(array, n7, n2 - n7);
                                                iftrue(Label_0264:)(k < 0);
                                                continue;
                                            }
                                        }
                                        catch (Throwable t) {
                                            return false;
                                        }
                                    }
                                    break Label_0275;
                                }
                                case 18: {
                                    continue Label_0227_Outer;
                                }
                                case 37: {
                                    continue;
                                }
                                case 3:
                                case 4:
                                case 5: {
                                    return false;
                                }
                                case 30: {
                                    if (n2 <= 0) {
                                        return false;
                                    }
                                    break;
                                }
                                case 31: {
                                    n = 0;
                                    final int n7 = 0;
                                    continue Label_0266_Outer;
                                }
                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                Label_0091: {
                    return b;
                }
            }
            if (n < (b2 & 0xFF)) {
                continue;
            }
            break;
        }
        if (n3 == n2) {
            return b;
        }
        return false;
    }
    
    static boolean Code(final boolean b, final int n, final int n2) {
        if (u.Code.m()) {
            String s;
            if (b) {
                s = u.c.I(n, n2);
            }
            else {
                s = u.c.Code(n, n2);
            }
            return !u.c.B(s) || u.c.Z(s);
        }
        return false;
    }
    
    private static boolean Code(final byte[] array, final int n, final boolean b) {
        if (n == 0) {
            return false;
        }
        final byte b2 = array[0];
        int i = 0;
        int n2 = 1;
        while (i < (b2 & 0xFF)) {
            final int j = I(array, n2 + 0, n - n2);
            if (j < 0) {
                return false;
            }
            final int n3 = n2 + j;
            final int k = I(array, n3 + 0, n - n3);
            if (k <= 2) {
                return false;
            }
            final int n4 = k + n3;
            if (n4 == n) {
                return false;
            }
            int n6;
            final int n5 = n6 = n4 + 1;
            if (array[n4 + 0] != 0) {
                final int code = Code(array, n5 + 0, n - n5);
                if (code < 0) {
                    return false;
                }
                n6 = n5 + code;
            }
            n2 = n6;
            if (b) {
                final int l = I(array, n6 + 0, n - n6);
                if (l < 0) {
                    return false;
                }
                n2 = n6 + l;
            }
            ++i;
        }
        return n2 == n;
    }
    
    private int D() {
        return this.Z(this.av++);
    }
    
    private static int D(final int n) {
        final int q = u.Z.q(n);
        u.Z.Code(n, 0, q, true);
        return q - 2;
    }
    
    private int E(final int n) {
        return u.Z.Code(this.ai, n + 2, q.Z(this.ai, n));
    }
    
    private void E() {
        this.ap = this.A();
        this.aq = this.y();
        this.ar = this.A();
        this.as = this.y();
    }
    
    private int F(final int n) {
        final int z = q.Z(this.ai, n);
        if (z > 0 && this.ai[n + 2] == 0) {
            return u.Z.Code(this.ai, this.l + 2, q.Z(this.ai, this.l), this.ai, n + 3, z - 1);
        }
        return u.Z.Code(this.ai, n + 2, z);
    }
    
    private void F() {
        this.ap = (short)this.A();
        this.aq = this.z();
        this.ar = this.A();
        this.as = this.y();
    }
    
    private int G(int h) {
        h = this.H(h);
        if (this.L()) {
            this.B(true);
        }
        if (this.W || this.ad == null) {
            return h;
        }
        this.W = true;
        this.Code.a();
        u.Z.b(this.n());
        u.Z.c(this.ah);
        u.I.I(this.Code.C(), 30);
        return h;
    }
    
    private void G() {
        this.av += this.A();
    }
    
    private int H(int i) {
        int av;
        int d;
        int d2;
        int y;
        int n;
        int n2;
        int y2;
        int d3;
        int x;
        String h;
        String h2;
        int x2;
        Integer value;
        Hashtable ae;
        bh code;
        Label_0187_Outer:Label_0096_Outer:
        while (true) {
            while (true) {
            Label_0978:
                while (true) {
                    Label_0258: {
                        Label_0234: {
                            synchronized (this) {
                                this.Code.I();
                                try {
                                    this.av = i;
                                    while ((this.av < this.ai.length && this.ak == this.ai.length) || this.av < this.ak - 16) {
                                        av = this.av;
                                        d = this.D();
                                        switch (d) {
                                            case 83: {
                                                this.av += this.y();
                                                i = this.av;
                                                continue Label_0187_Outer;
                                            }
                                            case 76: {
                                                break Label_0234;
                                            }
                                            case 77: {
                                                break Label_0258;
                                            }
                                            default: {
                                                break Label_0978;
                                            }
                                        }
                                    }
                                    break;
                                    this.F();
                                    this.K(d);
                                    iftrue(Label_0963:)(this.av > this.ak);
                                    this.ap += this.at;
                                    this.aq += this.au;
                                    this.b(av, this.av);
                                    this.at = this.ap;
                                    this.au = this.aq;
                                    this.J(this.ap, this.aq, this.ar, this.as);
                                }
                                finally {
                                    this.Code.Z();
                                    this.M();
                                }
                            }
                        }
                        this.y();
                        this.aa = this.y();
                        this.ab = this.y();
                        continue Label_0096_Outer;
                    }
                    d2 = this.D();
                    y = this.y();
                    if (this.av + y > this.ak) {
                        break;
                    }
                    switch (d2) {
                        case 116: {
                            this.ax = this.av - 3;
                            this.av += y;
                            continue Label_0096_Outer;
                        }
                        case 67: {
                            this.U = (y - 8) / 6;
                            this.T = new int[this.A() * 4 + this.U * 6];
                            this.X = this.D();
                            this.P = this.A();
                            this.Q = this.y();
                            this.R = true;
                            i = this.U;
                            n = 0;
                            n2 = i * 5;
                            for (i = 0; i / 5 < this.U; i += 5) {
                                y2 = this.y();
                                this.T[i + 0] = n;
                                this.T[i + 1] = y2;
                                this.T[i + 2] = n2;
                                this.T[i + 4] = this.D();
                                n2 += this.A() * 4 + 1;
                                n += y2;
                            }
                            this.V = true;
                            continue Label_0096_Outer;
                        }
                        case 84: {
                            this.ac = new int[y / 12 * 5];
                            for (i = 0; i < this.ac.length; i += 5) {
                                this.ac[i + 0] = this.y();
                                this.ac[i + 1] = this.y();
                                this.ac[i + 2] = this.y() - this.ac[i + 0];
                                this.ac[i + 3] = this.y() - this.ac[i + 1];
                            }
                            continue Label_0096_Outer;
                        }
                        case 86: {
                            this.v = new int[4];
                            for (i = 0; i < 3; ++i) {
                                this.v[i] = this.A();
                            }
                            this.v[3] = this.D();
                            this.w = true;
                            continue Label_0096_Outer;
                        }
                        case 73: {
                            this.ad = new int[y / 11 * 5];
                            for (i = 0; i < this.ad.length; i += 5) {
                                this.ad[i + 0] = this.D();
                                this.ad[i + 1] = this.y();
                                this.ad[i + 2] = this.y();
                                this.ad[i + 3] = this.A();
                                this.ad[i + 4] = this.A();
                            }
                            continue Label_0096_Outer;
                        }
                        case 78: {
                            for (d3 = this.D(), i = 0; i < d3; ++i) {
                                x = this.x();
                                h = this.H();
                                h2 = this.H();
                                x2 = this.x();
                                if (this.ae == null) {
                                    this.ae = new Hashtable();
                                    this.ag = new Hashtable();
                                    this.af = new Hashtable();
                                }
                                value = x2;
                                if (x >= 0) {
                                    ae = this.ae;
                                    if (!u.Code.Code(x, h, h2)) {
                                        x = -2;
                                    }
                                    ae.put(value, x);
                                }
                                this.af.put(value, h);
                                this.ag.put(value, h2);
                            }
                            continue Label_0096_Outer;
                        }
                        case 117: {
                            i = this.x();
                            if (!this.ay) {
                                code = this.Code;
                                code.d += i;
                                continue Label_0096_Outer;
                            }
                            continue Label_0096_Outer;
                        }
                        default: {
                            this.av += y;
                            continue Label_0096_Outer;
                        }
                    }
                    break;
                }
                continue;
            }
        }
        Label_0963: {
            this.Code.Z();
        }
        this.M();
        monitorexit(this);
        return i;
    }
    
    private String H() {
        final String j = this.J(this.av);
        this.G();
        return j;
    }
    
    private static int I(final byte[] array, final int n, final int n2) {
        if (n2 >= 2) {
            final int z = q.Z(array, n);
            if (z + 2 <= n2 && q.I(array, n + 2, z)) {
                return z + 2;
            }
        }
        return -1;
    }
    
    private int I(final int[] array, final int n, int d, final int n2) {
        if (d != 0) {
            d = this.d(n2, d);
            if ((array[n + d] & Integer.MIN_VALUE) != 0x0) {
                return n2 - this.T[d * 5 + 0] + (array[d + n] & 0xFFFFFF);
            }
        }
        return -1;
    }
    
    private void J(final int l, final int m, final int n, final int o) {
        if (this.Z(l, m, n, o)) {
            if (this.N > 0) {
                final int i = this.L;
                final int n2 = this.N;
                this.L = Math.min(this.L, l);
                this.N = Math.max(l + n, i + n2) - this.L;
                final int j = this.M;
                final int o2 = this.O;
                this.M = Math.min(this.M, m);
                this.O = Math.max(m + o, j + o2) - this.M;
            }
            else {
                this.L = l;
                this.M = m;
                this.N = n;
                this.O = o;
            }
        }
        this.B(l, m, n, o);
    }
    
    private void J(final boolean b) {
        for (int i = 0, n = 0; i < this.aA.J; ++i, n += 6) {
            if (this.A) {
                if (this.aA.I[i] != null && !this.x(n)) {
                    this.aA.Code(i, true, true);
                }
                else {
                    this.aA.Code(i, true, false);
                }
            }
            else if (this.aA.Z[i] != null && !this.x(n)) {
                this.aA.Code(i, true, true);
            }
            else if (!b && this.aA.I[i] != null) {
                this.aA.Code(i, false, true);
            }
        }
    }
    
    private String K() {
        String s2;
        final String s = s2 = this.H();
        if (s != null) {
            s2 = s;
            if (s.length() > 0) {
                s2 = s;
                if (s.charAt(0) == '\0') {
                    s2 = this.k + s.substring(1, s.length());
                }
            }
        }
        return s2;
    }
    
    private void K(final int n) {
        switch (n) {
            default: {}
            case 84: {
                this.av += 6;
                this.Q();
                this.av += this.A();
            }
            case 73: {
                this.av += 7;
                this.Q();
            }
            case 66: {
                this.av += 4;
            }
            case 70: {
                this.av += 6;
                this.av += this.A();
                this.av = this.A() + this.av + 5;
            }
            case 83: {
                this.av += this.y();
            }
            case 76: {
                this.av += 9;
            }
            case 77: {
                ++this.av;
                this.av += this.y();
            }
        }
    }
    
    private int L(final int n) {
        return this.Code.c() * n / this.x;
    }
    
    private boolean L() {
        return this.V && this.Code.b() == this;
    }
    
    private int M(final int n) {
        return this.x * n / this.z;
    }
    
    private native void M();
    
    private int N(int y) {
        this.av = y + 1 + 1 + this.ai[y + 1] * 10;
        this.av += 2;
        y = this.y();
        return this.av = y;
    }
    
    private void N() {
        this.M();
        if (this.O()) {
            this.Code.a();
            u.I.I(this.Code.C(), 22);
        }
    }
    
    private boolean O() {
        return this.N > 0;
    }
    
    private int P() {
        final int n = 0;
        synchronized (this) {
            int ag;
            if (this.aG == -1) {
                ag = n;
            }
            else {
                this.av = this.aG;
                int i;
                do {
                    ag = n;
                    if (this.av > this.ab) {
                        return ag;
                    }
                    this.aG = this.av;
                    i = this.D();
                    this.av += this.D() * 10;
                    this.av += this.A();
                    this.Q();
                } while (i != 76);
                ag = this.aG;
                this.aG = this.av;
            }
            return ag;
        }
    }
    
    private void Q() {
        for (int i = this.D(); i > 0; --i) {
            ++this.av;
            this.av += this.A();
        }
    }
    
    private void R() {
        if (this.w) {
            this.w = false;
            this.Code.a();
            u.I.I(this.Code.C(), 31);
        }
    }
    
    private boolean S() {
        return this.aL != null && this.aL.Code();
    }
    
    private int Z(final int[] array, final int n, final int n2, int n3) {
    Label_0019_Outer:
        while (true) {
        Label_0019:
            while (true) {
                int code = 0;
                final Throwable t;
                Label_0060: {
                    synchronized (this) {
                        code = cg.Code(array, n, n2, 1, 16777215, n3);
                        break Label_0060;
                        while (true) {
                            final int n4;
                            n3 = t[n + n4];
                            iftrue(Label_0050:)((n3 & Integer.MIN_VALUE) != 0x0);
                            ++n4;
                            break Label_0019;
                            Label_0050: {
                                return n4;
                            }
                            iftrue(Label_0050:)(n4 >= n2);
                            continue Label_0019_Outer;
                        }
                    }
                }
                while (true) {
                    int n4 = code;
                    if (code <= 0) {
                        continue Label_0019;
                    }
                    if (code != n2 && (t[n + code] & 0xFFFFFF) != (t[n + code - 1] & 0xFFFFFF)) {
                        n4 = code;
                        if ((t[n + code] & 0xFFFFFF) <= n3) {
                            continue Label_0019;
                        }
                    }
                    --code;
                }
                break;
            }
        }
    }
    
    private boolean Z(final int n, final int n2, final int n3, final int n4) {
        for (int i = 1; i < this.E[0]; i += 4) {
            if (cg.Code(n, n2, n3, n4, this.E[i + 0], this.E[i + 1], this.E[i + 2], this.E[i + 3])) {
                return true;
            }
        }
        return false;
    }
    
    private int a(int i, int n, final int av) {
        final int n2 = 0;
        synchronized (this) {
            this.av = av;
            this.D();
            final int d = this.D();
            u.Z.Z(i);
            u.Z.J(n);
            u.Z.o(d * 4);
            final p z = u.Z;
            final int av2 = this.av;
            n = 0;
            int[] j;
            int n3;
            int[] k;
            int[] l;
            int n4;
            int[] m;
            for (i = n2; i < d; ++i) {
                this.E();
                j = u.Z.I;
                n3 = n + 1;
                j[n] = this.ap;
                k = u.Z.I;
                n = n3 + 1;
                k[n3] = this.aq;
                l = u.Z.I;
                n4 = n + 1;
                l[n] = this.ar;
                m = u.Z.I;
                n = n4 + 1;
                m[n4] = this.as;
            }
            final int o = u.Z.o();
            final int z2 = u.Z.Z();
            i = u.Z.J();
            u.Z.Z(0);
            u.Z.J(0);
            final int a = A(i);
            final int[] i2 = u.Z.I;
            final p z3 = u.Z;
            this.av = av2;
            n = 1;
            for (i = d; i > 0; --i) {
                this.E();
                this.aq = this.I(i2, 0, a, this.aq);
                u.Z.Z(o, n, this.aq);
                n += 4;
            }
            this.av += this.A();
            this.Q();
            u.Z.B(z2, 3, av);
            u.Z.B(z2, 4, 16);
            u.Z.B(z2, 5, 0);
            u.Z.J(z2, 2, o);
            return z2;
        }
    }
    
    private void b(final int n, final int n2) {
        int d = this.d(this.aq, this.U);
        int n4;
        do {
            int n3;
            for (n3 = this.T[d * 5 + 2]; this.T[n3 + 4] != 0; n3 += 4) {}
            if (this.T[n3 + 0] == 0) {
                this.B(n3, n, n2);
            }
            else if (this.T[n3 + 1] + this.X >= n) {
                this.T[n3 + 1] = n2;
            }
            else {
                this.B(n3 + 4, n, n2);
            }
            n4 = d + 1;
            if (n4 >= this.U) {
                break;
            }
            d = n4;
        } while (this.aq + this.as > this.T[n4 * 5 + 0]);
    }
    
    private int c(final int n, final int n2) {
        return this.x * n / n2;
    }
    
    private int d(final int n, final int n2) {
        synchronized (this) {
            int code;
            for (code = cg.Code(this.T, n2, 5, n); code > 0 && (code == n2 || this.T[code * 5 + 0] == this.T[(code - 1) * 5 + 0] || this.T[code * 5 + 0] > n); --code) {}
            return code;
        }
    }
    
    private int[] e(int n, int length) {
        final int n2 = 1;
        final Vector i = this.aL.I(n);
        if (i != null && length < i.size()) {
            final int[] array = i.elementAt(length);
            final int[] array2 = new int[array.length + 2];
            System.arraycopy(array, 0, array2, 0, array.length);
            final int length2 = array.length;
            if (array[9] == this.Code.C) {
                length = 1;
            }
            else {
                length = 0;
            }
            array2[length2] = length;
            final int[] array3 = i.elementAt(i.size() - 1);
            length = array.length;
            while (true) {
                Label_0163: {
                    if (n != array3[0]) {
                        break Label_0163;
                    }
                    n = array[1];
                    if (array[2] + n != array3[2] + array3[1]) {
                        break Label_0163;
                    }
                    n = n2;
                    array2[length + 1] = n;
                    return array2;
                }
                n = 0;
                continue;
            }
        }
        return null;
    }
    
    private boolean q() {
        int n = 8;
        for (int i = 0; i < 4; ++i) {
            if (n + 2 >= this.ak) {
                return false;
            }
            n += this.I(n) + 2;
        }
        if (this.ak >= n + 6) {
            return true;
        }
        return false;
    }
    
    private native void r();
    
    private void s() {
        int n;
        int n2;
        boolean s;
        boolean p;
        boolean b;
        p z;
        Label_0184_Outer:Label_0205_Outer:
        while (true) {
            n = 1;
            while (true) {
            Label_0443:
                while (true) {
                Label_0353_Outer:
                    while (true) {
                        Label_0433: {
                            while (true) {
                            Label_0428:
                                while (true) {
                                    Label_0418: {
                                        synchronized (this) {
                                            this.av = 0;
                                            this.i = this.D();
                                            this.x = this.A();
                                            this.y = this.y();
                                            this.q = this.A();
                                            if ((this.r & 0x1) != 0x0) {
                                                this.q = 0;
                                            }
                                            this.m = this.av;
                                            this.av += this.A();
                                            n2 = this.A();
                                            if (n2 > 0) {
                                                this.n = new byte[n2];
                                                System.arraycopy(this.ai, this.av, this.n, 0, n2);
                                                this.av += n2;
                                            }
                                            this.l = this.av;
                                            this.k = this.H();
                                            this.j = this.K();
                                            n2 = this.D();
                                            if ((n2 & 0x1) == 0x0) {
                                                break Label_0433;
                                            }
                                            s = true;
                                            this.S = s;
                                            this.u = (n2 & 0x6) >>> 1;
                                            if ((n2 & 0x10) != 0x0) {
                                                p = true;
                                                this.p = p;
                                                if (!this.ay) {
                                                    if ((n2 & 0x8) == 0x0) {
                                                        break Label_0443;
                                                    }
                                                    b = true;
                                                    this.b = b;
                                                    if (this.h != null || this.g != null) {
                                                        this.Code.a();
                                                        u.Z.b(u.Z.Code(this.c));
                                                        u.Z.b(u.Z.Code(this.e));
                                                        u.Z.b(u.Z.Code(this.f));
                                                        if (this.g != null) {
                                                            u.Z.b(u.Z.Code(this.g));
                                                        }
                                                        else {
                                                            u.Z.b(0);
                                                        }
                                                        if (this.h == null) {
                                                            break Label_0418;
                                                        }
                                                        u.Z.b(u.Z.Code(this.h));
                                                        u.Z.b(u.Z.Code(this.d));
                                                        z = u.Z;
                                                        if (!this.b) {
                                                            break Label_0428;
                                                        }
                                                        z.c(n);
                                                        u.I.I(this.Code.C(), 25);
                                                    }
                                                }
                                                this.ah = this.A();
                                                this.Y = this.y();
                                                this.aj = this.av;
                                                return;
                                            }
                                            break Label_0353_Outer;
                                        }
                                    }
                                    u.Z.b(0);
                                    continue Label_0353_Outer;
                                }
                                n = 0;
                                continue;
                            }
                        }
                        s = false;
                        continue Label_0184_Outer;
                    }
                    p = false;
                    continue Label_0205_Outer;
                }
                b = false;
                continue;
            }
        }
    }
    
    private void t() {
        for (int i = 0, n = 0; i < this.aA.J; ++i, n += 6) {
            if (this.aA.I[i] != null || this.aA.Z[i] != null) {
                final int[] code = this.aA.Code;
                final int n2 = n + 2;
                code[n2] |= Integer.MIN_VALUE;
                this.aA.Code(i, true, true);
            }
        }
    }
    
    private int u() {
        return this.Code.c() * 256 / this.x;
    }
    
    private Object v(int n) {
        n += this.Y;
        if (!this.w(n)) {
            return null;
        }
        try {
            return u.Code.r().Code(this.ai, n + 2, q.Z(this.ai, n));
        }
        catch (Throwable t) {
            return null;
        }
    }
    
    private boolean v() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        al.A:Z
        //     6: ifeq            290
        //     9: aload_0        
        //    10: getfield        al.aA:Lam;
        //    13: getfield        am.I:[Laz;
        //    16: astore          11
        //    18: aload_0        
        //    19: getfield        al.A:Z
        //    22: ifeq            302
        //    25: sipush          256
        //    28: istore_1       
        //    29: goto            465
        //    32: iload_2        
        //    33: aload_0        
        //    34: getfield        al.aA:Lam;
        //    37: getfield        am.J:I
        //    40: if_icmpge       452
        //    43: aload           11
        //    45: iload_2        
        //    46: aaload         
        //    47: ifnonnull       487
        //    50: aload_0        
        //    51: getfield        al.aA:Lam;
        //    54: getfield        am.Code:[I
        //    57: iload_3        
        //    58: iconst_2       
        //    59: iadd           
        //    60: iaload         
        //    61: ldc             -2147483648
        //    63: iand           
        //    64: ifne            499
        //    67: aload_0        
        //    68: iload_3        
        //    69: invokespecial   al.x:(I)Z
        //    72: ifeq            499
        //    75: aload_0        
        //    76: aload_0        
        //    77: getfield        al.aA:Lam;
        //    80: getfield        am.Code:[I
        //    83: iload_3        
        //    84: iconst_1       
        //    85: iadd           
        //    86: iaload         
        //    87: invokespecial   al.w:(I)Z
        //    90: ifeq            499
        //    93: iconst_1       
        //    94: istore          4
        //    96: iload           4
        //    98: ifeq            487
        //   101: aload_0        
        //   102: getfield        al.aB:Z
        //   105: ifeq            505
        //   108: aload_0        
        //   109: getfield        al.aA:Lam;
        //   112: getfield        am.Code:[I
        //   115: iload_3        
        //   116: iconst_5       
        //   117: iadd           
        //   118: iaload         
        //   119: ifne            505
        //   122: iconst_1       
        //   123: istore          9
        //   125: iload           9
        //   127: istore          10
        //   129: aload_0        
        //   130: getfield        al.aA:Lam;
        //   133: getfield        am.B:I
        //   136: ifle            358
        //   139: aload_0        
        //   140: getfield        al.aA:Lam;
        //   143: getfield        am.Code:[I
        //   146: iload_3        
        //   147: iconst_1       
        //   148: iadd           
        //   149: iaload         
        //   150: istore          7
        //   152: aload_0        
        //   153: getfield        al.aA:Lam;
        //   156: getfield        am.Code:[I
        //   159: iload_3        
        //   160: iconst_5       
        //   161: iadd           
        //   162: iaload         
        //   163: bipush          16
        //   165: iushr          
        //   166: istore          5
        //   168: aload_0        
        //   169: getfield        al.aA:Lam;
        //   172: getfield        am.Code:[I
        //   175: iload_3        
        //   176: iconst_5       
        //   177: iadd           
        //   178: iaload         
        //   179: ldc_w           65535
        //   182: iand           
        //   183: istore          6
        //   185: getstatic       al.aD:[I
        //   188: astore          12
        //   190: aload_0        
        //   191: getfield        al.ai:[B
        //   194: astore          13
        //   196: aload_0        
        //   197: getfield        al.ai:[B
        //   200: iload           7
        //   202: invokestatic    r.Z:([BI)I
        //   205: istore          8
        //   207: iload           5
        //   209: istore          4
        //   211: iload           5
        //   213: ifne            472
        //   216: iconst_m1      
        //   217: istore          4
        //   219: goto            472
        //   222: aload           13
        //   224: iload           7
        //   226: iconst_2       
        //   227: iadd           
        //   228: iload           8
        //   230: iload_1        
        //   231: iload           4
        //   233: iload           5
        //   235: aload           12
        //   237: invokestatic    cg.Code:([BIIIII[I)V
        //   240: aload_0        
        //   241: getfield        al.aA:Lam;
        //   244: getstatic       al.aD:[I
        //   247: iconst_2       
        //   248: iaload         
        //   249: invokevirtual   am.I:(I)Z
        //   252: ifne            310
        //   255: aload_0        
        //   256: getfield        al.aA:Lam;
        //   259: getfield        am.Code:[I
        //   262: astore          12
        //   264: iload_3        
        //   265: iconst_2       
        //   266: iadd           
        //   267: istore          4
        //   269: aload           12
        //   271: iload           4
        //   273: aload           12
        //   275: iload           4
        //   277: iaload         
        //   278: ldc             -2147483648
        //   280: ior            
        //   281: iastore        
        //   282: aload_0        
        //   283: iload_3        
        //   284: invokespecial   al.y:(I)V
        //   287: goto            487
        //   290: aload_0        
        //   291: getfield        al.aA:Lam;
        //   294: getfield        am.Z:[Laz;
        //   297: astore          11
        //   299: goto            18
        //   302: aload_0        
        //   303: invokespecial   al.u:()I
        //   306: istore_1       
        //   307: goto            465
        //   310: iload           9
        //   312: istore          10
        //   314: iload           9
        //   316: ifeq            358
        //   319: iload           9
        //   321: istore          10
        //   323: iload_1        
        //   324: sipush          256
        //   327: if_icmpeq       358
        //   330: iload           9
        //   332: istore          10
        //   334: aload_0        
        //   335: getfield        al.aA:Lam;
        //   338: getstatic       al.aD:[I
        //   341: iconst_0       
        //   342: iaload         
        //   343: getstatic       al.aD:[I
        //   346: iconst_1       
        //   347: iaload         
        //   348: iadd           
        //   349: invokevirtual   am.I:(I)Z
        //   352: ifne            358
        //   355: iconst_0       
        //   356: istore          10
        //   358: getstatic       al.az:Lbb;
        //   361: aload_0        
        //   362: getfield        al.aA:Lam;
        //   365: getfield        am.Code:[I
        //   368: iload_3        
        //   369: iconst_0       
        //   370: iadd           
        //   371: iaload         
        //   372: aload_0        
        //   373: getfield        al.aA:Lam;
        //   376: getfield        am.Code:[I
        //   379: iload_3        
        //   380: iconst_1       
        //   381: iadd           
        //   382: iaload         
        //   383: iload_1        
        //   384: aload_0        
        //   385: getfield        al.aA:Lam;
        //   388: getfield        am.Code:[I
        //   391: iload_3        
        //   392: iconst_2       
        //   393: iadd           
        //   394: iaload         
        //   395: ldc_w           1073741823
        //   398: iand           
        //   399: aload_0        
        //   400: getfield        al.aA:Lam;
        //   403: getfield        am.Code:[I
        //   406: iload_3        
        //   407: iconst_3       
        //   408: iadd           
        //   409: iaload         
        //   410: aload_0        
        //   411: getfield        al.aA:Lam;
        //   414: getfield        am.Code:[I
        //   417: iload_3        
        //   418: iconst_5       
        //   419: iadd           
        //   420: iaload         
        //   421: bipush          16
        //   423: iushr          
        //   424: aload_0        
        //   425: getfield        al.aA:Lam;
        //   428: getfield        am.Code:[I
        //   431: iload_3        
        //   432: iconst_5       
        //   433: iadd           
        //   434: iaload         
        //   435: ldc_w           65535
        //   438: iand           
        //   439: iload           10
        //   441: invokevirtual   bb.Code:(IIIIIIIZ)V
        //   444: iconst_1       
        //   445: istore          9
        //   447: aload_0        
        //   448: monitorexit    
        //   449: iload           9
        //   451: ireturn        
        //   452: iconst_0       
        //   453: istore          9
        //   455: goto            447
        //   458: astore          11
        //   460: aload_0        
        //   461: monitorexit    
        //   462: aload           11
        //   464: athrow         
        //   465: iconst_0       
        //   466: istore_2       
        //   467: iconst_0       
        //   468: istore_3       
        //   469: goto            32
        //   472: iload           6
        //   474: istore          5
        //   476: iload           6
        //   478: ifne            222
        //   481: iconst_m1      
        //   482: istore          5
        //   484: goto            222
        //   487: iload_2        
        //   488: iconst_1       
        //   489: iadd           
        //   490: istore_2       
        //   491: iload_3        
        //   492: bipush          6
        //   494: iadd           
        //   495: istore_3       
        //   496: goto            32
        //   499: iconst_0       
        //   500: istore          4
        //   502: goto            96
        //   505: iconst_0       
        //   506: istore          9
        //   508: goto            125
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      18     458    465    Any
        //  18     25     458    465    Any
        //  32     43     458    465    Any
        //  50     93     458    465    Any
        //  101    122    458    465    Any
        //  129    207    458    465    Any
        //  222    264    458    465    Any
        //  282    287    458    465    Any
        //  290    299    458    465    Any
        //  302    307    458    465    Any
        //  334    355    458    465    Any
        //  358    444    458    465    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2088)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:206)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:94)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:840)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:733)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:610)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:577)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:193)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:160)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:135)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:144)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private void w() {
        if (this.aA.B > 0 && this.aA.C > 0) {
            this.aA.Code(this.aA.B + this.aA.C, 0);
        }
        this.Z = null;
    }
    
    private boolean w(final int n) {
        return n + 2 <= this.ak && q.Z(this.ai, n) + n <= this.ak;
    }
    
    private int x() {
        this.av += 4;
        final int n = this.av - 4;
        return (this.ai[n + 3] & 0xFF) + ((this.ai[n] << 24) + ((this.ai[n + 1] & 0xFF) << 16) + ((this.ai[n + 2] & 0xFF) << 8));
    }
    
    private boolean x(final int n) {
        return this.Z(this.aA.Code[n + 2] & 0x3FFFFFFF, this.aA.Code[n + 3], this.aA.Code[n + 4] >>> 16, this.aA.Code[n + 4] & 0xFFFF);
    }
    
    private int y() {
        this.av += 3;
        return this.Code(this.av - 3);
    }
    
    private void y(final int n) {
        this.J(this.aA.Code[n + 2] & 0x3FFFFFFF, this.aA.Code[n + 3], this.aA.Code[n + 4] >>> 16, this.aA.Code[n + 4] & 0xFFFF);
    }
    
    private int z() {
        return this.y() << 8 >> 8;
    }
    
    private boolean z(int i) {
        i += 17;
        int n = i + 1;
        int n2;
        for (i = this.Z(i); i > 0; --i) {
            n2 = n + 1;
            if (this.Z(n) == 116 && this.J(n2).equals("s")) {
                return true;
            }
            n = this.I(n2) + 2 + n2;
        }
        return false;
    }
    
    final cb B(final int n) {
    Label_0108_Outer:
        while (true) {
            int n2 = 0;
            monitorenter(this);
            cb cb = null;
            while (true) {
                int n3 = 0;
                int n8 = 0;
                int n9 = 0;
                Label_0250: {
                    int n4 = 0;
                    Label_0243: {
                        try {
                            final int av = this.av;
                            final int ap = this.ap;
                            final int aq = this.aq;
                            n3 = -1;
                            this.av = this.aj;
                            n4 = 0;
                            int n5 = 0;
                            int n6 = 0;
                            while (this.av < n) {
                                final int av2 = this.av;
                                final int d = this.D();
                                switch (d) {
                                    case 66:
                                    case 70:
                                    case 73:
                                    case 84: {
                                        this.F();
                                        n4 += this.ap;
                                        final int n7 = n8 = n2 + this.aq;
                                        n9 = n4;
                                        if (d != 84) {
                                            break Label_0250;
                                        }
                                        n8 = n7;
                                        n9 = n4;
                                        if (!this.z(av2)) {
                                            n5 = n7;
                                            n6 = n4;
                                            n3 = n7;
                                            final int n10 = av2;
                                            this.K(d);
                                            n9 = n10;
                                            n2 = n3;
                                            n3 = n9;
                                            continue Label_0108_Outer;
                                        }
                                        break Label_0250;
                                    }
                                    default: {
                                        break Label_0243;
                                    }
                                }
                            }
                            if (n3 > 0) {
                                cb = new cb(this, n3, n6, n5);
                            }
                            this.ap = ap;
                            this.aq = aq;
                            this.av = av;
                            return cb;
                        }
                        finally {
                            monitorexit(this);
                        }
                    }
                    n9 = n4;
                    n8 = n2;
                }
                final int n10 = n3;
                n3 = n8;
                int n4 = n9;
                continue;
            }
        }
    }
    
    final void B(final int n, final int n2) {
        synchronized (this) {
            u.Z.Code(n2, 0, 5, false);
            final int[] t = this.T;
            final int[] i = u.Z.I;
            final p z = u.Z;
            System.arraycopy(t, n * 5, i, 0, 5);
            u.Z.p();
        }
    }
    
    final boolean B() {
        if (this.Z != null) {
            synchronized (this) {
                this.w();
                return true;
            }
        }
        return false;
    }
    
    final int C() {
        return this.ah;
    }
    
    final void C(int n) {
        while (true) {
            int n2 = 0;
            while (true) {
                int n3;
                synchronized (this) {
                    final int d = D(n);
                    final int[] i = u.Z.I;
                    final p z = u.Z;
                    i[1] = 0;
                    n = 0;
                    if (n >= d) {
                        i[0] = n2;
                        u.Z.p();
                        return;
                    }
                    i[n + 2] = ((i[n + 2] & 0xFF000000) | n2);
                    n3 = n2;
                    if ((i[n + 2] & Integer.MIN_VALUE) != 0x0) {
                        n3 = n2 + this.T[n * 5 + 1];
                        if ((i[n + 2] & 0x40000000) == 0x0) {
                            i[1] += this.T[n * 5 + 1];
                            n3 = n3;
                        }
                    }
                }
                ++n;
                n2 = n3;
                continue;
            }
        }
    }
    
    final boolean C(final int n, int n2) {
        while (true) {
            boolean b = false;
            int n3 = 0;
            Label_0090: {
                synchronized (this) {
                    if (this.O()) {
                        n3 = D(n2);
                        final int[] i = u.Z.I;
                        final p z = u.Z;
                        n2 = this.I(i, 2, n3, this.M);
                        n3 = this.I(i, 2, n3, this.M + this.O);
                        if (n2 != n3) {
                            break Label_0090;
                        }
                        this.N = 0;
                    }
                    return b;
                }
            }
            if (n2 < 0) {
                n2 = Math.max(n3 - this.O, 0);
            }
            else if (n3 < 0) {
                final Throwable t;
                n3 = Math.min(this.O + n2, t[0]);
            }
            u.Z.Code(n, 0, 4, false);
            final int[] j = u.Z.I;
            final p z2 = u.Z;
            j[0] = this.L;
            final int[] k = u.Z.I;
            final p z3 = u.Z;
            k[1] = n2;
            final int[] l = u.Z.I;
            final p z4 = u.Z;
            l[2] = this.N;
            final int[] m = u.Z.I;
            final p z5 = u.Z;
            m[3] = n3 - n2;
            u.Z.p();
            this.N = 0;
            b = true;
            return b;
        }
    }
    
    final int Code() {
        return this.ai.length;
    }
    
    final int Code(final int n) {
        return Code(this.ai, n);
    }
    
    final int Code(int o, char c, int i) {
    Label_0175_Outer:
        while (true) {
            final int n = 0;
            int j = 0;
            while (true) {
            Label_0242:
                while (true) {
                    Label_0239: {
                        synchronized (this) {
                            o += this.ai[o + 1] * 10 + 2;
                            if (c == '\0') {
                                c = (char)this.I(o);
                                o += 2;
                                c += (char)o;
                                if (i == 0) {
                                    u.Z.o((c - o) / 3);
                                }
                                else {
                                    u.Z.p((c - o) / 3);
                                }
                                final p z = u.Z;
                                int n2;
                                for (i = o, o = j; i < c; i = this.Z(i), j = this.I(n2), u.Z.I[o] = (i << 16 | j), ++o, i = n2 + 2) {
                                    n2 = i + 1;
                                }
                            }
                            else {
                                o += this.I(o) + 2 + 1;
                                int n3 = 0;
                                Block_7: {
                                    for (int k = this.ai[o - 1]; k > 0; --k) {
                                        n3 = o + 1;
                                        if (this.Z(o) == c) {
                                            break Block_7;
                                        }
                                        o = this.I(n3) + 2 + n3;
                                    }
                                    break Label_0242;
                                }
                                c = (char)this.I(n3);
                                o = n3 + 2;
                                c += (char)o;
                                if (c < o) {
                                    o = n;
                                    return o;
                                }
                                break Label_0239;
                            }
                        }
                        o = u.Z.o();
                        return o;
                    }
                    continue Label_0175_Outer;
                }
                c = '\0';
                continue;
            }
        }
    }
    
    final int Code(int n, final int n2) {
        while (true) {
            while (true) {
                int n3 = 0;
                Label_0153: {
                    synchronized (this) {
                        n3 = this.aG;
                        if (n3 == -1) {
                            n = 0;
                            return n;
                        }
                        final int a = A(n2);
                        final int[] i = u.Z.I;
                        final p z = u.Z;
                        this.av = this.aG;
                        while (this.av <= this.ab) {
                            this.aG = this.av;
                            ++this.av;
                            n3 = this.D();
                            if (n3 > 0) {
                                this.E();
                                this.aq = this.I(i, 0, a, this.aq);
                                if (this.aq >= 0) {
                                    break Label_0153;
                                }
                                this.av += (n3 - 1) * 10;
                            }
                            this.av += this.A();
                            this.Q();
                        }
                        return 0;
                    }
                }
                if (cg.Code(this.aH, this.aI, this.aJ, this.aK, this.ap, this.aq, this.ar, this.as)) {
                    this.a(n, n2, this.aG);
                    this.aG = this.av;
                    n = 1;
                    return n;
                }
                --n3;
                continue;
            }
            n = 0;
            return n;
        }
    }
    
    final int Code(int i, int n, int n2, int n3, final int n4, int n5) {
        if (this.ac == null) {
            return 0;
        }
        final int a = A(n5);
        final int[] j = u.Z.I;
        final p z = u.Z;
        int k = 0;
        n5 = 0;
        while (k < this.ac.length) {
            this.ac[k + 4] = this.I(j, 0, a, this.ac[k + 1]);
            if (this.ac[k + 4] >= 0 && cg.Code(n4, n3, n2, n, this.ac[k + 0], this.ac[k + 4], this.ac[k + 2], this.ac[k + 3])) {
                ++n5;
            }
            else {
                this.ac[k + 4] = -1;
            }
            k += 5;
        }
        if (i == 0) {
            u.Z.o(n5 * 4);
        }
        else {
            u.Z.p(n5 * 4);
        }
        final p z2 = u.Z;
        n = 0;
        int[] l;
        int[] m;
        int[] i2;
        int[] i3;
        for (i = 0; i < this.ac.length; i += 5, n = n2) {
            n2 = n;
            if (this.ac[i + 4] >= 0) {
                l = u.Z.I;
                n2 = n + 1;
                l[n] = this.ac[i + 0];
                m = u.Z.I;
                n = n2 + 1;
                m[n2] = this.ac[i + 4];
                i2 = u.Z.I;
                n3 = n + 1;
                i2[n] = this.ac[i + 2];
                i3 = u.Z.I;
                n2 = n3 + 1;
                i3[n3] = this.ac[i + 3];
            }
        }
        return u.Z.o();
    }
    
    final int Code(int av, final int[] array) {
        this.av = av;
        while (this.av < this.ak) {
            av = this.av;
            final int d = this.D();
            switch (d) {
                case 66:
                case 70:
                case 73:
                case 84: {
                    this.F();
                    this.ap += array[0];
                    this.aq += array[1];
                    array[0] = this.ap;
                    array[1] = this.aq;
                    break;
                }
            }
            if (d == 84) {
                return av;
            }
            this.K(d);
        }
        return -1;
    }
    
    final int Code(final Object o, int e) {
        synchronized (this) {
            e = ((int[])((Object[])o)[2])[e];
            e = this.E(e + q.Z(this.ai, e) + 2);
            return e;
        }
    }
    
    final int Code(final Object o, final au au, int code) {
        synchronized (this) {
            this.av = ((int[])((Object[])o)[2])[code];
            this.G();
            code = au.Code(this.H());
            return code;
        }
    }
    
    public final int Code(final String b, final int[] array, int c) {
        final int n = 0;
        final int n2 = 0;
        monitorenter(this);
        while (true) {
            Label_0241: {
                if (array == null) {
                    break Label_0241;
                }
                while (true) {
                    try {
                        final int a = A(c);
                        final int[] i = u.Z.I;
                        final p z = u.Z;
                        if (b.equals(this.Code.B) && this.aL != null) {
                            if (!this.aL.Code()) {
                                c = n2;
                            }
                            else {
                                final bh code = this.Code;
                                c = n;
                                if (this.Code.C < this.aL.I() - 1) {
                                    c = this.Code.C + 1;
                                }
                                code.C = c;
                                if (array != null) {
                                    this.Code(i, a, array);
                                }
                                if (this.Code.C == 0) {
                                    return 2;
                                }
                                c = 1;
                            }
                        }
                        else {
                            if (this.aL != null) {
                                this.l();
                            }
                            this.Code.B = b;
                            (this.aL = new ca()).Code(this, this.aj, b);
                            c = n2;
                            if (this.aL.Code()) {
                                if (this.Code.C == -1) {
                                    this.Code.C = 0;
                                }
                                if (array != null) {
                                    this.Code(i, a, array);
                                }
                                c = 1;
                            }
                        }
                        return c;
                    }
                    finally {
                        monitorexit(this);
                    }
                    break;
                    c = 2;
                    return c;
                }
            }
            final int[] i = null;
            final int a = 0;
            continue;
        }
    }
    
    final cb Code(int n, int code, final int n2) {
        final int av;
        final int ap;
        final int aq;
        synchronized (this) {
            av = this.av;
            ap = this.ap;
            aq = this.aq;
            final int[] array = { code, n2, 0, 0 };
            cb cb = null;
            while (cb == null && n != -1) {
                this.av = n + 1 + 10;
                this.K(84);
                code = this.Code(this.av, array);
                if ((n = code) != -1) {
                    n = code;
                    if (this.z(code)) {
                        continue;
                    }
                    cb = new cb(this, code, array[0], array[1]);
                    n = code;
                }
            }
        }
        this.ap = ap;
        this.aq = aq;
        this.av = av;
        monitorexit(this);
        return;
    }
    
    final void Code(final int ak, final int aj, final int ai, final int ah) {
        if (this.aa == 0) {
            this.aG = -1;
            return;
        }
        this.aG = this.aa;
        this.aH = ah;
        this.aI = ai;
        this.aJ = aj;
        this.aK = ak;
    }
    
    final void Code(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final int p6, final boolean p7) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ifeq            143
        //     5: getstatic       al.aE:[Laz;
        //     8: astore          10
        //    10: iconst_0       
        //    11: istore          9
        //    13: iload           9
        //    15: getstatic       u.b:I
        //    18: if_icmpgt       250
        //    21: aload_0        
        //    22: iload_2        
        //    23: iload_3        
        //    24: iload           4
        //    26: iload           5
        //    28: iload           6
        //    30: iload           7
        //    32: aload           10
        //    34: invokespecial   al.Code:(IIIIII[Laz;)Laz;
        //    37: astore          10
        //    39: aload           10
        //    41: ifnonnull       49
        //    44: iload           9
        //    46: ifle            136
        //    49: aload_0        
        //    50: monitorenter   
        //    51: aload_0        
        //    52: getfield        al.aA:Lam;
        //    55: iload_1        
        //    56: invokevirtual   am.Z:(I)I
        //    59: istore_1       
        //    60: aload           10
        //    62: ifnull          99
        //    65: aload_0        
        //    66: getfield        al.aA:Lam;
        //    69: astore          11
        //    71: iload_3        
        //    72: sipush          256
        //    75: if_icmpne       237
        //    78: iconst_1       
        //    79: istore          8
        //    81: aload           11
        //    83: iload_1        
        //    84: iload           8
        //    86: aload           10
        //    88: getstatic       al.aE:[Laz;
        //    91: iconst_0       
        //    92: aaload         
        //    93: invokevirtual   am.Code:(IZLaz;Laz;)Z
        //    96: ifne            126
        //    99: aload_0        
        //   100: getfield        al.aA:Lam;
        //   103: getfield        am.Code:[I
        //   106: astore          10
        //   108: iload_1        
        //   109: bipush          6
        //   111: imul           
        //   112: iconst_2       
        //   113: iadd           
        //   114: istore_2       
        //   115: aload           10
        //   117: iload_2        
        //   118: aload           10
        //   120: iload_2        
        //   121: iaload         
        //   122: ldc             -2147483648
        //   124: ior            
        //   125: iastore        
        //   126: aload_0        
        //   127: iload_1        
        //   128: bipush          6
        //   130: imul           
        //   131: invokespecial   al.y:(I)V
        //   134: aload_0        
        //   135: monitorexit    
        //   136: getstatic       al.aE:[Laz;
        //   139: iconst_0       
        //   140: aconst_null    
        //   141: aastore        
        //   142: return         
        //   143: aconst_null    
        //   144: astore          10
        //   146: goto            10
        //   149: astore          10
        //   151: getstatic       al.aE:[Laz;
        //   154: iconst_0       
        //   155: aconst_null    
        //   156: aastore        
        //   157: aconst_null    
        //   158: astore          10
        //   160: iload           9
        //   162: getstatic       u.b:I
        //   165: if_icmpeq       250
        //   168: aload_0        
        //   169: getfield        al.B:Z
        //   172: ifeq            186
        //   175: aload_0        
        //   176: getfield        al.Z:Lam;
        //   179: ifnull          186
        //   182: aload_0        
        //   183: invokespecial   al.w:()V
        //   186: getstatic       u.I:Lu;
        //   189: invokevirtual   u.h:()V
        //   192: aload_0        
        //   193: getfield        al.Code:Lbh;
        //   196: getfield        bh.Code:Lu;
        //   199: astore          11
        //   201: iload           9
        //   203: ifle            231
        //   206: iconst_1       
        //   207: istore          8
        //   209: aload           11
        //   211: iload           8
        //   213: invokevirtual   u.Code:(Z)V
        //   216: getstatic       u.I:Lu;
        //   219: invokevirtual   u.i:()V
        //   222: iload           9
        //   224: iconst_1       
        //   225: iadd           
        //   226: istore          9
        //   228: goto            13
        //   231: iconst_0       
        //   232: istore          8
        //   234: goto            209
        //   237: iconst_0       
        //   238: istore          8
        //   240: goto            81
        //   243: astore          10
        //   245: aload_0        
        //   246: monitorexit    
        //   247: aload           10
        //   249: athrow         
        //   250: aconst_null    
        //   251: astore          10
        //   253: goto            39
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  21     39     149    237    Ljava/lang/Throwable;
        //  51     60     243    250    Any
        //  65     71     243    250    Any
        //  81     99     243    250    Any
        //  99     108    243    250    Any
        //  126    136    243    250    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0081:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2604)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:209)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:94)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:840)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:733)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:610)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:577)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:193)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:160)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:135)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:333)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:254)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:144)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    final void Code(final int n, final int n2, final int n3, int n4, final int n5, final boolean b, final boolean b2, final boolean f, final int n6, final int n7, final int n8) {
        int[] i;
        Object o;
        int[] e;
        int d;
        p z;
        int n9;
        int n10 = 0;
        int[] array = null;
        int[] e2;
        int n11;
        int n12;
        int n13;
        int z2;
        int[] array2;
        int n14;
        int n15;
        int n16;
        int n17;
        int n18;
        int n19;
        int n20;
        int[] array3;
        int n21;
        int n22;
        Label_0220_Outer:Label_0255_Outer:
        while (true) {
        Label_0255:
            while (true) {
            Label_0142_Outer:
                while (true) {
                Label_0142:
                    while (true) {
                    Label_0220:
                        while (true) {
                            synchronized (this) {
                                this.E[0] = n2 * 4;
                                if (this.E[0] > this.E.length) {
                                    (this.E = new int[this.E[0] + 1])[0] = this.E.length - 1;
                                }
                                u.Z.Code(n, 0, this.E[0], true);
                                i = u.Z.I;
                                o = u.Z;
                                System.arraycopy(i, 0, this.E, 1, this.E[0]);
                                e = this.E;
                                if (this.T != null) {
                                    d = D(n4);
                                    o = u.Z.I;
                                    z = u.Z;
                                    n4 = o[1];
                                    n9 = 2;
                                    break Label_0220;
                                }
                                o = null;
                                n9 = 0;
                                d = 0;
                                n4 = 0;
                                break Label_0220;
                                while (true) {
                                    this.L = 0;
                                    this.M = 0;
                                    this.N = this.x;
                                    this.O = this.y;
                                    break Label_0220;
                                    n10 = 1;
                                    break Label_0255;
                                    Block_18: {
                                        while (true) {
                                            iftrue(Label_0309:)(array[n10 + 3] != 0);
                                            Block_21: {
                                                break Block_21;
                                                this.E = e2;
                                                this.Code(u.Z, n, n2, this.E, n3, n5, b, b2, f, n6, n7, n8);
                                                iftrue(Label_0951:)(f);
                                                break Block_18;
                                            }
                                            array[0] -= 4;
                                            System.arraycopy(array, n10 + 4, array, n10, array[0] + 1 - n10);
                                            break Label_0142_Outer;
                                            iftrue(Label_0429:)(n10 >= array[0]);
                                            continue Label_0142_Outer;
                                        }
                                        this.G = this.F;
                                        this.F = f;
                                        return;
                                        Label_0309: {
                                            n11 = array[n10 + 0];
                                        }
                                        n12 = array[n10 + 1];
                                        array[n10 + 0] = this.c(n11, n3);
                                        array[n10 + 1] = this.C(n12, n3, n4);
                                        array[n10 + 2] = this.c(n11 + array[n10 + 2], n3) - array[n10 + 0];
                                        array[n10 + 3] = this.C(n12 + array[n10 + 3], n3, n4) - array[n10 + 1];
                                        break Label_0142_Outer;
                                    }
                                    this.K = false;
                                    iftrue(Label_0220:)(n3 == this.H);
                                    continue Label_0220_Outer;
                                }
                            }
                            Label_0429: {
                                e2 = array;
                            }
                            if (this.T == null) {
                                continue Label_0142;
                            }
                            n4 = 1;
                            while (true) {
                                e2 = array;
                                if (n4 >= array[0]) {
                                    continue Label_0142;
                                }
                                n13 = array[n4 + 1];
                                z2 = this.Z((int[])o, n9, d, n13);
                                if (z2 >= d) {
                                    array[0] -= 4;
                                    System.arraycopy(array, n4 + 4, array, n4, array[0] + 1 - n4);
                                    n4 -= 4;
                                    array2 = array;
                                }
                                else {
                                    array[n4 + 1] = this.T[z2 * 5 + 0] + n13 - (o[n9 + z2] & 0xFFFFFF);
                                    n14 = (o[n9 + z2] & 0xFFFFFF) + this.T[z2 * 5 + 1];
                                    n10 = n4;
                                    n15 = 1;
                                    n4 = n14;
                                    while (true) {
                                        n16 = z2 + 1;
                                        if (n16 >= d || n4 >= array[n10 + 3] + n13) {
                                            break;
                                        }
                                        if ((o[n9 + n16] & Integer.MIN_VALUE) == 0x0) {
                                            z2 = n16;
                                            if (n15 == 0) {
                                                continue Label_0220_Outer;
                                            }
                                            n17 = n4 - n13;
                                            n18 = array[n10 + 0];
                                            n19 = array[n10 + 1];
                                            n20 = array[n10 + 2];
                                            array3 = array;
                                            if (array[0] + 4 >= array.length) {
                                                array3 = new int[array.length + 8];
                                                System.arraycopy(array, 0, array3, 0, array.length);
                                            }
                                            System.arraycopy(array3, n10, array3, n10 + 4, array3[0] + 1 - n10);
                                            array3[0] += 4;
                                            array3[n10 + 0] = n18;
                                            array3[n10 + 1] = n19;
                                            array3[n10 + 2] = n20;
                                            array3[n10 + 3] = n17;
                                            n10 += 4;
                                            n21 = n10 + 3;
                                            array3[n21] -= n17;
                                            n15 = 0;
                                            n13 = n4;
                                            array = array3;
                                            z2 = n16;
                                        }
                                        else {
                                            if ((n22 = n15) == 0) {
                                                array[n10 + 1] = this.T[n16 * 5 + 0];
                                                n22 = 1;
                                            }
                                            n4 += this.T[n16 * 5 + 1];
                                            n15 = n22;
                                            z2 = n16;
                                        }
                                    }
                                    n4 = n10;
                                    array2 = array;
                                    if (n15 == 0) {
                                        array[0] -= 4;
                                        System.arraycopy(array, n10 + 4, array, n10, array[0] + 1 - n10);
                                        n4 = n10 - 4;
                                        array2 = array;
                                    }
                                }
                                n4 += 4;
                                array = array2;
                            }
                            Label_0951:
                            if (n8 <= 0) {
                                this.K = false;
                                continue Label_0220;
                            }
                            if (!this.F) {
                                this.H = Math.min(n3, n8);
                                this.K = true;
                                continue Label_0220;
                            }
                            continue Label_0220;
                        }
                        if (n3 == 0) {
                            array[0] = 0;
                            e2 = array;
                            continue Label_0142;
                        }
                        break;
                    }
                    continue Label_0255_Outer;
                }
                n10 += 4;
                continue Label_0255;
            }
        }
    }
    
    final void Code(int d, final String s) {
        synchronized (this) {
            this.N(d);
            this.av += 15;
            d = this.D();
            ++this.av;
            this.Code.Code(s, d, this.H());
        }
    }
    
    final void Code(final int n, final boolean b) {
        synchronized (this) {
            this.Code(u.Z, n, b);
        }
    }
    
    final void Code(final by by, final DataInputStream dataInputStream, int i, int j) {
        this.o = (j << 16 | dataInputStream.readUnsignedShort()) + by.n() - i;
        this.Code.Code(this.o);
        this.Code.Z(3);
        if (cg.K[3] != null && cg.K[1] != null) {
            cg.Code(3, null, true);
        }
        final int n = by.n();
        final long currentTimeMillis = System.currentTimeMillis();
        final int code = Code((DataInput)dataInputStream);
        int k = 0;
        int n2 = 0;
        int[] array = null;
    Label_0088:
        while (true) {
            while (k < code) {
                final byte byte1 = dataInputStream.readByte();
                if (byte1 >= 0) {
                    j = dataInputStream.readUnsignedShort();
                    i = j + 3 + k;
                }
                else {
                    j = dataInputStream.readInt();
                    i = j + 5 + k;
                }
                final int n3 = byte1 & 0x7F;
                switch (n3) {
                    default: {
                        if (by.o()) {
                            switch (n3) {
                                default: {
                                    cg.Code((InputStream)dataInputStream, j);
                                    k = i;
                                    continue;
                                }
                                case 75: {
                                    j = dataInputStream.readUnsignedByte();
                                    final String utf = dataInputStream.readUTF();
                                    if (j == 0) {
                                        ((Object[])bx.Z.get(by.s().Z()))[1] = utf;
                                        k = i;
                                        continue;
                                    }
                                    cg.Code(j, utf, true);
                                    k = i;
                                    continue;
                                }
                                case 101: {
                                    j = dataInputStream.readInt();
                                    final byte byte2 = dataInputStream.readByte();
                                    final String utf2 = dataInputStream.readUTF();
                                    this.Code.a();
                                    u.Z.b(u.Z.Code(utf2));
                                    u.Z.c(j);
                                    u.Z.c(byte2);
                                    u.I.I(this.Code.C(), 17);
                                    k = i;
                                    continue;
                                }
                                case 87: {
                                    dataInputStream.readUTF();
                                    dataInputStream.readUTF();
                                    this.an = dataInputStream.readUTF();
                                    this.ao = dataInputStream.readUTF();
                                    final byte byte3 = dataInputStream.readByte();
                                    j = 0;
                                    while (true) {
                                        k = i;
                                        if (j >= byte3) {
                                            continue Label_0088;
                                        }
                                        this.am.addElement(dataInputStream.readUTF());
                                        ++j;
                                    }
                                    break;
                                }
                                case 72: {
                                    final String utf3 = dataInputStream.readUTF();
                                    final String utf4 = dataInputStream.readUTF();
                                    final String utf5 = dataInputStream.readUTF();
                                    String s2;
                                    final String s = s2 = dataInputStream.readUTF();
                                    if (s.equals("")) {
                                        s2 = s;
                                        if (utf5 != null) {
                                            j = utf5.indexOf("auth_server=");
                                            s2 = s;
                                            if (j >= 0) {
                                                j += "auth_server=".length();
                                                final int index = utf5.indexOf(38, j);
                                                s2 = s;
                                                if (index > j) {
                                                    s2 = utf5.substring(j, index);
                                                }
                                            }
                                        }
                                    }
                                    this.Code.a();
                                    u.Z.b(u.Z.Code(s2));
                                    u.Z.b(u.Z.Code(utf3));
                                    u.Z.b(u.Z.Code(utf4));
                                    u.Z.b(u.Z.Code(utf5));
                                    u.I.I(this.Code.C(), 24);
                                    k = i;
                                    continue;
                                }
                                case 70: {
                                    this.c = dataInputStream.readUTF();
                                    this.d = dataInputStream.readLong();
                                    this.e = dataInputStream.readUTF();
                                    this.f = dataInputStream.readUTF();
                                    final byte byte4 = dataInputStream.readByte();
                                    j = 0;
                                    while (true) {
                                        k = i;
                                        if (j >= byte4) {
                                            continue Label_0088;
                                        }
                                        final char c = (char)dataInputStream.readByte();
                                        final String utf6 = dataInputStream.readUTF();
                                        switch (c) {
                                            case 111: {
                                                this.g = utf6;
                                                break;
                                            }
                                            case 115: {
                                                this.h = utf6;
                                                break;
                                            }
                                        }
                                        ++j;
                                    }
                                    break;
                                }
                                case 67: {
                                    this.r = dataInputStream.readUnsignedByte();
                                    k = i;
                                    continue;
                                }
                                case 79: {
                                    n2 = (j - 2) / 9;
                                    array = new int[n2 * 3];
                                    dataInputStream.readUnsignedShort();
                                    final byte[] array2 = new byte[n2 * 9];
                                    dataInputStream.readFully(array2);
                                    for (j = 0; j < n2; ++j) {
                                        array[j * 3 + 0] = Code(array2, j * 9 + 0);
                                        array[j * 3 + 1] = Code(array2, j * 9 + 3);
                                        array[j * 3 + 2] = Code(array2, j * 9 + 6);
                                    }
                                    k = i;
                                    continue;
                                }
                                case 68: {
                                    final String utf7 = dataInputStream.readUTF();
                                    final String utf8 = dataInputStream.readUTF();
                                    final String utf9 = dataInputStream.readUTF();
                                    this.Code.a();
                                    u.Z.c(0);
                                    u.Z.b(u.Z.Code(utf7));
                                    u.Z.b(u.Z.Code(utf8));
                                    u.Z.b(u.Z.Code(utf9));
                                    u.Z.b(0);
                                    u.Z.b(0);
                                    u.Z.b(0);
                                    u.I.I(this.Code.C(), 27);
                                    k = i;
                                    continue;
                                }
                                case 78: {
                                    final String utf10 = dataInputStream.readUTF();
                                    final String utf11 = dataInputStream.readUTF();
                                    final String utf12 = dataInputStream.readUTF();
                                    final String utf13 = dataInputStream.readUTF();
                                    final String utf14 = dataInputStream.readUTF();
                                    this.Code.a();
                                    u.Z.c(1);
                                    u.Z.b(u.Z.Code(utf10));
                                    u.Z.b(u.Z.Code(utf11));
                                    u.Z.b(u.Z.Code(utf14));
                                    u.Z.b(u.Z.Code(utf12));
                                    u.Z.b(u.Z.Code(utf13));
                                    u.Z.b(0);
                                    u.I.I(this.Code.C(), 27);
                                    k = i;
                                    continue;
                                }
                                case 80: {
                                    final String utf15 = dataInputStream.readUTF();
                                    final String utf16 = dataInputStream.readUTF();
                                    final String utf17 = dataInputStream.readUTF();
                                    final String utf18 = dataInputStream.readUTF();
                                    final String utf19 = dataInputStream.readUTF();
                                    final String utf20 = dataInputStream.readUTF();
                                    this.Code.a();
                                    u.Z.c(2);
                                    u.Z.b(u.Z.Code(utf15));
                                    u.Z.b(u.Z.Code(utf16));
                                    u.Z.b(u.Z.Code(utf20));
                                    u.Z.b(u.Z.Code(utf17));
                                    u.Z.b(u.Z.Code(utf18));
                                    u.Z.b(u.Z.Code(utf19));
                                    u.I.I(this.Code.C(), 27);
                                    k = i;
                                    continue;
                                }
                                case 112: {
                                    u.Code.I(dataInputStream.readUTF());
                                    k = i;
                                    continue;
                                }
                                case 111: {
                                    j = dataInputStream.readShort();
                                    k = i;
                                    if (this.B) {
                                        this.Code.B(j);
                                        k = i;
                                        continue;
                                    }
                                    continue;
                                }
                                case 108: {
                                    bp.Z(dataInputStream.readInt());
                                    k = i;
                                    continue;
                                }
                                case 103: {
                                    k = i;
                                    if (!u.e) {
                                        u.I.w();
                                        this.Code.a();
                                        u.I.Z(40);
                                        k = i;
                                        continue;
                                    }
                                    continue;
                                }
                                case 65: {
                                    final byte[] array3 = new byte[j];
                                    dataInputStream.readFully(array3);
                                    this.Code.a();
                                    u.Z.b(u.Z.Code(array3));
                                    u.I.Z(43);
                                    k = i;
                                    continue;
                                }
                                case 89: {
                                    u.Code.ae();
                                    k = i;
                                    continue;
                                }
                                case 97: {
                                    final byte[] array4 = new byte[j];
                                    dataInputStream.readFully(array4);
                                    this.Code.a();
                                    u.Z.b(u.Z.Code(array4));
                                    u.I.Z(41);
                                    k = i;
                                    continue;
                                }
                            }
                        }
                        else {
                            switch (n3) {
                                default: {
                                    cg.Code((InputStream)dataInputStream, j);
                                    k = i;
                                    continue;
                                }
                                case 75: {
                                    j = dataInputStream.readUnsignedByte();
                                    final String utf21 = dataInputStream.readUTF();
                                    k = i;
                                    if (j == 1) {
                                        cg.Code(3, utf21, true);
                                        k = i;
                                        continue;
                                    }
                                    continue;
                                }
                            }
                        }
                        break;
                    }
                    case 102: {
                        cg.Code((InputStream)dataInputStream, j);
                        j = Thread.currentThread().getPriority();
                        Thread.currentThread().setPriority(1);
                        this.Code.l();
                        cg.Code(true);
                        Thread.currentThread().setPriority(j);
                        k = i;
                        continue;
                    }
                    case 76: {
                        this.s = dataInputStream.readByte();
                        this.t = dataInputStream.readShort();
                        k = i;
                        continue;
                    }
                    case 99: {
                        final byte byte5 = dataInputStream.readByte();
                        j = 0;
                        while (true) {
                            k = i;
                            if (j == byte5) {
                                continue Label_0088;
                            }
                            final short short1 = dataInputStream.readShort();
                            int byte6 = -1;
                            if (short1 == 1) {
                                byte6 = dataInputStream.readByte();
                            }
                            final int int1 = dataInputStream.readInt();
                            final int unsignedShort = dataInputStream.readUnsignedShort();
                            if (byte6 == 4) {
                                cg.O = int1;
                                cg.P = dataInputStream.readUTF();
                                cg.a("md");
                                final u l = u.I;
                                u.v();
                                this.Code.a();
                                u.Z.b(u.Z.Code(cg.P));
                                u.I.Z(37);
                            }
                            else {
                                byte[] array5 = new byte[unsignedShort];
                                dataInputStream.readFully(array5);
                                switch (byte6) {
                                    default: {
                                        u.I.h();
                                        u.Z.c(byte6);
                                        u.Z.c(int1);
                                        Label_0678: {
                                            if (Code(byte6, array5, array5.length)) {
                                                if (byte6 == 31) {
                                                    final String code2 = u.Code.Code("OM-Upgrade");
                                                    if (code2 != null) {
                                                        final byte[] array6 = new byte[array5.length + q.Code(code2) + 2];
                                                        System.arraycopy(array5, 0, array6, 0, array5.length);
                                                        q.Code(code2, array6, array5.length);
                                                        array5 = array6;
                                                    }
                                                }
                                                while (true) {
                                                    u.Z.b(u.Z.I(array5, 0, array5.length));
                                                    break Label_0678;
                                                    continue;
                                                }
                                            }
                                            u.Z.b(0);
                                        }
                                        u.I.Z(38);
                                        break;
                                    }
                                    case 3: {
                                        bz.Code(int1, array5);
                                        final u m = u.I;
                                        u.v();
                                        break;
                                    }
                                    case 17: {
                                        if (int1 != ce.Code) {
                                            ce.Code(int1, array5);
                                            final u i2 = u.I;
                                            u.v();
                                            bx.Code(ce.Code);
                                            break;
                                        }
                                        break;
                                    }
                                    case 38: {
                                        cg.S = int1;
                                        final byte b = array5[0];
                                        final String[] array7 = new String[b];
                                        byte b2;
                                        int n4;
                                        int i3;
                                        for (b2 = 0, n4 = 1; b2 < b; ++b2, n4 += i3) {
                                            i3 = I(array5, n4, array5.length - n4);
                                            array7[b2] = q.Code(array5, n4);
                                        }
                                        cg.Q = u.Code.Code(array7);
                                        int n5 = n4 + 1;
                                        final byte b3 = array5[n4];
                                        final String[] array8 = new String[b3];
                                        for (byte b4 = 0; b4 < b3; ++b4) {
                                            final int i4 = I(array5, n5, array5.length - n5);
                                            array8[b4] = q.Code(array5, n5);
                                            n5 += i4;
                                        }
                                        cg.R = u.Code.I(array8);
                                        final u i5 = u.I;
                                        u.v();
                                        break;
                                    }
                                    case 40: {
                                        cg.T = int1;
                                        int n6 = 1;
                                        final byte b5 = array5[0];
                                        final HashMap<String, String> hashMap = new HashMap<String, String>();
                                        for (byte b6 = 0; b6 < b5; ++b6) {
                                            final int i6 = I(array5, n6, array5.length - n6);
                                            final String code3 = q.Code(array5, n6);
                                            final int n7 = n6 + i6;
                                            final int i7 = I(array5, n7, array5.length - n7);
                                            final String code4 = q.Code(array5, n7);
                                            n6 = n7 + i7;
                                            hashMap.put(code3, code4);
                                        }
                                        u.Code.Code(hashMap);
                                        final u i8 = u.I;
                                        u.v();
                                        break;
                                    }
                                }
                            }
                            ++j;
                        }
                        break;
                    }
                    case 35: {
                        final byte byte7 = dataInputStream.readByte();
                        j = 0;
                        while (true) {
                            k = i;
                            if (j >= byte7) {
                                continue Label_0088;
                            }
                            final byte byte8 = dataInputStream.readByte();
                            final int unsignedShort2 = dataInputStream.readUnsignedShort();
                            byte[] array9 = null;
                            if (unsignedShort2 > 0) {
                                array9 = new byte[unsignedShort2];
                                dataInputStream.readFully(array9);
                            }
                            final String utf22 = dataInputStream.readUTF();
                            final String utf23 = dataInputStream.readUTF();
                            final int int2 = dataInputStream.readInt();
                            if (byte8 <= 0 || byte8 > 9 || ((utf23.length() > 0 || utf22.length() > 0 || unsignedShort2 > 0) && (utf23.length() == 0 || array9 == null || !cg.I(array9, 0, unsignedShort2)))) {
                                u.I.c(int2);
                            }
                            else {
                                this.Code.a();
                                u.Z.c(int2);
                                u.Z.c(byte8 - 1);
                                u.Z.b(u.Z.Code(utf22));
                                u.Z.b(u.Z.Code(utf23));
                                if (unsignedShort2 > 0) {
                                    u.Z.b(u.Z.I(array9, 0, unsignedShort2));
                                }
                                else {
                                    u.Z.b(0);
                                }
                                u.I.Z(39);
                            }
                            ++j;
                        }
                        break;
                    }
                    case 114: {
                        final String utf24 = dataInputStream.readUTF();
                        final String j2 = this.Code.j();
                        if (!by.o()) {
                            k = i;
                            if (!utf24.equals(j2)) {
                                continue;
                            }
                        }
                        this.Code.b = utf24;
                        throw new RuntimeException();
                    }
                    case 85: {
                        Code(dataInputStream, j, this.Code);
                        k = i;
                        continue;
                    }
                    case 116: {
                        final String utf25 = dataInputStream.readUTF();
                        this.Code.a();
                        u.Z.b(u.Z.Code(utf25));
                        u.I.Z(45);
                        k = i;
                        continue;
                    }
                    case 109: {
                        Code(dataInputStream);
                        k = i;
                        continue;
                    }
                }
            }
            break;
        }
        final int n8 = (dataInputStream.readUnsignedByte() << 16) + dataInputStream.readUnsignedShort();
        this.Code.I(n8);
        i = 0;
    Label_2892_Outer:
        while (true) {
            while (true) {
                if (i <= 4) {
                    try {
                        this.ai = new byte[n8];
                        if (this.I != null && n2 > 0 && this.I.ai == null) {
                            this.ai = null;
                            throw new OutOfMemoryError();
                        }
                    }
                    catch (Throwable t) {
                        u.I.h();
                        this.Code.Code.Code(i > 1);
                        if (i == 0) {
                            if (this.I != null) {
                                this.I.I(false);
                            }
                            u.I.i();
                        }
                        else {
                            if (this.I != null && this.I.J == 0 && i >= u.b) {
                                if (!this.I.C) {
                                    final al i9 = this.I;
                                    i9.ai = null;
                                    i9.aG = -1;
                                    i9.aa = 0;
                                }
                                this.I.I(true);
                            }
                            u.Z.c(i - 1 + 0);
                            u.I.Z(71);
                        }
                        ++i;
                        continue Label_2892_Outer;
                    }
                    break;
                }
                continue;
            }
        }
        if (this.ai == null) {
            this.ai = new byte[n8];
        }
        al i10;
        byte[] ai;
        for (i = 0; i < n2; ++i) {
            i10 = this.I;
            ai = this.ai;
            j = array[i * 3 + 1];
            System.arraycopy(i10.ai, array[i * 3 + 0], ai, j, array[i * 3 + 2]);
        }
        this.I = null;
        this.r(cg.d * 1024);
        this.ak = 0;
        j = 0;
        i = 0;
        while (this.ak < n8) {
            final int ak = this.ak;
            int n9 = j;
            while (this.ak - ak < 1024 && this.ak < n8) {
                if (n9 < n2) {
                    j = array[n9 * 3 + 1] - this.ak;
                }
                else {
                    j = 1024;
                }
                j = Math.min(1024, Math.min(j, n8 - this.ak));
                if (n9 < n2 && this.ak == array[n9 * 3 + 1]) {
                    this.ak += array[n9 * 3 + 2];
                    ++n9;
                }
                else {
                    j = by.read(this.ai, this.ak, j);
                    if (j < 0) {
                        throw new EOFException();
                    }
                    this.ak += j;
                }
            }
            j = n9;
            if (this.B) {
                j = i;
                if (this.aj == 0) {
                    j = i;
                    if (this.q()) {
                        this.s();
                        j = this.aj;
                        this.Code(true);
                        this.aA.Code(this.u());
                    }
                }
                i = j;
                if (this.aj > 0) {
                    this.r();
                    i = this.G(j);
                }
                if (this.R) {
                    this.R = false;
                    if (this.S && !this.Code.h()) {
                        this.Code.a();
                        u.Z.c(this.P);
                        u.Z.c(this.Q);
                        u.I.I(this.Code.C(), 19);
                    }
                }
                this.R();
                j = n9;
            }
        }
        final long n10 = System.currentTimeMillis() - currentTimeMillis;
        if (n10 != 0L) {
            bh.J((int)((by.n() - n) * 1000L / n10));
        }
        if (this.B) {
            if (this.ax != 0) {
                this.Code.a();
                u.I.I(this.Code.C(), 20);
            }
            return;
        }
        this.s();
        i = this.aj;
        this.aA.Code(this.u());
        this.G(this.aj);
    }
    
    final void Code(final cc cc, final int n, int n2) {
        synchronized (this) {
            final int c = cc.C();
            n2 = A(n2);
            final int[] i = u.Z.I;
            final p z = u.Z;
            n2 = this.I(i, 0, n2, c);
            u.Z.Code(n, 0, 3, false);
            final int[] j = u.Z.I;
            final p z2 = u.Z;
            j[0] = cc.B();
            final int[] k = u.Z.I;
            final p z3 = u.Z;
            k[1] = n2;
            final int[] l = u.Z.I;
            final p z4 = u.Z;
            l[2] = cc.b();
            u.Z.p();
        }
    }
    
    final void Code(final String s, final al al) {
        final int code = cg.Code("odp:component", s);
        this.ay = (code < 0 && al == null);
        int i = 0;
        Label_0046_Outer:Label_0083_Outer:
        while (i <= 4) {
            while (true) {
                if (al != null) {
                Block_14_Outer:
                    while (true) {
                        try {
                            this.ai = al.ai;
                            if (this.ai == null) {
                                if (this.ay) {
                                    u.I.h();
                                    u.I.Z(5);
                                }
                                this.Code.Z(7);
                                return;
                            }
                            break;
                            while (true) {
                                this.ai = cg.C(code);
                                continue Block_14_Outer;
                                iftrue(Label_0166:)(this.ay);
                                continue Label_0083_Outer;
                            }
                        }
                        catch (Throwable t) {
                            u.I.h();
                            this.Code.Code.Code(i > 1);
                            if (i == 0) {
                                if (this.I != null) {
                                    this.I.I(false);
                                }
                                u.I.i();
                            }
                            else {
                                u.Z.c(i - 1 + 0);
                                u.I.Z(71);
                            }
                            ++i;
                            continue Label_0046_Outer;
                            Label_0166: {
                                this.ai = u.c.I(s);
                            }
                            continue Label_0083_Outer;
                        }
                        break;
                    }
                    break;
                }
                continue;
            }
        }
        if (this.ai == null) {
            this.Code.Z(7);
            return;
        }
        if (!this.ay && this.ai.length == 0) {
            synchronized (this) {
                this.i = 16;
                this.x = 0;
                this.y = 0;
                this.q = 0;
                this.n = null;
                this.ax = 0;
                this.k = "";
                this.j = "";
                this.S = false;
                this.u = 0;
                this.p = false;
                this.ah = 0;
                this.l = 0;
                this.m = 0;
                this.Y = 2;
                this.aj = 2;
                this.ai = new byte[2];
                this.ak = 2;
                monitorexit(this);
                this.G(this.aj);
                this.Code(true);
                this.Code.Z(5);
                return;
            }
        }
        try {
            if (this.Z(0) != 16) {
                this.Code.Z(7);
                return;
            }
        }
        catch (Throwable t2) {
            this.Code.Z(7);
            return;
        }
        this.ak = this.ai.length;
        this.s();
        this.G(this.aj);
        this.Code(true);
        if (this.ax != 0) {
            this.Code.a();
            u.I.I(this.Code.C(), 20);
        }
        this.R();
        this.Code.Z(5);
    }
    
    final void Code(final String s, final String s2) {
        if (this.Code.a == null) {
            this.Code.a = new Hashtable();
        }
        this.Code.a.put(s2, new Object[] { s, new Integer((int)u.c.C(s)) });
        this.Code.Code(s2);
    }
    
    final void Code(final String s, final String s2, final String s3) {
        this.Code.a();
        u.Z.b(u.Z.Code(s));
        u.Z.b(u.Z.Code(s2));
        u.Z.b(u.Z.Code(s3));
        u.I.I(this.Code.C(), 26);
    }
    
    final void Code(final boolean b) {
        final int n = 1;
        if (b) {
            this.Code.a();
        }
        if (this.Code.C() == 0) {
            u.I.i();
            return;
        }
        u.Z.c(this.x);
        u.Z.c(this.y);
        u.Z.b(this.E(this.m));
        u.Z.b(u.Z.Code(this.j));
        u.Z.b(u.Z.Code(this.n));
        final p z = u.Z;
        Label_0180: {
            if (this.ax == 0) {
                break Label_0180;
            }
            int n2 = 1;
        Label_0130_Outer:
            while (true) {
                z.c(n2);
                final p z2 = u.Z;
                Label_0185: {
                    if (!this.S) {
                        break Label_0185;
                    }
                    int n3 = n;
                Label_0174_Outer:
                    while (true) {
                        z2.c(n3);
                        u.Z.c(this.ah);
                        Label_0190: {
                            if (!this.L()) {
                                break Label_0190;
                            }
                            u.Z.b(this.Code.C());
                            while (true) {
                                try {
                                    u.Z.C(18);
                                    this.B(false);
                                    return;
                                    n2 = 0;
                                    continue Label_0130_Outer;
                                    u.I.I(this.Code.C(), 18);
                                    return;
                                    n3 = 0;
                                    continue Label_0174_Outer;
                                }
                                catch (Throwable t) {
                                    continue;
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
    
    final boolean Code(final ae ae, int d, final ae ae2) {
        boolean b = false;
        monitorenter(this);
        if (d != 0) {
            try {
                d = D(d);
                final int[] i = u.Z.I;
                final p z = u.Z;
                final int j = this.I(i, 2, d, ae2.I());
                if (j >= 0) {
                    ae.Z().Code(this.Code(i, d, ae2.Code(), j), ae2.Code(), j);
                    b = true;
                }
            }
            finally {
                monitorexit(this);
            }
        }
        monitorexit(this);
        return b;
    }
    
    public final boolean Code(final aw aw, int x, int n, int min, int d) {
    Label_0278_Outer:
        while (true) {
            while (true) {
                Label_0651: {
                    while (true) {
                        Label_0648: {
                            while (true) {
                            Label_0638:
                                while (true) {
                                    Label_0608: {
                                        synchronized (this) {
                                            al.az.Code();
                                            try {
                                                final int code = aw.Code();
                                                final int i = aw.I();
                                                final int z = aw.Z();
                                                final int j = aw.J();
                                                aw.Z(code, i, z, j, 16777215);
                                                boolean b;
                                                if (this.T == null || this.ai == null || d == 0) {
                                                    this.z = min;
                                                    x = this.x;
                                                    if (x != 0) {
                                                        al.az.I();
                                                        if (this.G && !this.F && this.aF != null) {
                                                            this.aF.clear();
                                                            this.aF = null;
                                                        }
                                                        b = true;
                                                    }
                                                    else {
                                                        al.az.I();
                                                        if (this.G && !this.F && this.aF != null) {
                                                            this.aF.clear();
                                                            this.aF = null;
                                                        }
                                                        b = false;
                                                    }
                                                }
                                                else {
                                                    d = D(d);
                                                    final int[] k = u.Z.I;
                                                    final p z2 = u.Z;
                                                    if (!this.F) {
                                                        this.H = min;
                                                    }
                                                    else if (!this.K) {
                                                        if (min * 12 >= this.H * 11) {
                                                            break Label_0608;
                                                        }
                                                        this.H = min * 11 / 12;
                                                    }
                                                    final int z3 = this.z;
                                                    aw.I(x, n, this.z = min, this.a(k[0]));
                                                    if (aw.Z() > 0 && aw.J() > 0) {
                                                        if (min <= this.x / 2) {
                                                            break Label_0651;
                                                        }
                                                        final boolean a = true;
                                                        this.A = a;
                                                        if (k[1] <= 0) {
                                                            break Label_0648;
                                                        }
                                                        this.z = this.x;
                                                        this.D = true;
                                                        final int min2 = Math.min(aw.I() - n, k[0] - 1);
                                                        this.Code(aw, x, n, min2, Math.min(aw.J() + min2 - 1, k[1] - 1), k, d);
                                                        this.z = min;
                                                        n += k[1] - this.a(k[1]);
                                                        this.D = this.A;
                                                        min = Math.min(Math.max(k[1], this.M(aw.I() - n)), k[0] - 1);
                                                        this.Code(aw, x, n, min, Math.min(this.M(aw.J()) + min, k[0] - 1), k, d);
                                                    }
                                                    aw.Code(code, i, z, j);
                                                    if (!this.C) {
                                                        break Label_0638;
                                                    }
                                                    al.az.I(this);
                                                    al.az.I();
                                                    if (this.G && !this.F && this.aF != null) {
                                                        this.aF.clear();
                                                        this.aF = null;
                                                    }
                                                    b = true;
                                                }
                                                return b;
                                            }
                                            finally {
                                                al.az.I();
                                                if (this.G && !this.F && this.aF != null) {
                                                    this.aF.clear();
                                                    this.aF = null;
                                                }
                                            }
                                        }
                                    }
                                    if (this.H * 12 < min * 11) {
                                        this.H = min * 12 / 11;
                                        continue Label_0278_Outer;
                                    }
                                    continue Label_0278_Outer;
                                }
                                al.az.Z(this);
                                continue;
                            }
                        }
                        continue;
                    }
                }
                final boolean a = false;
                continue;
            }
        }
    }
    
    final boolean Code(final bw bw, int d, final bw bw2) {
        final boolean b = false;
        monitorenter(this);
        boolean b2;
        if (d == 0) {
            b2 = b;
        }
        else {
            try {
                d = D(d);
                final int[] i = u.Z.I;
                final p z = u.Z;
                final int j = this.I(i, 2, d, bw2.Code().C());
                b2 = b;
                if (j >= 0) {
                    final int k = this.I(i, 2, d, bw2.I().C());
                    b2 = b;
                    if (k >= 0) {
                        bw.Code().Code(this.Code(i, d, bw2.Code().B(), j), bw2.Code().B(), j);
                        bw.I().Code(this.Code(i, d, bw2.I().B(), k), bw2.I().B(), k);
                        b2 = true;
                    }
                }
            }
            finally {
                monitorexit(this);
            }
        }
        monitorexit(this);
        return b2;
    }
    
    final int I(final int n) {
        return ((this.ai[n] & 0xFF) << 8) + (this.ai[n + 1] & 0xFF);
    }
    
    final int I(int i, int z) {
        final int n = 0;
        monitorenter(this);
        int a = 0;
        Label_0012: {
            if (i == 0) {
                a = n;
            }
            else {
                while (true) {
                Label_0119_Outer:
                    while (true) {
                    Label_0282:
                        while (true) {
                            Label_0275: {
                                while (true) {
                                    Label_0270: {
                                        try {
                                            final int q = u.Z.q(i);
                                            a = n;
                                            if (q != 0) {
                                                u.Z.Code(i, 0, q, true);
                                                final p z2 = u.Z;
                                                this.av = this.aa;
                                                int n2 = 0;
                                            Block_10:
                                                while (true) {
                                                    a = n;
                                                    if (this.av > this.ab) {
                                                        break Label_0012;
                                                    }
                                                    n2 = this.av++;
                                                    i = this.D();
                                                    if (i <= 0) {
                                                        break Label_0270;
                                                    }
                                                    this.E();
                                                    final int d = this.d(this.aq, this.U);
                                                    final p z3 = u.Z;
                                                    a = 0;
                                                    if (a >= q + 0) {
                                                        break Label_0282;
                                                    }
                                                    if (u.Z.I[a] != d) {
                                                        break Label_0275;
                                                    }
                                                    this.av += (i - 1) * 10;
                                                    i = 1;
                                                    this.av += this.A();
                                                    if (i != 0) {
                                                        for (i = this.D(); i > 0; --i) {
                                                            if (this.D() == 102) {
                                                                break Block_10;
                                                            }
                                                            this.av += this.A();
                                                        }
                                                    }
                                                    else {
                                                        this.Q();
                                                    }
                                                }
                                                u.Z.Z(z);
                                                i = u.Z.I(6, 54);
                                                z = u.Z.Z();
                                                u.Z.Z(0);
                                                a = this.a(i, z, n2);
                                                break;
                                            }
                                            break;
                                        }
                                        finally {
                                            monitorexit(this);
                                        }
                                    }
                                    i = 0;
                                    continue;
                                }
                            }
                            ++a;
                            continue;
                        }
                        --i;
                        continue Label_0119_Outer;
                    }
                }
            }
        }
        monitorexit(this);
        return a;
    }
    
    final int I(final Object o) {
        synchronized (this) {
            return (int)((Object[])o)[5];
        }
    }
    
    final cb I(int d, final int n, final int n2) {
        synchronized (this) {
            d = D(d);
            final int[] i = u.Z.I;
            final p z = u.Z;
            return this.Code(i, d, n, n2);
        }
    }
    
    final void I(int n, int code, int n2, final int n3) {
    Label_0176_Outer:
        while (true) {
            while (true) {
                Label_0322: {
                    synchronized (this) {
                        n2 = A(n2);
                        final int[] i = u.Z.I;
                        final p z = u.Z;
                        n = this.Code(i, n2, n);
                        u.Z.l(this.Code.I.size() * 2 + 6);
                        u.Z.I("x");
                        u.Z.I(String.valueOf(code));
                        u.Z.I("y");
                        u.Z.I(String.valueOf(n));
                        while (true) {
                            if (this.Z(n3) == 83) {
                                this.av = n3 + 2 + this.ai[n3 + 1] * 10;
                                u.Z.I(cg.Code(this.H()));
                                n2 = u.Z.j();
                                n = this.D();
                                code = n2;
                                if (n > 0) {
                                    switch (this.D()) {
                                        case 116: {
                                            code = u.Z.Code(cg.Code(this.H()));
                                            break;
                                        }
                                        default: {
                                            break Label_0322;
                                        }
                                    }
                                }
                                u.Z.m(code);
                            }
                            final Enumeration keys = this.Code.I.keys();
                            while (keys.hasMoreElements()) {
                                final String s = (String)keys.nextElement();
                                if (!s.startsWith("o:")) {
                                    u.Z.I(cg.Code(s));
                                    u.Z.I(cg.Code(this.Code.I.get(s).toString()));
                                }
                            }
                            break;
                            this.av += this.A();
                            --n;
                            continue Label_0176_Outer;
                        }
                    }
                    break;
                }
                continue;
            }
        }
        u.Z.b(u.Z.n());
        monitorexit(this);
    }
    
    public final void I(final boolean b) {
        monitorenter(this);
        Label_0013: {
            if (!b) {
                break Label_0013;
            }
            try {
                this.t();
                return;
                this.J(true);
            }
            finally {
                monitorexit(this);
            }
        }
    }
    
    final boolean I() {
        return this.ai != null && this.ak == this.ai.length;
    }
    
    final boolean I(final Object o, final int n) {
        synchronized (this) {
            return ((Hashtable)((Object[])o)[3]).containsKey(new Integer(n));
        }
    }
    
    final int J(int code, int a) {
        synchronized (this) {
            a = A(a);
            final int[] i = u.Z.I;
            final p z = u.Z;
            code = this.Code(i, a, code);
            return code;
        }
    }
    
    final ai J(final int n, final int n2, int n3) {
        ai ai;
        String s;
        Object o = null;
        Object o2;
        int a;
        int[] i;
        Object o3 = null;
        int n4 = 0;
        int n5 = 0;
        int d;
        int av = 0;
        String s2 = null;
        Label_0437_Outer:Label_0466_Outer:
        while (true) {
            while (true) {
            Label_0437:
                while (true) {
                Label_0573:
                    while (true) {
                    Label_0490:
                        while (true) {
                            Label_0238_Outer:Label_0378_Outer:
                            while (true) {
                                Label_0550: {
                                    Label_0536: {
                                    Label_0515:
                                        while (true) {
                                            Label_0506: {
                                                while (true) {
                                                    Label_0503: {
                                                        while (true) {
                                                            Label_0477: {
                                                                synchronized (this) {
                                                                    if (this.aa == 0) {
                                                                        ai = new ai(this, n, n2, null, null, null, 0);
                                                                        return ai;
                                                                    }
                                                                    s = null;
                                                                    o = null;
                                                                    o2 = null;
                                                                    this.av = this.aa;
                                                                    a = A(n3);
                                                                    i = u.Z.I;
                                                                    o3 = u.Z;
                                                                    n4 = 0;
                                                                    n3 = 0;
                                                                    Label_0353: {
                                                                        while (this.av <= this.ab) {
                                                                            n5 = this.av;
                                                                            d = this.D();
                                                                            av = this.D();
                                                                            if (av <= 0) {
                                                                                break Label_0477;
                                                                            }
                                                                            this.E();
                                                                            this.aq = this.I(i, 0, a, this.aq);
                                                                            if (this.aq < 0 || !cg.Code(n, n2, 1, 1, this.ap, this.aq, this.ar, this.as)) {
                                                                                break Label_0490;
                                                                            }
                                                                            this.av += (av - 1) * 10;
                                                                            av = this.av;
                                                                            switch (d) {
                                                                                case 76: {
                                                                                    if (s == null) {
                                                                                        s = this.K();
                                                                                        n5 = n3;
                                                                                        n3 = n4;
                                                                                        n4 = n5;
                                                                                        break;
                                                                                    }
                                                                                    break Label_0490;
                                                                                }
                                                                                case 78: {
                                                                                    if (s == null) {
                                                                                        this.av += 7;
                                                                                        s = this.j + "#" + this.H();
                                                                                        n5 = n3;
                                                                                        n3 = n4;
                                                                                        n4 = n5;
                                                                                        break;
                                                                                    }
                                                                                    break Label_0490;
                                                                                }
                                                                                case 105: {
                                                                                    break Label_0353;
                                                                                }
                                                                                default: {
                                                                                    break Label_0490;
                                                                                }
                                                                                case 73: {
                                                                                    break Label_0536;
                                                                                }
                                                                                case 83: {
                                                                                    break Label_0550;
                                                                                }
                                                                            }
                                                                            this.av = av;
                                                                            this.av += this.A();
                                                                            this.Q();
                                                                            n5 = n4;
                                                                            n4 = n3;
                                                                            n3 = n5;
                                                                        }
                                                                        break Label_0573;
                                                                    }
                                                                    o3 = o;
                                                                    if (o == null) {
                                                                        o3 = this.K();
                                                                    }
                                                                    n5 = this.D();
                                                                    o = o2;
                                                                    if (n5 <= 0 || o != null) {
                                                                        break Label_0515;
                                                                    }
                                                                    switch (this.D()) {
                                                                        case 116: {
                                                                            this.H();
                                                                            break Label_0506;
                                                                        }
                                                                        default: {
                                                                            break Label_0503;
                                                                        }
                                                                    }
                                                                    ai = new ai(this, n, n2, s2, (String)o3, (String)o2, n3);
                                                                    return ai;
                                                                    this.av += this.A();
                                                                    break Label_0506;
                                                                }
                                                                o3 = o;
                                                                s2 = s;
                                                                continue Label_0437;
                                                            }
                                                            n5 = n3;
                                                            n3 = n4;
                                                            n4 = n5;
                                                            continue Label_0378_Outer;
                                                        }
                                                        n5 = n3;
                                                        n3 = n4;
                                                        n4 = n5;
                                                        continue Label_0238_Outer;
                                                    }
                                                    continue Label_0466_Outer;
                                                }
                                            }
                                            --n5;
                                            continue Label_0437_Outer;
                                        }
                                        n5 = n3;
                                        o2 = o;
                                        n3 = n4;
                                        n4 = n5;
                                        o = o3;
                                        continue Label_0238_Outer;
                                    }
                                    if (n3 == 0) {
                                        n3 = n4;
                                        n4 = n5;
                                        continue Label_0437_Outer;
                                    }
                                    continue Label_0490;
                                }
                                if (n4 == 0) {
                                    n4 = n3;
                                    n3 = n5;
                                    continue Label_0437_Outer;
                                }
                                break;
                            }
                            continue Label_0490;
                        }
                        --av;
                        continue Label_0437_Outer;
                    }
                    if (n3 != 0 || n4 != 0) {
                        s2 = null;
                        o3 = null;
                        continue Label_0437;
                    }
                    break;
                }
                continue;
            }
        }
    }
    
    final String J(final int n) {
        return q.Code(this.ai, n);
    }
    
    final void J() {
        if (!this.v() && this.O()) {
            this.Code.a();
            u.I.I(this.Code.C(), 22);
        }
    }
    
    final int Z(final int n) {
        return this.ai[n] & 0xFF;
    }
    
    final int Z(int n, int a) {
    Label_0328_Outer:
        while (true) {
        Label_0328:
            while (true) {
            Label_0605:
                while (true) {
                    final int d2;
                    Label_0596: {
                        int n3 = 0;
                        Label_0560: {
                            int d = 0;
                            int y = 0;
                            int ap = 0;
                            int aq = 0;
                            int av = 0;
                            int ar = 0;
                            int as = 0;
                            int n4 = 0;
                            Label_0367: {
                                Label_0344: {
                                    synchronized (this) {
                                        final int n2 = this.N(n);
                                        ++this.av;
                                        this.F();
                                        this.av += 4;
                                        d = this.D();
                                        d2 = this.D();
                                        final String h = this.H();
                                        this.H();
                                        while (true) {
                                            if (this.Code.I.get(h) != null) {
                                                n = 0;
                                                n3 = (d2 & 0x1);
                                                switch (d) {
                                                    default: {
                                                        n = 0;
                                                        break;
                                                    }
                                                    case 83:
                                                    case 85:
                                                    case 97:
                                                    case 112:
                                                    case 120: {
                                                        u.Z.o(3);
                                                        final p z = u.Z;
                                                        u.Z.I[0] = n3;
                                                        u.Z.I[1] = n;
                                                        u.Z.I[2] = -1;
                                                        n = u.Z.o();
                                                        break;
                                                    }
                                                    case 115: {
                                                        this.av = this.y();
                                                        y = this.y();
                                                        ap = this.ap;
                                                        aq = this.aq;
                                                        av = this.av;
                                                        ar = this.ar;
                                                        as = this.as;
                                                        n4 = 0;
                                                        d = 0;
                                                        this.av = this.aj;
                                                        if (this.av >= n2) {
                                                            break Label_0367;
                                                        }
                                                        final int d3 = this.D();
                                                        switch (d3) {
                                                            case 66:
                                                            case 70:
                                                            case 73:
                                                            case 84: {
                                                                break Label_0344;
                                                            }
                                                            default: {
                                                                break Label_0605;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                    case 99:
                                                    case 114: {
                                                        break Label_0560;
                                                    }
                                                }
                                                return n;
                                            }
                                            break Label_0596;
                                            int d3 = 0;
                                            this.K(d3);
                                            continue Label_0328_Outer;
                                        }
                                    }
                                }
                                this.F();
                                n4 += this.ap;
                                d += this.aq;
                                continue Label_0328;
                            }
                            this.ap = n4 + ap;
                            this.aq = d + aq;
                            this.ar = ar;
                            this.as = as;
                            this.av = av;
                            a = A(a);
                            final int[] i = u.Z.I;
                            final p z2 = u.Z;
                            this.aq = this.I(i, 0, a, this.aq);
                            u.Z.o(8);
                            final p z3 = u.Z;
                            u.Z.I[0] = n3;
                            u.Z.I[1] = n;
                            u.Z.I[2] = y;
                            final int[] j = u.Z.I;
                            if ((d2 & 0x4) != 0x0) {
                                n = 1;
                            }
                            else {
                                n = 0;
                            }
                            j[3] = n;
                            u.Z.I[4] = this.ap;
                            u.Z.I[5] = this.aq;
                            u.Z.I[6] = this.ar;
                            u.Z.I[7] = this.as;
                            n = u.Z.o();
                            return n;
                        }
                        u.Z.o(1);
                        final int[] k = u.Z.I;
                        final p z4 = u.Z;
                        k[0] = n3;
                        n = u.Z.o();
                        return n;
                    }
                    n = (d2 & 0x8);
                    continue Label_0328_Outer;
                }
                continue Label_0328;
            }
        }
    }
    
    final int Z(final boolean b) {
        if (u.Code.m()) {
            for (int i = 0; i < 5; ++i) {
                final int n = (this.j.hashCode() ^ new Long(System.currentTimeMillis()).hashCode()) % 100000000;
                int n2;
                if ((n2 = n) < 0) {
                    n2 = -n;
                }
                if (n2 != 0) {
                    String s;
                    if (b) {
                        s = u.c.I(n2, 16);
                    }
                    else {
                        s = u.c.Code(n2, 16);
                    }
                    final int code = u.c.Code(this.ai, s);
                    if (code == 0) {
                        return n2;
                    }
                    if (code == 2) {
                        return 0;
                    }
                    if (b) {
                        u.c.I();
                    }
                    else {
                        u.c.Code();
                    }
                }
            }
        }
        return 0;
    }
    
    final void Z(int code, final int n, int a) {
        synchronized (this) {
            a = A(a);
            final int[] i = u.Z.I;
            final p z = u.Z;
            code = this.Code(i, a, code);
            u.Z.l(this.Code.I.size() * 2 + 4);
            u.Z.I("x");
            u.Z.I(String.valueOf(n));
            u.Z.I("y");
            u.Z.I(String.valueOf(code));
            final Enumeration keys = this.Code.I.keys();
            while (keys.hasMoreElements()) {
                final String s = (String)keys.nextElement();
                if (!s.startsWith("o:")) {
                    u.Z.I(cg.Code(s));
                    u.Z.I(cg.Code(this.Code.I.get(s).toString()));
                }
            }
        }
        u.Z.b(u.Z.n());
        monitorexit(this);
    }
    
    final void Z(final Object o) {
        final StringBuffer sb;
        synchronized (this) {
            final Hashtable hashtable = (Hashtable)((Object[])o)[3];
            sb = new StringBuffer();
            final Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                if (sb.length() > 0) {
                    sb.append('\0');
                }
                sb.append(keys.nextElement());
            }
        }
        final Throwable t;
        this.Code((int)((Object[])(Object)t)[1], sb.toString());
        monitorexit(this);
    }
    
    final void Z(final Object o, final int n) {
        synchronized (this) {
            final Hashtable hashtable = (Hashtable)((Object[])o)[3];
            if (!(boolean)((Object[])o)[4]) {
                hashtable.clear();
            }
            final Integer n2 = new Integer(n);
            if (!hashtable.containsKey(n2)) {
                hashtable.put(n2, n2);
            }
            else {
                hashtable.remove(n2);
            }
        }
    }
    
    public final boolean Z() {
        return this.p;
    }
    
    final int a() {
        al i;
        for (i = this; i.ax == 0 || i.ai == null; i = i.I) {
            if (i.I == null) {
                return 0;
            }
        }
        return u.Z.I(i.ai, i.ax + 3, Code(i.ai, i.ax));
    }
    
    final int a(final int n) {
        return this.z * n / this.x;
    }
    
    final int a(int o, int n) {
    Label_0123_Outer:
        while (true) {
            while (true) {
                Label_0186: {
                    synchronized (this) {
                        if (this.ad == null) {
                            o = 0;
                            return o;
                        }
                        final int n2 = this.ad[o * 5 + 1];
                        final int n3 = this.ad[o * 5 + 2];
                        int d;
                        o = (d = this.d(n2, this.U));
                        while (true) {
                            final int n4 = this.T[d * 5 + 0];
                            final int n5 = this.T[d * 5 + 1];
                            if (n4 < n2 || n5 + n4 > n2 + n3) {
                                break;
                            }
                            ++d;
                        }
                        if (n == 0) {
                            u.Z.o(d - o);
                            break Label_0186;
                        }
                        u.Z.p(d - o);
                        break Label_0186;
                        while (true) {
                            final int[] i = u.Z.I;
                            final p z = u.Z;
                            i[n - o + 0] = n;
                            ++n;
                            iftrue(Label_0176:)(n >= d);
                            continue Label_0123_Outer;
                        }
                    }
                    Label_0176: {
                        o = u.Z.o();
                    }
                    return o;
                }
                n = o;
                continue;
            }
        }
    }
    
    public final int b(final int n) {
        if (n == 0) {
            u.Z.o(this.E[0]);
        }
        else {
            u.Z.p(this.E[0]);
        }
        final int[] e = this.E;
        final int[] i = u.Z.I;
        final p z = u.Z;
        System.arraycopy(e, 1, i, 0, this.E[0]);
        return u.Z.o();
    }
    
    final void b() {
        synchronized (this) {
            if (this.C) {
                al.az.Code(this);
            }
            this.J = 0;
        }
    }
    
    final int c() {
        return this.P;
    }
    
    final void c(int i) {
        final int n = u.Z.n(i);
        u.Z.Code(i, n);
        this.al.clear();
        Hashtable al;
        p z;
        int[] j;
        p z2;
        String k;
        p z3;
        int[] l;
        p z4;
        for (i = 0; i < n; i += 2) {
            al = this.al;
            z = u.Z;
            j = u.Z.I;
            z2 = u.Z;
            k = cg.I(z.f(j[i + 0]));
            z3 = u.Z;
            l = u.Z.I;
            z4 = u.Z;
            al.put(k, cg.I(z3.f(l[i + 0 + 1])));
        }
        if (n > 0) {
            final String string = Integer.toString(0);
            final String string2 = Integer.toString(1);
            this.Code(string, this.an, 'x', null);
            this.Code(string2, this.ao, 'p', null);
        }
    }
    
    final int d() {
        return this.Q;
    }
    
    final String d(final int n) {
        switch (n) {
            case 0: {
                if (this.ao != null && this.Code.I.containsKey(this.ao)) {
                    return this.an;
                }
                break;
            }
            case 1: {
                return this.ao;
            }
        }
        return null;
    }
    
    final int e() {
        return this.u;
    }
    
    final int e(int i) {
        int n;
        final Throwable t;
        while (true) {
            int[] array;
            int j = 0;
            int p;
            int n2 = 0;
            int n3 = 0;
            int n4 = 0;
            int n5;
            int z;
            int k;
            int n6;
            int n7;
            int l;
            Label_0084_Outer:Label_0127_Outer:
            while (true) {
            Label_0127:
                while (true) {
                    Label_0575: {
                        while (true) {
                            Label_0248: {
                                synchronized (this) {
                                    if (this.aa == 0) {
                                        this.aG = -1;
                                    }
                                    else {
                                        this.aG = this.aa;
                                    }
                                    array = new int[this.U * 4];
                                    j = 0;
                                    n = 0;
                                    p = this.P();
                                    if (p <= 0) {
                                        break;
                                    }
                                    n2 = this.ai[p + 1] * 10 + 2 + p;
                                    n2 += this.I(n2) + 2 + 1;
                                    n3 = this.ai[n2 - 1];
                                    if (n3 <= 0) {
                                        break Label_0575;
                                    }
                                    n4 = n2 + 1;
                                    if (this.Z(n2) == 114) {
                                        j = this.I(n4);
                                        n2 = n4 + 2;
                                        j += n2;
                                        break Label_0575;
                                    }
                                    break Label_0248;
                                    while (true) {
                                        Block_15: {
                                            while (true) {
                                                n5 = n4 + 1;
                                                z = this.Z(n4);
                                                k = this.I(n5);
                                                n6 = (n4 = n5 + 2);
                                                iftrue(Label_0127:)(z <= 0);
                                                break Block_15;
                                                iftrue(Label_0274:)(n4 >= j);
                                                continue Label_0127_Outer;
                                            }
                                            n2 = this.T[k * 5 + 0];
                                            n3 = n7;
                                            n4 = n6;
                                            continue Label_0127;
                                        }
                                        t[k] = true;
                                        n7 = (n3 += this.T[k * 5 + 1]);
                                        n4 = n6;
                                        iftrue(Label_0127:)(n2 != -1);
                                        continue;
                                    }
                                }
                            }
                            l = this.I(n4);
                            --n3;
                            n2 = n4 + (l + 2);
                            continue Label_0127_Outer;
                        }
                        Label_0594: {
                            if (n3 > 0) {
                                t[this.U + n * 3] = n2;
                                t[this.U + n * 3 + 1] = n3;
                                t[this.U + n * 3 + 2] = p;
                                ++n;
                                break Label_0594;
                            }
                            break Label_0594;
                        }
                        continue Label_0084_Outer;
                    }
                    if (j >= n2) {
                        n3 = 0;
                        n4 = n2;
                        n2 = -1;
                        continue Label_0127;
                    }
                    break;
                }
                continue Label_0084_Outer;
            }
        }
        final int[] array2 = new int[3];
        int n8 = 0;
    Label_0336:
        while (n8 == 0) {
            for (int u = this.U; u < this.U + (n - 1) * 3; u += 3) {
                if (t[u] > t[u + 3]) {
                    System.arraycopy(t, u, array2, 0, 3);
                    System.arraycopy(t, u + 3, t, u, 3);
                    System.arraycopy(array2, 0, t, u + 3, 3);
                    n8 = 0;
                    continue Label_0336;
                }
            }
            n8 = 1;
        }
        if (i == 0) {
            u.Z.o(this.U + 1 + n * 2);
        }
        else {
            u.Z.p(this.U + 1 + n * 2);
        }
        final p z2 = u.Z;
        u.Z.I[0] = n;
        i = 0;
        int n9 = 1;
        while (i < n) {
            final int[] m = u.Z.I;
            final int n10 = n9 + 1;
            m[n9] = t[this.U + i * 3 + 2];
            final int[] i2 = u.Z.I;
            n9 = n10 + 1;
            i2[n10] = t[this.U + i * 3 + 1];
            ++i;
        }
        System.arraycopy(t, 0, u.Z.I, n9, this.U);
        i = u.Z.o();
        monitorexit(this);
        return i;
    }
    
    final int f(final int n) {
        return this.ai[n];
    }
    
    final int[] f() {
        return this.v;
    }
    
    final byte g() {
        return this.s;
    }
    
    final int g(int n) {
        final int z = this.Z(n);
        n += this.ai[n + 1] * 10 + 2;
        if (z != 78) {
            return this.F(n);
        }
        return this.E(n + 2 + 2 + 3);
    }
    
    final int h() {
        return this.t;
    }
    
    final int h(final int n) {
        return this.I(this.ai[n + 1] * 10 + 2 + n + 2);
    }
    
    final int i() {
        return this.r;
    }
    
    final int i(final int n) {
        return this.Code(this.ai[n + 1] * 10 + 2 + n + 4);
    }
    
    final int j() {
        return this.o;
    }
    
    final int j(int av) {
        final int n = 0;
        this.av = av;
        int n2;
        if (this.D() == 67) {
            n2 = 16;
        }
        else {
            n2 = 0;
        }
        this.av += this.D() * 10;
        this.av += this.A();
        int i = this.D();
        av = n;
        while (i > 0) {
            switch (this.D()) {
                case 70: {
                    ++av;
                    break;
                }
                case 66: {
                    av += 2;
                    break;
                }
                case 108: {
                    av += 4;
                    break;
                }
                case 114: {
                    av += 8;
                    break;
                }
            }
            this.av += this.A();
            --i;
        }
        return n2 | av;
    }
    
    final int k() {
        return this.q;
    }
    
    final int k(int code) {
        code = this.Code(code, 't');
        if (code == 0) {
            return 0;
        }
        return this.E(code);
    }
    
    final int l(int code) {
        code = this.Code(code, 'o');
        if (code == 0) {
            return 0;
        }
        return this.F(code);
    }
    
    public final void l() {
        synchronized (this) {
            this.aL = null;
            this.Code.B = null;
            this.Code.C = -1;
        }
    }
    
    final int m() {
        int n2;
        final int n = n2 = 0;
        if (cg.c) {
            n2 = n;
            if (this.ai != null) {
                final int n3 = n2 = this.ai.length + 0;
                if (this.T != null) {
                    n2 = n3 + this.T.length * 4;
                }
            }
        }
        if (this.Z != null) {
            return n2 + this.aA.b + this.aA.C;
        }
        return n2 + this.aA.b;
    }
    
    final int m(int n) {
        synchronized (this) {
            this.N(n);
            this.av += 15;
            n = this.ai[this.av];
            return n;
        }
    }
    
    final int n() {
        int o = 0;
        synchronized (this) {
            if (this.ad != null) {
                u.Z.o(this.ad.length);
                final int[] ad = this.ad;
                final int[] i = u.Z.I;
                final p z = u.Z;
                System.arraycopy(ad, 0, i, 0, this.ad.length);
                o = u.Z.o();
            }
            return o;
        }
    }
    
    final Object n(final int n) {
        synchronized (this) {
            this.N(n);
            this.av += 15;
            this.D();
            final int d = this.D();
            final String h = this.H();
            String h2 = this.H();
            this.av = this.y();
            final int y = this.y();
            final int[] array = new int[y];
            for (int i = 0; i < y; ++i) {
                array[i] = this.av;
                this.G();
                this.G();
            }
            if (this.Code.I.containsKey(h)) {
                h2 = this.Code.I.get(h);
            }
            final Hashtable hashtable = new Hashtable();
            final Integer n2 = new Integer(Code(hashtable, h2));
            final Integer n3 = new Integer(n);
            final Boolean b = new Boolean((d & 0x4) != 0x0);
            monitorexit(this);
            return new Object[] { this, n3, array, hashtable, b, n2 };
        }
    }
    
    final int o() {
        synchronized (this) {
            u.Z.o(this.U * 5);
            final int[] t = this.T;
            final int[] i = u.Z.I;
            final p z = u.Z;
            System.arraycopy(t, 0, i, 0, this.U * 5);
            return u.Z.o();
        }
    }
    
    final String o(final int n) {
        synchronized (this) {
            this.N(n);
            this.av += 17;
            this.G();
            return this.H();
        }
    }
    
    final String p(int d) {
        while (true) {
            while (true) {
                int d2 = 0;
                String s = null;
                Label_0155: {
                    while (true) {
                        Label_0152: {
                            synchronized (this) {
                                this.N(d);
                                this.av += 15;
                                d = this.D();
                                d2 = this.D();
                                s = this.Code.I.get(this.H());
                                switch (d) {
                                    case 83:
                                    case 85:
                                    case 97:
                                    case 112:
                                    case 115:
                                    case 120: {
                                        String h = s;
                                        if (s == null) {
                                            h = this.H();
                                        }
                                        return h;
                                    }
                                    default: {
                                        break Label_0152;
                                    }
                                    case 99: {
                                        break Label_0155;
                                    }
                                }
                                return "0";
                                h = "";
                                return h;
                            }
                        }
                        continue;
                    }
                }
                if (s != null) {
                    d = 1;
                }
                else {
                    d = 0;
                }
                boolean b;
                if ((d2 & 0x2) != 0x0) {
                    b = true;
                }
                else {
                    b = false;
                }
                if (((b ? 1 : 0) ^ d) != 0x0) {
                    return "1";
                }
                continue;
            }
        }
    }
    
    public final void p() {
        this.Code.a();
        u.I.I(this.Code.C(), 28);
    }
    
    final String q(final int n) {
        synchronized (this) {
            this.N(n);
            this.av += 17;
            return this.H();
        }
    }
    
    final int r(int max) {
        int n2;
        if (cg.c && max > 0 && this.ai != null) {
            final int n = n2 = this.ai.length + 0;
            if (this.T != null) {
                n2 = n + this.T.length * 4;
            }
            max = Math.max(1, max - n2);
        }
        else {
            n2 = 0;
        }
        if (this.Z != null) {
            this.aA.Code(max, this.Z.b);
            return n2 + this.aA.b + this.aA.C;
        }
        this.aA.Code(max, 0);
        return n2 + this.aA.b;
    }
    
    final int s(int intValue) {
        synchronized (this) {
            Integer n;
            if (this.ae != null) {
                n = this.ae.get(intValue);
            }
            else {
                n = null;
            }
            if (n != null) {
                intValue = n;
            }
            else {
                intValue = -1;
            }
            return intValue;
        }
    }
    
    public final String t(final int n) {
        if (this.af != null) {
            return this.af.get(n);
        }
        return null;
    }
    
    public final String u(final int n) {
        if (this.ag != null) {
            return this.ag.get(n);
        }
        return null;
    }
}
