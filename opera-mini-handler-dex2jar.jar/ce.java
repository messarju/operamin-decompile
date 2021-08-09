import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ce
{
    private static final cf B;
    private static final cf C;
    static int Code;
    private static cf[] I;
    private static final cf J;
    private static bu[] Z;
    private static final bu a;
    private static bu b;
    
    static {
        ce.Code = 0;
        J = new cf("i", "*", 0, "/firsttime/*", 1);
        B = new cf("server", "*", 0, "setup", 1);
        C = new cf("probe", "*", 0, "*", 1);
        a = new bu(0, 0, "mini5.opera-mini.net", 80, 1080, "c1dd7ab77e2c967746fe10681026c920f864811321bcb8be6bbfa5a03fda4e16c9c8db3af280f7703366e778e93c55e7159a8852d2b1381e521a337f22b1406cddf41a3114aecb4f4bfe79e0c5aa2ba8824fc989cb8bdcbf8ec5cef5176bfd4059f229b91bfa025126b295f9c409e75f6f6415ee094fd7f5dfd395a1f431668c5a08e88de891dc4dd38d4e9aa9b9c00dc604a0428e3aa5a28ccfa75af099147b", "mini5.opera-mini.net");
    }
    
    public static int Code(final String s, final String s2) {
        while (true) {
            while (true) {
                Label_0159: {
                    try {
                        final Object[] e = cg.e(s);
                        Block_7: {
                            for (int i = 0; i < ce.I.length; ++i) {
                                final cf cf = ce.I[i];
                                final String s3 = (String)e[0];
                                final String s4 = (String)e[1];
                                final int intValue = (int)e[2];
                                final String s5 = (String)e[3];
                                if (!cg.I(cf.Code, s3) || !cg.I(cf.I, s4) || (cf.Z != 0 && intValue != cf.Z) || !cg.I(cf.J, s5)) {
                                    break Label_0159;
                                }
                                final int n = 1;
                                if (n != 0) {
                                    break Block_7;
                                }
                            }
                            break;
                        }
                        int i = 0;
                        if (ce.I[i].B == 255) {
                            return Code(s2, null);
                        }
                        return ce.I[i].B;
                    }
                    catch (Throwable t) {}
                    break;
                }
                final int n = 0;
                continue;
            }
        }
        return 0;
    }
    
    public static bu Code(final int n) {
        final bu a = ce.a;
        final bu b = ce.b;
        while (true) {
            for (int i = 0; i < ce.Z.length; ++i) {
                if (ce.Z[i].Code == n) {
                    final bu bu = ce.Z[i];
                    int j = 0;
                    int n2 = 0;
                    int b2 = 0;
                    int k = 0;
                    String c = null;
                    String code = null;
                    int l = 0;
                    String s = null;
                    while (j < 3) {
                        final bu bu2 = (new bu[] { a, b, bu })[j];
                        int n3 = n2;
                        String s2 = s;
                        String s3 = code;
                        String s4 = c;
                        if (bu2 != null) {
                            if (bu2.Z.length() != 0) {
                                s = bu2.Z;
                                n2 = j;
                                code = s;
                            }
                            if (bu2.C.length() != 0) {
                                c = bu2.C;
                            }
                            l = bu2.I;
                            k = bu2.J;
                            b2 = bu2.B;
                            s4 = c;
                            s3 = code;
                            s2 = s;
                            n3 = n2;
                        }
                        ++j;
                        n2 = n3;
                        s = s2;
                        code = s3;
                        c = s4;
                    }
                    if (n2 == 2) {
                        s = Code(s);
                    }
                    else if (n != 0) {
                        code = Code(code, n);
                    }
                    return new bu(n, l, code, k, b2, c, s);
                }
            }
            final bu bu = null;
            continue;
        }
    }
    
    private static String Code(final String s) {
        final int index = s.indexOf(46);
        final int lastIndex = s.lastIndexOf(45, index - 1);
        try {
            final int int1 = Integer.parseInt(s.substring(lastIndex, index));
            String string = s;
            if (int1 >= -255) {
                string = s;
                if (int1 < 0) {
                    string = s.substring(0, lastIndex) + s.substring(index);
                }
            }
            return string;
        }
        catch (Throwable t) {
            return s;
        }
    }
    
    private static String Code(final String s, final int n) {
        final int index = s.indexOf(46);
        String string = s;
        if (index > 0) {
            string = s.substring(0, index) + '-' + n + s.substring(index);
        }
        return string;
    }
    
    static void Code() {
        bs.Code.Z("zerorating");
        try {
            I(q.J(bs.Code.Code("trafficrouting", 1), 0), bs.Code.Code("trafficrouting", 2));
        }
        catch (Throwable t) {
            Z();
        }
    }
    
    static void Code(final int n, final byte[] array) {
        synchronized (ce.class) {
            try {
                I(n, array);
                bs.Code.Z("trafficrouting");
                final byte[] array2 = new byte[4];
                q.Z(ce.Code, array2, 0);
                bs.Code.Code("trafficrouting", array2);
                bs.Code.Code("trafficrouting", array);
            }
            catch (Throwable t) {}
        }
    }
    
    public static bu I(final int n) {
        return new bu(n, ce.a.I, Code(ce.a.Z, 1), ce.a.J, ce.a.B, ce.a.C, ce.a.Z);
    }
    
    private static void I(final int code, final byte[] array) {
        while (true) {
            while (true) {
                int i;
                synchronized (ce.class) {
                    final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(array));
                    try {
                        Z();
                        final bu b = null;
                        int n = dataInputStream.readUnsignedByte();
                        final bu[] z = new bu[n];
                        i = 0;
                        if (i >= n) {
                            n = dataInputStream.readUnsignedByte();
                            final cf[] j = new cf[n + 3];
                            j[0] = ce.B;
                            for (i = 1; i <= n; ++i) {
                                j[i] = new cf(dataInputStream.readUTF(), dataInputStream.readUTF(), dataInputStream.readUnsignedShort(), dataInputStream.readUTF(), dataInputStream.readUnsignedByte());
                            }
                            j[n + 1] = ce.C;
                            j[n + 2] = ce.J;
                            ce.b = b;
                            ce.Z = z;
                            ce.I = j;
                            ce.Code = code;
                            return;
                        }
                        final int unsignedByte = dataInputStream.readUnsignedByte();
                        final int unsignedByte2 = dataInputStream.readUnsignedByte();
                        final String utf = dataInputStream.readUTF();
                        z[i] = new bu(unsignedByte, unsignedByte2, utf, dataInputStream.readUnsignedShort(), dataInputStream.readUnsignedShort(), dataInputStream.readUTF(), utf);
                        if (z[i].Code == 255) {
                            final bu bu = z[i];
                        }
                    }
                    catch (IOException ex) {
                        throw ex;
                    }
                }
                ++i;
                continue;
            }
        }
    }
    
    public static boolean I() {
        synchronized (ce.class) {
            bs.Code.Z("trafficrouting");
            boolean b;
            if (ce.Code != 0) {
                Z();
                b = true;
            }
            else {
                b = false;
            }
            return b;
        }
    }
    
    private static void Z() {
        ce.I = new cf[] { ce.J, ce.B, ce.C };
        ce.Z = new bu[0];
        ce.b = null;
        ce.Code = 0;
    }
}
