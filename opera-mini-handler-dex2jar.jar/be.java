// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class be
{
    private static short[] C;
    private static short[] a;
    private static short[] b;
    private static int[] c;
    private static int[] d;
    private int A;
    private int[] B;
    public int Code;
    private int D;
    private byte[][] E;
    private int F;
    private int G;
    private int H;
    public int I;
    private int J;
    private int[] K;
    private int[][] L;
    private int[][] M;
    private short[][] N;
    private byte[][] O;
    private byte[][] P;
    private short[] Q;
    private int R;
    private int S;
    private int[] T;
    private int[][] U;
    private int V;
    private int W;
    int[] Z;
    private byte[] e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private int[] m;
    private int[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int[] s;
    private int t;
    private int[] u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int[] z;
    
    static {
        be.C = null;
        be.a = null;
        be.b = null;
        be.c = null;
        be.d = null;
    }
    
    public be() {
        int i = 0;
        this.l = new int[3];
        this.m = new int[3];
        this.n = new int[3];
        this.s = new int[3];
        this.u = new int[3];
        this.z = new int[3];
        this.E = new byte[3][];
        this.K = new int[6];
        this.L = new int[16][];
        this.M = new int[16][];
        this.N = new short[16][];
        this.O = new byte[16][];
        this.P = new byte[16][];
        this.Q = new short[3];
        this.T = new int[3];
        this.U = new int[4][];
        this.V = -1;
        Code();
        this.h = 0;
        this.i = 0;
        this.k = 0;
        this.y = 0;
        while (i < 3) {
            this.E[i] = null;
            this.L[i] = null;
            this.M[i] = null;
            this.N[i] = null;
            this.O[i] = null;
            this.P[i] = null;
            ++i;
        }
    }
    
    private int Code(final int n) {
        if (n == 0) {
            return 0;
        }
        if (this.S < n) {
            this.J();
            if (this.S < n) {
                return -2;
            }
        }
        final int r = this.R;
        this.R <<= n;
        this.S -= n;
        return r >>> 32 - n;
    }
    
    private static int Code(final int n, final int n2) {
        int n3 = n2;
        if (n2 < 1 << n - 1) {
            n3 = (-1 << n) + n2 + 1;
        }
        return n3;
    }
    
    private static void Code() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_3       
        //     2: ldc             Lbe;.class
        //     4: monitorenter   
        //     5: getstatic       be.C:[S
        //     8: astore          4
        //    10: aload           4
        //    12: ifnonnull       299
        //    15: aconst_null    
        //    16: astore          5
        //    18: invokestatic    cg.I:()Ljava/io/DataInputStream;
        //    21: astore          4
        //    23: aload           4
        //    25: astore          5
        //    27: sipush          768
        //    30: newarray        S
        //    32: putstatic       be.C:[S
        //    35: aload           4
        //    37: astore          5
        //    39: sipush          256
        //    42: newarray        S
        //    44: putstatic       be.a:[S
        //    47: aload           4
        //    49: astore          5
        //    51: sipush          256
        //    54: newarray        S
        //    56: putstatic       be.b:[S
        //    59: aload           4
        //    61: astore          5
        //    63: bipush          64
        //    65: newarray        I
        //    67: putstatic       be.c:[I
        //    70: aload           4
        //    72: astore          5
        //    74: bipush          64
        //    76: newarray        I
        //    78: putstatic       be.d:[I
        //    81: iconst_0       
        //    82: istore_1       
        //    83: iconst_0       
        //    84: istore_2       
        //    85: iload_1        
        //    86: sipush          768
        //    89: if_icmpge       347
        //    92: aload           4
        //    94: astore          5
        //    96: getstatic       be.C:[S
        //    99: astore          6
        //   101: aload           4
        //   103: astore          5
        //   105: iload_2        
        //   106: aload           4
        //   108: invokevirtual   java/io/DataInputStream.readShort:()S
        //   111: iadd           
        //   112: i2s            
        //   113: istore_0       
        //   114: aload           6
        //   116: iload_1        
        //   117: iload_0        
        //   118: sastore        
        //   119: iload_1        
        //   120: iconst_1       
        //   121: iadd           
        //   122: istore_1       
        //   123: iload_0        
        //   124: istore_2       
        //   125: goto            85
        //   128: iload_1        
        //   129: sipush          256
        //   132: if_icmpge       354
        //   135: aload           4
        //   137: astore          5
        //   139: getstatic       be.a:[S
        //   142: astore          6
        //   144: aload           4
        //   146: astore          5
        //   148: iload_2        
        //   149: aload           4
        //   151: invokevirtual   java/io/DataInputStream.readShort:()S
        //   154: iadd           
        //   155: i2s            
        //   156: istore_0       
        //   157: aload           6
        //   159: iload_1        
        //   160: iload_0        
        //   161: sastore        
        //   162: iload_1        
        //   163: iconst_1       
        //   164: iadd           
        //   165: istore_1       
        //   166: iload_0        
        //   167: istore_2       
        //   168: goto            128
        //   171: iload_1        
        //   172: sipush          256
        //   175: if_icmpge       361
        //   178: aload           4
        //   180: astore          5
        //   182: getstatic       be.b:[S
        //   185: astore          6
        //   187: aload           4
        //   189: astore          5
        //   191: iload_2        
        //   192: aload           4
        //   194: invokevirtual   java/io/DataInputStream.readShort:()S
        //   197: iadd           
        //   198: i2s            
        //   199: istore_0       
        //   200: aload           6
        //   202: iload_1        
        //   203: iload_0        
        //   204: sastore        
        //   205: iload_1        
        //   206: iconst_1       
        //   207: iadd           
        //   208: istore_1       
        //   209: iload_0        
        //   210: istore_2       
        //   211: goto            171
        //   214: iload_1        
        //   215: bipush          64
        //   217: if_icmpge       368
        //   220: aload           4
        //   222: astore          5
        //   224: getstatic       be.c:[I
        //   227: astore          6
        //   229: aload           4
        //   231: astore          5
        //   233: iload_2        
        //   234: aload           4
        //   236: invokevirtual   java/io/DataInputStream.readShort:()S
        //   239: iadd           
        //   240: i2s            
        //   241: istore_2       
        //   242: aload           6
        //   244: iload_1        
        //   245: iload_2        
        //   246: iastore        
        //   247: iload_1        
        //   248: iconst_1       
        //   249: iadd           
        //   250: istore_1       
        //   251: goto            214
        //   254: iload_1        
        //   255: bipush          64
        //   257: if_icmpge       294
        //   260: aload           4
        //   262: astore          5
        //   264: getstatic       be.d:[I
        //   267: astore          6
        //   269: aload           4
        //   271: astore          5
        //   273: iload_2        
        //   274: aload           4
        //   276: invokevirtual   java/io/DataInputStream.readShort:()S
        //   279: iadd           
        //   280: i2s            
        //   281: istore_2       
        //   282: aload           6
        //   284: iload_1        
        //   285: iload_2        
        //   286: iastore        
        //   287: iload_1        
        //   288: iconst_1       
        //   289: iadd           
        //   290: istore_1       
        //   291: goto            254
        //   294: aload           4
        //   296: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   299: ldc             Lbe;.class
        //   301: monitorexit    
        //   302: return         
        //   303: astore          4
        //   305: aload           5
        //   307: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   310: goto            299
        //   313: astore          4
        //   315: ldc             Lbe;.class
        //   317: monitorexit    
        //   318: aload           4
        //   320: athrow         
        //   321: astore          4
        //   323: aconst_null    
        //   324: astore          6
        //   326: aload           4
        //   328: astore          5
        //   330: aload           6
        //   332: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   335: aload           5
        //   337: athrow         
        //   338: astore          5
        //   340: aload           4
        //   342: astore          6
        //   344: goto            330
        //   347: iconst_0       
        //   348: istore_1       
        //   349: iconst_0       
        //   350: istore_2       
        //   351: goto            128
        //   354: iconst_0       
        //   355: istore_1       
        //   356: iconst_0       
        //   357: istore_2       
        //   358: goto            171
        //   361: iconst_0       
        //   362: istore_1       
        //   363: iconst_0       
        //   364: istore_2       
        //   365: goto            214
        //   368: iconst_0       
        //   369: istore_2       
        //   370: iload_3        
        //   371: istore_1       
        //   372: goto            254
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  5      10     313    321    Any
        //  18     23     303    313    Ljava/lang/Throwable;
        //  18     23     321    330    Any
        //  27     35     303    313    Ljava/lang/Throwable;
        //  27     35     338    347    Any
        //  39     47     303    313    Ljava/lang/Throwable;
        //  39     47     338    347    Any
        //  51     59     303    313    Ljava/lang/Throwable;
        //  51     59     338    347    Any
        //  63     70     303    313    Ljava/lang/Throwable;
        //  63     70     338    347    Any
        //  74     81     303    313    Ljava/lang/Throwable;
        //  74     81     338    347    Any
        //  96     101    303    313    Ljava/lang/Throwable;
        //  96     101    338    347    Any
        //  105    114    303    313    Ljava/lang/Throwable;
        //  105    114    338    347    Any
        //  139    144    303    313    Ljava/lang/Throwable;
        //  139    144    338    347    Any
        //  148    157    303    313    Ljava/lang/Throwable;
        //  148    157    338    347    Any
        //  182    187    303    313    Ljava/lang/Throwable;
        //  182    187    338    347    Any
        //  191    200    303    313    Ljava/lang/Throwable;
        //  191    200    338    347    Any
        //  224    229    303    313    Ljava/lang/Throwable;
        //  224    229    338    347    Any
        //  233    242    303    313    Ljava/lang/Throwable;
        //  233    242    338    347    Any
        //  264    269    303    313    Ljava/lang/Throwable;
        //  264    269    338    347    Any
        //  273    282    303    313    Ljava/lang/Throwable;
        //  273    282    338    347    Any
        //  294    299    313    321    Any
        //  305    310    313    321    Any
        //  330    338    313    321    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 214, Size: 214
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
    
    private void Code(int i, final short[] array, final byte[] array2, int n, final int n2) {
        final int[] array3 = new int[64];
        for (int j = 0; j < 8; ++j) {
            if (array[be.c[j + 8]] == 0 && array[be.c[j + 16]] == 0 && array[be.c[j + 24]] == 0 && array[be.c[j + 32]] == 0 && array[be.c[j + 40]] == 0 && array[be.c[j + 48]] == 0 && array[be.c[j + 56]] == 0) {
                final int n3 = array[be.c[j]] * this.U[this.T[i]][j];
                array3[j + 8] = (array3[j] = n3);
                array3[j + 24] = (array3[j + 16] = n3);
                array3[j + 40] = (array3[j + 32] = n3);
                array3[j + 56] = (array3[j + 48] = n3);
            }
            else {
                array3[j] = array[be.c[j]] * this.U[this.T[i]][j];
                array3[j + 8] = array[be.c[j + 8]] * this.U[this.T[i]][j + 8];
                array3[j + 16] = array[be.c[j + 16]] * this.U[this.T[i]][j + 16];
                array3[j + 24] = array[be.c[j + 24]] * this.U[this.T[i]][j + 24];
                array3[j + 32] = array[be.c[j + 32]] * this.U[this.T[i]][j + 32];
                array3[j + 40] = array[be.c[j + 40]] * this.U[this.T[i]][j + 40];
                array3[j + 48] = array[be.c[j + 48]] * this.U[this.T[i]][j + 48];
                array3[j + 56] = array[be.c[j + 56]] * this.U[this.T[i]][j + 56];
                final int n4 = array3[j];
                final int n5 = array3[j + 32];
                final int n6 = array3[j + 16];
                final int n7 = array3[j + 48];
                final int n8 = array3[j + 16] + array3[j + 48];
                final int n9 = n4 - n5;
                final int n10 = (n6 - n7 >> 8) * 362 - n8;
                final int n11 = n9 - n10;
                final int n12 = n10 + n9;
                final int n13 = n4 + n5;
                final int n14 = n13 - n8;
                final int n15 = n13 + n8;
                final int n16 = array3[j + 40] - array3[j + 24];
                final int n17 = array3[j + 8] + array3[j + 56];
                final int n18 = array3[j + 24] + array3[j + 40];
                final int n19 = n17 + n18;
                final int n20 = array3[j + 8] - array3[j + 56];
                final int n21 = (n16 + n20 >> 8) * 196;
                final int n22 = -n16;
                final int n23 = (n20 >> 8) * 669 - n21 - n19;
                final int n24 = n23 - (n17 - n18 >> 8) * 362;
                final int n25 = (n22 >> 8) * 277 - n21 - n24;
                array3[j] = n15 + n19;
                array3[j + 8] = n12 + n23;
                array3[j + 16] = n11 - n24;
                array3[j + 24] = n14 - n25;
                array3[j + 32] = n14 + n25;
                array3[j + 40] = n11 + n24;
                array3[j + 48] = n12 - n23;
                array3[j + 56] = n15 - n19;
            }
        }
        byte b;
        int n26;
        int n27;
        int n28;
        int n29;
        int n30;
        int n31;
        int n32;
        int n33;
        int n34;
        int n35;
        int n36;
        int n37;
        int n38;
        int n39;
        int n40;
        int n41;
        int n42;
        int n43;
        int n44;
        int n45;
        int n46;
        int n47;
        for (i = 0; i < 64; i += 8) {
            if (array3[i + 1] == 0 && array3[i + 2] == 0 && array3[i + 3] == 0 && array3[i + 4] == 0 && array3[i + 5] == 0 && array3[i + 6] == 0 && array3[i + 7] == 0) {
                b = (byte)be.C[(array3[i] + 1024 >> 11) + 128 + 256];
                array2[n + 1] = (array2[n] = b);
                array2[n + 3] = (array2[n + 2] = b);
                array2[n + 5] = (array2[n + 4] = b);
                array2[n + 7] = (array2[n + 6] = b);
            }
            else {
                n26 = array3[i];
                n27 = array3[i + 4];
                n28 = array3[i + 2];
                n29 = array3[i + 6];
                n30 = array3[i + 2] + array3[i + 6];
                n31 = n26 - n27;
                n32 = (n28 - n29 >> 8) * 362 - n30;
                n33 = n31 - n32;
                n34 = n32 + n31;
                n35 = n26 + n27;
                n36 = n35 - n30;
                n37 = n35 + n30;
                n38 = array3[i + 5] - array3[i + 3];
                n39 = array3[i + 1] + array3[i + 7];
                n40 = array3[i + 3] + array3[i + 5];
                n41 = n39 + n40;
                n42 = array3[i + 1] - array3[i + 7];
                n43 = (n38 + n42 >> 8) * 196;
                n44 = -n38;
                n45 = (n42 >> 8) * 669 - n43 - n41;
                n46 = n45 - (n39 - n40 >> 8) * 362;
                n47 = (n44 >> 8) * 277 - n43 - n46;
                array2[n] = (byte)be.C[(n37 + n41 + 1024 >> 11) + 128 + 256];
                array2[n + 1] = (byte)be.C[(n34 + n45 + 1024 >> 11) + 128 + 256];
                array2[n + 2] = (byte)be.C[(n33 - n46 + 1024 >> 11) + 128 + 256];
                array2[n + 3] = (byte)be.C[(n36 - n47 + 1024 >> 11) + 128 + 256];
                array2[n + 4] = (byte)be.C[(n36 + n47 + 1024 >> 11) + 128 + 256];
                array2[n + 5] = (byte)be.C[(n46 + n33 + 1024 >> 11) + 128 + 256];
                array2[n + 6] = (byte)be.C[(n34 - n45 + 1024 >> 11) + 128 + 256];
                array2[n + 7] = (byte)be.C[(n37 - n41 + 1024 >> 11) + 128 + 256];
            }
            n += n2;
        }
    }
    
    private void Code(final boolean b) {
        final int n = this.o * 8;
        final int n2 = n * this.F;
        final int[] array = new int[3];
        final int[] array2 = new int[3];
        final int[] array3 = new int[3];
        final int[] array4 = new int[3];
        if (this.k == 3) {
            array2[array[0] = 0] = (this.m[0] << 11) / this.o;
            array4[0] = (this.n[0] << 11) / this.p;
            array[1] = 0;
            array2[1] = (this.m[1] << 11) / this.o;
            array4[1] = (this.n[1] << 11) / this.p;
            array[2] = 0;
            array2[2] = (this.m[2] << 11) / this.o;
            array4[2] = (this.n[2] << 11) / this.p;
        }
        if (!b) {
            this.W = this.G;
        }
        else {
            int w;
            if (this.A == 0) {
                w = this.G % (this.p * 8);
            }
            else {
                w = this.p * 8;
            }
            this.W = w;
            if (this.W == 0) {
                this.W = this.p * 8;
            }
        }
        int[] array5;
        if (b) {
            array5 = this.B;
        }
        else {
            array5 = this.Z;
        }
        for (int i = 0; i < n; ++i) {
            if (n2 + i < this.H && this.k == 3) {
                int n4;
                final int n3 = n4 = (n2 + i) * this.G;
                if (b) {
                    final int n5 = this.s[0];
                    final int n6 = this.A / this.D;
                    final int p = this.p;
                    if (this.V == -1) {
                        this.V = n3 + ((n5 + 1 & 0xFFFFFFFE) * 8 - (n6 + 1) * p * 8);
                    }
                    n4 = this.p * i * 8;
                }
                final int n7 = array[0];
                int n8;
                if (b) {
                    n8 = this.n[0] * 8;
                }
                else {
                    n8 = this.s[0] * 8;
                }
                final int n9 = (n7 >> 11) * n8;
                array[0] += array2[0];
                array3[0] = 0;
                final int n10 = array[1];
                int n11;
                if (b) {
                    n11 = this.n[1] * 8;
                }
                else {
                    n11 = this.s[1] * 8;
                }
                final int n12 = (n10 >> 11) * n11;
                array[1] += array2[1];
                array3[1] = 0;
                final int n13 = array[2];
                int n14;
                if (b) {
                    n14 = this.n[2] * 8;
                }
                else {
                    n14 = this.s[2] * 8;
                }
                final int n15 = (n13 >> 11) * n14;
                array[2] += array2[2];
                array3[2] = 0;
                if (this.n[0] == 2 && this.n[1] == 1 && this.n[2] == 1) {
                    for (int j = 0; j < this.W >> 1; ++j) {
                        final int n16 = this.E[0][(j << 1) + n9] & 0xFF;
                        final int n17 = this.E[1][n12 + j] & 0xFF;
                        final int n18 = this.E[2][n15 + j] & 0xFF;
                        final short n19 = be.a[n18];
                        final short n20 = be.b[n17];
                        final int n21 = (n17 - 128) * 705 + (n18 - 128) * 1463 + 1024 >> 11;
                        final short n22 = be.C[n16 + n19 + 256];
                        final short n23 = be.C[n16 - n21 + 256];
                        final short n24 = be.C[n16 + n20 + 256];
                        final int n25 = n4 + 1;
                        array5[n4] = (n24 | (n22 << 16 | n23 << 8));
                        final int n26 = this.E[0][(j << 1) + n9 + 1] & 0xFF;
                        final short n27 = be.C[n26 + n19 + 256];
                        final short n28 = be.C[n26 - n21 + 256];
                        final short n29 = be.C[n26 + n20 + 256];
                        n4 = n25 + 1;
                        array5[n25] = (n27 << 16 | n28 << 8 | n29);
                    }
                    if ((this.G & 0x1) != 0x0 && this.A == 0) {
                        int g;
                        if (b) {
                            g = this.p * 8;
                        }
                        else {
                            g = this.G;
                        }
                        final int n30 = this.E[0][n9 + g - 1] & 0xFF;
                        final int n31 = this.E[1][n12 + (g - 1 >> 1)] & 0xFF;
                        final byte b2 = this.E[2][(g - 1 >> 1) + n15];
                        final short n32 = be.C[be.b[n31] + n30 + 256];
                        final int n33 = (b2 & 0xFF) - 128;
                        array5[n4] = (be.C[be.a[n33 + 128] + n30 + 256] << 16 | be.C[n30 - ((n31 - 128) * 705 + n33 * 1463 + 1024 >> 11) + 256] << 8 | n32);
                    }
                }
                else if (this.n[0] == 1 && this.n[1] == 1 && this.n[2] == 1) {
                    for (int k = 0; k < this.W; ++k, ++n4) {
                        final int n34 = this.E[0][n9 + k] & 0xFF;
                        final int n35 = this.E[1][n12 + k] & 0xFF;
                        final byte b3 = this.E[2][n15 + k];
                        final short n36 = be.C[be.b[n35] + n34 + 256];
                        final int n37 = (b3 & 0xFF) - 128;
                        array5[n4] = (be.C[n34 - ((n35 - 128) * 705 + n37 * 1463 + 1024 >> 11) + 256] << 8 | be.C[n34 + be.a[n37 + 128] + 256] << 16 | n36);
                    }
                }
                else {
                    for (int l = 0; l < this.W; ++l, ++n4) {
                        final int n38 = array3[0];
                        array3[0] += array4[0];
                        final byte b4 = this.E[0][(n38 >> 11) + n9];
                        final int n39 = array3[1];
                        array3[1] += array4[1];
                        final byte b5 = this.E[1][(n39 >> 11) + n12];
                        final int n40 = array3[2];
                        array3[2] += array4[2];
                        final byte b6 = this.E[2][(n40 >> 11) + n15];
                        final short n41 = be.C[be.b[b5] + b4 + 256];
                        final int n42 = b6 - 128;
                        array5[n4] = (be.C[b4 - ((b5 - 128) * 705 + n42 * 1463 + 1024 >> 11) + 256] << 8 | be.C[b4 + be.a[n42 + 128] + 256] << 16 | n41);
                    }
                }
            }
        }
    }
    
    private int I(final int n) {
        if (this.S < 8) {
            this.J();
            if (this.S < 8) {
                return this.I(n, 1);
            }
        }
        final int n2 = this.R >>> 24;
        final byte b = this.P[n][n2];
        if (b <= 8) {
            this.R <<= b;
            this.S -= b;
            return this.P[n][n2 + 256] & 0xFF;
        }
        return this.I(n, 9);
    }
    
    private int I(final int n, int n2) {
        int code = this.Code(n2);
        if (code < 0) {
            return code;
        }
        int code2;
        for (--n2; n2 < 16 && code > this.L[n][n2]; code = (code2 | code << 1), ++n2) {
            code2 = this.Code(1);
            if (code2 < 0) {
                return code2;
            }
        }
        final short n3 = this.N[n][n2];
        n2 = this.M[n][n2];
        return this.O[n][code - n2 + n3] & 0xFF;
    }
    
    private void I() {
        if (this.t == 1) {
            this.A = ((this.n[this.u[this.v]] * this.G + this.p - 1) / this.p + 7) / 8;
            this.z[this.u[this.v]] = 0;
            return;
        }
        this.A = 0;
        for (int i = 0; i < this.t; ++i) {
            this.A += this.m[this.u[i]] * this.n[this.u[i]];
            this.z[this.u[i]] = 0;
        }
        this.D = this.A;
        this.A *= this.q / (this.p * 8);
    }
    
    private void J() {
        while (this.S <= 24 && this.g > 0) {
            final int n = this.e[this.f] & 0xFF;
            if (n == 255) {
                if (this.g < 2 || this.e[this.f + 1] != 0) {
                    break;
                }
                ++this.f;
                --this.g;
            }
            ++this.f;
            --this.g;
            this.R |= n << 24 - this.S;
            this.S += 8;
        }
    }
    
    private void Z() {
        for (int i = 0; i < 3; ++i) {
            this.Q[i] = 0;
        }
        this.R = 0;
        this.S = 0;
    }
    
    public final int Code(final byte[] e, int i, int j, int k, final boolean b) {
        this.e = e;
        this.f = i;
        this.g = j;
        this.J = k;
        i = 0;
    Label_0023:
        while (i == 0) {
            while (this.i > 0) {
                if (this.i >= this.g) {
                    this.i -= this.g;
                    j = 0;
                    return j;
                }
                this.f += this.i;
                this.g -= this.i;
                this.i = 0;
            }
            Label_0146: {
                switch (this.h) {
                    case 1:
                    case 2: {
                        if (this.g < 2) {
                            return this.g;
                        }
                        Block_12: {
                        Block_9:
                            while (true) {
                                j = i;
                                if (this.g < 2 || (j = i) != 0) {
                                    break Label_0146;
                                }
                                j = i;
                                if (this.i != 0) {
                                    break Label_0146;
                                }
                                if (this.h != 1) {
                                    j = i;
                                    if (this.h != 2) {
                                        break Label_0146;
                                    }
                                }
                                if ((this.e[this.f] & 0xFF) != 0xFF) {
                                    ++this.f;
                                    --this.g;
                                }
                                else {
                                    switch (this.e[this.f + 1] & 0xFF) {
                                        default: {
                                            if (this.g < 4) {
                                                break Block_9;
                                            }
                                            this.i = ((this.e[this.f + 2] & 0xFF) << 8 | (this.e[this.f + 3] & 0xFF));
                                            this.f += 4;
                                            this.g -= 4;
                                            this.i -= 2;
                                            continue;
                                        }
                                        case 192:
                                        case 193: {
                                            if (this.g < 4) {
                                                return this.g;
                                            }
                                            this.j = ((this.e[this.f + 2] & 0xFF) << 8 | (this.e[this.f + 3] & 0xFF));
                                            if (this.g < 10) {
                                                return this.g;
                                            }
                                            this.f += 4;
                                            this.g -= 4;
                                            this.j -= 2;
                                            this.G = ((this.e[this.f + 3] & 0xFF) << 8 | (this.e[this.f + 4] & 0xFF));
                                            this.H = ((this.e[this.f + 1] & 0xFF) << 8 | (this.e[this.f + 2] & 0xFF));
                                            if (b) {
                                                break Block_12;
                                            }
                                            this.Code = this.G >> this.J;
                                            this.I = this.H >> this.J;
                                            this.Z = new int[this.Code * this.I];
                                            this.k = (this.e[this.f + 5] & 0xFF);
                                            for (j = 0; j < 3; ++j) {
                                                this.K[j * 2] = 0;
                                                this.K[j * 2 + 1] = 4;
                                            }
                                            this.Z();
                                            this.f += 6;
                                            this.g -= 6;
                                            this.j -= 6;
                                            this.h = 3;
                                            continue;
                                        }
                                        case 218: {
                                            if (this.g < 4) {
                                                return this.g;
                                            }
                                            this.j = ((this.e[this.f + 2] & 0xFF) << 8 | (this.e[this.f + 3] & 0xFF));
                                            if (this.g < this.j + 2) {
                                                return this.g;
                                            }
                                            this.t = (this.e[this.f + 4] & 0xFF);
                                            this.f += 5;
                                            this.g -= 5;
                                            this.j -= 3;
                                            byte b2;
                                            int l;
                                            for (k = 0; k < this.t; ++k) {
                                                b2 = this.e[this.f];
                                                this.u[k] = k;
                                                for (j = 0; j < this.k; j = l + 1) {
                                                    l = j;
                                                    if ((b2 & 0xFF) == this.l[j]) {
                                                        this.u[k] = j;
                                                        l = this.k;
                                                    }
                                                }
                                                j = (this.e[this.f + 1] & 0xFF);
                                                this.K[this.u[k] * 2] = j >> 4;
                                                this.K[this.u[k] * 2 + 1] = (j & 0xF) + 4;
                                                this.f += 2;
                                                this.g -= 2;
                                                this.j -= 2;
                                            }
                                            this.Z();
                                            this.w = 0;
                                            this.v = 0;
                                            this.x = 0;
                                            this.F = 0;
                                            this.I();
                                            this.f += this.j;
                                            this.g -= this.j;
                                            this.h = 4;
                                            continue;
                                        }
                                        case 196: {
                                            if (this.g < 4) {
                                                i = -2;
                                            }
                                            else {
                                                i = ((this.e[this.f + 2] & 0xFF) << 8 | (this.e[this.f + 3] & 0xFF));
                                                if (this.g < i + 2) {
                                                    i = -2;
                                                }
                                                else {
                                                    k = i - 2;
                                                    this.f += 4;
                                                    this.g -= 4;
                                                    while (k > 0) {
                                                        final int n = (this.e[this.f] & 0xF) | (this.e[this.f] & 0x10) >> 2;
                                                        ++this.f;
                                                        --this.g;
                                                        int n2 = 0;
                                                        final short[] array = new short[16];
                                                        j = 0;
                                                        for (i = 0; i < 16; ++i) {
                                                            array[i] = (short)(this.e[this.f + i] & 0xFF);
                                                            j += array[i];
                                                        }
                                                        final int[] array2 = new int[j + 1];
                                                        final int[] array3 = new int[j];
                                                        for (i = 0; i < 16; ++i) {
                                                            for (j = 1; j <= array[i]; ++j, ++n2) {
                                                                array2[n2] = i + 1;
                                                            }
                                                        }
                                                        array2[n2] = 0;
                                                        int n3 = 0;
                                                        i = 0;
                                                        int n4 = array2[0];
                                                        while (array2[n3] != 0) {
                                                            int n5 = n3;
                                                            j = i;
                                                            while (array2[n5] == n4) {
                                                                array3[n5] = j;
                                                                ++j;
                                                                ++n5;
                                                            }
                                                            i = j;
                                                            n3 = n5;
                                                            if (array2[n5] != 0) {
                                                                int n6 = n4;
                                                                while (true) {
                                                                    n4 = n6;
                                                                    i = j;
                                                                    n3 = n5;
                                                                    if (array2[n5] == n6) {
                                                                        break;
                                                                    }
                                                                    j <<= 1;
                                                                    ++n6;
                                                                }
                                                            }
                                                        }
                                                        this.M[n] = new int[16];
                                                        this.L[n] = new int[16];
                                                        this.N[n] = new short[16];
                                                        j = 0;
                                                        for (i = 0; i < 16; ++i) {
                                                            if (array[i] == 0) {
                                                                this.L[n][i] = -1;
                                                            }
                                                            else {
                                                                this.N[n][i] = (short)j;
                                                                this.M[n][i] = array3[j];
                                                                j += array[i] - 1;
                                                                this.L[n][i] = array3[j];
                                                                ++j;
                                                            }
                                                        }
                                                        this.f += 16;
                                                        this.g -= 16;
                                                        this.O[n] = new byte[n2];
                                                        for (i = 0; i < n2; ++i) {
                                                            this.O[n][i] = this.e[this.f + i];
                                                        }
                                                        this.f += n2;
                                                        this.g -= n2;
                                                        this.P[n] = new byte[512];
                                                        for (i = 0; i < 256; ++i) {
                                                            this.P[n][i] = 9;
                                                        }
                                                        j = 0;
                                                        int n7;
                                                        int n8;
                                                        int n9;
                                                        for (i = 1; i <= 8; ++i) {
                                                            for (n7 = 0; n7 < array[i - 1]; ++n7) {
                                                                n8 = array3[j] << 8 - i;
                                                                for (n9 = 0; n9 < 1 << 8 - i; ++n9) {
                                                                    this.P[n][n8 | n9] = (byte)i;
                                                                    this.P[n][(n8 | n9) + 256] = this.O[n][j];
                                                                }
                                                                ++j;
                                                            }
                                                        }
                                                        k = k - 1 - 16 - n2;
                                                    }
                                                    i = 0;
                                                }
                                            }
                                            continue;
                                        }
                                        case 219: {
                                            if (this.g < 4) {
                                                i = -2;
                                            }
                                            else {
                                                i = ((this.e[this.f + 2] & 0xFF) << 8 | (this.e[this.f + 3] & 0xFF));
                                                if (this.g < i + 2) {
                                                    i = -2;
                                                }
                                                else {
                                                    this.f += 4;
                                                    this.g -= 4;
                                                    i -= 2;
                                                    while (i > 0) {
                                                        if ((this.e[this.f] & 0xF0) != 0x0) {
                                                            j = 1;
                                                        }
                                                        else {
                                                            j = 0;
                                                        }
                                                        k = (this.e[this.f] & 0xF);
                                                        ++this.f;
                                                        --this.g;
                                                        final int n10 = i - 1;
                                                        this.U[k] = new int[64];
                                                        if (j != 0) {
                                                            for (i = 0; i < 64; ++i) {
                                                                j = be.c[i];
                                                                this.U[k][i] = ((this.e[j * 2 + this.f + 1] & 0xFF) | (this.e[this.f + j * 2] & 0xFF) << 8) * be.d[i];
                                                            }
                                                            this.f += 128;
                                                            this.g -= 128;
                                                            i = n10 - 128;
                                                        }
                                                        else {
                                                            for (i = 0; i < 64; ++i) {
                                                                j = be.c[i];
                                                                this.U[k][i] = (this.e[j + this.f] & 0xFF) * be.d[i];
                                                            }
                                                            this.f += 64;
                                                            this.g -= 64;
                                                            i = n10 - 64;
                                                        }
                                                    }
                                                    i = 0;
                                                }
                                            }
                                            continue;
                                        }
                                        case 221: {
                                            if (this.g < 4) {
                                                return this.g;
                                            }
                                            this.i = ((this.e[this.f + 2] & 0xFF) << 8 | (this.e[this.f + 3] & 0xFF));
                                            if (this.g < 6) {
                                                return this.g;
                                            }
                                            this.y = ((this.e[this.f + 4] & 0xFF) << 8 | (this.e[this.f + 5] & 0xFF));
                                            this.x = 0;
                                            this.f += 6;
                                            this.g -= 6;
                                            this.i -= 4;
                                            continue;
                                        }
                                        case 217: {
                                            this.f += 2;
                                            this.g -= 2;
                                            this.h = 6;
                                            continue;
                                        }
                                        case 0:
                                        case 255: {
                                            ++this.f;
                                            --this.g;
                                            continue;
                                        }
                                    }
                                }
                            }
                            return this.g;
                        }
                        this.h = 0;
                        return this.G << 16 | this.H;
                    }
                    case 3: {
                        if (this.g < this.k * 3) {
                            return this.g;
                        }
                        int n11;
                        int p5;
                        for (j = 0; j < this.k; ++j) {
                            this.l[j] = (this.e[this.f] & 0xFF);
                            n11 = (this.e[this.f + 1] & 0xFF);
                            k = (n11 & 0xF);
                            p5 = n11 >>> 4;
                            if (p5 > this.p) {
                                this.p = p5;
                            }
                            if (k > this.o) {
                                this.o = k;
                            }
                            this.n[j] = p5;
                            this.m[j] = k;
                            this.T[j] = (this.e[this.f + 2] & 0xFF);
                            this.f += 3;
                            this.g -= 3;
                            this.j -= 3;
                        }
                        if (this.j > 0) {
                            this.i = this.j;
                        }
                        for (j = 0; j < this.k; ++j) {
                            this.s[j] = ((this.G * this.n[j] + this.p - 1) / this.p + 7) / 8;
                            if (this.J == 0) {
                                this.E[j] = new byte[this.s[j] * 64 * this.m[j]];
                            }
                            else {
                                this.E[j] = new byte[this.m[j] * 64 * this.n[j]];
                            }
                        }
                        this.F = 0;
                        if (this.k > 1) {
                            this.q = this.p * 8 * ((this.G + this.p * 8 - 1) / (this.p * 8));
                            this.r = this.o * 8 * ((this.H + this.o * 8 - 1) / (this.o * 8));
                        }
                        this.h = 2;
                        continue;
                    }
                    case 5: {
                        while (this.h == 5) {
                            if (this.g < 2) {
                                return this.g;
                            }
                            if ((this.e[this.f] & 0xFF) == 0xFF && this.e[this.f + 1] != 0) {
                                if ((this.e[this.f + 1] & 0xFF) >= 208 && (this.e[this.f + 1] & 0xFF) <= 215) {
                                    this.h = 4;
                                    this.f += 2;
                                    this.g -= 2;
                                }
                                else {
                                    this.h = 2;
                                }
                            }
                            else {
                                ++this.f;
                                --this.g;
                            }
                        }
                        break;
                    }
                    case 4: {
                        final short[] array4 = new short[64];
                        if (this.J != 0 && this.B == null) {
                            this.B = new int[this.o * this.p * 64];
                        }
                        do {
                            final int n12 = this.u[this.v];
                            for (i = 0; i < 64; ++i) {
                                array4[i] = 0;
                            }
                            final int g = this.g;
                            final int r = this.R;
                            final int s = this.S;
                            j = this.I(this.K[n12 * 2]);
                            Label_3120: {
                                if (j < 0) {
                                    this.f -= g - this.g;
                                    this.g = g;
                                    this.R = r;
                                    this.S = s;
                                }
                                else {
                                    i = this.Code(j);
                                    if (i < 0) {
                                        this.f -= g - this.g;
                                        this.g = g;
                                        this.R = r;
                                        this.S = s;
                                        j = i;
                                    }
                                    else {
                                        array4[0] = (short)(Code(j, i) + this.Q[n12]);
                                        final int n13 = this.K[n12 * 2 + 1];
                                        int n14;
                                        for (i = 1; i < 64; ++i) {
                                            j = this.I(n13);
                                            if (j < 0) {
                                                this.f -= g - this.g;
                                                this.g = g;
                                                this.R = r;
                                                this.S = s;
                                                break Label_3120;
                                            }
                                            n14 = (j & 0xF);
                                            k = j >> 4;
                                            if (n14 == 0) {
                                                if (k != 15) {
                                                    break;
                                                }
                                                i += k;
                                            }
                                            else {
                                                j = this.Code(n14);
                                                if (j < 0) {
                                                    this.f -= g - this.g;
                                                    this.g = g;
                                                    this.R = r;
                                                    this.S = s;
                                                    break Label_3120;
                                                }
                                                k += i;
                                                if ((i = k) >= 64) {
                                                    i = 63;
                                                }
                                                array4[i] = (short)Code(n14, j);
                                            }
                                        }
                                        this.Q[n12] = array4[0];
                                        j = 0;
                                    }
                                }
                            }
                            i = j;
                            if (j != 0) {
                                continue Label_0023;
                            }
                            j = this.z[n12] / (this.m[n12] * this.n[n12]);
                            i = this.z[n12] % (this.m[n12] * this.n[n12]);
                            j = j * this.n[n12] + i % this.n[n12];
                            if (j < this.s[n12]) {
                                if (this.J == 0) {
                                    i /= this.n[n12];
                                    k = this.s[n12];
                                    this.Code(n12, array4, this.E[n12], (j + i * k * 8) * 8, this.s[n12] * 8);
                                }
                                else {
                                    j = i / this.n[n12];
                                    k = this.n[n12];
                                    this.Code(n12, array4, this.E[n12], j * (k * 64) + i % this.n[n12] * 8, this.n[n12] * 8);
                                }
                            }
                            final int[] z = this.z;
                            ++z[n12];
                            --this.A;
                            if (this.A % this.D == 0 && this.J != 0) {
                                this.Code(true);
                                i = this.V;
                                j = this.G;
                                final int n15 = this.V / this.G;
                                k = this.J;
                                final int n16 = n15 >> this.J;
                                k = this.Code * n16 + (i % j >> k);
                                j = 0;
                                int n17;
                                for (i = 0; i < this.o * 8 >> this.J && i + n16 < this.I; ++i) {
                                    for (n17 = 0; n17 < this.W >> this.J; ++n17) {
                                        this.Z[k + n17] = this.B[(n17 << this.J) + j];
                                    }
                                    k += this.Code;
                                    j += this.p * 8 << this.J;
                                }
                                this.V = -1;
                            }
                            if (this.A == 0) {
                                if (this.J == 0) {
                                    this.Code(false);
                                }
                                ++this.F;
                                if ((this.t > 1 && this.F >= this.r / (this.o * 8)) || (this.t == 1 && this.F >= ((this.m[n12] * this.H + this.o - 1) / this.o + 7) / 8)) {
                                    this.h = 2;
                                    i = 0;
                                    continue Label_0023;
                                }
                                this.I();
                            }
                            ++this.w;
                            i = this.w;
                            j = this.m[n12];
                            if (i < this.n[n12] * j && this.t != 1) {
                                continue;
                            }
                            this.w = 0;
                            ++this.v;
                            if (this.v < this.t) {
                                continue;
                            }
                            this.v = 0;
                            ++this.x;
                        } while (this.x != this.y || this.y <= 0);
                        this.x = 0;
                        this.Z();
                        this.h = 5;
                        i = 0;
                        continue;
                    }
                    case 6: {
                        return 0;
                    }
                    case 0: {
                        if (this.g < 2) {
                            return this.g;
                        }
                        this.f += 2;
                        this.g -= 2;
                        this.h = 1;
                        break;
                    }
                }
                j = i;
            }
            i = j;
        }
        if ((j = i) == -2) {
            return this.g;
        }
        return j;
    }
}
