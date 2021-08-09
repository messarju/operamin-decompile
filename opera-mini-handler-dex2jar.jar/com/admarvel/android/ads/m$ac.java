// 
// Decompiled by Procyon v0.6-prerelease
// 

package com.admarvel.android.ads;

import java.lang.ref.WeakReference;

class m$ac implements Runnable
{
    private final WeakReference a;
    private final WeakReference b;
    
    public m$ac(final m m, final d d) {
        this.a = new WeakReference((T)m);
        this.b = new WeakReference((T)d);
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        com/admarvel/android/ads/m$ac.a:Ljava/lang/ref/WeakReference;
        //     4: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //     7: checkcast       Lcom/admarvel/android/ads/m;
        //    10: astore_1       
        //    11: aload_0        
        //    12: getfield        com/admarvel/android/ads/m$ac.b:Ljava/lang/ref/WeakReference;
        //    15: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    18: checkcast       Lcom/admarvel/android/ads/d;
        //    21: astore_2       
        //    22: aload_1        
        //    23: ifnull          167
        //    26: aload_2        
        //    27: ifnonnull       31
        //    30: return         
        //    31: aload_1        
        //    32: new             Ljava/lang/StringBuilder;
        //    35: dup            
        //    36: invokespecial   java/lang/StringBuilder.<init>:()V
        //    39: aload_1        
        //    40: getfield        com/admarvel/android/ads/m.s:Ljava/lang/String;
        //    43: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    46: ldc             "EMBEDDED_VIDEO"
        //    48: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    51: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    54: invokevirtual   com/admarvel/android/ads/m.findViewWithTag:(Ljava/lang/Object;)Landroid/view/View;
        //    57: checkcast       Lcom/admarvel/android/ads/a;
        //    60: astore_3       
        //    61: aload_2        
        //    62: ifnull          128
        //    65: aload_3        
        //    66: ifnull          128
        //    69: aload_1        
        //    70: getfield        com/admarvel/android/ads/m.I:Ljava/lang/String;
        //    73: ifnull          128
        //    76: aload_1        
        //    77: getfield        com/admarvel/android/ads/m.I:Ljava/lang/String;
        //    80: invokevirtual   java/lang/String.length:()I
        //    83: ifle            128
        //    86: aload_2        
        //    87: new             Ljava/lang/StringBuilder;
        //    90: dup            
        //    91: invokespecial   java/lang/StringBuilder.<init>:()V
        //    94: aload_1        
        //    95: getfield        com/admarvel/android/ads/m.I:Ljava/lang/String;
        //    98: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   101: ldc             "("
        //   103: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   106: aload_3        
        //   107: invokevirtual   com/admarvel/android/ads/a.h:()I
        //   110: i2f            
        //   111: ldc             1000.0
        //   113: fdiv           
        //   114: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
        //   117: ldc             ")"
        //   119: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   122: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   125: invokevirtual   com/admarvel/android/ads/d.e:(Ljava/lang/String;)V
        //   128: new             Landroid/os/Handler;
        //   131: dup            
        //   132: invokestatic    android/os/Looper.getMainLooper:()Landroid/os/Looper;
        //   135: invokespecial   android/os/Handler.<init>:(Landroid/os/Looper;)V
        //   138: aload_1        
        //   139: getfield        com/admarvel/android/ads/m.O:Lcom/admarvel/android/ads/m$ac;
        //   142: ldc2_w          500
        //   145: invokevirtual   android/os/Handler.postDelayed:(Ljava/lang/Runnable;J)Z
        //   148: pop            
        //   149: return         
        //   150: astore_1       
        //   151: aload_1        
        //   152: invokestatic    android/util/Log.getStackTraceString:(Ljava/lang/Throwable;)Ljava/lang/String;
        //   155: invokestatic    com/admarvel/android/util/Logging.log:(Ljava/lang/String;)V
        //   158: return         
        //   159: astore_2       
        //   160: aload_2        
        //   161: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   164: goto            128
        //   167: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      22     150    159    Ljava/lang/Exception;
        //  31     61     150    159    Ljava/lang/Exception;
        //  69     128    159    167    Ljava/lang/Exception;
        //  128    149    150    159    Ljava/lang/Exception;
        //  160    164    150    159    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0128:
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
}
