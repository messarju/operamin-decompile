import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.DataInputStream;
import java.util.Hashtable;
import java.io.DataInput;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class a extends InputStream implements J, DataInput
{
    private int Z;
    private byte[] Code;
    private InputStream Code;
    private Code Code;
    private a Code;
    private Object[] Code;
    private int[] Code;
    private Hashtable Code;
    private int I;
    private boolean Code;
    private boolean I;
    private int J;
    private int B;
    public DataInputStream Code;
    public int Code;
    private int C;
    private int a;
    private int b;
    private byte[] I;
    private long Code;
    private int c;
    private int d;
    private int e;
    private int f;
    private static int[] I;
    private static int[] Z;
    private short[] Code;
    private byte[] Z;
    private short[] I;
    private boolean Z;
    
    public final a Code(a code) {
        if (code == this) {
            code = this.Code;
            this.Code = null;
            return code;
        }
        for (a code2 = this; code2.Code != null; code2 = code2.Code) {
            if (code2.Code == code) {
                code2.Code = code.Code;
                code.Code = null;
                break;
            }
        }
        return this;
    }
    
    public final a Code() {
        return this.Code;
    }
    
    public final Object[] Code() {
        return this.Code;
    }
    
    public final Hashtable Code(final boolean b) {
        final Hashtable code = this.Code;
        if (b) {
            this.Code = null;
        }
        return code;
    }
    
    public a(final Object[] code, final int[] code2, final int a) {
        this.b = 0;
        this.I = new byte[1];
        this.Code = code;
        this.Code = code2;
        this.a = a;
        code2[46] = 0;
        this.Code = (Hashtable)code[9];
        code[9] = null;
    }
    
    public final Code Code() {
        return this.Code;
    }
    
    public final byte[] Code() {
        return this.Code;
    }
    
    public final Code I() {
        return this.Code.Z();
    }
    
    public final void I() {
        this.Code = null;
        this.Code = null;
    }
    
    public final void c() {
        this.Code(new byte[32768]);
    }
    
    public final boolean J(final String s) {
        if (this.b >= 3) {
            return false;
        }
        ++this.b;
        this.a = Code.Code(s, (String)null);
        this.Code = null;
        if (this.b == 1) {
            this.Code[90] = this.Code[53];
        }
        this.Code[53] = s;
        this.Code[46] = 0;
        return true;
    }
    
    public a() {
        this.Z = true;
        this.I = true;
        this.Code = 6;
        this.I = 0;
        this.f = 0;
        this.Code = new short[574];
        this.I = new short[62];
        this.Z = new byte[288];
    }
    
    public final void J(final int n) {
        this.C += n;
    }
    
    public final boolean J() {
        return this.Code.I();
    }
    
    public final void I(final byte[] code, final int c, final int n) {
        this.Code = code;
        this.c = c;
        this.d = c + n;
    }
    
    public final int Code() {
        return this.a;
    }
    
    public final void Code(final Code code, final int i) {
        this.Code = code;
        this.I = i;
    }
    
    public final void Code() {
        this.Code = null;
    }
    
    public final void Code(final a code) {
        this.Code = code;
    }
    
    public final synchronized void Code(final int code) {
        this.Code = code;
        this.Code = null;
        this.notifyAll();
    }
    
    public a(final byte b) {
        this.Z = true;
        this.Code = true;
    }
    
    public a(final InputStream code) {
        this.Z = true;
        this.Code = code;
    }
    
    public final void I(final Code code) {
        this.Code = code;
    }
    
    public final void Code(final DataInputStream code) {
        this.c();
        this.Code = code;
    }
    
    public final int Z() {
        return this.I;
    }
    
    public final int[] I() {
        return this.Code;
    }
    
    public final long readLong() {
        return -1L;
    }
    
    static {
        a.I = new int[29];
        a.Z = new int[30];
    }
    
    public final int J() {
        return this.B;
    }
    
    public final int B() {
        return this.Code;
    }
    
    public final short readShort() {
        return (short)this.n();
    }
    
    public final int e() {
        return this.a;
    }
    
    public final boolean Code() {
        return this.Code == null;
    }
    
    public final boolean I() {
        return this.Code[46] != 0;
    }
    
    public final void B() {
        this.Code = System.currentTimeMillis();
    }
    
    public final void Z() {
        this.Code[46] = 1;
    }
    
    public final void J() {
        this.I = true;
        Code.Code((Object)this);
    }
    
    public final boolean Z() {
        return this.Code;
    }
    
    public final boolean readBoolean() {
        return this.m() != 0;
    }
    
    public final void I(final int j) {
        this.Code = true;
        this.J = j;
        Code.Code((Object)this);
    }
    
    public final void Z(final int z) {
        this.Z = z;
    }
    
    public final int C() {
        return this.Z;
    }
    
    public final int f() {
        return this.J;
    }
    
    public final int g() {
        return this.C;
    }
    
    public final int h() {
        return (int)(System.currentTimeMillis() - this.Code);
    }
    
    public final void readFully(final byte[] array, final int n, final int n2) {
        if (this.Code.read(array, n, n2) < n2) {
            throw new EOFException();
        }
    }
    
    public final char readChar() {
        return (char)this.n();
    }
    
    public final String readUTF() {
        return null;
    }
    
    public final int skipBytes(final int n) {
        return (int)this.skip(n);
    }
    
    private int m() {
        final int read;
        if ((read = this.Code.read()) == -1) {
            throw new EOFException();
        }
        return read;
    }
    
    public final void readFully(final byte[] array) {
        if (this.Code.read(array) < array.length) {
            throw new EOFException();
        }
    }
    
    private int Code(final byte[] code, final int b, final int code2) {
        this.B = b;
        this.Code = code2;
        this.Code = code;
        Code.Code((Object)this);
        while (!this.Code) {
            final Code code3;
            if ((code3 = this.Code) != null) {
                code3.Code(this);
            }
            if (this.Code == null) {
                if (this.Code == 0) {
                    return this.read(code, b, code2);
                }
                return this.Code;
            }
            else {
                Code.Code((Object)this, 1000);
            }
        }
        if (this.I) {
            return -1;
        }
        throw new IOException();
    }
    
    public final int read() {
        if (this.Z) {
            if (this.I) {
                if (this.read(null, 0, 1) == 0) {
                    return -1;
                }
                return this.I[this.B - 1] & 0xFF;
            }
            else {
                if (!this.Code) {
                    return this.Code.read();
                }
                final int read;
                if ((read = this.Code.read()) < 0) {
                    return -1;
                }
                ++this.J;
                return read;
            }
        }
        else {
            if (this.read(this.I, 0, 1) < 0) {
                return -1;
            }
            return this.I[0] & 0xFF;
        }
    }
    
    public final void close() {
        if (!this.Z) {
            Code.Code(this, false);
            return;
        }
        if (this.I) {
            super.close();
            return;
        }
        Code.Code((InputStream)this.Code);
        this.Code = null;
    }
    
    public final void Code(final byte[] i) {
        this.I = i;
        this.J = i.length;
        if (a.Z[0] == 0) {
            a.Z[0] = 1;
            a.Z[1] = 2;
            for (int j = 1; j < 29; ++j) {
                a.Z[j + 1] = (1 << j / 2) + (1 << (j - 1) / 2) + 1;
            }
            int k = 0;
            int n = 3;
            while (k < 28) {
                a.I[k] = n;
                n += ((k < 8) ? 1 : (1 << (k - 4) / 4));
                ++k;
            }
            a.I[28] = 258;
        }
    }
    
    public final byte readByte() {
        return (byte)this.m();
    }
    
    public final int readUnsignedByte() {
        return this.m();
    }
    
    private int n() {
        int n2;
        int n;
        int n3;
        for (n = ((n2 = this.m()) & 0x7F); (n2 & 0x80) != 0x0; n2 = this.m(), n = (n3 | (n2 & 0x7F))) {
            n3 = n << 7;
        }
        return n;
    }
    
    public final int readInt() {
        return this.n();
    }
    
    public final int readUnsignedShort() {
        return this.n();
    }
    
    public static a Code(int n) {
        final a a = new a((byte)0);
        n &= 0x7FFF;
        a.Code = new DataInputStream(new ByteArrayInputStream(Code.Code()));
        final Code code = Code.Code();
        Code.Code((InputStream)a.Code, a.Code.readShort());
        a.Code.readShort();
        Code.Code((InputStream)(a.Code = code.C(n)), code.B(n) + (n * 6 + 6));
        return a;
    }
    
    public static a Code(final int n, final String s) {
        return Code.J.Code(Code.I(n), Code.Code(n, s));
    }
    
    public static a Code(final InputStream inputStream, final int code) {
        final a a;
        (a = new a((byte)0)).Code = new DataInputStream(inputStream);
        a.Code = code;
        return a;
    }
    
    public final int i() {
        return this.Code;
    }
    
    public final int j() {
        if (this.J == this.Code) {
            throw new EOFException();
        }
        ++this.J;
        return this.Code.readByte();
    }
    
    public final int k() {
        if (this.J + 2 > this.Code) {
            throw new EOFException();
        }
        this.J += 2;
        return this.Code.readShort();
    }
    
    public final int l() {
        if (this.J + 4 > this.Code) {
            throw new EOFException();
        }
        this.J += 4;
        return this.Code.readInt();
    }
    
    public final long I() {
        if (this.J + 8 > this.Code) {
            throw new EOFException();
        }
        this.J += 8;
        return this.Code.readLong();
    }
    
    public final int Code(final int n) {
        final int min = Math.min(n, this.Code - this.J);
        Code.Code((InputStream)this.Code, min);
        this.J += min;
        if (n != min) {
            throw new EOFException();
        }
        return n;
    }
    
    private int o() {
        if (this.Code != null) {
            return this.Code.readByte();
        }
        while (this.c >= this.d) {
            this.Code.Z(true);
        }
        ++this.a;
        return this.Code[this.c++] & 0xFF;
    }
    
    private int I(final int n) {
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            if (this.f == 0) {
                this.e = this.o();
                this.f = 8;
            }
            n2 |= (this.e & 0x1) << i;
            this.e >>>= 1;
            --this.f;
        }
        return n2;
    }
    
    private static void Code(final byte[] array, final int n, final short[] array2) {
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = 0;
        }
        short n2 = 2;
        int n3 = 0;
        for (byte b = 1; b <= 16; ++b) {
            for (int j = 0; j < n; j = (short)(j + 1)) {
                if (array[j] == b) {
                    int n4 = 0;
                    for (int k = b - 1; k >= 0; --k) {
                        if ((n3 & 1 << k) != 0x0) {
                            ++n4;
                        }
                        if (k == 0) {
                            break;
                        }
                        if (array2[n4] == 0) {
                            array2[n4] = n2;
                            n4 = n2;
                            n2 += 2;
                        }
                        else {
                            n4 = array2[n4];
                        }
                    }
                    array2[n4] = (short)(j | 0x8000);
                    ++n3;
                }
            }
            n3 <<= 1;
        }
    }
    
    private int Code(final short[] array) {
        int i;
        for (i = 0; i >= 0; i = array[i + (this.e & 0x1)], this.e >>>= 1, --this.f) {
            if (this.f == 0) {
                this.e = this.o();
                this.f = 8;
            }
        }
        return i & 0xFFF;
    }
    
    private byte[] Code(final short[] array, final int n) {
        final byte[] array2 = new byte[n];
        int code;
        for (int i = 0; i < n; array2[i++] = (byte)code) {
            if ((code = this.Code(array)) >= 16) {
                int n2 = this.I((code == 18) ? 7 : (code - 14)) + 3;
                if (code == 18) {
                    n2 += 8;
                }
                byte b;
                if (code > 16) {
                    b = 0;
                }
                else {
                    b = array2[i - 1];
                }
                while (n2-- > 0) {
                    array2[i++] = b;
                }
            }
        }
        return array2;
    }
    
    private boolean B() {
        while (this.Z-- > 0) {
            this.I[this.B++] = this.I[this.C++];
            if (this.C == this.J) {
                this.C = 0;
            }
            if (this.b == this.B) {
                return true;
            }
        }
        return false;
    }
    
    private boolean C() {
        if (this.Z > 0 && this.B()) {
            return true;
        }
        int code;
        while ((code = this.Code(this.Code)) != 256) {
            if (code > 256) {
                final int n = code - 257;
                this.Z = a.I[n];
                if (n > 7 && n != 28) {
                    this.Z += this.I(n / 4 - 1);
                }
                final int code2 = this.Code(this.I);
                int n2 = a.Z[code2];
                if (code2 > 3) {
                    n2 += this.I(code2 / 2 - 1);
                }
                this.C = this.B - n2;
                if (this.C < 0) {
                    this.C += this.J;
                }
                if (this.B()) {
                    return true;
                }
            }
            else {
                this.I[this.B++] = (byte)code;
            }
            if (this.b == this.B) {
                return true;
            }
        }
        return false;
    }
    
    public final int read(final byte[] array, int n, final int n2) {
        if (!this.Z) {
            return this.Code(array, n, n2);
        }
        n = n;
        if (this.I) {
            this.a = 0;
            if (this.B == this.J) {
                this.B = 0;
            }
            final int n3 = this.J - this.B;
            this.b = this.B + ((n2 < n3) ? n2 : n3);
            final int b = this.B;
        Label_0694:
            while (this.b != this.B && (this.Code != null || this.c < this.d)) {
                switch (this.Code) {
                    case 7: {
                        return 0;
                    }
                    case 0: {
                        this.f = 0;
                        this.Z = this.I(16);
                        this.I(16);
                        this.Code = 3;
                    }
                    case 3: {
                        while (this.Z > 0) {
                            --this.Z;
                            this.I[this.B++] = (byte)this.o();
                            if (this.b == this.B) {
                                break Label_0694;
                            }
                        }
                        break;
                    }
                    case 1: {
                        int i;
                        for (i = 0; i < 144; ++i) {
                            this.Z[i] = 8;
                        }
                        while (i < 256) {
                            this.Z[i] = 9;
                            ++i;
                        }
                        while (i < 280) {
                            this.Z[i] = 7;
                            ++i;
                        }
                        while (i < 288) {
                            this.Z[i] = 8;
                            ++i;
                        }
                        Code(this.Z, 288, this.Code);
                        for (int j = 0; j < 32; ++j) {
                            this.Z[j] = 5;
                        }
                        Code(this.Z, 32, this.I);
                        this.Code = 4;
                    }
                    case 4: {
                        if (this.C()) {
                            break Label_0694;
                        }
                        break;
                    }
                    case 2: {
                        final int n4 = this.I(5) + 257;
                        final int n5 = this.I(5) + 1;
                        final int n6 = this.I(4) + 4;
                        for (int k = 0; k < 19; ++k) {
                            int n7;
                            if (k < 3) {
                                n7 = k + 16;
                            }
                            else if (k == 3) {
                                n7 = 0;
                            }
                            else if ((k & 0x1) == 0x1) {
                                n7 = 7 - (k - 5 >>> 1);
                            }
                            else {
                                n7 = 8 + (k - 4 >>> 1);
                            }
                            this.Z[n7] = (byte)((k < n6) ? ((byte)this.I(3)) : 0);
                        }
                        final short[] array2 = new short[36];
                        Code(this.Z, 19, array2);
                        Code(this.Code(array2, n4), n4, this.Code);
                        Code(this.Code(array2, n5), n5, this.I);
                        this.Code = 5;
                    }
                    case 5: {
                        if (!this.C()) {
                            break;
                        }
                        break Label_0694;
                    }
                }
                if (this.I == 1) {
                    this.Code = 7;
                    break;
                }
                this.I = this.I(1);
                this.Code = this.I(2);
            }
            if (array != null) {
                System.arraycopy(this.I, b, array, n, this.B - b);
            }
            return this.B - b;
        }
        if (this.J == this.Code && n2 > 0) {
            throw new EOFException();
        }
        final int read;
        if ((read = this.Code.read(array, n, Math.min(n2, this.Code - this.J))) < 0) {
            throw new EOFException();
        }
        this.J += read;
        return read;
    }
}
