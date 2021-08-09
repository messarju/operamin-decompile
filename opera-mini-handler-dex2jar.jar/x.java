import java.util.Stack;
import java.util.Vector;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class x
{
    private final Vector B;
    private char[] Code;
    private byte I;
    private byte[] J;
    private final au Z;
    
    x(char[] code, int code2, int length, int code3, final String s, final au z) {
        final int n = 1;
        this.I = -1;
        this.B = new Vector();
        this.Code = code;
        this.Z = z;
        for (int i = 0; i < this.Code.length; ++i) {
            final byte j = I(this.Code[i]);
            if (j == 1) {
                this.I = 0;
            }
            else if ((j & 0x6) > 0) {
                if (this.I < 0) {
                    this.I = 1;
                }
                this.J = this.I(this.I);
                break;
            }
        }
        if (this.I < 0) {
            this.I = 0;
            this.J = null;
        }
        if (code2 == 0) {
            code2 = Integer.MAX_VALUE;
        }
        if ((code3 & 0x1) == 0x0) {
            length = this.Code.length;
            if ((code3 & 0x6) != 0x0) {
                final boolean b = (code3 & 0x4) != 0x0;
                code2 = cg.Code(this.Code, b, code2, z.Code(s), z);
                if (b) {
                    code3 = 0;
                    length = code2;
                    code2 = code3;
                }
            }
            else {
                code2 = 0;
            }
            if (code2 > 0) {
                this.Code(0);
            }
            this.Code(this.Code, 0, code2, length, 0);
            if (length < this.Code.length) {
                this.Code(0);
            }
            return;
        }
        if ((code3 & 0x4) != 0x0) {
            code3 = n;
        }
        else {
            code3 = 0;
        }
        code = this.Code;
        if (code3 != 0) {
            length /= z.I();
        }
        else {
            length = 0;
        }
        if (code3 != 0) {
            code3 = z.Code(s);
        }
        else {
            code3 = 0;
        }
        bg.Code(code, code2, length, code3, z, this);
    }
    
    private static byte Code(final byte b) {
        if ((b & 0x1) == 0x0) {
            return 1;
        }
        return 2;
    }
    
    public static int Code(final char[] array, int n) {
        final int n2 = 0;
        if ((n & 0x8) != 0x0) {
            for (int i = 0; i < array.length; ++i) {
                final int index = "()<>[]{}«»\u2018\u2019\u201c\u201d\u2039\u203a".indexOf(array[i]);
                if (index >= 0) {
                    int n3;
                    if ((index & 0x1) == 0x0) {
                        n3 = index + 1;
                    }
                    else {
                        n3 = index - 1;
                    }
                    array[i] = "()<>[]{}«»\u2018\u2019\u201c\u201d\u2039\u203a".charAt(n3);
                }
            }
        }
        if ((n & 0x4) != 0x0) {
            final int length = array.length;
            for (int n4 = length / 2, j = 0; j < n4; ++j) {
                final char c = array[j];
                array[j] = array[length - j - 1];
                array[length - j - 1] = c;
            }
        }
        int length2 = array.length;
        if ((n & 0x2) != 0x0) {
            n = 0;
            int n5 = n2;
            while (true) {
                length2 = n;
                if (n5 >= array.length) {
                    break;
                }
                if (Code(array[n])) {
                    System.arraycopy(array, n + 1, array, n, array.length - (n + 1));
                }
                else {
                    ++n;
                }
                ++n5;
            }
        }
        return length2;
    }
    
    private static void Code(final byte[] array, final byte b, final int n, final int n2, final byte b2, final byte b3) {
        int n5;
        for (int i = n; i < n2; i = n5 + 1) {
            if (array[i] == -128) {
                int n3 = i;
                int n4;
                do {
                    n4 = n3 + 1;
                    if (n4 >= n2) {
                        break;
                    }
                    n3 = n4;
                } while (array[n4] == -128);
                byte b4;
                if (i > n) {
                    b4 = array[i - 1];
                }
                else {
                    b4 = b2;
                }
                byte b5;
                if (n4 < n2) {
                    b5 = array[n4];
                }
                else {
                    b5 = b3;
                }
                byte code;
                if (b4 == 1 && b5 == 1) {
                    code = 1;
                }
                else if ((b4 & 0x1A) != 0x0 && (b5 & 0x1A) != 0x0) {
                    code = 2;
                }
                else {
                    code = Code(b);
                }
                while (true) {
                    n5 = n4;
                    if (i >= n4) {
                        break;
                    }
                    array[i] = code;
                    ++i;
                }
            }
            else {
                n5 = i;
            }
        }
    }
    
    private static void Code(final byte[] array, final byte[] array2, int i, final int n) {
        while (i < n) {
            Label_0068: {
                byte b2 = 0;
                int n2 = 0;
                byte[] array3 = null;
                byte b3 = 0;
                Label_0057: {
                    byte b;
                    if ((array[i] == 1 && (array2[i] & 0x1) != 0x0) || (array[i] == 2 && (array2[i] & 0x1) == 0x0)) {
                        b = array2[i];
                    }
                    else {
                        if (array[i] != 16 && array[i] != 8) {
                            break Label_0068;
                        }
                        b = array2[i];
                        if ((array2[i] & 0x1) == 0x0) {
                            b2 = b;
                            n2 = i;
                            array3 = array2;
                            b3 = 2;
                            break Label_0057;
                        }
                    }
                    array3 = array2;
                    n2 = i;
                    final byte b4 = 1;
                    b2 = b;
                    b3 = b4;
                }
                array3[n2] = (byte)(b3 + b2);
            }
            ++i;
        }
    }
    
    private static boolean Code(final char c) {
        return bg.Code(c) || c == '\u200e' || c == '\u200f';
    }
    
    private static byte I(final char c) {
        final byte b = 2;
        byte b2;
        if (" -=_/|\\:;.,\u060c!?&$#'`´\"\t\n".indexOf(c) >= 0 || "()<>[]{}«»\u2018\u2019\u201c\u201d\u2039\u203a".indexOf(c) >= 0) {
            b2 = -128;
        }
        else {
            if ('\u202a' <= c && c <= '\u202e') {
                return 64;
            }
            b2 = b;
            if (c != '\u200f') {
                b2 = b;
                if (!cg.I(c)) {
                    if ('\u0660' <= c && c <= '\u0669') {
                        return 16;
                    }
                    if (cg.Z(c)) {
                        return 4;
                    }
                    if ('0' <= c && c <= '9') {
                        return 8;
                    }
                    return 1;
                }
            }
        }
        return b2;
    }
    
    private byte[] I(final byte b) {
        final int n = 1;
        byte[] array = new byte[this.Code.length];
        byte[] array2 = new byte[this.Code.length];
        for (int i = 0; i < this.Code.length; ++i) {
            byte j;
            if ((j = I(this.Code[i])) == 4) {
                j = 2;
            }
            array2[i] = j;
            array[i] = b;
        }
        final Stack<byte[]> stack = new Stack<byte[]>();
        int k = 0;
        int n2 = 0;
        byte b2 = -128;
        byte b3 = b;
        while (k < this.Code.length) {
            switch (this.Code[k]) {
                default: {
                    array[k] = b3;
                    if (b2 != -128) {
                        array2[k] = b2;
                    }
                    ++n2;
                    break;
                }
                case '\u202b': {
                    stack.push(new byte[] { b3, b2 });
                    byte b4;
                    if ((b3 & 0x1) == 0x0) {
                        b4 = 1;
                    }
                    else {
                        b4 = 2;
                    }
                    b3 += b4;
                    b2 = -128;
                    break;
                }
                case '\u202a': {
                    stack.push(new byte[] { b3, b2 });
                    byte b5;
                    if ((b3 & 0x1) == 0x0) {
                        b5 = 2;
                    }
                    else {
                        b5 = 1;
                    }
                    b3 += b5;
                    b2 = -128;
                    break;
                }
                case '\u202e': {
                    stack.push(new byte[] { b3, b2 });
                    byte b6;
                    if ((b3 & 0x1) == 0x0) {
                        b6 = 1;
                    }
                    else {
                        b6 = 2;
                    }
                    b3 += b6;
                    b2 = 2;
                    break;
                }
                case '\u202d': {
                    stack.push(new byte[] { b3, b2 });
                    byte b7;
                    if ((b3 & 0x1) == 0x0) {
                        b7 = 2;
                    }
                    else {
                        b7 = 1;
                    }
                    b3 += b7;
                    b2 = 1;
                    break;
                }
                case '\u202c': {
                    if (!stack.empty()) {
                        final byte[] array3 = stack.pop();
                        b3 = array3[0];
                        b2 = array3[1];
                        break;
                    }
                    break;
                }
            }
            ++k;
        }
        if (n2 < this.Code.length) {
            final char[] code = new char[n2];
            final byte[] array4 = new byte[n2];
            final byte[] array5 = new byte[n2];
            int n3 = 0;
            int n4;
            for (int l = 0; l < this.Code.length; ++l, n3 = n4) {
                if (this.Code[l] >= '\u202a') {
                    n4 = n3;
                    if (this.Code[l] <= '\u202e') {
                        continue;
                    }
                }
                code[n3] = this.Code[l];
                array4[n3] = array[l];
                array5[n3] = array2[l];
                n4 = n3 + 1;
            }
            this.Code = code;
            array2 = array5;
            array = array4;
        }
        byte b8 = b;
        int n7;
        for (int n5 = 0, n6 = n; n5 < array.length; n5 = n6, n6 = n7) {
            byte b9;
            for (b9 = array[n5]; n6 < array.length && array[n6] == b9; ++n6) {}
            final byte code2 = Code((byte)Math.max(b8, b9));
            byte b10;
            if (n6 < array.length) {
                b10 = array[n6];
            }
            else {
                b10 = b;
            }
            Code(array2, b9, n5, n6, code2, Code((byte)Math.max(b10, b9)));
            Code(array2, array, n5, n6);
            b8 = b9;
            n7 = n6;
        }
        return array;
    }
    
    private int d(final int n) {
        return this.B.elementAt(n).Z;
    }
    
    public final int B(final int n) {
        return this.B.elementAt(n).J;
    }
    
    public final int C(final int n) {
        return this.B.elementAt(n).B;
    }
    
    public final int Code() {
        return this.B.size();
    }
    
    public final void Code(final int n) {
        this.B.addElement(new y(n));
    }
    
    public final void Code(final char[] array, final int n, int i, final int n2, final int n3) {
        if (i == n2) {
            this.B.addElement(new aa(0, i, n2, n, 0, n3));
        }
        else if (this.J == null) {
            if (i < n2) {
                final int n4 = 0;
                int n5 = i;
                int n6;
                while (true) {
                    n6 = n4;
                    if (n5 >= n2) {
                        break;
                    }
                    if (Code(array[n5])) {
                        n6 = 2;
                        break;
                    }
                    ++n5;
                }
                this.B.addElement(new aa(0, i, n2, n, n6, n3));
            }
        }
        else {
            while (i < n2) {
                final boolean b = (this.J[i] & 0x1) == 0x1;
                int n7 = 0;
                int n8 = 1;
                int n9 = 0;
                int n10;
                int n11;
                int n12;
                int n13;
                for (n10 = i; n10 < n2 && this.J[n10] == this.J[i]; ++n10, n7 = n13, n8 = n12, n9 = n11) {
                    if ((n11 = n9) == 0) {
                        n11 = n9;
                        if (b) {
                            n11 = n9;
                            if ("()<>[]{}«»\u2018\u2019\u201c\u201d\u2039\u203a".indexOf(this.Code[n10]) >= 0) {
                                n11 = 1;
                            }
                        }
                    }
                    if ((n12 = n8) != 0) {
                        n12 = n8;
                        if (b == cg.J(this.Code[n10])) {
                            n12 = 0;
                        }
                    }
                    if ((n13 = n7) == 0) {
                        n13 = n7;
                        if (Code(this.Code[n10])) {
                            n13 = 1;
                        }
                    }
                }
                int n14;
                if (n7 != 0) {
                    n14 = 2;
                }
                else {
                    n14 = 0;
                }
                int n15;
                if (n8 != 0) {
                    n15 = 4;
                }
                else {
                    n15 = 0;
                }
                int n16;
                if (n9 != 0) {
                    n16 = 8;
                }
                else {
                    n16 = 0;
                }
                this.B.addElement(new aa(this.J[i], i, n10, n, n14 | n15 | n16, n3));
                i = n10;
            }
        }
    }
    
    public final int I(final int n) {
        return this.B.elementAt(n).Code;
    }
    
    public final char[] I() {
        return this.Code;
    }
    
    public final int J(final int n) {
        return this.d(n) - this.Z(n);
    }
    
    public final int Z(final int n) {
        return this.B.elementAt(n).I;
    }
    
    public final boolean Z() {
        return this.I == 1;
    }
    
    public final int a(final int n) {
        return this.B.elementAt(n).C;
    }
    
    public final int b(final int n) {
        if ((this.C(n) & 0x2) != 0x0) {
            final char[] array = new char[this.Code.length];
            int i = this.Z(n);
            int n2 = 0;
            while (i < this.d(n)) {
                int n3 = n2;
                if (!Code(this.Code[i])) {
                    array[n2] = this.Code[i];
                    n3 = n2 + 1;
                }
                ++i;
                n2 = n3;
            }
            return this.Z.Code(array, 0, n2);
        }
        return this.Z.Code(this.Code, this.Z(n), this.J(n));
    }
    
    public final boolean c(final int n) {
        return this.B.elementAt(n) instanceof y;
    }
}
