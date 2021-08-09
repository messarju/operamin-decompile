import java.util.Enumeration;
import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.Vector;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class ca
{
    private int B;
    private int C;
    private Vector Code;
    private Hashtable I;
    private int J;
    private al Z;
    private int a;
    
    ca() {
        this.Code = new Vector();
        this.I = new Hashtable();
        this.C = 0;
        this.a = 0;
    }
    
    private static int[] Code(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10) {
        return new int[] { n, n2, n3, n4, n5, n6, n7, n8, n9, n10 };
    }
    
    private int Z(int n) {
        final int n2 = n + 2 + this.Z.I(n);
        if (n2 < this.Z.Code()) {
            n = n2;
            if (this.Z.Z(n2) == 84) {
                return n;
            }
        }
        n = -1;
        return n;
    }
    
    public final void Code(al z, int i, String s) {
        this.Z = z;
        while (true) {
            for (int j = 0; j < s.length(); ++j) {
                if (cg.Z(s.charAt(j))) {
                    final int n = 1;
                    final int[] array = { this.C, this.a, 0, 0 };
                    this.J = this.Z.Code(i, array);
                    String c = s;
                    while (this.J != -1) {
                        this.C = array[0];
                        this.a = array[1];
                        int n2 = 0;
                        i = this.J + 17;
                        int k = this.Z.Z(i);
                        int n3 = i + 1;
                        while (k > 0) {
                            z = this.Z;
                            final int n4 = n3 + 1;
                            if (z.Z(n3) == 116 && this.Z.J(n4).equals("s")) {
                                i = 1;
                            }
                            else {
                                i = n2;
                            }
                            final int l = this.Z.I(n4);
                            --k;
                            n3 = n4 + (l + 2);
                            n2 = i;
                        }
                        s = this.Z.J(n3);
                        if (n != 0) {
                            c = cg.c(c);
                            s = cg.c(s);
                        }
                        final int z2 = this.Z(n3);
                        this.B = 0;
                    Label_0687_Outer:
                        while (n2 == 0 && this.B < s.length()) {
                            int m = this.J;
                            int b = this.B;
                            int c2 = this.C;
                            int a = this.a;
                            final int size = this.Code.size();
                            int n5 = 1;
                            String s2 = c;
                            String s3 = s;
                            i = z2;
                            while (true) {
                                while (s2.length() > s3.length() - b) {
                                    int[][] array2;
                                    if (i == -1 || !s3.regionMatches(true, b, s2, 0, s3.length() - b)) {
                                        array2 = null;
                                    }
                                    else {
                                        final int i2 = this.Z.I(m + 6);
                                        final int code = this.Z.Code(m + 8);
                                        final int n6 = c2 + this.Z.I(i + 1);
                                        final int n7 = a + this.Z.Code(i + 3);
                                        final int i3 = this.Z.I(i + 6);
                                        final int code2 = this.Z.Code(i + 8);
                                        final int n8 = i + 17;
                                        int z3 = this.Z.Z(n8);
                                        int n9 = n8 + 1;
                                        while (z3 > 0) {
                                            final int n10 = n9 + 1;
                                            final int i4 = this.Z.I(n10);
                                            --z3;
                                            n9 = n10 + (i4 + 2);
                                        }
                                        String s5;
                                        final String s4 = s5 = this.Z.J(n9);
                                        if (n != 0) {
                                            s5 = cg.c(s4);
                                        }
                                        final int z4 = this.Z(n9);
                                        if (!cb.Code(c2, a, i2, code, n6, n7, i3, code2)) {
                                            s2 = s2.substring(s3.length() - b);
                                            b = 0;
                                            ++n5;
                                            a = n7;
                                            c2 = n6;
                                            m = i;
                                            i = z4;
                                            s3 = s5;
                                            continue Label_0687_Outer;
                                        }
                                        if (s2.charAt(s3.length() - b) == ' ' && s2.length() > s3.length() - b + 1) {
                                            s2 = s2.substring(s3.length() - b + 1);
                                            b = 0;
                                            ++n5;
                                            a = n7;
                                            c2 = n6;
                                            m = i;
                                            i = z4;
                                            s3 = s5;
                                            continue Label_0687_Outer;
                                        }
                                        array2 = null;
                                    }
                                    if (array2 != null) {
                                        this.Code.addElement(array2);
                                    }
                                    ++this.B;
                                    continue Label_0687_Outer;
                                }
                                if (s3.regionMatches(true, b, s2, 0, s2.length())) {
                                    int j2 = this.J;
                                    int b2 = this.B;
                                    int c3 = this.C;
                                    int a2 = this.a;
                                    final int n11 = b + s2.length();
                                    final int[][] array2 = (int[][])Array.newInstance(Integer.TYPE, n5, 10);
                                    int n12 = 0;
                                    String j3;
                                    int n16;
                                    int i6;
                                    int a3;
                                    int code3;
                                    int code4;
                                    while (true) {
                                        final int n13 = j2 + 17;
                                        i = 1;
                                        int z5 = this.Z.Z(n13);
                                        int n14 = n13 + 1;
                                        while (z5 > 0) {
                                            final al z6 = this.Z;
                                            final int n15 = n14 + 1;
                                            if (z6.Z(n14) == 114) {
                                                i = 0;
                                            }
                                            final int i5 = this.Z.I(n15);
                                            --z5;
                                            n14 = i5 + 2 + n15;
                                        }
                                        j3 = this.Z.J(n14);
                                        n16 = 0;
                                        int n17 = 0;
                                        int n18 = 0;
                                        while (n17 < b2) {
                                            int n19;
                                            int n20;
                                            if (j3.charAt(n17) == '\n') {
                                                n19 = n16 + 1;
                                                n20 = n17 + 1;
                                            }
                                            else {
                                                final int n21 = n18;
                                                n19 = n16;
                                                n20 = n21;
                                            }
                                            ++n17;
                                            final int n22 = n19;
                                            n18 = n20;
                                            n16 = n22;
                                        }
                                        i6 = this.Z.I(j2 + 15);
                                        a3 = cg.a(i6);
                                        code3 = cg.Code(i6, j3.substring(n18, b2));
                                        code4 = cg.Code(j3, b2);
                                        if (j2 == m) {
                                            break;
                                        }
                                        final int z7 = this.Z(n14);
                                        final int i7 = this.Z.I(z7 + 1);
                                        final int code5 = this.Z.Code(z7 + 3);
                                        final int code6 = cg.Code(i6, j3.substring(b2, j3.length()));
                                        final int code7 = cg.Code(j3, j3.length());
                                        if (i == 0) {
                                            code3 = 0;
                                        }
                                        array2[n12] = Code(j2, code4, code7 - code4, code3, a3 * n16, code6, a3, c3, a2, size);
                                        ++n12;
                                        a2 += code5;
                                        c3 += i7;
                                        b2 = 0;
                                        j2 = z7;
                                    }
                                    final int code8 = cg.Code(i6, j3.substring(b2, n11));
                                    final int code9 = cg.Code(j3, n11);
                                    if (i == 0) {
                                        code3 = this.Z.I(j2 + 6) - code3 - code8;
                                    }
                                    array2[n12] = Code(j2, code4, code9 - code4, code3, a3 * n16, code8, a3, c3, a2, size);
                                    continue;
                                }
                                int[][] array2 = null;
                                continue;
                            }
                        }
                        this.J = this.Z.Code(n3 + 2 + this.Z.I(n3), array);
                    }
                    final Enumeration elements = this.Code.elements();
                    while (elements.hasMoreElements()) {
                        int[][] array3;
                        int[] array4;
                        Integer n23;
                        Vector<int[]> vector;
                        for (array3 = (int[][])elements.nextElement(), i = 0; i < array3.length; ++i) {
                            array4 = array3[i];
                            n23 = new Integer(array4[0]);
                            if (this.I.containsKey(n23)) {
                                ((Vector<int[]>)this.I.get(n23)).addElement(array4);
                            }
                            else {
                                vector = new Vector<int[]>();
                                vector.addElement(array4);
                                this.I.put(n23, vector);
                            }
                        }
                    }
                    return;
                }
            }
            final int n = 0;
            continue;
        }
    }
    
    final boolean Code() {
        return this.Code.size() > 0;
    }
    
    final int[][] Code(final int n) {
        return this.Code.elementAt(n);
    }
    
    final int I() {
        return this.Code.size();
    }
    
    final Vector I(final int n) {
        return this.I.get(new Integer(n));
    }
}
