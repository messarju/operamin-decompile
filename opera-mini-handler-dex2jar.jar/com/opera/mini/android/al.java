// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

public class al
{
    private static final int[] B;
    private static int[] C;
    public static final al Code;
    private static final int[] J;
    private static final int[] Z;
    private static final int[][][] a;
    private boolean I;
    
    static {
        Code = new al();
        Z = new int[] { 0, 2, 4, 6, 8, 10, 12, 14 };
        J = new int[] { 4385, 4897, 5377, 5921, 6403, 7457, 7939, 8961, 9475, 10499, 11523, 12547, 13571, 14593, 15105, 15617, 16129, 16643, 17667, 18691, 19715, 20739, 21763, 22787, 23811, 0, 0, 0, 0, 0, 3, 24835, 25859, 26883, 27923, 28931, 29955, 30979, 32001, 32513, 33027, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 34049, 34561, 35073, 35585, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 33, 33, 0, 33, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 3, 3, 3, 3, 1, 1 };
        B = new int[] { 3, 3, 3, 0, 3, 0, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 32, 33, 32, 33, 0, 1, 32, 33, 0, 2, 3, 1, 32, 33, 0, 2, 3, 1, 0, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 16, 18, 19, 17, 0, 2, 3, 1, 0, 2, 3, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 2, 3, 1, 0, 1, 0, 1, 0, 1, 0, 1 };
        al.C = new int[] { 1611, 1611, 1612, 1612, 1613, 1613, 1614, 1614, 1615, 1615, 1616, 1616, 1617, 1617, 1618, 1618, 1569, 1570, 1570, 1571, 1571, 1572, 1572, 1573, 1573, 1574, 1574, 1574, 1574, 1575, 1575, 1576, 1576, 1576, 1576, 1577, 1577, 1578, 1578, 1578, 1578, 1579, 1579, 1579, 1579, 1580, 1580, 1580, 1580, 1581, 1581, 1581, 1581, 1582, 1582, 1582, 1582, 1583, 1583, 1584, 1584, 1585, 1585, 1586, 1586, 1587, 1587, 1587, 1587, 1588, 1588, 1588, 1588, 1589, 1589, 1589, 1589, 1590, 1590, 1590, 1590, 1591, 1591, 1591, 1591, 1592, 1592, 1592, 1592, 1593, 1593, 1593, 1593, 1594, 1594, 1594, 1594, 1601, 1601, 1601, 1601, 1602, 1602, 1602, 1602, 1603, 1603, 1603, 1603, 1604, 1604, 1604, 1604, 1605, 1605, 1605, 1605, 1606, 1606, 1606, 1606, 1607, 1607, 1607, 1607, 1608, 1608, 1609, 1609, 1610, 1610, 1610, 1610, 1628, 1628, 1629, 1629, 1630, 1630, 1631, 1631 };
        a = new int[][][] { { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 3 }, { 0, 1, 0, 1 } }, { { 0, 0, 2, 2 }, { 0, 0, 1, 2 }, { 0, 1, 1, 2 }, { 0, 1, 1, 3 } }, { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 3 }, { 0, 1, 0, 3 } }, { { 0, 0, 1, 2 }, { 0, 0, 1, 2 }, { 0, 1, 1, 2 }, { 0, 1, 1, 3 } } };
    }
    
    private al() {
        this.I = true;
    }
    
    private static int Code(final char c) {
        if (c >= '\u0622' && c <= '\u06d3') {
            return al.J[c - '\u0622'];
        }
        if (c == '\u200d') {
            return 3;
        }
        if (c >= '\u206d' && c <= '\u206f') {
            return 4;
        }
        if (c >= '\ufe70' && c <= '\ufefc') {
            return al.B[c - '\ufe70'];
        }
        return 0;
    }
    
    private static void Code(final char[] array, int n) {
        int i;
        char c;
        for (i = 0, n = n + 0 - 1; i < n; ++i, --n) {
            c = array[i];
            array[i] = array[n];
            array[n] = c;
        }
    }
    
    private static int I(final char c) {
        if (c >= '\u0633' && c <= '\u0636') {
            return 1;
        }
        return 0;
    }
    
    private int I(final char[] array, final int n) {
        int i;
        int n2;
        for (i = 0, n2 = n + 0; i < n2; ++i) {
            final char c = array[i];
            if (c >= '\ufe70' && c <= '\ufefc') {
                array[i] = (char)al.C[c - '\ufe70'];
            }
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = n2 - 1;
        int n6 = Code(array[n5]);
        int n7 = 0;
        int j = -2;
        int k = n5;
        int n8 = 0;
        int n9 = 0;
        int code = 0;
        while (k >= 0) {
            int n13 = 0;
            int n14 = 0;
            int n15 = 0;
            int n16 = 0;
            int n17 = 0;
            int n18 = 0;
            Label_0518: {
                if ((0xFF00 & n6) <= 0) {
                    final char c2 = array[k];
                    int n10;
                    if (c2 >= '\u064b' && c2 <= '\u0652') {
                        n10 = 1;
                    }
                    else {
                        n10 = 0;
                    }
                    if (n10 == 0) {
                        final int n11 = n4;
                        final int n12 = n6;
                        n13 = k;
                        n14 = n8;
                        n15 = n12;
                        n16 = code;
                        n17 = n9;
                        n18 = n11;
                        break Label_0518;
                    }
                }
                j = -2;
                int n19 = k - 1;
                while (j < 0) {
                    if (n19 == -1) {
                        code = 0;
                        j = Integer.MAX_VALUE;
                    }
                    else {
                        code = Code(array[n19]);
                        if ((code & 0x4) == 0x0) {
                            j = n19;
                        }
                        else {
                            --n19;
                        }
                    }
                }
                int code2;
                int n21;
                int n23;
                int n24;
                if ((n6 & 0x20) > 0 && (n8 & 0x10) > 0) {
                    char c3 = '\0';
                    switch (array[k]) {
                        default: {
                            c3 = '\0';
                            break;
                        }
                        case '\u0622': {
                            c3 = '\u065c';
                            break;
                        }
                        case '\u0623': {
                            c3 = '\u065d';
                            break;
                        }
                        case '\u0625': {
                            c3 = '\u065e';
                            break;
                        }
                        case '\u0627': {
                            c3 = '\u065f';
                            break;
                        }
                    }
                    int n20 = k;
                    if (c3 != '\0') {
                        array[k] = '\uffff';
                        array[n5] = c3;
                        n20 = n5;
                    }
                    code2 = Code(c3);
                    n21 = n7;
                    final int n22 = 1;
                    n23 = n20;
                    n24 = n22;
                }
                else {
                    final int n25 = k;
                    n21 = n8;
                    code2 = n6;
                    n23 = n25;
                    n24 = n3;
                }
                while (true) {
                    Label_1047: {
                        int n27;
                        if (n23 > 0 && array[n23 - 1] == ' ') {
                            if (I(array[n23]) == 1) {
                                final int n26 = 1;
                                n27 = n9;
                                n18 = n26;
                            }
                            else {
                                if (array[n23] != '\u0626') {
                                    break Label_1047;
                                }
                                final int n28 = 1;
                                n18 = n4;
                                n27 = n28;
                            }
                        }
                        else {
                            if (n23 != 0) {
                                break Label_1047;
                            }
                            if (I(array[n23]) == 1) {
                                final int n29 = 1;
                                n27 = n9;
                                n18 = n29;
                            }
                            else {
                                if (array[n23] != '\u0626') {
                                    break Label_1047;
                                }
                                final int n30 = 1;
                                n18 = n4;
                                n27 = n30;
                            }
                        }
                        final char c4 = array[n23];
                        int n31;
                        if ((c4 > '\u0621' && c4 < '\u0626') || c4 == '\u0627' || (c4 > '\u062e' && c4 < '\u0633') || (c4 > '\u0647' && c4 < '\u064a') || c4 == '\u0629') {
                            n31 = 1;
                        }
                        else if (c4 >= '\u064b' && c4 <= '\u0652') {
                            n31 = 2;
                        }
                        else if ((c4 >= '\u0653' && c4 <= '\u0655') || c4 == '\u0670' || (c4 >= '\ufe70' && c4 <= '\ufe7f')) {
                            n31 = 3;
                        }
                        else {
                            n31 = 0;
                        }
                        int n32 = al.a[code & 0x3][n21 & 0x3][code2 & 0x3];
                        if (n31 == 1) {
                            n32 &= 0x1;
                        }
                        else if (n31 == 2) {
                            if ((n21 & 0x2) != 0x0 && (code & 0x1) != 0x0 && array[n23] != '\u064c' && array[n23] != '\u064d' && ((code & 0x20) != 0x20 || (n21 & 0x10) != 0x10)) {
                                n32 = 1;
                            }
                            else {
                                n32 = 0;
                            }
                        }
                        if (n31 == 2) {
                            array[n23] = (char)(65136 + al.Z[array[n23] - '\u064b'] + n32);
                            final int n33 = code;
                            final int n34 = n23;
                            n3 = n24;
                            n17 = n27;
                            n16 = n33;
                            n15 = code2;
                            n14 = n21;
                            n13 = n34;
                            break Label_0518;
                        }
                        array[n23] = (char)(65136 + (code2 >> 8) + n32);
                        final int n35 = code2;
                        final int n36 = n21;
                        final int n37 = n27;
                        final int n38 = n24;
                        n13 = n23;
                        n14 = n36;
                        n15 = n35;
                        n16 = code;
                        n17 = n37;
                        n3 = n38;
                        break Label_0518;
                    }
                    final int n39 = n4;
                    int n27 = n9;
                    n18 = n39;
                    continue;
                }
            }
            int n40 = n14;
            if ((n15 & 0x4) == 0x0) {
                n5 = n13;
                n40 = n15;
                n7 = n14;
            }
            final int n41 = n13 - 1;
            if (n41 == j) {
                final int n42 = -2;
                final int n43 = n18;
                n6 = n16;
                n8 = n40;
                n9 = n17;
                code = n16;
                k = n41;
                n4 = n43;
                j = n42;
            }
            else if (n41 != -1) {
                n6 = Code(array[n41]);
                final int n44 = n17;
                code = n16;
                n8 = n40;
                n4 = n18;
                k = n41;
                n9 = n44;
            }
            else {
                final int n45 = n17;
                code = n16;
                final int n46 = n40;
                n4 = n18;
                final int n47 = n15;
                k = n41;
                n9 = n45;
                n8 = n46;
                n6 = n47;
            }
        }
        if (n3 != 0) {
            final boolean l = this.I;
            for (int n48 = 0; n48 < n + 0; ++n48) {
                if (array[n48] == '\uffff') {
                    array[n48] = '\ufeff';
                }
            }
        }
        if (n4 != 0 || n9 != 0) {
            final boolean m = this.I;
        }
        return n;
    }
    
    public final String Code(final String s) {
        final char[] charArray = s.toCharArray();
        final int length = charArray.length;
        final int length2 = charArray.length;
        if (charArray == null) {
            throw new IllegalArgumentException("source can not be null");
        }
        if (length < 0 || length + 0 > charArray.length) {
            throw new IllegalArgumentException("bad source start (0) or length (" + length + ") for buffer of length " + charArray.length);
        }
        if (charArray == null && length2 != 0) {
            throw new IllegalArgumentException("null dest requires destSize == 0");
        }
        if (length2 != 0 && (length2 < 0 || length2 + 0 > charArray.length)) {
            throw new IllegalArgumentException("bad dest start (0) or size (" + length2 + ") for buffer of length " + charArray.length);
        }
        int i;
        if (length == 0) {
            i = 0;
        }
        else {
            i = length;
            if (length2 != 0) {
                final char[] array = new char[length * 2];
                System.arraycopy(charArray, 0, array, 0, length);
                if (this.I) {
                    Code(array, length);
                }
                i = this.I(array, length);
                if (i > length2) {
                    throw new am("not enough room for result data");
                }
                if (this.I) {
                    Code(array, i);
                }
                System.arraycopy(array, 0, charArray, 0, i);
            }
        }
        return new String(charArray, 0, i);
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o != null && o.getClass() == al.class;
    }
    
    @Override
    public final int hashCode() {
        return 9;
    }
    
    @Override
    public final String toString() {
        final StringBuffer sb = new StringBuffer(super.toString());
        sb.append('[');
        sb.append("LamAlef spaces at near");
        sb.append(", logical");
        sb.append(", shape letters");
        sb.append(", no digit shaping");
        sb.append(", standard Arabic-Indic digits");
        sb.append("]");
        return sb.toString();
    }
}
