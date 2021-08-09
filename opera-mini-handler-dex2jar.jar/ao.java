import java.io.InputStream;
import java.io.DataInputStream;
import java.util.Hashtable;

// 
// Decompiled by Procyon v0.6-prerelease
// 

final class ao implements Runnable
{
    private static Hashtable B;
    private static String j;
    private static int k;
    private by C;
    private String Code;
    private String I;
    private String J;
    private int Z;
    private ah a;
    private int b;
    private int c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private Thread[] i;
    
    static {
        ao.B = new Hashtable();
        ao.j = "-";
    }
    
    private ao(final int z, final String j) {
        this.b = 0;
        this.c = -1;
        this.d = 0;
        this.e = false;
        this.f = true;
        this.i = new Thread[2];
        ao.B.put(new Integer(z), this);
        this.Z = z;
        this.J = j;
    }
    
    private void C() {
        synchronized (this.i) {
            this.i[0] = this.i[1];
            this.i[1] = null;
        }
    }
    
    private int Code(final DataInputStream dataInputStream) {
        int n;
        byte[] array;
        for (n = 4, array = new byte[4]; dataInputStream != null && !this.h && n > 0; n -= dataInputStream.read(array, 4 - n, n)) {}
        return q.J(array, 0);
    }
    
    public static int Code(final String s) {
        synchronized (ao.class) {
            final int n = ++ao.k;
            new ao(n, s);
            return n;
        }
    }
    
    public static ao Code(final int n) {
        return ao.B.get(new Integer(n));
    }
    
    public static String Code() {
        return ao.j;
    }
    
    private static boolean I(final int n) {
        return n < 0 && (0xFFFF & n) == 0x0;
    }
    
    private void Z(final int n) {
        try {
            u.I.h();
            u.Z.c(this.Z);
            u.Z.c(n);
            u.I.Z(35);
            cg.Z();
        }
        catch (Throwable t) {}
    }
    
    private void a() {
        cg.Code(new Runnable() {
            @Override
            public final void run() {
                ao.this.b();
            }
        });
    }
    
    private void b() {
        switch (this.b) {
            default: {}
            case 1: {
                this.Z(1);
            }
            case 2:
            case 3: {
                this.Z(3);
            }
            case 4: {
                if (this.d == this.c) {
                    this.Z(2);
                    return;
                }
                this.Z(0);
            }
        }
    }
    
    private void c() {
        this.b = 1;
        this.e();
    }
    
    private void d() {
        this.d = 0;
        this.b = 3;
        this.e();
    }
    
    private void e() {
        this.g = true;
        this.h = true;
        this.f();
    }
    
    private void f() {
        if (this.C != null) {
            cg.Code(this.C);
            this.C = null;
        }
        if (this.a == null) {
            return;
        }
        while (true) {
            try {
                this.a.Code();
                this.a = null;
            }
            catch (Throwable t) {
                continue;
            }
            break;
        }
    }
    
    public final int B() {
        return this.d;
    }
    
    public final void Code(final String code, final String i, final boolean b) {
        final boolean b2 = true;
        this.Code = code;
        this.I = i;
        while (true) {
            Label_0112: {
                if (b) {
                    break Label_0112;
                }
                final boolean f = b2;
                this.f = f;
                this.g = false;
                synchronized (this.i) {
                    if (this.i[0] == null) {
                        (this.i[0] = new Thread(this)).start();
                    }
                    else if (this.i[1] == null) {
                        (this.i[1] = new Thread(this)).start();
                    }
                    return;
                }
            }
            final boolean f = false;
            continue;
        }
    }
    
    public final void I() {
        this.c();
        this.a();
    }
    
    public final void I(final String s, final String s2, final boolean b) {
        this.b = 4;
        this.Code(s, s2, b);
        this.a();
    }
    
    public final void J() {
        this.e = false;
        u.c.Z(this.J);
    }
    
    public final void Z() {
        this.d = 0;
        this.b = 2;
        this.e();
        this.a();
    }
    
    @Override
    public final void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: ldc             "-"
        //     4: putstatic       ao.j:Ljava/lang/String;
        //     7: aconst_null    
        //     8: astore          9
        //    10: aconst_null    
        //    11: astore          13
        //    13: aconst_null    
        //    14: astore          12
        //    16: aconst_null    
        //    17: astore          14
        //    19: aconst_null    
        //    20: astore          15
        //    22: aconst_null    
        //    23: astore          11
        //    25: aload_0        
        //    26: getfield        ao.g:Z
        //    29: istore          8
        //    31: iload           8
        //    33: ifeq            70
        //    36: aload_0        
        //    37: invokespecial   ao.b:()V
        //    40: aconst_null    
        //    41: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //    44: aconst_null    
        //    45: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //    48: aload_0        
        //    49: invokespecial   ao.f:()V
        //    52: aload_0        
        //    53: getfield        ao.e:Z
        //    56: ifne            63
        //    59: aload_0        
        //    60: invokevirtual   ao.J:()V
        //    63: aload_0        
        //    64: invokespecial   ao.C:()V
        //    67: aload_0        
        //    68: monitorexit    
        //    69: return         
        //    70: aload_0        
        //    71: iconst_0       
        //    72: putfield        ao.h:Z
        //    75: aload_0        
        //    76: iconst_1       
        //    77: putfield        ao.e:Z
        //    80: getstatic       u.c:Lap;
        //    83: aload_0        
        //    84: getfield        ao.J:Ljava/lang/String;
        //    87: iconst_1       
        //    88: iconst_3       
        //    89: invokevirtual   ap.Code:(Ljava/lang/String;ZI)Lar;
        //    92: astore          10
        //    94: aload           10
        //    96: astore          9
        //    98: aload_0        
        //    99: aload           9
        //   101: invokeinterface ar.I:()Ljava/lang/String;
        //   106: putfield        ao.J:Ljava/lang/String;
        //   109: iconst_0       
        //   110: istore_3       
        //   111: aload_0        
        //   112: iconst_0       
        //   113: putfield        ao.d:I
        //   116: aload_0        
        //   117: getfield        ao.b:I
        //   120: iconst_4       
        //   121: if_icmpne       142
        //   124: aload           9
        //   126: invokeinterface ar.Z:()J
        //   131: l2i            
        //   132: istore_3       
        //   133: aload_0        
        //   134: iload_3        
        //   135: putfield        ao.d:I
        //   138: aload_0        
        //   139: invokespecial   ao.b:()V
        //   142: aload           9
        //   144: iload_3        
        //   145: i2l            
        //   146: invokeinterface ar.Code:(J)Ljava/io/OutputStream;
        //   151: astore          10
        //   153: aload           10
        //   155: astore          11
        //   157: aload           14
        //   159: astore          13
        //   161: aload           15
        //   163: astore          12
        //   165: aload_0        
        //   166: iconst_4       
        //   167: putfield        ao.b:I
        //   170: aload           14
        //   172: astore          13
        //   174: aload           15
        //   176: astore          12
        //   178: aload_0        
        //   179: invokespecial   ao.b:()V
        //   182: iconst_m1      
        //   183: istore_2       
        //   184: iconst_0       
        //   185: istore          4
        //   187: iconst_1       
        //   188: istore          7
        //   190: iconst_1       
        //   191: istore          6
        //   193: iconst_1       
        //   194: istore          5
        //   196: aload           14
        //   198: astore          13
        //   200: aload           15
        //   202: astore          12
        //   204: aload_0        
        //   205: getfield        ao.h:Z
        //   208: ifne            1380
        //   211: aload           14
        //   213: astore          13
        //   215: aload           15
        //   217: astore          12
        //   219: aload_0        
        //   220: invokespecial   ao.f:()V
        //   223: aload           14
        //   225: astore          13
        //   227: aload           15
        //   229: astore          12
        //   231: aload_0        
        //   232: getfield        ao.f:Z
        //   235: ifeq            560
        //   238: aload           14
        //   240: astore          13
        //   242: aload           15
        //   244: astore          12
        //   246: ldc             "NB"
        //   248: putstatic       ao.j:Ljava/lang/String;
        //   251: aload           14
        //   253: astore          13
        //   255: aload           15
        //   257: astore          12
        //   259: getstatic       u.Code:Lbn;
        //   262: astore          16
        //   264: aload           14
        //   266: astore          13
        //   268: aload           15
        //   270: astore          12
        //   272: aload_0        
        //   273: getfield        ao.Code:Ljava/lang/String;
        //   276: aload_0        
        //   277: getfield        ao.Code:Ljava/lang/String;
        //   280: iconst_0       
        //   281: invokestatic    cg.Code:(Ljava/lang/String;Z)Ljava/lang/String;
        //   284: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   287: ifeq            543
        //   290: aload           14
        //   292: astore          13
        //   294: aload           15
        //   296: astore          12
        //   298: aload_0        
        //   299: getfield        ao.Code:Ljava/lang/String;
        //   302: iconst_1       
        //   303: invokestatic    cg.Code:(Ljava/lang/String;Z)Ljava/lang/String;
        //   306: astore          10
        //   308: aload           14
        //   310: astore          13
        //   312: aload           15
        //   314: astore          12
        //   316: aload_0        
        //   317: aload           16
        //   319: aload           10
        //   321: aconst_null    
        //   322: ldc             "GET"
        //   324: invokeinterface bn.Code:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lah;
        //   329: putfield        ao.a:Lah;
        //   332: iload_3        
        //   333: ifle            376
        //   336: aload           14
        //   338: astore          13
        //   340: aload           15
        //   342: astore          12
        //   344: aload_0        
        //   345: getfield        ao.a:Lah;
        //   348: ldc             "Range"
        //   350: new             Ljava/lang/StringBuilder;
        //   353: dup            
        //   354: ldc             "bytes="
        //   356: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   359: iload_3        
        //   360: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   363: ldc             "-"
        //   365: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   368: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   371: invokeinterface ah.Code:(Ljava/lang/String;Ljava/lang/String;)V
        //   376: aload           14
        //   378: astore          13
        //   380: aload           15
        //   382: astore          12
        //   384: aload_0        
        //   385: getfield        ao.a:Lah;
        //   388: invokeinterface ah.J:()I
        //   393: istore          4
        //   395: iload_3        
        //   396: ifne            1420
        //   399: sipush          200
        //   402: istore_1       
        //   403: goto            1394
        //   406: aload           14
        //   408: astore          13
        //   410: aload           15
        //   412: astore          12
        //   414: aload_0        
        //   415: getfield        ao.a:Lah;
        //   418: invokeinterface ah.Z:()Ljava/io/DataInputStream;
        //   423: astore          10
        //   425: aload           10
        //   427: astore          13
        //   429: aload           10
        //   431: astore          12
        //   433: aload_0        
        //   434: getfield        ao.a:Lah;
        //   437: invokeinterface ah.B:()J
        //   442: lconst_0       
        //   443: lcmp           
        //   444: iflt            1405
        //   447: aload           10
        //   449: astore          13
        //   451: aload           10
        //   453: astore          12
        //   455: aload_0        
        //   456: getfield        ao.a:Lah;
        //   459: invokeinterface ah.B:()J
        //   464: l2i            
        //   465: iload_3        
        //   466: iadd           
        //   467: istore_2       
        //   468: goto            1405
        //   471: iload           4
        //   473: ifeq            765
        //   476: aload           10
        //   478: astore          13
        //   480: aload           10
        //   482: astore          12
        //   484: aload_0        
        //   485: invokespecial   ao.d:()V
        //   488: aload_0        
        //   489: invokespecial   ao.b:()V
        //   492: aload           11
        //   494: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //   497: aload           10
        //   499: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   502: aload           9
        //   504: ifnull          514
        //   507: aload           9
        //   509: invokeinterface ar.C:()V
        //   514: aload_0        
        //   515: invokespecial   ao.f:()V
        //   518: aload_0        
        //   519: getfield        ao.e:Z
        //   522: ifne            529
        //   525: aload_0        
        //   526: invokevirtual   ao.J:()V
        //   529: aload_0        
        //   530: invokespecial   ao.C:()V
        //   533: goto            67
        //   536: astore          9
        //   538: aload_0        
        //   539: monitorexit    
        //   540: aload           9
        //   542: athrow         
        //   543: aload           14
        //   545: astore          13
        //   547: aload           15
        //   549: astore          12
        //   551: aload_0        
        //   552: getfield        ao.Code:Ljava/lang/String;
        //   555: astore          10
        //   557: goto            308
        //   560: aload           14
        //   562: astore          13
        //   564: aload           15
        //   566: astore          12
        //   568: bipush          127
        //   570: anewarray       Ljava/lang/Object;
        //   573: astore          10
        //   575: aload           14
        //   577: astore          13
        //   579: aload           15
        //   581: astore          12
        //   583: bipush          127
        //   585: newarray        I
        //   587: astore          16
        //   589: aload           16
        //   591: bipush          29
        //   593: iconst_2       
        //   594: iastore        
        //   595: aload           16
        //   597: bipush          37
        //   599: iload_3        
        //   600: iastore        
        //   601: aload           16
        //   603: bipush          43
        //   605: aload           16
        //   607: bipush          43
        //   609: iaload         
        //   610: ldc             16777216
        //   612: ior            
        //   613: iastore        
        //   614: aload           14
        //   616: astore          13
        //   618: aload           15
        //   620: astore          12
        //   622: aload           10
        //   624: bipush          53
        //   626: aload_0        
        //   627: getfield        ao.Code:Ljava/lang/String;
        //   630: aastore        
        //   631: aload           14
        //   633: astore          13
        //   635: aload           15
        //   637: astore          12
        //   639: invokestatic    cg.J:()V
        //   642: aload           14
        //   644: astore          13
        //   646: aload           15
        //   648: astore          12
        //   650: aload_0        
        //   651: aload           10
        //   653: aload           16
        //   655: aload_0        
        //   656: getfield        ao.I:Ljava/lang/String;
        //   659: aconst_null    
        //   660: invokestatic    ce.Code:(Ljava/lang/String;Ljava/lang/String;)I
        //   663: iconst_1       
        //   664: invokestatic    bx.Code:([Ljava/lang/Object;[IIZ)Lby;
        //   667: putfield        ao.C:Lby;
        //   670: aload           14
        //   672: astore          13
        //   674: aload           15
        //   676: astore          12
        //   678: new             Ljava/io/DataInputStream;
        //   681: dup            
        //   682: aload_0        
        //   683: getfield        ao.C:Lby;
        //   686: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //   689: astore          10
        //   691: aload_0        
        //   692: aload           10
        //   694: invokespecial   ao.Code:(Ljava/io/DataInputStream;)I
        //   697: istore_3       
        //   698: iload_3        
        //   699: ifgt            1372
        //   702: iload_3        
        //   703: invokestatic    ao.I:(I)Z
        //   706: ifeq            1471
        //   709: ldc             16777216
        //   711: iload_3        
        //   712: iand           
        //   713: ifne            1432
        //   716: ldc_w           1073741824
        //   719: iload_3        
        //   720: iand           
        //   721: ifne            1450
        //   724: goto            1432
        //   727: aload           12
        //   729: putstatic       ao.j:Ljava/lang/String;
        //   732: iload           4
        //   734: istore          5
        //   736: iload_1        
        //   737: istore          4
        //   739: iload           5
        //   741: istore_1       
        //   742: goto            471
        //   745: aload_0        
        //   746: aload           10
        //   748: invokespecial   ao.Code:(Ljava/io/DataInputStream;)I
        //   751: istore_3       
        //   752: iconst_0       
        //   753: istore_1       
        //   754: goto            1437
        //   757: ldc_w           "B"
        //   760: astore          12
        //   762: goto            727
        //   765: iload_1        
        //   766: istore          4
        //   768: iload_3        
        //   769: istore_1       
        //   770: iload           4
        //   772: ifne            795
        //   775: aload_0        
        //   776: getfield        ao.c:I
        //   779: iconst_m1      
        //   780: if_icmpeq       912
        //   783: iload_1        
        //   784: aload_0        
        //   785: getfield        ao.c:I
        //   788: if_icmpeq       912
        //   791: aload_0        
        //   792: invokespecial   ao.d:()V
        //   795: getstatic       cg.A:I
        //   798: newarray        B
        //   800: astore          12
        //   802: aload_0        
        //   803: invokespecial   ao.b:()V
        //   806: aload_0        
        //   807: getfield        ao.h:Z
        //   810: ifne            859
        //   813: iload_1        
        //   814: istore_3       
        //   815: iload_1        
        //   816: ifeq            1485
        //   819: iload_1        
        //   820: iconst_m1      
        //   821: if_icmpne       1051
        //   824: sipush          512
        //   827: istore_3       
        //   828: aload           10
        //   830: aload           12
        //   832: iconst_0       
        //   833: iload_3        
        //   834: invokevirtual   java/io/DataInputStream.read:([BII)I
        //   837: istore_3       
        //   838: iload_3        
        //   839: iconst_m1      
        //   840: if_icmpne       1062
        //   843: aload_0        
        //   844: getfield        ao.c:I
        //   847: iconst_m1      
        //   848: if_icmpne       859
        //   851: aload_0        
        //   852: aload_0        
        //   853: getfield        ao.d:I
        //   856: putfield        ao.c:I
        //   859: aload           11
        //   861: invokevirtual   java/io/OutputStream.flush:()V
        //   864: aload_0        
        //   865: invokespecial   ao.b:()V
        //   868: aload           11
        //   870: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //   873: aload           10
        //   875: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   878: aload           9
        //   880: ifnull          890
        //   883: aload           9
        //   885: invokeinterface ar.C:()V
        //   890: aload_0        
        //   891: invokespecial   ao.f:()V
        //   894: aload_0        
        //   895: getfield        ao.e:Z
        //   898: ifne            905
        //   901: aload_0        
        //   902: invokevirtual   ao.J:()V
        //   905: aload_0        
        //   906: invokespecial   ao.C:()V
        //   909: goto            67
        //   912: aload_0        
        //   913: iload_1        
        //   914: putfield        ao.c:I
        //   917: goto            795
        //   920: astore          13
        //   922: aload           11
        //   924: astore          12
        //   926: aload           10
        //   928: astore          11
        //   930: aload           13
        //   932: astore          10
        //   934: aload_0        
        //   935: getfield        ao.b:I
        //   938: iconst_1       
        //   939: if_icmpeq       1003
        //   942: aload_0        
        //   943: getfield        ao.b:I
        //   946: iconst_2       
        //   947: if_icmpeq       1003
        //   950: aload_0        
        //   951: getfield        ao.h:Z
        //   954: ifne            1003
        //   957: aload_0        
        //   958: getfield        ao.d:I
        //   961: aload_0        
        //   962: getfield        ao.c:I
        //   965: if_icmplt       976
        //   968: aload_0        
        //   969: getfield        ao.c:I
        //   972: iconst_m1      
        //   973: if_icmpne       1003
        //   976: aload           10
        //   978: instanceof      Ljava/io/IOException;
        //   981: ifeq            1239
        //   984: getstatic       u.Code:Lbn;
        //   987: invokeinterface bn.ap:()Z
        //   992: ifeq            1239
        //   995: aload_0        
        //   996: invokespecial   ao.c:()V
        //   999: aload_0        
        //  1000: invokespecial   ao.b:()V
        //  1003: aload_0        
        //  1004: invokespecial   ao.b:()V
        //  1007: aload           12
        //  1009: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //  1012: aload           11
        //  1014: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //  1017: aload           9
        //  1019: ifnull          1029
        //  1022: aload           9
        //  1024: invokeinterface ar.C:()V
        //  1029: aload_0        
        //  1030: invokespecial   ao.f:()V
        //  1033: aload_0        
        //  1034: getfield        ao.e:Z
        //  1037: ifne            1044
        //  1040: aload_0        
        //  1041: invokevirtual   ao.J:()V
        //  1044: aload_0        
        //  1045: invokespecial   ao.C:()V
        //  1048: goto            67
        //  1051: iload_1        
        //  1052: sipush          512
        //  1055: invokestatic    java/lang/Math.min:(II)I
        //  1058: istore_3       
        //  1059: goto            828
        //  1062: aload           11
        //  1064: aload           12
        //  1066: iconst_0       
        //  1067: iload_3        
        //  1068: invokevirtual   java/io/OutputStream.write:([BII)V
        //  1071: aload_0        
        //  1072: aload_0        
        //  1073: getfield        ao.d:I
        //  1076: iload_3        
        //  1077: iadd           
        //  1078: putfield        ao.d:I
        //  1081: iload_1        
        //  1082: ifle            1369
        //  1085: iload_1        
        //  1086: iload_3        
        //  1087: isub           
        //  1088: istore_1       
        //  1089: lconst_0       
        //  1090: iload_3        
        //  1091: i2l            
        //  1092: iload_3        
        //  1093: i2l            
        //  1094: invokestatic    cg.Code:(JJJ)V
        //  1097: iload           4
        //  1099: ifne            1483
        //  1102: aload_0        
        //  1103: getfield        ao.d:I
        //  1106: aload_0        
        //  1107: getfield        ao.c:I
        //  1110: if_icmpeq       859
        //  1113: goto            1483
        //  1116: aload_0        
        //  1117: aload_0        
        //  1118: getfield        ao.d:I
        //  1121: putfield        ao.c:I
        //  1124: goto            859
        //  1127: astore          13
        //  1129: aload           10
        //  1131: astore          12
        //  1133: aload           13
        //  1135: astore          10
        //  1137: aload_0        
        //  1138: invokespecial   ao.b:()V
        //  1141: aload           11
        //  1143: invokestatic    cg.Code:(Ljava/io/OutputStream;)V
        //  1146: aload           12
        //  1148: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //  1151: aload           9
        //  1153: ifnull          1163
        //  1156: aload           9
        //  1158: invokeinterface ar.C:()V
        //  1163: aload_0        
        //  1164: invokespecial   ao.f:()V
        //  1167: aload_0        
        //  1168: getfield        ao.e:Z
        //  1171: ifne            1178
        //  1174: aload_0        
        //  1175: invokevirtual   ao.J:()V
        //  1178: aload_0        
        //  1179: invokespecial   ao.C:()V
        //  1182: aload           10
        //  1184: athrow         
        //  1185: aload_0        
        //  1186: aload           10
        //  1188: invokespecial   ao.Code:(Ljava/io/DataInputStream;)I
        //  1191: istore_1       
        //  1192: iload_1        
        //  1193: invokestatic    ao.I:(I)Z
        //  1196: ifeq            1214
        //  1199: ldc_w           536870912
        //  1202: iload_1        
        //  1203: iand           
        //  1204: ifeq            1214
        //  1207: ldc             16777216
        //  1209: iload_1        
        //  1210: iand           
        //  1211: ifeq            1501
        //  1214: aload_0        
        //  1215: invokespecial   ao.d:()V
        //  1218: goto            859
        //  1221: aload_0        
        //  1222: aload           10
        //  1224: invokespecial   ao.Code:(Ljava/io/DataInputStream;)I
        //  1227: istore_1       
        //  1228: invokestatic    java/lang/Thread.yield:()V
        //  1231: goto            806
        //  1234: iconst_0       
        //  1235: istore_2       
        //  1236: goto            1221
        //  1239: aload_0        
        //  1240: invokevirtual   ao.Z:()V
        //  1243: goto            1003
        //  1246: astore          10
        //  1248: aload           12
        //  1250: astore          13
        //  1252: aload           11
        //  1254: astore          12
        //  1256: aload           13
        //  1258: astore          11
        //  1260: goto            1137
        //  1263: astore          10
        //  1265: aconst_null    
        //  1266: astore          11
        //  1268: aconst_null    
        //  1269: astore          9
        //  1271: goto            1137
        //  1274: astore          10
        //  1276: aconst_null    
        //  1277: astore          11
        //  1279: goto            1137
        //  1282: astore          10
        //  1284: aload           13
        //  1286: astore          12
        //  1288: goto            1137
        //  1291: astore          13
        //  1293: aload           10
        //  1295: astore          12
        //  1297: aload           13
        //  1299: astore          10
        //  1301: goto            1137
        //  1304: astore          10
        //  1306: aload           13
        //  1308: astore          12
        //  1310: goto            934
        //  1313: astore          10
        //  1315: aload           13
        //  1317: astore          12
        //  1319: goto            934
        //  1322: astore          10
        //  1324: aload           11
        //  1326: astore          13
        //  1328: aload           12
        //  1330: astore          11
        //  1332: aload           13
        //  1334: astore          12
        //  1336: goto            934
        //  1339: astore          14
        //  1341: aload           10
        //  1343: astore          12
        //  1345: aload           11
        //  1347: astore          13
        //  1349: aload           14
        //  1351: astore          10
        //  1353: aload           12
        //  1355: astore          11
        //  1357: aload           13
        //  1359: astore          12
        //  1361: goto            934
        //  1364: iload_3        
        //  1365: istore_1       
        //  1366: goto            1228
        //  1369: goto            1089
        //  1372: iconst_0       
        //  1373: istore_1       
        //  1374: iload           6
        //  1376: istore_2       
        //  1377: goto            1437
        //  1380: iconst_0       
        //  1381: istore          4
        //  1383: aconst_null    
        //  1384: astore          10
        //  1386: iload_2        
        //  1387: istore_1       
        //  1388: iload           7
        //  1390: istore_2       
        //  1391: goto            770
        //  1394: iload           4
        //  1396: iload_1        
        //  1397: if_icmpeq       1427
        //  1400: iconst_1       
        //  1401: istore_1       
        //  1402: goto            406
        //  1405: iconst_0       
        //  1406: istore_3       
        //  1407: iload_1        
        //  1408: istore          4
        //  1410: iload_3        
        //  1411: istore_1       
        //  1412: iload_2        
        //  1413: istore_3       
        //  1414: iload           5
        //  1416: istore_2       
        //  1417: goto            471
        //  1420: sipush          206
        //  1423: istore_1       
        //  1424: goto            1394
        //  1427: iconst_0       
        //  1428: istore_1       
        //  1429: goto            406
        //  1432: iconst_1       
        //  1433: istore_1       
        //  1434: iload           6
        //  1436: istore_2       
        //  1437: iload           4
        //  1439: ifeq            757
        //  1442: ldc_w           "BS"
        //  1445: astore          12
        //  1447: goto            727
        //  1450: iconst_1       
        //  1451: istore          4
        //  1453: ldc_w           268435456
        //  1456: iload_3        
        //  1457: iand           
        //  1458: ifeq            1466
        //  1461: iconst_1       
        //  1462: istore_2       
        //  1463: goto            745
        //  1466: iconst_0       
        //  1467: istore_2       
        //  1468: goto            745
        //  1471: iload_3        
        //  1472: ifge            1372
        //  1475: iconst_1       
        //  1476: istore_1       
        //  1477: iload           6
        //  1479: istore_2       
        //  1480: goto            1437
        //  1483: iload_1        
        //  1484: istore_3       
        //  1485: iload_3        
        //  1486: ifne            1364
        //  1489: iload_2        
        //  1490: ifne            1116
        //  1493: iload           4
        //  1495: ifne            1185
        //  1498: goto            1116
        //  1501: iload_1        
        //  1502: ldc_w           268435456
        //  1505: iand           
        //  1506: ifeq            1234
        //  1509: iconst_1       
        //  1510: istore_2       
        //  1511: goto            1221
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      7      536    543    Any
        //  25     31     1304   1313   Ljava/lang/Throwable;
        //  25     31     1263   1274   Any
        //  36     63     536    543    Any
        //  63     67     536    543    Any
        //  70     94     1304   1313   Ljava/lang/Throwable;
        //  70     94     1263   1274   Any
        //  98     109    1313   1322   Ljava/lang/Throwable;
        //  98     109    1274   1282   Any
        //  111    116    1313   1322   Ljava/lang/Throwable;
        //  111    116    1274   1282   Any
        //  116    142    1313   1322   Ljava/lang/Throwable;
        //  116    142    1274   1282   Any
        //  142    153    1313   1322   Ljava/lang/Throwable;
        //  142    153    1274   1282   Any
        //  165    170    1322   1339   Ljava/lang/Throwable;
        //  165    170    1282   1291   Any
        //  178    182    1322   1339   Ljava/lang/Throwable;
        //  178    182    1282   1291   Any
        //  204    211    1322   1339   Ljava/lang/Throwable;
        //  204    211    1282   1291   Any
        //  219    223    1322   1339   Ljava/lang/Throwable;
        //  219    223    1282   1291   Any
        //  231    238    1322   1339   Ljava/lang/Throwable;
        //  231    238    1282   1291   Any
        //  246    251    1322   1339   Ljava/lang/Throwable;
        //  246    251    1282   1291   Any
        //  259    264    1322   1339   Ljava/lang/Throwable;
        //  259    264    1282   1291   Any
        //  272    290    1322   1339   Ljava/lang/Throwable;
        //  272    290    1282   1291   Any
        //  298    308    1322   1339   Ljava/lang/Throwable;
        //  298    308    1282   1291   Any
        //  316    332    1322   1339   Ljava/lang/Throwable;
        //  316    332    1282   1291   Any
        //  344    376    1322   1339   Ljava/lang/Throwable;
        //  344    376    1282   1291   Any
        //  384    395    1322   1339   Ljava/lang/Throwable;
        //  384    395    1282   1291   Any
        //  414    425    1322   1339   Ljava/lang/Throwable;
        //  414    425    1282   1291   Any
        //  433    447    1322   1339   Ljava/lang/Throwable;
        //  433    447    1282   1291   Any
        //  455    468    1322   1339   Ljava/lang/Throwable;
        //  455    468    1282   1291   Any
        //  484    488    1322   1339   Ljava/lang/Throwable;
        //  484    488    1282   1291   Any
        //  488    502    536    543    Any
        //  507    514    536    543    Any
        //  514    529    536    543    Any
        //  529    533    536    543    Any
        //  551    557    1322   1339   Ljava/lang/Throwable;
        //  551    557    1282   1291   Any
        //  568    575    1322   1339   Ljava/lang/Throwable;
        //  568    575    1282   1291   Any
        //  583    589    1322   1339   Ljava/lang/Throwable;
        //  583    589    1282   1291   Any
        //  622    631    1322   1339   Ljava/lang/Throwable;
        //  622    631    1282   1291   Any
        //  639    642    1322   1339   Ljava/lang/Throwable;
        //  639    642    1282   1291   Any
        //  650    670    1322   1339   Ljava/lang/Throwable;
        //  650    670    1282   1291   Any
        //  678    691    1322   1339   Ljava/lang/Throwable;
        //  678    691    1282   1291   Any
        //  691    698    1339   1364   Ljava/lang/Throwable;
        //  691    698    1291   1304   Any
        //  702    709    1339   1364   Ljava/lang/Throwable;
        //  702    709    1291   1304   Any
        //  727    732    1339   1364   Ljava/lang/Throwable;
        //  727    732    1291   1304   Any
        //  745    752    1339   1364   Ljava/lang/Throwable;
        //  745    752    1291   1304   Any
        //  775    795    920    934    Ljava/lang/Throwable;
        //  775    795    1127   1137   Any
        //  795    806    920    934    Ljava/lang/Throwable;
        //  795    806    1127   1137   Any
        //  806    813    920    934    Ljava/lang/Throwable;
        //  806    813    1127   1137   Any
        //  828    838    920    934    Ljava/lang/Throwable;
        //  828    838    1127   1137   Any
        //  843    859    920    934    Ljava/lang/Throwable;
        //  843    859    1127   1137   Any
        //  859    864    920    934    Ljava/lang/Throwable;
        //  859    864    1127   1137   Any
        //  864    878    536    543    Any
        //  883    890    536    543    Any
        //  890    905    536    543    Any
        //  905    909    536    543    Any
        //  912    917    920    934    Ljava/lang/Throwable;
        //  912    917    1127   1137   Any
        //  934    976    1246   1263   Any
        //  976    1003   1246   1263   Any
        //  1003   1017   536    543    Any
        //  1022   1029   536    543    Any
        //  1029   1044   536    543    Any
        //  1044   1048   536    543    Any
        //  1051   1059   920    934    Ljava/lang/Throwable;
        //  1051   1059   1127   1137   Any
        //  1062   1081   920    934    Ljava/lang/Throwable;
        //  1062   1081   1127   1137   Any
        //  1089   1097   920    934    Ljava/lang/Throwable;
        //  1089   1097   1127   1137   Any
        //  1102   1113   920    934    Ljava/lang/Throwable;
        //  1102   1113   1127   1137   Any
        //  1116   1124   920    934    Ljava/lang/Throwable;
        //  1116   1124   1127   1137   Any
        //  1137   1151   536    543    Any
        //  1156   1163   536    543    Any
        //  1163   1178   536    543    Any
        //  1178   1185   536    543    Any
        //  1185   1199   920    934    Ljava/lang/Throwable;
        //  1185   1199   1127   1137   Any
        //  1214   1218   920    934    Ljava/lang/Throwable;
        //  1214   1218   1127   1137   Any
        //  1221   1228   920    934    Ljava/lang/Throwable;
        //  1221   1228   1127   1137   Any
        //  1228   1231   920    934    Ljava/lang/Throwable;
        //  1228   1231   1127   1137   Any
        //  1239   1243   1246   1263   Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 749, Size: 749
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
}
