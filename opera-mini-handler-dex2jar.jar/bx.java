import java.io.InputStream;
import java.io.OutputStream;
import com.opera.mini.android.b$2;
import java.util.Enumeration;
import java.io.IOException;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.util.Vector;
import java.util.Hashtable;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class bx implements Runnable
{
    protected static byte Code;
    private static boolean W;
    private static final Object X;
    private static int Y;
    static Hashtable Z;
    private static boolean aa;
    private static Vector ae;
    private static au af;
    static boolean b;
    private static byte f;
    private static String g;
    private static int h;
    private static int j;
    private static boolean k;
    private static boolean l;
    private static boolean m;
    private static boolean n;
    private static int o;
    private static byte p;
    private static String q;
    private static String r;
    private static by y;
    private long A;
    ax B;
    bq C;
    private long D;
    private int E;
    private final boolean F;
    private bd G;
    private bd H;
    byte[] I;
    ax J;
    private byte[] K;
    private Object[] L;
    private int[] M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private ah R;
    private aj S;
    private Object[] T;
    private int U;
    private int V;
    bq a;
    private final int ab;
    private boolean ac;
    private final boolean ad;
    private String[] c;
    private bu d;
    private byte e;
    private int i;
    private boolean s;
    private Vector t;
    private DataInputStream u;
    private DataOutputStream v;
    private DataInputStream w;
    private DataOutputStream x;
    private long z;
    
    static {
        bx.f = -1;
        bx.g = null;
        bx.j = 0;
        bx.k = false;
        bx.n = true;
        bx.o = 0;
        bx.Code = -1;
        bx.p = -1;
        bx.q = "";
        bx.r = "";
        bx.Z = new Hashtable();
        bx.W = false;
        X = new Object();
        bx.Y = -1;
        bx.ae = new Vector(2);
        bx.af = null;
    }
    
    public bx(final int ab, byte e, final boolean b, final boolean ad) {
        final boolean b2 = true;
        this.i = 0;
        this.t = new Vector();
        this.I = new byte[1024];
        this.L = new Object[127];
        this.M = new int[127];
        this.ac = false;
        this.ab = ab;
        this.ad = ad;
        if (b) {
            this.d = ce.I(ab);
            this.ac = true;
        }
        else {
            this.d = ce.Code(ab);
        }
        final boolean l = u.Code.L();
        int n;
        if (l) {
            n = 3;
        }
        else {
            n = 2;
        }
        this.c = new String[n];
        if (!this.d.I()) {
            this.c[0] = "socket://" + this.d.Z + ":" + this.d.B;
        }
        else {
            this.c[0] = "socket://do_not_use_me:0";
        }
        if (l) {
            this.c[1] = "http://10.0.0.172:80/";
        }
        this.c[this.c.length - 1] = this.d();
        int n2;
        if (this.c.length != bx.h) {
            bx.h = this.c.length;
            J();
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        final String z = this.d.Z();
        final Object[] t = bx.Z.get(z);
        if (t != null) {
            this.T = t;
            this.S = (aj)t[0];
        }
        else {
            this.S = new aj(cg.Code(cg.J(this.d.C), 0, 160));
            (this.T = new Object[2])[0] = this.S;
            this.T[1] = "";
            bx.Z.put(z, this.T);
            n2 = 1;
        }
        if (n2 != 0) {
            cg.a("md");
        }
        if (e == -1) {
            if (bx.Code >= 0 && !this.d.I()) {
                e = bx.Code;
            }
            else if (bx.p >= 0) {
                e = bx.p;
            }
            else {
                e = 1;
            }
        }
        this.e = e;
        this.F = (cg.E >= 160 && b2);
        if (bx.ae.size() <= ab) {
            bx.ae.setSize(ab + 1);
        }
        if (ad) {
            bx.ae.setElementAt(this, ab);
        }
        cg.Code(this);
    }
    
    private void B(final by p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ifnonnull       5
        //     4: return         
        //     5: aload_1        
        //     6: iconst_1       
        //     7: invokevirtual   by.Code:(Z)Ljava/util/Hashtable;
        //    10: astore          8
        //    12: aload           8
        //    14: ifnull          4
        //    17: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //    20: invokevirtual   java/lang/Thread.getPriority:()I
        //    23: istore_3       
        //    24: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //    27: iconst_1       
        //    28: invokevirtual   java/lang/Thread.setPriority:(I)V
        //    31: new             Lak;
        //    34: dup            
        //    35: sipush          4104
        //    38: invokespecial   ak.<init>:(I)V
        //    41: astore          9
        //    43: new             Ljava/io/DataOutputStream;
        //    46: dup            
        //    47: aload           9
        //    49: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    52: astore          10
        //    54: aload           9
        //    56: bipush          22
        //    58: aload_1        
        //    59: invokevirtual   by.C:()I
        //    62: bipush          7
        //    64: invokestatic    bx.Code:(Lak;III)V
        //    67: aload           10
        //    69: iconst_1       
        //    70: invokevirtual   java/io/DataOutputStream.write:(I)V
        //    73: aload           10
        //    75: bipush          9
        //    77: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    80: aload           10
        //    82: aload           8
        //    84: invokestatic    bx.Code:(Ljava/util/Hashtable;)I
        //    87: bipush          7
        //    89: isub           
        //    90: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //    93: aload_0        
        //    94: aload           9
        //    96: invokevirtual   ak.Code:()[B
        //    99: iconst_0       
        //   100: bipush          15
        //   102: invokespecial   bx.Code:([BII)V
        //   105: aload_0        
        //   106: aload           9
        //   108: invokevirtual   ak.Code:()[B
        //   111: bipush          15
        //   113: invokespecial   bx.Code:([BI)V
        //   116: aload           9
        //   118: iconst_0       
        //   119: invokevirtual   ak.Code:(I)V
        //   122: aconst_null    
        //   123: astore          6
        //   125: aload           8
        //   127: invokevirtual   java/util/Hashtable.keys:()Ljava/util/Enumeration;
        //   130: astore          11
        //   132: aconst_null    
        //   133: astore          6
        //   135: aload           11
        //   137: invokeinterface java/util/Enumeration.hasMoreElements:()Z
        //   142: ifeq            437
        //   145: aload           11
        //   147: invokeinterface java/util/Enumeration.nextElement:()Ljava/lang/Object;
        //   152: checkcast       Ljava/lang/String;
        //   155: astore          7
        //   157: aload           8
        //   159: aload           7
        //   161: invokevirtual   java/util/Hashtable.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   164: checkcast       [Ljava/lang/Object;
        //   167: astore          12
        //   169: aload           7
        //   171: invokestatic    r.Code:(Ljava/lang/String;)I
        //   174: istore_2       
        //   175: aload           12
        //   177: iconst_0       
        //   178: aaload         
        //   179: checkcast       Ljava/lang/String;
        //   182: invokestatic    r.Code:(Ljava/lang/String;)I
        //   185: iload_2        
        //   186: iadd           
        //   187: bipush          8
        //   189: iadd           
        //   190: istore_2       
        //   191: aload           9
        //   193: bipush          22
        //   195: aload_1        
        //   196: invokevirtual   by.C:()I
        //   199: iload_2        
        //   200: invokestatic    bx.Code:(Lak;III)V
        //   203: aload           10
        //   205: aload           7
        //   207: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   210: aload           10
        //   212: aload           12
        //   214: iconst_0       
        //   215: aaload         
        //   216: checkcast       Ljava/lang/String;
        //   219: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   222: aload           12
        //   224: iconst_1       
        //   225: aaload         
        //   226: checkcast       Ljava/lang/Integer;
        //   229: invokevirtual   java/lang/Integer.intValue:()I
        //   232: istore          4
        //   234: aload           10
        //   236: iload           4
        //   238: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   241: aload_0        
        //   242: aload           9
        //   244: invokevirtual   ak.Code:()[B
        //   247: iconst_0       
        //   248: iload_2        
        //   249: bipush          8
        //   251: iadd           
        //   252: invokespecial   bx.Code:([BII)V
        //   255: aload_0        
        //   256: aload           9
        //   258: invokevirtual   ak.Code:()[B
        //   261: iload_2        
        //   262: bipush          8
        //   264: iadd           
        //   265: invokespecial   bx.Code:([BI)V
        //   268: aload           9
        //   270: iconst_0       
        //   271: invokevirtual   ak.Code:(I)V
        //   274: getstatic       u.c:Lap;
        //   277: aload           12
        //   279: iconst_0       
        //   280: aaload         
        //   281: checkcast       Ljava/lang/String;
        //   284: iconst_0       
        //   285: iconst_1       
        //   286: invokevirtual   ap.Code:(Ljava/lang/String;ZI)Lar;
        //   289: invokeinterface ar.Code:()Ljava/io/InputStream;
        //   294: astore          7
        //   296: aload           7
        //   298: astore          6
        //   300: aload           9
        //   302: invokevirtual   ak.Code:()[B
        //   305: astore          12
        //   307: iconst_0       
        //   308: istore_2       
        //   309: aload           7
        //   311: astore          6
        //   313: aload_1        
        //   314: invokevirtual   by.k:()Z
        //   317: ifne            421
        //   320: aload           7
        //   322: astore          6
        //   324: aload           7
        //   326: aload           12
        //   328: bipush          8
        //   330: sipush          4096
        //   333: invokevirtual   java/io/InputStream.read:([BII)I
        //   336: istore          5
        //   338: iload           5
        //   340: iflt            421
        //   343: iload_2        
        //   344: iload           4
        //   346: if_icmpge       421
        //   349: iload_2        
        //   350: iload           5
        //   352: iadd           
        //   353: istore_2       
        //   354: aload           7
        //   356: astore          6
        //   358: aload           12
        //   360: iconst_0       
        //   361: bipush          22
        //   363: aload_1        
        //   364: invokevirtual   by.C:()I
        //   367: iload           5
        //   369: invokestatic    bx.Code:([BIIII)V
        //   372: aload           7
        //   374: astore          6
        //   376: aload_0        
        //   377: aload           12
        //   379: iconst_0       
        //   380: iload           5
        //   382: bipush          8
        //   384: iadd           
        //   385: invokespecial   bx.Code:([BII)V
        //   388: aload           7
        //   390: astore          6
        //   392: aload_0        
        //   393: aload           12
        //   395: iload           5
        //   397: bipush          8
        //   399: iadd           
        //   400: invokespecial   bx.Code:([BI)V
        //   403: goto            309
        //   406: astore_1       
        //   407: aload           6
        //   409: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   412: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   415: iload_3        
        //   416: invokevirtual   java/lang/Thread.setPriority:(I)V
        //   419: aload_1        
        //   420: athrow         
        //   421: aload           7
        //   423: astore          6
        //   425: aload           7
        //   427: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   430: aload           7
        //   432: astore          6
        //   434: goto            135
        //   437: aload           6
        //   439: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   442: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
        //   445: iload_3        
        //   446: invokevirtual   java/lang/Thread.setPriority:(I)V
        //   449: return         
        //   450: astore_1       
        //   451: goto            407
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  125    132    406    407    Any
        //  135    296    450    454    Any
        //  300    307    406    407    Any
        //  313    320    406    407    Any
        //  324    338    406    407    Any
        //  358    372    406    407    Any
        //  376    388    406    407    Any
        //  392    403    406    407    Any
        //  425    430    406    407    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0135:
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
    
    private boolean B(final int n) {
        int n2 = 0;
        by by;
        int n3;
        Block_11_Outer:Label_0049_Outer:Label_0190_Outer:
        while (true) {
            while (true) {
                Label_0202: {
                    while (true) {
                        Label_0195: {
                            Label_0188: {
                                synchronized (bx.X) {
                                    if (bx.ae.elementAt(this.ab) == this) {
                                        bx.ae.setElementAt(null, this.ab);
                                    }
                                    if (!bx.n && !this.s) {
                                        break Label_0202;
                                    }
                                    break Label_0188;
                                    while (true) {
                                    Label_0101:
                                        while (true) {
                                            by = this.t.elementAt(n2);
                                            iftrue(Label_0123:)(by.k() || by.g() || (n3 == 0 && by.h()));
                                            break Label_0101;
                                            Label_0123: {
                                                by.I(n);
                                            }
                                            break Label_0195;
                                            by.i();
                                            Label_0110:
                                            by.J();
                                            I(by);
                                            break Label_0195;
                                            iftrue(Label_0140:)(n2 >= this.t.size());
                                            continue Block_11_Outer;
                                        }
                                        iftrue(Label_0110:)(n3 != 0);
                                        continue Label_0049_Outer;
                                    }
                                }
                                break;
                            }
                            n3 = 1;
                            n2 = 0;
                            continue Label_0190_Outer;
                        }
                        ++n2;
                        continue Label_0190_Outer;
                    }
                }
                n3 = 0;
                continue;
            }
        }
        Label_0140: {
            this.t.removeAllElements();
        }
        final Object o;
        if (!this.P) {
            this.P = true;
            this.v = null;
            this.u = null;
            f();
            cg.Code(bx.X);
            monitorexit(o);
            return true;
        }
        monitorexit(o);
        return false;
    }
    
    public static void C() {
        if (!bx.n) {
            J();
        }
        throw new IOException();
    }
    
    private void C(final int e) {
        synchronized (this) {
            this.D = System.currentTimeMillis();
            this.E = e;
        }
    }
    
    private boolean C(by string) {
        if (this.I[0] != 72 || this.I[1] != 84 || this.I[2] != 84 || this.I[3] != 80) {
            return false;
        }
        this.Code(5, 7);
        if (this.d.Code() && this.I[8] == 32 && this.I[9] == 51 && this.I[10] == 48 && (this.I[11] == 49 || this.I[11] == 50 || this.I[11] == 51 || this.I[11] == 55)) {
            this.i = 1;
            String code;
            while (true) {
                try {
                    code = this.Code("location");
                    if (code == null || code.length() == 0) {
                        return false;
                    }
                }
                catch (Throwable t) {
                    code = null;
                    continue;
                }
                break;
            }
            Label_0272: {
                if (string != null) {
                    if (!string.Code(code)) {
                        break Label_0272;
                    }
                    this.J(string);
                    f();
                }
                while (true) {
                    synchronized (bx.X) {
                        for (by by = bx.y; by != null; by = by.B()) {
                            if (by.Code() == this.ab && !by.k() && by != string) {
                                if (by.Code(code)) {
                                    f();
                                }
                                else {
                                    by.close();
                                }
                            }
                        }
                        break;
                        string.close();
                        continue;
                    }
                    break;
                }
            }
            final Object o;
            monitorexit(o);
            this.Code(false, 0);
            return true;
        }
        if (this.I[8] != 32 || this.I[9] != 52 || this.I[10] != 48 || this.I[11] != 51) {
            return false;
        }
        this.i = 2;
        string = (by)new StringBuffer();
        while (true) {
            try {
                this.Code((String)null);
                int n = 0;
                while (true) {
                    final int n2 = n + 1;
                    if (n2 > 256) {
                        break;
                    }
                    this.Code(0, 1);
                    if (this.I[0] <= 32) {
                        break;
                    }
                    ((StringBuffer)string).append((char)this.I[0]);
                    if ((n = n2) != 4) {
                        continue;
                    }
                    n = n2;
                    if (!((StringBuffer)string).toString().toLowerCase().equals("http")) {
                        ((StringBuffer)string).setLength(0);
                        break;
                    }
                }
                if (((StringBuffer)string).length() > 4) {
                    string = (by)((StringBuffer)string).toString();
                }
                else {
                    string = null;
                }
                bx.g = (String)string;
                this.Code(false, 4);
                return true;
            }
            catch (Throwable t2) {
                continue;
            }
            break;
        }
    }
    
    private static int Code(final Hashtable hashtable) {
        int n;
        if (hashtable == null) {
            n = 0;
        }
        else {
            final Enumeration keys = hashtable.keys();
            int n2 = 7;
            while (true) {
                n = n2;
                if (!keys.hasMoreElements()) {
                    break;
                }
                final String s = (String)keys.nextElement();
                final Object[] array = hashtable.get(s);
                n2 = (int)array[1] + 4 + (n2 + (q.Code(s) + 2) + (q.Code((String)array[0]) + 2));
            }
        }
        return n;
    }
    
    static by Code(final Object[] array, final int[] array2, final int n, final boolean b) {
        final by by = new by(array, array2, n, b);
        I(by);
        f();
        return by;
    }
    
    private String Code(final String s) {
        final StringBuffer sb = new StringBuffer();
        while (true) {
            this.Code(0, 1);
            if (this.I[0] == 13) {
                this.Code(0, 1);
            }
            if (this.I[0] == 10) {
                if (sb.length() == 0) {
                    if (s != null) {}
                    return null;
                }
                if (s != null) {
                    final String string = sb.toString();
                    final int index = string.indexOf(58);
                    if (index >= 0 && string.toLowerCase().startsWith(s)) {
                        return string.substring(index + 1).trim();
                    }
                }
                sb.setLength(0);
            }
            else {
                sb.append((char)this.I[0]);
            }
        }
    }
    
    private static String Code(final String s, String i) {
        String j = null;
        Label_0007: {
            if (s == null) {
                j = null;
            }
            else {
                final int length = s.length();
                final int index = s.indexOf(":/");
                final int index2 = s.indexOf(58);
                if (index >= 0) {
                    j = s;
                    if (index <= 10) {
                        break Label_0007;
                    }
                }
                if (index2 != -1 && index == -1) {
                    j = s;
                    if (index2 + 1 == length) {
                        break Label_0007;
                    }
                    final char char1 = s.charAt(index2 + 1);
                    j = s;
                    if (char1 < '0') {
                        break Label_0007;
                    }
                    j = s;
                    if (char1 > '9') {
                        break Label_0007;
                    }
                }
                j = b$2.j("http://" + s);
            }
        }
        if (j == null) {
            return "";
        }
        final int index3 = j.indexOf("https://");
        final int index4 = j.indexOf(47, index3 + 8);
        final StringBuffer sb = new StringBuffer(j);
        if (i != null && i.length() > 0 && index3 == -1) {
            i = I(i);
            sb.append('?').append(i);
        }
        if (index3 != -1 && index4 != -1) {
            sb.delete(index4, sb.length());
        }
        int k = sb.length() - 1;
        int n = 0;
        int n2 = 0;
        while (k >= 0) {
            final char char2 = sb.charAt(k);
            int n3;
            if (char2 < '!' || char2 > '~' || "\"#;<>[]^`{|}~\\".indexOf(char2) >= 0) {
                sb.deleteCharAt(k);
                n3 = n2;
            }
            else {
                int n4;
                if (char2 == '=') {
                    n4 = 1;
                }
                else if (char2 == '&') {
                    n2 = 0;
                    n4 = 0;
                }
                else {
                    n4 = n;
                    if (char2 == '.') {
                        n2 = 1;
                        n4 = n;
                    }
                }
                n3 = n2;
                n = n4;
                if (k > j.length()) {
                    n3 = n2;
                    if ((n = n4) != 0) {
                        n3 = n2;
                        n = n4;
                        if (n2 != 0) {
                            sb.deleteCharAt(k);
                            n3 = n2;
                            n = n4;
                        }
                    }
                }
            }
            --k;
            n2 = n3;
        }
        sb.setLength(127);
        if (sb.charAt(126) == '%') {
            sb.setLength(126);
        }
        else if (sb.charAt(125) == '%') {
            sb.setLength(125);
        }
        return sb.toString().trim();
    }
    
    private static void Code(final byte code, final String q) {
        bx.Code = code;
        bx.q = q;
    }
    
    public static void Code(final int j) {
        if (j != bx.j) {
            J(0);
            bx.j = j;
            bx.k = true;
        }
    }
    
    private void Code(final int n, final int n2) {
        this.u.readFully(this.I, n, n2);
        cg.Code(n2, 0L, 0L);
    }
    
    private static void Code(final ak ak, final int n, final int n2, final int n3) {
        ak.Code(ak.size() + 8);
        Code(ak.Code(), ak.size() - 8, n, n2, n3);
    }
    
    static void Code(final aw aw) {
        if (!bx.b) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        String s;
        if (bx.aa) {
            s = "*";
        }
        else {
            s = "";
        }
        final String string = sb.append(s).append(bx.Y).append(":").append(ao.Code()).toString();
        if (bx.af == null) {
            bx.af = u.Code.s().Code(64, 0);
        }
        aw.Code(string, (u.Code.J() - bx.af.Code(string)) / 2, 1, bx.af, 16777088);
    }
    
    static void Code(final by by, final boolean b) {
    Label_0115_Outer:
        while (true) {
            while (true) {
            Label_0172:
                while (true) {
                    int n = 0;
                    Label_0165: {
                        Label_0146: {
                            synchronized (bx.X) {
                                if (!by.k()) {
                                    by.I(0);
                                    final bx z = by.Z();
                                    if (z == null) {
                                        break Label_0146;
                                    }
                                    int g = z.g() ? 1 : 0;
                                    n = 0;
                                    if (g != 0 && n < z.t.size()) {
                                        final by by2 = z.t.elementAt(n);
                                        if (!by2.k() && by2.g()) {
                                            g = 0;
                                        }
                                        break Label_0165;
                                    }
                                    else if (g == 0 && z.B()) {
                                        z.Q = true;
                                        if (!b) {
                                            break Label_0172;
                                        }
                                        n = 7;
                                        by.Z(n);
                                        cg.Code(bx.X);
                                    }
                                    else {
                                        z.Code(false, 0);
                                    }
                                }
                                return;
                            }
                        }
                        if (bx.y != null) {
                            bx.y = bx.y.I(by);
                            return;
                        }
                        return;
                    }
                    ++n;
                    continue Label_0115_Outer;
                }
                int n = 6;
                continue;
            }
        }
    }
    
    private void Code(final by by, final byte[] array) {
        String substring = this.c[this.e];
        final int index = substring.indexOf(59);
        String substring2;
        if (index >= 0) {
            substring2 = substring.substring(index);
            substring = substring.substring(0, index);
        }
        else {
            substring2 = "";
        }
        bx.Y = this.ab;
        bx.aa = this.ac;
        if (!this.B()) {
            String s = "";
            String s2;
            if (by != null) {
                final Object[] a = by.a();
                s2 = (String)a[53];
                s = (String)a[42];
            }
            else {
                s2 = "server:test";
            }
            int n;
            if ((this.d.I & 0x2) != 0x0) {
                n = 1;
            }
            else {
                n = 0;
            }
            String string = substring;
        Label_0715_Outer:
            while (true) {
                Label_0284: {
                    if (n == 0) {
                        break Label_0284;
                    }
                    String s3 = Code(s2, s);
                    if (s2 != null && (s2.startsWith("b:") || s2.startsWith("javascript:"))) {
                        s3 = Code((String)by.a()[38], null);
                    }
                    else if ("".equals(s3)) {
                        if ((s3 = s2) == null) {
                            s3 = "internal";
                        }
                    }
                    string = substring + s3;
                }
                final ah code = u.Code.Code(string, substring2, "POST");
                this.R = code;
                if (string.startsWith("http://10.0.0.172")) {
                    final Object[] e = cg.e(this.d());
                    final String string2 = (String)e[1] + ":" + e[2];
                    if (string2 != null) {
                        code.Code("X-Online-Host", string2);
                    }
                }
                code.Code("Content-Type", "application/xml");
                this.v = code.I();
                this.x = this.v;
                this.Code(array, array.length);
                this.B(by);
                this.v.close();
                if (by != null) {
                    by.p();
                }
                this.v = null;
                this.u = code.Z();
                this.w = this.u;
                final int j = code.J();
                if (j == 301 || j == 302 || j == 303 || j == 307) {
                    this.i = 1;
                    if (by != null && this.d.Code()) {
                        final String code2 = code.Code("Location");
                        if (code2 != null && code2.length() > 0) {
                            if (by.Code(code2)) {
                                this.J(by);
                                f();
                            }
                            else {
                                by.close();
                            }
                        }
                    }
                    this.Z(false);
                    return;
                }
                if (j != 403) {
                    return;
                }
                this.i = 2;
                while (true) {
                    try {
                        final StringBuffer sb = new StringBuffer();
                        int n2 = 0;
                        while (true) {
                            final int read = this.u.read();
                            if (read <= 32) {
                                break;
                            }
                            final int n3 = n2 + 1;
                            if (n3 > 256) {
                                break;
                            }
                            sb.append((char)read);
                            if ((n2 = n3) != 4) {
                                continue Label_0715_Outer;
                            }
                            n2 = n3;
                            if (!sb.toString().toLowerCase().equals("http")) {
                                sb.setLength(0);
                                break;
                            }
                        }
                        String string3;
                        if (sb.length() > 0) {
                            string3 = sb.toString();
                        }
                        else {
                            string3 = null;
                        }
                        bx.g = string3;
                        this.Code(false, 4);
                        return;
                    }
                    catch (Throwable t) {
                        continue;
                    }
                    break;
                }
                continue;
            }
        }
        if (this.v == null) {
            final ah code3 = u.Code.Code(substring, substring2);
            this.R = code3;
            this.v = code3.I();
            this.x = this.v;
            this.u = code3.Z();
            this.w = this.u;
        }
        this.Code(array, array.length);
        if (by != null) {
            by.p();
        }
        this.B(by);
    }
    
    static void Code(final DataInputStream dataInputStream, int n) {
        final String s = null;
        final int n2 = 0;
        monitorenter(bx.class);
        Label_0099: {
            if (n > 5) {
                break Label_0099;
            }
            try {
                dataInputStream.readUTF();
                dataInputStream.readByte();
                dataInputStream.readByte();
                dataInputStream.readBoolean();
                dataInputStream.readBoolean();
                dataInputStream.readLong();
                dataInputStream.skip(8L);
                dataInputStream.skip(dataInputStream.readUnsignedByte());
                dataInputStream.skip(dataInputStream.readUnsignedShort() * 4);
                dataInputStream.skip(dataInputStream.readUnsignedShort() * 4);
                if (n >= 4) {
                    dataInputStream.readByte();
                }
                Label_0095: {
                    return;
                }
                while (true) {
                    Label_0368: {
                    Label_0235_Outer:
                        while (true) {
                            aj aj = null;
                            int unsignedByte = 0;
                            Block_10: {
                                while (true) {
                                    Block_8: {
                                        String utf;
                                        String utf2;
                                        String utf3;
                                        byte byte1;
                                        Label_0169_Outer:Block_9_Outer:
                                        while (true) {
                                            utf = null;
                                            while (true) {
                                                Label_0211: {
                                                Block_7_Outer:
                                                    while (true) {
                                                        while (true) {
                                                            Label_0194: {
                                                                while (true) {
                                                                    Label_0146: {
                                                                        break Label_0146;
                                                                        bx.q = utf2;
                                                                        bx.h = dataInputStream.readByte();
                                                                        iftrue(Label_0194:)(n < 7);
                                                                        bx.W = dataInputStream.readBoolean();
                                                                        break Label_0194;
                                                                        utf3 = dataInputStream.readUTF();
                                                                        aj = new aj(cg.Code(dataInputStream));
                                                                        aj.I = dataInputStream.readLong();
                                                                        dataInputStream.readFully(aj.a);
                                                                        unsignedByte = dataInputStream.readUnsignedByte();
                                                                        iftrue(Label_0319:)(unsignedByte == 0);
                                                                        break Block_10;
                                                                        while (true) {
                                                                            bx.Z.put(utf3, new Object[] { aj, "" });
                                                                            break Label_0368;
                                                                            ce.I();
                                                                            break Label_0211;
                                                                            utf2 = s;
                                                                            continue Block_9_Outer;
                                                                            aj.Z = cg.Code(dataInputStream);
                                                                            aj.J = cg.Code(dataInputStream);
                                                                            iftrue(Label_0368:)(aj.I());
                                                                            continue Block_7_Outer;
                                                                        }
                                                                    }
                                                                    bx.r = utf;
                                                                    utf2 = dataInputStream.readUTF();
                                                                    iftrue(Label_0375:)(utf2.length() != 0);
                                                                    continue Label_0235_Outer;
                                                                }
                                                            }
                                                            iftrue(Label_0211:)(dataInputStream.readInt() == "mini5.opera-mini.net".hashCode());
                                                            continue Label_0235_Outer;
                                                        }
                                                        Label_0375:
                                                        continue Block_9_Outer;
                                                    }
                                                }
                                                aj.e = true;
                                                iftrue(Label_0235:)(n < 8);
                                                break Block_8;
                                                byte1 = dataInputStream.readByte();
                                                n = n2;
                                                iftrue(Label_0095:)(n >= byte1);
                                                continue Label_0235_Outer;
                                            }
                                            bx.n = dataInputStream.readBoolean();
                                            dataInputStream.readByte();
                                            bx.Code = dataInputStream.readByte();
                                            bx.p = dataInputStream.readByte();
                                            iftrue(Label_0146:)((utf = dataInputStream.readUTF()).length() != 0);
                                            continue Label_0169_Outer;
                                        }
                                    }
                                    aj.e = dataInputStream.readBoolean();
                                    aj.d = dataInputStream.readLong();
                                    continue;
                                }
                            }
                            dataInputStream.readFully(aj.C = new byte[unsignedByte]);
                            aj.c = aj.C;
                            continue;
                        }
                    }
                    ++n;
                    continue;
                }
            }
            finally {
                monitorexit(bx.class);
            }
        }
    }
    
    static void Code(final DataOutputStream dataOutputStream) {
        Object o;
        Object o2 = null;
        Label_0052_Outer:Label_0112_Outer:
        while (true) {
            while (true) {
            Label_0229:
                while (true) {
                Label_0222:
                    while (true) {
                        synchronized (bx.class) {
                            dataOutputStream.writeBoolean(bx.n);
                            dataOutputStream.writeByte(-1);
                            dataOutputStream.writeByte(bx.Code);
                            dataOutputStream.writeByte(bx.p);
                            if (bx.r == null) {
                                o = "";
                                dataOutputStream.writeUTF((String)o);
                                if (bx.q == null) {
                                    o = "";
                                    dataOutputStream.writeUTF((String)o);
                                    dataOutputStream.writeByte(bx.h);
                                    dataOutputStream.writeBoolean(bx.W);
                                    dataOutputStream.writeInt("mini5.opera-mini.net".hashCode());
                                    dataOutputStream.writeBoolean(aj.e);
                                    dataOutputStream.writeLong(aj.d);
                                    dataOutputStream.writeByte(bx.Z.size());
                                    o = bx.Z.keys();
                                    while (((Enumeration)o).hasMoreElements()) {
                                        o2 = ((Enumeration)o).nextElement();
                                        dataOutputStream.writeUTF((String)o2);
                                        o2 = ((Object[])bx.Z.get(o2))[0];
                                        cg.Code(dataOutputStream, ((aj)o2).Code);
                                        dataOutputStream.writeLong(((aj)o2).I);
                                        dataOutputStream.write(((aj)o2).a);
                                        dataOutputStream.write(((aj)o2).C.length);
                                        dataOutputStream.write(((aj)o2).C);
                                        if (cg.K[1] != null) {
                                            break Label_0229;
                                        }
                                        dataOutputStream.writeInt(0);
                                    }
                                    break;
                                }
                                break Label_0222;
                            }
                        }
                        o = bx.r;
                        continue Label_0052_Outer;
                    }
                    o = bx.q;
                    continue Label_0112_Outer;
                }
                cg.Code(dataOutputStream, ((aj)o2).Z);
                cg.Code(dataOutputStream, ((aj)o2).J);
                continue;
            }
        }
        monitorexit(bx.class);
    }
    
    public static void Code(final boolean w) {
        synchronized (bx.X) {
            if (bx.W != w) {
                bx.W = w;
                J();
                cg.a("md");
            }
        }
    }
    
    private void Code(final boolean b, final int n) {
        if (this.B(n)) {
            if (!b) {
                cg.Code(this);
                return;
            }
            this.run();
        }
    }
    
    private void Code(final byte[] array, final int n) {
        this.v.write(array, 0, n);
        if (this.B()) {
            this.v.flush();
        }
        this.A = System.currentTimeMillis();
    }
    
    private void Code(final byte[] array, final int n, final int n2) {
        int z;
        for (int i = n; i < n2; i += z + 6) {
            z = q.Z(array, i + 4);
            this.J.Code(this.V++);
            this.J.Code(array, i + 4, z + 2);
            this.J.I(array, i, 4);
        }
        this.C.Code(array, n, n2 - n);
    }
    
    private static void Code(final byte[] array, final int n, final int n2, final int n3, final int n4) {
        array[n + 4 + 0] = (byte)(n4 + 2 >> 8);
        array[n + 4 + 1] = (byte)(n4 + 2);
        array[n + 4 + 2] = (byte)n2;
        array[n + 4 + 3] = (byte)n3;
    }
    
    private byte[] Code(final by by, int i) {
        Object[] a = null;
        int[] b = null;
        int j = 0;
        String s = null;
        int length = 0;
        int length2 = 0;
        int length3 = 0;
        String code;
        int code2;
        int n;
        Label_0120_Outer:Label_0443_Outer:Label_0334_Outer:
        while (true) {
        Label_0334:
            while (true) {
            Label_0443:
                while (true) {
                Label_1664:
                    while (true) {
                        Label_1658:Label_0214_Outer:Label_0364_Outer:
                        while (true) {
                        Label_0231_Outer:
                            while (true) {
                                Label_1641: {
                                    Label_1636: {
                                        Label_1627: {
                                            while (true) {
                                                Label_1566:Label_0303_Outer:
                                                while (true) {
                                                    Label_1559: {
                                                    Label_0303:
                                                        while (true) {
                                                            Label_0487: {
                                                                synchronized (bx.X) {
                                                                    a = by.a();
                                                                    b = by.b();
                                                                    j = 0;
                                                                    s = (String)this.T[1];
                                                                    if (this.O) {
                                                                        break Label_1559;
                                                                    }
                                                                    length = (s + "\u0000" + u.Code.U() + "\u0000").getBytes().length;
                                                                    length2 = this.S.C.length;
                                                                    if (!this.F) {
                                                                        break Label_0231_Outer;
                                                                    }
                                                                    length3 = cg.B(1).length();
                                                                    if (this.v != null) {
                                                                        break Label_1658;
                                                                    }
                                                                    j = 2;
                                                                    j = j + (length2 + (length + 41) + length3) + this.S.B.length;
                                                                    this.G = this.H;
                                                                    this.H = null;
                                                                    if (this.N > 0) {
                                                                        this.K = null;
                                                                        this.G = null;
                                                                        this.N = 0;
                                                                    }
                                                                    if (this.K == null) {
                                                                        break Label_1664;
                                                                    }
                                                                    length3 = j + (this.K.length + 8);
                                                                    while (true) {
                                                                        j = length3;
                                                                        if (this.G != null) {
                                                                            break Label_1559;
                                                                        }
                                                                        length = length3 + 8;
                                                                        if ((this.d.I & 0x4) != 0x0) {
                                                                            length3 = 1;
                                                                            break Label_1566;
                                                                        }
                                                                        break Label_0487;
                                                                    Label_0427:
                                                                        while (true) {
                                                                        Block_37:
                                                                            while (true) {
                                                                                while (true) {
                                                                                    code = u.Code.Code("OM-Install-Referrer");
                                                                                    iftrue(Label_0492:)(code == null);
                                                                                    break Label_0303;
                                                                                    b[24] &= 0xFFFDFFFF;
                                                                                    break Label_1627;
                                                                                    iftrue(Label_0601:)(length2 >= 127);
                                                                                    break Block_37;
                                                                                    iftrue(Label_0470:)(length3 >= 127);
                                                                                Block_34:
                                                                                    while (true) {
                                                                                        Label_0263: {
                                                                                            Block_41: {
                                                                                                break Block_41;
                                                                                                cg.Code(false);
                                                                                                break Label_0263;
                                                                                            }
                                                                                            this.L[length3] = null;
                                                                                            this.M[length3] = 0;
                                                                                            ++length3;
                                                                                            continue Label_0443;
                                                                                            a[100] = code;
                                                                                            a[120] = u.Code.Code("OM-Facebook-Attribution-Id");
                                                                                            iftrue(Label_1669:)(!cg.N);
                                                                                            length3 = 1;
                                                                                            break Label_0334;
                                                                                        }
                                                                                        a[6] = cg.F;
                                                                                        iftrue(Label_0285:)(cg.G == null);
                                                                                        break Block_34;
                                                                                        iftrue(Label_0499:)(!(a[length2] instanceof byte[]) || (this.L[length2] instanceof byte[] && cg.Code((byte[])a[length2], (byte[])this.L[length2])));
                                                                                        break Label_0427;
                                                                                        b[0] = 16;
                                                                                        a[40] = s;
                                                                                        a[33] = cg.B(2);
                                                                                        iftrue(Label_0263:)(cg.F != null);
                                                                                        continue Label_0334_Outer;
                                                                                    }
                                                                                    a[28] = cg.G;
                                                                                    continue Label_0303_Outer;
                                                                                }
                                                                                b[50] = length3;
                                                                                iftrue(Label_1627:)(this.B());
                                                                                continue Label_0364_Outer;
                                                                            }
                                                                            iftrue(Label_0570:)(a[length2] == null);
                                                                            continue Label_0231_Outer;
                                                                        }
                                                                        length3 = ((byte[])a[length2]).length + 7;
                                                                        break Label_1636;
                                                                        Label_0470: {
                                                                            this.G = null;
                                                                        }
                                                                        length3 = j;
                                                                        continue Label_0214_Outer;
                                                                    }
                                                                }
                                                            }
                                                            length3 = 0;
                                                            break Label_1566;
                                                            Label_0492: {
                                                                code = "";
                                                            }
                                                            continue Label_0303;
                                                        }
                                                        Label_0499: {
                                                            if (this.L[length2] != null) {
                                                                length3 = j;
                                                                if (a[length2].equals(this.L[length2])) {
                                                                    break Label_1641;
                                                                }
                                                            }
                                                        }
                                                        length3 = j;
                                                        if (a[length2] instanceof String) {
                                                            code2 = q.Code((String)a[length2]);
                                                            if (code2 <= 254) {
                                                                n = 4;
                                                            }
                                                            else {
                                                                n = 7;
                                                            }
                                                            length3 = n + code2;
                                                            break Label_1636;
                                                        }
                                                        break Label_1641;
                                                        Label_0570:
                                                        if (this.M[length2] == b[length2]) {
                                                            length3 = j;
                                                            if (this.L[length2] == null) {
                                                                break Label_1641;
                                                            }
                                                        }
                                                        if (b[length2] <= 254) {
                                                            length3 = 4;
                                                            break Label_1636;
                                                        }
                                                        length3 = 7;
                                                        break Label_1636;
                                                    }
                                                    length = j;
                                                    continue Label_0364_Outer;
                                                }
                                                if (length3 != 0) {
                                                    a[77] = null;
                                                    a[79] = (a[73] = null);
                                                    a[118] = (a[117] = null);
                                                    b[99] = 0;
                                                    a[94] = (a[86] = null);
                                                    b[85] = 0;
                                                    continue;
                                                }
                                                continue;
                                            }
                                        }
                                        j = 4;
                                        length2 = 0;
                                        continue Label_0443_Outer;
                                    }
                                    length3 += j;
                                }
                                ++length2;
                                j = length3;
                                continue Label_0443_Outer;
                            }
                            length3 = 0;
                            continue Label_0120_Outer;
                        }
                        j = 0;
                        continue Label_0443_Outer;
                    }
                    length3 = 0;
                    continue Label_0443;
                }
                Label_1669: {
                    length3 = 0;
                }
                continue Label_0334;
            }
        }
        final int n2;
        Label_0601: {
            n2 = length + (j + 16 + j / 65529 * 8);
        }
        final ak ak = new ak(n2);
        final DataOutputStream dataOutputStream = new DataOutputStream(ak);
        int n3 = 0;
        if (!this.O) {
            int n4;
            if (this.v == null) {
                dataOutputStream.write(1);
                dataOutputStream.write(2);
                n4 = 2;
            }
            else {
                n4 = 0;
            }
            dataOutputStream.write(1);
            dataOutputStream.write(this.S.b, 0, 8);
            dataOutputStream.writeInt(this.S.Code[0]);
            dataOutputStream.write(this.S.C);
            dataOutputStream.writeShort(i);
            dataOutputStream.write(this.S.B);
            i = ak.size();
            String b2;
            if (this.F) {
                b2 = cg.B(1);
            }
            else {
                b2 = "";
            }
            dataOutputStream.writeUTF(b2);
            this.J.Code(ak.Code(), n4, ak.size() - n4);
            this.B.Code(ak.Code(), n4, ak.size() - n4);
            this.J.I(ak.Code(), ak.size(), 16);
            ak.Code(ak.size() + 16);
            this.C.Code(ak.Code(), i, ak.size() - i);
            i = ak.size();
            final byte[] bytes = (s + "\u0000" + u.Code.U() + "\u0000").getBytes();
            Code(ak, 128, 3, bytes.length);
            dataOutputStream.write(bytes);
            if (this.K != null) {
                Code(ak, 15, 0, 8);
                dataOutputStream.write(this.K);
            }
            n3 = i;
            if (this.G == null) {
                Code(ak, 16, 0, 0);
                n3 = i;
            }
        }
        ++this.N;
        final by by2;
        Code(ak, 5, by2.C(), 0);
        Code(ak, 22, by2.C(), Math.min(j, 65529));
        dataOutputStream.writeInt(j - 4 + Code(by2.Code(false)));
        int size;
        String s2;
        byte[] array;
        int n5;
        int k;
        int n6;
        for (i = 0; i < 127; ++i) {
            if (a[i] != null) {
                if (a[i] instanceof byte[] && (!(this.L[i] instanceof byte[]) || !cg.Code((byte[])a[i], (byte[])this.L[i]))) {
                    dataOutputStream.write(1);
                    dataOutputStream.writeShort(i);
                    dataOutputStream.writeInt(((byte[])a[i]).length);
                    dataOutputStream.write((byte[])a[i]);
                }
                else if ((this.L[i] == null || !a[i].equals(this.L[i])) && a[i] instanceof String) {
                    if (q.Code((String)a[i]) <= 254) {
                        dataOutputStream.write(0);
                        dataOutputStream.write(i >> 16);
                        size = ak.size();
                        dataOutputStream.writeUTF((String)a[i]);
                        ak.Code()[size] = (byte)i;
                    }
                    else {
                        dataOutputStream.write(1);
                        dataOutputStream.writeShort(i);
                        s2 = (String)a[i];
                        array = new byte[q.Code(s2)];
                        n5 = 0;
                        for (k = 0; k < s2.length(); ++k) {
                            n5 += q.Code(s2.charAt(k), array, n5);
                        }
                        dataOutputStream.writeInt(array.length);
                        dataOutputStream.write(array);
                    }
                }
            }
            else if (this.M[i] != b[i] || this.L[i] != null) {
                n6 = b[i];
                if (n6 <= 254) {
                    dataOutputStream.write(2);
                    dataOutputStream.writeShort(i);
                    dataOutputStream.write(n6);
                }
                else {
                    dataOutputStream.write(3);
                    dataOutputStream.writeShort(i);
                    dataOutputStream.writeInt(n6);
                }
            }
            this.L[i] = a[i];
            this.M[i] = b[i];
        }
        i = ak.size() - j;
        while (j > 65529) {
            ak.Code(ak.size() + 8);
            System.arraycopy(ak.Code(), 65529 + i, ak.Code(), 65529 + i + 8, j - 65529);
            i += 65537;
            j -= 65529;
            Code(ak.Code(), i - 8, 22, by2.C(), Math.min(j, 65529));
        }
        this.Code(ak.Code(), n3, n2);
        this.O = true;
        final byte[] code3 = ak.Code();
        final Object o;
        monitorexit(o);
        return code3;
    }
    
    private static String I(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if ((char1 <= '/' || char1 >= ':') && (char1 <= '@' || char1 >= '[') && (char1 <= '`' || char1 >= '{') && "-_.~".indexOf(char1) == -1 && "%&=".indexOf(char1) == -1) {
                sb.append('%').append(Integer.toString(char1, 16));
            }
            else {
                sb.append(char1);
            }
        }
        return sb.toString();
    }
    
    public static void I() {
        final int size = bx.ae.size();
        int n = 0;
    Label_0045_Outer:
        while (true) {
            if (n >= size) {
                return;
            }
            while (true) {
                try {
                    final bx bx = bx.ae.elementAt(n);
                    if (bx != null) {
                        bx.s |= false;
                        bx.Code(false, 0);
                    }
                    ++n;
                    continue Label_0045_Outer;
                }
                catch (Throwable t) {
                    continue;
                }
                break;
            }
        }
    }
    
    private static void I(final byte p2, final String r) {
        bx.p = p2;
        bx.r = r;
    }
    
    private void I(final int n) {
        synchronized (this) {
            this.Z(this.Z(n));
        }
    }
    
    private static void I(final by y) {
        synchronized (bx.X) {
            y.Code(bx.y);
            bx.y = y;
        }
    }
    
    public static void J() {
        synchronized (bx.X) {
            if (!bx.m) {
                Code((byte)(-1), null);
                I((byte)(-1), null);
                ++bx.o;
                bx.n = true;
                Z();
            }
        }
    }
    
    private static void J(final int n) {
        synchronized (bx.X) {
            while (bx.y != null) {
                bx.y.I(n);
                bx.y = bx.y.B();
            }
        }
        final Object o;
        monitorexit(o);
    }
    
    private void J(final by by) {
        synchronized (this) {
            this.Z(by);
            by.J();
            I(by);
        }
    }
    
    private by Z(final int n) {
        monitorenter(this);
        int i = 0;
        try {
            while (i < this.t.size()) {
                final by by = this.t.elementAt(i);
                if (by.C() == n) {
                    return by;
                }
                ++i;
            }
            return null;
        }
        finally {
            monitorexit(this);
        }
    }
    
    public static void Z() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_2       
        //     4: aload_2        
        //     5: monitorenter   
        //     6: getstatic       bx.ae:Ljava/util/Vector;
        //     9: invokevirtual   java/util/Vector.size:()I
        //    12: istore_1       
        //    13: iconst_0       
        //    14: istore_0       
        //    15: iload_0        
        //    16: iload_1        
        //    17: if_icmpge       75
        //    20: getstatic       bx.ae:Ljava/util/Vector;
        //    23: iload_0        
        //    24: invokevirtual   java/util/Vector.elementAt:(I)Ljava/lang/Object;
        //    27: checkcast       Lbx;
        //    30: astore_3       
        //    31: aload_3        
        //    32: ifnull          68
        //    35: getstatic       bx.ae:Ljava/util/Vector;
        //    38: aconst_null    
        //    39: iload_0        
        //    40: invokevirtual   java/util/Vector.setElementAt:(Ljava/lang/Object;I)V
        //    43: aload_3        
        //    44: iconst_0       
        //    45: putfield        bx.s:Z
        //    48: aload_3        
        //    49: invokespecial   bx.h:()V
        //    52: aload_3        
        //    53: getfield        bx.t:Ljava/util/Vector;
        //    56: invokevirtual   java/util/Vector.isEmpty:()Z
        //    59: ifeq            68
        //    62: aload_3        
        //    63: iconst_0       
        //    64: iconst_0       
        //    65: invokespecial   bx.Code:(ZI)V
        //    68: iload_0        
        //    69: iconst_1       
        //    70: iadd           
        //    71: istore_0       
        //    72: goto            15
        //    75: aload_2        
        //    76: monitorexit    
        //    77: return         
        //    78: astore_3       
        //    79: aload_2        
        //    80: monitorexit    
        //    81: aload_3        
        //    82: athrow         
        //    83: astore_3       
        //    84: goto            68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      13     78     83     Any
        //  20     31     83     87     Ljava/lang/Throwable;
        //  20     31     78     83     Any
        //  35     68     83     87     Ljava/lang/Throwable;
        //  35     68     78     83     Any
        //  75     77     78     83     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0068:
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
    
    private void Z(final by by) {
        monitorenter(this);
        if (by == null) {
            return;
        }
        try {
            this.t.removeElement(by);
        }
        finally {
            monitorexit(this);
        }
    }
    
    private void Z(final boolean b) {
        this.Code(b, 0);
    }
    
    public static String a() {
        final String g = bx.g;
        bx.g = null;
        return g;
    }
    
    public static boolean b() {
        return true;
    }
    
    private String d() {
        return b$2.j("http://" + this.d.Z + ":" + this.d.J + "/");
    }
    
    private by e() {
        while (true) {
            while (true) {
                int n = 0;
                Label_0224: {
                    synchronized (bx.X) {
                        if (!this.B() && this == bx.ae.elementAt(this.ab)) {
                            bx.ae.setElementAt(null, this.ab);
                        }
                        while (bx.y == null || (bx.y != null && (this.ab != bx.y.Code() || (this.B() && this.g() && this != bx.y.Z())))) {
                            if (this.Q) {
                                n = 0;
                                if (n < this.t.size()) {
                                    final by by = this.t.elementAt(n);
                                    if (by.l() != 0) {
                                        return by;
                                    }
                                    break Label_0224;
                                }
                            }
                            this.Q = false;
                            cg.Code(bx.X, 0);
                            if (this.P) {
                                f();
                                return null;
                            }
                        }
                        if (this.P) {
                            f();
                            return null;
                        }
                        final by y = bx.y;
                        bx.y = y.B();
                        for (n = 1; this.Z(n) != null; ++n) {}
                        this.t.addElement(y);
                        y.Code(this, n);
                        f();
                        return y;
                    }
                }
                ++n;
                continue;
            }
        }
    }
    
    private static void f() {
        byte b = 1;
        synchronized (bx.X) {
            if (bx.m) {
                return;
            }
            if (bx.k) {
                bx.k = false;
                J();
            }
            if (bx.y == null) {
                return;
            }
        }
        final int code = bx.y.Code();
        final boolean i = bx.y.I();
        final bu code2 = ce.Code(code);
        if (bx.Code == -2 && bx.p == -2) {
            Code((byte)(-1), null);
            I((byte)(-1), null);
        }
        if (code2.I() && bx.p == -2) {
            I((byte)(-1), null);
        }
        if (((code2.I() && bx.p == -1) || (!code2.I() && (bx.Code == -1 || (bx.Code == -2 && bx.p == -1)))) && !bx.l) {
            ++bx.o;
            bx.f = -1;
            bx.n = true;
            bx.l = true;
        }
        if (bx.ae.size() > code && bx.ae.elementAt(code) != null) {
            cg.Code(bx.X);
        }
        else {
            final bn code3 = u.Code;
            if (!bx.n) {
                b = -1;
            }
            code3.Code(code, b, false, i);
        }
        final Object o;
        monitorexit(o);
    }
    
    private boolean g() {
        return bx.ae.elementAt(this.ab) != this;
    }
    
    private void h() {
        monitorenter(this);
        int i = 0;
        while (true) {
            while (true) {
                Label_0058: {
                    try {
                        while (i < this.t.size()) {
                            final by by = this.t.elementAt(i);
                            if (by.g()) {
                                break Label_0058;
                            }
                            this.J(by);
                            --i;
                            ++i;
                        }
                        return;
                    }
                    finally {
                        monitorexit(this);
                    }
                }
                continue;
            }
        }
    }
    
    private void i() {
        synchronized (this) {
            this.j();
            this.E = 0;
        }
    }
    
    private void j() {
        synchronized (this) {
            if (this.P) {
                throw new IOException();
            }
        }
        this.z = System.currentTimeMillis();
        monitorexit(this);
    }
    
    private boolean k() {
        synchronized (this) {
            if (this.E <= 0) {
                return false;
            }
            long n;
            if (this.z >= this.D) {
                n = Math.max(this.z, this.A) + 240000L;
            }
            else {
                long n2;
                if (this.B()) {
                    n2 = this.D;
                }
                else {
                    n2 = Math.max(this.D, this.A);
                }
                n = n2 + this.E;
            }
            if (n - System.currentTimeMillis() >= 0L) {
                return false;
            }
            return true;
            b = false;
            return b;
        }
    }
    
    private boolean l() {
        int o;
        bu i;
        Enumeration elements;
        int n;
        boolean b;
        bx code;
        final Object o2;
        Label_0178_Outer:Block_15_Outer:Label_0051_Outer:
        while (true) {
        Label_0233_Outer:
            while (true) {
                Label_0233:Label_0326_Outer:
                while (true) {
                    while (true) {
                        synchronized (bx.X) {
                            if (!bx.l) {
                                return false;
                            }
                            o = bx.o;
                            bx.l = false;
                            bx.m = true;
                            try {
                                if (bx.f >= this.c.length - 1) {
                                    bx.f = -1;
                                }
                                break Label_0233;
                                Label_0095: {
                                    i = ce.I(this.ab);
                                }
                                iftrue(Label_0170:)(!this.d.a.equals(i.a) || !this.d.C.equals(i.C) || this.d.J != i.J);
                                Label_0064: {
                                    Block_20: {
                                        break Block_20;
                                        while (true) {
                                            while (true) {
                                                while (true) {
                                                    ((aj)((Object[])elements.nextElement())[0]).Code();
                                                    iftrue(Label_0226:)(!elements.hasMoreElements());
                                                    continue Label_0178_Outer;
                                                }
                                                m();
                                                return true;
                                                ++bx.f;
                                                break Label_0064;
                                                Label_0170:
                                                elements = bx.Z.elements();
                                                continue Block_15_Outer;
                                            }
                                            iftrue(Label_0064:)(n != 0);
                                            continue Label_0051_Outer;
                                        }
                                    }
                                    m();
                                    return true;
                                }
                                iftrue(Label_0558:)(bx.f < this.c.length);
                                iftrue(Label_0095:)(!b);
                            }
                            catch (Throwable t) {
                                m();
                                return true;
                                Block_26: {
                                Block_27:
                                    while (true) {
                                        iftrue(Label_0572:)(!bx.W);
                                        break Block_26;
                                        Label_0286: {
                                            this.S.Code();
                                        }
                                        cg.a("md");
                                        iftrue(Label_0380:)(code != null);
                                        break Block_27;
                                        Label_0226:
                                        bx.f = 0;
                                        b = true;
                                        break Label_0233;
                                        while (true) {
                                            cg.Code(bx.X, 1000);
                                            iftrue(Label_0428:)(!bx.n || code.P || code.k());
                                            continue Label_0326_Outer;
                                        }
                                        iftrue(Label_0286:)(!this.c[bx.f].startsWith("socket://") || (bx.Code < 0 && !bx.W && !this.d.I()));
                                        continue Label_0233_Outer;
                                    }
                                    code = u.Code.Code(this.ab, bx.f, b, this.ad);
                                    continue;
                                }
                                Code((byte)(-2), null);
                            }
                            finally {
                                bx.m = false;
                                f();
                            }
                        }
                        Label_0380: {
                            code.K = null;
                        }
                        code.H = null;
                        code.e = bx.f;
                        if (code.ad) {
                            bx.ae.setElementAt(code, this.ab);
                        }
                        cg.Code(code);
                        continue;
                    }
                    Label_0428: {
                        if (!bx.n || o != bx.o) {
                            bx.m = false;
                            f();
                            monitorexit(o2);
                            return true;
                        }
                    }
                    if (code.i == 1 && n == 0) {
                        n = 1;
                    }
                    else {
                        n = 0;
                    }
                    if (code.i == 2) {
                        J(4);
                        bx.f = -1;
                        cg.a("md");
                        bx.m = false;
                        f();
                        monitorexit(o2);
                        return true;
                    }
                    if (code.B() && n == 0 && !this.c[bx.f + 1].startsWith("socket://")) {
                        Code((byte)(-2), null);
                    }
                    code.Code(false, 0);
                    continue Label_0233_Outer;
                    Label_0558:
                    continue Label_0233;
                }
                b = false;
                n = 0;
                continue;
                Label_0572: {
                    n = 0;
                }
                continue;
            }
        }
    }
    
    private static void m() {
        J(0);
        Code((byte)(-2), null);
        I((byte)(-2), null);
        bx.f = -1;
        cg.a("md");
    }
    
    private void n() {
        this.j();
        this.S.Code();
        final int n = (this.I[1] & 0xFF) * 4 + 128;
        final int n2 = this.I[2] & 0xFF;
        this.Code(5, n2 + 166 + n);
        this.i();
        this.S.C = new byte[n2 + 1];
        aj.c = this.S.C;
        System.arraycopy(this.I, 2, this.S.C, 0, n2 + 1);
        final int[] code = cg.Code(this.I, n2 + 3, 160);
        final int[] code2 = cg.Code(this.I, n2 + 163, n);
        final aj s = this.S;
        final byte[] i = this.I;
        final int n3 = n + (n2 + 163);
        s.I = (((long)q.J(i, n3 + 4) & 0xFFFFFFFFL) | (long)q.J(i, n3) << 32);
        this.S.Z = code;
        this.S.J = code2;
        if (!aj.e) {
            aj.d = System.currentTimeMillis() - (this.S.I - 1209600000L);
            aj.e = true;
        }
    }
    
    public final boolean B() {
        return this.c[this.e].startsWith("socket://");
    }
    
    public final bu Code() {
        return this.d;
    }
    
    final void Code(final by by) {
        synchronized (this) {
            if (this.k()) {
                this.Code(false, 2);
                if (by.k()) {
                    throw new IOException();
                }
            }
        }
        monitorexit(this);
    }
    
    final void I(final boolean b) {
    Label_0000:
        while (true) {
            while (true) {
                this.Code(0, 6);
                this.a.Code(this.I, 0, 6);
                final int z = q.Z(this.I, 4);
                if (z > 1014) {
                    throw new IOException();
                }
                this.Code(6, z);
                this.z = System.currentTimeMillis();
                this.a.Code(this.I, 6, z);
                this.B.Code(this.U++);
                this.B.Code(this.I, 4, z + 2);
                this.B.I(this.I, 1020, 4);
                if (this.I[1020] != this.I[0] || this.I[1021] != this.I[1] || this.I[1022] != this.I[2] || this.I[1023] != this.I[3]) {
                    throw new IOException();
                }
                final byte b2 = this.I[6];
                final byte b3 = this.I[7];
                int n = z - 2;
                switch (b2) {
                    case 20: {
                        cg.Code(new ay(q.Code(this.I, 8, n + 8)));
                        continue;
                    }
                    case 17: {
                        (this.G = u.Code.x()).Code();
                        continue;
                    }
                    case 9: {
                        this.N = Math.max(this.N - 1, 0);
                        this.Z(b3).f();
                        cg.Code(false);
                        continue;
                    }
                    case 7: {
                        this.I(b3);
                        continue;
                    }
                    case 4: {
                        this.Z(true);
                    }
                    case 12: {
                        continue;
                    }
                    default: {
                        continue;
                    }
                    case 11: {
                        this.G.Code(this);
                        this.G.setInput(this.I, 8, n);
                        if (b) {
                            return;
                        }
                    }
                    case 6:
                    case 10: {
                        by z2 = this.Z(b3);
                        int n2 = 0;
                        int n3 = 8;
                    Label_0363:
                        while (z2 != null) {
                            while (true) {
                                while (z2.c() == null) {
                                    if (z2.k()) {
                                        z2 = null;
                                        if (n2 == 0) {
                                            continue Label_0363;
                                        }
                                        continue Label_0000;
                                    }
                                    else {
                                        cg.Code((Object)z2, 1000);
                                    }
                                }
                                int n4 = Math.min(z2.e(), n);
                                switch (b2) {
                                    case 10: {
                                        System.arraycopy(this.I, n3, z2.c(), z2.d(), n4);
                                        if (n4 == n) {
                                            n2 = 1;
                                        }
                                        else {
                                            n2 = 0;
                                        }
                                        z2.J(n4);
                                        break;
                                    }
                                    case 11: {
                                        n4 = this.G.read(z2.c(), z2.d(), z2.e());
                                        if (n4 == 0) {
                                            n2 = 1;
                                        }
                                        else {
                                            n2 = 0;
                                        }
                                        z2.J(this.G.I());
                                        break;
                                    }
                                    case 6: {
                                        z2.j();
                                        Code(z2, true);
                                        if (this.F && !this.B()) {
                                            this.H = this.G;
                                        }
                                        if (this.M[50] == 1) {
                                            cg.N = false;
                                            cg.a("md");
                                            continue Label_0000;
                                        }
                                        continue Label_0000;
                                    }
                                }
                                z2.Code(n4);
                                n3 += n4;
                                n -= n4;
                                continue;
                            }
                        }
                        if (b2 == 11) {
                            while (this.G.read(null, 0, 1024) > 0) {}
                            continue;
                        }
                        continue;
                    }
                    case 15: {
                        if (!this.F) {
                            continue;
                        }
                        if (this.K != null) {
                            System.arraycopy(this.I, 8, this.K, 0, 8);
                            this.Z(this.s = true);
                            return;
                        }
                        this.K = new byte[8];
                        System.arraycopy(this.I, 8, this.K, 0, 8);
                        continue;
                    }
                }
            }
            break;
        }
    }
    
    final boolean c() {
        return this.F;
    }
    
    @Override
    public final void run() {
        while (true) {
            by e2 = null;
            Label_0811: {
            Label_0053_Outer:
                while (true) {
                    Label_0172: {
                        while (true) {
                            by e;
                            try {
                                if (this.P) {
                                    cg.Code(this.x);
                                    cg.Code((InputStream)this.w);
                                    this.R.Code();
                                    return;
                                }
                                if (this.l()) {
                                    break;
                                }
                                try {
                                    if (!this.O) {
                                        break Label_0172;
                                    }
                                    final byte[] array = new byte[8];
                                    while (true) {
                                        e = this.e();
                                        if (!e.k()) {
                                            break;
                                        }
                                        final int l = e.l();
                                        e.Z(0);
                                        Code(array, 0, l, e.C(), 0);
                                        this.Code(array, 0, 8);
                                        this.Code(array, 8);
                                        if (l != 7) {
                                            continue Label_0053_Outer;
                                        }
                                        this.Z(e);
                                    }
                                }
                                catch (Throwable t) {
                                    final boolean p = this.P;
                                    this.Code(true, 0);
                                    return;
                                }
                            }
                            catch (Throwable t2) {
                                return;
                            }
                            if (!e.g()) {
                                this.C(10000);
                                this.Code(e, this.Code(e, 0));
                                continue;
                            }
                            continue;
                        }
                    }
                    final boolean n = bx.n;
                    this.S.Z();
                    final int code = this.S.Code(this);
                    if (code < 0) {
                        final byte[] array2 = new byte[15];
                        array2[0] = 1;
                        array2[1] = 2;
                        array2[2] = 0;
                        cg.I(this.S.b);
                        System.arraycopy(this.S.b, 0, this.S.a, 0, 8);
                        System.arraycopy(this.S.a, 0, array2, 3, 8);
                        q.Z(this.S.Code[0], array2, 11);
                        this.C(30000);
                        try {
                            this.Code(null, array2);
                            this.Code(0, 5);
                            if (this.I[0] != 2) {
                                if (!this.C(null)) {
                                    this.i = 1;
                                    this.e();
                                    this.Code(true, 0);
                                    return;
                                }
                                break;
                            }
                        }
                        catch (Throwable t3) {
                            this.e();
                            throw t3;
                        }
                        this.n();
                        synchronized (bx.X) {
                            if (bx.n) {
                                bx.n = false;
                                bx.m = false;
                                final String s = this.c[this.e];
                                String substring = null;
                                if (s.indexOf(59) >= 0) {
                                    substring = s.substring(s.indexOf(59));
                                }
                                if (this.B()) {
                                    Code(this.e, substring);
                                }
                                else {
                                    I(this.e, substring);
                                }
                                if (this.ac && ce.I()) {
                                    final u i = u.I;
                                    u.v();
                                    Code(ce.Code);
                                }
                                bx.f = -1;
                                cg.L = true;
                                cg.M = true;
                                cg.a("md");
                            }
                            monitorexit(bx.X);
                            if (this.S.I()) {
                                this.S.Code();
                                J(1);
                                this.Code(true, 0);
                                return;
                            }
                        }
                        if (!this.B()) {
                            this.Code(this.s = true, 0);
                            return;
                        }
                    }
                    int code2;
                    if ((code2 = code) < 0) {
                        this.S.Z();
                        code2 = this.S.Code(this);
                    }
                    e2 = this.e();
                    this.C(240000);
                    this.Code(e2, this.Code(e2, code2));
                    this.Code(0, 5);
                    switch (this.I[0]) {
                        case 2: {
                            this.n();
                            if (this.S.I()) {
                                this.S.Code();
                                J(1);
                            }
                            this.Code(true, 0);
                            return;
                        }
                        case 3: {
                            this.z = System.currentTimeMillis();
                            if (!this.F) {
                                this.S.Code();
                            }
                            this.a.Code(this.I, 1, 4);
                            this.B.I(this.I, 5, 4);
                            if (this.I[1] != this.I[5] || this.I[2] != this.I[6] || this.I[3] != this.I[7] || this.I[4] != this.I[8]) {
                                this.Code(true, 0);
                                return;
                            }
                            if (this.B()) {
                                cg.Code(this);
                            }
                            this.I(false);
                            break Label_0053_Outer;
                        }
                        default: {
                            break Label_0811;
                        }
                    }
                    this.i = 1;
                    this.Code(true, 0);
                    return;
                }
                return;
            }
            if (!this.C(e2)) {
                continue;
            }
            break;
        }
    }
}
