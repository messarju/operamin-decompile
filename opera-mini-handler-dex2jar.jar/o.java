import java.util.Vector;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.InputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class o
{
    private static final long Code(final byte[] array, final int n, final boolean b) {
        long n2 = 0L;
        for (int i = 0; i < n; ++i) {
            n2 = (n2 << 8 | (long)(array[i + 0] & 0xFF));
        }
        long n3 = n2;
        if (!b) {
            n3 = n2;
            switch (n) {
                default: {
                    n3 = -1L;
                    break;
                }
                case 8: {
                    break;
                }
                case 1: {
                    return (byte)n2;
                }
                case 2: {
                    return (short)n2;
                }
                case 3: {
                    return -(~n2 + 1L & 0xFFFFFFL);
                }
                case 4: {
                    return (int)n2;
                }
            }
        }
        return n3;
    }
    
    public static void Code(final InputStream inputStream, final OutputStream outputStream, final g g) {
        final DataInputStream dataInputStream = new DataInputStream(inputStream);
        final DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        int n = 0;
        n n2 = null;
        final byte[] array = new byte[1024];
        final e e = new e();
        e.Code();
        final Vector code = g.Code();
        int n3 = 0;
        int n4;
        while (true) {
            n4 = n;
            if (n3 >= code.size()) {
                break;
            }
            final h h = code.elementAt(n3);
            int i = n;
            Label_0092: {
                if (h.Code() == 0) {
                    n2 = (n)h;
                }
                else {
                    while (i < h.I()) {
                        int length;
                        if ((length = h.I() - i) > array.length) {
                            length = array.length;
                        }
                        dataInputStream.readFully(array, 0, length);
                        e.Code(array, 0, length);
                        dataOutputStream.write(array, 0, length);
                        i += length;
                    }
                    Label_0200: {
                        switch (h.Code()) {
                            case 1: {
                                final k k = (k)h;
                                int n5 = k.Code;
                                int j = 0;
                                if (n5 > k.I) {
                                    n5 = k.I;
                                    n = i;
                                }
                                else {
                                    n = i;
                                }
                                while (j < n5) {
                                    int length2;
                                    if ((length2 = n5 - j) > array.length) {
                                        length2 = array.length;
                                    }
                                    dataInputStream.readFully(array, 0, length2);
                                    e.Code(array, 0, length2);
                                    for (int l = 0; l < length2; ++l, ++j) {
                                        array[l] ^= k.Z[j];
                                    }
                                    dataOutputStream.write(array, 0, length2);
                                    n += length2;
                                }
                                if (j < k.I) {
                                    dataOutputStream.write(k.Z, j, k.I - j);
                                    break Label_0092;
                                }
                                while (true) {
                                    i = n;
                                    if (j >= k.Code) {
                                        break Label_0200;
                                    }
                                    int length3 = k.Code - j;
                                    if (length3 > array.length) {
                                        length3 = array.length;
                                    }
                                    dataInputStream.readFully(array, 0, length3);
                                    e.Code(array, 0, length3);
                                    j += length3;
                                    n += length3;
                                }
                                break;
                            }
                            case 2: {
                                final l m = (l)h;
                                dataInputStream.readFully(array, 0, m.Code);
                                e.Code(array, 0, m.Code);
                                i += m.Code;
                                final long n6 = Code(array, m.Code, m.Z) + m.J;
                                switch (m.I) {
                                    default: {
                                        break Label_0200;
                                    }
                                    case 1: {
                                        dataOutputStream.writeByte((int)n6);
                                        n = i;
                                        break Label_0092;
                                    }
                                    case 2: {
                                        dataOutputStream.writeShort((short)n6);
                                        n = i;
                                        break Label_0092;
                                    }
                                    case 3: {
                                        dataOutputStream.writeShort((int)(n6 >> 8));
                                        dataOutputStream.writeByte((int)(n6 & 0xFFL));
                                        n = i;
                                        break Label_0092;
                                    }
                                    case 4: {
                                        dataOutputStream.writeInt((int)n6);
                                        break Label_0200;
                                    }
                                }
                                break;
                            }
                        }
                    }
                    n = i;
                }
            }
            ++n3;
        }
        while (true) {
            final int read = dataInputStream.read(array);
            if (read < 0) {
                break;
            }
            e.Code(array, 0, read);
            dataOutputStream.write(array, 0, read);
            n4 += read;
        }
        final byte[] i2 = e.I();
        if (n2.Code != n4) {
            throw new IOException();
        }
        if (n2.I.length != i2.length) {
            throw new IOException();
        }
        for (int n7 = 0; n7 < n2.I.length; ++n7) {
            if (n2.I[n7] != i2[n7]) {
                throw new IOException();
            }
        }
    }
}
