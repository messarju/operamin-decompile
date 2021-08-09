import java.io.DataInputStream;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ci extends InputStream implements bd
{
    private static final int[] k;
    private static final int[] l;
    private int B;
    private int C;
    private int Code;
    private int I;
    private int J;
    private byte[] Z;
    private int a;
    private int b;
    private int c;
    private bx d;
    private DataInputStream e;
    private byte[] f;
    private int g;
    private int h;
    private int i;
    private int j;
    private short[] m;
    private short[] n;
    private byte[] o;
    
    static {
        k = new int[29];
        l = new int[30];
    }
    
    public ci() {
        this.Code = 6;
        this.c = 0;
        this.j = 0;
        this.m = new short[574];
        this.n = new short[62];
        this.o = new byte[288];
    }
    
    private boolean B() {
        if (this.a > 0 && this.J()) {
            return true;
        }
        do {
            final int code = this.Code(this.m);
            if (code == 256) {
                return false;
            }
            if (code > 256) {
                final int n = code - 257;
                this.a = ci.k[n];
                if (n > 7 && n != 28) {
                    this.a += this.Code(n / 4 - 1);
                }
                final int code2 = this.Code(this.n);
                int n2 = ci.l[code2];
                if (code2 > 3) {
                    n2 += this.Code(code2 / 2 - 1);
                }
                this.B = this.J - n2;
                if (this.B < 0) {
                    this.B += this.I;
                }
                if (this.J()) {
                    return true;
                }
                continue;
            }
            else {
                this.Z[this.J++] = (byte)code;
            }
        } while (this.C != this.J);
        return true;
    }
    
    private final int Code(final int n) {
        int i = 0;
        int n2 = 0;
        while (i < n) {
            if (this.j == 0) {
                this.i = this.Z();
                this.j = 8;
            }
            n2 |= (this.i & 0x1) << i;
            this.i >>>= 1;
            --this.j;
            ++i;
        }
        return n2;
    }
    
    private int Code(final short[] array) {
        int i;
        for (i = 0; i >= 0; i = array[i + (this.i & 0x1)], this.i >>>= 1, --this.j) {
            if (this.j == 0) {
                this.i = this.Z();
                this.j = 8;
            }
        }
        return i & 0xFFF;
    }
    
    private static final void Code(final byte[] array, final int n, final short[] array2) {
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = 0;
        }
        short n2 = 2;
        int j = 1;
        int n3 = 0;
        while (j <= 16) {
            int n9;
            for (int k = 0; k < n; k = (short)(k + 1), n3 = n9) {
                if (array[k] == j) {
                    int n4 = j - 1;
                    int n5 = 0;
                    int n6;
                    while (true) {
                        n6 = n5;
                        if (n4 < 0) {
                            break;
                        }
                        int n7 = n5;
                        if ((1 << n4 & n3) != 0x0) {
                            n7 = n5 + 1;
                        }
                        n6 = n7;
                        if (n4 == 0) {
                            break;
                        }
                        short n8;
                        if (array2[n7] == 0) {
                            array2[n7] = n2;
                            n8 = (short)(n2 + 2);
                            n5 = n2;
                        }
                        else {
                            n5 = array2[n7];
                            n8 = n2;
                        }
                        --n4;
                        n2 = n8;
                    }
                    array2[n6] = (short)(0x8000 | k);
                    n9 = n3 + 1;
                }
                else {
                    n9 = n3;
                }
            }
            n3 <<= 1;
            ++j;
        }
    }
    
    private byte[] Code(final short[] array, final int n) {
        final byte[] array2 = new byte[n];
        for (int i = 0; i < n; ++i) {
            final int code = this.Code(array);
            if (code < 16) {
                array2[i] = (byte)code;
            }
            else {
                int n2;
                if (code == 18) {
                    n2 = 7;
                }
                else {
                    n2 = code - 14;
                }
                int j;
                final int n3 = j = this.Code(n2) + 3;
                if (code == 18) {
                    j = n3 + 8;
                }
                byte b;
                if (code > 16) {
                    b = 0;
                }
                else {
                    b = array2[i - 1];
                }
                while (j > 0) {
                    array2[i] = b;
                    ++i;
                    --j;
                }
            }
        }
        return array2;
    }
    
    private boolean J() {
        final boolean b = false;
        do {
            final int n = this.a--;
            final boolean b2 = b;
            if (n <= 0) {
                return b2;
            }
            this.Z[this.J++] = this.Z[this.B++];
            if (this.B != this.I) {
                continue;
            }
            this.B = 0;
        } while (this.C != this.J);
        return true;
    }
    
    private int Z() {
        if (this.e != null) {
            return this.e.readByte();
        }
        while (this.g >= this.h) {
            this.d.I(true);
        }
        ++this.b;
        return this.f[this.g++] & 0xFF;
    }
    
    @Override
    public final void Code() {
        this.Code(new byte[32768]);
    }
    
    @Override
    public final void Code(final bx d) {
        this.d = d;
    }
    
    public final void Code(final DataInputStream e) {
        this.Code();
        this.e = e;
    }
    
    @Override
    public final void Code(final byte[] z) {
        this.Z = z;
        this.I = z.length;
        if (ci.l[0] == 0) {
            ci.l[0] = 1;
            ci.l[1] = 2;
            for (int i = 1; i < 29; ++i) {
                ci.l[i + 1] = (1 << i / 2) + (1 << (i - 1) / 2) + 1;
            }
            int n2;
            for (int j = 0, n = 3; j < 28; ++j, n += n2) {
                ci.k[j] = n;
                if (j < 8) {
                    n2 = 1;
                }
                else {
                    n2 = 1 << (j - 4) / 4;
                }
            }
            ci.k[28] = 258;
        }
    }
    
    @Override
    public final int I() {
        return this.b;
    }
    
    @Override
    public final void end() {
    }
    
    @Override
    public final int read() {
        if (this.read(null, 0, 1) == 0) {
            return -1;
        }
        return this.Z[this.J - 1] & 0xFF;
    }
    
    @Override
    public final int read(final byte[] array, final int n, int i) {
        this.b = 0;
        if (this.J == this.I) {
            this.J = 0;
        }
        final int n2 = this.I - this.J;
        if (i >= n2) {
            i = n2;
        }
        this.C = this.J + i;
        final int j = this.J;
    Label_0146:
        while (this.C != this.J && (this.e != null || this.g < this.h)) {
            switch (this.Code) {
                case 7: {
                    return 0;
                }
                case 0: {
                    this.j = 0;
                    this.a = this.Code(16);
                    this.Code(16);
                    this.Code = 3;
                }
                case 3: {
                    while (this.a > 0) {
                        --this.a;
                        final byte[] z = this.Z;
                        i = this.J++;
                        z[i] = (byte)this.Z();
                        if (this.C == this.J) {
                            break Label_0146;
                        }
                    }
                    break;
                }
                case 1: {
                    int n3 = 0;
                    while (true) {
                        i = n3;
                        if (n3 >= 144) {
                            break;
                        }
                        this.o[n3] = 8;
                        ++n3;
                    }
                    int n4;
                    while ((n4 = i) < 256) {
                        this.o[i] = 9;
                        ++i;
                    }
                    while ((i = n4) < 280) {
                        this.o[n4] = 7;
                        ++n4;
                    }
                    while (i < 288) {
                        this.o[i] = 8;
                        ++i;
                    }
                    Code(this.o, 288, this.m);
                    for (i = 0; i < 32; ++i) {
                        this.o[i] = 5;
                    }
                    Code(this.o, 32, this.n);
                    this.Code = 4;
                }
                case 4: {
                    if (this.B()) {
                        break Label_0146;
                    }
                    break;
                }
                case 2: {
                    final int n5 = this.Code(5) + 257;
                    final int n6 = this.Code(5) + 1;
                    final int code = this.Code(4);
                    for (int k = 0; k < 19; ++k) {
                        if (k < 3) {
                            i = k + 16;
                        }
                        else if (k == 3) {
                            i = 0;
                        }
                        else if ((k & 0x1) == 0x1) {
                            i = 7 - (k - 5 >>> 1);
                        }
                        else {
                            i = (k - 4 >>> 1) + 8;
                        }
                        final byte[] o = this.o;
                        byte b;
                        if (k < code + 4) {
                            b = (byte)this.Code(3);
                        }
                        else {
                            b = 0;
                        }
                        o[i] = b;
                    }
                    final short[] array2 = new short[36];
                    Code(this.o, 19, array2);
                    Code(this.Code(array2, n5), n5, this.m);
                    Code(this.Code(array2, n6), n6, this.n);
                    this.Code = 5;
                }
                case 5: {
                    if (!this.B()) {
                        break;
                    }
                    break Label_0146;
                }
            }
            if (this.c == 1) {
                this.Code = 7;
                break;
            }
            this.c = this.Code(1);
            this.Code = this.Code(2);
        }
        if (array != null) {
            System.arraycopy(this.Z, j, array, n, this.J - j);
        }
        return this.J - j;
    }
    
    @Override
    public final void setInput(final byte[] f, final int g, final int n) {
        this.f = f;
        this.g = g;
        this.h = g + n;
    }
}
