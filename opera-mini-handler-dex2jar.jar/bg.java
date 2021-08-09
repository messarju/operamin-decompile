// 
// Decompiled by Procyon v0.6-prerelease
// 

final class bg
{
    private static final byte[] Code;
    private static final byte[] I;
    private static final int[] Z;
    
    static {
        Code = new byte[256];
        I = new byte[366];
        Z = new int[366];
    }
    
    private static int Code(final int n, final int n2, final int n3, final int n4) {
        int n5 = n3;
        if (n == n2 - 1) {
            n5 = n3 - n4;
        }
        return Math.max(0, n5);
    }
    
    public static void Code() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2       
        //     2: new             Ljava/io/DataInputStream;
        //     5: dup            
        //     6: ldc             "/l"
        //     8: invokestatic    cg.B:(Ljava/lang/String;)Ljava/io/InputStream;
        //    11: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    14: astore_1       
        //    15: aload_1        
        //    16: getstatic       bg.Code:[B
        //    19: invokevirtual   java/io/DataInputStream.readFully:([B)V
        //    22: aload_1        
        //    23: getstatic       bg.I:[B
        //    26: invokevirtual   java/io/DataInputStream.readFully:([B)V
        //    29: iconst_0       
        //    30: istore_0       
        //    31: iload_0        
        //    32: sipush          366
        //    35: if_icmpge       57
        //    38: getstatic       bg.Z:[I
        //    41: iload_0        
        //    42: aload_1        
        //    43: invokevirtual   java/io/DataInputStream.readShort:()S
        //    46: ldc             65535
        //    48: iand           
        //    49: iastore        
        //    50: iload_0        
        //    51: iconst_1       
        //    52: iadd           
        //    53: istore_0       
        //    54: goto            31
        //    57: aload_1        
        //    58: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //    61: return         
        //    62: astore_1       
        //    63: aconst_null    
        //    64: astore_1       
        //    65: aload_1        
        //    66: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //    69: return         
        //    70: astore_3       
        //    71: aload_2        
        //    72: astore_1       
        //    73: aload_3        
        //    74: astore_2       
        //    75: aload_1        
        //    76: invokestatic    cg.Code:(Ljava/io/InputStream;)V
        //    79: aload_2        
        //    80: athrow         
        //    81: astore_2       
        //    82: goto            75
        //    85: astore_2       
        //    86: goto            65
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      15     62     65     Ljava/lang/Exception;
        //  2      15     70     75     Any
        //  15     29     85     89     Ljava/lang/Exception;
        //  15     29     81     85     Any
        //  38     50     85     89     Ljava/lang/Exception;
        //  38     50     81     85     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0031:
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
    
    public static void Code(final char[] array, final int n, final int n2, final int n3, final au au, final x x) {
        int i = 0;
        final int length = array.length;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        while (i < length) {
            final char c = array[i];
            char c2 = '\0';
            if (i + 1 < length) {
                c2 = array[i + 1];
            }
            int n8;
            if ((I(c) & 0x8) != 0x0 || (I(c2) & 0x4) != 0x0) {
                n8 = 0;
            }
            else if (I(c) == 0 && I(c2) == 0) {
                n8 = 0;
            }
            else {
                n8 = 1;
            }
            if (n8 != 0 || Code(c) || i == length - 1) {
                if (Code(c)) {
                    final int n9 = c;
                }
                else {
                    final int n9 = 0;
                }
                int n9;
                int n10;
                int n11;
                if (c == '\r' && c2 == '\n') {
                    n10 = i + 1;
                    n11 = 2;
                    n9 = -1;
                }
                else if (c == ' ' || Code(c)) {
                    final int n12 = 1;
                    n10 = i;
                    n11 = n12;
                }
                else {
                    final int n13 = 0;
                    n10 = i;
                    n11 = n13;
                }
                final int n14 = n10 - n4 + 1;
                final int n15 = n10 - n6 + 1;
                final int code = au.Code(array, n6, n15);
                int code2;
                if (n11 != 0) {
                    code2 = au.Code(array, n6, n15 - n11);
                }
                else {
                    code2 = code;
                }
                if (code2 + n7 > Code(n5, n2, n, n3)) {
                    int n16;
                    if (n4 != n6) {
                        n16 = n6 - n4;
                    }
                    else if (n15 - n11 != 1 && (!cg.B(c) || n15 - n11 != 2)) {
                        final int code3 = Code(n5, n2, n, n3);
                        int n17;
                        if (Code(array, n6)) {
                            n17 = 2;
                        }
                        else {
                            n17 = 1;
                        }
                        final int n18 = n17 + n6;
                        int n19 = n10 - n11;
                        int n20;
                        while (true) {
                            n20 = n19;
                            if (n19 <= n18) {
                                break;
                            }
                            int n21 = n19;
                            if (Code(array, n19 - 1)) {
                                n21 = n19 - 1;
                            }
                            n20 = n21;
                            if (au.Code(array, n6, n21 - n6) <= code3 - n7 || (n20 = n21) <= n18) {
                                break;
                            }
                            n19 = n21 - 1;
                        }
                        n16 = Math.max(n20, n18) - n4;
                    }
                    else {
                        n16 = n14;
                    }
                    if (Code(x, array, n4, n16, n5, n2, n3, 0)) {
                        break;
                    }
                    ++n5;
                    i = (n6 = n4 + n16);
                    n7 = 0;
                    n4 = i;
                }
                else if (Code(c) || n10 == length - 1) {
                    boolean b;
                    if (Code(c) && n4 + n14 == length) {
                        b = true;
                    }
                    else {
                        b = false;
                    }
                    int n22 = n11;
                    if (n3 == 0) {
                        n22 = n11;
                        if (x == null) {
                            n22 = 0;
                        }
                    }
                    int n23;
                    if (n10 == length - 1 && !b) {
                        n23 = 0;
                    }
                    else {
                        n23 = n3;
                    }
                    if (Code(x, array, n4, n14 - n22, n5, n2, n23, n9)) {
                        break;
                    }
                    ++n5;
                    i = n4 + n14;
                    if (b) {
                        Code(x, array, 0, 0, n5, n2, 0, 0);
                        break;
                    }
                    n6 = i;
                    n7 = 0;
                    n4 = i;
                }
                else {
                    n6 += n15;
                    n7 += code;
                    i = n10 + 1;
                }
            }
            else {
                ++i;
            }
        }
    }
    
    public static boolean Code(final char c) {
        return c == '\n' || c == '\r' || c == '\u000b' || c == '\u0085' || c == '\f' || c == '\u2028' || c == '\u2029';
    }
    
    private static boolean Code(final x x, final char[] array, final int n, final int n2, final int n3, int n4, final int n5, final int n6) {
        final boolean b = n4 > 0 && n3 >= n4 - 1;
        n4 = n2;
        if (b) {
            n4 = n2;
            if (n5 != 0 && (n4 = n2) > 0) {
                n4 = n2;
                if (array[n + n2 - 1] == ' ') {
                    n4 = n2 - 1;
                }
            }
        }
        if (x != null) {
            x.Code(array, n3, n, n + n4, n6);
            if (b && n5 != 0) {
                x.Code(n3);
            }
            return b;
        }
        u.Code(array, n, n + n4);
        return b;
    }
    
    private static boolean Code(final char[] array, final int n) {
        return n >= 0 && n < array.length && cg.B(array[n]);
    }
    
    private static int I(final char c) {
        int n = 0;
        if (c < '\u0100') {
            n = bg.Code[c];
        }
        else if (c < '\ufffd') {
            int length = bg.Z.length;
            int n2 = 0;
            int n3;
            while (true) {
                n3 = (length + n2) / 2;
                if (bg.Z[n3] <= c) {
                    if (bg.Z[n3 + 1] > c) {
                        break;
                    }
                    n2 = n3;
                }
                else {
                    length = n3;
                }
            }
            return bg.I[n3];
        }
        return n;
    }
}
