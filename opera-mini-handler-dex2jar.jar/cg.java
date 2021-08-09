import java.io.IOException;
import java.util.Random;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Hashtable;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class cg
{
    public static int A;
    public static long B;
    public static long C;
    public static boolean Code;
    public static boolean D;
    public static int E;
    protected static byte[] F;
    protected static byte[] G;
    static boolean H;
    public static boolean I;
    protected static boolean J;
    static String[] K;
    static boolean L;
    static boolean M;
    static boolean N;
    static int O;
    static String P;
    static String Q;
    static String R;
    static int S;
    static int T;
    static boolean U;
    static boolean V;
    static byte W;
    static Object X;
    static byte[] Y;
    protected static boolean Z;
    public static int a;
    private static int aA;
    private static final Hashtable aB;
    private static Integer aC;
    static byte[] aa;
    static byte[] ab;
    protected static int ac;
    protected static int ad;
    public static au[] ae;
    static int af;
    private static int ag;
    private static int ah;
    private static boolean ai;
    private static bv aj;
    private static boolean ak;
    private static int al;
    private static long am;
    private static long an;
    private static long ao;
    private static Object ap;
    private static int[] aq;
    private static int ar;
    private static ak as;
    private static int at;
    private static int au;
    private static int av;
    private static int aw;
    private static final byte[] ax;
    private static final byte[] ay;
    private static int az;
    public static int b;
    public static boolean c;
    public static int d;
    public static int e;
    public static int f;
    protected static int g;
    public static boolean h;
    public static String i;
    public static int j;
    protected static int k;
    public static boolean l;
    public static boolean m;
    protected static int n;
    protected static boolean o;
    protected static boolean p;
    protected static int q;
    public static int r;
    static boolean s;
    static int t;
    protected static int u;
    public static boolean v;
    public static char w;
    public static boolean x;
    public static boolean y;
    public static boolean z;
    
    static {
        cg.C = 500000L;
        cg.a = -1;
        cg.b = 4;
        cg.c = true;
        cg.f = -1;
        cg.j = -1;
        cg.n = -1;
        cg.q = 0;
        cg.s = true;
        cg.t = 2;
        cg.u = 2;
        cg.w = '*';
        cg.ag = -1;
        cg.ah = -1;
        cg.A = 512;
        cg.aj = new bv();
        cg.ak = true;
        cg.K = new String[4];
        cg.ap = new Object();
        cg.X = new Object();
        ax = new byte[] { 34, 34, 35, 35, 37, 37, 39, 39 };
        ay = new byte[] { 33, 34, 34, 35, 35, 36, 36, 37, 37, 38, 38, 38, 38, 39, 39, 40, 40, 40, 40, 41, 41, 42, 42, 42, 42, 43, 43, 43, 43, 44, 44, 44, 44, 45, 45, 45, 45, 46, 46, 46, 46, 47, 47, 48, 48, 49, 49, 50, 50, 51, 51, 51, 51, 52, 52, 52, 52, 53, 53, 53, 53, 54, 54, 54, 54, 55, 55, 55, 55, 56, 56, 56, 56, 57, 57, 57, 57, 58, 58, 58, 58, 65, 65, 65, 65, 66, 66, 66, 66, 67, 67, 67, 67, 68, 68, 68, 68, 69, 69, 69, 69, 70, 70, 70, 70, 71, 71, 71, 71, 72, 72, 73, 73, 74, 74, 74, 74 };
        cg.az = -1;
        cg.aA = -1;
        (aB = new Hashtable(6)).put("http", new Integer(80));
        cg.aB.put("https", new Integer(443));
        cg.aB.put("ftp", new Integer(21));
        cg.aB.put("rtsp", new Integer(554));
        cg.aC = new Integer(0);
    }
    
    static InputStream B(final String s) {
        return u.Code.Z(s);
    }
    
    public static String B(final int n) {
        if (cg.K[n] != null) {
            return cg.K[n];
        }
        return "";
    }
    
    static boolean B() {
        bx.b();
        return cg.E < 160 && cg.D;
    }
    
    public static boolean B(final char c) {
        return ('\uf800' & c) == 0xD800;
    }
    
    protected static String C(final String s) {
        final String property = System.getProperty(s);
        if (property == null) {
            return property;
        }
        final byte[] bytes = property.getBytes();
        synchronized (cg.aj) {
            cg.aj.Code(bytes, 0, bytes.length);
            return property;
        }
    }
    
    public static void C() {
        if (cg.W < 3) {
            ++cg.W;
            b();
        }
    }
    
    private static boolean C(final char c) {
        return '\u0600' <= c && c <= '\u06ff';
    }
    
    public static byte[] C(int i) {
        int n;
        int n2;
        byte[] code;
        final Object o;
        ci ci;
        DataInputStream dataInputStream;
        int code2;
        int n3;
        u j;
        boolean b;
        byte[] array;
        Label_0041_Outer:Label_0019_Outer:
        while (true) {
        Label_0019:
            while (true) {
                Label_0463: {
                    while (true) {
                        synchronized (cg.X) {
                            if (cg.Y == null) {
                                return null;
                            }
                            break Label_0463;
                            while (true) {
                                n /= 3;
                                iftrue(Label_0065:)(n >= 0);
                                return null;
                                iftrue(Label_0458:)(n >= cg.Y.length);
                                iftrue(Label_0058:)(cg.Y[n] != (byte)i);
                                continue Label_0041_Outer;
                            }
                        }
                        Label_0058: {
                            n += 3;
                        }
                        continue Label_0019;
                        Label_0065:
                        n2 = 0;
                    Label_0390_Outer:
                        while (true) {
                            while (true) {
                                Label_0468: {
                                    Label_0410: {
                                        while (true) {
                                            Label_0425: {
                                                try {
                                                    code = bs.Code.Code("mo", n + 2);
                                                    i = code[0];
                                                    if (i != 1) {
                                                        monitorexit(o);
                                                        return null;
                                                    }
                                                    if (code[1] != 16) {
                                                        monitorexit(o);
                                                        return null;
                                                    }
                                                    if (cg.aa == null && (cg.Y[n * 3] != code[2] || cg.Y[n * 3 + 1] != code[3] || cg.Y[n * 3 + 2] != code[4])) {
                                                        cg.aa = new byte[cg.Y.length];
                                                        System.arraycopy(cg.Y, 0, cg.aa, 0, cg.Y.length);
                                                    }
                                                    if (cg.aa != null) {
                                                        cg.aa[n * 3] = code[2];
                                                        cg.aa[n * 3 + 1] = code[3];
                                                        cg.aa[n * 3 + 2] = code[4];
                                                    }
                                                    cg.ab[n] = code[5];
                                                    if (code.length == 6) {
                                                        monitorexit(o);
                                                        return new byte[0];
                                                    }
                                                    ci = new ci();
                                                    ci.Code(new DataInputStream(new ByteArrayInputStream(code, 6, code.length - 6)));
                                                    dataInputStream = new DataInputStream(ci);
                                                    code2 = al.Code((DataInput)dataInputStream);
                                                    i = 0;
                                                    while (i < code2) {
                                                        if ((dataInputStream.read() & 0xFF & 0x80) != 0x0) {
                                                            break Label_0410;
                                                        }
                                                        n3 = dataInputStream.readUnsignedShort();
                                                        i += n3 + 3;
                                                        if (dataInputStream.skipBytes(n3) < n3) {
                                                            throw new EOFException();
                                                        }
                                                    }
                                                    break Label_0425;
                                                }
                                                catch (Throwable t) {
                                                    if (n2 >= u.b) {
                                                        C();
                                                        d();
                                                        monitorexit(o);
                                                        return null;
                                                    }
                                                    u.I.h();
                                                    j = u.I;
                                                    if (n2 > 0) {
                                                        b = true;
                                                        j.Code(b);
                                                        u.I.i();
                                                        ++n2;
                                                        continue Label_0041_Outer;
                                                    }
                                                    break Label_0468;
                                                    array = new byte[al.Code((DataInput)dataInputStream)];
                                                    dataInputStream.readFully(array);
                                                    monitorexit(o);
                                                    return array;
                                                    n3 = dataInputStream.readInt();
                                                    i += n3 + 5;
                                                    continue Label_0390_Outer;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                                b = false;
                                continue;
                            }
                        }
                        Label_0458:
                        n = -1;
                        continue Label_0019_Outer;
                    }
                }
                n = 0;
                continue Label_0019;
            }
        }
    }
    
    private static int Code(final int n, final char c) {
        return cg.ae[n].Code(c);
    }
    
    public static int Code(final int n, final int n2, final int n3) {
        return Math.max(Math.min(n, n3), n2);
    }
    
    private static int Code(int int1, final DataInputStream dataInputStream) {
        Code((InputStream)dataInputStream, (int1 & 0x7FFF) * 4);
        int1 = dataInputStream.readInt();
        final int int2 = dataInputStream.readInt();
        Code((InputStream)dataInputStream, int1);
        return int2 + 4 - int1;
    }
    
    static int Code(final int n, final String s) {
        return cg.ae[n].Code(s);
    }
    
    static int Code(final int n, final char[] array, final int n2, final int n3) {
        return cg.ae[n].Code(array, n2, n3);
    }
    
    public static int Code(int n, final char[] array, final int n2, int n3, final int n4) {
        final int n5 = 0;
        if (n4 <= 0) {
            return 0;
        }
        if (n3 > 0) {
            final int n6 = n2 + n3;
            if (Code(n, array, n2, n3) <= n4) {
                n = n6;
            }
            else {
                final int n7 = n3 = n6 - 1;
                if (b(array[n7])) {
                    n3 = n7 - 1;
                }
                int n8 = n2;
                int n9 = n2;
                int n10 = n3;
                n3 = n5;
                int n11;
                while (true) {
                    n11 = n3;
                    if (n8 >= n10) {
                        break;
                    }
                    final int n12 = n3 = (n8 + n10) / 2;
                    if (b(array[n12])) {
                        n3 = n12 - 1;
                    }
                    final int code = Code(n, array, n2, n3 - n2);
                    if (code < n4) {
                        int n13;
                        if (B(array[n3])) {
                            n13 = 2;
                        }
                        else {
                            n13 = 1;
                        }
                        final int n14 = n13 + n3;
                        final int n15 = code;
                        n9 = n3;
                        n3 = n15;
                        n8 = n14;
                    }
                    else {
                        if (code == n4) {
                            n11 = code;
                            n9 = n3;
                            break;
                        }
                        n10 = n3;
                        final int n16 = code;
                        n9 = n3;
                        n3 = n16;
                    }
                }
                n = n9;
                if (n11 > n4) {
                    n3 = (n = n9 - 1);
                    if (b(array[n3])) {
                        n = n3 - 1;
                    }
                }
            }
        }
        else {
            n = n2;
        }
        return n - n2;
    }
    
    private static int Code(final au au) {
        int n = 0;
        boolean b;
        if (au.C()) {
            b = true;
        }
        else {
            b = false;
        }
        int n2;
        if (au.a()) {
            n2 = 2;
        }
        else {
            n2 = 0;
        }
        int n3;
        if (au.b()) {
            n3 = 4;
        }
        else {
            n3 = 0;
        }
        if (au.c()) {
            n = 8;
        }
        return n3 | (n2 | (b ? 1 : 0)) | n;
    }
    
    static int Code(final String s, final int n) {
        return q.Code(s.substring(0, n));
    }
    
    public static int Code(final String s, final String s2) {
        final int length = s.length();
        if (s2.length() != length + 2 || !s2.startsWith(s)) {
            return -1;
        }
        return s2.charAt(length + 1) - 'A' + (s2.charAt(length) - 'A') * 26;
    }
    
    public static int Code(final char[] array, final boolean b, final int n, final int n2, final au au) {
        int n3 = 0;
        final int n4 = 0;
        int length;
        if (au.Code(array, 0, array.length) <= n) {
            length = n4;
            if (b) {
                length = array.length;
            }
        }
        else {
            final int length2 = array.length;
            if (b) {
                int n5 = length2;
                int n6;
                while (true) {
                    n6 = n5;
                    if (n5 <= 0) {
                        break;
                    }
                    final int n7 = n5 / 2;
                    n6 = n5;
                    if (au.Code(array, 0, n7 + 0) + n2 <= n) {
                        break;
                    }
                    n5 = n7;
                }
                while (n6 > 0 && au.Code(array, 0, n6 + 0) + n2 > n) {
                    --n6;
                }
                return n6;
            }
            int n8;
            while ((n8 = n3) < length2) {
                final int n9 = (length2 - n3) / 2 + n3 + 1;
                n8 = n3;
                if (au.Code(array, n9, length2 - n9) + n2 <= n) {
                    break;
                }
                n3 = n9;
            }
            while ((length = n8) < length2) {
                length = n8;
                if (au.Code(array, n8, length2 - n8) + n2 <= n) {
                    break;
                }
                ++n8;
            }
        }
        return length;
    }
    
    public static int Code(final int[] array, final int n, final int n2, final int n3) {
        return Code(array, 0, n, n2, -1, n3);
    }
    
    public static int Code(final int[] array, final int n, int n2, final int n3, final int n4, final int n5) {
        int n6 = -1;
        while (n2 - n6 > 1) {
            final int n7 = n6 + n2 >>> 1;
            if ((array[n7 * n3 + n + 0] & n4) < n5) {
                n6 = n7;
            }
            else {
                n2 = n7;
            }
        }
        return n2;
    }
    
    static az Code(final int n, final boolean b) {
        final byte[] c = c(n);
        return u.Code.q().Code(c, c.length, b);
    }
    
    static String Code(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '\0') {
                sb.append("%00");
            }
            else if ("%&=;".indexOf(char1) >= 0) {
                sb.append('%').append(Integer.toString(char1, 16));
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
    
    static String Code(final String s, final boolean b) {
        if (s == null) {
            return s;
        }
        final StringBuffer sb = new StringBuffer(s.length());
        int n;
        for (int i = 0; i < s.length(); i = n + 1) {
            final char char1 = s.charAt(i);
            if (b) {
                if (char1 <= '\u007f') {
                    if (char1 == '%' || char1 <= ' ') {
                        Code(sb, char1);
                        n = i;
                    }
                    else {
                        sb.append(char1);
                        n = i;
                    }
                }
                else {
                    if (char1 > '\u07ff') {
                        Code(sb, (char)((char1 >> 12 & 0xF) | 0xE0));
                        Code(sb, (char)((char1 >> 6 & 0x3F) | 0x80));
                    }
                    else {
                        Code(sb, (char)((char1 >> 6 & 0x1F) | 0xC0));
                    }
                    Code(sb, (char)((char1 >> 0 & 0x3F) | 0x80));
                    n = i;
                }
            }
            else if (char1 == '%') {
                final int int1 = Integer.parseInt(s.substring(i + 1, i + 3), 16);
                if (int1 < 32) {
                    sb.append(char1);
                    n = i;
                }
                else if (int1 <= 127) {
                    sb.append((char)int1);
                    n = i + 2;
                }
                else if (int1 <= 223) {
                    sb.append((char)((Integer.parseInt(s.substring(i + 4, i + 6), 16) & 0x3F) | (int1 & 0x1F) << 6));
                    n = i + 5;
                }
                else {
                    n = i;
                    if (int1 <= 239) {
                        sb.append((char)((Integer.parseInt(s.substring(i + 4, i + 6), 16) & 0x3F) << 6 | (int1 & 0xF) << 12 | (Integer.parseInt(s.substring(i + 7, i + 9), 16) & 0x3F) << 0));
                        n = i + 8;
                    }
                }
            }
            else {
                sb.append(char1);
                n = i;
            }
        }
        return sb.toString();
    }
    
    public static String Code(byte[] array) {
        final bv bv = new bv();
        bv.Code(array, 0, array.length);
        array = new byte[32];
        bv.Code(array);
        return Code(array, array.length);
    }
    
    private static String Code(final byte[] array, int i) {
        final int min = Math.min(i, 128);
        final StringBuffer sb = new StringBuffer();
        for (i = 0; i < min + 0; ++i) {
            if ((array[i] & 0xFF) < 16) {
                sb.append('0');
            }
            sb.append(Integer.toString(array[i] & 0xFF, 16));
        }
        return sb.toString();
    }
    
    public static void Code() {
        Z((int)System.currentTimeMillis());
    }
    
    public static void Code(final int n) {
        final long n2 = n;
        try {
            Thread.sleep(n2);
        }
        catch (InterruptedException ex) {}
    }
    
    private static void Code(final int n, final int n2) {
        cg.au = ((cg.au <<= n2) | ((1 << n2) - 1 & n));
        cg.at += n2;
        while (cg.at >= 8) {
            cg.at -= 8;
            cg.as.write(cg.au >> cg.at);
        }
    }
    
    public static void Code(final int n, final String s, final boolean b) {
        if (cg.K[n] == null || !cg.K[n].equals(s)) {
            cg.K[n] = s;
            if (n == 1 && b) {
                a("mc");
            }
            else if (n == 3 && b) {
                a("md");
            }
        }
    }
    
    static void Code(final long n, final long n2, final long n3) {
        synchronized (cg.ap) {
            cg.an += n;
            cg.ao += n2;
            cg.am += n3;
        }
    }
    
    public static void Code(final ar ar) {
        try {
            ar.C();
        }
        catch (Throwable t) {}
    }
    
    public static void Code(final aw aw, final int n, final char[] array, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9) {
        aw.Code(n, array, n2, n3, n4, n5 + cg.ae[n].Z(), n6, true, n7, n8, n9);
    }
    
    private static void Code(final ByteArrayOutputStream byteArrayOutputStream, final int n, final int n2, final int n3, final String s) {
        final byte[] array = new byte[q.Code(s) + 2];
        final int code = q.Code(s, array, 0);
        byteArrayOutputStream.write(n >> 8 & 0xFF);
        byteArrayOutputStream.write(n & 0xFF);
        byteArrayOutputStream.write(n2 >> 8 & 0xFF);
        byteArrayOutputStream.write(n2 & 0xFF);
        byteArrayOutputStream.write(n3);
        byteArrayOutputStream.write(code);
        byteArrayOutputStream.write(array, 2, code);
    }
    
    private static void Code(final DataInputStream dataInputStream, int i) {
        while (i > 0) {
            Z(dataInputStream.readInt());
            --i;
        }
    }
    
    static void Code(final DataOutputStream dataOutputStream, final int[] array) {
        if (array != null) {
            dataOutputStream.writeShort(array.length);
            dataOutputStream.write(Code(array));
            return;
        }
        dataOutputStream.writeShort(0);
    }
    
    public static void Code(final InputStream inputStream) {
        try {
            inputStream.close();
        }
        catch (Throwable t) {}
    }
    
    public static void Code(final InputStream inputStream, int i) {
        while (i > 0) {
            i -= (int)inputStream.skip(i);
        }
    }
    
    public static void Code(final OutputStream outputStream) {
        try {
            outputStream.close();
        }
        catch (Throwable t) {}
    }
    
    public static void Code(final Object o) {
        synchronized (o) {
            o.notifyAll();
        }
    }
    
    public static void Code(final Object o, final int n) {
        monitorenter(o);
        final long n2 = n;
        try {
            try {
                o.wait(n2);
            }
            finally {
                monitorexit(o);
            }
        }
        catch (InterruptedException ex) {}
    }
    
    public static void Code(final Runnable runnable) {
        new Thread(runnable).start();
    }
    
    private static void Code(final StringBuffer sb, final char c) {
        sb.append('%');
        if (c < '\u0010') {
            sb.append('0');
        }
        sb.append(Integer.toHexString(c));
    }
    
    static void Code(final boolean b) {
    Label_0391_Outer:
        while (true) {
            int n = 0;
            bv bv;
            char[] array2;
            char[] array;
            int n2;
            int i;
            int n3 = 0;
            int[] array3;
            int n4;
            int code;
            int abs;
            int n5;
            int n6;
            int[] array4;
            int n7;
            int n8;
            int n9;
            int n10;
            int n11;
            ak as;
            Label_0391:Label_0787_Outer:
            while (true) {
                Label_0787:Label_0753_Outer:
                while (true) {
                Label_1098:
                    while (true) {
                    Label_0733:
                        while (true) {
                            while (true) {
                                Label_1075: {
                                    Label_1070: {
                                        Label_0662:Block_24_Outer:
                                        while (true) {
                                            synchronized (cg.class) {
                                                cg.af = 0;
                                                if (!b && cg.F != null) {
                                                    n = cg.F.length;
                                                    if (n == 32) {
                                                        return;
                                                    }
                                                }
                                                bv = new bv();
                                                array = (array2 = new char[13]);
                                                array2[0] = ' ';
                                                array2[1] = 'm';
                                                array2[2] = 'i';
                                                array2[3] = '0';
                                                array2[4] = 'X';
                                                array2[5] = '\u00e5';
                                                array2[6] = '\u0627';
                                                array2[7] = '\u05df';
                                                array2[8] = '\u03a8';
                                                array2[9] = '\u3042';
                                                array2[10] = '\u044e';
                                                array2[11] = '\u4e00';
                                                array2[12] = '\u330f';
                                                cg.as = new ak(32);
                                                cg.ar = (cg.ac - cg.ad) * 16454;
                                                if (b) {
                                                    u.I.h();
                                                    u.Z.c(cg.ar);
                                                    u.I.Z(32);
                                                }
                                                break Label_1070;
                                                Block_18: {
                                                    while (true) {
                                                    Block_15_Outer:
                                                        while (true) {
                                                            n2 = Math.max(0, cg.ae[n].I() - d(n) - cg.ae[n].Z());
                                                            i = cg.ae[n].I();
                                                            cg.as.write(i - n2);
                                                            cg.as.write(cg.ae[n].I());
                                                            n2 = 0;
                                                            while (true) {
                                                                Label_0278: {
                                                                    break Label_0278;
                                                                    iftrue(Label_1017:)(n3 >= cg.ac);
                                                                    Block_19: {
                                                                        while (true) {
                                                                            Block_17: {
                                                                                break Block_17;
                                                                                iftrue(Label_0941:)(i > 65535);
                                                                                break Block_19;
                                                                                n3 = 0;
                                                                                continue Label_0391;
                                                                            }
                                                                            iftrue(Label_1122:)(u.Code.a(n3));
                                                                            break Block_18;
                                                                            cg.as.write(Code(n, array[n2]));
                                                                            ++n2;
                                                                            break Label_0278;
                                                                            Label_0359: {
                                                                                ((bv)(Object)array3).Code(1);
                                                                            }
                                                                            cg.as.Code(32);
                                                                            ((bv)(Object)array3).Code(cg.as.Code());
                                                                            iftrue(Label_1025:)(!b);
                                                                            continue Block_15_Outer;
                                                                        }
                                                                        Code(cg.aw, cg.av);
                                                                        Code(1, cg.av * 2);
                                                                        ++cg.av;
                                                                        cg.aw = 1 << cg.av - 1;
                                                                        break Label_0787;
                                                                    }
                                                                    n4 = i + 1;
                                                                    code = Code(n3, (char)i);
                                                                    ++cg.af;
                                                                    i = code - n2;
                                                                    abs = Math.abs(i);
                                                                    iftrue(Label_1082:)(i != n5 || n4 - 1 == array3[n6]);
                                                                    ++n;
                                                                    n2 = code;
                                                                    i = n4;
                                                                    continue Label_0662;
                                                                }
                                                                iftrue(Label_0306:)(n2 >= array.length);
                                                                continue Block_24_Outer;
                                                            }
                                                            Label_0306: {
                                                                Code(cg.as, n, 1, Code(cg.ae[n]), cg.ae[n].B());
                                                            }
                                                            ((bv)(Object)array3).Code(cg.as.Code(), 0, cg.as.size());
                                                            cg.as.reset();
                                                            break Label_1075;
                                                            iftrue(Label_1098:)(n2 >= n);
                                                            Code(n5, cg.av);
                                                            ++n2;
                                                            continue Label_0733;
                                                            iftrue(Label_0359:)(n >= cg.ac);
                                                            iftrue(Label_1075:)(u.Code.a(n));
                                                            continue Label_0391_Outer;
                                                        }
                                                        iftrue(Label_0863:)(abs >>> cg.av - 1 == 0);
                                                        continue Label_0787_Outer;
                                                    }
                                                    Code(cg.aw, cg.av);
                                                    iftrue(Label_0845:)(n > 1 << cg.av * 2 - 1);
                                                    Code(n, cg.av * 2);
                                                    break Label_1098;
                                                }
                                                n = Math.max(0, cg.ae[n3].I() - d(n3) - cg.ae[n3].Z());
                                                n2 = cg.ae[n3].I();
                                                cg.as.write(n3 >> 8 & 0xFF);
                                                cg.as.write(n3 & 0xFF);
                                                cg.as.write(n2 - n);
                                                cg.as.write(n);
                                                cg.ae[n3].d();
                                                cg.at = 0;
                                                cg.av = 4;
                                                cg.aw = 1 << cg.av - 1;
                                                array3 = (array4 = new int[17]);
                                                array4[array4[0] = 1] = 31;
                                                array4[2] = 2043;
                                                array4[3] = 2303;
                                                array4[4] = 7037;
                                                array4[5] = 7423;
                                                array4[6] = 13312;
                                                array4[7] = 19903;
                                                array4[8] = 19968;
                                                array4[9] = 40895;
                                                array4[10] = 42183;
                                                array4[11] = 42751;
                                                array4[12] = 44032;
                                                array4[13] = 55203;
                                                array4[14] = 55296;
                                                array4[15] = 64255;
                                                array4[16] = 65536;
                                                n6 = 0;
                                                n = 0;
                                                n5 = Integer.MAX_VALUE;
                                                i = 1;
                                                n2 = 0;
                                                continue Label_0662;
                                            }
                                            Label_0845: {
                                                Code(2, cg.av * 2);
                                            }
                                            Code(n, 16);
                                            break Label_1098;
                                            Label_0863:
                                            Code(i, cg.av);
                                            n7 = n6;
                                            n = n2;
                                            n8 = n4;
                                            if (n4 - 1 == array3[n6]) {
                                                Code(0, cg.av);
                                                n9 = array3[n6 + 1];
                                                n10 = array3[n6];
                                                n11 = array3[n6 + 1];
                                                n7 = n6 + 2;
                                                n8 = n11 + 1;
                                                n = n9 - n10 - 1;
                                                i = 0;
                                            }
                                            n4 = i;
                                            i = n8;
                                            n2 = code;
                                            n6 = n7;
                                            n5 = n4;
                                            continue Label_0662;
                                        }
                                        Label_0941: {
                                            if (n > 0) {
                                                Code(cg.aw, cg.av);
                                                Code(2, cg.av * 2);
                                                Code(n, 16);
                                            }
                                        }
                                        Code(cg.aw, cg.av);
                                        Code(3, cg.av * 2);
                                        if (cg.at != 0) {
                                            cg.as.write(cg.au << 8 - cg.at);
                                        }
                                        as = cg.as;
                                        break Label_0787;
                                        Label_1017:
                                        u.Code.ab();
                                        Label_1025:
                                        cg.F = cg.as.toByteArray();
                                        cg.as = null;
                                        cg.G = null;
                                        if (b) {
                                            k();
                                        }
                                        if (b) {
                                            u.I.h();
                                            u.I.Z(33);
                                            return;
                                        }
                                        return;
                                    }
                                    n = 0;
                                    continue Label_0753_Outer;
                                }
                                ++n;
                                continue Label_0753_Outer;
                            }
                            Label_1082: {
                                if ((n2 = n) <= 0) {
                                    continue Label_0787;
                                }
                            }
                            if (n < 4) {
                                n2 = 0;
                                continue Label_0733;
                            }
                            break;
                        }
                        continue;
                    }
                    n2 = 0;
                    continue Label_0787;
                }
                ++n3;
                continue Label_0391;
            }
        }
    }
    
    static void Code(final byte[] array, final int n, final int n2, final int n3) {
        array[0] = 1;
        array[1] = 16;
        array[2] = (byte)n;
        array[3] = (byte)(n2 >> 8);
        array[4] = (byte)n2;
        array[5] = (byte)n3;
    }
    
    static void Code(final byte[] array, int j, int z, int n, final int aa, final int az, final int[] array2) {
        final boolean b = aa != -1 && az != -1;
        if ((z >= 4 && array[j] == 82) || array[j] == 67 || array[j] == 88) {
            if (array[j] == 88) {
                array2[0] = (array[j + 1] << 3 | (array[j + 2] >>> 5 & 0x7) * ((array[j + 2] & 0x1F) << 6) | (array[j + 3] >>> 2 & 0x3F) * cg.b);
            }
            else {
                array2[0] = array[j + 1] * array[j + 2] * cg.b;
            }
            j = array2[0];
            array2[1] = (array2[2] = j);
            cg.az = 0;
            cg.aA = 0;
            return;
        }
        int i = 0;
        Label_0188: {
            if (z >= 23 && array[j] == -119) {
                i = q.J(array, j + 16);
                j = q.J(array, j + 20);
                z = 0;
            }
            else {
                if (array[j] == -1 && array[j + 1] == -40) {
                    int n2 = 2;
                    while (true) {
                        while (n2 < z && array[j + n2] == -1) {
                            final int n3 = ++n2;
                            if (array[j + n3] != -1) {
                                if (array[j + n3] == 0) {
                                    break;
                                }
                                if (array[j + n3] == 1 || (array[j + n3] >= -48 && array[j + n3] <= -41)) {
                                    n2 = n3 + 1;
                                }
                                else if (array[j + n3] == -64 || array[j + n3] == -62) {
                                    z = q.Z(array, j + n3 + 6);
                                    final int z2 = q.Z(array, n3 + j + 4);
                                    j = z;
                                    z = z2;
                                    int n4;
                                    if (b) {
                                        n4 = az * 256 / j;
                                    }
                                    else {
                                        n4 = n;
                                    }
                                    if (!cg.s && n4 < 256) {
                                        int n5;
                                        for (n5 = 8; 256 / n5 <= n4; n5 /= 2) {}
                                        final int n6 = j;
                                        j = z;
                                        z = n5;
                                        i = n6;
                                        break Label_0188;
                                    }
                                    final int n7 = 0;
                                    i = j;
                                    j = z;
                                    z = n7;
                                    break Label_0188;
                                }
                                else {
                                    final int n8 = n3 + 1;
                                    n2 = n8 + q.Z(array, j + n8);
                                }
                            }
                        }
                        z = 0;
                        j = 0;
                        continue;
                    }
                }
                z = 0;
                j = 0;
                i = 0;
            }
        }
        cg.az = az;
        cg.aA = aa;
        array2[1] = az * aa * cg.b;
        if (n == 256) {
            j = array2[1];
            array2[0] = (array2[2] = j);
            return;
        }
        array2[0] = ((az * n - 1) / 256 + 1) * ((aa * n - 1) / 256 + 1) * cg.b;
        if (z > 0) {
            n = array2[0];
            array2[2] = j * i * cg.b / z + n;
            return;
        }
        array2[2] = array2[0] + array2[1];
    }
    
    static void Code(final byte[] array, int aa, int az, final int[] array2) {
        if ((az >= 4 && array[aa] == 82) || array[aa] == 67 || array[aa] == 88) {
            if (array[aa] == 88) {
                array2[0] = (array[aa + 1] << 3 | (array[aa + 2] >>> 5 & 0x7) * ((array[aa + 2] & 0x1F) << 6) | (array[aa + 3] >>> 2 & 0x3F) * cg.b);
            }
            else {
                array2[0] = array[aa + 1] * array[aa + 2] * cg.b;
            }
            aa = array2[0];
            array2[1] = (array2[2] = aa);
            cg.az = 0;
            cg.aA = 0;
            return;
        }
        Label_0159: {
            if (az >= 23 && array[aa] == -119) {
                az = q.J(array, aa + 16);
                aa = q.J(array, aa + 20);
            }
            else {
                if (array[aa] == -1 && array[aa + 1] == -40) {
                    int n = 2;
                    while (true) {
                        while (n < az && array[aa + n] == -1) {
                            final int n2 = ++n;
                            if (array[aa + n2] != -1) {
                                if (array[aa + n2] == 0) {
                                    break;
                                }
                                if (array[aa + n2] == 1 || (array[aa + n2] >= -48 && array[aa + n2] <= -41)) {
                                    n = n2 + 1;
                                }
                                else {
                                    if (array[aa + n2] == -64 || array[aa + n2] == -62) {
                                        az = q.Z(array, aa + n2 + 6);
                                        aa = q.Z(array, n2 + aa + 4);
                                        final boolean s = cg.s;
                                        break Label_0159;
                                    }
                                    final int n3 = n2 + 1;
                                    n = n3 + q.Z(array, aa + n3);
                                }
                            }
                        }
                        aa = 0;
                        az = 0;
                        continue;
                    }
                }
                aa = 0;
                az = 0;
            }
        }
        array2[1] = az * aa * cg.b;
        cg.az = az;
        cg.aA = aa;
        aa = array2[1];
        array2[0] = (array2[2] = aa);
    }
    
    public static boolean Code(final char c) {
        return I(c) || Z(c);
    }
    
    public static boolean Code(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        return n < n5 + n7 && n + n3 > n5 && n2 < n6 + n8 && n2 + n4 > n6;
    }
    
    public static boolean Code(final int p0, final byte[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_3       
        //     4: aload_3        
        //     5: monitorenter   
        //     6: getstatic       bs.Code:Lbs;
        //     9: ldc_w           "mo"
        //    12: iconst_1       
        //    13: invokevirtual   bs.Code:(Ljava/lang/String;I)[B
        //    16: astore          4
        //    18: aload           4
        //    20: arraylength    
        //    21: iconst_1       
        //    22: if_icmpne       175
        //    25: aload           4
        //    27: iconst_0       
        //    28: baload         
        //    29: istore_2       
        //    30: iload_2        
        //    31: iconst_m1      
        //    32: if_icmpne       44
        //    35: getstatic       bs.Code:Lbs;
        //    38: ldc_w           "mo"
        //    41: invokevirtual   bs.Z:(Ljava/lang/String;)V
        //    44: iload_0        
        //    45: iload_2        
        //    46: if_icmpge       73
        //    49: getstatic       bs.Code:Lbs;
        //    52: ldc_w           "mo"
        //    55: iload_0        
        //    56: iconst_2       
        //    57: iadd           
        //    58: aload_1        
        //    59: invokevirtual   bs.Code:(Ljava/lang/String;I[B)V
        //    62: aload_3        
        //    63: monitorexit    
        //    64: iconst_1       
        //    65: ireturn        
        //    66: astore          4
        //    68: iconst_m1      
        //    69: istore_2       
        //    70: goto            30
        //    73: iconst_1       
        //    74: newarray        B
        //    76: astore          4
        //    78: aload           4
        //    80: iconst_0       
        //    81: iload_0        
        //    82: iconst_1       
        //    83: iadd           
        //    84: i2b            
        //    85: bastore        
        //    86: iload_2        
        //    87: iconst_m1      
        //    88: if_icmpne       130
        //    91: getstatic       bs.Code:Lbs;
        //    94: ldc_w           "mo"
        //    97: aload           4
        //    99: invokevirtual   bs.Code:(Ljava/lang/String;[B)I
        //   102: pop            
        //   103: iconst_0       
        //   104: istore_2       
        //   105: iload_2        
        //   106: iload_0        
        //   107: if_icmpge       156
        //   110: getstatic       bs.Code:Lbs;
        //   113: ldc_w           "mo"
        //   116: iconst_0       
        //   117: newarray        B
        //   119: invokevirtual   bs.Code:(Ljava/lang/String;[B)I
        //   122: pop            
        //   123: iload_2        
        //   124: iconst_1       
        //   125: iadd           
        //   126: istore_2       
        //   127: goto            105
        //   130: getstatic       bs.Code:Lbs;
        //   133: ldc_w           "mo"
        //   136: iconst_1       
        //   137: aload           4
        //   139: invokevirtual   bs.Code:(Ljava/lang/String;I[B)V
        //   142: goto            105
        //   145: astore_1       
        //   146: invokestatic    cg.b:()V
        //   149: invokestatic    cg.C:()V
        //   152: aload_3        
        //   153: monitorexit    
        //   154: iconst_0       
        //   155: ireturn        
        //   156: getstatic       bs.Code:Lbs;
        //   159: ldc_w           "mo"
        //   162: aload_1        
        //   163: invokevirtual   bs.Code:(Ljava/lang/String;[B)I
        //   166: pop            
        //   167: goto            62
        //   170: astore_1       
        //   171: aload_3        
        //   172: monitorexit    
        //   173: aload_1        
        //   174: athrow         
        //   175: iconst_m1      
        //   176: istore_2       
        //   177: goto            30
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      25     66     73     Ljava/lang/Throwable;
        //  6      25     170    175    Any
        //  35     44     170    175    Any
        //  49     62     145    156    Ljava/lang/Throwable;
        //  49     62     170    175    Any
        //  62     64     170    175    Any
        //  73     78     145    156    Ljava/lang/Throwable;
        //  73     78     170    175    Any
        //  91     103    145    156    Ljava/lang/Throwable;
        //  91     103    170    175    Any
        //  110    123    145    156    Ljava/lang/Throwable;
        //  110    123    170    175    Any
        //  130    142    145    156    Ljava/lang/Throwable;
        //  130    142    170    175    Any
        //  146    154    170    175    Any
        //  156    167    145    156    Ljava/lang/Throwable;
        //  156    167    170    175    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0062:
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
    
    public static boolean Code(final byte[] array, final byte[] array2) {
        final boolean b = false;
        boolean b2;
        if (array == array2) {
            b2 = true;
        }
        else {
            b2 = b;
            if (array != null) {
                b2 = b;
                if (array2 != null) {
                    b2 = b;
                    if (array.length == array2.length) {
                        for (int i = 0; i < array.length; ++i) {
                            b2 = b;
                            if (array[i] != array2[i]) {
                                return b2;
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return b2;
    }
    
    static byte[] Code(final int[] array) {
        final byte[] array2 = new byte[array.length * 4];
        int length = array2.length;
        while (true) {
            --length;
            if (length < 0) {
                break;
            }
            array2[length] = (byte)(array[length / 4] >> (3 - length % 4) * 8);
        }
        return array2;
    }
    
    static int[] Code(final DataInputStream dataInputStream) {
        final int unsignedShort = dataInputStream.readUnsignedShort();
        if (unsignedShort == 0) {
            return null;
        }
        final byte[] array = new byte[unsignedShort * 4];
        dataInputStream.readFully(array);
        return Code(array, 0, array.length);
    }
    
    static int[] Code(final byte[] array, final int n, int length) {
        final int[] array2 = new int[length / 4];
        length = array2.length;
        while (true) {
            --length;
            if (length < 0) {
                break;
            }
            array2[length] = (array[length * 4 + n] << 24 | (array[length * 4 + n + 1] & 0xFF) << 16 | (array[length * 4 + n + 2] & 0xFF) << 8 | (array[length * 4 + n + 3] & 0xFF));
        }
        return array2;
    }
    
    static int[] Code(final int[] array, final int n) {
        final int[] array2 = new int[n];
        System.arraycopy(array, 0, array2, 0, array.length);
        return array2;
    }
    
    static az[] Code(final az[] array, final int n) {
        final az[] array2 = new az[n];
        System.arraycopy(array, 0, array2, 0, array.length);
        return array2;
    }
    
    static bm I(final byte[] array) {
        Object aj = cg.aj;
        synchronized (aj) {
            final int al = cg.al;
            cg.al = al + 1;
            Z(al);
            cg.aj.Code(array);
            cg.aj.Code(array, 0, 32);
            monitorexit(aj);
            aj = new bm();
            ((bm)aj).Code(array, 0);
            final byte[] c = aj.c;
            ((bm)aj).I(c, c.length);
            ((bm)aj).Z(array, 0);
            return (bm)aj;
        }
    }
    
    static DataInputStream I() {
        final DataInputStream dataInputStream = new DataInputStream(B("/t"));
        Code(1, dataInputStream);
        return dataInputStream;
    }
    
    static String I(String substring) {
        final StringBuffer sb = new StringBuffer();
        sb.ensureCapacity(substring.length());
        while (true) {
            final int index = substring.indexOf(37);
            if (index < 0 || index + 3 > substring.length()) {
                break;
            }
            sb.append(substring.substring(0, index)).append((char)Integer.parseInt(substring.substring(index + 1, index + 3), 16));
            substring = substring.substring(index + 3, substring.length());
        }
        return sb.append(substring).toString();
    }
    
    public static void I(final int n) {
        cg.E += n;
        if (cg.ak) {
            u.I.j();
            if (cg.E >= 160) {
                cg.ak = false;
                Code(cg.aj);
            }
        }
    }
    
    public static boolean I(final char c) {
        return '\u0590' <= c && c <= '\u05ff';
    }
    
    public static boolean I(final String s, final String s2) {
        final boolean b = false;
        final int length = s2.length();
        final int length2 = s.length();
        boolean b2;
        if (length2 == 0 && length == 0) {
            b2 = true;
        }
        else {
            b2 = b;
            if (length2 != 0) {
                int n = -1;
                int n2 = 0;
                while (true) {
                    final int index = s.indexOf(42, n + 1);
                    String s3;
                    if (index != -1) {
                        s3 = s.substring(n + 1, index);
                    }
                    else {
                        s3 = s.substring(n + 1);
                    }
                    int index2;
                    if (s3.length() == 0 && n2 == s2.length()) {
                        index2 = n2;
                    }
                    else {
                        index2 = s2.indexOf(s3, n2);
                    }
                    b2 = b;
                    if (index2 == -1) {
                        return b2;
                    }
                    if (n2 == 0 && index2 > 0) {
                        b2 = b;
                        if (s.charAt(0) != '*') {
                            return b2;
                        }
                    }
                    if (n == length2 - 1) {
                        break;
                    }
                    n2 = s3.length() + index2;
                    if (n2 >= length && index == -1) {
                        return true;
                    }
                    n = index;
                }
                return true;
            }
        }
        return b2;
    }
    
    static boolean I(final byte[] array, int n, int n2) {
        if (n2 > 8) {
            n2 = n + 1;
            if (array[n] == -119) {
                n = n2 + 1;
                if (array[n2] == 80) {
                    n2 = n + 1;
                    if (array[n] == 78) {
                        n = n2 + 1;
                        if (array[n2] == 71) {
                            n2 = n + 1;
                            if (array[n] == 13) {
                                n = n2 + 1;
                                if (array[n2] == 10 && array[n] == 26 && array[n + 1] == 10) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    static void J() {
        Label_0087: {
            synchronized (cg.class) {
                if (!B()) {
                    break Label_0087;
                }
                u.I.h();
                u.Z.c(160);
                u.Z.c(cg.E);
                u.Z.c(1);
                u.I.Z(34);
                while (cg.E < 160) {
                    Code(cg.aj, 5000);
                }
            }
            a("mc");
            a("md");
        }
        if (cg.E >= 160 && cg.K[1] == null) {
            final byte[] array = new byte[32];
            I(array);
            Code(1, Code(array, array.length), true);
        }
        monitorexit(cg.class);
    }
    
    static void J(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: ldc_w           32768
        //     5: iload_0        
        //     6: iand           
        //     7: ifne            71
        //    10: new             Ljava/io/DataInputStream;
        //    13: dup            
        //    14: ldc_w           "/t"
        //    17: invokestatic    cg.B:(Ljava/lang/String;)Ljava/io/InputStream;
        //    20: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    23: astore_2       
        //    24: aload_2        
        //    25: astore_1       
        //    26: iload_0        
        //    27: aload_2        
        //    28: invokestatic    cg.Code:(ILjava/io/DataInputStream;)I
        //    31: istore_0       
        //    32: aload_2        
        //    33: astore_1       
        //    34: getstatic       u.Z:Lp;
        //    37: iload_0        
        //    38: invokevirtual   p.r:(I)V
        //    41: aload_2        
        //    42: astore_1       
        //    43: getstatic       u.Z:Lp;
        //    46: getfield        p.Code:[B
        //    49: astore_3       
        //    50: aload_2        
        //    51: astore_1       
        //    52: getstatic       u.Z:Lp;
        //    55: astore          4
        //    57: aload_2        
        //    58: astore_1       
        //    59: aload_2        
        //    60: aload_3        
        //    61: iconst_0       
        //    62: iload_0        
        //    63: invokevirtual   java/io/DataInputStream.readFully:([BII)V
        //    66: aload_2        
        //    67: invokevirtual   java/io/InputStream.close:()V
        //    70: return         
        //    71: iload_0        
        //    72: invokestatic    ab.Code:(I)Lab;
        //    75: astore_3       
        //    76: new             Ljava/io/DataInputStream;
        //    79: dup            
        //    80: aload_3        
        //    81: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    84: astore_2       
        //    85: aload_2        
        //    86: astore_1       
        //    87: aload_3        
        //    88: invokevirtual   ab.Code:()I
        //    91: istore_0       
        //    92: goto            32
        //    95: astore_1       
        //    96: aconst_null    
        //    97: astore_1       
        //    98: aload_1        
        //    99: invokevirtual   java/io/InputStream.close:()V
        //   102: return         
        //   103: astore_1       
        //   104: return         
        //   105: astore_3       
        //   106: aload_1        
        //   107: astore_2       
        //   108: aload_3        
        //   109: astore_1       
        //   110: aload_2        
        //   111: invokevirtual   java/io/InputStream.close:()V
        //   114: aload_1        
        //   115: athrow         
        //   116: astore_1       
        //   117: return         
        //   118: astore_2       
        //   119: goto            114
        //   122: astore_1       
        //   123: goto            110
        //   126: astore_1       
        //   127: goto            110
        //   130: astore_1       
        //   131: goto            110
        //   134: astore_2       
        //   135: goto            98
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  10     24     95     98     Ljava/lang/Exception;
        //  10     24     105    110    Any
        //  26     32     134    138    Ljava/lang/Exception;
        //  26     32     122    126    Any
        //  34     41     134    138    Ljava/lang/Exception;
        //  34     41     130    134    Any
        //  43     50     134    138    Ljava/lang/Exception;
        //  43     50     130    134    Any
        //  52     57     134    138    Ljava/lang/Exception;
        //  52     57     130    134    Any
        //  59     66     134    138    Ljava/lang/Exception;
        //  59     66     130    134    Any
        //  66     70     116    118    Ljava/lang/Throwable;
        //  71     85     95     98     Ljava/lang/Exception;
        //  71     85     105    110    Any
        //  87     92     134    138    Ljava/lang/Exception;
        //  87     92     126    130    Any
        //  98     102    103    105    Ljava/lang/Throwable;
        //  110    114    118    122    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0032:
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
    
    public static boolean J(final char c) {
        boolean b = false;
        int n;
        if (I(c)) {
            n = 2;
        }
        else if (C(c)) {
            n = 4;
        }
        else if (a(c)) {
            n = 8;
        }
        else {
            n = 0;
        }
        if ((n & cg.r) != 0x0) {
            b = true;
        }
        return b;
    }
    
    static byte[] J(final String s) {
        final byte[] array = new byte[s.length() / 2];
        for (int i = 0; i < array.length; ++i) {
            array[i] = (byte)Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16);
        }
        return array;
    }
    
    static String Z(final String s) {
        String string = s;
        if (s != null) {
            string = s;
            if (!s.endsWith("/")) {
                string = s + "/";
            }
        }
        return string;
    }
    
    static void Z() {
        synchronized (cg.ap) {
            final long an = cg.an;
            final long ao = cg.ao;
            final long am = cg.am;
            cg.am = 0L;
            cg.ao = 0L;
            cg.an = 0L;
            monitorexit(cg.ap);
            final long n = an - am;
            u.I.h();
            u.Z.Z(u.Z.I(10, 56));
            u.Z.B(u.Z.Z(), 0, (int)an);
            u.Z.B(u.Z.Z(), 1, (int)(an >> 32));
            u.Z.B(u.Z.Z(), 2, (int)ao);
            u.Z.B(u.Z.Z(), 3, (int)(ao >> 32));
            u.Z.B(u.Z.Z(), 4, (int)n);
            u.Z.B(u.Z.Z(), 5, (int)(n >> 32));
            u.Z.B(u.Z.Z(), 8, (int)am);
            u.Z.B(u.Z.Z(), 9, (int)(am >> 32));
            u.Z.b(u.Z.Z());
            u.Z.Z(0);
            u.I.Z(6);
        }
    }
    
    public static void Z(final int n) {
        synchronized (cg.aj) {
            cg.aj.Code(n);
        }
    }
    
    public static boolean Z(final char c) {
        return C(c) || a(c);
    }
    
    static int a(final int n) {
        return cg.ae[n].I();
    }
    
    public static void a() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_3       
        //     4: aload_3        
        //     5: monitorenter   
        //     6: getstatic       cg.Y:[B
        //     9: ifnull          18
        //    12: getstatic       cg.ab:[B
        //    15: ifnonnull       95
        //    18: getstatic       bs.Code:Lbs;
        //    21: ldc_w           "mo"
        //    24: invokevirtual   bs.Code:(Ljava/lang/String;)Z
        //    27: ifne            33
        //    30: aload_3        
        //    31: monitorexit    
        //    32: return         
        //    33: getstatic       bs.Code:Lbs;
        //    36: ldc_w           "mo"
        //    39: iconst_1       
        //    40: invokevirtual   bs.Code:(Ljava/lang/String;I)[B
        //    43: astore          4
        //    45: aload           4
        //    47: arraylength    
        //    48: iconst_1       
        //    49: if_icmpne       286
        //    52: aload           4
        //    54: iconst_0       
        //    55: baload         
        //    56: istore_0       
        //    57: iload_0        
        //    58: ifne            81
        //    61: invokestatic    cg.b:()V
        //    64: aload_3        
        //    65: monitorexit    
        //    66: return         
        //    67: astore          4
        //    69: aload_3        
        //    70: monitorexit    
        //    71: aload           4
        //    73: athrow         
        //    74: astore          4
        //    76: iconst_0       
        //    77: istore_0       
        //    78: goto            57
        //    81: iload_0        
        //    82: iconst_3       
        //    83: imul           
        //    84: newarray        B
        //    86: putstatic       cg.aa:[B
        //    89: iload_0        
        //    90: newarray        B
        //    92: putstatic       cg.ab:[B
        //    95: getstatic       cg.aa:[B
        //    98: ifnonnull       291
        //   101: getstatic       cg.Y:[B
        //   104: arraylength    
        //   105: newarray        B
        //   107: putstatic       cg.aa:[B
        //   110: getstatic       cg.Y:[B
        //   113: iconst_0       
        //   114: getstatic       cg.aa:[B
        //   117: iconst_0       
        //   118: getstatic       cg.Y:[B
        //   121: arraylength    
        //   122: invokestatic    java/lang/System.arraycopy:(Ljava/lang/Object;ILjava/lang/Object;II)V
        //   125: goto            291
        //   128: getstatic       cg.aa:[B
        //   131: arraylength    
        //   132: iconst_3       
        //   133: idiv           
        //   134: istore_1       
        //   135: iload_0        
        //   136: iload_1        
        //   137: if_icmpge       280
        //   140: iconst_0       
        //   141: istore_1       
        //   142: getstatic       bs.Code:Lbs;
        //   145: ldc_w           "mo"
        //   148: iload_0        
        //   149: iconst_2       
        //   150: iadd           
        //   151: invokevirtual   bs.Code:(Ljava/lang/String;I)[B
        //   154: astore          4
        //   156: aload           4
        //   158: iconst_0       
        //   159: baload         
        //   160: iconst_1       
        //   161: if_icmpeq       170
        //   164: invokestatic    cg.b:()V
        //   167: aload_3        
        //   168: monitorexit    
        //   169: return         
        //   170: aload           4
        //   172: iconst_1       
        //   173: baload         
        //   174: bipush          16
        //   176: if_icmpeq       185
        //   179: invokestatic    cg.b:()V
        //   182: aload_3        
        //   183: monitorexit    
        //   184: return         
        //   185: getstatic       cg.aa:[B
        //   188: iload_0        
        //   189: iconst_3       
        //   190: imul           
        //   191: aload           4
        //   193: iconst_2       
        //   194: baload         
        //   195: bastore        
        //   196: getstatic       cg.aa:[B
        //   199: iload_0        
        //   200: iconst_3       
        //   201: imul           
        //   202: iconst_1       
        //   203: iadd           
        //   204: aload           4
        //   206: iconst_3       
        //   207: baload         
        //   208: bastore        
        //   209: getstatic       cg.aa:[B
        //   212: iload_0        
        //   213: iconst_3       
        //   214: imul           
        //   215: iconst_2       
        //   216: iadd           
        //   217: aload           4
        //   219: iconst_4       
        //   220: baload         
        //   221: bastore        
        //   222: getstatic       cg.ab:[B
        //   225: iload_0        
        //   226: aload           4
        //   228: iconst_5       
        //   229: baload         
        //   230: bastore        
        //   231: iload_0        
        //   232: iconst_1       
        //   233: iadd           
        //   234: istore_0       
        //   235: goto            128
        //   238: astore          4
        //   240: iload_1        
        //   241: getstatic       u.b:I
        //   244: if_icmpge       271
        //   247: getstatic       u.I:Lu;
        //   250: astore          4
        //   252: iload_1        
        //   253: ifle            296
        //   256: iconst_1       
        //   257: istore_2       
        //   258: aload           4
        //   260: iload_2        
        //   261: invokevirtual   u.Code:(Z)V
        //   264: iload_1        
        //   265: iconst_1       
        //   266: iadd           
        //   267: istore_1       
        //   268: goto            142
        //   271: invokestatic    cg.C:()V
        //   274: invokestatic    cg.b:()V
        //   277: aload_3        
        //   278: monitorexit    
        //   279: return         
        //   280: invokestatic    cg.d:()V
        //   283: aload_3        
        //   284: monitorexit    
        //   285: return         
        //   286: iconst_0       
        //   287: istore_0       
        //   288: goto            57
        //   291: iconst_0       
        //   292: istore_0       
        //   293: goto            128
        //   296: iconst_0       
        //   297: istore_2       
        //   298: goto            258
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      18     67     74     Any
        //  18     32     67     74     Any
        //  33     52     74     81     Ljava/lang/Throwable;
        //  33     52     67     74     Any
        //  61     66     67     74     Any
        //  81     95     67     74     Any
        //  95     125    67     74     Any
        //  128    135    67     74     Any
        //  142    156    238    280    Ljava/lang/Throwable;
        //  142    156    67     74     Any
        //  164    167    238    280    Ljava/lang/Throwable;
        //  164    167    67     74     Any
        //  167    169    67     74     Any
        //  179    182    238    280    Ljava/lang/Throwable;
        //  179    182    67     74     Any
        //  182    184    67     74     Any
        //  185    231    238    280    Ljava/lang/Throwable;
        //  185    231    67     74     Any
        //  240    252    67     74     Any
        //  258    264    67     74     Any
        //  271    279    67     74     Any
        //  280    285    67     74     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0033:
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
    
    public static void a(final String s) {
    Label_0216_Outer:
        while (true) {
            boolean b = true;
            while (true) {
            Label_0277:
                while (true) {
                    Label_0272: {
                        try {
                            final ak ak = new ak();
                            final DataOutputStream dataOutputStream = new DataOutputStream(ak);
                            if ("mc".equals(s)) {
                                dataOutputStream.write(1);
                                dataOutputStream.writeUTF(B(1));
                                dataOutputStream.writeBoolean(false);
                            }
                            else if ("md".equals(s)) {
                                while (true) {
                                    dataOutputStream.write(8);
                                    final byte[] array = new byte[32];
                                    Object o = cg.aj;
                                    while (true) {
                                        synchronized (o) {
                                            cg.aj.Code(array);
                                            cg.aj.Code(array, 0, 32);
                                            monitorexit(o);
                                            dataOutputStream.write(array);
                                            if (cg.E < 160) {
                                                break Label_0272;
                                            }
                                            dataOutputStream.writeBoolean(b);
                                            bx.Code(dataOutputStream);
                                            dataOutputStream.writeBoolean(cg.N);
                                            dataOutputStream.writeInt(0);
                                            dataOutputStream.writeInt(cg.t);
                                            dataOutputStream.writeShort(cg.ag);
                                            dataOutputStream.writeShort(cg.ah);
                                            u.Code.Code(dataOutputStream);
                                            dataOutputStream.writeInt(cg.O);
                                            if (cg.P == null) {
                                                break Label_0277;
                                            }
                                            o = cg.P;
                                            dataOutputStream.writeUTF((String)o);
                                            dataOutputStream.writeByte(cg.W);
                                            if (cg.D && cg.K[3] != null) {
                                                o = cg.K[3];
                                                dataOutputStream.writeUTF((String)o);
                                                break;
                                            }
                                        }
                                        o = "";
                                        continue;
                                    }
                                }
                            }
                            final byte[] byteArray = ak.toByteArray();
                            bs.Code.Z(s);
                            bs.Code.Code(s, byteArray);
                            return;
                        }
                        catch (Throwable t) {
                            return;
                        }
                    }
                    b = false;
                    continue Label_0216_Outer;
                }
                Object o = "";
                continue;
            }
        }
    }
    
    private static boolean a(final char c) {
        return ('\ufb50' <= c && c <= '\ufdff') || ('\ufe70' <= c && c <= '\ufefe');
    }
    
    public static void b() {
        synchronized (cg.X) {
            cg.Y = null;
            cg.aa = null;
            cg.ab = null;
            bs.Code.Z("mo");
        }
    }
    
    static void b(int i) {
        if (cg.aq == null || cg.aq.length < i * 2) {
            cg.aq = null;
            cg.aq = new int[new int[i * 2].length];
            final Random random = new Random(4711L);
            for (i = 0; i < cg.aq.length >> 1; ++i) {
                cg.aq[i] = (random.nextInt() & 0x7F);
                cg.aq[(cg.aq.length >> 1) + i] = cg.aq[i] + 64;
            }
        }
    }
    
    public static void b(String s) {
        try {
            final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bs.Code.I(s)));
            if ("mc".equals(s)) {
                if (dataInputStream.readByte() == 1) {
                    s = dataInputStream.readUTF();
                    if (s.length() >= 64) {
                        Code(1, s, false);
                    }
                    cg.ai = dataInputStream.readBoolean();
                }
            }
            else if ("md".equals(s)) {
                final byte byte1 = dataInputStream.readByte();
                if (byte1 <= 8) {
                    try {
                        Code(dataInputStream, 8);
                        if (byte1 >= 8) {
                            cg.ai = dataInputStream.readBoolean();
                        }
                        if (cg.ai) {
                            cg.E = 160;
                        }
                        bx.Code(dataInputStream, byte1);
                        cg.N = dataInputStream.readBoolean();
                        dataInputStream.readInt();
                        cg.t = dataInputStream.readInt();
                        if (byte1 >= 5) {
                            cg.ag = dataInputStream.readShort();
                            cg.ah = dataInputStream.readShort();
                        }
                        u.Code.Code(dataInputStream, byte1);
                        cg.O = dataInputStream.readInt();
                        cg.P = dataInputStream.readUTF();
                        cg.W = (byte)(dataInputStream.readByte() & 0x3);
                        s = dataInputStream.readUTF();
                        if (!s.equals("")) {
                            Code(3, s, false);
                        }
                    }
                    catch (IOException ex) {}
                }
            }
        }
        catch (Throwable t) {}
    }
    
    private static boolean b(final char c) {
        return ('\ufc00' & c) == 0xDC00;
    }
    
    public static int c() {
    Label_0115_Outer:
        while (true) {
        Label_0115:
            while (true) {
                int n3 = 0;
            Label_0163:
                while (true) {
                    int n = 0;
                    Label_0156: {
                        Label_0149: {
                            Label_0146: {
                                Label_0143: {
                                    synchronized (cg.X) {
                                        if (cg.ab == null) {
                                            break Label_0149;
                                        }
                                        final byte[] array = new byte[6];
                                        final byte[] array2 = new byte[cg.ab.length];
                                        n = 0;
                                        int n2 = 0;
                                        if (n >= cg.ab.length) {
                                            break Label_0146;
                                        }
                                        if ((cg.ab[n] & 0x1) == 0x0) {
                                            break Label_0143;
                                        }
                                        n3 = n2 + 1;
                                        array2[n2] = cg.Y[n * 3];
                                        cg.Y[n * 3 + 1] = 0;
                                        cg.Y[n * 3 + 2] = 0;
                                        Code(array, cg.Y[n * 3], 0, cg.ab[n]);
                                        if (Code(n, array)) {
                                            n2 = n3;
                                            break Label_0156;
                                        }
                                        break Label_0163;
                                        d();
                                        monitorexit(cg.X);
                                        iftrue(Label_0141:)(n2 <= 0);
                                        return u.Z.I(array2, 0, n2);
                                    }
                                    break;
                                }
                                break Label_0156;
                            }
                            continue Label_0115;
                        }
                        final byte[] array2 = null;
                        int n2 = 0;
                        continue Label_0115;
                    }
                    ++n;
                    continue Label_0115_Outer;
                }
                int n2 = n3;
                continue Label_0115;
            }
        }
        Label_0141: {
            return 0;
        }
    }
    
    public static String c(final String s) {
        StringBuffer sb = null;
        int n;
        StringBuffer sb2;
        for (int i = 0; i < s.length(); i = n + 1, sb = sb2) {
            final char char1 = s.charAt(i);
            n = i;
            sb2 = sb;
            if ('\ufe80' <= char1) {
                n = i;
                sb2 = sb;
                if (char1 <= '\ufefc') {
                    if ((sb2 = sb) == null) {
                        sb2 = new StringBuffer(s);
                    }
                    if (char1 < '\ufef5') {
                        sb2.setCharAt(i, (char)((cg.ay[char1 - '\ufe80'] & 0xFF) + 1536));
                        n = i;
                    }
                    else {
                        sb2.setCharAt(i, '\u0644');
                        n = i + 1;
                        sb2.insert(n, (char)((cg.ax[char1 - '\ufef5'] & 0xFF) + 1536));
                    }
                }
            }
        }
        if (sb == null) {
            return s;
        }
        return sb.toString();
    }
    
    private static byte[] c(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: iload_0        
        //     4: iand           
        //     5: ifne            51
        //     8: new             Ljava/io/DataInputStream;
        //    11: dup            
        //    12: ldc_w           "/t"
        //    15: invokestatic    cg.B:(Ljava/lang/String;)Ljava/io/InputStream;
        //    18: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    21: astore_3       
        //    22: aload_3        
        //    23: astore_1       
        //    24: aload_3        
        //    25: astore_2       
        //    26: iload_0        
        //    27: aload_3        
        //    28: invokestatic    cg.Code:(ILjava/io/DataInputStream;)I
        //    31: istore_0       
        //    32: aload_3        
        //    33: astore_1       
        //    34: iload_0        
        //    35: newarray        B
        //    37: astore_2       
        //    38: aload_1        
        //    39: aload_2        
        //    40: iconst_0       
        //    41: iload_0        
        //    42: invokevirtual   java/io/DataInputStream.readFully:([BII)V
        //    45: aload_1        
        //    46: invokevirtual   java/io/InputStream.close:()V
        //    49: aload_2        
        //    50: areturn        
        //    51: iload_0        
        //    52: invokestatic    ab.Code:(I)Lab;
        //    55: astore          4
        //    57: new             Ljava/io/DataInputStream;
        //    60: dup            
        //    61: aload           4
        //    63: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    66: astore_3       
        //    67: aload_3        
        //    68: astore_1       
        //    69: aload_3        
        //    70: astore_2       
        //    71: aload           4
        //    73: invokevirtual   ab.Code:()I
        //    76: istore_0       
        //    77: aload_3        
        //    78: astore_1       
        //    79: goto            34
        //    82: astore_1       
        //    83: aconst_null    
        //    84: astore_2       
        //    85: aload_2        
        //    86: invokevirtual   java/io/InputStream.close:()V
        //    89: aconst_null    
        //    90: areturn        
        //    91: astore_1       
        //    92: aconst_null    
        //    93: areturn        
        //    94: astore_2       
        //    95: aconst_null    
        //    96: astore_1       
        //    97: aload_1        
        //    98: invokevirtual   java/io/InputStream.close:()V
        //   101: aload_2        
        //   102: athrow         
        //   103: astore_1       
        //   104: goto            49
        //   107: astore_1       
        //   108: goto            101
        //   111: astore_2       
        //   112: goto            97
        //   115: astore_2       
        //   116: goto            97
        //   119: astore_1       
        //   120: goto            85
        //   123: astore_2       
        //   124: aload_1        
        //   125: astore_2       
        //   126: goto            85
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  8      22     82     85     Ljava/lang/Exception;
        //  8      22     94     97     Any
        //  26     32     119    123    Ljava/lang/Exception;
        //  26     32     111    115    Any
        //  34     45     123    129    Ljava/lang/Exception;
        //  34     45     115    119    Any
        //  45     49     103    107    Ljava/lang/Throwable;
        //  51     67     82     85     Ljava/lang/Exception;
        //  51     67     94     97     Any
        //  71     77     119    123    Ljava/lang/Exception;
        //  71     77     111    115    Any
        //  85     89     91     94     Ljava/lang/Throwable;
        //  97     101    107    111    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 81, Size: 81
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //     at java.util.ArrayList.get(ArrayList.java:435)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3379)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
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
    
    private static int d(final int n) {
        if (cg.ae[n].J() > 0) {
            return cg.ae[n].J();
        }
        return cg.ae[n].I() - cg.ae[n].Z();
    }
    
    public static String d(final String s) {
        String substring = s;
        if (s != null) {
            substring = s;
            if (s.startsWith("http://")) {
                substring = s;
                if (s.indexOf("&url=rtsp://") >= 0) {
                    substring = s.substring(s.indexOf("rtsp://"));
                }
            }
        }
        return substring;
    }
    
    public static void d() {
        synchronized (cg.X) {
            if (cg.aa != null) {
                cg.Y = cg.aa;
                cg.aa = null;
            }
        }
    }
    
    static String e() {
        final int i = i();
        final int j = j();
        if (i != -1 && j != -1) {
            String s;
            for (s = Integer.toString(j); s.length() < 3; s = "0" + s) {}
            return Integer.toString(i) + "-" + s;
        }
        return null;
    }
    
    public static Object[] e(String s) {
        for (s = s.toLowerCase(); s.startsWith("<"); s = s.substring(s.indexOf(62) + 1)) {}
        final int index = s.indexOf(58);
        while (true) {
            Label_0110: {
                if (index == -1) {
                    break Label_0110;
                }
                final String substring = s.substring(0, index);
                if (substring.indexOf(46) != -1) {
                    break Label_0110;
                }
                s = s.substring(index + 1);
                String s2;
                Integer n;
                if (!cg.aB.containsKey(substring)) {
                    s2 = "";
                    n = cg.aC;
                }
                else {
                    String substring2 = s;
                    if (s.startsWith("//")) {
                        substring2 = s.substring(2);
                    }
                    final int index2 = substring2.indexOf(63);
                    s = substring2;
                    if (index2 != -1) {
                        s = substring2.substring(0, index2);
                    }
                    final int index3 = s.indexOf(47);
                    String substring3;
                    if (index3 != -1) {
                        substring3 = s.substring(0, index3);
                        s = s.substring(index3);
                    }
                    else {
                        final String s3 = "";
                        substring3 = s;
                        s = s3;
                    }
                    final int index4 = substring3.indexOf(64);
                    s2 = substring3;
                    if (index4 != -1) {
                        s2 = substring3.substring(index4 + 1);
                    }
                    if (s2.startsWith("www.")) {
                        s2 = s2.substring(4);
                    }
                    final int index5 = s2.indexOf(58);
                    if (index5 != -1) {
                        n = Integer.valueOf(s2.substring(index5 + 1));
                        s2 = s2.substring(0, index5);
                    }
                    else {
                        n = cg.aB.get(substring);
                    }
                }
                return new Object[] { substring, s2, n, s };
            }
            final String substring = "http";
            continue;
        }
    }
    
    static int f() {
        return cg.az;
    }
    
    static int g() {
        return cg.aA;
    }
    
    static String h() {
        return "Opera Mini/7.6.40234/hifi/" + u.Code.U() + "/" + ac.Code();
    }
    
    private static int i() {
        final int m = u.Code.M();
        if (m != cg.ag && m != -1) {
            cg.ag = m;
            a("md");
        }
        return cg.ag;
    }
    
    private static int j() {
        final int n = u.Code.N();
        if (n != cg.ah && n != -1) {
            cg.ah = n;
            a("md");
        }
        return cg.ah;
    }
    
    private static void k() {
        while (true) {
            int n = 0;
        Label_0153_Outer:
            while (true) {
                Label_0177: {
                    String b = null;
                    int code = 0;
                    while (true) {
                        String s = null;
                        Label_0160: {
                            Object o2;
                            synchronized (cg.class) {
                                final ak ak = new ak(32);
                                final int n2 = 0;
                                final int n3 = 0;
                                final Object o = null;
                                if (n >= cg.ac) {
                                    if (o != null) {
                                        Code(ak, n2, cg.ac - n2, n3, (String)o);
                                    }
                                    cg.G = ak.toByteArray();
                                    return;
                                }
                                o2 = o;
                                if (!u.Code.a(n)) {
                                    o2 = cg.ae[n];
                                    b = ((au)o2).B();
                                    code = Code((au)o2);
                                    if ((s = (String)o) != null) {
                                        if (((String)o).equals(b)) {
                                            s = (String)o;
                                            if (code == n3) {
                                                break Label_0160;
                                            }
                                        }
                                        Code(ak, n2, n - n2, n3, (String)o);
                                        s = null;
                                    }
                                    break Label_0160;
                                }
                            }
                            final Object o = o2;
                            break Label_0177;
                        }
                        Object o2;
                        if ((o2 = s) != null) {
                            continue;
                        }
                        break;
                    }
                    final int n2 = n;
                    final Object o = b;
                    final int n3 = code;
                }
                ++n;
                continue Label_0153_Outer;
            }
        }
    }
}
