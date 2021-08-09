// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.egl.EGLDisplay;
import android.os.SystemClock;
import android.graphics.Rect;
import javax.microedition.khronos.egl.EGL10;
import java.util.Scanner;
import javax.microedition.khronos.opengles.GL10;
import android.os.Build$VERSION;
import android.os.Build;
import javax.microedition.khronos.egl.EGLContext;
import java.util.HashSet;
import android.opengl.GLSurfaceView$Renderer;

public class bc implements GLSurfaceView$Renderer
{
    private static final HashSet d;
    private EGLContext B;
    private int C;
    private boolean Code;
    private MiniView I;
    private k J;
    private boolean Z;
    private int a;
    private int b;
    private int c;
    private long e;
    
    static {
        d = new HashSet() {
            {
                this.add(new bd("Nexus One"));
                this.add(new bd("HTC Desire"));
                this.add(new bd("GT-S5830"));
                this.add(new bd("U20i"));
                this.add(new bd("HTC Gratia A6380"));
                this.add(new bd("Garmin-Asus A10"));
                this.add(new bd("U8230"));
                this.add(new bd("hp_h_sb1"));
                this.add(new bd("HTC Hero"));
                this.add(new bd("HTC Legend"));
                this.add(new bd("HTC Magic"));
                this.add(new bd("Hero", "HTC", null, null));
                this.add(new bd("Magic", "HTC", null, null));
                this.add(new bd("Liquid", "Acer", "4", null));
                this.add(new bd(null, null, null, "sapphire"));
            }
        };
    }
    
    public bc(final int n, final int n2, final MiniView i) {
        this.Code = false;
        this.Z = false;
        this.J = null;
        this.B = null;
        this.e = 0L;
        this.C = n;
        this.a = n2;
        this.b = n2;
        this.c = n;
        this.I = i;
    }
    
    static boolean C() {
        return bc.d.contains(new bd(Build.MODEL)) || bc.d.contains(new bd(Build.MODEL, Build.MANUFACTURER, Build$VERSION.SDK, null)) || bc.d.contains(new bd(Build.MODEL, Build.MANUFACTURER, null, null)) || bc.d.contains(new bd(Build.MODEL, null, Build$VERSION.SDK, null)) || bc.d.contains(new bd(null, null, null, Build.BOARD));
    }
    
    private static String Code(final GL10 p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: sipush          7937
        //     4: invokeinterface javax/microedition/khronos/opengles/GL10.glGetString:(I)Ljava/lang/String;
        //     9: ldc             "PowerVR"
        //    11: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //    14: ifge            19
        //    17: aconst_null    
        //    18: areturn        
        //    19: aload_0        
        //    20: sipush          7938
        //    23: invokeinterface javax/microedition/khronos/opengles/GL10.glGetString:(I)Ljava/lang/String;
        //    28: astore_0       
        //    29: aload_0        
        //    30: ldc             " build"
        //    32: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //    35: istore_1       
        //    36: iload_1        
        //    37: ifle            52
        //    40: aload_0        
        //    41: iload_1        
        //    42: bipush          6
        //    44: iadd           
        //    45: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //    48: astore_0       
        //    49: aload_0        
        //    50: areturn        
        //    51: astore_0       
        //    52: new             Ljava/io/BufferedReader;
        //    55: dup            
        //    56: new             Ljava/io/FileReader;
        //    59: dup            
        //    60: ldc             "/proc/pvr/version"
        //    62: invokespecial   java/io/FileReader.<init>:(Ljava/lang/String;)V
        //    65: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    68: astore_3       
        //    69: aload_3        
        //    70: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //    73: astore_0       
        //    74: aload_0        
        //    75: ifnull          127
        //    78: aload_0        
        //    79: ldc             " "
        //    81: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //    84: istore_1       
        //    85: iload_1        
        //    86: ifle            127
        //    89: aload_0        
        //    90: iload_1        
        //    91: iconst_1       
        //    92: iadd           
        //    93: invokevirtual   java/lang/String.substring:(I)Ljava/lang/String;
        //    96: astore_2       
        //    97: aload_2        
        //    98: ldc             " "
        //   100: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   103: istore_1       
        //   104: aload_2        
        //   105: astore_0       
        //   106: iload_1        
        //   107: ifle            117
        //   110: aload_2        
        //   111: iconst_0       
        //   112: iload_1        
        //   113: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   116: astore_0       
        //   117: aload_3        
        //   118: invokevirtual   java/io/BufferedReader.close:()V
        //   121: aload_0        
        //   122: areturn        
        //   123: astore_0       
        //   124: ldc             ""
        //   126: areturn        
        //   127: aload_3        
        //   128: invokevirtual   java/io/BufferedReader.close:()V
        //   131: goto            124
        //   134: astore_0       
        //   135: aload_3        
        //   136: invokevirtual   java/io/BufferedReader.close:()V
        //   139: aload_0        
        //   140: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  19     36     51     52     Ljava/lang/Throwable;
        //  40     49     51     52     Ljava/lang/Throwable;
        //  52     69     123    124    Ljava/lang/Throwable;
        //  69     74     134    141    Any
        //  78     85     134    141    Any
        //  89     104    134    141    Any
        //  110    117    134    141    Any
        //  117    121    123    124    Ljava/lang/Throwable;
        //  127    131    123    124    Ljava/lang/Throwable;
        //  135    141    123    124    Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0117:
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
    
    private static boolean I(final GL10 gl10) {
        if (x.ak < 11) {
            final String code = Code(gl10);
            if (code != null) {
                try {
                    final int[] array2;
                    final int[] array = array2 = new int[4];
                    array2[array2[0] = 1] = 5;
                    array2[2] = 15;
                    array2[3] = 3196;
                    final Scanner useDelimiter = new Scanner(code).useDelimiter("[^0-9]");
                    for (int i = 0; i < 4; ++i) {
                        if (!useDelimiter.hasNextInt()) {
                            return true;
                        }
                        final int nextInt = useDelimiter.nextInt();
                        if (nextInt > array[i]) {
                            return false;
                        }
                        if (nextInt < array[i]) {
                            return true;
                        }
                    }
                    return true;
                }
                catch (Throwable t) {}
                return true;
            }
        }
        return false;
    }
    
    private static EGLContext a() {
        return ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
    }
    
    final boolean B() {
        return this.Z;
    }
    
    public final void Code() {
        this.Code = true;
    }
    
    public final void Code(final int c, final int b) {
        this.b = b;
        this.c = c;
    }
    
    public final void I() {
        synchronized (this) {
            if (this.J != null) {
                this.Z = false;
                this.J.f();
            }
        }
    }
    
    public final void J() {
        synchronized (this) {
            if (this.J != null && this.B.equals(a())) {
                this.J.c();
            }
        }
    }
    
    public final void Z() {
        synchronized (this) {
            if (this.J != null) {
                this.J.g();
                this.J = null;
            }
        }
    }
    
    public void onDrawFrame(final GL10 gl10) {
    Label_0168_Outer:
        while (true) {
            while (true) {
            Label_0293:
                while (true) {
                    int[] array = null;
                    int[] array2 = null;
                    Label_0274: {
                        synchronized (this) {
                            if (this.J != null) {
                                if (this.a != this.b) {
                                    final EGLContext b = this.B;
                                    final EGL10 egl10 = (EGL10)EGLContext.getEGL();
                                    final EGLDisplay eglGetCurrentDisplay = egl10.eglGetCurrentDisplay();
                                    array = new int[] { 0 };
                                    array2 = new int[] { 0 };
                                    final EGLSurface eglGetCurrentSurface = egl10.eglGetCurrentSurface(12378);
                                    if (eglGetCurrentDisplay == null || eglGetCurrentSurface == null) {
                                        break Label_0274;
                                    }
                                    egl10.eglQuerySurface(eglGetCurrentDisplay, eglGetCurrentSurface, 12374, array);
                                    egl10.eglQuerySurface(eglGetCurrentDisplay, eglGetCurrentSurface, 12375, array2);
                                    final Rect rect = new Rect(0, 0, array2[0], array[0]);
                                    if (this.a == rect.bottom) {
                                        break Label_0293;
                                    }
                                    this.J.J(rect.right, rect.bottom);
                                    this.a = rect.bottom;
                                    this.C = rect.right;
                                }
                                this.Z = true;
                                long e;
                                final long n = e = SystemClock.uptimeMillis();
                                if (this.e != 0L) {
                                    final long n2 = n - this.e;
                                    e = n;
                                    if (n2 < 16L) {
                                        e = n;
                                        if (n2 >= 0L) {
                                            SystemClock.sleep(16L - n2);
                                            e = SystemClock.uptimeMillis();
                                        }
                                    }
                                }
                                this.e = e;
                                if (this.J.a()) {
                                    Browser.Code.Code(this.J);
                                    this.J.b();
                                }
                            }
                            return;
                        }
                    }
                    array[0] = this.b;
                    array2[0] = this.c;
                    continue Label_0168_Outer;
                }
                this.I.a();
                continue;
            }
        }
    }
    
    public void onSurfaceChanged(final GL10 gl10, final int n, final int n2) {
        synchronized (this) {
            if (this.J != null) {
                this.J.J(n, n2);
                this.I.I();
            }
        }
    }
    
    public void onSurfaceCreated(final GL10 gl10, final EGLConfig eglConfig) {
    Label_0172_Outer:
        while (true) {
            final int n = 1;
            while (true) {
                Label_0185: {
                    while (true) {
                        Label_0169: {
                            synchronized (this) {
                                int n2;
                                if (gl10.glGetString(7937).indexOf("PixelFlinger") >= 0) {
                                    n2 = n;
                                }
                                else {
                                    n2 = n;
                                    if (!I(gl10)) {
                                        final String glGetString = gl10.glGetString(7937);
                                        if (glGetString == null) {
                                            break Label_0169;
                                        }
                                        if (glGetString.indexOf("FIMG") < 0) {
                                            break Label_0169;
                                        }
                                        break Label_0185;
                                    }
                                }
                                if (n2 != 0) {
                                    Browser.Z.runOnUiThread((Runnable)new be(this));
                                }
                                else {
                                    (this.J = k.I(this.C, this.a)).e();
                                    this.J.Code(false);
                                    this.B = a();
                                    if (this.Code) {
                                        if (Browser.Code.C) {
                                            final a code = Browser.Code;
                                            com.opera.mini.android.a.I.h();
                                            final a code2 = Browser.Code;
                                            com.opera.mini.android.a.I.y();
                                        }
                                        this.Code = false;
                                    }
                                }
                                return;
                            }
                        }
                        final int n3 = 0;
                        int n2 = n;
                        if (n3 == 0) {
                            n2 = 0;
                            continue Label_0172_Outer;
                        }
                        continue Label_0172_Outer;
                    }
                }
                final int n3 = 1;
                continue;
            }
        }
    }
}
