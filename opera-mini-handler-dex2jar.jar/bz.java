import java.io.InputStream;
import java.io.DataInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public final class bz
{
    private static az A;
    private static boolean B;
    private static int C;
    static int Code;
    private static boolean D;
    private static int E;
    private static int F;
    private static int G;
    private static final Object I;
    private static boolean J;
    private static bn Z;
    private static int a;
    private static az b;
    private static az c;
    private static int d;
    private static int e;
    private static int f;
    private static String g;
    private static int h;
    private static int i;
    private static int j;
    private static int k;
    private static au l;
    private static int m;
    private static az n;
    private static az o;
    private static int p;
    private static int q;
    private static int r;
    private static String s;
    private static String t;
    private static int u;
    private static int v;
    private static au w;
    private static az x;
    private static int y;
    private static int z;
    
    static {
        I = new Object();
    }
    
    static boolean B() {
        synchronized (bz.I) {
            return bz.J;
        }
    }
    
    private static void C() {
        if (bz.C == bz.Z.J() && bz.a == bz.Z.B()) {
            return;
        }
        bz.C = bz.Z.J();
        bz.k = (bz.p = (bz.a = bz.Z.B()) * 60 / 100) - bz.G - bz.l.Code();
    }
    
    public static void Code() {
        synchronized (bz.I) {
            bz.B = false;
        }
    }
    
    static void Code(final int p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: astore_1       
        //     4: aload_1        
        //     5: monitorenter   
        //     6: getstatic       bz.J:Z
        //     9: ifeq            64
        //    12: getstatic       bz.B:Z
        //    15: ifne            64
        //    18: invokestatic    bz.C:()V
        //    21: getstatic       bz.i:I
        //    24: getstatic       bz.j:I
        //    27: getstatic       bz.i:I
        //    30: isub           
        //    31: iload_0        
        //    32: imul           
        //    33: bipush          100
        //    35: idiv           
        //    36: iadd           
        //    37: sipush          1000
        //    40: invokestatic    java/lang/Math.min:(II)I
        //    43: putstatic       bz.m:I
        //    46: getstatic       bz.Z:Lbn;
        //    49: iconst_0       
        //    50: getstatic       bz.p:I
        //    53: getstatic       bz.C:I
        //    56: getstatic       bz.r:I
        //    59: invokeinterface bn.Code:(IIII)V
        //    64: aload_1        
        //    65: monitorexit    
        //    66: return         
        //    67: astore_2       
        //    68: aload_1        
        //    69: monitorexit    
        //    70: aload_2        
        //    71: athrow         
        //    72: astore_2       
        //    73: goto            64
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                            
        //  -----  -----  -----  -----  --------------------------------
        //  6      46     67     72     Any
        //  46     64     72     76     Ljava/lang/NullPointerException;
        //  46     64     67     72     Any
        //  64     66     67     72     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0064:
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
    
    static void Code(final int n, final int n2) {
        synchronized (bz.I) {
            bz.i = n * 10;
            bz.j = n2 * 10;
            Code(0);
        }
    }
    
    static void Code(final int code, final byte[] array) {
        bs.Code.Z("splash");
        final byte[] array2 = new byte[4];
        q.Z(code, array2, 0);
        try {
            bs.Code.Code("splash", array2);
            bz.Code = code;
            bs.Code.Code("splash", array);
        }
        catch (IOException ex) {}
    }
    
    static void Code(final aw aw) {
    Label_0352_Outer:
        while (true) {
            while (true) {
                int n = 0;
                int f = 0;
            Label_0391:
                while (true) {
                    synchronized (bz.I) {
                        if (!bz.J || bz.B) {
                            return;
                        }
                        aw.Z(aw.Code(), aw.I(), aw.Z(), aw.J(), 16777215);
                        C();
                        final az c = bz.c;
                        n = bz.e;
                        f = bz.f;
                        final int n2 = (bz.C - n) / 2;
                        final int n3 = bz.k - bz.G * 2 - f;
                        final int n4 = bz.a * 5 / 100;
                        if (n3 < n4) {
                            final int n5 = n4 - n3;
                            final int n6 = (int)(n - (f - n5) / (double)f * n);
                            aw.Code(bz.c, n6 / 2 + n2, n4, n - n6, f - n5, false);
                        }
                        else {
                            aw.Code(bz.c, n2, n3);
                        }
                        if (bz.g != null) {
                            n = (bz.C - bz.h) / 2;
                            aw.Code(bz.g, n, bz.k, bz.l, 0);
                        }
                        n = (bz.C - bz.q) / 2;
                        Code(aw, bz.n, n, bz.p, bz.q, bz.r);
                        Code(aw, bz.o, n, bz.p, bz.q * bz.m / 1000, bz.r);
                        n = bz.p;
                        f = bz.r + n;
                        if (bz.z * 2 + f + bz.G * 4 > 0.9 * bz.a) {
                            n = (bz.a - f - bz.z * 2) / 4;
                            f += n * 2;
                            if (bz.b != null && bz.d > 1) {
                                aw.Code(bz.b, (bz.C - bz.d) / 2, f);
                                monitorexit(bz.I);
                                bx.Code(aw);
                                return;
                            }
                            break Label_0391;
                        }
                    }
                    n = bz.G * 2;
                    continue Label_0352_Outer;
                }
                final int n7 = bz.C * 90 / 100 - bz.y - bz.G;
                n += bz.z + f;
                final int n8 = bz.y + bz.G + Math.min(n7, bz.u);
                final int n9 = bz.y + bz.G + Math.min(n7, bz.v);
                final int max = Math.max(n8, n9);
                final int n10 = (bz.z - bz.w.Code()) / 2;
                final int n11 = (bz.C - max) / 2;
                if (!cg.Code(bz.s.charAt(0))) {
                    final int n12 = bz.y + n11 + bz.G;
                    aw.Code(bz.x, n11, f);
                    aw.Code(bz.x, n11, n);
                    Code(aw, bz.w, bz.s, n12, f + n10, bz.u, n7, false);
                    Code(aw, bz.w, bz.t, n12, n + n10, bz.v, n7, false);
                    continue;
                }
                final int n13 = bz.C - n11;
                aw.Code(bz.x, n13 - bz.y, f);
                aw.Code(bz.x, n13 - bz.y, n);
                Code(aw, bz.w, bz.s, n13 - n8, f + n10, bz.u, n7, true);
                Code(aw, bz.w, bz.t, n13 - n9, n + n10, bz.v, n7, true);
                continue;
            }
        }
    }
    
    private static void Code(final aw aw, final au au, final String s, int n, final int n2, int n3, final int n4, final boolean d) {
        if (n3 < n4) {
            aw.Code(s, n, n2, au, 0);
            return;
        }
        final int code = aw.Code();
        final int i = aw.I();
        final int z = aw.Z();
        final int j = aw.J();
        final int code2 = bz.w.Code();
        final int e = bz.G * 4;
        final int code3 = bz.w.Code();
        if (bz.A == null || bz.E != e || bz.F != code3 || bz.D != d) {
            final int[] array = new int[e];
            final int[] array2 = new int[e * code3];
            if (d) {
                for (int k = 0; k < e; ++k) {
                    array[e - k - 1] = (k * 255 / e << 24 | 0xFFFFFF);
                }
            }
            else {
                for (int l = 0; l < e; ++l) {
                    array[l] = (l * 255 / e << 24 | 0xFFFFFF);
                }
            }
            for (int n5 = 0; n5 < code3; ++n5) {
                System.arraycopy(array, 0, array2, n5 * e, e);
            }
            bz.A = bz.Z.q().Code(array2, e, code3, true, false);
            bz.E = e;
            bz.F = code3;
            bz.D = d;
        }
        aw.I(n, n2 + code2 - bz.w.J(), n4, code2);
        if (d) {
            n3 = n - (n3 - n4);
        }
        else {
            n3 = n;
        }
        aw.Code(s, n3, n2, au, 0);
        final az a = bz.A;
        if (!d) {
            n = n + n4 - bz.E;
        }
        aw.Code(a, n, n2);
        aw.Code(code, i, z, j);
    }
    
    private static void Code(final aw aw, final az az, final int n, int n2, final int n3, int n4) {
        if (n4 > az.Z()) {
            n2 += (n4 - az.Z()) / 2;
        }
        n4 = az.I();
        n4 = Math.min(az.I() / 3, Math.min(n3 / 2, n4));
        aw.Code(az, 0, 0, n4, az.Z(), n, n2);
        aw.Code(az, az.I() - n4, 0, n4, az.Z(), n + n3 - n4, n2);
        aw.Code(az, n4, 0, az.I() - n4 * 2, az.Z(), n + n4, n2, n3 - n4 * 2, az.Z());
    }
    
    static void Code(final String g) {
        synchronized (bz.I) {
            if (bz.J && !bz.B) {
                C();
                final char[] charArray = g.toCharArray();
                final int c = new x(charArray, 0, 0, 0, null, bz.l).C(0);
                if ((c & 0xE) != 0x0) {
                    bz.g = new String(charArray, 0, x.Code(charArray, c));
                }
                else {
                    bz.g = g;
                }
                bz.h = bz.l.Code(bz.g);
                bz.Z.Code(0, bz.k, bz.C, bz.l.Code());
            }
        }
    }
    
    public static void Code(final String s, final String t) {
        bz.s = s;
        bz.t = t;
        C();
        if (Math.max(bz.w.Code(bz.s), bz.w.Code(bz.t)) > bz.C - bz.y - bz.G * 5) {
            bz.w = bz.Z.s().Code(64, 0);
        }
        bz.u = bz.w.Code(bz.s);
        bz.v = bz.w.Code(bz.t);
    }
    
    public static void I() {
        synchronized (bz.I) {
            bz.B = true;
        }
    }
    
    static void J() {
        synchronized (bz.I) {
            bz.J = false;
            bz.b = null;
            bz.c = null;
            bz.n = null;
            bz.o = null;
            bz.x = null;
            bz.A = null;
        }
    }
    
    static void Z() {
        while (true) {
            final u i = u.I;
            bz.Z = u.e();
        Label_0107_Outer:
            while (true) {
            Label_0163_Outer:
                while (true) {
                Label_0321_Outer:
                    while (true) {
                        Label_0505: {
                            try {
                                if (bs.Code.Code("splash")) {
                                    bz.Code = q.J(bs.Code.Code("splash", 1), 0);
                                    final DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bs.Code.Code("splash", 2)));
                                    if (dataInputStream.readInt() == 1397764400) {
                                        final short short1 = dataInputStream.readShort();
                                        String s = "";
                                        final int n = 0;
                                        if (n < short1) {
                                            final String utf = dataInputStream.readUTF();
                                            final short short2 = dataInputStream.readShort();
                                            final int n2 = 0;
                                            if (n2 >= short2) {
                                                break Label_0321_Outer;
                                            }
                                            final String utf2 = dataInputStream.readUTF();
                                            final String utf3 = dataInputStream.readUTF();
                                            if (utf.equals("brand-logo") && utf2.equals("bitmap")) {
                                                s = utf3;
                                                break Label_0321_Outer;
                                            }
                                            break Label_0321_Outer;
                                        }
                                        else {
                                            final short short3 = dataInputStream.readShort();
                                            final int n3 = 0;
                                            if (n3 < short3) {
                                                final String utf4 = dataInputStream.readUTF();
                                                final int int1 = dataInputStream.readInt();
                                                if (utf4.equals(s)) {
                                                    final byte[] array = new byte[int1];
                                                    dataInputStream.readFully(array);
                                                    bz.b = bz.Z.q().Code(array, array.length, true);
                                                    break Label_0505;
                                                }
                                                cg.Code((InputStream)dataInputStream, int1);
                                                break Label_0505;
                                            }
                                        }
                                    }
                                }
                            }
                            catch (Throwable t) {}
                            while (true) {
                                try {
                                    bz.c = bz.Z.al();
                                    bz.n = bz.Z.am();
                                    bz.o = bz.Z.an();
                                    bz.x = bz.Z.ao();
                                    final String l = u.I.l();
                                    if ("hvga".equals(l)) {
                                        bz.G = 9;
                                    }
                                    else if ("vga".equals(l)) {
                                        bz.G = 12;
                                    }
                                    else if ("svga".equals(l) || "qxga".equals(l)) {
                                        bz.G = 18;
                                    }
                                    else {
                                        bz.G = 6;
                                    }
                                    if (bz.b == null) {
                                        bz.b = cg.Code(32770, true);
                                    }
                                    bz.l = bz.Z.s().Code(64, 0);
                                    bz.w = bz.Z.s().Code(64, 16);
                                    bz.f = bz.c.Z();
                                    bz.e = bz.c.I();
                                    if (bz.b != null) {
                                        bz.d = bz.b.I();
                                    }
                                    bz.r = bz.n.Z();
                                    bz.q = bz.n.I();
                                    bz.z = bz.x.Z();
                                    bz.y = bz.x.I();
                                    bz.J = true;
                                    return;
                                    final int n2 = n2 + 1;
                                    continue Label_0163_Outer;
                                    final int n = n + 1;
                                    continue Label_0107_Outer;
                                    final int n3 = n3 + 1;
                                    continue Label_0321_Outer;
                                }
                                catch (Throwable t2) {
                                    continue;
                                }
                                break;
                            }
                        }
                        break;
                    }
                    break;
                }
                break;
            }
        }
    }
}
