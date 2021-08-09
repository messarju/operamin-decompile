// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.opera.mini.android;

import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;

final class bg implements Runnable
{
    private /* synthetic */ bf Code;
    
    private bg(final bf code) {
        this.Code = code;
    }
    
    private static Bitmap Code(final int n, final int n2) {
        int n3 = 0;
        while (true) {
            try {
                final Bitmap bitmap = Bitmap.createBitmap(n, n2, Bitmap$Config.RGB_565);
                if (bitmap != null) {
                    return bitmap;
                }
            }
            catch (OutOfMemoryError outOfMemoryError) {
                if (n3 >= u.b) {
                    throw outOfMemoryError;
                }
            }
            u.I.h();
            u.I.Code(n3 > 0);
            u.I.i();
            ++n3;
        }
    }
    
    @Override
    public final void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: invokevirtual   cd.I:()V
        //     6: getstatic       u.Code:Lbn;
        //     9: invokeinterface bn.p:()Z
        //    14: ifne            43
        //    17: aload_0        
        //    18: monitorenter   
        //    19: invokestatic    com/opera/mini/android/bf.c:()Z
        //    22: ifne            62
        //    25: aload_0        
        //    26: iconst_0       
        //    27: invokestatic    cg.Code:(Ljava/lang/Object;I)V
        //    30: getstatic       u.Code:Lbn;
        //    33: invokeinterface bn.p:()Z
        //    38: ifeq            62
        //    41: aload_0        
        //    42: monitorexit    
        //    43: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //    46: ifnull          55
        //    49: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //    52: invokevirtual   com/opera/mini/android/k.g:()V
        //    55: invokestatic    com/opera/mini/android/bf.B:()Lcd;
        //    58: invokevirtual   cd.Z:()V
        //    61: return         
        //    62: invokestatic    com/opera/mini/android/bf.d:()Z
        //    65: pop            
        //    66: invokestatic    com/opera/mini/android/bf.e:()I
        //    69: istore_1       
        //    70: invokestatic    com/opera/mini/android/bf.f:()I
        //    73: istore_2       
        //    74: invokestatic    com/opera/mini/android/bf.g:()I
        //    77: istore_3       
        //    78: invokestatic    com/opera/mini/android/bf.h:()I
        //    81: istore          4
        //    83: iconst_0       
        //    84: invokestatic    com/opera/mini/android/bf.Code:(I)I
        //    87: pop            
        //    88: aload_0        
        //    89: monitorexit    
        //    90: aload_0        
        //    91: getfield        com/opera/mini/android/bg.Code:Lcom/opera/mini/android/bf;
        //    94: invokevirtual   com/opera/mini/android/bf.getWidth:()I
        //    97: istore          5
        //    99: aload_0        
        //   100: getfield        com/opera/mini/android/bg.Code:Lcom/opera/mini/android/bf;
        //   103: invokevirtual   com/opera/mini/android/bf.getHeight:()I
        //   106: istore          6
        //   108: iload           5
        //   110: ifle            6
        //   113: iload           6
        //   115: ifle            6
        //   118: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   121: ifnull          146
        //   124: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   127: invokevirtual   android/graphics/Bitmap.getWidth:()I
        //   130: iload           5
        //   132: if_icmpne       146
        //   135: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   138: invokevirtual   android/graphics/Bitmap.getHeight:()I
        //   141: iload           6
        //   143: if_icmpeq       209
        //   146: aconst_null    
        //   147: invokestatic    com/opera/mini/android/bf.Code:(Lcom/opera/mini/android/k;)Lcom/opera/mini/android/k;
        //   150: pop            
        //   151: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   154: ifnull          168
        //   157: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   160: invokevirtual   android/graphics/Bitmap.recycle:()V
        //   163: aconst_null    
        //   164: invokestatic    com/opera/mini/android/bf.Code:(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
        //   167: pop            
        //   168: iload           5
        //   170: iload           6
        //   172: invokestatic    com/opera/mini/android/bg.Code:(II)Landroid/graphics/Bitmap;
        //   175: invokestatic    com/opera/mini/android/bf.Code:(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
        //   178: pop            
        //   179: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   182: ifnull          55
        //   185: aload_0        
        //   186: monitorenter   
        //   187: invokestatic    com/opera/mini/android/bf.j:()I
        //   190: pop            
        //   191: invokestatic    com/opera/mini/android/bf.k:()I
        //   194: pop            
        //   195: iload           5
        //   197: invokestatic    com/opera/mini/android/bf.Code:(I)I
        //   200: pop            
        //   201: iload           6
        //   203: invokestatic    com/opera/mini/android/bf.I:(I)I
        //   206: pop            
        //   207: aload_0        
        //   208: monitorexit    
        //   209: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //   212: ifnonnull       242
        //   215: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   218: invokestatic    com/opera/mini/android/k.I:(Landroid/graphics/Bitmap;)Lcom/opera/mini/android/k;
        //   221: invokestatic    com/opera/mini/android/bf.Code:(Lcom/opera/mini/android/k;)Lcom/opera/mini/android/k;
        //   224: pop            
        //   225: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //   228: iconst_1       
        //   229: invokevirtual   com/opera/mini/android/k.Code:(Z)V
        //   232: aload_0        
        //   233: getfield        com/opera/mini/android/bg.Code:Lcom/opera/mini/android/bf;
        //   236: invokestatic    com/opera/mini/android/bf.Code:(Lcom/opera/mini/android/bf;)Lcom/opera/mini/android/MiniView;
        //   239: invokevirtual   com/opera/mini/android/MiniView.I:()V
        //   242: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //   245: invokevirtual   com/opera/mini/android/k.a:()Z
        //   248: ifeq            290
        //   251: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //   254: iload_1        
        //   255: iload_2        
        //   256: iload_3        
        //   257: iload           4
        //   259: invokevirtual   com/opera/mini/android/k.Code:(IIII)V
        //   262: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //   265: iload_1        
        //   266: iload_2        
        //   267: iload_3        
        //   268: iload           4
        //   270: ldc             16777215
        //   272: invokevirtual   com/opera/mini/android/k.Z:(IIIII)V
        //   275: getstatic       com/opera/mini/android/Browser.Code:Lcom/opera/mini/android/a;
        //   278: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //   281: invokevirtual   com/opera/mini/android/a.Code:(Law;)V
        //   284: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //   287: invokevirtual   com/opera/mini/android/k.b:()V
        //   290: invokestatic    com/opera/mini/android/bf.l:()Lcom/opera/mini/android/k;
        //   293: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   296: invokevirtual   com/opera/mini/android/k.Code:(Landroid/graphics/Bitmap;)V
        //   299: aload_0        
        //   300: getfield        com/opera/mini/android/bg.Code:Lcom/opera/mini/android/bf;
        //   303: invokestatic    com/opera/mini/android/bf.I:(Lcom/opera/mini/android/bf;)Landroid/view/SurfaceHolder;
        //   306: invokeinterface android/view/SurfaceHolder.lockCanvas:()Landroid/graphics/Canvas;
        //   311: astore          7
        //   313: aload           7
        //   315: ifnull          6
        //   318: aload           7
        //   320: invokestatic    com/opera/mini/android/bf.i:()Landroid/graphics/Bitmap;
        //   323: fconst_0       
        //   324: fconst_0       
        //   325: aconst_null    
        //   326: invokevirtual   android/graphics/Canvas.drawBitmap:(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
        //   329: aload_0        
        //   330: getfield        com/opera/mini/android/bg.Code:Lcom/opera/mini/android/bf;
        //   333: invokestatic    com/opera/mini/android/bf.I:(Lcom/opera/mini/android/bf;)Landroid/view/SurfaceHolder;
        //   336: aload           7
        //   338: invokeinterface android/view/SurfaceHolder.unlockCanvasAndPost:(Landroid/graphics/Canvas;)V
        //   343: goto            6
        //   346: astore          7
        //   348: invokestatic    com/opera/mini/android/bf.B:()Lcd;
        //   351: invokevirtual   cd.Z:()V
        //   354: aload           7
        //   356: athrow         
        //   357: astore          7
        //   359: aload_0        
        //   360: monitorexit    
        //   361: aload           7
        //   363: athrow         
        //   364: astore          7
        //   366: aload_0        
        //   367: monitorexit    
        //   368: aload           7
        //   370: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  6      19     346    357    Any
        //  19     43     357    364    Any
        //  43     55     346    357    Any
        //  62     90     357    364    Any
        //  90     108    346    357    Any
        //  118    146    346    357    Any
        //  146    168    346    357    Any
        //  168    187    346    357    Any
        //  187    209    364    371    Any
        //  209    242    346    357    Any
        //  242    290    346    357    Any
        //  290    313    346    357    Any
        //  318    343    346    357    Any
        //  359    364    346    357    Any
        //  366    371    346    357    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 163, Size: 163
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
