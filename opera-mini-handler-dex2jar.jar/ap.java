// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class ap
{
    private int B;
    private int C;
    private String Code;
    private String I;
    private Object[] J;
    private as Z;
    private at[] a;
    
    public ap(final as z) {
        this.J = null;
        this.B = 0;
        this.C = 0;
        this.a = new at[10];
        this.Z = z;
    }
    
    private Object[] C(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_3       
        //     2: aconst_null    
        //     3: astore          4
        //     5: iload_1        
        //     6: aload_0        
        //     7: getfield        ap.B:I
        //    10: if_icmpne       22
        //    13: aload_0        
        //    14: getfield        ap.J:[Ljava/lang/Object;
        //    17: astore          4
        //    19: aload           4
        //    21: areturn        
        //    22: iload_2        
        //    23: invokestatic    ap.Code:(I)Z
        //    26: ifeq            19
        //    29: aload_0        
        //    30: iload_1        
        //    31: putfield        ap.B:I
        //    34: aload_0        
        //    35: aconst_null    
        //    36: putfield        ap.J:[Ljava/lang/Object;
        //    39: aload_0        
        //    40: iload_1        
        //    41: iload_2        
        //    42: invokevirtual   ap.Code:(II)Ljava/lang/String;
        //    45: astore          4
        //    47: aload_0        
        //    48: getfield        ap.Z:Las;
        //    51: aload           4
        //    53: iconst_0       
        //    54: iconst_1       
        //    55: invokeinterface as.Code:(Ljava/lang/String;ZI)Lar;
        //    60: astore          4
        //    62: aload           4
        //    64: invokeinterface ar.Code:()Ljava/io/InputStream;
        //    69: astore          5
        //    71: new             Ljava/io/DataInputStream;
        //    74: dup            
        //    75: aload           5
        //    77: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    80: astore          7
        //    82: iconst_4       
        //    83: newarray        B
        //    85: astore          6
        //    87: iload_3        
        //    88: istore_1       
        //    89: iload_1        
        //    90: aload           7
        //    92: aload           6
        //    94: iload_1        
        //    95: iconst_4       
        //    96: iload_1        
        //    97: isub           
        //    98: invokevirtual   java/io/DataInputStream.read:([BII)I
        //   101: iadd           
        //   102: istore_3       
        //   103: iload_3        
        //   104: istore_1       
        //   105: iload_3        
        //   106: iconst_4       
        //   107: if_icmplt       89
        //   110: aload           6
        //   112: iconst_0       
        //   113: invokestatic    r.J:([BI)I
        //   116: istore_1       
        //   117: iload_1        
        //   118: ldc             47404304
        //   120: if_icmpeq       140
        //   123: aload           7
        //   125: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   128: aload           5
        //   130: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   133: aload           4
        //   135: invokestatic    cg.Code:(Lar;)V
        //   138: aconst_null    
        //   139: areturn        
        //   140: aload           7
        //   142: iconst_3       
        //   143: invokestatic    cg.Code:(Ljava/io/InputStream;I)V
        //   146: aload           7
        //   148: invokevirtual   java/io/DataInputStream.read:()I
        //   151: istore_1       
        //   152: iload_1        
        //   153: iload_2        
        //   154: if_icmpeq       174
        //   157: aload           7
        //   159: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   162: aload           5
        //   164: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   167: aload           4
        //   169: invokestatic    cg.Code:(Lar;)V
        //   172: aconst_null    
        //   173: areturn        
        //   174: iload_2        
        //   175: bipush          15
        //   177: if_icmpne       342
        //   180: bipush          10
        //   182: istore_1       
        //   183: aload           7
        //   185: iload_1        
        //   186: invokestatic    cg.Code:(Ljava/io/InputStream;I)V
        //   189: aload           7
        //   191: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //   194: astore          10
        //   196: aload           7
        //   198: invokevirtual   java/io/DataInputStream.readShort:()S
        //   201: istore_1       
        //   202: iload_1        
        //   203: newarray        B
        //   205: astore          6
        //   207: aload           7
        //   209: aload           6
        //   211: iconst_0       
        //   212: iload_1        
        //   213: invokevirtual   java/io/DataInputStream.readFully:([BII)V
        //   216: iload_1        
        //   217: ifne            484
        //   220: aconst_null    
        //   221: astore          6
        //   223: aload           7
        //   225: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //   228: astore          9
        //   230: aload           7
        //   232: invokevirtual   java/io/DataInputStream.readUTF:()Ljava/lang/String;
        //   235: astore          8
        //   237: aload           8
        //   239: ifnull          481
        //   242: aload           8
        //   244: invokevirtual   java/lang/String.length:()I
        //   247: ifle            481
        //   250: aload           8
        //   252: iconst_0       
        //   253: invokevirtual   java/lang/String.charAt:(I)C
        //   256: ifne            481
        //   259: new             Ljava/lang/StringBuilder;
        //   262: dup            
        //   263: invokespecial   java/lang/StringBuilder.<init>:()V
        //   266: aload           9
        //   268: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   271: aload           8
        //   273: iconst_1       
        //   274: aload           8
        //   276: invokevirtual   java/lang/String.length:()I
        //   279: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   282: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   285: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   288: astore          8
        //   290: iconst_3       
        //   291: anewarray       Ljava/lang/Object;
        //   294: astore          9
        //   296: aload           9
        //   298: iconst_0       
        //   299: aload           10
        //   301: aastore        
        //   302: aload           9
        //   304: iconst_1       
        //   305: aload           8
        //   307: aastore        
        //   308: aload           9
        //   310: iconst_2       
        //   311: aload           6
        //   313: aastore        
        //   314: aload           7
        //   316: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   319: aload           5
        //   321: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   324: aload           4
        //   326: invokestatic    cg.Code:(Lar;)V
        //   329: aload           9
        //   331: astore          4
        //   333: aload_0        
        //   334: aload           4
        //   336: putfield        ap.J:[Ljava/lang/Object;
        //   339: aload           4
        //   341: areturn        
        //   342: bipush          7
        //   344: istore_1       
        //   345: goto            183
        //   348: astore          4
        //   350: aconst_null    
        //   351: astore          4
        //   353: aconst_null    
        //   354: astore          5
        //   356: aconst_null    
        //   357: astore          6
        //   359: aload           4
        //   361: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   364: aload           5
        //   366: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   369: aload           6
        //   371: invokestatic    cg.Code:(Lar;)V
        //   374: aconst_null    
        //   375: astore          4
        //   377: goto            333
        //   380: astore          6
        //   382: aconst_null    
        //   383: astore          7
        //   385: aconst_null    
        //   386: astore          5
        //   388: aconst_null    
        //   389: astore          4
        //   391: aload           7
        //   393: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   396: aload           5
        //   398: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //   401: aload           4
        //   403: invokestatic    cg.Code:(Lar;)V
        //   406: aload           6
        //   408: athrow         
        //   409: astore          6
        //   411: aconst_null    
        //   412: astore          7
        //   414: aconst_null    
        //   415: astore          5
        //   417: goto            391
        //   420: astore          6
        //   422: aconst_null    
        //   423: astore          7
        //   425: goto            391
        //   428: astore          6
        //   430: goto            391
        //   433: astore          5
        //   435: aconst_null    
        //   436: astore          7
        //   438: aconst_null    
        //   439: astore          5
        //   441: aload           4
        //   443: astore          6
        //   445: aload           7
        //   447: astore          4
        //   449: goto            359
        //   452: astore          6
        //   454: aconst_null    
        //   455: astore          7
        //   457: aload           4
        //   459: astore          6
        //   461: aload           7
        //   463: astore          4
        //   465: goto            359
        //   468: astore          6
        //   470: aload           4
        //   472: astore          6
        //   474: aload           7
        //   476: astore          4
        //   478: goto            359
        //   481: goto            290
        //   484: goto            223
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  47     62     348    359    Ljava/lang/Throwable;
        //  47     62     380    391    Any
        //  62     71     433    452    Ljava/lang/Throwable;
        //  62     71     409    420    Any
        //  71     82     452    468    Ljava/lang/Throwable;
        //  71     82     420    428    Any
        //  82     87     468    481    Ljava/lang/Throwable;
        //  82     87     428    433    Any
        //  89     103    468    481    Ljava/lang/Throwable;
        //  89     103    428    433    Any
        //  110    117    468    481    Ljava/lang/Throwable;
        //  110    117    428    433    Any
        //  140    152    468    481    Ljava/lang/Throwable;
        //  140    152    428    433    Any
        //  183    216    468    481    Ljava/lang/Throwable;
        //  183    216    428    433    Any
        //  223    237    468    481    Ljava/lang/Throwable;
        //  223    237    428    433    Any
        //  242    290    468    481    Ljava/lang/Throwable;
        //  242    290    428    433    Any
        //  290    296    468    481    Ljava/lang/Throwable;
        //  290    296    428    433    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 248, Size: 248
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
    
    public static String Code(final String s) {
        String s2;
        if (s == null) {
            s2 = null;
        }
        else {
            s2 = s;
            if (!s.startsWith("file://")) {
                String string = s;
                if (!s.startsWith("/")) {
                    string = "/" + s;
                }
                return "file://" + string;
            }
        }
        return s2;
    }
    
    private static boolean Code(final int n) {
        return n == 15 || n == 16;
    }
    
    public static int c(String substring) {
        if (substring.length() > 7 && substring.indexOf(".obml") == substring.length() - 5 - 2) {
            substring = substring.substring(substring.length() - 2);
            try {
                final int int1 = Integer.parseInt(substring);
                if (Code(int1)) {
                    return int1;
                }
            }
            catch (Exception ex) {}
        }
        return 0;
    }
    
    private String c() {
        String s;
        if (this.I != null && !this.I.equals("")) {
            s = this.I;
        }
        else {
            s = cg.Z(this.Z.J());
        }
        return this.I = Code(s);
    }
    
    public static int d(String substring) {
        if (c(substring) == 0) {
            return 0;
        }
        substring = substring.substring(0, substring.length() - 5 - 2);
        try {
            return Integer.parseInt(substring);
        }
        catch (Exception ex) {
            return 0;
        }
    }
    
    private String d() {
        at at = null;
        String code;
        if (this.Code != null && !"".equals(this.Code)) {
            code = this.Code;
        }
        else {
            code = null;
        }
        String z = null;
        Label_0051: {
            if (code != null) {
                z = code;
                if (!"".equals(code)) {
                    break Label_0051;
                }
            }
            z = this.Z.Z();
        }
        String string = null;
        Label_0117: {
            if (z != null) {
                string = z;
                if (!"".equals(z)) {
                    break Label_0117;
                }
            }
            final as z2 = this.Z;
            final at[] b = this.B();
            if (b.length > 0) {
                at = b[0];
            }
            string = z;
            if (at != null) {
                string = cg.Z(at.I()) + "OperaSavedPages/";
            }
        }
        if (string != null) {
            final String s = string;
            if (!"".equals(string)) {
                return this.Code = Code(s);
            }
        }
        final String s = "OperaSavedPages/";
        return this.Code = Code(s);
    }
    
    public final boolean B(final String s) {
        return this.Z.Code(s);
    }
    
    final byte[] B(final int n, final int n2) {
        final Object[] c = this.C(n, n2);
        if (c != null) {
            return (byte[])c[2];
        }
        return null;
    }
    
    final at[] B() {
        try {
            this.Z.Code();
            return this.a;
        }
        catch (Throwable t) {
            return this.a;
        }
    }
    
    public final long C(final String s) {
        return this.Z.I(s);
    }
    
    final int[] C() {
        return this.Z.B();
    }
    
    final int Code(final byte[] array, final String s) {
        return this.Z.Code(array, s);
    }
    
    public final ar Code(final String s, final boolean b, final int n) {
        return this.Z.Code(s, b, n);
    }
    
    public final String Code(final int n, final int n2) {
        int n3 = n2;
        if (n2 == -1) {
            n3 = 16;
        }
        return cg.Z(this.d()) + n + ".obml" + n3;
    }
    
    final void Code() {
        this.J(this.d());
    }
    
    public final void Code(final String s, final String s2) {
        final int length = this.a.length;
        if (this.C >= length) {
            final at[] a = new at[length + 5];
            for (int i = 0; i < this.C; ++i) {
                a[i] = this.a[i];
            }
            this.a = a;
        }
        this.a[this.C++] = new at(s, s2);
    }
    
    public final String I(final int n, final int n2) {
        int n3 = n2;
        if (n2 == -1) {
            n3 = 16;
        }
        return cg.Z(this.c()) + n + ".obml" + n3;
    }
    
    final void I() {
        this.J(this.c());
    }
    
    final byte[] I(final String s) {
        return this.Z.J(s);
    }
    
    public final String J() {
        return this.Z.I();
    }
    
    final String J(final int n, final int n2) {
        final Object[] c = this.C(n, n2);
        if (c != null) {
            return (String)c[1];
        }
        return null;
    }
    
    final boolean J(final String s) {
        return this.Z.C(s);
    }
    
    public final String Z() {
        final as z = this.Z;
        return null;
    }
    
    final String Z(final int n, final int n2) {
        final Object[] c = this.C(n, n2);
        if (c != null) {
            return (String)c[0];
        }
        return null;
    }
    
    final boolean Z(final String s) {
        return this.Z.B(s);
    }
    
    final at a() {
        final as z = this.Z;
        return null;
    }
    
    final String a(String z) {
        if (z != null && !"".equals(z)) {
            this.Code = z;
            return null;
        }
        this.Code = null;
        this.Code = this.d();
        if ((z = this.Z.Z()) == null) {
            z = "";
        }
        final StringBuilder sb = new StringBuilder();
        final as z2 = this.Z;
        return sb.append(z).toString();
    }
    
    public final at b(final String s) {
        for (int i = 0; i < this.C; ++i) {
            final at at = this.a[i];
            if (at.Code(s)) {
                return at;
            }
        }
        return null;
    }
    
    public final boolean b() {
        final as z = this.Z;
        return false;
    }
    
    final long e(final String s) {
        return this.Z.Z(s);
    }
}
